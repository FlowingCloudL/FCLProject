const config = {
  header: {
    token: '',
    'Content-Type': 'application/x-www-form-urlencoded',
  },
  timeout: 1,	// 超时时间，单位 ms
  dataType: 'json',	// 如果设为 json，会尝试对返回的数据做一次 JSON.parse
  responseType: 'text',	// 设置响应的数据类型。合法值：text、arraybuffer
  sslVerify: true,		// 验证 ssl 证书
  baseUrl: '',
  rootUrl: ''
};

export default config;