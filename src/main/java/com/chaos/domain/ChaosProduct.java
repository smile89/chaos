package com.chaos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ChaosProduct implements Serializable {
    /** 产品ID */
    private Long productId ;
    /** 产品名称 */
    private String productName ;
    /** 产品描述 */
    private String productDes ;
    /** 产品负责人 */
    private String productManager ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updatedTime ;
    /** 删除标识;0:未删除；1:删除 */
    private String isdel ;
    /** 所属项目;所属项目 */
    private String projectId ;

    /** 产品ID */
    public Long getProductId(){
        return this.productId;
    }
    /** 产品ID */
    public void setProductId(Long productId){
        this.productId = productId;
    }
    /** 产品名称 */
    public String getProductName(){
        return this.productName;
    }
    /** 产品名称 */
    public void setProductName(String productName){
        this.productName = productName;
    }
    /** 产品描述 */
    public String getProductDes(){
        return this.productDes;
    }
    /** 产品描述 */
    public void setProductDes(String productDes){
        this.productDes = productDes;
    }
    /** 产品负责人 */
    public String getProductManager(){
        return this.productManager;
    }
    /** 产品负责人 */
    public void setProductManager(String productManager){
        this.productManager = productManager;
    }
    /** 创建人 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人 */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新人 */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** 更新人 */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
    /** 删除标识;0:未删除；1:删除 */
    public String getIsdel(){
        return this.isdel;
    }
    /** 删除标识;0:未删除；1:删除 */
    public void setIsdel(String isdel){
        this.isdel = isdel;
    }
    /** 所属项目;所属项目 */
    public String getProjectId(){
        return this.projectId;
    }
    /** 所属项目;所属项目 */
    public void setProjectId(String projectId){
        this.projectId = projectId;
    }
}
