/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

/**
 *
 * @author Cameron Steinburg
 */
public class EnDecrypter {
    
    public static char[] encrypt(char[] plainText) {

        for (int y = 0; y < plainText.length; y++) {
            plainText[y] =(char) (plainText[y] + 13);
        }
        return plainText;
    }

    public static char[] decrypt(char[] cipherText) {
        
        for (int x = 0; x < cipherText.length; x++) {
            cipherText[x] = (char) (cipherText[x] - 13);
        }
        return cipherText;
    }
    
}
