package com.fp.mall.product.config;

import io.seata.rm.datasource.DataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Seata - 代理数据源配置
 *
 * @author FlowingCloudL
 * @date 2022/5/14 19:47
 */
@Slf4j
@Configuration
public class DataSourceProxyConfig {

    // 配置代理数据源，使Seata生效！
    @Bean
    DataSource dataSource(DataSourceProperties properties) {
        DataSource dataSource = properties.initializeDataSourceBuilder().build();
        DataSourceProxy dataSourceProxy = new DataSourceProxy(dataSource);
        log.info("代理数据源已经生效!");
        return dataSourceProxy;
    }

}