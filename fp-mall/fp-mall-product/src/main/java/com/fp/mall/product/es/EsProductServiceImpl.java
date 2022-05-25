package com.fp.mall.product.es;

import com.alibaba.fastjson.JSON;
import com.fp.common.core.model.PageDTO;
import com.fp.common.core.model.PageVO;
import com.fp.common.core.util.PageUtil;
import com.fp.mall.product.mapper.SpuMapper;
import com.fp.mall.product.model.dto.SpuSearchDTO;
import com.fp.mall.product.model.entity.SpuEntity;
import com.fp.mall.product.model.vo.SpuAppSearchVO;
import com.fp.mall.product.service.SpuService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EsProductServiceImpl implements EsProductService {

    @Resource
    private EsRepository esRepository;

    @Resource
    private SpuMapper spuMapper;

    @Resource
    private SpuService spuService;

    @Resource
    private RestHighLevelClient esClient;

    @Override
    public PageVO<SpuAppSearchVO> searchSpu(SpuSearchDTO spuSearchDTO) throws IOException {

        //=============================================== 构造搜索条件 ================================================

        SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.searchSource(); // 搜索构造器
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery(); // 布尔查询
        searchSourceBuilder.query(boolQuery); // 将布尔查询放入搜索构造器中

        // 关键词匹配
        boolQuery.should(QueryBuilders.matchQuery("spuName", spuSearchDTO.getSpuKeyword()))
                .should(QueryBuilders.matchQuery("spuDesc", spuSearchDTO.getSpuKeyword()));
        // 过滤品牌
        if (spuSearchDTO.getBrandId() != null) {
            boolQuery.filter(QueryBuilders.termQuery("brandId", spuSearchDTO.getBrandId()));
        }
        // 过滤分类
        if (spuSearchDTO.getCategoryId() != null) {
            boolQuery.filter(QueryBuilders.termQuery("categoryId", spuSearchDTO.getCategoryId()));
        }
        // 过滤状态
        if (spuSearchDTO.getStatus() != null) {
            boolQuery.filter(QueryBuilders.termQuery("status", spuSearchDTO.getStatus()));
        }
        // 价格区间 >
        if (spuSearchDTO.getMinPrice() != null) {
            boolQuery.filter(QueryBuilders.rangeQuery("price").gte(spuSearchDTO.getMinPrice()));
        }
        // 价格区间 <
        if (spuSearchDTO.getMaxPrice() != null) {
            boolQuery.filter(QueryBuilders.rangeQuery("price").lte(spuSearchDTO.getMaxPrice()));
        }
        // 销量区间 >
        if (spuSearchDTO.getMinSales() != null) {
            boolQuery.filter(QueryBuilders.rangeQuery("sales").gte(spuSearchDTO.getMinSales()));
        }
        // 销量区间 <
        if (spuSearchDTO.getMaxSales() != null) {
            boolQuery.filter(QueryBuilders.rangeQuery("sales").lte(spuSearchDTO.getMaxSales()));
        }

        // 排序
        if (spuSearchDTO.getSortRule() != null) {
            String rule = "sales"; // 默认销量
            SortOrder order = SortOrder.ASC; // 默认升序
            switch (spuSearchDTO.getSortRule()) {
                case 0: rule = "sales"; break;
                case 1: rule = "price"; break;
            }
            switch (spuSearchDTO.getSortType()) {
                case 0: order = SortOrder.ASC; break;
                case 1: order = SortOrder.DESC; break;
            }
            searchSourceBuilder.sort(rule, order);
        }

        // 分页
        PageDTO pageDTO = spuSearchDTO.getPageDTO(); // 分页参数
        searchSourceBuilder.from(pageDTO.getPageNum()).size(pageDTO.getPageSize());

        //=============================================== 构造搜索请求 ================================================

        SearchRequest searchRequest = new SearchRequest("fp_mall_product_spu");
        searchRequest.source(searchSourceBuilder);

        //=============================================== 处理响应结果 ================================================

        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();

        // 封装搜索结果
        List<SpuAppSearchVO> spuAppSearchVOS = new ArrayList<>(hits.length);
        for (SearchHit hit : hits) {
            EsProductEntity esProductEntity = JSON.parseObject(hit.getSourceAsString(), EsProductEntity.class);
            SpuAppSearchVO spuAppSearchVO = new SpuAppSearchVO();
            BeanUtils.copyProperties(esProductEntity, spuAppSearchVO);
            spuAppSearchVOS.add(spuAppSearchVO);
        }

        PageVO<SpuAppSearchVO> pageVO = new PageVO<>();
        pageVO.setPageNum(pageDTO.getPageNum());
        pageVO.setPageSize(pageDTO.getPageSize());
        pageVO.setContent(spuAppSearchVOS);

        return pageVO;
    }

    @Override
    public void importAll() {
        // 从数据库拉取全部商品数据
        List<SpuEntity> spuList = spuMapper.list();
        List<EsProductEntity> esList = new ArrayList<>(spuList.size());
        for (SpuEntity entity :spuList) {
            EsProductEntity esProductEntity = new EsProductEntity();
            BeanUtils.copyProperties(entity, esProductEntity);
            esProductEntity.setPrice(0L);
            esProductEntity.setSales(0L);
            esList.add(esProductEntity);
        }
        // 保存到ES中
        System.out.println(esList);
        esRepository.saveAll(esList);
    }
}
