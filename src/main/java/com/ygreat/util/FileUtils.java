package com.ygreat.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Classname FileUtils
 * Date 2024/8/22 23:03
 * Created by y_great
 */
@Slf4j
public class FileUtils {

    /**
     * 读取文件到string
     * return
     * */
    public static String readFile2String(File file) {
        String data = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] byt = new byte[4096];
            int len = fis.read(byt);
            data = new String(byt, 0, len);
            fis.close();
        } catch (IOException e1) {
            log.error("读取文件报错：{}",e1.getMessage());
        }
        return data;
    }
}
