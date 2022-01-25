package com.fclProject.haya152.consumer.nga.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


    //后台监控配置
    //SpringBoot内置了Servlet容器, 因而没有web.xml, 若要注册一个Servlet/Filter, 替代方法:

    //1.Servlet: 注册一个类型为 ServletRegistrationBean 的 bean, 相当于在web.xml配置了servlet
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //配置参数
        HashMap<String, String> initParameters = new HashMap<>();

        //添加配置, 注意: 配置名是固定的
        //用户名,密码
        initParameters.put("loginUsername","root");
        initParameters.put("loginPassword","123456");
        //允许访问 为"" 代表所有人都可以访问
        initParameters.put("allow","");
        //禁止访问
        //initParameters.put("kuangshen","192.168.11.123");

        bean.setInitParameters(initParameters);

        return bean;
    }

    //2.Filter: 注册一个类型为 FilterRegistrationBean 的 bean, 相当于在web.xml配置了Filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();

        //添加过滤器: 统计url访问
        bean.setFilter(new WebStatFilter());

        //设置参数, 参数名是约定好的
        Map<String, String> initParameters = new HashMap<>();
        //exclusions : 排除路径, 不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);

        return bean;
    }

}
