package com.chaos.controller;

import com.chaos.domain.ChaosProduct;
import com.chaos.service.ChaosProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/product")
public class ChaosProductController {

    @Autowired
    private ChaosProductService chaosProductService;

    @GetMapping("add")
    public Object addProd(){
        //Controller 负责接参，返回处理结果
        ChaosProduct product = new ChaosProduct();
        product.setProductName("测试产品2");
        product.setProductDes("测试产品描述2");
        product.setProductManager("王阳2");
        product.setCreatedBy("王阳2");
        product.setCreatedTime(new Date());
        product.setUpdatedBy("王阳2");
        product.setUpdatedTime(new Date());
        product.setProjectId("1");
        product.setIsdel("0");
        return chaosProductService.saveProduct(product);
    }


    /**
     * 更新产品信息
     * @param productId
     * @return
     */
    @GetMapping("update")
    public Object updateProductInfo(Long productId){
        ChaosProduct product = new ChaosProduct();
        product.setProductId(productId);
        product.setProductName("测试产品更新");
        return chaosProductService.updateProduct(product);
    }
}
