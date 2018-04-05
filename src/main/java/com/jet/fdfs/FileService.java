package com.jet.fdfs;

import org.csource.common.NameValuePair;

import java.util.Map;

/**
 * Description:
 * <pre>
 * </pre>
 *
 * @author javahuang
 * @since 2017/12/24 上午10:52
 */
public interface FileService {

    /**
     * @param bytes   上传文件字节流
     * @param extName 文件拓展名
     * @param pairs   文件元数据，不能为空，且必须包含 name="name" 的 pair
     * @return
     */
    String uploadFile(byte[] bytes, String extName, NameValuePair[] pairs);


    boolean uploadFileWithMetaData();


    byte[] downloadFile(String fileId);

    /**
     * 下载文件，同时获取文件元信息
     *
     * @param fileId 上传文件的 ID
     * @return
     */
    Map<String, Object> downloadFileWithMetaData(String fileId);

    NameValuePair[] getFileMetaData(String fileId);
}
