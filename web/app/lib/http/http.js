import $config from '@/config'
import {
	getAccessToken
} from '../auth.js'
class HttpRequest {
	constructor(config) {
		this.config = config;
	}
	request(option) {
		const token = getAccessToken();
		let promise = new Promise((resolve, reject) => {
			let cfg = JSON.parse(JSON.stringify(this.config))

			cfg.header = option.header ? Object.assign({}, cfg.header, option.header) : cfg.header

			const isToken = (option.header || {}).isToken === false;
			let token = getAccessToken();
			if (token && !isToken) {
				// token
				cfg.header['Authorization'] = 'Bearer ' + token
			}
			let url = option.url ? option.url : '';
			url = $config.baseUrl + $config.rootUrl + url
			console.log($config);
			let params = option.params ? option.params : {};
			let temp = ''
			for (let i in params) {
				if (temp === '') {
					temp += '?'
				} else {
					temp += '&'
				}
				temp += i + '=' + params[i]
			}
			url += temp;

			let data = option.data ? option.data : {};

			let method = option.method ? option.method : 'GET';
			method = method.toUpperCase();
			uni.request({
				url: url,
				data: data,
				header: cfg.header,
				method: method,
				dataType: cfg.dataType,
				success: res => {
					try {
						if (res.header['content-disposition'] && res.header['content-disposition'].indexOf('attachment;fileName') != -1) {
							if (res.statusCode === 401) {
								uni.showToast({
									title: '凭证已过期，请重新登录'
								})
								/* setTimout(()=>{
									uni.reLaunch('/pages/init/init')
								}, 1000) */
							}
							resolve(res);
						}
					} catch (e) {
						reject(e)
					}
					// 收到开发者服务成功返回的回调函数
					resolve(res.data);
				},
				fail: error => { // 接口调用失败的回调函数, 控制台输出
					reject(error);
					console.log(cfg.header);
					console.log(error);
				},
				complete: () => { // 接口调用结束的回调函数（调用成功、失败都会执行）

				}
			})
		});
		return promise;
	}
	downloadFile(option){
		const token = getAccessToken();
		let promise = new Promise((resolve, reject) => {
			let cfg = JSON.parse(JSON.stringify(this.config))
		
			cfg.header = option.header ? Object.assign({}, cfg.header, option.header) : cfg.header
		
			const isToken = (option.header || {}).isToken === false;
			let token = getAccessToken();
			if (token && !isToken) {
				// token
				cfg.header['Authorization'] = 'Bearer ' + token
			}
		
			let url = option.url ? option.url : '';
			url = cfg.baseUrl + cfg.rootUrl + url
			let params = option.params ? option.params : {};
			let temp = ''
			for (let i in params) {
				if (temp === '') {
					temp += '?'
				} else {
					temp += '&'
				}
				temp += i + '=' + params[i]
			}
			url += temp;
		
			let data = option.data ? option.data : {};
		
			let method = option.method ? option.method : 'GET';
			method = method.toUpperCase();
			uni.downloadFile({
				url: url,
				header: cfg.header,
				success: res => {
					resolve(res);
				},
				fail: error => { // 接口调用失败的回调函数, 控制台输出
					reject(error);
					console.log(error);
				},
			})
		});
		return promise;
	}
}

export default HttpRequest;
