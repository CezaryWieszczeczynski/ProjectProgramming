import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Klasa do zapisywania danych pracowników do pliku
public class FileSaver {
    // Zapisuje listę pracowników do pliku o podanej ścieżce
    public static void saveToFile(String filePath, List<ComparableEmployers> data) {
        // Używa BufferedWriter do efektywnego zapisu danych do pliku
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            // Iteruje po liście pracowników
            for (ComparableEmployers emp : data) {
                // Zapisuje dane pracownika w formacie CSV (imię, nazwisko, wiek, data, płeć, wynagrodzenie)
                writer.write(emp.getName() + ", " + emp.getSurname() + ", " + emp.getAge() + ", " + emp.getDate() + ", " + emp.getSex() + ", " + emp.getSalary());
                // Dodaje nową linię po każdym rekordzie
                writer.newLine();
            }
            // Informuje o pomyślnym zapisaniu danych
            System.out.println("Zapisano dane do pliku.");
        } catch (IOException e) {
            // Obsługuje wyjątek w przypadku błędu zapisu do pliku
            System.out.println("Błąd podczas zapisu: " + e.getMessage());
        }
    }
}