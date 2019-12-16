package com.chaos.mapper;

import com.chaos.domain.ChaosProduct;
import com.chaos.mapper.sql.ProductSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ChaosProductMapper {

    @Select("SELECT * FROM chaos_product")
    @Results(id = "productMap", value = {
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productDes", column = "product_des"),
            @Result(property = "productManager", column = "product_manager"),
            @Result(property = "createdBy", column = "created_by"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "updatedBy", column = "updated_by"),
            @Result(property = "updatedTime", column = "updated_time"),
            @Result(property = "projectId", column = "project_id")
    })
    List<ChaosProduct> getAll();

    /**
     * 根据产品id查找产品
     *
     * @param productId
     */
    @Select("SELECT * FROM chaos_product WHERE product_id=#{productId}")
    @ResultMap(value = "productMap")
    ChaosProduct findById(Long productId);


    /**
     * 插入产品信息
     * @param product
     * @return
     */
//    @Insert("INSERT INTO chaos_product (product_name, product_des, product_manager, created_by, created_time, updated_by, updated_time, isdel, project_id) VALUES " +
//            "(#{productName}, #{productDes}, #{productManager}, #{createdBy}, #{createdTime}, #{updatedBy}, #{updatedTime}, #{isdel}, #{projectId})")
    @InsertProvider(type = ProductSql.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "productId", keyColumn = "product_id")
    Long insert(ChaosProduct product);

    /**
     * 根据产品id删除产品
     * @param productId
     */
    @Delete("DELETE FROM chaos_product WHERE product_id = #{productId}")
    void del(Long productId);

    /**
     * 更新产品信息
     * @param product
     */
    @UpdateProvider(type = ProductSql.class, method = "update")
    @ResultMap(value = "productMap")
    void update(ChaosProduct product);

}
