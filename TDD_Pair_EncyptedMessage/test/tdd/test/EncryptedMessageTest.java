/**
 * 
 */
package tdd.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import tdd.EncryptedMessage;

/**
 * 
 * Tests using isolated test cases for every case
 * 
 * @author Jocelyn Richardt
 *
 */
class EncryptedMessageTest {

	@Test
	void zeroLengthMsgEncryption() {
		String msg = "";
		String key = "A";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void zeroLengthMsgDecryption() {
		String msg = "";
		String key = "A";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void oneCharLengthMsgEncryption() {
		String msg = "C";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("C", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void oneCharLengthMsgDecryption() {
		String msg = "C";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("C", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void manyCharLengthMsgEncryption() {
		String msg = "WXYZ";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("WXYZ", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void manyCharLengthMsgDecryption() {
		String msg = "WXYZ";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("WXYZ", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	/*
	 * @Test void veryLargeCharLengthMsgEncryption() {
	 * 
	 * // I run out of memory when a create max string StringBuilder msg = new
	 * StringBuilder(); for (int i = 1; i < 2147483; i++) { msg.append('B'); }
	 * String key = "A";
	 * 
	 * EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);
	 * 
	 * // test getMessage try { assertEquals(msg.toString(),
	 * encryptedMsg.getMessage()); } catch (Exception e) {
	 * fail("Unexpected exception."); e.printStackTrace(); } }
	 * 
	 * @Test void veryLargeCharLengthMsgDecryption() {
	 * 
	 * // I run out of memory when a create max string // char[] array = new
	 * char[2147483646];
	 * 
	 * // very large string char[] array = new char[2147483];
	 * 
	 * // assign the specified data value to each element Arrays.fill(array, 'B');
	 * // creating a constructor of the String class and parses an array into it
	 * String msg = new String(array); String key = "A";
	 * 
	 * EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);
	 * 
	 * // test decryption try { assertEquals(msg.toString(),
	 * encryptedMsg.decryptMessage(key)); } catch (Exception e) {
	 * fail("Unexpected exception."); e.printStackTrace(); } }
	 */
	@Test
	void nullMsgEncryption() {

		String msg = null;
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void nullMsgDecryption() {

		String msg = null;
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void zeroLengthKeyEncryption() {
		String msg = "ABC";
		String key = "";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void zeroLengthKeyDecryption() {
		String msg = "ABC";
		String key = "";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void oneCharLengthKeyEncryption() {
		String msg = "ABC";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("BCD", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void oneCharLengthKeyDecryption() {
		String msg = "ABC";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("ABC", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void manyCharLengthKeyEncryption() {
		String msg = "ABC";
		String key = "ABC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("ACE", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void manyCharLengthKeyDecryption() {
		String msg = "ABC";
		String key = "ABC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("ABC", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	/*
	 * @Test void veryLargeCharLengthKeyEncryption() {
	 * 
	 * StringBuilder key = new StringBuilder(); for (int i = 1; i < 2147483; i++) {
	 * key.append('B'); } String msg = "ABC";
	 * 
	 * EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key.toString());
	 * 
	 * // test getMessage try { assertEquals("BCD", encryptedMsg.getMessage()); }
	 * catch (Exception e) { fail("Unexpected exception."); e.printStackTrace(); } }
	 * 
	 * @Test void veryLargeCharLengthKeyDecryption() {
	 * 
	 * StringBuilder key = new StringBuilder(); for (int i = 1; i < 2147483; i++) {
	 * key.append('B'); } String msg = "ABC";
	 * 
	 * EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key.toString());
	 * 
	 * // test decryption try { assertEquals(msg.toString(),
	 * encryptedMsg.decryptMessage(key.toString())); } catch (Exception e) {
	 * fail("Unexpected exception."); e.printStackTrace(); } }
	 */

	@Test
	void nullKeyEncryption() {

		String msg = "ABC";
		String key = null;

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void nullKeyDecryption() {

		String msg = "ABC";
		String key = null;

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void msgLongerThanKeyEncryption() {

		String msg = "ABC";
		String key = "BD";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("BDD", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void msgLongerThanKeyDecryption() {

		String msg = "ABC";
		String key = "AB";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void msgShorterThanKeyEncryption() {

		String msg = "ABC";
		String key = "BCDEFG";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("BDF", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void msgShorterThanKeyDecryption() {

		String msg = "ABC";
		String key = "BCEFG";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void msgKeySameLengthEncryption() {

		String msg = "ABC";
		String key = "ABC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("ACE", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void msgKeySameLengthDecryption() {

		String msg = "ABC";
		String key = "ABC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

}
