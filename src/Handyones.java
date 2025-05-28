import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Klasa zawierająca metody pomocnicze do obsługi daty, czasu, wejścia użytkownika i interakcji z menu
public class Handyones {
    // Statyczny obiekt Scanner do odczytywania danych z konsoli
    static Scanner franek = new Scanner(System.in);

    // Zwraca bieżący czas w formacie HH:mm
    public static String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        return timeFormat.format(new Date());
    }
    
    // Zwraca bieżącą datę w formacie dd.MM.yyyy
    public static String Date() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String formattedDate = dateFormat.format(currentDate);
        return formattedDate;
    }
    
    // Oblicza czas działania programu w formacie minuty:sekundy na podstawie czasu startu
    public static String Runtime(long pies) {
        long endTime = System.currentTimeMillis();
        long runTime = endTime - pies; // Oblicza czas działania w milisekundach
        long sekundy = runTime / 1000; // Konwertuje na sekundy
        long minuty = sekundy / 60; // Oblicza pełne minuty
        long sekundyWyświetlane = sekundy % 60; // Oblicza pozostałe sekundy
        String Wynik = (String) (minuty + ":" + sekundyWyświetlane); // Formatuje wynik jako minuty:sekundy
        return Wynik;
    }
    
    // Czeka na naciśnięcie klawisza i wraca do menu głównego
    public static void pressToLeave(long x) {
        System.out.println("(((   Naciśnij dowolny przycisk aby wrócić do menu głównego   ))) ");
        @SuppressWarnings("unused") // Ignoruje ostrzeżenie o nieużywanym zmiennej
        String k = franek.nextLine(); // Odczytuje linię wejścia użytkownika
        Interface.main_menu(x); // Wywołuje metodę menu głównego z klasy Interface
    }

 

    // Filtruje listę pracowników według doświadczenia z podaną wartością i opcją
    public static void expHelperUltraProMax(int option, Analyzer x) {
        double experience;
        while (true) {
            System.out.print("Podaj wartość doświadczenia (liczbową): ");
            String input = franek.nextLine(); // Odczytuje wejście użytkownika
            try {
                experience = Double.parseDouble(input); // Próbuje skonwertować wejście na liczbę
                break; // Kończy pętlę, jeśli konwersja się uda
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny input. Spróbuj ponownie.");
            }
        }
        x.filterByExperience(experience, option); // Filtruje listę pracowników w obiekcie Analyzer
    }

    // Filtruje listę pracowników według wieku z podaną wartością i opcją
    public static void ageHelperUltraProMax(int option, Analyzer x) {
        int age;
        while (true) {
            System.out.print("Podaj wiek: ");
            String input = franek.nextLine(); // Odczytuje wejście użytkownika
            try {
                age = Integer.parseInt(input); // Próbuje skonwertować wejście na liczbę całkowitą
                break; // Kończy pętlę, jeśli konwersja się uda
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny input. Spróbuj ponownie.");
            }
        }
        x.filterByAge(age, option); // Filtruje listę pracowników w obiekcie Analyzer
    }
    //metoda pomocnicza do sprawdzenia, czy data została przekazana w poprawnym formacie
    public static boolean isValidDateFormat(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false); // Wyłącza luźne parsowanie (np. 32.13.2023 będzie błędem)
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static void getFilePath() throws IOException{
    	System.out.println("Podaj ścieżkę z której odczytujesz plik");
    	String fileName1 = franek.nextLine();
    	File file = new File(fileName1);
    	if(!file.exists()) {
    		throw new IOException();
    	}else {
    		Interface.wczytywanie.fileName = fileName1;
    	}
    	
    	
    	
    }
}