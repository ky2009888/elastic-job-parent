package com.app.job.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 文件属性类.
 *
 * @author root
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class FileCustom {
    /**
     * 标识
     文件类*/
    private String id;
    /**
     * 文件名
     */
    private String name;
    /**
     * 文件类型，如text、image、radio、vedio
     */
    private String type;
    /**
     * 文件内容
     */
    private String content;
    /**
     * 是否已备份
     */
    private Boolean backedUp = false;

    /**
     * 定义构造函数.
     * @param id 文件ID.
     * @param name 文件名称.
     * @param type 文件类型.
     * @param content 文件内容.
     */
    public FileCustom(String id, String name, String type, String content){
        this.id = id;
        this.name = name;
        this.type = type;
        this.content = content;
    }
}
