package com.chaos.mapper;

import com.chaos.domain.ChaosApi;
import com.chaos.mapper.sql.ApiSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ChaosApiMapper {

    @Select("SELECT * FROM API")
    @Results(id = "apiMap", value = {
            @Result(property = "apiType", column = "api_type"),
            @Result(property = "apiVersion", column = "api_version"),
            @Result(property = "apiName", column = "api_name"),
            @Result(property = "apiMethod", column = "api_method"),
            @Result(property = "apiUri", column = "api_uri"),
            @Result(property = "apiBody", column = "api_body"),
            @Result(property = "createdBy", column = "created_by"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "apiRelation", column = "api_relation"),
            @Result(property = "updatedBy", column = "updated_by"),
            @Result(property = "updatedTime", column = "updated_time"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "lastrunTime", column = "lastrun_time"),
            @Result(property = "apiStatus", column = "api_status"),
    })
    List<ChaosApi> findAll();

    @Select("SELECT * FROM API WHERE id=#{id}")
    @ResultMap(value = "apiMap")
    ChaosApi selectById(Long id);

    @Select("SELECT count(id) FROM API where api_name = #{apiName}")
    int checkApiExist(String apiName);


    @InsertProvider(type = ApiSql.class, method = "insert")
    @ResultMap(value = "apiMap")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(ChaosApi api);

    @UpdateProvider(type = ApiSql.class, method = "update")
    @ResultMap(value = "apiMap")
    void update(ChaosApi chaosApi);

}
