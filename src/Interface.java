
import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
	static Scanner fred = new Scanner(System.in);
	
	public class wczytywanie {
	    private static String fileName = "C:\\Users\\wiesz\\OneDrive\\Dokumenty\\inputData.txt";
	    private static Table listaP = new Table(fileName);
	    public static ArrayList<ComparableEmployers> table1 = listaP.getTab();
	    private static Analyzer analyze = new Analyzer(table1);
	}
	
	public static void main_menu(long x) {
		
		
		System.out.println(Handyones.Date() + " ||Menu Główne|| Runtime: " + Handyones.Runtime(x));
		System.out.println();
		System.out.println(" 1.Statystyki");
		System.out.println(" 2.Zarządzaj Pracownikami");
		System.out.println(" 3.Przeglądaj Pracowników");
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
		System.out.println("- Średnie zarobki: "+ Stats.meanOp(wczytywanie.table1, 1));
		System.out.println("- Ilość Kobiet: "+Stats.countM(wczytywanie.table1, "K"));
		System.out.println("- Ilość Mężczyzn: "+Stats.countM(wczytywanie.table1, "M"));
		System.out.println("- Mediana Zarobki: "+Stats.medianZarobki(wczytywanie.table1));
		System.out.println("- Średnia wieku pracowników: "+ Stats.meanOp(wczytywanie.table1, 2) );
		Handyones.pressToLeave(x);
		
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
		System.out.println("1. Wyszukaj Pracownika.");
		System.out.println("2. Sortuj po pensji rosnąco i wyświetl.");
		System.out.println("3. Sortuj po pensji malejąco i wyświtl.");
		System.out.println("4. Filtruj tylko mężczyzn.");
		System.out.println("5. Filtruj tylko Kobiety.");
		System.out.println("6. Filtruj według doświadczenia.");
		System.out.println("7. Filtruj według wieku");
		System.out.println("8. Filtruj wedlug daty");
		System.out.println("9.Filtruj według imienia");
		System.out.println("10.Filtruj według nazwiska");
		System.out.println("11. Powrót");
			
		boolean poprawnywybor = false;
		
		ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
		Analyzer brad = new Analyzer(table2);
		
		while (!poprawnywybor) {
			String choice = fred.nextLine();
			
			switch (choice) {
			case "1":
				System.out.println("Podaj imię Pracownika");
				String name = fred.nextLine();
				brad.filterByName(name);
				System.out.println("Podaj nazwisko Pracownika");
				String surname = fred.nextLine();
				brad.filterBySurname(surname);
				brad.printTable();
				if(table2.size() == 0 ) {System.out.println("Nie ma takiego Pracownika.");}
				poprawnywybor = true;
				break;
			case "2":
				brad.sortSalary(true);
				brad.printTable();
				poprawnywybor = true;
				break;
			case "3":
				brad.sortSalary(false);
				brad.printTable();
				poprawnywybor = true;
				break;
			case "4":
				brad.filterBySex("M");
				brad.printTable();
				poprawnywybor = true;
				break;
			case "5":

				brad.filterBySex("K");
				brad.printTable();
				poprawnywybor = true;
				break;
			case "6":
				exp(x);
				poprawnywybor = true;
				break;
			case "7":
				age(x);
				break;
			case "8":
				date(x);
				break;
			case "9":
				name(x);
				break;
			case "10":
				surname(x);
				break;
			case "11":
				main_menu(x);	
				poprawnywybor = true;
				break;
	
			default:
				System.out.println("Niepoprawny wybór" + choice + ". Wybierz liczbę z przedziału <1;7>");
							
			}
			}
		Handyones.pressToLeave(x);
		

	}
	
	
	private static void surname(long x) {
		System.out.println("Podaj mi nazwisko, po którym chcesz przefiltrować");
		String surname = fred.nextLine();
		ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
		Analyzer brad = new Analyzer(table2);
		brad.filterBySurname(surname);
		brad.printTable();
		if(table2.size() == 0 ) {System.out.println("Nie ma pracownika o takim nazwisku");}
		
		
		Handyones.pressToLeave(x);
		
	}
		
	


	private static void name(long x) {
		System.out.println("Podaj mi imię, po którym chcesz przefiltrować");
		String name = fred.nextLine();
		ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
		Analyzer brad = new Analyzer(table2);
		brad.filterByName(name);
		brad.printTable();
		if(table2.size() == 0 ) {System.out.println("Nie ma pracownika o takim imieniu");}
		
		
		Handyones.pressToLeave(x);
		
	}


	private static void date(long x) {
		System.out.println("Podaj mi datę, po której chcesz przefiltrować(dd.MM.yyyy)");
		String date = fred.nextLine();
		ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
		Analyzer brad = new Analyzer(table2);
		brad.filterByDate(date);
		brad.printTable();
		if(table2.size() == 0 ) {System.out.println("Nie ma pracownika o takiej dacie przyjęcia do firmy");}
		
		
		Handyones.pressToLeave(x);
		
	}


	private static void exp(long x) {
		System.out.println("      Filtrowanie po doświadczeniu");
		System.out.println(" 1. Doświadczenie większe niż.");
		System.out.println(" 2. Doświadczenie większe lub równy.");
		System.out.println(" 3. Doświadczenie mniejsze niż.");
		System.out.println(" 4. Doświadczenie mniejsze bądz równe.");
		System.out.println(" 5. Doświadczenie równe.");
		
		ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
		Analyzer brad = new Analyzer(table2);
		boolean poprawnywybor = false;
		while (!poprawnywybor) {
			String choice = fred.nextLine();
			
			switch (choice) {
			case "1":
				Handyones.expHelperUltraProMax(4, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			case "2":
				Handyones.expHelperUltraProMax(2, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			case "3":
				Handyones.expHelperUltraProMax(5, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			case "4":
				Handyones.expHelperUltraProMax(3, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			case "5":
				Handyones.expHelperUltraProMax(1, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			default:
				System.out.println("Niepoprawny wybór" + choice + ". Wybierz liczbę z przedziału <1;5>");
							
			}
			}
		Handyones.pressToLeave(x);
		
	}
	private static void age(long x) {
		System.out.println("      Filtrowanie po wieku");
		System.out.println(" 1. Wiek większy niż.");
		System.out.println(" 2. Wiek większy lub równy.");
		System.out.println(" 3. Wiek mniejszy.");
		System.out.println(" 4. Wiek mniejszy bądz równy.");
		System.out.println(" 5. Wiek równy.");
		
		ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
		Analyzer brad = new Analyzer(table2);
		boolean poprawnywybor = false;
		while (!poprawnywybor) {
			String choice = fred.nextLine();
			
			switch (choice) {
			case "1":
				Handyones.ageHelperUltraProMax(4, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			case "2":
				Handyones.ageHelperUltraProMax(2, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			case "3":
				Handyones.ageHelperUltraProMax(5, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			case "4":
				Handyones.ageHelperUltraProMax(3, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			case "5":
				Handyones.ageHelperUltraProMax(1, brad);
				poprawnywybor = true;
				brad.printTable();
				break;
			default:
				System.out.println("Niepoprawny wybór" + choice + ". Wybierz liczbę z przedziału <1;5>");
							
			}
			}
		Handyones.pressToLeave(x);
		
	}


	private static void fin(long x) {
		System.out.println(Handyones.Date() + "                     Runtime: " + Handyones.Runtime(x));
		System.out.println("");
		FileSaver.saveToFile(wczytywanie.fileName, wczytywanie.table1);
		System.out.println("Pliki zostały zapisane.");
		System.out.println("Dziękujemy za korzystanie z naszego Programu");
		
	}

	private static void DodajPracownika(long x) {
		
		System.out.println(Handyones.Date() + " ||Dodawanie Pracownika|| Runtime: " + Handyones.Runtime(x));
		ComparableEmployers pies;
		while(true) {
			try {
				System.out.println("Imię: ");
				String name = fred.nextLine();
				System.out.println("Nazwisko: ");
				String surname = fred.nextLine();
				System.out.println("Wiek: ");
				String age = fred.nextLine();
				System.out.println("Data zatrudnienia format (DD.MM.YYYY): ");
				String emp = fred.nextLine();
				System.out.println("Podaj płeć pracownika (K/M): ");
				String sex = fred.nextLine();
				System.out.println("Wynagrozdenie: ");
				String salary = fred.nextLine();
				
				pies = new ComparableEmployers(name, surname,Integer.parseInt(age), emp, sex, Double.parseDouble(salary));
				break;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.");
        }
		}
		wczytywanie.table1.add(pies);
		System.out.println("Pracownik został Dodany");
		System.out.println("Naciśnij dowolny przycisk aby powrócić.");
		
		
		hr(x);
		//table.add 
		
		
	}
	
	public static void UsunPracownika(long x) {
		System.out.println(Handyones.Date() + " ||Usuń Pracownika|| Runtime: " + Handyones.Runtime(x));
		System.out.println("Podaj imię i nazwisko pracownika:");
		String[] input;
		while(true) {
			input = fred.nextLine().split(" ");

        	if (input.length != 2) {
        		System.out.println("Wpisz imię i nazwisko po spacji.");
        		continue;
        	}else {
        		break;
        	}
        }  
		String Name = input[0];
		String Surname = input[1];
		ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
		Analyzer brad = new Analyzer(table2);
		brad.filterBySurname(Surname);
		int l = table2.size();
		wczytywanie.analyze.delete(Name, Surname);
		brad.delete(Name,Surname);
		if (l > 0) {System.out.println("Usunięto pracownika.");}
		else {System.out.println("Nie ma takiego pracownika");}
		
		
		Handyones.pressToLeave(x);

	}



















	
	
	
	
	
	
	
	
	
	



	
	

}
