package MasterMindTQSProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class MasterMindTest {
	//ScannerInterface sc = new myScanner();
	ScannerInterface sc = new MockMyScanner();
	
	MasterMind newGame = new MasterMind(sc);
	
	@Test
	public void testDefaultGameWin() {
		String code = "1 2 3 4 5";
		int[] correctCode = {1,2,3,4,5};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(1); //Mode custom
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode);
		newGame.myGame.sc.setNewCode(code);
		newGame.startGame();
		
		assertTrue(newGame.endGame);
	}
	
	@Test
	public void testDefaultGameLose() {
		String code = "1 2 3 3 5";
		int[] correctCode = {1,2,3,4,5};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(1); //Mode custom
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode);
		
		for(int i = 0; i<10; i++) {
			newGame.myGame.sc.setNewCode(code);
		}
		
		newGame.startGame();
		
		assertFalse(newGame.endGame);
	}
	
	
	@Test
	public void testCustomGameWin() {
		String code = "5 6 7 8 9 10";
		int[] correctCode = {5,6,7,8,9,10};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(2); //Mode custom
		newGame.myGame.sc.setNewInt(6); //Length
		newGame.myGame.sc.setNewInt(5); //MinValue
		newGame.myGame.sc.setNewInt(50); //Tries
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode);
		
		
		newGame.myGame.sc.setNewCode(code);
		
		newGame.startGame();
		
		assertTrue(newGame.endGame);
	}
	
	@Test
	public void testCustomGameLose() {
		String code = "5 6 7 8 9 9";
		int[] correctCode = {5,6,7,8,9,10};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(2); //Mode custom
		newGame.myGame.sc.setNewInt(6); //Length
		newGame.myGame.sc.setNewInt(5); //MinValue
		newGame.myGame.sc.setNewInt(50); //Tries
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode);
		
		for(int i = 0; i<50; i++) {
			newGame.myGame.sc.setNewCode(code);
		}
		
		newGame.startGame();
		
		assertFalse(newGame.endGame);
	}
	
	@Test
	public void testInitMasterMind() {
		assertEquals(0, newGame.proxyGetUsedTries());
		assertEquals(0, newGame.proxyGetCorrect());
		assertEquals(0, newGame.proxyGetAprox());
		assertFalse(newGame.proxyIsEndGame());
		assertNotNull(newGame.proxyGetSc());
	}
	
	@Test
	public void testEndGame() {
		newGame.proxySetEndGame(true);
		assertEquals("You win!", newGame.winner(1));
		newGame.proxySetEndGame(false);
		assertEquals("You lose!", newGame.winner(0));
	}
	
	@Test
	public void testPlayAgain() {
		String code = "1 2 3 4 5";
		int[] correctCode = {1,2,3,4,5};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(1); //Mode custom
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode);
		newGame.myGame.sc.setNewCode(code);
		newGame.startGame();
		newGame.myGame.sc.setNewInt(1);
		int again = newGame.askPlayAgain();
		
		assertEquals(again,1);
		assertEquals(newGame.usedTries,0);
		assertEquals(newGame.correct,0);
		assertEquals(newGame.aprox,0);
		assertFalse(newGame.endGame);
	}
	
	@Test
	public void testNoPlayAgain() {
		String code = "1 2 3 4 5";
		int[] correctCode = {1,2,3,4,5};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(1); //Mode custom
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode);
		newGame.myGame.sc.setNewCode(code);
		newGame.startGame();
		newGame.myGame.sc.setNewInt(0);
		int again = newGame.askPlayAgain();
		
		assertEquals(again,0);
		assertEquals(newGame.usedTries,newGame.usedTries);
		assertEquals(newGame.correct,newGame.correct);
		assertEquals(newGame.aprox,newGame.aprox);
		assertTrue(newGame.endGame);
	}
	
	@Test
	public void testPathStatement() {
		//Game 1
		String code = "1 2 3 4 5";
		int[] correctCode = {1,2,3,4,5};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(3);
		newGame.myGame.sc.setNewInt(1); //Mode custom
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode);
		newGame.myGame.sc.setNewCode("1 2 3 4 a");
		newGame.myGame.sc.setNewCode(code);
		newGame.startGame();
		
		assertTrue(newGame.endGame);
		newGame.myGame.sc.setNewInt(1);
		int again = newGame.askPlayAgain();
		
		//Game 2
		String code2 = "1 2 3 3 5";
		int[] correctCode2 = {1,2,3,4,5};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(1); //Mode custom
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode2);
		
		for(int i = 0; i<10; i++) {
			newGame.myGame.sc.setNewCode(code2);
		}
		
		newGame.startGame();
		
		assertFalse(newGame.endGame);
		
		newGame.myGame.sc.setNewInt(1);
		again = newGame.askPlayAgain();
		
		//Game 3
		String code3 = "1 2 3 3 5";
		int[] correctCode3 = {1,2,3,4,5};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(1); //Mode custom
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode3);
		
		for(int i = 0; i<8; i++) {
			newGame.myGame.sc.setNewCode(code3);
		}
		newGame.myGame.sc.setNewCode("1 2 3 4 5 6");
		newGame.myGame.sc.setNewCode("1 2 3 4 5");
		
		
		newGame.startGame();
		
		assertTrue(newGame.endGame);
		
		newGame.myGame.sc.setNewInt(1);
		again = newGame.askPlayAgain();
		
		//Game 4
		String code4 = "5 6 7 8 9 10";
		int[] correctCode4 = {5,6,7,8,9,10};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(2); //Mode custom
		newGame.myGame.sc.setNewInt(6); //Length
		newGame.myGame.sc.setNewInt(5); //MinValue
		newGame.myGame.sc.setNewInt(50); //Tries
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode4);
		
		newGame.myGame.sc.setNewCode("5 6 7 8 9");
		newGame.myGame.sc.setNewCode(code4);
		
		newGame.startGame();
		
		assertTrue(newGame.endGame);
		
		newGame.myGame.sc.setNewInt(1);
		again = newGame.askPlayAgain();
		
		//Game 5
		String code5 = "5 6 7 8 9 9";
		int[] correctCode5 = {5,6,7,8,9,10};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(2); //Mode custom
		newGame.myGame.sc.setNewInt(6); //Length
		newGame.myGame.sc.setNewInt(5); //MinValue
		newGame.myGame.sc.setNewInt(50); //Tries
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode5);
		
		for(int i = 0; i<50; i++) {
			newGame.myGame.sc.setNewCode(code5);
		}
		
		newGame.startGame();
		
		assertFalse(newGame.endGame);
		newGame.myGame.sc.setNewInt(1);
		again = newGame.askPlayAgain();
		
		//Game 6
		String code6 = "5 6 7 8 9 9";
		int[] correctCode6 = {5,6,7,8,9,10};
		
		//Mock inicialization
		newGame.myGame.sc.setNewInt(2); //Mode custom
		newGame.myGame.sc.setNewInt(6); //Length
		newGame.myGame.sc.setNewInt(5); //MinValue
		newGame.myGame.sc.setNewInt(50); //Tries
		
		newGame.initGame();
		newGame.myGame.secretWord.setSecretWord(correctCode6);
		
		for(int i = 0; i<47; i++) {
			newGame.myGame.sc.setNewCode(code6);
		}
		newGame.myGame.sc.setNewCode("5 6 7 8 11 9");
		newGame.myGame.sc.setNewCode("5 6 7 8 4 9");
		newGame.myGame.sc.setNewCode("5 6 7 8 9 10");
		
		newGame.startGame();
		
		assertTrue(newGame.endGame);
		
	}
}
