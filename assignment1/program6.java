// Abstract class
abstract class Cipher {
    protected String message;

    // Constructor
    Cipher(String message) {
        this.message = message;
    }

    // Abstract methods
    abstract String encrypt();
    abstract String decrypt();
}

// Caesar Cipher class
class CaesarCipher extends Cipher {
    private int shift;

    CaesarCipher(String message, int shift) {
        super(message);
        this.shift = shift;
    }

    // Encrypt method (override)
    @Override
    String encrypt() {
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }

            result += ch;
        }
        return result;
    }

    // Decrypt method (override)
    @Override
    String decrypt() {
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base - shift + 26) % 26 + base);
            }

            result += ch;
        }
        return result;
    }
}

// Main class
public class CipherSystem {
    public static void main(String[] args) {

        CaesarCipher obj = new CaesarCipher("king 18", 3);

        String encrypted = obj.encrypt();
        System.out.println("Encrypted: " + encrypted);

        // Set encrypted text for decryption
        obj = new CaesarCipher(encrypted, 3);

        String decrypted = obj.decrypt();
        System.out.println("Decrypted: " + decrypted);
    }
}
