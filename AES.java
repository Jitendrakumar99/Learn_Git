import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.util.Scanner;
public class AES {
public static String asHex(byte buf[]) {
StringBuffer strbuf = new StringBuffer(buf.length * 2);
int i;
for (i = 0; i < buf.length; i++) {
if (((int) buf[i] & 0xff) < 0x10)
strbuf.append("0");
strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
}
return strbuf.toString();
}
public static void main(String[] args) throws Exception {
// Create Scanner for user input
Scanner scanner = new Scanner(System.in);
// Prompt for user input message
System.out.print("Input your message: ");
String message = scanner.nextLine();
// Get the KeyGenerator for AES
KeyGenerator kgen = KeyGenerator.getInstance("AES");
kgen.init(128); // AES key size (128 bits)
// Generate the secret key
SecretKey skey = kgen.generateKey();
byte[] raw = skey.getEncoded();
// Create SecretKeySpec from the raw key
SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
// Instantiate the Cipher for AES/ECB/PKCS5Padding mode
Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
// Encrypt the message
cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
byte[] encrypted = cipher.doFinal(message.getBytes());
// Print the encrypted string in hex
System.out.println("Encrypted text (hex): " + asHex(encrypted));
// Decrypt the message
cipher.init(Cipher.DECRYPT_MODE, skeySpec);
byte[] original = cipher.doFinal(encrypted);
String originalString = new String(original);
// Print the original decrypted string
System.out.println("Decrypted text: " + originalString);
// Close the scanner
scanner.close();
}
}