package com.fp.gateway.filter;

import cn.dev33.satoken.id.SaIdUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 *  Filter - 添加 ID-Token
 */

public class SaIdTokenFilter implements GlobalFilter {
        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            ServerHttpRequest newRequest = exchange
                    .getRequest()
                    .mutate()
                    // 为请求追加 Id-Token 参数
                    .header(SaIdUtil.ID_TOKEN, SaIdUtil.getToken())
                    .build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        }
    }