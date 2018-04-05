package com.jet.fdfs.spring.boot.autoconfigure;

import com.jet.fdfs.FileService;
import com.jet.fdfs.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * <pre>
 * </pre>
 *
 * @author javahuang
 * @since 2017/12/22
 */
@Configuration
@EnableConfigurationProperties(FastDfsProperties.class)
public class FastDfsAutoConfigure {

    @Autowired
    private FastDfsProperties properties;

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean
    public FileService fileService() {
        return new FileServiceImpl(properties);
    }
}
