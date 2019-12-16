package com.chaos.service.impl;

import com.chaos.common.JsonData;
import com.chaos.constant.ResponseEnum;
import com.chaos.domain.ChaosApi;
import com.chaos.mapper.ChaosApiMapper;
import com.chaos.service.ChaosApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChaosApiServiceImpl implements ChaosApiService {

    /**
     * 常见的隔离级别，传播行为
     * 隔离级别
     * 		Serializable： 最严格，串行处理，消耗资源大
     * 		Repeatable Read：保证了一个事务不会修改已经由另一个事务读取但未提交（回滚）的数据
     * 		Read Committed：大多数主流数据库的默认事务等级
     * 		Read Uncommitted：保证了读取过程中不会读取到非法数据。
     * 	常见的传播行为
     * 		PROPAGATION_REQUIRED--支持当前事务，如果当前没有事务，就新建一个事务,最常见的选择。
     *
     * 		PROPAGATION_SUPPORTS--支持当前事务，如果当前没有事务，就以非事务方式执行。
     *
     * 		PROPAGATION_MANDATORY--支持当前事务，如果当前没有事务，就抛出异常。
     *
     * 		PROPAGATION_REQUIRES_NEW--新建事务，如果当前存在事务，把当前事务挂起, 两个事务之间没有关系，一个异常，一个提交，不会同时回滚
     *
     * 		PROPAGATION_NOT_SUPPORTED--以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     *
     * 		PROPAGATION_NEVER--以非事务方式执行，如果当前存在事务，则抛出异常
     */

    @Autowired
    private ChaosApiMapper chaosApiMapper;

    /**
     * 新增API
     *
     * @param api
     * @return
     */
    @Override
    public JsonData saveApi(ChaosApi api) {
        int count = 0;
        try {
            count = chaosApiMapper.checkApiExist(api.getApiName());
            if (0 == count) {
                chaosApiMapper.insert(api);
                return JsonData.buildSuccess("API保存成功");
            } else {
                return JsonData.buildError("API已存在");
            }

        } catch (Exception e) {
            return JsonData.buildError("API保存失败");
        }
    }

    /**
     * 查找全部API接口
     */
    @Override
    public List<ChaosApi> findAll() {
        return chaosApiMapper.findAll();
    }

    /**
     * 通过id查找Api
     *
     * @param id
     */
    @Override
    public ChaosApi findApiById(Long id) {
        return chaosApiMapper.selectById(id);
    }

    /**
     * 更新Api信息
     *
     * @param chaosApi
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)   // 添加事务，隔离级别
    public JsonData updateApi(ChaosApi chaosApi) {
        // TODO: 2019/12/10 重复名称校验
        try {

            chaosApiMapper.update(chaosApi);
            return JsonData.buildSuccess("Api更新成功");

        } catch (Exception e) {
            return JsonData.buildError("Api更新失败");
        }
    }
}
