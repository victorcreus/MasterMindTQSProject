package MasterMindTQSProject.Model;

import java.util.Random;

public class MyRandom implements RandomInterface {
	Random rnd = new Random();
	
	public MyRandom(){
	}
	
	public int nextInt(int high, int low) {
		int number = 0;
		number = rnd.nextInt(high-low)+low;
		return number;
	}
	
	public void setInt(int value) {};
}
