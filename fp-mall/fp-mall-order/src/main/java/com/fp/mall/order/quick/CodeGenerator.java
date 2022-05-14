package com.fp.mall.order.quick;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CodeGenerator {
    public static void main(String[] args) {
        String packagePath = System.getProperty("user.dir") + "/fp-mall/fp-mall-order/src/main/java";
        FastAutoGenerator.create(
                    "jdbc:mysql://localhost:3306/fp_mall_oms?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC",
                    "root",
                    "123456"
                )
                // 全局配置
                .globalConfig(builder -> builder
                        .outputDir(packagePath)
                        .author("FlowingCloudL")
                        .enableSwagger()
                        .fileOverride()
                )
                // 包配置
                .packageConfig(builder -> builder
                        .parent("com.fp.mall.order.quick")
                )
                // 策略配置
                .strategyConfig(builder -> builder
                        .addInclude(getTables("all"))
                        .entityBuilder()
                                .enableLombok()
                                .addTableFills(
                                        new Column("create_time", FieldFill.INSERT),
                                        new Column("update_time", FieldFill.UPDATE)
                                )
                        .build()
                )
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }



    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
