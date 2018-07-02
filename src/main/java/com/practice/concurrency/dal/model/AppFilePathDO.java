package com.practice.concurrency.dal.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AppFilePathDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     * app_file_path.file_id
     */
    private Long fileId;

    /**
     * app名
     * app_file_path.app_name
     */
    private String appName;

    /**
     * 文件路径
     * app_file_path.file_path
     */
    private String filePath;

    /**
     * app_file_id
     * app_file_path.app_file_id
     */
    private String appFileId;

}