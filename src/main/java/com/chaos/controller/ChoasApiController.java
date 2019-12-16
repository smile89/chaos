package com.chaos.controller;

import com.chaos.domain.ChaosApi;
import com.chaos.service.ChaosApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1/api")
public class ChoasApiController {

    @Autowired
    private ChaosApiService chaosApiService;

    /**
     * 添加api
     *
     * @return
     */
    @GetMapping("add")
    public Object saveApiInfo() {
        ChaosApi api = new ChaosApi();
        api.setApiType(1);
        api.setApiName("test_API");
        api.setApiMethod("POST");
        api.setApiPath("https://www.baidu.com");
        api.setApiBody("{}");
        api.setCreatedBy("王阳");
        api.setCreatedTime(new Date());
        api.setUpdatedBy("王阳");
        api.setUpdatedTime(new Date());
        api.setProductId((long) 1);
        return chaosApiService.saveApi(api);
    }

    @GetMapping("findall")
    public List<ChaosApi> findAllApi() {
        return chaosApiService.findAll();
    }

    @GetMapping("getone")
    public Object findApi(Long id){
       return chaosApiService.findApiById(id);
    }


    @GetMapping("update")
    public Object updateApiInfo(Long id){
        ChaosApi chaosApi = new ChaosApi();
        chaosApi.setId(id);
        chaosApi.setApiName("测试数据更新");
        return chaosApiService.updateApi(chaosApi);
    }

}
