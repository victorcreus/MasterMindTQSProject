package MasterMindTQSProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class MasterMindTest {
	//ScannerInterface sc = new myScanner();
	ScannerInterface sc = new MockMyScanner();
	
	MasterMind newGame1 = new MasterMind(sc); 

	
	
	@Test
	public void defaultGame() {
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
	public void customGame() {
		String code = "1 2 3 4 5";
		int[] correctCode = {1,2,3,4,5};
		
		//Mock inicialization
		newGame1.myGame.sc.setNewInt(2); //Mode custom
		newGame1.myGame.sc.setNewInt(5); //Length
		newGame1.myGame.sc.setNewInt(1); //MinValue
		newGame1.myGame.sc.setNewInt(50); //Tries
		
		newGame1.initGame();
		newGame1.myGame.secretWord.setSecretWord(correctCode);
		
		
		newGame1.myGame.sc.setNewCode(code);
		
		newGame1.startGame();
		
		assertTrue(newGame1.endGame);
	}
	
	@Test
	public void initMasterMind() {
		assertEquals(0, newGame1.proxyGetUsedTries());
		assertEquals(0, newGame1.proxyGetCorrect());
		assertEquals(0, newGame1.proxyGetAprox());
		assertFalse(newGame1.proxyIsEndGame());
		assertNotNull(newGame1.proxyGetSc());
	}
	
	@Test
	public void endGame() {
		newGame1.proxySetEndGame(true);
		assertEquals("You win!", newGame1.winner(1));
		newGame1.proxySetEndGame(false);
		assertEquals("You lose!", newGame1.winner(0));
	}
}
