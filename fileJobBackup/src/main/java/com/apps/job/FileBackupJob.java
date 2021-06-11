package com.apps.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件备份定时任务
 *
 * @author root
 */
@Slf4j(topic = "文件备份")
public class FileBackupJob implements SimpleJob {
    /**
     * 每次任务执行要备份的文件数量.
     */
    private final static int FETCH_SIZE = 1;
    /**
     * 定义文件名称列表.
     */
    public static final List<FileCustom> files = new ArrayList<>();
    /**
     * 执行作业.
     *
     * @param shardingContext 分片上下文
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        //作业分片信息
        int shardingItem = shardingContext.getShardingItem();
        log.info("作业分片：{}",shardingItem);
        //获取未备份的文件
        List<FileCustom> fileCustoms = fetchUnBackupFiles(FETCH_SIZE);
        //文件备份
        backupFiles(fileCustoms);
    }

    /**
     * 获取未备份的文件列表.
     * @param count 文件数量.
     * @return 文件列表.
     */
    public List<FileCustom> fetchUnBackupFiles(int count){
        List<FileCustom> fetchList = new ArrayList<>();
        int num = 0;
        for(FileCustom fileCustom:files){
            if(num>=count){
                break;
            }
            //未备份的文件则放入列表
            if(!fileCustom.getBackedUp()){
                fetchList.add(fileCustom);
                num++;
            }
        }
        //ManagementFactory.getRuntimeMXBean()获取当前JVM进程的PID
        log.info("{}Time:{},已获取{}文件", ManagementFactory.getRuntimeMXBean().getName(),new SimpleDateFormat("hh:mm:ss").format(new
                        Date()),num);
        return fetchList;
    }
    /**
     * 备份文件
     *
     * @param files 文件名称列表.
     */
    public void backupFiles(List<FileCustom> files){
        for(FileCustom file : files){
            //标记文件数据为已备份
            file.setBackedUp(Boolean.TRUE);
            log.info("已备份文件: {}:{} 型: {}",file.getId(),file.getName(),file.getType());
        }
    }
}
