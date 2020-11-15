package MasterMindTQSProject.Model;

public class MockRandom implements RandomInterface {
	
	int number = 0;
	
	public void setInt(int value) {
		this.number = value;
	}
	

	public int nextInt(int value1, int value2) {
		return this.number;
	}
}
