package com.fp.mall.sale.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RedisConfig {

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);

        // jackson2 序列化方式
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 解决LocalDateTime序列化问题
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // String 序列化方式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key 采用String序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // value 采用jackson2序列化方式
        template.setValueSerializer(jackson2JsonRedisSerializer);

        // hash-key 采用String序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // hash-value 采用jackson2序列化方式
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.afterPropertiesSet();
        return template;
    }

    // 秒杀Lua脚本
    @Bean("flashsaleScript")
    public RedisScript<Long> flashsaleScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        // 设置返回类型
        redisScript.setResultType(Long.class);
        // 设置Lua脚本文件
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redis/flashsale.lua")));
        return redisScript;
    }


}

