import http from '@/lib/http/http.request.js';

export const list = (data) => {
	return http.request({
		url: '/select/comments',
		method: 'POST',
		data
	})
}

export const buildingList = () => {
	return http.request({
		url: '/select/building/list',
		method: 'get'
	})
}