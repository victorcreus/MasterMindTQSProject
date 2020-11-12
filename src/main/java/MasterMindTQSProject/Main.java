package MasterMindTQSProject;

public class Main {

	public static void main(String[] args) {
		ScannerInterface sc = new MyScanner();
		MasterMind match = new MasterMind(sc);
		match.initGame();
		match.startGame();
	}

}
