import java.io.*;
import java.util.*;
public class SubstitutionCipher {
static Scanner sc = new Scanner(System.in);
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
public static void main(String[] args) throws IOException {
// Alphabet for substitution
String a = "abcdefghijklmnopqrstuvwxyz";
String b = "zyxwvutsrqponmlkjihgfedcba";
// Input string from user
System.out.print("Enter any string: ");
String str = br.readLine().toLowerCase(); // Convert input to lowercase for consistent
// mapping
String decrypt = "";
// Encrypt the string
for (int i = 0; i < str.length(); i++) {
char c = str.charAt(i);
if (Character.isLetter(c)) { // Check if the character is a letter
int j = a.indexOf(c);
decrypt += b.charAt(j);
} else {
decrypt += c; // Keep non-alphabet characters as is
}
}
System.out.println("The encrypted data is: " + decrypt);
}
}