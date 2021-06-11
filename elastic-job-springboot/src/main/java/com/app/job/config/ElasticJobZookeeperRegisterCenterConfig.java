package com.app.job.config;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * elastic job 配置类.
 *
 * @author root
 */
@Configuration
public class ElasticJobZookeeperRegisterCenterConfig {
    /**
     * 定义zookeeper服务器地址.
     */
    public static final String ZOOKEEPER_SERVER_ADDRESS_LIST = "h7:2181";
    /**
     * 定义elastic job的zookeeper命名空间.
     */
    public static final String ZOOKEEPER_ELASTIC_JOB_NAMESPACE = "elastic-job-exmaple-springboot";

    /**
     * 对注册中心进行配置.
     *
     * @return CoordinatorRegistryCenter.
     */
    @Bean(initMethod = "init")
    public CoordinatorRegistryCenter createRedisterCenter() {
        //配置zookeeper注册中心.
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(ZOOKEEPER_SERVER_ADDRESS_LIST, ZOOKEEPER_ELASTIC_JOB_NAMESPACE);
        //设置会话失效时间为100毫秒
        zookeeperConfiguration.setSessionTimeoutMilliseconds(100);
        //zookeeper的注册中心
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }
}
