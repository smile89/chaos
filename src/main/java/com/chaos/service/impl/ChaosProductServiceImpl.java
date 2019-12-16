package com.chaos.service.impl;

import com.chaos.domain.ChaosProduct;
import com.chaos.common.JsonData;
import com.chaos.mapper.ChaosProductMapper;
import com.chaos.service.ChaosProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChaosProductServiceImpl implements ChaosProductService {

    @Autowired
    private ChaosProductMapper chaosProductMapper;

    /**
     * 新增产品
     *
     * @param product
     */
    @Override
    public Long addProduct(ChaosProduct product) {
        chaosProductMapper.insert(product);
        return product.getProductId();
    }

    /**
     * 获取全部产品
     */
    @Override
    public List<ChaosProduct> getAll() {
        return chaosProductMapper.getAll();
    }

    /**
     * 根据产品ID查找产品
     *
     * @param productId
     */
    @Override
    public ChaosProduct findById(Long productId) {
        return chaosProductMapper.findById(productId);
    }

    /**
     * 更新产品信息
     *
     * @param product
     */
    @Override
    public JsonData updateProduct(ChaosProduct product) {
        if (!Objects.nonNull(product.getProductId())){
            return JsonData.buildError("产品Id不能为空");
        }
        try {
            chaosProductMapper.update(product);
            return JsonData.buildSuccess("产品信息更新成功");
        } catch (Exception e) {
            return JsonData.buildError("产品信息更新失败");
        }

    }

    /**
     * 根据项目Id删除项目
     *
     * @param productId
     */
    @Override
    public JsonData deleteProduct(Long productId) {
        try {
            chaosProductMapper.del(productId);
            return JsonData.buildSuccess("删除数据成功");
        } catch (Exception e) {
            // TODO: 2019/12/10 添加日志
            return JsonData.buildError("失败");
        }
    }

    /**
     * 1、插入数据
     * 2、将返回主键返回
     * 3、异常处理
     */
    @Override
    public JsonData saveProduct(ChaosProduct chaosProduct) {
        try {
            Long productIdPo = chaosProductMapper.insert(chaosProduct);
            return JsonData.buildSuccess(productIdPo);
        } catch (Exception e) {
            //TODO 添加错误日志输出，便于排错
            System.out.println(e);
            return JsonData.buildError("失败");
        }

    }
}
