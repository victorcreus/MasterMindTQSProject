package MasterMindTQSProject.Controller;

import MasterMindTQSProject.Model.RandomInterface;
import MasterMindTQSProject.Model.ScannerInterface;
import MasterMindTQSProject.View.MasterMindView;

public class MasterMind {
	
	static ScannerInterface sc;
	static Game myGame;
			
	public static int usedTries;
	public static int correct;
	public static int aprox;
	public static boolean endGame;
	public static RandomInterface r;
	
	
	public MasterMind(ScannerInterface sc, RandomInterface r) {
		this.sc = sc;
		this.r = r;
		
		this.myGame = new Game(this.sc, r);
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
		MasterMindView.askPlayAgainMissatge();
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
				MasterMindView.askPlayAgainError();
			}
		}while(again != 1 && again != 2);
		
		return again;
	}

	public void initGame() {
		System.out.println(MasterMindView.menu());
		myGame.selectMode();
	}
	
	public void startGame() {
		MasterMindView.scoreBoard(myGame,this);

		while(!endGame && usedTries < myGame.getTries()) {
			
			myGame.askCode();
			usedTries++;
			correct = myGame.getNumbersCorrectPosition();
			aprox = myGame.getAproxNumbers();
			
			if(correct != myGame.secretWord.getWord_length()) {
				MasterMindView.scoreBoard(myGame,this);
			} else {
				endGame = true;
			}
		}
		
		endGame();
	}
	
	private void endGame() {
		if(endGame) {
			System.out.println(MasterMindView.winner(1));
		} else {
			System.out.println(MasterMindView.winner(0));
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
