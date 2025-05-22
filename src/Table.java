import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// Klasa do wczytywania danych pracowników z pliku i przechowywania ich w liście
public class Table {
    // Lista przechowująca obiekty pracowników
    ArrayList<ComparableEmployers> tab = new ArrayList<ComparableEmployers>();
    // Obiekt Scanner do odczytywania danych z pliku
    Scanner scan;

    // Konstruktor wczytujący dane pracowników z pliku o podanej nazwie
    public Table(String fileName) {
        try {
            // Inicjalizuje Scanner dla pliku o podanej ścieżce
            scan = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            // Obsługuje wyjątek w przypadku braku pliku
            e.printStackTrace();
        }
        try {
            // Odczytuje linie z pliku
            while (scan.hasNextLine()) {
                String line = scan.nextLine(); // Pobiera kolejną linię
                // Dzieli linię na wartości oddzielone przecinkami
                String[] values = line.split(",");
                // Tworzy nowy obiekt pracownika na podstawie danych z linii
                ComparableEmployers object = new ComparableEmployers(
                        values[0].trim(), // Imię
                        values[1].trim(), // Nazwisko
                        Integer.parseInt(values[2].trim()), // Wiek
                        values[3].trim(), // Data zatrudnienia
                        values[4].trim(), // Płeć
                        Double.parseDouble(values[5].trim())); // Wynagrodzenie
                // Dodaje pracownika do listy
                tab.add(object);
            }
        } finally {
            // Zamyka Scanner, aby zwolnić zasoby
            scan.close();
        }
    }

    // Zwraca listę pracowników
    public ArrayList<ComparableEmployers> getTab() {
        return tab;
    }
}