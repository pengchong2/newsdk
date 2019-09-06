package cn.flyaudio.otasdk.utils;

import java.io.UnsupportedEncodingException;

/**
*@author pengchong
*@date 2019/8/27
*@function  XTEA算法的实现
*/
public class XTEA {
	
    private static final int BLOCK_ALIGN = 8;
    private static final int KEY_LENGTH = 16;
    private static final int DELTA = 0x9E3779B9;
    private static final int NUM_ROUNDS = 64;
    private static int[] keys = new int[NUM_ROUNDS];
    private static byte[] ivtmp = new byte[BLOCK_ALIGN];
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5','6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    
    private static void setKey(byte[] b) {
        int[] key = new int[4];
        for (int i = 0; i < KEY_LENGTH;) {
            key[i / 4] = (b[i++] << 24) + ((b[i++] & 255) << 16) + ((b[i++] & 255) << 8) + (b[i++] & 255);
        }
        for (int i = 0, sum = 0; i < NUM_ROUNDS;) {
            keys[i++] = sum + key[sum & 3];
            sum += DELTA;
            keys[i++] = sum + key[(sum >>> 11) & 3];
        }
    }

    private static void setIV(byte[] b) {
        System.arraycopy(b, 0, ivtmp, 0, BLOCK_ALIGN);
    }

    private static byte[] padding(byte[] in, int len) {
        int lennew = len;
        int mod = len % BLOCK_ALIGN;
        if (mod != 0) {
            lennew = ((len + BLOCK_ALIGN) / BLOCK_ALIGN) * BLOCK_ALIGN;
        }
        byte[] innew = new byte[lennew];
        System.arraycopy(in, 0, innew, 0, len);

        return innew;
    }

    public static byte[] encrypt(byte[] key, byte[] iv, byte[] in, int len) {
        if (key.length != KEY_LENGTH) {
            throw new RuntimeException("invalid key length, should be length of 16");
        }
        if (iv.length % BLOCK_ALIGN != 0) {
            throw new RuntimeException("invalid iv length, should be length of 8");
        }
        setKey(key);
        setIV(iv);

        byte[] plain = padding(in, len);

        for (int i = 0; i < plain.length; i += BLOCK_ALIGN) {
            for (int j = 0; j < BLOCK_ALIGN; j++) {
                plain[i + j] = (byte) (plain[i + j] ^ ivtmp[j]);
            }
            encryptBlock(plain, plain, i);
            System.arraycopy(plain, i, ivtmp, 0, BLOCK_ALIGN);
        }
        return plain;
    }

    public static byte[] decrypt(byte[] key, byte[] iv, byte[] in, int len) {
        if (key.length != KEY_LENGTH) {
            throw new RuntimeException("invalid key length, should be length of 16");
        }
        if (iv.length % BLOCK_ALIGN != 0) {
            throw new RuntimeException("invalid iv length, should be length of 8");
        }
        if (len % BLOCK_ALIGN != 0) {
            throw new RuntimeException("invalid ciper length, should be multiple of 8");
        }
        setKey(key);
        setIV(iv);

        byte[] plain = new byte[len];
        byte[] tmp8 = new byte[BLOCK_ALIGN];
        for (int i = 0; i < len; i += BLOCK_ALIGN) {
            System.arraycopy(in, i, tmp8, 0, BLOCK_ALIGN);
            decryptBlock(in, plain, i);
            for (int j = 0; j < BLOCK_ALIGN; j++) {
                plain[i + j] = (byte) (plain[i + j] ^ ivtmp[j]);
            }
            System.arraycopy(tmp8, 0, ivtmp, 0, BLOCK_ALIGN);
        }
        return plain;
    }

    private static void encryptBlock(byte[] in, byte[] out, int off) {
        int y = (in[off] << 24) | ((in[off + 1] & 255) << 16) | ((in[off + 2] & 255) << 8) | (in[off + 3] & 255);
        int z = (in[off + 4] << 24) | ((in[off + 5] & 255) << 16) | ((in[off + 6] & 255) << 8) | (in[off + 7] & 255);
        for (int i = 0; i < NUM_ROUNDS; i += 2) {
            y += (((z << 4) ^ (z >>> 5)) + z) ^ keys[i];
            z += (((y >>> 5) ^ (y << 4)) + y) ^ keys[i + 1];
        }
        out[off] = (byte) (y >> 24);
        out[off + 1] = (byte) (y >> 16);
        out[off + 2] = (byte) (y >> 8);
        out[off + 3] = (byte) y;
        out[off + 4] = (byte) (z >> 24);
        out[off + 5] = (byte) (z >> 16);
        out[off + 6] = (byte) (z >> 8);
        out[off + 7] = (byte) z;
    }

    private static void decryptBlock(byte[] in, byte[] out, int off) {
        int y = (in[off] << 24) | ((in[off + 1] & 255) << 16) | ((in[off + 2] & 255) << 8) | (in[off + 3] & 255);
        int z = (in[off + 4] << 24) | ((in[off + 5] & 255) << 16) | ((in[off + 6] & 255) << 8) | (in[off + 7] & 255);
        for (int i = NUM_ROUNDS - 1; i >= 0; i -= 2) {
            z -= (((y >>> 5) ^ (y << 4)) + y) ^ keys[i];
            y -= (((z << 4) ^ (z >>> 5)) + z) ^ keys[i - 1];
        }
        out[off] = (byte) (y >> 24);
        out[off + 1] = (byte) (y >> 16);
        out[off + 2] = (byte) (y >> 8);
        out[off + 3] = (byte) y;
        out[off + 4] = (byte) (z >> 24);
        out[off + 5] = (byte) (z >> 16);
        out[off + 6] = (byte) (z >> 8);
        out[off + 7] = (byte) z;
    }

    public static String convertBytesToHex(byte[] bytes) {
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        for(byte b : bytes) {
            // 使用除与取余进行转换
            if(b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }

            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }
        return new String(buf);
    }
    
    public static byte[] toBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }
    /**
     *********************************************************   
     * @Title: getdecryptStr   
     * @Description: 解密后的字节数组转换成字符串   
     * @Param:  plain 解密后的字节数组
     * @Return: String 解密后的字符串      
     * @Author maojianyun
     **********************************************************
     */
    public static String getdecryptStr(byte[] plain) {
    	int len = 0;
        while (len < plain.length && plain[len] != 0) {
            len++;
        }
        byte[] p2 = new byte[len];
        System.arraycopy(plain, 0, p2, 0, len);
        String p = "";
        try {
            p = new String(p2, "utf-8");
        } catch (Exception e) {

        }
        return p;
    }

    /**
     *********************************************************
     * @Title: getdecryptStr
     * @Description: 把加密后的十六进制的字符串转换成解密后的字符串
     * @Param:  key
     * @Param:  iv
     * @Param:  HexStr
     * @Return: String
     * @Author maojianyun
     **********************************************************
     */
    public static String getDecryptStr(String key, String iv, String HexStr) {
        byte[] in = XTEA.toBytes(HexStr);
        byte[] plain = XTEA.decrypt(key.getBytes(), iv.getBytes(), in, in.length);
        String result = XTEA.getdecryptStr(plain);
        return result;
    }

    /**
     *********************************************************
     * @Title: getEncryptStr
     * @Description: 把字符串加密成十六进制的字符串
     * @Param: key
     * @Param: iv
     * @Param: HexStr
     * @Author maojianyun
     **********************************************************
     */
    public static String getEncryptStr(String key, String iv, String HexStr) {
        byte[] in = new byte[0];
        try {
            in = HexStr.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        byte[] cipher = encrypt(key.getBytes(), iv.getBytes(), in, in.length);
        return XTEA.convertBytesToHex(cipher);
    }

}
