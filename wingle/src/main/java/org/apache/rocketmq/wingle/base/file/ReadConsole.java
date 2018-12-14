package org.apache.rocketmq.wingle.base.file;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * org.apache.rocketmq.wingle.base
 *
 * @author Wingle
 * @create 2018/12/9 1:36 AM
 **/
public class ReadConsole {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = null;

        try {
            in = new InputStreamReader(System.in);
            System.out.println("Enter characters, 'q' to quit.");

            char c;
            do {
                c = (char) in.read();
                System.out.print(c);
            } while (c != 'q');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                in.close();
            }
        }
    }
}
