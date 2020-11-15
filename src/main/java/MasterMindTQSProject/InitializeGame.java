package MasterMindTQSProject;

import MasterMindTQSProject.Controller.MasterMind;
import MasterMindTQSProject.Model.MockRandom;
import MasterMindTQSProject.Model.MyRandom;
import MasterMindTQSProject.Model.MyScanner;
import MasterMindTQSProject.Model.RandomInterface;
import MasterMindTQSProject.Model.ScannerInterface;

public class InitializeGame {

	public static void main(String[] args) {
		//ScannerInterface sc = new MockMyScanner();
		ScannerInterface sc = new MyScanner();
		
		RandomInterface r = new MockRandom();
		r.setInt(5);
		//RandomInterface r = new MyRandom();
		
		
		
		MasterMind masterMind = new MasterMind(sc,r);
		int keepPlaying = 1;
		while(keepPlaying==1) {
			masterMind.initGame();
			masterMind.startGame();
			keepPlaying = masterMind.askPlayAgain(); 
		}
	}
}
