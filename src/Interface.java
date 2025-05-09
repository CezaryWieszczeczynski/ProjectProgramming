package programowanie_komputerow_1;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Interface {
	static Scanner fred = new Scanner(System.in);
	
	
	
	
	
	
	public static void main_menu(long x) {
		System.out.println(Handyones.Date() + " ||Moduł HR|| Runtime: " + Handyones.Runtime(x));
		System.out.println();
		System.out.println(" 1.Statystyki");
		System.out.println(" 2.Zarządzaj Pracownikami");
		System.out.println(" 3.Wyświetl Wszystkich Pracowników");
		System.out.println(" 4.Zamknij Program");
		System.out.println();
		
		
		boolean poprawnywybor = false;
	while (!poprawnywybor) {
		String choice = fred.nextLine();
		
		switch (choice) {
		case "1":
			statystyki(x);
			poprawnywybor = true;
			break;
		case "2":
			hr(x);
			poprawnywybor = true;
			break;
		case "3":
			printPracownicy(x);
			poprawnywybor = true;
			break;
		case "4":
			poprawnywybor = true;
			fin(x);
			break;
		default:
			System.out.println("Niepoprawny wybór" + choice + ". Wybierz liczbę z przedziału <1;4>");
						
		}
		}
	}
	

	private static void statystyki(long x) {
		System.out.println(Handyones.Date() + " ||Statystyki|| Runtime: " + Handyones.Runtime(x));
		
			
		
		System.out.println();
		
	}
	


	private static void hr(long x) {
		System.out.println(Handyones.Date() + " ||Moduł HR|| Runtime: " + Handyones.Runtime(x));
		System.out.println();
		System.out.println("1. Dodaj Pracownika");
		System.out.println("2. Usuń Pracownika");
		System.out.println("3. Powrót");
		
		boolean poprawnywybor = false;
	while (!poprawnywybor) {
		String choice = fred.nextLine();
		
		switch (choice) {
		case "1":
			DodajPracownika(x);
			poprawnywybor = true;
			break;
		case "2":
			UsunPracownika(x);
			poprawnywybor = true;
			break;
		case "3":
			main_menu(x);
			poprawnywybor = true;
			break;
		default:
			System.out.println("Niepoprawny wybór" + choice + ". Wybierz liczbę z przedziału <1;3>");
						
		}
		}

		
		System.out.println();
		
		
	}

	
	
	private static void printPracownicy(long x) {
		System.out.println(Handyones.Date() + " ||Lista Pracowników|| Runtime: " + Handyones.Runtime(x));
		
		
			
			
		System.out.println("Naciśnij dowolny przycisk aby powrócić.");
		String choice = fred.nextLine(); 
		hr(x);
		
	}
	
	
	private static void fin(long x) {
		System.out.println("Dziękujemy za Uwagę B)");
		
	}

	private static void DodajPracownika(long x) {
		System.out.println(Handyones.Date() + " ||Dodawanie Pracownika|| Runtime: " + Handyones.Runtime(x));

		// comparaemployer pies = new ccomparaemployer(...)
		System.out.println("Naciśnij dowolny przycisk aby powrócić.");
		String choice = fred.nextLine(); 
		hr(x);
		//table.add 
		
		
	}
	
	private static void UsunPracownika(long x) {
		System.out.println(Handyones.Date() + " ||Usuń Pracownika|| Runtime: " + Handyones.Runtime(x));
		//się wyklepie
		
		System.out.println("Wpisz * aby anulować");
	}



















	
	
	
	
	
	
	
	
	
	



	
	

}
