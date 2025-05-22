import java.util.ArrayList;
import java.util.Iterator;

// Klasa do analizy i manipulacji listą pracowników
public class Analyzer {
    // Lista przechowująca obiekty pracowników
    ArrayList<ComparableEmployers> table;

    // Konstruktor inicjalizujący listę pracowników
    public Analyzer(ArrayList<ComparableEmployers> table) {
        this.table = table;
    }

    // Sortuje listę pracowników według wieku (rosnąco lub malejąco)
    public void sortAge(boolean sorting) {
        table.sort(sorting ? new AgeComparator() : new AgeComparator().reversed());
    }

    // Sortuje listę pracowników według wynagrodzenia (rosnąco lub malejąco)
    public void sortSalary(boolean sorting) {
        table.sort(sorting ? new SalaryComparator() : new SalaryComparator().reversed());
    }

    // Sortuje listę pracowników według doświadczenia (rosnąco lub malejąco)
    public void sortExperience(boolean sorting) {
        table.sort(sorting ? new ExperienceComparator() : new ExperienceComparator().reversed());
    }

    // Wyświetla listę pracowników w formacie tabelarycznym
    public void printTable() {
        for (ComparableEmployers employer : table) {
            System.out.printf("%-15s %-15s %-5d %-15s %-5s %-10.2f %-10d%n",
                    employer.getName(),
                    employer.getSurname(),
                    employer.getAge(),
                    employer.getDate(),
                    employer.getSex(),
                    employer.getSalary(),
                    employer.getExperience());
        }
    }

    // Filtruje listę pracowników według płci
    public void filterBySex(String sex) {
        if (sex == null) return; // Sprawdza, czy parametr nie jest null
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            if (!employer.getSex().equals(sex)) {
                iterator.remove(); // Usuwa pracownika, jeśli płeć nie pasuje
            }
        }
    }

    // Filtruje listę pracowników według wynagrodzenia na podstawie wybranej opcji
    public void filterBySalary(double salary, int option) {
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            boolean keep = false;
            switch (option) {
                case 1: // Równa się podanemu wynagrodzeniu
                    keep = employer.getSalary() == salary;
                    break;
                case 2: // Większe lub równe podanemu wynagrodzeniu
                    keep = employer.getSalary() >= salary;
                    break;
                case 3: // Mniejsze lub równe podanemu wynagrodzeniu
                    keep = employer.getSalary() <= salary;
                    break;
                case 4: // Większe niż podane wynagrodzenie
                    keep = employer.getSalary() > salary;
                    break;
                case 5: // Mniejsze niż podane wynagrodzenie
                    keep = employer.getSalary() < salary;
                    break;
                default:
                    return; // Zwraca, jeśli opcja jest nieprawidłowa
            }
            if (!keep) {
                iterator.remove(); // Usuwa pracownika, jeśli nie spełnia warunku
            }
        }
    }

    // Filtruje listę pracowników według doświadczenia na podstawie wybranej opcji
    public void filterByExperience(double experience, int option) {
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            boolean keep = false;
            switch (option) {
                case 1: // Równa się podanemu doświadczeniu
                    keep = employer.getExperience() == experience;
                    break;
                case 2: // Większe lub równe podanemu doświadczeniu
                    keep = employer.getExperience() >= experience;
                    break;
                case 3: // Mniejsze lub równe podanemu doświadczeniu
                    keep = employer.getExperience() <= experience;
                    break;
                case 4: // Większe niż podane doświadczenie
                    keep = employer.getExperience() > experience;
                    break;
                case 5: // Mniejsze niż podane doświadczenie
                    keep = employer.getExperience() < experience;
                    break;
                default:
                    return; // Zwraca, jeśli opcja jest nieprawidłowa
            }
            if (!keep) {
                iterator.remove(); // Usuwa pracownika, jeśli nie spełnia warunku
            }
        }
    }

    // Filtruje listę pracowników według imienia
    public void filterByName(String name) {
        if (name == null) return; // Sprawdza, czy parametr nie jest null
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            if (!employer.getName().equals(name)) {
                iterator.remove(); // Usuwa pracownika, jeśli imię nie pasuje
            }
        }
    }

    // Filtruje listę pracowników według nazwiska
    public void filterBySurname(String surname) {
        if (surname == null) return; // Sprawdza, czy parametr nie jest null
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            if (!employer.getSurname().equals(surname)) {
                iterator.remove(); // Usuwa pracownika, jeśli nazwisko nie pasuje
            }
        }
    }

    // Filtruje listę pracowników według daty zatrudnienia
    public void filterByDate(String date) {
        if (date == null) return; // Sprawdza, czy parametr nie jest null
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            if (!employer.getDate().equals(date)) {
                iterator.remove(); // Usuwa pracownika, jeśli data nie pasuje
            }
        }
    }

    // Filtruje listę pracowników według wieku na podstawie wybranej opcji
    public void filterByAge(int age, int option) {
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            boolean keep;
            switch (option) {
                case 1: // Równa się podanemu wiekowi
                    keep = employer.getAge() == age;
                    break;
                case 2: // Większe lub równe podanemu wiekowi
                    keep = employer.getAge() >= age;
                    break;
                case 3: // Mniejsze lub równe podanemu wiekowi
                    keep = employer.getAge() <= age;
                    break;
                case 4: // Większe niż podany wiek
                    keep = employer.getAge() > age;
                    break;
                case 5: // Mniejsze niż podany wiek
                    keep = employer.getAge() < age;
                    break;
                default:
                    return; // Zwraca, jeśli opcja jest nieprawidłowa
            }
            if (!keep) {
                iterator.remove(); // Usuwa pracownika, jeśli nie spełnia warunku
            }
        }
    }

    // Usuwa pracownika o podanym imieniu i nazwisku
    public void delete(String name, String surname) {
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            if (employer.getSurname().equals(surname) && employer.getName().equals(name)) {
                iterator.remove(); // Usuwa pracownika, jeśli imię i nazwisko pasują
            }
        }
    }

    // Zwraca listę pracowników
    public ArrayList<ComparableEmployers> getTable() {
        return table;
    }
}