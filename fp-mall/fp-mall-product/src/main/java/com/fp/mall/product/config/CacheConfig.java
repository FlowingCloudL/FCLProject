package com.fp.mall.product.config;
 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
 
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


/**
 * 缓存配置类
 *
 * @author FlowingCloudL
 * @date 2022/5/7 21:37
 */
@Configuration
@EnableCaching
public class CacheConfig {
 
    /**
     * CacheManager为一个接口，RedisCacheManager为该接口的实现
     * @param redisConnectionFactory 连接工厂
     * @return 连接管理器
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(defaultCacheConfig(10000)) // 默认配置
                .withInitialCacheConfigurations(initCacheConfigMap()) // 从initCacheConfigMap()获取针对不同cacheName的不同配置
                .transactionAware()
                .build();
    }
 
    /**
     * 缓存配置
     * @param second 默认过期时间(秒)
     * @return Redis缓存配置
     */
    private RedisCacheConfiguration defaultCacheConfig(Integer second) {

        // 序列化方式
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
 
        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        //创建RedisCache的配置
        return RedisCacheConfiguration.defaultCacheConfig()
                // 过期时间
                .entryTtl(Duration.ofSeconds(second))
                // key 的序列化方式
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                // value 的序列化方式
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                // 禁止缓存空值
                .disableCachingNullValues();
    }
 
    /**
     * 针对不同的key, 自定义过期时间
     * @return 过期时间配置
     */
    private Map<String,RedisCacheConfiguration> initCacheConfigMap() {
 
        Map<String,RedisCacheConfiguration> configMap = new HashMap<>();
        configMap.put("User",this.defaultCacheConfig(1000));
        configMap.put("User1",this.defaultCacheConfig(1000));
        configMap.put("User2",this.defaultCacheConfig(1000));
        configMap.put("User3",this.defaultCacheConfig(1000));
        return configMap;
    }
 
}