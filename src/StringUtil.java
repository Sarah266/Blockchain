import java.security.MessageDigest;

public class StringUtil {
	
	// Applies SHA256 to a string and returns the result
	public static String applySHA256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			// Applies SHA256 to our input
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					sb.append('0');
				sb.append(hex);
			}
			return sb.toString();
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
