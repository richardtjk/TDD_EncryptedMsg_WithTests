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

	@Test
	void uppercaseKeyEncryption() {

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
	void upperCaseKeyDecryption() {

		String msg = "ABC";
		String key = "BCDEFG";

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
	void lowercaseKeyEncryption() {

		String msg = "ABC";
		String key = "b";

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
	void lowercaseKeyDecryption() {

		String msg = "ABC";
		String key = "b";

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
	void mixedCaseKeyEncryption() {

		String msg = "ABD";
		String key = "BbC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("BCF", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void mixedCaseKeyDecryption() {

		String msg = "ABD";
		String key = "BbC";

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
	void numberKeyEncryption() {
		String msg = "ABC";
		String key = "12";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void numberKeyDecryption() {
		String msg = "ABC";
		String key = "12";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void punctuationKeyEncryption() {
		String msg = "ABC";
		String key = "#$%^";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void punctuationKeyDecryption() {
		String msg = "ABC";
		String key = "#$%^";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void spaceKeyEncryption() {
		String msg = "ABC";
		String key = "      ";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void spaceKeyDecryption() {
		String msg = "ABC";
		String key = "      ";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}
	
	@Test
	void mixedCharKeyEncryption() {
		String msg = "ABC";
		String key = "AB2 (5)";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void mixedCharKeyDecryption() {
		String msg = "ABC";
		String key = "AB2 (5)";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}
	

	@Test
	void uppercaseMsgEncryption() {

		String msg = "BCDEFG";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void upperCaseMsgDecryption() {

		String msg = "BCDEFG";
		String key = "B";

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
	void lowercaseMsgEncryption() {

		String msg = "bcdefg";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void lowercaseMsgDecryption() {

		String msg = "bcdefg";
		String key = "B";

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
	void mixedCaseMsgEncryption() {

		String msg = "BcdeFg";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void mixedCaseMsgDecryption() {

		String msg = "BcdeFg";
		String key = "B";

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
	void numberMsgEncryption() {
		String msg = "43255";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void numberMsgDecryption() {
		String msg = "43255";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void punctuationMsgEncryption() {
		String msg = "#%&!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void punctuationMsgDecryption() {
		String msg = "#%&!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void spaceMsgEncryption() {
		String msg = "    ";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void spaceMsgDecryption() {
		String msg = "    ";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}
	
	@Test
	void mixedCharMsgEncryption() {
		String msg = "HE110 THERE!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("IFPUIFSF", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}

	}

	@Test
	void mixedCharMsgDecryption() {
		String msg = "HE110 THERE!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("HEOTHERE", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}

	}
	
	@Test
	void uppercaseEncryptedMsgEncryption() {

		String msg = "CDEFGH";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals(msg, encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void upperCaseEncryptedMsgDecryption() {

		String msg = "CDEFGH";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void lowercaseEncryptedMsgEncryption() {

		String msg = "cdefgh";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void lowercaseEncryptedMsgDecryption() {

		String msg = "cdefgh";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void mixedCaseEncryptedMsgEncryption() {

		String msg = "CdefGh";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void mixedCaseEncryptedMsgDecryption() {

		String msg = "CdefGh";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void numberEncryptedMsgEncryption() {
		String msg = "43255";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void numberEncryptedMsgDecryption() {
		String msg = "43255";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void punctuationEncryptedMsgEncryption() {
		String msg = "#%&!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void punctuationEncryptedMsgDecryption() {
		String msg = "#%&!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void spaceEncryptedMsgEncryption() {
		String msg = "    ";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void spaceEncryptedMsgDecryption() {
		String msg = "    ";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}
	
	@Test
	void mixedCharEncryptedMsgEncryption() {
		String msg = "HE110 THERE!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void mixedCharEncryptedMsgDecryption() {
		String msg = "HE110 THERE!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void noChangeEncryption() {

		String msg = "BCDEFG";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals("BCDEFG", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void noChangeDecryption() {

		String msg = "BCDEFG";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void noRolloverEncryption() {

		String msg = "BCDEFG";
		String key = "C";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals("DFGHIJ", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void noRolloverDecryption() {

		String msg = "BCDEFG";
		String key = "C";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}
	
	@Test
	void rolloverEncryption() {

		String msg = "XYZABC";
		String key = "CCCZZZ";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals("ZABZAB", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void rolloverDecryption() {

		String msg = "XYZABC";
		String key = "CCCZZZ";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("ZABZAB", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}
	
	
	@Test
	void decryptWithWrongKey() {

		String msg = "BCDEFG";
		String key = "CAB";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
		
		// test wrong decryption that doesn't change
		try {
			assertEquals("DCEGFH", encryptedMsg.decryptMessage("A"));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}

		// test wrong decryption that doesn't change
		try {
			assertEquals("DFGHIJ", encryptedMsg.decryptMessage("B"));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}

	}
	

}
