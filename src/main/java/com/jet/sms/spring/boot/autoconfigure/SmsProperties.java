package com.jet.sms.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description:
 * <pre>
 * </pre>
 *
 * @author javahuang
 * @since 2017/12/22
 */
@ConfigurationProperties(prefix = "third-service.sms")
public class SmsProperties {

    private String msgServerIp;
    private String msgServerPort ="3212";
    private String msgServerSubCode ="03";
    private String msgReplyIp;
    private String msgReplyPort="12302";
    private String msgSendStatusIp;
    private String msgSendStatusPort="12303";
    private String msgSign;
    private String projectId;

    public String getMsgServerIp() {
        return msgServerIp;
    }

    public void setMsgServerIp(String msgServerIp) {
        this.msgServerIp = msgServerIp;
    }

    public String getMsgServerPort() {
        return msgServerPort;
    }

    public void setMsgServerPort(String msgServerPort) {
        this.msgServerPort = msgServerPort;
    }

    public String getMsgServerSubCode() {
        return msgServerSubCode;
    }

    public void setMsgServerSubCode(String msgServerSubCode) {
        this.msgServerSubCode = msgServerSubCode;
    }

    public String getMsgReplyIp() {
        return msgReplyIp;
    }

    public void setMsgReplyIp(String msgReplyIp) {
        this.msgReplyIp = msgReplyIp;
    }

    public String getMsgReplyPort() {
        return msgReplyPort;
    }

    public void setMsgReplyPort(String msgReplyPort) {
        this.msgReplyPort = msgReplyPort;
    }

    public String getMsgSendStatusIp() {
        return msgSendStatusIp;
    }

    public void setMsgSendStatusIp(String msgSendStatusIp) {
        this.msgSendStatusIp = msgSendStatusIp;
    }

    public String getMsgSendStatusPort() {
        return msgSendStatusPort;
    }

    public void setMsgSendStatusPort(String msgSendStatusPort) {
        this.msgSendStatusPort = msgSendStatusPort;
    }

    public String getMsgSign() {
        return msgSign;
    }

    public void setMsgSign(String msgSign) {
        this.msgSign = msgSign;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
