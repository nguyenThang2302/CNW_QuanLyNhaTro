package ultils;

import java.security.SecureRandom;

public class UltilsService {
	public static String generateCustomerCode() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int codeLength = 5;

		SecureRandom random = new SecureRandom();

		StringBuilder customerCode = new StringBuilder();
		for (int i = 0; i < codeLength; i++) {
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			customerCode.append(randomChar);
		}

		return customerCode.toString();
	}
}
