package MasterMindTQSProject.Controller;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import MasterMindTQSProject.Controller.MasterMind;
import MasterMindTQSProject.Model.MockMyScanner;
import MasterMindTQSProject.Model.MockRandom;
import MasterMindTQSProject.Model.RandomInterface;
import MasterMindTQSProject.Model.ScannerInterface;

public class AutomatedTest {

	ScannerInterface sc = new MockMyScanner();
	RandomInterface r = new MockRandom();
	MasterMind newGame = new MasterMind(sc,r);
	
	RandomInterface r2 = new MockRandom();
	MasterMind newGame2 = new MasterMind(sc,r);
	
	
	
	/*public void WhereIam() {
		System.out.println(new File(".").getAbsoluteFile());
	}*/
	
	@Test
	public void mode1Test() throws IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader("TC_E9_Functionality_06.txt"));
		
		String linea;
		
		while ((linea = bf.readLine())!=null) {
			
			
			int mode = Integer.parseInt(linea);
			newGame.myGame.sc.setNewInt(mode);
			
			newGame.initGame();
			
			linea=bf.readLine();
			int correctCodeL1=Integer.parseInt(linea);
			linea=bf.readLine();
			int correctCodeL2=Integer.parseInt(linea);
			linea=bf.readLine();
			int correctCodeL3=Integer.parseInt(linea);
			linea=bf.readLine();
			int correctCodeL4=Integer.parseInt(linea);
			linea=bf.readLine();
			int correctCodeL5=Integer.parseInt(linea);
			
			int[] correctCode = {correctCodeL1,correctCodeL2,correctCodeL3,correctCodeL4,correctCodeL5};
			newGame.myGame.secretWord.setSecretWord(correctCode);
			
			//System.out.println(correctCode[0]+"\n");
			//System.out.println(correctCode[1]+"\n");
			//System.out.println(correctCode[2]+"\n");
			//System.out.println(correctCode[3]+"\n");
			//System.out.println(correctCode[4]+"\n");
			
			
			
			while ((linea = bf.readLine())!=null) {
				newGame.myGame.sc.setNewCode(linea);
				//System.out.println(linea);
			}
			
			int correct=0;
			int aprox=0;
			
						
			newGame.startGame();
			
			for(int i=0; i< 5; i++) {
				if(correctCode[i]==newGame.myGame.getCodeTry()[i]) {
					correct++;
				}
			}
			
			assertEquals(correct,newGame.correct);
			
			
		}
		bf.close();
	}
	
	//@Test finalmente no se ha utilizado para los test cases.
	public void mode2Test() throws IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader("TC_E9_Functionality_06.txt"));
		
		String linea;
		
		while ((linea = bf.readLine())!=null) {
			
			
			int mode = Integer.parseInt(linea);
			newGame2.myGame.sc.setNewInt(mode);
						
			linea=bf.readLine();
			int length=Integer.parseInt(linea);
			newGame2.myGame.sc.setNewInt(length);
			
			linea=bf.readLine();
			int minVal=Integer.parseInt(linea);
			newGame2.myGame.sc.setNewInt(minVal);
			
			linea=bf.readLine();
			int tries=Integer.parseInt(linea);
			newGame2.myGame.sc.setNewInt(tries);
			
			
			linea=bf.readLine();
			int correctCodeL1=Integer.parseInt(linea);
			linea=bf.readLine();
			int correctCodeL2=Integer.parseInt(linea);
			linea=bf.readLine();
			int correctCodeL3=Integer.parseInt(linea);
			linea=bf.readLine();
			int correctCodeL4=Integer.parseInt(linea);
			linea=bf.readLine();
			int correctCodeL5=Integer.parseInt(linea);
			linea=bf.readLine();
			int correctCodeL6=Integer.parseInt(linea);
			
			int[] correctCode = {correctCodeL1,correctCodeL2,correctCodeL3,correctCodeL4,correctCodeL5,correctCodeL6};
			newGame2.myGame.secretWord.setSecretWord(correctCode);	
			
			newGame.initGame();
			
				
			while ((linea = bf.readLine())!=null) {
				newGame2.myGame.sc.setNewCode(linea);
				//System.out.println(linea);
			}
			
			newGame2.startGame();
			
			
		}
		bf.close();
	}
}
