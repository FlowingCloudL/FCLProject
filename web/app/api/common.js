import http from '@/lib/http/http.request.js';

export const list = (data) => {
	return http.request({
		url: '/select/default',
		method: 'POST',
		data
	})
}