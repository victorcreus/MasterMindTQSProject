package MasterMindTQSProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class MasterMindTest {
	//ScannerInterface sc = new myScanner();
	//ScannerInterface sc = new MockMyScanner();
	
	MasterMind newGame1 = new MasterMind();
	
	@Test
	public void inicializationDefault() {
		String code = "1 2 3 4 5";
		int[] correctCode = {1,2,3,4,5};
		
		newGame1.myGame.secretWord.setSecretWord(correctCode);
		newGame1.myGame.sc.setNewInt(1);
		newGame1.myGame.sc.setNewCode(code);
		MasterMind.main();
		
		assertTrue(newGame1.endGame);
	}
}
