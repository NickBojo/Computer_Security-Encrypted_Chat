package VPNGui;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.*;

// Class used to encrypt and decrypt input strings in DES
public class DES {
    
    private Cipher encryptionCipher;
    private Cipher decryptionCipher;
    byte[] encryptBytes;
    byte[] decryptBytes;
    byte[] stringAsBytesE;
    byte[] stringAsBytesD;
    IvParameterSpec IV = new IvParameterSpec(new byte[] {34, 16, 74, 33, 06, 95, 61, 45});
    
    // Creates a DES encryption class with a specific input key
    // Sets encryption cipher and decryption cipher to DES mode
    DES(SecretKey inKey) throws Exception {       
        // Setup encryption cipher
        encryptionCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, inKey, IV);
       
        // Setup decryption cipher
        decryptionCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        decryptionCipher.init(Cipher.DECRYPT_MODE, inKey, IV); 
    }
    
    // Input: Unencrypted String
    // Output: DES Encrypted String
    public String encryptString (String inString) throws Exception {
        String outString;
                
        // Convert String to UTF-8 Bytes
        stringAsBytesE = inString.getBytes("UTF8");
        
        // Encrypt
        encryptBytes = encryptionCipher.doFinal(stringAsBytesE);
        
        // Convert Bytes to String
        outString = new sun.misc.BASE64Encoder().encode(encryptBytes);
        
        return outString;      
    }
    
    // Input: DES Encrypted String
    // Output: Unencrypted String
    public String decryptString(String inString) throws Exception {        
        // Convert String to UTF-8 Bytes
        stringAsBytesD = new sun.misc.BASE64Decoder().decodeBuffer(inString);
        
        // Decrypt
        decryptBytes = decryptionCipher.doFinal(stringAsBytesD);
        
        // Convert Bytes to String
        String outString = new String(decryptBytes, "UTF8");
        
        return outString;
    }  
}