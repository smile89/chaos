package com.chaos.mapper.sql;

import com.chaos.domain.ChaosProduct;
import io.netty.util.internal.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Objects;

public class ProductSql extends SQL {
    private static final String TABLE_NAME = "chaos_product";

    /**
     * 更新产品信息
     * @param product
     * @return
     */
    public String update(@Param("product")ChaosProduct product){
        return new SQL(){{
            UPDATE(TABLE_NAME);
            if (!StringUtil.isNullOrEmpty(product.getProductName())){
                SET("product_name=#{productName}");
            }
            if (!StringUtil.isNullOrEmpty(product.getProductDes())){
                SET("product_des=#{productDes}");
            }
            if (!StringUtil.isNullOrEmpty(product.getProductManager())){
                SET("product_manager=#{productManager}");
            }
            if (!StringUtil.isNullOrEmpty(product.getUpdatedBy())){
                SET("updated_by=#{updatedBy}");
            }
            if (Objects.nonNull(product.getUpdatedTime())){
                SET("updated_time=#{updatedTime}");
            }
            if (!StringUtil.isNullOrEmpty(product.getProjectId())){
                SET("project_id=#{projectId}");
            }
            WHERE("product_id=#{productId}");
        }}.toString();
    }

    /**
     * 新增产品信息
     * @return
     */
    public String insert(){
        return new SQL(){{
            INSERT_INTO(TABLE_NAME);
            VALUES("product_name, product_des, product_manager, created_by, created_time, updated_by, updated_time, isdel, project_id","#{productName}, #{productDes}, #{productManager}, #{createdBy}, #{createdTime}, #{updatedBy}, #{updatedTime}, #{isdel}, #{projectId}");
        }}.toString();
    }
}
