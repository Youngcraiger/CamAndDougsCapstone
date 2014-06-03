/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

/**
 *
 * @author Cameron Steinburg
 */
import java.io.*;
import java.util.*;

public class TextFile {

    String path;
    public String fileContent;

    public TextFile(String path) throws IOException {
        this.path = path;
        this.fileContent = readFile(path);
    }

    public void encrypt() {

        char toEncrpyt[] = fileContent.toCharArray();
        char encrypted[] = EnDecrypter.encrypt(toEncrpyt);
        this.fileContent = fileContent.valueOf(encrypted);
    }

    public void decrypt() {
        char toDecrpyt[] = fileContent.toCharArray();
        char decrypted[] = EnDecrypter.decrypt(toDecrpyt);
        this.fileContent = fileContent.valueOf(decrypted);
    }

    public void saveToDisk(String path) throws IOException {
        FileWriter encryptedTextFile = new FileWriter(path);
        PrintWriter output = new PrintWriter(encryptedTextFile);
        output.print(fileContent);
        encryptedTextFile.close();

    }

    public static String readFile(String path) throws IOException {

        File suckIt = new File(path);
        FileInputStream fis = new FileInputStream(suckIt);

        byte[] b = new byte[(int) suckIt.length()];
        fis.read(b);
        String content = new String(b);
        return content;
    }
}
