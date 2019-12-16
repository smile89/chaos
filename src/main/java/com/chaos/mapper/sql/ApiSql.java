package com.chaos.mapper.sql;

import com.chaos.domain.ChaosApi;
import io.netty.util.internal.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Objects;

public class ApiSql extends SQL {
    private static final String TABLE_NAME = "API";

    /**
     * 新增API信息
     * @return
     */
    public String insert(){
         return new SQL(){{
             INSERT_INTO(TABLE_NAME);
             VALUES("id, api_type, api_version, api_name, api_method, api_path, api_body, created_by, created_time, api_relation, updated_by, updated_time, product_id, lastrun_time, api_status, isdel, runtime",
                     "#{id}, #{apiType}, #{apiVersion}, #{apiName}, #{apiMethod}, #{apiPath}, #{apiBody}, #{createdBy}, #{createdTime}, #{apiRelation}, #{updatedBy}, #{updatedTime}, #{productId}, #{lastrunTime}, #{apiStatus}, #{isdel}, #{runtime}");
         }}.toString();
    }

    public String update(@Param("chaosApi")ChaosApi chaosApi){
        return new SQL(){{
            UPDATE(TABLE_NAME);
            if (Objects.nonNull(chaosApi.getApiType())){
                SET("api_typr=#{apiType}");
            }
            if (!StringUtil.isNullOrEmpty(chaosApi.getApiVersion())){
                SET("api_version=#{apiVersion}");
            }
            if (!StringUtil.isNullOrEmpty(chaosApi.getApiName())){
                SET("api_name=#{apiName}");
            }
            if (!StringUtil.isNullOrEmpty(chaosApi.getApiMethod())){
                SET("api_method=#{apiMethod}");
            }
            if (!StringUtil.isNullOrEmpty(chaosApi.getApiPath())){
                SET("api_path=#{apiPath}");
            }
            if (!StringUtil.isNullOrEmpty(chaosApi.getApiBody())){
                SET("api_body=#{apiBody}");
            }
            if (!StringUtil.isNullOrEmpty(chaosApi.getCreatedBy())){
                SET("created_by=#{createdBy}");
            }
            if (Objects.nonNull(chaosApi.getCreatedTime())){
                SET("created_time=#{createdTime}");
            }
            if (Objects.nonNull(chaosApi.getApiRelation())){
                SET("api_relation=#{apiRelation}");
            }
            if (!StringUtil.isNullOrEmpty(chaosApi.getUpdatedBy())){
                SET("updated_by=#{updatedBy}");
            }
            if (Objects.nonNull(chaosApi.getUpdatedTime())){
                SET("updated_by=updatedBy");
            }
            if (Objects.nonNull(chaosApi.getProductId())){
                SET("product_id=#{productId}");
            }
            if (Objects.nonNull(chaosApi.getLastrunTime())){
                SET("lastrun_time=#{lastrunTime}");
            }
            if (Objects.nonNull(chaosApi.getApiStatus())){
                SET("api_status=#{apiStatus}");
            }
            if (!StringUtil.isNullOrEmpty(chaosApi.getIsdel())){
                SET("isdel=#{isdel}");
            }
            if (Objects.nonNull(chaosApi.getRuntime())){
                SET("runtime=#{runtime}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }
}
