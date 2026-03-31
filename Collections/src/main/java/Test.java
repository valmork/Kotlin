import static properties.EncryptedPropertyKt.encode;

public class Test {

    public static void main(String[] args) {
        String s = "Hello";
        String encoded = encode(s);
        System.out.println(encoded);
    }
}
