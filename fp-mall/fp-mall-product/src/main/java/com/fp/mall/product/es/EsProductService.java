package com.fp.mall.product.es;

import com.fp.common.core.model.PageVO;
import com.fp.mall.product.model.dto.SpuSearchDTO;
import com.fp.mall.product.model.vo.SpuAppSearchVO;

import java.io.IOException;

/**
 * ElasticSearch 搜索服务
 *
 * @author FlowingCloudL
 * @date 2022/5/18 16:23
 */
public interface EsProductService {

    /**
     * 搜索SPU
     * @param spuSearchDTO 查询参数
     * @return 分页 - SPU列表
     */
    PageVO<SpuAppSearchVO> searchSpu(SpuSearchDTO spuSearchDTO) throws IOException;

    /**
     * 将数据库中的全部商品信息, 保存到ES中
     */
    void importAll();
}
