package MasterMindTQSProject.View;

public class GameView {

	public static void askTriesMissatge() {
		System.out.print("Insert the number of tries: ");
	}
	
	public static void menuMode() {
		System.out.println("Choose an option ");
		System.out.println("[1] Default mode");
		System.out.println("[2] Customized mode");
		System.out.print("Option selected: ");
	}
	
	public static void selectModeMissatge(int missatge) {
		if(missatge == 1)
			System.out.print("Insert the length of the secret word: ");
		if(missatge == 2)
			System.out.print("Insert the minimum value of the secret word: ");
		if(missatge == 3)
			System.out.print("This is not a correct option");
	}
	
	public static void askCodeMissages(int missatge) {
		if(missatge == 1)
			System.out.println("Insert your answer code; example [1 2 3 4 5]");
		if(missatge == 2)
			System.out.println("Some values are not in range!");
		if(missatge == 3)
			System.out.println("Introduce a correct length code!");
		if(missatge == 4)
			System.out.println("Some values are not integers! Try again:");
	}
}
