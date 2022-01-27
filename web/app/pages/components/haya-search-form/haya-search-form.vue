<template>
	<view>
		<view style="margin-left: 40upx; margin-right: 40upx; padding-bottom: 10px;">
			<u--form ref="form" :model="form" :rules="rules" labelWidth="80">
				<u-form-item label="楼号" name="no" required @click="handleOpenSheet('no')">
					<u--input :value="getSheetLabel('no', form.no)" disabled :disabledColor="color.bgColor"
						placeholder="请选择楼号">
						<u-icon slot="suffix" name="arrow-right"></u-icon>
					</u--input>
				</u-form-item>
				<u-form-item label="关键词" name="fuzzy_key">
					<u--input @confirm="submit" v-model="form.fuzzy_key" placeholder="请输入关键词" >
						<u-button slot="suffix" size="mini" :color="color.theme" @click="handleOpenHistory('fuzzy_key')" text="历史"></u-button>
					</u--input>
				</u-form-item>
				<u-form-item label="用户uid" name="uid">
					<u--input @confirm="submit" v-model="form.uid" placeholder="请输入用户uid" >
						<u-button slot="suffix" size="mini" :color="color.theme" @click="handleOpenHistory('uid')" text="历史"></u-button>
					</u--input>
				</u-form-item>
				<u-form-item label="用户名" name="name">
					<u--input @confirm="submit" v-model="form.name" placeholder="请输入用户名" >
						<u-button slot="suffix" size="mini" :color="color.theme" @click="handleOpenHistory('name')" text="历史"></u-button>
					</u--input>
				</u-form-item>
				<u-form-item label="楼层" name="floor">
					<u--input @confirm="submit" v-model="form.floor" placeholder="请输入楼层" />
				</u-form-item>
				<u-form-item label="评论类型" name="tag" @click="handleOpenSheet('tag')">
					<u--input :value="getSheetLabel('tag', form.tag)" disabled :disabledColor="color.bgColor"
						placeholder="请选择评论类型">
						<u-icon slot="suffix" name="arrow-right"></u-icon>
					</u--input>
				</u-form-item>
				<u-form-item label="开始日期" name="startDate" required @click="handleOpenDatetime('startDate')">
					<u--input :value="form.startDate" disabled :disabledColor="color.bgColor" placeholder="请选择开始日期">
						<u-icon slot="suffix" name="arrow-right"></u-icon>
					</u--input>
				</u-form-item>
				<u-form-item label="结束日期" name="endDate" required @click="handleOpenDatetime('endDate')">
					<u--input :value="form.endDate" disabled :disabledColor="color.bgColor" placeholder="请选择开始日期">
						<u-icon slot="suffix" name="arrow-right"></u-icon>
					</u--input>
				</u-form-item>
				<!-- <u-form-item label="最大条数" name="limit">
					<u--input @confirm="submit" v-model="form.limit" placeholder="请输入最大显示条数" />
				</u-form-item> -->
				<u-form-item label="排序标准" name="orderBy" required @click="handleOpenSheet('orderBy')">
					<u--input :value="getSheetLabel('orderBy', form.orderBy)" disabled :disabledColor="color.bgColor"
						placeholder="请选择楼号">
						<u-icon slot="suffix" name="arrow-right"></u-icon>
					</u--input>
				</u-form-item>
				<u-form-item label="排序" name="order" required>
					<u-radio-group v-model="form.order">
						<u-row style="width: 100%;">
							<u-col span="4" v-for="(item, index) in actionsMap.order" style="text-align: left;">
								<u-radio style="margin-left: 10px;" :key="index" :label="item.name" :name="item.value">
								</u-radio>
							</u-col>
						</u-row>
					</u-radio-group>
				</u-form-item>
			</u--form>
			<u-row style="margin-top: 10px;">
				<u-button type="error" text="关闭" @click="handleClose"></u-button>
				<u-button style="margin-left: 10px; " type="primary" text="搜索" @click="submit"></u-button>
			</u-row>
		</view>
		<u-datetime-picker :show="showDatetime" :value="getDatetimeValue()" mode="datetime" @cancel="showDatetime = false"
			@confirm="datetimeSelect">{{form.endDate}}</u-datetime-picker>
		<u-action-sheet :show="showSheet" :actions="actions" title="请选择" @close="showSheet = false"
			@select="sheetSelect">
		</u-action-sheet>
		<u-popup :show="showHistory" :customStyle="{width: '90%', padding: '0px 10px 10px 0px'}" mode="center" @close="showHistory = false">
			<view>
				<u-tag 
					:style="{float: 'left', marginLeft: '10px', marginTop: '10px'}" 
					v-for="(text, index) in history" 
					:text="text" 
					closable 
					@close="handleDelHistory(text)"
					@click="handleClickHistory(text)"></u-tag>
			</view>
		</u-popup>
	</view>
</template>

<script>
	import {buildingList} from '../../../api/common.js'
	import color from '../../../lib/color.js'
	export default {
		name: 'haya-search-form',
		data() {
			return {
				color: color,
				// 表单
				form: {
					// 楼号
					no: 6,
					// 用户uid
					uid: '',
					// 用户名
					name: '',
					// 楼层
					floor: '',
					// 评论类型
					tag: '',
					// 开始日期
					startDate: '',
					// 结束日期
					endDate: '',
					// 排序标准
					orderBy: "`floor`",
					// 排序
					order: 2,
					// 仅获取json类型
					type: 2,
					fuzzy_key: ''
				},
				// 校验规则
				rules: {
					no: {
						rules: [{
							required: true,
							errorMessage: '楼号不能为空'
						}]
					},
					floor: {
						rules: [{
							format: 'number',
							errorMessage: '楼层只能输入数字'
						}]
					},
				},
				// 显示历史
				showHistory: false,
				historyKey: '',
				history: [],
				// 日期选择器
				showDatetime: false,
				datetimeKey: 'startDate',
				// 选择器
				showSheet: false,
				// 选择器类型
				actionsKey: 'no',
				actionsMap: {
					// 楼号集合
					no: [
					],
					// 评论类型集合
					tag: [{
							name: '所有',
							value: ''
						}, {
							name: '同传',
							value: 2
						},
						{
							name: '回复',
							value: 1
						},
						{
							name: '普通评论',
							value: 0
						},

					],
					// 排序类型集合
					orderBy: [{
							name: '用户uid',
							value: "`uid`"
						},
						{
							name: '用户名',
							value: "`name`"
						},
						{
							name: '楼层',
							value: "`floor`"
						},
						{
							name: '赞数',
							value: "`like`"
						},
						{
							name: '日期',
							value: "`date`"
						},
					],
					// 排序方式集合
					order: [{
							name: '升序',
							value: 1
						},
						{
							name: '降序',
							value: 2
						},
					],
				}
			}
		},
		computed: {
			actions() {
				return this.actionsMap[this.actionsKey]
			}
		},
		mounted() {
			buildingList().then(res=>{
				let list = []
				
				for(let i = res.length - 1; i >= 0; i--){
					let item = res[i]
					item['value'] = item['building_no']
					item['name'] = item['building_name'] + '号专楼'
					list.push(item)
				}
				
				this.actionsMap.no = list
				if(res && res.length > 0){
					this.actionsKey = 'no'
					console.log(list[0]);
					this.sheetSelect(list[0])
				}else {
					uni.showToast({
						icon: 'none',
						title: '未获取到专楼列表'
					})
				}
				
			}).catch(e=>{
				console.log(e)
				uni.showToast({
					icon: 'none',
					title: '未获取到专楼列表'
				})
			})
		},
		methods: {
			handleClose() {
				this.$emit('close')
			},
			submit() {
				this.$refs.form.validate().then(e => {
					this.$emit('submit', this.form)
					let form = uni.getStorageSync('form')
					if(!form){
						form = {
							fuzzy_key: [],
							uid: [],
							name: []
						}
					}
					for(let key in form){
						let val = this.form[key]
						if(val && form[key].indexOf(val) === -1){
							form[key] = [val].concat(form[key])
						}
					}
					uni.setStorageSync('form', form)
				}).catch(err => {
					console.log('err', err);
					this.$emit('validate-error', err)
				})
			},
			handleOpenHistory(key){
				let form = uni.getStorageSync('form')
				if(form[key] && form[key].length > 0){
					this.history = form[key]
					this.historyKey = key
					this.showHistory = true
				}else {
					this.history = []
					uni.showToast({
						icon: 'none',
						title: '没有相关历史'
					})
				}
			},
			handleClickHistory(text){
				this.form[this.historyKey] = text
				this.showHistory = false
			},
			handleDelHistory(text){
				let list = uni.$u.deepClone(this.history)
				for(let i = 0; i < list.length; i++){
					if(list[i] === text){
						list.splice(i, 1)
					}
				}
				let form = uni.getStorageSync('form')
				form[this.historyKey] = list
				uni.setStorageSync('form', form)
				this.history = list
			},
			handleOpenSheet(key) {
				this.actionsKey = key;
				this.$nextTick(() => {
					this.showSheet = true
				})
			},
			sheetSelect(e) {
				this.form[this.actionsKey] = e.value
				/* if(this.actionsKey == 'no'){
					this.form.startDate = e.startDatetime
					this.form.endDate = e.endDatetime
				} */
			},
			getSheetLabel(key, value) {
				let list = this.actionsMap[key]
				for (let item of list) {
					if (item.value === value) {
						return item.name
					}
				}
				return ''
			},
			handleOpenDatetime(key) {
				this.datetimeKey = key;
				this.showDatetime = true
			},
			datetimeSelect({
				value
			}) {
				this.form[this.datetimeKey] = new Date(value).format('yyyy-MM-dd HH:mm:ss')
				this.showDatetime = false
			},
			getDatetimeValue() {
				return this.form[this.datetimeKey]
			},
		}
	}
</script>

<style>
</style>
