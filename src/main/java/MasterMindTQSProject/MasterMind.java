package MasterMindTQSProject;

public class MasterMind {
	
	static ScannerInterface sc;
	static Game myGame;
			
	public static int usedTries;
	public static int correct;
	public static int aprox;
	public static boolean endGame;
	
	
	public MasterMind(ScannerInterface sc) {
		this.sc = sc;
		
		this.myGame = new Game(this.sc);
		this.usedTries = 0;
		this.correct = 0;
		this.aprox = 0;
		this.endGame = false;
	}
	
	private void playAgain(int again) {
		if(again == 1) {
			this.usedTries = 0;
			this.correct = 0;
			this.aprox = 0;
			this.endGame = false;
		}
		
	}
	
	public int askPlayAgain() {
		int again = 0;
		do {
			again = sc.nextInt();
			switch(again) {
			case 1:
				playAgain(again);
				break;
			case 2:
				break;
			default:
				System.out.println("Please, enter a correct option!");
			}
		}while(again != 1 && again != 2);
		
		return again;
	}

	public void initGame() {
		System.out.println(menu());
		myGame.selectMode();
	}
	
	public void startGame() {
		scoreBoard(myGame);

		while(!endGame && usedTries < myGame.getTries()) {
			
			myGame.askCode();
			usedTries++;
			correct = myGame.getNumbersCorrectPosition();
			aprox = myGame.getAproxNumbers();
			
			if(correct != myGame.secretWord.getWord_length()) {
				scoreBoard(myGame);
			} else {
				endGame = true;
			}
		}
		
		endGame();
	}
	
	private static String menu() {
		String text = 
		"----------------------------\n" +
		"------- MASTER MIND --------\n" +
		"--------- WELCOME ----------\n" + 
		"----------------------------\n";
		return text;
	}
	
	private static void scoreBoard(Game myGame) {
		System.out.println("\n");
		System.out.println("Remaining tries: "+(myGame.getTries()-usedTries));
		System.out.println("Correct numbers: "+correct);
		System.out.println("Approximate numbers: "+aprox);
		System.out.println("\n");
	}
	
	private void endGame() {
		if(endGame) {
			System.out.println(winner(1));
		} else {
			System.out.println(winner(0));
		}
	}
	
	
	public static String winner(int value) {
		if(value == 1) {
			return "You win!";
		} else {
			return "You lose!";
		}
	}
	
	public static ScannerInterface proxyGetSc() {
		return sc;
	}


	public static Game proxyGetMyGame() {
		return myGame;
	}


	public static int proxyGetUsedTries() {
		return usedTries;
	}


	public static int proxyGetCorrect() {
		return correct;
	}


	public static int proxyGetAprox() {
		return aprox;
	}


	public static boolean proxyIsEndGame() {
		return endGame;
	}
	
	public static void proxySetEndGame(boolean endGame) {
		MasterMind.endGame = endGame;
	}

}
