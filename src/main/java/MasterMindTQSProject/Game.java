package MasterMindTQSProject;

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
		System.out.print("Insert the number of tries: ");
		this.tries = this.sc.nextInt();
	}
	
	public void selectMode() {
		int mode = 0;
		 do{
			System.out.println("Choose an option ");
			System.out.println("[1] Default mode");
			System.out.println("[2] Customized mode");
			System.out.print("Option selected: ");
			
			mode = sc.nextInt();
			switch(mode) {
			case 1: 
				this.secretWord = new SecretWord();
				this.secretWord.generateSecretWord(this.secretWord.getWord_length(), this.secretWord.getMin_number());
				break;
			case 2:
				int length;
				int minValue;
				System.out.print("Insert the length of the secret word: ");
				length = sc.nextInt();
				System.out.print("Insert the minimum value of the secret word: ");
				minValue = sc.nextInt();
				this.secretWord = new SecretWord(length,minValue);
				askTries();
				this.secretWord.generateSecretWord(length, minValue);
				break;
			default:
				System.out.print("This is not a correct option");
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
				System.out.println("Insert your answer code; example [1 2 3 4 5]");
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
						System.out.println("Some values are not in range!");
					}
						
				} else {
					System.out.println("Introduce a correct length code!");
				}
			}
		} catch (NumberFormatException ex) {
			//System.err.println("Some values are not integers: "+ex);
			System.out.println("Some values are not integers! Try again:");
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
