package com.tunnel.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Utility class to handle encryption & decryption
 */
public final class EncryptionUtil {

    /**
     * App key used for encrypting/decrypting purpose
     */
    private static final byte[] APP_KEY = "#$oc!al_m!nd@$".getBytes();

    private static final EncryptionUtil INSTANCE = new EncryptionUtil();

    /**
     * Default private C'tor
     */
    private EncryptionUtil() {
    }

    /**
     * Encrypt the  plain text
     *
     * @param text Plain text to be encrypted
     * @return Encrypted text
     * @throws IllegalArgumentException If encryption text is empty
     */
    public static byte[] encrypt(byte[] text) {
        if (!StringUtils.hasText(new String(text))) {
            throw new IllegalArgumentException("Encryption text is empty");
        }
        return INSTANCE.doEncryption(text);
    }

    /**
     * Decrypts the encrypted text
     *
     * @param text Encrypted text to be decrypted
     * @return decrypted text
     */
    public static byte[] decrypt(byte[] text) {
        return INSTANCE.doDecryption(text);
    }

    private byte[] doEncryption(byte[] text) {
        ByteBuffer bb = ByteBuffer.allocate(text.length + APP_KEY.length);
        return Base64.encodeBase64(bb.put(text).put(APP_KEY).array());
    }

    private byte[] doDecryption(byte[] text) {
        final byte[] decoded = Base64.decodeBase64(text);
        final int newLength = decoded.length - APP_KEY.length;
        return Arrays.copyOf(decoded, newLength);
    }
}
