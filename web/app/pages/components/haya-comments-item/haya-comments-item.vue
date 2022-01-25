<template>
	<view :style="style">
		<!-- 用户信息 -->
		<u-line :color="color.border"></u-line>
		<u-row style="padding-top: 5px;">
			<u-col span="2">
				<u-avatar :text="item.name ? item.name[0] : ''"></u-avatar>
			</u-col>
			<u-col span="10">
				<u-row>
					<u-col span="8">
						<u--text :text="item.name" color="#f4af60" bold size="15" >
						</u--text>
					</u-col>
					<u-col span="2">
						<u-tag text="同传" size="mini" style="width: 36px;" color="#fff6df" :borderColor="color.theme" :bgColor="color.theme"  v-if="item.tag == '2'"></u-tag>
					</u-col>
					<u-col span="2">
						<u--text align="right" :color="color.fontDarkInfo" :text="'#' + item.floor" size="14"></u--text>
					</u-col>
				</u-row>
				<u-row>
					<u-col>
						<u--text :color="color.fontDarkInfo" :text="'uid: ' + item.uid" size="13"></u--text>
					</u-col>
				</u-row>
			</u-col>
		</u-row>
		<!-- 内容 -->
		<u-line style="margin-top: 5px; margin-bottom: 5px;" :color="color.border"></u-line>
		<u-row style="margin-top: 10px;">
			<view v-html="getComments(item.comments)"></view>
		</u-row>
		<!-- 点赞 时间 -->
		<u-line style="margin-top: 5px;" :color="color.border"></u-line>
		<u-row style="margin-top: 10px; ">
			<u-col span="6">
				<u--text :text="'赞: ' + item.like" :color="color.fontDarkInfo" size="12"></u--text>
			</u-col>
			<u-col span="6">
				<u--text align="right" :color="color.fontDarkInfo" :text="item.date" size="12"></u--text>
			</u-col>
		</u-row>
	</view>
</template>

<script>
	const basePath = window.location.protocol + "//" + window.location.host;
	import color from '../../../lib/color.js'
	export default {
		name: 'haya-comments-item',
		props:{
			item: {
				type: Object,
				default(){
					return {
						basePath: basePath,
					}
				}
			},
			bgColor: {
				type: String,
				default: '#fff3d5'
			}
		},
		data(){
			return {
				color: color
			}
		},
		computed:{
			style(){
				return {
					marginTop: '0px',
					backgroundColor: this.bgColor,
					paddingTop: '0px',
					paddingBottom: '10px',
					paddingLeft: '10px',
					paddingRight: '10px',
				}
			}
		},
		methods:{
			getComments(comments) {
				try{
					if (comments) {
						// 替换nga图片域名
						comments = comments.replace(/https:\/\/img4.nga.178.com/g, '/ngaimg4')
						comments = comments.replace(/https:\/\/img.nga.178.com/g, '/ngaimg')
						// 提取超链接
						let regexp = /\[(.*?)]/g;
						let array = comments.matchAll(regexp);
						for(let regexp of array){
							let text = regexp[0];
							if(text.indexOf('此网页不属于本网站，不保证其安全性继续访问取消') !== -1){
								let url = text.substring(text.lastIndexOf('http'), text.length - 1)
								comments = comments.replace(text, `<a href="${url}" >${url}</a>`)
							}
						}
						// 替换换行符
						comments = comments.replace(/[\n|\r]/g, '</br>')
					}
					
					return comments;
				}catch(e){
					//TODO handle the exception
					return comments;
				}
			}
		}
	}
</script>

<style>
</style>
