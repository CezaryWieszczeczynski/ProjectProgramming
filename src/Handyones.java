
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Handyones {
	
	static Scanner franek = new Scanner(System.in);

    public static String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        return timeFormat.format(new Date());
    }
    
	public static String Date() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String formattedDate = dateFormat.format(currentDate);
		return formattedDate;
		
	}
	
	public static String Runtime(long pies) {
		long endTime = System.currentTimeMillis();
		long runTime = endTime - pies;
		long sekundy = runTime / 1000;
		long minuty = sekundy / 60;
		long sekundyWyświtlane = sekundy % 60;
		String Wynik = (String) (minuty + ":" + sekundyWyświtlane);
		return Wynik;
		
	}
	
	public static void pressToLeave(long x) {
		System.out.println("(((   Naciśnij dowolny przycisk aby wrócić do menu głównego   ))) ");
		@SuppressWarnings("unused")//jest potrzebny i tyle
		String k = franek.nextLine();
		Interface.main_menu(x);

	}
	public static  double experienceHelper() {
	    double experience;
	    String maciek = franek.nextLine();
	    while (true) {
	        System.out.print("Podaj wartość doświadczenia (liczbową): ");
	        

	        try {
	            experience = Double.parseDouble(maciek);
	            break;
	        } catch (NumberFormatException e) {
	            System.out.println("Niepoprawny input. Spróbuj ponownie.");
	        }
	        
	    }
	    return experience;
	}
	public static void expHelperUltraProMax(int option, Analyzer x) {
	    
	    double experience;

	    while (true) {
	        System.out.print("Podaj wartość doświadczenia (liczbową): ");
	        String input = franek.nextLine();

	        try {
	            experience = Double.parseDouble(input);
	            break; 
	        } catch (NumberFormatException e) {
	            System.out.println("Niepoprawny input. Spróbuj ponownie.");
	        }
	    }

	    x.filterByExperience(experience, option);
	}
	public static void ageHelperUltraProMax(int option, Analyzer x) {
	    
	    int age;

	    while (true) {
	        System.out.print("Podaj wiek: ");
	        String input = franek.nextLine();

	        try {
	            age = Integer.parseInt(input);
	            break; 
	        } catch (NumberFormatException e) {
	            System.out.println("Niepoprawny input. Spróbuj ponownie.");
	        }
	    }

	    x.filterByAge(age, option);
	}
	
	


			
		
		
	
		
	
}
    

	
	

