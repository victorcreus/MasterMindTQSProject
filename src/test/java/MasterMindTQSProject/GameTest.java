package MasterMindTQSProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	
	Game game = new Game();
	
	//@Test
	public void testAskNumTriesDefault() {
		int testTries = 10;
		assertEquals(testTries,game.getTries());
	}
	
	//@Test
	public void testAskNumTriesCustomized() {
		int testTries = 15;
		game.proxyAskTries();
		assertEquals(testTries,game.getTries());
	}
	
	//@Test
	public void testSelectModeDefault() {
		int testLengthTest = 5;
		int testMinValue = 1;
		int testTries = 10;
		game.selectMode();
		assertEquals(testLengthTest, game.secretWord.getWord_length());
		assertEquals(testMinValue, game.secretWord.getMin_number());
		assertEquals(testTries, game.getTries());
	}
	
	//@Test
	public void testSelectModeCustomized() {
		int testLengthTest = 4;
		int testMinValue = 5;
		int testTries = 15;
		game.selectMode();
		assertEquals(testLengthTest, game.secretWord.getWord_length());
		assertEquals(testMinValue, game.secretWord.getMin_number());
		assertEquals(testTries, game.getTries());
	}
	
	@Test
	/*Falta crear MockObject para la lectura del askCode, sino el usuario
	debe ingresar los datos manualmente. Después se debe comprobar si es
	válido o se debe pedir de nuevo.
	Preguntas tutoria:
	Mock Objects
	FeedBack general
	¿Se puede involucrar al usuario en los test? (Scanner de datos)*/
	
	public void testInsertCode() {
		int []testCode = {1,2,3,4,5};
		int []testCodeError1 = {1,2,8,4,5};
		int []testCodeError2 = {1,2,3,4,5,4};
		int []testCodeError3 = {1,2,3,4};
		int []testCodeError4 = {1,2,3,4,-9};
		game.secretWord.setWord_length(5);
		game.secretWord.setMin_number(1);
		game.secretWord.setSecretWord(testCode);
		
		game.askCode();
		assertEquals(testCode, game.getCodeTry());
		//assertNotEquals(testCodeError1, game.getCodeTry());
	}
	
	/*//@Test
	public void testInsertCodeRangeDefault() {
		int codeOK[] = new int [] {1,2,3,4,5};
		int codeNotOKLow[] = new int [] {1,2,3,4,5,6};
		int codeNotOKHigh[] = new int [] {1,2,3,4,5,6};
		game.codeInRange(code);
		assertEquals(code.size,game.secretWord.getWord_length());
	}
	
	//@Test
	public void testInsertCodeRangeCustomized() {
		game.codeInRange();
		assertEquals(code.size,game.secretWord.getWord_length());
	}
	
	//@Test
	public void testInsertCodeLengthDefault() {
		int codeOK[] = new int [] {1,2,3,4,5};
		int codeNotOKLow[] = new int [] {1,2,3,4,5,6};
		int codeNotOKHigh[] = new int [] {1,2,3,4,5,6};
		game.codeInRange(code);
		assertEquals(code.size,game.secretWord.getWord_length());
	}
	
	//@Test
	public void testInsertCodeCustomized() {
		int codeOK[] = new int [] {1,2,3,4,5};
		int codeNotOKLow[] = new int [] {1,2,3,4,5,6};
		int codeNotOKHigh[] = new int [] {1,2,3,4,5,6};
		game.codeInRange(code);
		assertEquals(code.size,game.secretWord.getWord_length());
	}*/
	
	
	

}
