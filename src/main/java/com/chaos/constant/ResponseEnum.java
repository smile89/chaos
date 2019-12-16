package com.chaos.constant;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    /**
     * 错误码描述
     */
    E01("E00001", "项目名称不能为空"),
    E02("E00002", "项目负责人不能为空"),
    E03("E00003", "API名称已存在"),
    ;

    private String code;
    private String msg;

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
