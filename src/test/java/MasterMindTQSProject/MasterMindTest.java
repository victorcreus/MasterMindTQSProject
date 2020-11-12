package MasterMindTQSProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class MasterMindTest {
	//ScannerInterface sc = new myScanner();
	ScannerInterface sc = new MockMyScanner();
	
	MasterMind newGame1 = new MasterMind(sc); 

	
	
	@Test
	public void testDefaultGameWin() {
		String code = "1 2 3 4 5";
		int[] correctCode = {1,2,3,4,5};
		
		//Mock inicialization
		newGame1.myGame.sc.setNewInt(1); //Mode custom
		
		newGame1.initGame();
		newGame1.myGame.secretWord.setSecretWord(correctCode);
		newGame1.myGame.sc.setNewCode(code);
		newGame1.startGame();
		
		assertTrue(newGame1.endGame);
	}
	
	@Test
	public void testDefaultGameLose() {
		String code = "1 2 3 3 5";
		int[] correctCode = {1,2,3,4,5};
		
		//Mock inicialization
		newGame1.myGame.sc.setNewInt(1); //Mode custom
		
		newGame1.initGame();
		newGame1.myGame.secretWord.setSecretWord(correctCode);
		newGame1.myGame.sc.setNewCode(code);
		newGame1.startGame();
		
		assertFalse(newGame1.endGame);
	}
	
	
	@Test
	public void testCustomGameWin() {
		String code = "5 6 7 8 9 10";
		int[] correctCode = {5,6,7,8,9,10};
		
		//Mock inicialization
		newGame1.myGame.sc.setNewInt(2); //Mode custom
		newGame1.myGame.sc.setNewInt(6); //Length
		newGame1.myGame.sc.setNewInt(5); //MinValue
		newGame1.myGame.sc.setNewInt(50); //Tries
		
		newGame1.initGame();
		newGame1.myGame.secretWord.setSecretWord(correctCode);
		
		
		newGame1.myGame.sc.setNewCode(code);
		
		newGame1.startGame();
		
		assertTrue(newGame1.endGame);
	}
	
	@Test
	public void testCustomGameLose() {
		String code = "5 6 7 8 9 9";
		int[] correctCode = {5,6,7,8,9,10};
		
		//Mock inicialization
		newGame1.myGame.sc.setNewInt(2); //Mode custom
		newGame1.myGame.sc.setNewInt(6); //Length
		newGame1.myGame.sc.setNewInt(5); //MinValue
		newGame1.myGame.sc.setNewInt(50); //Tries
		
		newGame1.initGame();
		newGame1.myGame.secretWord.setSecretWord(correctCode);
		
		
		newGame1.myGame.sc.setNewCode(code);
		
		newGame1.startGame();
		
		assertFalse(newGame1.endGame);
	}
	
	@Test
	public void testInitMasterMind() {
		assertEquals(0, newGame1.proxyGetUsedTries());
		assertEquals(0, newGame1.proxyGetCorrect());
		assertEquals(0, newGame1.proxyGetAprox());
		assertFalse(newGame1.proxyIsEndGame());
		assertNotNull(newGame1.proxyGetSc());
	}
	
	@Test
	public void testEndGame() {
		newGame1.proxySetEndGame(true);
		assertEquals("You win!", newGame1.winner(1));
		newGame1.proxySetEndGame(false);
		assertEquals("You lose!", newGame1.winner(0));
	}
}
