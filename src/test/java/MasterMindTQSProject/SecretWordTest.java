package MasterMindTQSProject;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SecretWordTest {


	SecretWord sw = new SecretWord();
	SecretWord swp = new SecretWord(4,5);

	@Test
	public void testSetWordLength() {
		int testDefault = 5;
		int testCustomized = 4;
		assertEquals(testDefault,sw.getWord_length());
		assertEquals(testCustomized,swp.getWord_length());
	}
	
	@Test
	public void testSetMinusNumber() {
		int testDefault = 1;
		int testCustomized = 5;
		assertEquals(testDefault,sw.getMin_number());
		assertEquals(testCustomized,swp.getMin_number());
	}
	
	@Test
	public void testSetSecretWord() {
		int testWordDefault[] = new int [] {1,2,3,4,5};
		int testWordCustomized[] = new int [] {5,6,7,8};
		sw.setSecretWord(testWordDefault);
		swp.setSecretWord(testWordCustomized);
		assertEquals(testWordDefault,sw.getSecretWord());
		assertEquals(testWordCustomized,swp.getSecretWord());
		
	}
	
	@Test
	public void testHasDuplicated() {
		int testWordNoDuplicated[] = new int [] {1,2,3,4,5};
		int testWordDuplicated[] = new int [] {1,2,3,1,5};
		//System.out.println(sw.proxyHasDuplicated(testWordNoDuplicated));
		assertFalse(sw.proxyHasDuplicated(testWordNoDuplicated));
		//System.out.println(sw.proxyHasDuplicated(testWordDuplicated));
		assertTrue(sw.proxyHasDuplicated(testWordDuplicated));
	}
	
	//@Test
	public void testGenerateCodeLength() {
		int testLengthDefault = 5;
		int testLengthCustomized = 4;
		int codeDefault[] = sw.proxyGenerateSecretWord(testLengthDefault, 1);
		int codeCustomized[] = swp.proxyGenerateSecretWord(testLengthCustomized, 5);
		assertEquals(testLengthDefault,codeDefault.length);
		assertEquals(testLengthCustomized,codeCustomized.length);
	}
	
	@Test
	public void testGenerateCodeMinusValue(){
		int testMinusValueDefault = 1;
		int testMinusValueCustomized = 5;
		int codeDefault[] = sw.proxyGenerateSecretWord(5, testMinusValueDefault);
		//int codeCustomized[] = swp.proxyGenerateSecretWord(4, testMinusValueCustomized);
		Arrays.sort(codeDefault);
		//Arrays.sort(codeCustomized);
		assertEquals(testMinusValueDefault,codeDefault[0]);
		//assertEquals(testMinusValueCustomized,codeCustomized[0]);
	}
	

}
