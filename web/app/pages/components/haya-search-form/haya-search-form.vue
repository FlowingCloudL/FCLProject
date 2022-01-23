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
					<u--input @confirm="submit" v-model="form.fuzzy_key" placeholder="请输入关键词" />
				</u-form-item>
				<u-form-item label="用户uid" name="uid">
					<u--input @confirm="submit" v-model="form.uid" placeholder="请输入用户uid" />
				</u-form-item>
				<u-form-item label="用户名" name="name">
					<u--input @confirm="submit" v-model="form.name" placeholder="请输入用户名" />
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
				<u-form-item label="最大条数" name="limit">
					<u--input @confirm="submit" v-model="form.limit" placeholder="请输入最大显示条数" />
				</u-form-item>
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
				<u-button style="margin-left: 10px;" type="primary" text="搜索" @click="submit"></u-button>
			</u-row>
		</view>
		<u-datetime-picker :show="showDatetime" :value="getDatetimeValue()" mode="date" @cancel="showDatetime = false"
			@confirm="datetimeSelect">{{form.endDate}}</u-datetime-picker>
		<u-action-sheet :show="showSheet" :actions="actions" title="请选择" @close="showSheet = false"
			@select="sheetSelect">
		</u-action-sheet>
	</view>
</template>

<script>
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
					startDate: new Date(new Date().getTime() - 24 * 60 * 60 * 1000).format('yyyy-MM-dd HH:mm:ss'),
					// 结束日期
					endDate: new Date().format('yyyy-MM-dd HH:mm:ss'),
					// 排序标准
					orderBy: "`floor`",
					// 排序
					order: 2,
					// 仅获取json类型
					type: 2,
					// 最大显示条数
					limit: 100,
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
					limit: {
						rules: [{
							format: 'number',
							errorMessage: '楼层只能输入数字'
						}]
					},
				},
				// 日期选择器
				showDatetime: false,
				datetimeKey: 'startDate',
				// 选择器
				showSheet: false,
				// 选择器类型
				actionsKey: 'no',
				actionsMap: {
					// 楼号集合
					no: [{
							name: '六号楼',
							value: 6
						},
						{
							name: '五号楼',
							value: 5
						},
						{
							name: '四号楼',
							value: 4
						},
						{
							name: '三号楼',
							value: 3
						},
						{
							name: '二号楼',
							value: 2
						},
						{
							name: '一号楼',
							value: 1
						},
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
		methods: {
			handleClose() {
				this.$emit('close')
			},
			submit() {
				this.$refs.form.validate().then(e => {
					this.$emit('submit', this.form)
					/* this.loading = true
					list(this.form).then(res => {
						this.loading = false
						this.$emit('success', res)
						// this.list = res
						// this.showSearch = false
					}).catch(e => {
						this.loading = false
						this.list = []
						this.$emit('error', res)
						console.log(e)
					}) */
				}).catch(err => {
					console.log('err', err);
					this.$emit('validate-error', res)
				})
			},
			handleOpenSheet(key) {
				this.actionsKey = key;
				this.$nextTick(() => {
					this.showSheet = true
				})
			},
			sheetSelect(e) {
				this.form[this.actionsKey] = e.value
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
