package com.fp.mall.product.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
@Document(indexName = "fp_mall_product_spu")
public class EsProductEntity {

    @Id
    private Long spuId;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String spuName;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String spuDesc;

    @Field(type = FieldType.Text)
    private String descImgUrl;

    @Field(type = FieldType.Long)
    private Long brandId;

    @Field(type = FieldType.Long)
    private Long categoryId;

    @Field(type = FieldType.Byte)
    private Byte status;

    @Field(type = FieldType.Long)
    private Long price;

    @Field(type = FieldType.Long)
    private Long sales;

    @Field(type = FieldType.Long)
    private Long totalStock;

    @Field(type = FieldType.Auto)
    private LocalDateTime createTime;

}
