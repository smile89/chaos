package com.chaos.service.impl;

import com.chaos.domain.ChaosProject;
import com.chaos.mapper.ChaosProjectMapper;
import com.chaos.service.ChaosProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChaosProjectServiceImpl implements ChaosProjectService {
    @Autowired
    private ChaosProjectMapper chaosProjectMapper;
    /**
     * 插入项目
     *
     * @param project
     * @return
     */
    @Override
    public Long addProject(ChaosProject project) {
        chaosProjectMapper.insert(project);
        return project.getProjId();
    }

    /**
     * 测试事务
     *
     * @param project
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long addProject1(ChaosProject project) {
        chaosProjectMapper.insert(project);
        Long proj_id = project.getProjId();
        int i = 10/0;
        return proj_id;
    }

    @Override
    public Object getAll() {
        return chaosProjectMapper.getAllProject();
    }

    @Override
    public void update(ChaosProject project) {
        chaosProjectMapper.update(project);
    }

    /**
     * 根据项目Id删除项目
     *
     * @param projId
     */
    @Override
    public void delete(Long projId) {
        chaosProjectMapper.deleteProjectById(projId);
    }
}
