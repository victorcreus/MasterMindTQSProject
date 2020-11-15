package MasterMindTQSProject.Model;

public interface ScannerInterface {
	void setNewCode(String values);
	void setNewInt(int values);

	int nextInt();
	String nextLine();
}
