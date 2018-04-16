
public class Main {
	public static String stringToHex(String s) {
		byte[] bytes = s.getBytes();
		int a =0;
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				if (a == 1) {
					binary.append((val & 128) == 1 ? 0 : 1);
					val <<= 1;
					a++;
				}
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
			}
		return binary.toString();
	}

	public static String stringToHex2(String s) {
		byte[] bytes = s.getBytes();
		int a = 1;
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				if (a == 1) {
					binary.append((val & 128) == 1 ? 0 : 1);
					val <<= 1;
					a++;
				}
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
		}
		return binary.toString();
	}

	public static void main(String args[]) {
		String key = "2015125016KIMSON";

		key = stringToHex(key);
		String word = "ABCDEFGHIJKLMNOP";
		word = stringToHex2(word);

		AES128 aespass = new AES128(key);
		String encstr = aespass.encrypt(word);
		String decstr = aespass.decrypt(encstr);

		System.out.println(encstr);
		System.out.println(decstr);

	}
}
