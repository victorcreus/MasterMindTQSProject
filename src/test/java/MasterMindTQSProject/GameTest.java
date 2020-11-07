package MasterMindTQSProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	MockMyScanner sc = new MockMyScanner();
	//MyScanner nsc = new MyScanner();
	Game game = new Game(sc);
		
	@Test
	public void testAskNumTriesDefault() {
		int testTries = 10;
		assertEquals(testTries,game.getTries());
	}
	
	@Test
	public void testAskNumTriesCustomized() {
		int testTries = 15;
		game.sc.setNewInt(15);
		game.proxyAskTries();
		assertEquals(testTries,game.getTries());
	}
	
	@Test
	public void testSelectModeDefault() {
		int testLengthTest = 5;
		int testMinValue = 1;
		int testTries = 10;

		game.sc.setNewInt(1); //Game mode

		game.selectMode();
		assertEquals(testLengthTest, game.secretWord.getWord_length());
		assertEquals(testMinValue, game.secretWord.getMin_number());
		assertEquals(testTries, game.getTries());
	}
	
	@Test
	public void testSelectModeCustomized() {
		int testLengthTest = 4;
		int testMinValue = 5;
		int testTries = 15;
		
		game.sc.setNewInt(2); //Game mode
		game.sc.setNewInt(testLengthTest); //WordLength
		game.sc.setNewInt(testMinValue); //MinValue
		game.sc.setNewInt(testTries); //Tries
		game.selectMode();
		
		assertEquals(testLengthTest, game.secretWord.getWord_length());
		assertEquals(testMinValue, game.secretWord.getMin_number());
		assertEquals(testTries, game.getTries());
	}
	
	//@Test //Encontramos bucle infinito porque el ASK pide valores VALIDO y no los damos
	/*Falta crear MockObject para la lectura del askCode, sino el usuario
	debe ingresar los datos manualmente. Despu�s se debe comprobar si es
	v�lido o se debe pedir de nuevo.
	Preguntas tutoria:
	Mock Objects
	FeedBack general
	�Se puede involucrar al usuario en los test? (Scanner de datos)
	�C�mo hacemos assertEquals para arrays de datos?*/
	
	public void testInsertCode() {
		int []testCode = {1,2,3,4,5};
		int []testCodeError1 = {1,2,8,4,5};
		int []testCodeError2 = {1,2,3,4,5,4};
		int []testCodeError3 = {1,2,3,4};
		int []testCodeError4 = {1,2,3,4,-9};
		
		
		String mockCode = "1 2 3 4 5";
		game.sc.setNewCode(mockCode);
		game.askCode();
		for (int i = 0; i < 5; i++) {
			assertEquals(testCode[i], game.getCodeTry()[i]);
		}
		
		mockCode = "1 2 8 4 5";
		game.sc.setNewCode(mockCode);
		game.askCode();
		for (int i = 0; i < 5; i++) {
			assertNotEquals(testCode[i], game.getCodeTry()[i]);
		}
		
		mockCode = "1 2 3 4 5 4";
		game.sc.setNewCode(mockCode);
		game.askCode();
		for (int i = 0; i < 5; i++) {
			assertNotEquals(testCode[i], game.getCodeTry()[i]);
		}
		
		
		mockCode = "1 2 3 4";
		game.sc.setNewCode(mockCode);
		game.askCode();
		for (int i = 0; i < 5; i++) {
			assertNotEquals(testCode[i], game.getCodeTry()[i]);
		}
		
		mockCode = "1 2 3 4 -9";
		game.sc.setNewCode(mockCode);
		game.askCode();
		for (int i = 0; i < 5; i++) {
			assertNotEquals(testCode[i], game.getCodeTry()[i]);
		}
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
	
	
	@Test
	public void testCorrectPosition() {
		int correctPosition;
		String testCode = "1 2 3 4 5";
		
		game.sc.setNewCode(testCode);
		game.askCode();
		game.secretWord.setMin_number(1);
		game.secretWord.setWord_length(5);
		int[] gameCode = {1,2,3,4,5};
		game.secretWord.setSecretWord(gameCode);
		
		correctPosition = game.getNumbersCorrectPosition();
		assertEquals(5, correctPosition);
		
		
		int[] gameCode2 = {1,2,3,4,4};
		game.secretWord.setSecretWord(gameCode2);
		
		correctPosition = game.getNumbersCorrectPosition();
		assertEquals(4, correctPosition);
		
	}
	
	@Test
	public void testAproxNumbers() {
		int correctPosition;
		
		String testCode = "1 2 3 4 5"; 
		game.sc.setNewCode(testCode);
		game.askCode();
		game.secretWord.setMin_number(1);
		game.secretWord.setWord_length(5);
		int[] gameCode = {1,3,3,2,5};
		game.secretWord.setSecretWord(gameCode);
		
		correctPosition = game.getAproxNumbers();
		assertEquals(2, correctPosition);
		
		
		int[] gameCode2 = {1,4,5,2,5};
		game.secretWord.setSecretWord(gameCode2);
		
		correctPosition = game.getAproxNumbers();
		assertEquals(3, correctPosition);
	}
	
}
