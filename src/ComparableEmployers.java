import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

// Klasa reprezentująca pracownika z atrybutami i logiką porównywania
public class ComparableEmployers {
    // Imię pracownika
    private String name;
    // Nazwisko pracownika
    private String surname;
    // Wiek pracownika w latach
    private Integer age;
    // Data zatrudnienia w formacie "dd.MM.yyyy"
    private String date;
    // Płeć pracownika (np. "M" lub "K")
    private String sex;
    // Wynagrodzenie pracownika
    private Double salary;
    // Lata doświadczenia pracownika, obliczane na podstawie daty zatrudnienia
    private Integer Experience;

    // Konstruktor do inicjalizacji obiektu pracownika z podanymi atrybutami
    public ComparableEmployers(String name, String surname, Integer age, String date, String sex, Double salary) {
        this.setName(name);  
        this.setSurname(surname);
        this.setAge(age);
        this.setDate(date);
        this.setSex(sex);
        this.setSalary(salary);
        this.setExperience();
    }

    // Getter dla lat doświadczenia
    public Integer getExperience() {
        return Experience;
    }

    // Oblicza lata doświadczenia na podstawie daty zatrudnienia i bieżącej daty
    public void setExperience() {
        // Definiuje format daty do parsowania daty zatrudnienia
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        // Parsuje ciąg daty zatrudnienia na obiekt LocalDate
        LocalDate dateExperience = LocalDate.parse(date, formatter);
        // Pobiera bieżącą datę
        LocalDate today = LocalDate.now();
        // Oblicza okres między datą zatrudnienia a dniem dzisiejszym
        Period period = Period.between(dateExperience, today);
        // Ustawia doświadczenie jako liczba lat w okresie
        this.Experience = period.getYears();
    }

    // Getter dla wieku
    public Integer getAge() {
        return age;
    }

    // Setter dla wieku
    public void setAge(Integer age) {
        this.age = age;
    }

    // Getter dla imienia
    public String getName() {
        return name;
    }

    // Setter dla imienia
    public void setName(String name) {
        this.name = name;
    }

    // Getter dla nazwiska
    public String getSurname() {
        return surname;
    }

    // Setter dla nazwiska
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Getter dla daty zatrudnienia
    public String getDate() {
        return date;
    }

    // Setter dla daty zatrudnienia
    public void setDate(String date) {
        this.date = date;
    }

    // Getter dla płci
    public String getSex() {
        return sex;
    }

    // Setter dla płci
    public void setSex(String sex) {
        this.sex = sex;
    }

    // Getter dla wynagrodzenia
    public Double getSalary() {
        return salary;
    }

    // Setter dla wynagrodzenia
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

// Klasa Comparator do sortowania obiektów ComparableEmployers według wieku
class AgeComparator implements Comparator<ComparableEmployers> {
    // Porównuje dwóch pracowników na podstawie ich wieku
    @Override
    public int compare(ComparableEmployers o1, ComparableEmployers o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }    
}

// Klasa Comparator do sortowania obiektów ComparableEmployers według wynagrodzenia
class SalaryComparator implements Comparator<ComparableEmployers> {
    // Porównuje dwóch pracowników na podstawie ich wynagrodzenia
    @Override
    public int compare(ComparableEmployers o1, ComparableEmployers o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}

// Klasa Comparator do sortowania obiektów ComparableEmployers według doświadczenia
class ExperienceComparator implements Comparator<ComparableEmployers> {
    // Porównuje dwóch pracowników na podstawie ich lat doświadczenia
	@Override
    public int compare(ComparableEmployers o1, ComparableEmployers o2) {
        return Integer.compare(o1.getExperience(), o2.getExperience());
    }
}