<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style lang="scss">
	@import "@/uni_modules/uview-ui/index.scss";
	
	$u-primary: #222;
	$u-primary-dark: #000;
	$u-primary-disabled: #444;
	$u-primary-light: #888;
	
	.u-navbar__content__title {
		color: #fff3d5 !important
	}
	
	body {
		background-color: #fff3d5;
	}
	
	.u-form-item__body__left__content__label {
		font-weight: 600;
		color: #10273f !important;
	}
	
	.u-border {
		border-color: #e0c19e !important;
	}
</style>
