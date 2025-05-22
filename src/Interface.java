import java.util.ArrayList;
import java.util.Scanner;

// Klasa obsługująca interfejs użytkownika i zarządzanie danymi pracowników
public class Interface {
    // Statyczny obiekt Scanner do odczytywania danych z konsoli
    static Scanner fred = new Scanner(System.in);

    // Wewnętrzna klasa do wczytywania i przechowywania danych pracowników
    public static class wczytywanie {
        // Ścieżka do pliku z danymi pracowników
        private static String fileName = "C:\\Users\\wiesz\\OneDrive\\Dokumenty\\inputData.txt";
        // Obiekt Table do wczytywania danych z pliku
        private static Table listaP = new Table(fileName);
        // Lista pracowników wczytanych z pliku
        public static ArrayList<ComparableEmployers> table1 = listaP.getTab();
        // Obiekt Analyzer do analizy i manipulacji danymi pracowników
        private static Analyzer analyze = new Analyzer(table1);
    }

    // Wyświetla menu główne i obsługuje wybory użytkownika
    public static void main_menu(long x) {
        // Wyświetla bieżącą datę, nagłówek menu i czas działania programu
        System.out.println(Handyones.Date() + " ||Menu Główne|| Runtime: " + Handyones.Runtime(x));
        System.out.println();
        System.out.println(" 1.Statystyki");
        System.out.println(" 2.Zarządzaj Pracownikami");
        System.out.println(" 3.Przeglądaj Pracowników");
        System.out.println(" 4.Zamknij Program");
        System.out.println();

        boolean poprawnywybor = false;
        // Pętla do obsługi wyboru użytkownika
        while (!poprawnywybor) {
            String choice = fred.nextLine();
            switch (choice) {
                case "1":
                    statystyki(x); // Wyświetla statystyki
                    poprawnywybor = true;
                    break;
                case "2":
                    hr(x); // Przechodzi do modułu HR
                    poprawnywybor = true;
                    break;
                case "3":
                    printPracownicy(x); // Przegląda listę pracowników
                    poprawnywybor = true;
                    break;
                case "4":
                    poprawnywybor = true;
                    fin(x); // Zamyka program
                    break;
                default:
                    // Informuje o nieprawidłowym wyborze
                    System.out.println("Niepoprawny wybór " + choice + ". Wybierz liczbę z przedziału <1;4>");
            }
        }
    }

    // Wyświetla statystyki o pracownikach
    private static void statystyki(long x) {
        // Wyświetla datę, nagłówek i czas działania
        System.out.println(Handyones.Date() + " ||Statystyki|| Runtime: " + Handyones.Runtime(x));
        System.out.println();
        // Wyświetla statystyki, takie jak średnie zarobki, liczba kobiet/mężczyzn, mediana itp.
        System.out.println("- Średnie zarobki: " + Stats.meanOp(wczytywanie.table1, 1));
        System.out.println("- Ilość Kobiet: " + Stats.countM(wczytywanie.table1, "K"));
        System.out.println("- Ilość Mężczyzn: " + Stats.countM(wczytywanie.table1, "M"));
        System.out.println("- Mediana Zarobki: " + Stats.medianZarobki(wczytywanie.table1));
        System.out.println("- Średnia wieku pracowników: " + Stats.meanOp(wczytywanie.table1, 2));
        Handyones.pressToLeave(x); // Czeka na naciśnięcie klawisza i wraca do menu
    }

    // Moduł HR do zarządzania pracownikami
    private static void hr(long x) {
        // Wyświetla datę, nagłówek i czas działania
        System.out.println(Handyones.Date() + " ||Moduł HR|| Runtime: " + Handyones.Runtime(x));
        System.out.println();
        System.out.println("1. Dodaj Pracownika");
        System.out.println("2. Usuń Pracownika");
        System.out.println("3. Powrót");

        boolean poprawnywybor = false;
        // Pętla do obsługi wyboru użytkownika
        while (!poprawnywybor) {
            String choice = fred.nextLine();
            switch (choice) {
                case "1":
                    DodajPracownika(x); // Dodaje nowego pracownika
                    poprawnywybor = true;
                    break;
                case "2":
                    UsunPracownika(x); // Usuwa pracownika
                    poprawnywybor = true;
                    break;
                case "3":
                    main_menu(x); // Wraca do menu głównego
                    poprawnywybor = true;
                    break;
                default:
                    // Informuje o nieprawidłowym wyborze
                    System.out.println("Niepoprawny wybór " + choice + ". Wybierz liczbę z przedziału <1;3>");
            }
        }
    }

    // Wyświetla listę pracowników i umożliwia ich filtrowanie/sortowanie
    private static void printPracownicy(long x) {
        // Wyświetla datę, nagłówek i czas działania
        System.out.println(Handyones.Date() + " ||Lista Pracowników|| Runtime: " + Handyones.Runtime(x));
        System.out.println("1. Wyszukaj Pracownika.");
        System.out.println("2. Sortuj po pensji rosnąco i wyświetl.");
        System.out.println("3. Sortuj po pensji malejąco i wyświtl.");
        System.out.println("4. Filtruj tylko mężczyzn.");
        System.out.println("5. Filtruj tylko Kobiety.");
        System.out.println("6. Filtruj według doświadczenia.");
        System.out.println("7. Filtruj według wieku");
        System.out.println("8. Filtruj wedlug daty");
        System.out.println("9. Filtruj według imienia");
        System.out.println("10. Filtruj według nazwiska");
        System.out.println("11. Powrót");

        boolean poprawnywybor = false;
        // Tworzy kopię listy pracowników do filtrowania
        ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
        Analyzer brad = new Analyzer(table2);

        // Pętla do obsługi wyboru użytkownika
        while (!poprawnywybor) {
            String choice = fred.nextLine();
            switch (choice) {
                case "1":
                    // Wyszukuje pracownika po imieniu i nazwisku
                    System.out.println("Podaj imię Pracownika");
                    String name = fred.nextLine();
                    brad.filterByName(name);
                    System.out.println("Podaj nazwisko Pracownika");
                    String surname = fred.nextLine();
                    brad.filterBySurname(surname);
                    brad.printTable();
                    if (table2.size() == 0) {
                        System.out.println("Nie ma takiego Pracownika.");
                    }
                    poprawnywybor = true;
                    break;
                case "2":
                    // Sortuje pracowników po pensji rosnąco i wyświetla
                    brad.sortSalary(true);
                    brad.printTable();
                    poprawnywybor = true;
                    break;
                case "3":
                    // Sortuje pracowników po pensji malejąco i wyświetla
                    brad.sortSalary(false);
                    brad.printTable();
                    poprawnywybor = true;
                    break;
                case "4":
                    // Filtruje tylko mężczyzn i wyświetla
                    brad.filterBySex("M");
                    brad.printTable();
                    poprawnywybor = true;
                    break;
                case "5":
                    // Filtruje tylko kobiety i wyświetla
                    brad.filterBySex("K");
                    brad.printTable();
                    poprawnywybor = true;
                    break;
                case "6":
                    exp(x); // Filtruje po doświadczeniu
                    poprawnywybor = true;
                    break;
                case "7":
                    age(x); // Filtruje po wieku
                    break;
                case "8":
                    date(x); // Filtruje po dacie zatrudnienia
                    break;
                case "9":
                    name(x); // Filtruje po imieniu
                    break;
                case "10":
                    surname(x); // Filtruje po nazwisku
                    break;
                case "11":
                    main_menu(x); // Wraca do menu głównego
                    poprawnywybor = true;
                    break;
                default:
                    // Informuje o nieprawidłowym wyborze
                    System.out.println("Niepoprawny wybór " + choice + ". Wybierz liczbę z przedziału <1;11>");
            }
        }
        Handyones.pressToLeave(x); // Czeka na naciśnięcie klawisza i wraca do menu
    }

    // Filtruje pracowników po nazwisku i wyświetla wyniki
    private static void surname(long x) {
        System.out.println("Podaj mi nazwisko, po którym chcesz przefiltrować");
        String surname = fred.nextLine();
        ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
        Analyzer brad = new Analyzer(table2);
        brad.filterBySurname(surname);
        brad.printTable();
        if (table2.size() == 0) {
            System.out.println("Nie ma pracownika o takim nazwisku");
        }
        Handyones.pressToLeave(x); // Czeka na naciśnięcie klawisza i wraca do menu
    }

    // Filtruje pracowników po imieniu i wyświetla wyniki
    private static void name(long x) {
        System.out.println("Podaj mi imię, po którym chcesz przefiltrować");
        String name = fred.nextLine();
        ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
        Analyzer brad = new Analyzer(table2);
        brad.filterByName(name);
        brad.printTable();
        if (table2.size() == 0) {
            System.out.println("Nie ma pracownika o takim imieniu");
        }
        Handyones.pressToLeave(x); // Czeka na naciśnięcie klawisza i wraca do menu
    }

    // Filtruje pracowników po dacie zatrudnienia i wyświetla wyniki
    private static void date(long x) {
        System.out.println("Podaj mi datę, po której chcesz przefiltrować(dd.MM.yyyy)");
        String date = fred.nextLine();
        ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
        Analyzer brad = new Analyzer(table2);
        brad.filterByDate(date);
        brad.printTable();
        if (table2.size() == 0) {
            System.out.println("Nie ma pracownika o takiej dacie przyjęcia do firmy");
        }
        Handyones.pressToLeave(x); // Czeka na naciśnięcie klawisza i wraca do menu
    }

    // Filtruje pracowników po doświadczeniu z wyborem opcji filtrowania
    private static void exp(long x) {
        // Wyświetla opcje filtrowania po doświadczeniu
        System.out.println("      Filtrowanie po doświadczeniu");
        System.out.println(" 1. Doświadczenie większe niż.");
        System.out.println(" 2. Doświadczenie większe lub równy.");
        System.out.println(" 3. Doświadczenie mniejsze niż.");
        System.out.println(" 4. Doświadczenie mniejsze bądz równe.");
        System.out.println(" 5. Doświadczenie równe.");

        ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
        Analyzer brad = new Analyzer(table2);
        boolean poprawnywybor = false;
        // Pętla do obsługi wyboru użytkownika
        while (!poprawnywybor) {
            String choice = fred.nextLine();
            switch (choice) {
                case "1":
                    Handyones.expHelperUltraProMax(4, brad); // Większe niż
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                case "2":
                    Handyones.expHelperUltraProMax(2, brad); // Większe lub równe
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                case "3":
                    Handyones.expHelperUltraProMax(5, brad); // Mniejsze niż
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                case "4":
                    Handyones.expHelperUltraProMax(3, brad); // Mniejsze lub równe
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                case "5":
                    Handyones.expHelperUltraProMax(1, brad); // Równe
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                default:
                    // Informuje o nieprawidłowym wyborze
                    System.out.println("Niepoprawny wybór " + choice + ". Wybierz liczbę z przedziału <1;5>");
            }
        }
        Handyones.pressToLeave(x); // Czeka na naciśnięcie klawisza i wraca do menu
    }

    // Filtruje pracowników po wieku z wyborem opcji filtrowania
    private static void age(long x) {
        // Wyświetla opcje filtrowania po wieku
        System.out.println("      Filtrowanie po wieku");
        System.out.println(" 1. Wiek większy niż.");
        System.out.println(" 2. Wiek większy lub równy.");
        System.out.println(" 3. Wiek mniejszy.");
        System.out.println(" 4. Wiek mniejszy bądz równy.");
        System.out.println(" 5. Wiek równy.");

        ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
        Analyzer brad = new Analyzer(table2);
        boolean poprawnywybor = false;
        // Pętla do obsługi wyboru użytkownika
        while (!poprawnywybor) {
            String choice = fred.nextLine();
            switch (choice) {
                case "1":
                    Handyones.ageHelperUltraProMax(4, brad); // Większy niż
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                case "2":
                    Handyones.ageHelperUltraProMax(2, brad); // Większy lub równy
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                case "3":
                    Handyones.ageHelperUltraProMax(5, brad); // Mniejszy niż
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                case "4":
                    Handyones.ageHelperUltraProMax(3, brad); // Mniejszy lub równy
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                case "5":
                    Handyones.ageHelperUltraProMax(1, brad); // Równy
                    poprawnywybor = true;
                    brad.printTable();
                    break;
                default:
                    // Informuje o nieprawidłowym wyborze
                    System.out.println("Niepoprawny wybór " + choice + ". Wybierz liczbę z przedziału <1;5>");
            }
        }
        Handyones.pressToLeave(x); // Czeka na naciśnięcie klawisza i wraca do menu
    }

    // Zamyka program i zapisuje dane do pliku
    private static void fin(long x) {
        // Wyświetla datę i czas działania
        System.out.println(Handyones.Date() + "                     Runtime: " + Handyones.Runtime(x));
        System.out.println("");
        // Zapisuje dane pracowników do pliku
        FileSaver.saveToFile(wczytywanie.fileName, wczytywanie.table1);
        System.out.println("Pliki zostały zapisane.");
        System.out.println("Dziękujemy za korzystanie z naszego Programu");
    }

    // Dodaje nowego pracownika do listy
    private static void DodajPracownika(long x) {
        // Wyświetla datę, nagłówek i czas działania
        System.out.println(Handyones.Date() + " ||Dodawanie Pracownika|| Runtime: " + Handyones.Runtime(x));
        ComparableEmployers pies;
        while (true) {
            try {
                // Pobiera dane nowego pracownika od użytkownika
                System.out.println("Imię: ");
                String name = fred.nextLine();
                System.out.println("Nazwisko: ");
                String surname = fred.nextLine();
                Integer age;
                while(true) {
                System.out.println("Wiek: ");	
                String age1 = fred.nextLine();
                try {
                	age = Integer.parseInt(age1);
                	break;
                } catch(Exception e){
                	System.out.println("Podaj wiek w poprawnym formacie");
                	continue;
                }
                }
                String emp;
                while(true) {
                System.out.println("Data zatrudnienia format (DD.MM.YYYY): ");
                emp = fred.nextLine();
                
                if(Handyones.isValidDateFormat(emp)) {
                	break;
                	}else {
                		System.out.println("Podaj prawidłowy format daty");
                		continue;
                	}
                }
                 
                String sex;
                System.out.println("Podaj płeć pracownika (K/M): ");
                while(true) {
                
                sex = fred.nextLine();
                if(sex.equals("M") || sex.equals("K")) {
                	break;
                }else {
                	System.out.println("Podaj prawidłowy format płci");
                	continue;
                }
                }
                Double salary;
                while(true) {
                System.out.println("Wynagrodzenie: ");
                String salary1 = fred.nextLine();
                try {
                	salary = Double.parseDouble(salary1);
                	break;
                }catch(Exception e) {
                	System.out.println("Podaj prawidłowy format wynagrodzenia");
                }
                }

                // Tworzy nowy obiekt pracownika
                pies = new ComparableEmployers(name, surname, age, emp, sex, salary);
                break;
            } catch (NumberFormatException e) {
                // Obsługuje błąd nieprawidłowego formatu liczb
                System.out.println("Invalid input. Try again.");
            }
        }
        // Dodaje pracownika do listy
        wczytywanie.table1.add(pies);
        System.out.println("Pracownik został Dodany");
        System.out.println("Naciśnij dowolny przycisk aby powrócić.");
        hr(x); // Wraca do modułu HR
    }

    // Usuwa pracownika z listy na podstawie imienia i nazwiska
    public static void UsunPracownika(long x) {
        // Wyświetla datę, nagłówek i czas działania
        System.out.println(Handyones.Date() + " ||Usuń Pracownika|| Runtime: " + Handyones.Runtime(x));
        System.out.println("Podaj imię i nazwisko pracownika:");
        String[] input;
        // Pętla do uzyskania prawidłowego formatu wejścia
        while (true) {
            input = fred.nextLine().split(" ");
            if (input.length != 2) {
                System.out.println("Wpisz imię i nazwisko po spacji.");
                continue;
            } else {
                break;
            }
        }
        String Name = input[0];
        String Surname = input[1];
        // Tworzy kopię listy pracowników do filtrowania
        ArrayList<ComparableEmployers> table2 = new ArrayList<>(wczytywanie.table1);
        Analyzer brad = new Analyzer(table2);
        brad.filterBySurname(Surname);
        int l = table2.size();
        // Usuwa pracownika z głównej listy
        wczytywanie.analyze.delete(Name, Surname);
        brad.delete(Name, Surname);
        // Informuje o wyniku operacji
        if (l > 0) {
            System.out.println("Usunięto pracownika.");
        } else {
            System.out.println("Nie ma takiego pracownika");
        }
        Handyones.pressToLeave(x); // Czeka na naciśnięcie klawisza i wraca do menu
    }
}