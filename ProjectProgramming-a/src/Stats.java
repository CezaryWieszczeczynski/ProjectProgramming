import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



public class Stats {
	
    private static ArrayList<ComparableEmployers> table2 = new ArrayList<>(Interface.wczytywanie.table1);
    private static Analyzer analyze = new Analyzer(table2);
	
	
	public static float meanOp(ArrayList<ComparableEmployers> table, int option) {
		
	float Suma = 0;  
    Iterator<ComparableEmployers> iterator = table.iterator();
    switch (option) {
    case 1:
    	while (iterator.hasNext()) {
    		ComparableEmployers Jack = iterator.next();
    		Suma += Jack.getSalary();
    	}
    	float mean = Suma/table.size();
    	return mean;
    	
    case 2:
    	while (iterator.hasNext()) {
    		ComparableEmployers Jack = iterator.next();
    		Suma += Jack.getAge();
    	}
    	float meanA = Suma/table.size();
    	return meanA;
    //case 3: //case 3 będzie do EXP jak tylko exp zacznie działać 
    default: return 0;
    	
    	
    }
    
    }
	public static int countM(ArrayList<ComparableEmployers> table, String a) {
		ArrayList<ComparableEmployers> table2 = new ArrayList<>(Interface.wczytywanie.table1);
	    Analyzer analyzeQuick = new Analyzer(table2);
	    analyzeQuick.filterBySex(a);
		
		return table2.size();
		
	}
	
	public static double medianZarobki(ArrayList<ComparableEmployers> table) {
	    if (table.isEmpty()) return 0;

	    ArrayList<Double> salaries = new ArrayList<>();
	    for (ComparableEmployers i : table) {
	        salaries.add(i.getSalary());
	    }

	    Collections.sort(salaries);

	    int size = salaries.size();
	    if (size % 2 == 1) {
	        return salaries.get(size / 2);
	    } else {
	    	double mediana = (salaries.get(size / 2 - 1) + salaries.get(size / 2)) / 2;
	        return mediana;
	    }
	}
	
	
}
