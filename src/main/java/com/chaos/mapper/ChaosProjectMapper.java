package com.chaos.mapper;

import com.chaos.domain.ChaosProject;
import com.chaos.mapper.sql.ProjectSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ChaosProjectMapper {

    @Insert("INSERT INTO chaos_project (project_name, project_des, project_manager, created_by, created_time, updated_by, updated_time, isdel) VALUES (#{projectName}, #{projectDes}, #{projectManager}, #{createdBy}, #{createdTime}, #{updatedBy}, #{updatedTime}, #{isdel})")
    @ResultMap("projectMap")
    @Options(useGeneratedKeys = true, keyProperty = "projId", keyColumn = "proj_id")
        // 获取数据库自增主键
    int insert(ChaosProject project);

    /**
     * 根据id找对象
     *
     * @param projId
     * @return
     */
    @Select("SELECT * FROM chaos_project WHERE proj_id = #{projId}")
    @ResultMap("projectMap")
    ChaosProject findById(Long projId);


    /**
     * 更新对象
     * @param project
     * @return
     */
    @UpdateProvider(type = ProjectSql.class, method = "update")
    @ResultMap(value = "projectMap")
    void update(ChaosProject project);

    /**
     * 根据id删除项目
     *
     * @param projId
     */
    @Delete("DELETE FROM chaos_project WHERE proj_id = #{projId}")
    void deleteProjectById(Long projId);

    @Select("SELECT * FROM chaos_project")
    @Results(id = "projectMap", value = {
            @Result(property = "projId", column = "proj_id"),
            @Result(property = "projectName", column = "project_name"),
            @Result(property = "projectDes", column = "project_des"),
            @Result(property = "projectManager", column = "project_manager"),
            @Result(property = "createdBy", column = "created_by"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "updatedBy", column = "updated_by"),
            @Result(property = "updatedTime", column = "updated_time")
    })
    List<ChaosProject> getAllProject();

}
