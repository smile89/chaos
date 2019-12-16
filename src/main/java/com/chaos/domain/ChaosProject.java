package com.chaos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChaosProject implements Serializable {

    /** 项目ID */
    private Long projId ;
    /** 项目名称 */
    private String projectName ;
    /** 项目描述 */
    private String projectDes ;
    /** 项目负责人 */
    private String projectManager ;
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
    /** 删除标识 */
    private Byte isdel ;

    public ChaosProject(Long projId, String projectName, String projectDes, String projectManager, String createdBy, Date createdTime, String updatedBy, Date updatedTime, Byte isdel) {
        this.projId = projId;
        this.projectName = projectName;
        this.projectDes = projectDes;
        this.projectManager = projectManager;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.isdel = isdel;
    }

    public ChaosProject() {
    }

    /** 项目ID */
    public Long getProjId(){
        return this.projId;
    }
    /** 项目ID */
    public void setProjId(Long projId){
        this.projId = projId;
    }
    /** 项目名称 */
    public String getProjectName(){
        return this.projectName;
    }
    /** 项目名称 */
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    /** 项目描述 */
    public String getProjectDes(){
        return this.projectDes;
    }
    /** 项目描述 */
    public void setProjectDes(String projectDes){
        this.projectDes = projectDes;
    }
    /** 项目负责人 */
    public String getProjectManager(){
        return this.projectManager;
    }
    /** 项目负责人 */
    public void setProjectManager(String projectManager){
        this.projectManager = projectManager;
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
    /** 删除标识 */
    public Byte getIsdel(){
        return this.isdel;
    }
    /** 删除标识 */
    public void setIsdel(Byte isdel){
        this.isdel = isdel;
    }
}
