package com.huawei.business.story.IOdemo;

import java.io.*;

/**
 * @program: design_pattern
 * @description: 输入输出重定向
 * https://blog.csdn.net/weixin_33989780/article/details/92947607
 * FileReader 和FileWriter 用于读写文件；BufferedReader 和BufferdeWriter是具有缓冲功能的流，可以提高读写效率。
 * BufferedReader中有一重要的方法readLind（），该方法用于一次读取一行文本。
 * 转换流是一种字符流，只能实现字节流读写文本数据的时候，通过转换流来使用字符高效流的方法。而不能实现图片、音频等数据的读写。
 * InputStreamReader:理解上是字节流通向字符流的桥梁，使用上为：
 * 　BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * OutputStreamWriter:理解上是字符流通向字节流的桥梁，使用上还是通过字节流转成字符流：
 * BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
 * @author: 吴泽恩
 * @create: 2020-08-04 22:57
 **/
public class Redirecting {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/file.in"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("src/main/resources/file.out")));

        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            if ("wuzeen".equals(s)) {
                for (int i = 0; i < s.length(); i++) {
                    System.out.print(s.charAt(i) + ",");
                }
                System.out.println(" ");
            }
        }
        out.close();
        System.setOut(console);
    }
}
