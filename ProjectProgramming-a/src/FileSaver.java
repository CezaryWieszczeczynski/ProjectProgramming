import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class FileSaver {
	public static void saveToFile(String filePath, List<ComparableEmployers> data) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
			for (ComparableEmployers emp : data) {
				writer.write(emp.getName()+ ", " + emp.getSurname()+ ", "+ emp.getAge()+ ", "+emp.getDate()+ ", "+emp.getSex()+ ", "+emp.getSalary());
	            writer.newLine();
	            }
	        System.out.println("Zapisano dane do pliku.");
	   } catch (IOException e) {
	            System.out.println("Błąd podczas zapisu: " + e.getMessage());
	       }
	  }
	
}



