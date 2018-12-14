package org.apache.rocketmq.wingle.base.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * org.apache.rocketmq.wingle.base
 *
 * @author Wingle
 * @create 2018/12/9 1:25 AM
 **/
public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
           in = new FileInputStream("/code/tmp/input.txt");
           out = new FileOutputStream("/code/tmp/output.txt");

           int c;
           while (-1 != (c = in.read()) ) {
               out.write(c);
           }
        } finally {
            if (null != in) {
                in.close();
            }
            if (null != out) {
                out.close();
            }
        }
    }
}
