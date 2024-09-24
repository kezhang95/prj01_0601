package com.example.distributionlock.test;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: C240924
 * @Author: k.z
 * @CreateTime: 2024/9/24 15:31
 * @Description:
 */
public class C240924 {
    public static void main(String[] args) {
        String text = "helloWorld";
        String binary = text2binary(text);
        System.out.println("输出二进制结果："+binary);
    }

    private static String text2binary(String text) {

        byte[] bytes = text.getBytes();
        StringBuilder binaryBuilder = new StringBuilder();
        for (byte b : bytes){
            //%8s指的是长度为8位的字符串
            binaryBuilder.append(String.format("%8s",Integer.toBinaryString(b&0xFF)).replace(" ","0"));
        }
        return binaryBuilder.toString();
    }
}
