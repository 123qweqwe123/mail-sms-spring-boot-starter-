package com.jet.sms.impl;

import com.bdcore.webservice.client.MsgClient;
import com.bdcore.webservice.client.SendResultCallback;
import com.bdcore.webservice.client.bean.MsgOfSend;
import com.bdcore.webservice.client.config.ClientConfig;
import com.jet.sms.SmsService;
import com.jet.sms.spring.boot.autoconfigure.SmsProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.PostConstruct;

/**
 * Description:
 * <pre>
 * </pre>
 *
 * @author javahuang
 * @since 2017/12/22
 */
public class SmsServiceImpl implements SmsService {
    Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    private MsgClient client;
    private SmsProperties properties;

    public SmsServiceImpl() {
    }

    public SmsServiceImpl(SmsProperties properties) {
        this.properties = properties;

    }

    @PostConstruct
    private void initClient() {
        if (client == null) {
            ClientConfig config = new ClientConfig();
            config.put(ClientConfig.MSG_SERVER_IP, properties.getMsgServerIp());
            config.put(ClientConfig.MSG_SERVER_PORT, properties.getMsgServerPort());
            config.put(ClientConfig.PROJ_ID, properties.getProjectId());
            config.put(ClientConfig.REPLY_SERVER_IP, properties.getMsgReplyIp());
            config.put(ClientConfig.REPLY_SERVER_PORT, properties.getMsgReplyPort());
            config.put(ClientConfig.SEND_STATUS_SERVER_IP, properties.getMsgSendStatusIp());
            config.put(ClientConfig.SEND_STATUS_SERVER_PORT, properties.getMsgSendStatusPort());
            config.put(ClientConfig.MSG_SEND_SUBCODE, "03");
            config.put(ClientConfig.MSG_SIGN, properties.getMsgSign());

            client = new MsgClient(config);
            client.start();
        }
    }

    /**
     * 调用短信服务，该操作是异步的
     *
     * @param tel 要发送的手机号
     * @param msg 发送的内容
     */
    @Override
    @Async
    public void send(String tel, String msg) {
        if (StringUtils.isBlank(tel) || StringUtils.isBlank(msg)) {
            throw new RuntimeException("发送短信手机号或者内容不能为空");
        }
        MsgOfSend sendMsg = new MsgOfSend();
        sendMsg.setTel(tel);
        sendMsg.setContent(msg);
        sendMsg.setLinkId("linkid");
        if (client == null) {
            initClient();
        }
        double i = Math.random();
        client.send(sendMsg, new SendResultCallback() {
            @Override
            public void callback(int result, String resultMsg, MsgOfSend msgOfSend) {
                if (result == 1) {
                    logger.info("短信发送成功");
                } else {
                    logger.error("短信发送失败,{},{}", result, resultMsg);
                }
            }
        });
    }
}
