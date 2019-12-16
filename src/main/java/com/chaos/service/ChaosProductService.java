package com.chaos.service;

import com.chaos.domain.ChaosProduct;
import com.chaos.common.JsonData;

import java.util.List;

public interface ChaosProductService {
    /**新增产品*/
    public Long addProduct(ChaosProduct product);

    /** 获取全部产品*/
    public List<ChaosProduct> getAll();

    /** 根据产品ID查找产品*/
    public ChaosProduct findById(Long productId);

    /** 更新产品信息*/
    JsonData updateProduct(ChaosProduct product);

    /** 根据项目Id删除项目*/
    JsonData deleteProduct(Long productId);

    /** 新增产品 */
    JsonData saveProduct(ChaosProduct chaosProduct);
}
