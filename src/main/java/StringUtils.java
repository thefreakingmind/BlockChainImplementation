import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;

public class StringUtils {

    // Takes the input String and apply SH256 on that
    public static String apply256(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(inputString.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 0) {
                    sb.append('0');
                }
                sb.append(hex);



            }
            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
