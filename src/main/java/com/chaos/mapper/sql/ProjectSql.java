package com.chaos.mapper.sql;

import com.chaos.domain.ChaosProject;
import io.netty.util.internal.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Objects;

public class ProjectSql extends SQL {
    private static final String TABLE_NAME = "chaos_project";
    public String update(@Param("project") ChaosProject project){
           return new SQL() {
               {
                   UPDATE(TABLE_NAME);
                   if (!StringUtil.isNullOrEmpty(project.getProjectName())){
                       SET("project_name=#{projectName}");
                   }
                   if (!StringUtil.isNullOrEmpty(project.getProjectDes())){
                       SET("project_des=#{projectDes}");
                   }
                   if (!StringUtil.isNullOrEmpty(project.getProjectManager())){
                       SET("project_manager=#{projectManager}");
                   }
                   if (!StringUtil.isNullOrEmpty(project.getUpdatedBy())){
                       SET("updated_by=#{updatedBy}");
                   }
                   if (Objects.nonNull(project.getUpdatedTime())){
                       SET("updated_time=#{updatedTime}");
                   }
                   WHERE("proj_id=#{projId}");
               }
           }.toString();
    }
}
