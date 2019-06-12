package src.de.haubauer.helpers;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;

public class DESEncrypter {

    private byte[] keyBytes;
    private byte[] ivBytes;

    private byte[] encrypted;

    private int enc_len;
    private int dec_len;

    private SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
    private  IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);


    public byte[] getEncrypted() {
        return encrypted;
    }

    public DESEncrypter(){
    }

    public void Encryption(byte[] input){

        try{

            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            encrypted= new byte[cipher.getOutputSize(input.length)];
            enc_len = cipher.update(input, 0, input.length, encrypted, 0);
            enc_len += cipher.doFinal(encrypted, enc_len);
        }
        catch(Exception e) {

        }
    }
    public void Decryption(byte[] input){

        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
            byte[] decrypted = new byte[cipher.getOutputSize(enc_len)];
            dec_len = cipher.update(encrypted, 0, enc_len, decrypted, 0);
            dec_len += cipher.doFinal(decrypted, dec_len);
        }
        catch(Exception e)
        {

        }
    }
}
