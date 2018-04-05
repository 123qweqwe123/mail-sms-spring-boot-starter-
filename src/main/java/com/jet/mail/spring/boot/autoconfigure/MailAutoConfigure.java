package com.jet.mail.spring.boot.autoconfigure;

import com.jet.fdfs.spring.boot.autoconfigure.FastDfsAutoConfigure;
import com.jet.mail.service.MailService;
import com.jet.mail.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
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
@EnableConfigurationProperties(MailProperties.class)
@AutoConfigureAfter(FastDfsAutoConfigure.class)
public class MailAutoConfigure {

    @Autowired
    private MailProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public MailService mailService() {
        return new MailServiceImpl(properties);
    }

}
