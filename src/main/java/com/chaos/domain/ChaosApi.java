package com.chaos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ChaosApi implements Serializable {
    /** 接口ID;接口ID */
    private Long id ;
    /** 接口类型;Restfull，dubbo等 */
    private Integer apiType ;
    /** 接口版本;接口版本 */
    private String apiVersion ;
    /** 接口名称;接口名称 */
    private String apiName ;
    /** 请求方法;请求方法 */
    private String apiMethod ;
    /** 接口路径;接口路径 */
    private String apiPath;
    /** 请求体;请求体 */
    private String apiBody ;
    /** 创建人;创建人 */
    private String createdBy ;
    /** 创建时间;创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createdTime ;
    /** 接口归属;接口关联 */
    private Integer apiRelation ;
    /** 更新人;更新人 */
    private String updatedBy ;
    /** 更新时间;更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updatedTime ;
    /** 所属系统;所属系统 */
    private Long productId ;
    /** 最后执行时间;最后执行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date lastrunTime ;
    /** 接口状态;0:正常；1:未完成；-1:废弃 */
    private Integer apiStatus ;
    /** 是否删除;0:未删除；1:已删除 */
    private String isdel ;
    /** 执行次数;执行次数 */
    private Integer runtime ;

    /** 接口ID;接口ID */
    public Long getId(){
        return this.id;
    }
    /** 接口ID;接口ID */
    public void setId(Long id){
        this.id = id;
    }
    /** 接口类型;Restfull，dubbo等 */
    public Integer getApiType(){
        return this.apiType;
    }
    /** 接口类型;Restfull，dubbo等 */
    public void setApiType(Integer apiType){
        this.apiType = apiType;
    }
    /** 接口版本;接口版本 */
    public String getApiVersion(){
        return this.apiVersion;
    }
    /** 接口版本;接口版本 */
    public void setApiVersion(String apiVersion){
        this.apiVersion = apiVersion;
    }
    /** 接口名称;接口名称 */
    public String getApiName(){
        return this.apiName;
    }
    /** 接口名称;接口名称 */
    public void setApiName(String apiName){
        this.apiName = apiName;
    }
    /** 请求方法;请求方法 */
    public String getApiMethod(){
        return this.apiMethod;
    }
    /** 请求方法;请求方法 */
    public void setApiMethod(String apiMethod){
        this.apiMethod = apiMethod;
    }
    /** 接口路径;接口路径 */
    public String getApiPath(){
        return this.apiPath;
    }
    /** 接口路径;接口路径 */
    public void setApiPath(String apiPath){
        this.apiPath = apiPath;
    }
    /** 请求体;请求体 */
    public String getApiBody(){
        return this.apiBody;
    }
    /** 请求体;请求体 */
    public void setApiBody(String apiBody){
        this.apiBody = apiBody;
    }
    /** 创建人;创建人 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人;创建人 */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间;创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间;创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 接口归属;接口关联 */
    public Integer getApiRelation(){
        return this.apiRelation;
    }
    /** 接口归属;接口关联 */
    public void setApiRelation(Integer apiRelation){
        this.apiRelation = apiRelation;
    }
    /** 更新人;更新人 */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** 更新人;更新人 */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** 更新时间;更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间;更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
    /** 所属系统;所属系统 */
    public Long getProductId(){
        return this.productId;
    }
    /** 所属系统;所属系统 */
    public void setProductId(Long productId){
        this.productId = productId;
    }
    /** 最后执行时间;最后执行时间 */
    public Date getLastrunTime(){
        return this.lastrunTime;
    }
    /** 最后执行时间;最后执行时间 */
    public void setLastrunTime(Date lastrunTime){
        this.lastrunTime = lastrunTime;
    }
    /** 接口状态;0:正常；1:未完成；-1:废弃 */
    public Integer getApiStatus(){
        return this.apiStatus;
    }
    /** 接口状态;0:正常；1:未完成；-1:废弃 */
    public void setApiStatus(Integer apiStatus){
        this.apiStatus = apiStatus;
    }
    /** 是否删除;0:未删除；1:已删除 */
    public String getIsdel(){
        return this.isdel;
    }
    /** 是否删除;0:未删除；1:已删除 */
    public void setIsdel(String isdel){
        this.isdel = isdel;
    }
    /** 执行次数;执行次数 */
    public Integer getRuntime(){
        return this.runtime;
    }
    /** 执行次数;执行次数 */
    public void setRuntime(Integer runtime){
        this.runtime = runtime;
    }
}
