package tw.com.bryant.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
// 執行緒配置類
public class AsyncTaskConfig implements AsyncConfigurer {
    // ThredPoolTaskExcutor的處理流程
    // 當池子大小小於corePoolSize，就新建執行緒，並處理請求
    // 當池子大小等於corePoolSize，把請求放入workQueue中，池子裡的空閒執行緒就去workQueue中取任務並處理
    // 當workQueue放不下任務時，就新建執行緒入池，並處理請求，如果池子大小撐到了maximumPoolSize，就用RejectedExecutionHandler來做拒絕處理
    // 當池子的執行緒數大於corePoolSize時，多餘的執行緒會等待keepAliveTime長時間，如果無請求可處理就自行銷燬
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncTaskConfig.class);

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        LOGGER.debug("Creating Async Task Executor");
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("CarThread-");
        executor.initialize();
        return executor;
    }
}
