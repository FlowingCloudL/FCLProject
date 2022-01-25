import HttpRequest from './http.js';
import config from '@/config/index.js';
import httpConfig from './http.config.js';
let myHttpConfig = JSON.parse(JSON.stringify(httpConfig));
myHttpConfig.baseUrl = config.baseUrl;
myHttpConfig.rootUrl = config.rootUrl;
const http = new HttpRequest(myHttpConfig);
export default http;

