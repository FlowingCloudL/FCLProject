package com.fp.mall.product.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsRepository extends ElasticsearchRepository<EsProductEntity, Long> {

}
