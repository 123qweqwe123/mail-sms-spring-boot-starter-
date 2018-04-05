package com.jet.mail.domain;

import java.util.List;

/**
 * Description:
 * <pre>
 * </pre>
 *
 * @author javahuang
 * @since 2017/12/22
 */
public class MailEntity {

    /**
     * 邮件标题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 收件人
     */
    private List<String> to;
    /**
     * 抄送
     */
    private List<String> copyTo;
    /**
     * 附件列表(上传到文件服务器)
     */
    private List<String> fileIds;

    public String getSubject() {
        return subject;
    }

    public MailEntity setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getContent() {
        return content;
    }

    public MailEntity setContent(String content) {
        this.content = content;
        return this;
    }

    public List<String> getTo() {
        return to;
    }

    public MailEntity setTo(List<String> to) {
        this.to = to;
        return this;
    }

    public List<String> getCopyTo() {
        return copyTo;
    }

    public MailEntity setCopyTo(List<String> copyTo) {
        this.copyTo = copyTo;
        return this;
    }

    public List<String> getFileIds() {
        return fileIds;
    }

    public MailEntity setFileIds(List<String> fileIds) {
        this.fileIds = fileIds;
        return this;
    }

    @Override
    public String toString() {
        return "邮件内容{" +
                "标题='" + subject + '\'' +
                ", 内容='" + content + '\'' +
                ", 收件人=" + to +
                ", 抄送=" + copyTo +
                ", 附件列表=" + fileIds +
                '}';
    }
}
