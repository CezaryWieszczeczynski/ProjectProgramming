import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Table {
	ArrayList<ComparableEmployers> tab = new ArrayList<ComparableEmployers>();
	Scanner scan;
	public Table(String fileName) {
		try {
			scan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] values = line.split(",");
				ComparableEmployers object = new ComparableEmployers(values[0].trim(), 
						values[1].trim(), 
						Integer.parseInt(values[2].trim()), 
						values[3].trim(), 
						values[4].trim(), 
						Double.parseDouble(values[5].trim()));
				tab.add(object);
				
			}
		}finally {
			scan.close();
		}
		
	}
	public ArrayList<ComparableEmployers> getTab(){
		return tab;
	}
}

		

