package MasterMindTQSProject;

public class InitializeGame {

	public static void main(String[] args) {
		//ScannerInterface sc = new MockMyScanner();
		ScannerInterface sc = new MyScanner();
		
		MasterMind masterMind = new MasterMind(sc);
		masterMind.initGame();
		masterMind.startGame();
	}
}
