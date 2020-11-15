package MasterMindTQSProject.View;
import MasterMindTQSProject.Controller.*;

public class MasterMindView {
	public static void scoreBoard(Game myGame, MasterMind md) {
		System.out.println("\n");
		System.out.println("Remaining tries: "+(myGame.getTries()-md.usedTries));
		System.out.println("Correct numbers: "+md.correct);
		System.out.println("Approximate numbers: "+md.aprox);
		System.out.println("\n");
	}
	
	public static String menu() {
		String text = 
		"----------------------------\n" +
		"------- MASTER MIND --------\n" +
		"--------- WELCOME ----------\n" + 
		"----------------------------\n";
		return text;
	}
	
	public static void askPlayAgainError() {
		System.out.println("Please, enter a correct option!");
	}
	
	public static void askPlayAgainMissatge() {
		System.out.println("Do you want to play again?");
	}
	
	public static String winner(int value) {
		if(value == 1) {
			return "You win!";
		} else {
			return "You lose!";
		}
	}
}
