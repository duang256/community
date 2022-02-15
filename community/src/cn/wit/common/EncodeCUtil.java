package cn.wit.common;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密解密类
 * @author yueyan
 *
 */
public class EncodeCUtil {
    // 加密:
    public static String encrypt(String key, String input) {
        String rs = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] bytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
            rs = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    // 解密:
    public static String decrypt(String key, String input) {
        String rs = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(input));
            rs = new String(bytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}

