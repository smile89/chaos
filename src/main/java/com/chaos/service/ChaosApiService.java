package com.chaos.service;

import com.chaos.common.JsonData;
import com.chaos.domain.ChaosApi;

import java.util.List;

public interface ChaosApiService {

    /** 新增API */
//    public Long saveApi(ChaosApi api);

    JsonData saveApi(ChaosApi api);

    /** 查找全部API接口 */
    List<ChaosApi> findAll();

    /** 通过id查找Api */
    ChaosApi findApiById(Long id);

    /** 更新Api信息 */
    JsonData updateApi(ChaosApi chaosApi);

}
