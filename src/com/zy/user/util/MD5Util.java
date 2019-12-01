package com.zy.user.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/**
 * 1.MD5�����ַ�32λ��д��
 * 2.MD5�����ַ�32λСд��
 * <p>
 * MD5���߼��ܣ�https://md5jiami.51240.com/
 * 3.���������ֽ�����ת��Ϊʮ������ַ�
 * 4.Unicode���ı���ת�����ַ�
 */
public class MD5Util {
 
    /**
     * MD5�����ַ�32λ��д��
     *
     * @param string ��Ҫ����MD5���ܵ��ַ�
     * @return ���ܺ���ַ���д��
     */
    public static String md5Encrypt32Upper(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString().toUpperCase();
    }
 
    /**
     * MD5�����ַ�32λСд��
     *
     * @param string ��Ҫ����MD5���ܵ��ַ�
     * @return ���ܺ���ַ�Сд��
     */
    public static String md5Encrypt32Lower(String string) {
        byte[] hash;
        try {
            //����һ��MD5�㷨���󣬲����MD5�ֽ�����,16*8=128λ
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }
 
        //ת��Ϊʮ������ַ�
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString().toLowerCase();
    }
 
    /**
     * ���������ֽ�����ת��Ϊʮ������ַ�
     *
     * @param bytes �������ֽ�����
     * @return ʮ������ַ�
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if (num < 0) {
                num += 256;
            }
            if (num < 16) {
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }
 
    /**
     * Unicode���ı���ת�����ַ�
     */
    public static String unicodeToString(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }
}