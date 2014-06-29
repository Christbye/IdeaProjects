package org.tfm.util;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.model.ObjectMetadata;
import com.baidu.inf.iis.bcs.model.X_BS_ACL;
import com.baidu.inf.iis.bcs.request.PutObjectRequest;
import com.baidu.inf.iis.bcs.response.BaiduBCSResponse;

import java.io.File;

/**
 * Created by christ on 14-6-29.
 * Make move.
 */
public class BCSUtil {
    private static BaiduBCS baiduBCS;
    // ----------------------------------------
    private static String dir = "/media";

    static{
        String secretKey = "khhboBuxIUi2HFAAD1rplgpsMQYKSGZI";
        String accessKey = "1s7tdhG2o0VbwoMjVmVaE3Y6";
        BCSCredentials credentials = new BCSCredentials(accessKey, secretKey);
        String host = "bcs.duapp.com";
        baiduBCS = new BaiduBCS(credentials, host);
        baiduBCS.setDefaultEncoding("UTF-8");
    }
    public static void setDir(String dir){
        BCSUtil.dir = dir;
    }

//    public static void main(String[] args) {
//        putObjectByFile(new File("/etc/profile"),dir);
//    }

    public static void putObjectByFile( File file, String dir)
    {
        String bucket = "tigerresource";
        PutObjectRequest request = new PutObjectRequest(bucket, dir+File.separator+file.getName(), file);
        request.setAcl(X_BS_ACL.PublicRead);
        ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setContentType("text/html");
        request.setMetadata(metadata);
        BaiduBCSResponse<ObjectMetadata> response = baiduBCS.putObject(request);
        ObjectMetadata objectMetadata = response.getResult();
        objectMetadata.getVersionId();
    }
    public static void putObjectByFile(File file){
        putObjectByFile(file,dir);
    }
}
