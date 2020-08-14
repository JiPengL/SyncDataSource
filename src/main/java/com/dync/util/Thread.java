package com.dync.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author liujipeng
 * @date 2020/6/16 17:06
 * @mail liujipeng
 * @desc ... @Bean 实现的对象默认以方法名为名
 */
@Configuration
public class Thread {

    @Bean
    public Executor ssdsd(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        return executor;
    }

    @Bean(name = "ssssd")
    public Executor sdsdsd(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        return executor;
    }





}
