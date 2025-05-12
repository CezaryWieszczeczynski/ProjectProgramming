import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) {
		String fileName = "Z:\\aaaaa\\Użytkownicy\\Java Project PK1\\ProjectProgramming-a\\src\\inputData.txt";
		Table tab = new Table(fileName);
		ArrayList<ComparableEmployers> table1 = tab.getTab();
		Analyzer analyze = new Analyzer(table1);
		//analyze.filterBySurname("Piotrowski");
		//System.out.println(table1.size());
		//analyze.printTable();
		analyze.sortSalary(true);
		//System.out.println("\n\n\n");
		//analyze.printTable();
		//System.out.println("\n\n\n");
		//analyze.filterBySex("M");
		//analyze.printTable();
		//System.out.println("\n\n\n");
		analyze.delete("Grzegorz", "Piotrkowski");
		analyze.printTable();
		
	}

}
