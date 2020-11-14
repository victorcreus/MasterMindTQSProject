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
	public void testGenerateCodeLength() {
		int testLengthDefault = 5;
		int testMinumValueDefault = 1;
		int testLengthCustomized = 4;
		int testMinumValueCustomized = 5;
		sw.generateSecretWord(testLengthDefault, testMinumValueDefault);
		int codeDefault[] = sw.getSecretWord();
		swp.generateSecretWord(testLengthCustomized, testMinumValueCustomized);
		int codeCustomized[] = swp.getSecretWord();
		assertEquals(testLengthDefault,codeDefault.length);
		assertEquals(testLengthCustomized,codeCustomized.length);
		Arrays.sort(codeDefault);
		Arrays.sort(codeCustomized);
		boolean inRangeDefault = false;
		boolean inRangeCustom = false;
		if (codeDefault[0] >= testMinumValueDefault && codeDefault[(codeDefault.length)-1] <= (testMinumValueDefault+testLengthDefault)-1) {
			inRangeDefault = true;
		}
		if (codeCustomized[0] >= testMinumValueCustomized && codeCustomized[(codeCustomized.length)-1] <= (testMinumValueCustomized+testLengthCustomized)-1) {
			inRangeCustom = true;
		}
		assertTrue(inRangeDefault);
		assertTrue(inRangeCustom);
	}
	
	/*//@Test
	public void testHasDuplicated() {
		int testWordNoDuplicated[] = new int [] {1,2,3,4,5};
		int testWordDuplicated[] = new int [] {1,2,3,1,5};
		int testWordDuplicatedAll[] = new int [] {1,1,1,1,1,1,1,1,1,1,1,5};
		//System.out.println(sw.proxyHasDuplicated(testWordNoDuplicated));
		assertFalse(sw.proxyHasDuplicated(testWordNoDuplicated));
		//System.out.println(sw.proxyHasDuplicated(testWordDuplicated));
		assertTrue(sw.proxyHasDuplicated(testWordDuplicated));
		assertTrue(sw.proxyHasDuplicated(testWordDuplicatedAll));
	}*/
	
	/*@Test
	public void testGenerateCodeCorrectValues(){
		sw.generateSecretWord(sw.getWord_length(), sw.getMin_number());
		swp.generateSecretWord(swp.getWord_length(), swp.getMin_number());
		assertTrue(sw.itIsInRange());
		assertTrue(swp.itIsInRange());
	}*/
	

}
