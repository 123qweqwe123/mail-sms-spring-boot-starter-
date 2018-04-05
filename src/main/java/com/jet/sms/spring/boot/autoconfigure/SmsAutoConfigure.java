package com.jet.sms.spring.boot.autoconfigure;

import com.jet.sms.SmsService;
import com.jet.sms.impl.SmsServiceImpl;
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
@EnableConfigurationProperties(SmsProperties.class)
public class SmsAutoConfigure {

    @Autowired
    private SmsProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public SmsService smsService() {
        return new SmsServiceImpl(properties);
    }
}
