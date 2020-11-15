package MasterMindTQSProject.Model;

import java.util.ArrayList;
import java.util.List;


public class MockMyScanner implements ScannerInterface{
	
	
	String stringValue;
	List<String> stringList = new ArrayList<>();
	List<Integer> intList = new ArrayList<>();
	int intUsed = 0;
	int stringUsed = 0;
	
	public MockMyScanner(){
	}
	
	@Override
	public void setNewInt(int value) {
		this.intList.add(value);
	}
	
	@Override
	public void setNewCode(String values) {
		this.stringList.add(values);
	}

	@Override
	public int nextInt() {
		return this.intList.get(intUsed++);
	}

	@Override
	public String nextLine() {
		return this.stringList.get(stringUsed++);
	}

}
