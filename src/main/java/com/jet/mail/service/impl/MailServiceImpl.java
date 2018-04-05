package com.jet.mail.service.impl;

import com.jet.fdfs.FileService;
import com.jet.mail.domain.MailEntity;
import com.jet.mail.service.MailService;
import com.jet.mail.spring.boot.autoconfigure.MailProperties;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.csource.common.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.nio.charset.Charset;

/**
 * Description:
 * <pre>
 * </pre>
 *
 * @author javahuang
 * @since 2017/12/24 上午10:49
 */
public class MailServiceImpl implements MailService {
    Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);


    private MailProperties properties;

    @Autowired
    private FileService fileService;

    public MailServiceImpl(MailProperties properties) {
        this.properties = properties;
    }

    @Async
    @Override
    public void send(MailEntity mailEntity) {
        try {
            Form form = Form.form();
            form.add("subject", mailEntity.getSubject());
            form.add("content", mailEntity.getContent());
            mailEntity.getTo().forEach(to -> {
                form.add("to", to);
            });
            if (mailEntity.getCopyTo() != null) {
                mailEntity.getCopyTo().forEach(copyTo -> {
                    form.add("copyTo", copyTo);
                });
            }
            if (mailEntity.getFileIds() != null) {
                mailEntity.getFileIds().forEach(fileId -> {
                    form.add("fileNames", getFileNameWithFileId(fileId));
                    form.add("filePaths", fileId);
                });
            }
            String responce = Request.Post(properties.getServerRequestUrl())
                    .bodyForm(form.build(), Charset.forName("utf-8"))
                    .execute().returnContent().asString();
            if (!"success".equals(responce)) {
                logger.error("发送邮件失败，{}", responce);
                throw new RuntimeException(responce);
            }
            logger.info("发送邮件成功，{}", mailEntity);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("发送邮件失败", e);
            throw new RuntimeException(" 邮件发送失败", e);
        }
    }

    private String getFileNameWithFileId(String fileId) {
        NameValuePair[] pairs = fileService.getFileMetaData(fileId);
        if (pairs == null) {
            return null;
        }
        for (NameValuePair pair : pairs) {
            if ("name".equals(pair.getName())) {
                return pair.getValue();
            }
        }
        return null;
    }
}
