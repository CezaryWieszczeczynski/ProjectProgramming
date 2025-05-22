import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// Klasa do obliczania statystyk dla listy pracowników
public class Stats {
    // Kopia listy pracowników z klasy Interface.wczytywanie
    private static ArrayList<ComparableEmployers> table2 = new ArrayList<>(Interface.wczytywanie.table1);
    // Obiekt Analyzer do manipulacji danymi pracowników
    private static Analyzer analyze = new Analyzer(table2);

    // Oblicza średnią wartość dla wynagrodzenia lub wieku pracowników
    public static float meanOp(ArrayList<ComparableEmployers> table, int option) {
        float Suma = 0;  
        // Iterator do przeglądania listy pracowników
        Iterator<ComparableEmployers> iterator = table.iterator();
        switch (option) {
            case 1: // Średnie wynagrodzenie
                while (iterator.hasNext()) {
                    ComparableEmployers Jack = iterator.next();
                    Suma += Jack.getSalary(); // Dodaje wynagrodzenie pracownika do sumy
                }
                float mean = Suma / table.size(); // Oblicza średnią wynagrodzenia
                return mean;

            case 2: // Średni wiek
                while (iterator.hasNext()) {
                    ComparableEmployers Jack = iterator.next();
                    Suma += Jack.getAge(); // Dodaje wiek pracownika do sumy
                }
                float meanA = Suma / table.size(); // Oblicza średnią wieku
                return meanA;
            default:
                return 0; // Zwraca 0 dla nieprawidłowej opcji
        }
    }

    // Zlicza liczbę pracowników o określonej płci
    public static int countM(ArrayList<ComparableEmployers> table, String a) {
        // Tworzy kopię listy pracowników
        ArrayList<ComparableEmployers> table2 = new ArrayList<>(Interface.wczytywanie.table1);
        // Tworzy obiekt Analyzer do filtrowania danych
        Analyzer analyzeQuick = new Analyzer(table2);
        analyzeQuick.filterBySex(a); // Filtruje pracowników według podanej płci
        return table2.size(); // Zwraca liczbę pracowników po filtrze
    }

    // Oblicza medianę wynagrodzeń pracowników
    public static double medianZarobki(ArrayList<ComparableEmployers> table) {
        if (table.isEmpty()) return 0; // Zwraca 0, jeśli lista jest pusta

        // Tworzy listę wynagrodzeń pracowników
        ArrayList<Double> salaries = new ArrayList<>();
        for (ComparableEmployers i : table) {
            salaries.add(i.getSalary()); // Dodaje wynagrodzenie każdego pracownika
        }

        Collections.sort(salaries); // Sortuje listę wynagrodzeń rosnąco

        int size = salaries.size();
        if (size % 2 == 1) {
            // Dla nieparzystej liczby elementów zwraca środkowy element
            return salaries.get(size / 2);
        } else {
            // Dla parzystej liczby elementów oblicza średnią dwóch środkowych
            double mediana = (salaries.get(size / 2 - 1) + salaries.get(size / 2)) / 2;
            return mediana;
        }
    }
}