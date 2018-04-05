package com.jet.sms;

/**
 * Description:
 * <pre>
 * </pre>
 *
 * @author javahuang
 * @since 2017/12/22
 */
public interface SmsService {
    /**
     * @param tel 要发送的手机号
     * @param msg 发送的内容
     */
    void send(String tel, String msg);
}
