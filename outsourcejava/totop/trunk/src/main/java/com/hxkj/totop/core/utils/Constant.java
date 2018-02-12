package com.hxkj.totop.core.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by huzhihui on 2016/4/25.
 */
public class Constant {

    static{
        String path = Constant.class.getClassLoader().getResource("config.properties").getPath();
        FileInputStream in = null;
        try {
            in = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(in);
            IMAGE_ROOT_URL = prop.getProperty("IMAGE_ROOT_URL");
            IMAGE_SERVER_URL = prop.getProperty("IMAGE_SERVER_URL");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 服务器文件存储的物理目录
     */
    public static String IMAGE_ROOT_URL;

    /**
     * 服务器的访问路径
     */
    public static String IMAGE_SERVER_URL;

}
