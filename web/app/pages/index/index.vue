<template>
	<view>
		<u-navbar :title="title" @rightClick="showSearch = !showSearch" style="color: #fff6df;" :bgColor="color.theme">
			<view slot="left"></view>
			<u-icon slot="right" name="search" size="25" bold color="#fff6df"></u-icon>
		</u-navbar>
		<!-- 搜索表单 -->
		<haya-search-form style="margin-top: 50px;" v-show="showSearch" @submit="submit"></haya-search-form>

		<u-loading-page style="z-index: 999999;" :loading="loading"></u-loading-page>
		<!-- 展示部分 -->
		<view v-show="!showSearch" class="u-page">
			<u-empty style="margin-top: 50px;" v-show="list.length === 0" mode="list"
				icon="http://cdn.uviewui.com/uview/empty/list.png">
			</u-empty>
			<view style="margin-top: 50px;" class="u-demo-block">
				<view class="u-page u-demo-block__content">
					<!-- 内容组件 -->
					<haya-connents-item v-for="(item,index) in list" :item="item"
						:bgColor="index % 2 === 0 ? color.bgColor : color.bgDark">
					</haya-connents-item>
				</view>
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
				page: {},
				list: [],

				scrollTop: 0
			}
		},
		onPageScroll(e) {
			this.scrollTop = e.scrollTop;
		},
		methods: {
			submit(form) {
				this.loading = true
				list(form).then(res => {
					this.loading = false
					this.list = res
					this.$refs.backTop.backToTop()
					this.showSearch = false
				}).catch(e => {
					this.loading = false
					this.list = []
					this.$emit('error', res)
					console.log(e)
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
