<template>
	<view>
		<u-navbar :title="title" @rightClick="showSearch = !showSearch" style="color: #fff6df;" :bgColor="color.theme">
			<view slot="left"></view>
			<u-icon slot="right" name="search" size="25" bold color="#fff6df"></u-icon>
		</u-navbar>
		<!-- 搜索表单 -->
		<haya-search-form style="margin-top: 50px;" v-show="showSearch" @submit="submit"></haya-search-form>
		<!-- 展示部分 -->
		<view v-show="!showSearch" style="margin-top: 50px; padding-bottom: 10px;" class="u-page">
			<u-empty v-if="list.length === 0 && !loading" mode="list"
				icon="http://cdn.uviewui.com/uview/empty/list.png">
			</u-empty>
			<view v-else class="u-demo-block">
				<view>
					<!-- 内容组件 -->
					<haya-connents-item v-for="(item,index) in list" :item="item"
						:bgColor="index % 2 === 0 ? color.bgColor : color.bgDark">
					</haya-connents-item>
				</view>
				<u-loadmore :status="pageStatus" @loadmore="loadMore" />
			</view>
			<u-back-top ref="backTop" :scroll-top="scrollTop"></u-back-top>
		</view>
	</view>
</template>

<script>
	import {
		list
	} from '@/api/common.js'

	import HayaSearchForm from '../components/haya-search-form/haya-search-form.vue'
	import HayaConnentsItem from '../components/haya-comments-item/haya-comments-item.vue'

	import color from '../../lib/color.js'

	export default {
		name: 'index',
		components: {
			HayaSearchForm,
			HayaConnentsItem
		},
		data() {
			return {
				color: color,

				showSearch: true,
				// 标题
				title: 'NGA专楼自助查询',
				loading: false,
				page: {
					pageNum: 1,
					pageSize: 20,
					hasMore: true
				},
				form: {},
				list: [],

				scrollTop: 0
			}
		},
		computed:{
			pageStatus(){
				if(this.loading){
					return 'loading'
				}else if(this.page.hasMore){
					return 'loadmore'
				}else {
					return 'nomore'
				}
			}
		},
		onPageScroll(e) {
			this.scrollTop = e.scrollTop;
		},
		methods: {
			submit(form) {
				this.form = form;
				this.page = {
					pageNum: 1,
					pageSize: 20,
					hasMore: true
				}
				this.showSearch = false
				this.load().then((data) => {
					this.list = data
					this.$refs.backTop.backToTop()
					
					// 处理分页数据
					if(data.length > 0){
						this.page.lastStartDate = data[data.length - 1].date
						if(data.length === this.form.limit){
							this.page.hasMore = true
						}
					}
				}).catch(e => {
					this.form = {}
					this.list = []
					console.log(e)
				})
			},
			loadMore(){
				this.page.pageNum += 1
				this.load().then(data => {
					this.list = this.list.concat(data)
					// 处理分页数据
					if(data.length > 0){
						if(data.length < this.page.pageSize){
							this.page.hasMore = false
						}
					}
				}).catch(e => {
					console.log(e)
				})
			},
			load(){
				return new Promise((res, rej) => {
					this.loading = true
					let form = JSON.parse(JSON.stringify(this.form))
					form = Object.assign({}, form, this.page)
					list(form).then(data => {
						this.loading = false
						res(data)
					}).catch(e => {
						this.loading = false
						ref(e)
					})
				})
			},
			

		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>

<style lang="scss">
	.album {
		@include flex;
		align-items: flex-start;

		&__avatar {
			background-color: $u-bg-color;
			padding: 5px;
			border-radius: 3px;
		}

		&__content {
			margin-left: 10px;
			flex: 1;
		}
	}
</style>
