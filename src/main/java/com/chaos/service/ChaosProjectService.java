package com.chaos.service;

import com.chaos.domain.ChaosProject;
import org.springframework.stereotype.Service;

public interface ChaosProjectService {
    /**插入项目
     * @return*/
     public Long addProject(ChaosProject project);

    /**
     * 测试事务
     * @param project
     * @return
     */
     public Long addProject1(ChaosProject project);

     /**获取全部项目*/
     public Object getAll();

    /**
     * 更新项目信息
     * @param project
     */
     public void update(ChaosProject project);


    /**
     * 根据项目Id删除项目
     * @param projId
     */
    public void delete(Long projId);

}
