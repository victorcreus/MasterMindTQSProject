package MasterMindTQSProject.Controller;

import MasterMindTQSProject.Model.ScannerInterface;
import MasterMindTQSProject.View.GameView;
import MasterMindTQSProject.Model.SecretWord;

public class Game {

	private int tries;
	private int codeTry[];
	public SecretWord secretWord;
	public ScannerInterface sc;
	
	
	Game(ScannerInterface sc){
		tries = 10;
		secretWord = new SecretWord();
		this.sc = sc;
	}
	
	public void setMyScanner(ScannerInterface scReceived) {
		this.sc = scReceived;
	}
	
	private void askTries() {
		GameView.askTriesMissatge();
		this.tries = this.sc.nextInt();
	}
	
	public void selectMode() {
		int mode = 0;
		 do{
			GameView.menuMode();
			mode = sc.nextInt();
			switch(mode) {
			case 1: 
				this.secretWord = new SecretWord();
				this.secretWord.generateSecretWord(this.secretWord.getWord_length(), this.secretWord.getMin_number());
				break;
			case 2:
				int length;
				int minValue;
				GameView.selectModeMissatge(1);
				length = sc.nextInt();
				GameView.selectModeMissatge(2);
				minValue = sc.nextInt();
				this.secretWord = new SecretWord(length,minValue);
				askTries();
				this.secretWord.generateSecretWord(length, minValue);
				break;
			default:
				GameView.selectModeMissatge(3);
				break;
				
			}
		}while(mode != 1 && mode != 2);
		
	}
	
	public void proxyAskTries() {
		askTries();
	}

	public int getTries() {
		return tries;
	}
	
	public void askCode() {
		boolean converted = false;
		int []numbersList = new int[this.secretWord.getWord_length()];
		
		try{
			while(!converted) {
				GameView.askCodeMissages(1);
				String strNumbers = this.sc.nextLine();
				String []StrNumbersArray = strNumbers.split(" ");

				if(StrNumbersArray.length == this.secretWord.getWord_length()) {
					for(int i=0; i<this.secretWord.getWord_length(); i++) {
						numbersList[i] = Integer.parseInt(StrNumbersArray[i]);
					}
					
					this.codeTry=numbersList;
					
					if(this.itIsInRange()) {
						converted = true;
					} else {
						GameView.askCodeMissages(2);
					}
						
				} else {
					GameView.askCodeMissages(3);
				}
			}
		} catch (NumberFormatException ex) {
			//System.err.println("Some values are not integers: "+ex);
			GameView.askCodeMissages(4);
			this.askCode();
		}
		
	}
	
	public boolean itIsInRange() {
		boolean inRange = true;
		int i = 0;
		int min = this.secretWord.getMin_number();
		int max = (this.secretWord.getWord_length()-1)+min;
		while(inRange && i < this.secretWord.getWord_length()) {
			if (this.codeTry[i] < min || this.codeTry[i] > max) {
				inRange = false;
			}
			else {
				i++;
			}
		}
		
		return inRange;
	}
	
	public int[] getCodeTry() {
		return codeTry;
	}
	
	public int getNumbersCorrectPosition() {
		int correctPosition = 0;
		
		for(int i = 0; i < this.secretWord.getWord_length(); i++) {
			if(this.codeTry[i] == this.secretWord.getSecretWord()[i]) {
				correctPosition++;
			}
		}
		return correctPosition;
	}
	
	public int getAproxNumbers() {
		int aproxNumbers = 0;
		int correctPosition = getNumbersCorrectPosition();
		boolean aprox;
		
		for(int i = 0; i < this.secretWord.getWord_length();i++) {
			aprox = false;
			for (int j = 0; j < this.codeTry.length;j++) {
				if (this.codeTry[j] == this.secretWord.getSecretWord()[i]) {
					aprox = true;
				}
			}
			if (aprox) {
				aproxNumbers++;
			}
		}
		return aproxNumbers - correctPosition;
		
	}
}
