package com.jet.mail.service;

import com.jet.mail.domain.MailEntity;

/**
 * Description:
 * <pre>
 * </pre>
 *
 * @author javahuang
 * @since 2017/12/22
 */
public interface MailService {

    /**
     * 发送邮件
     *
     * @param mailEntity
     */
    void send(MailEntity mailEntity);
}
