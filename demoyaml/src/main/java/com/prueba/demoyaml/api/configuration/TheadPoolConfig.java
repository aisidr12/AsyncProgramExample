package com.prueba.demoyaml.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ConfigurationProperties(prefix = "threading.config")
@EnableAsync
public class TheadPoolConfig {
    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;


//    @Bean
//    public ThreadPoolExecutor getDebitCustomerTaskExecutor() {
//        return buildContextAwareThreadPool("getDebitCustomerTaskExecutor");
//    }
//
//    private ThreadPoolExecutor buildContextAwareThreadPool(String threadNamePrefix) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 3000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1));
//        return threadPoolExecutor;
//    }

    @Bean
    public ThreadPoolTaskExecutor getProductsExecutor() {
        return buildContextAwareThreadPool("getProductsExecutor");
    }

    private ThreadPoolTaskExecutor buildContextAwareThreadPool(String threadNamePrefix) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // los core de tu pc
        executor.setMaxPoolSize(2); // maximo de hilos que se van a crear despues que los hilos estan ocupados.
        executor.setQueueCapacity(100); // maximo de hilos que estan a la espera para estar atendidos
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }


    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // los core de tu pc
        executor.setMaxPoolSize(2); // maximo de hilos que se van a crear despues que los hilos estan ocupados.
        executor.setQueueCapacity(100); // maximo de hilos que estan a la espera para estar atendidos
        executor.setThreadNamePrefix("AsyncThread-");
        executor.initialize();
        return executor;
    }


}

