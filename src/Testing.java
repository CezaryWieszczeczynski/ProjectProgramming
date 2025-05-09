import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) {
		String fileName = "C:\\Users\\wiesz\\Downloads\\inputData.txt";
		Table tab = new Table(fileName);
		ArrayList<ComparableEmployers> table1 = tab.getTab();
		Analyzer analyze = new Analyzer(table1);
		analyze.printTable();
		analyze.sortSalary(false);
		System.out.println("\n\n\n");
		analyze.printTable();
		System.out.println("\n\n\n");
		analyze.filterBySex("M");
		analyze.printTable();
	}

}
