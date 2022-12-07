package com.zcreate.datax.plugin.writer.kafkawriter;

/**
 * @author cw
 * @date : 2022/12/7
 * @description: 类型
 * @email: smallmartial@qq.com
 */
public enum WriteType {
    /**
     * 类型
     */
    JSON("json"),
    TEXT("text");

    private String name;

    WriteType(String name) {
        this.name = name;
    }
}

