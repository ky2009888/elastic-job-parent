package com.apps.job;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * 批量下载文件
 * Ctrl + Alt + L 格式化代码快捷键.
 * @author root
 */
@Slf4j(topic = "批量文件下载")
public class BatchDownloadFilesFromNets {
    /**
     * 下载完成文件之后存储的目录.
     */
    public static final String STORE_FILE_PATH = "/pics/";
    /**
     * 存储下载文件目录的文件路径.
     */
    public static final String SOURCE_FILE_PATH = "/root/下载/all.txt";

    public static void main(String[] args) {
        //downloadFilesWithProgress();
        batchDownLoadFiles();
    }

    /**
     * 批量下载文件.
     */
    private static void batchDownLoadFiles() {
        //默认UTF-8编码，可以在构造中传入第二个参数做为编码
        FileReader fileReader = new FileReader(SOURCE_FILE_PATH);
        List<String> filePathList = fileReader.readLines();
        for (String path : filePathList) {
            long size = HttpUtil.downloadFile(path, FileUtil.file(STORE_FILE_PATH));
            log.info("下载文件的大小：{}", size);
        }
    }

    /**
     * 带进度下载文件.
     */
    private static void downloadFilesWithProgress() {
        String fileUrl = "https://w.wallhaven.cc/full/rd/wallhaven-rdqyx7.jpg";
        //将文件下载后保存在E盘，返回结果为下载文件大小
        long size = HttpUtil.downloadFile(fileUrl, FileUtil.file("/pics/"), new StreamProgress() {
            @Override
            public void start() {
                log.info("文件开始下载--------------------------->");
            }

            @Override
            public void progress(long progressSize) {
                log.info("已下载：{}", FileUtil.readableFileSize(progressSize));
            }

            @Override
            public void finish() {
                log.info("文件下载完成<---------------------------");
            }
        });
        log.info("Download size: {}", size);
    }
}
