package MasterMindTQSProject;

public class MasterMind {
	//ScannerInterface sc = new MyScanner();
	static ScannerInterface sc = new MockMyScanner();
	static Game myGame = new Game(sc);
			
	public static int usedTries = 0;
	public static int correct = 0;
	public static int aprox = 0;
	public static boolean endGame = false;
	
	public static void main() {
		System.out.println(menu());

		myGame.selectMode();
		
		System.out.println("\n");
		for(int i=0; i<myGame.secretWord.getWord_length(); i++) {
			System.out.print(myGame.secretWord.getSecretWord()[i]+" ");
		}
		System.out.println("\n");
		
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
		
		if(endGame) {
			System.out.println(endGame(1));
		} else {
			System.out.println(endGame(0));
		}
		
	}
	
	private static String menu() {
		String text = 
		"----------------------------" +
		"-------- MASTER MIND -------" +
		"---------- WELCOME ---------" + 
		"----------------------------";
		return text;
	}
	
	private static void scoreBoard(Game myGame) {
		System.out.println("\n");
		System.out.println("Remaining tries: "+(myGame.getTries()-usedTries));
		System.out.println("Correct numbers: "+correct);
		System.out.println("Approximate numbers: "+aprox);
		System.out.println("\n");
	}
	
	private static String endGame(int value) {
		if(value == 1) {
			return "You win!";
		} else {
			return "You lose!";
		}
	}

	
	//Pedir al usuario numero de intentos
	//Pedir al usuario por defecto o personalizado
	//En caso por personalizado: Pedir minValue y long
	//Gen. palabra clave
	//Pedir su respuesta
	//Dar aciertos y aproximaciones
	//Si no es correcto del todo ir 3 pasos atras
	//Si es correcto o se acaban el numero de intentos: FIN DE PARTIDA
	
	
}
