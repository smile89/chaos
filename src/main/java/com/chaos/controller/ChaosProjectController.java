package com.chaos.controller;

import com.chaos.domain.ChaosProject;
import com.chaos.common.JsonData;
import com.chaos.service.ChaosProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/project")
public class ChaosProjectController {

    @Autowired
    private ChaosProjectService chaosProjectService;

    @GetMapping("add")
    public Object addProj() {
        ChaosProject project = new ChaosProject();
        project.setProjId(0L);
        project.setProjectName("测试项目");
        project.setProjectDes("测试项目测试项目");
        project.setProjectManager("王阳");
        project.setCreatedBy("王阳");
        project.setCreatedTime(new Date());
        project.setUpdatedTime(new Date());
        project.setUpdatedBy("王阳");
        project.setIsdel((byte) 0);
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("proj_id", chaosProjectService.addProject(project));
            return JsonData.buildSuccess(map, "保存成功");
        } catch (Exception e) {
            return JsonData.buildError("保存失败");
        }
    }

    /**
     * 测试事务
     *
     * @return
     */
    @GetMapping("testTrans")
    public Object addProj1() {
        ChaosProject project = new ChaosProject();
        project.setProjId(0L);
        project.setProjectName("测试项目");
        project.setProjectDes("测试项目测试项目");
        project.setProjectManager("王阳");
        project.setCreatedBy("王阳");
        project.setCreatedTime(new Date());
        project.setUpdatedTime(new Date());
        project.setUpdatedBy("王阳");
        project.setIsdel((byte) 0);
        Long projId = chaosProjectService.addProject1(project);
        return JsonData.buildSuccess(projId);
    }

    /**
     * 获取全部的项目
     *
     * @return
     */
    @GetMapping("all")
    public Object getAllProject() {
        return JsonData.buildSuccess(chaosProjectService.getAll());
    }

    /**
     * 更新项目信息
     *
     * @param projid
     */
    @GetMapping("update")
    public void updateProject(Long projid) {
        ChaosProject project = new ChaosProject();
        project.setProjId(projid);
        project.setProjectName("修改名称");
//        project.setProjectDes("测试项目测试项目");
//        project.setProjectManager("王阳");
        chaosProjectService.update(project);
    }


    /**
     * 根据项目ID删除项目
     *
     * @param projId
     */
    @GetMapping("del")
    public Object deleteProject(Long projId) {
        try {
            chaosProjectService.delete(projId);
            return JsonData.buildSuccess("删除成功");
        }catch (Exception e){
            return JsonData.buildError("删除失败");
        }

    }
}
