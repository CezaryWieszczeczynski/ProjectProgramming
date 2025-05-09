import java.util.ArrayList;
import java.util.Iterator;

public class Analyzer {
    ArrayList<ComparableEmployers> table;

    public Analyzer(ArrayList<ComparableEmployers> table) {
        this.table = table;
    }

    public void sortAge(boolean sorting) {
        table.sort(sorting ? new AgeComparator() : new AgeComparator().reversed());
    }

    public void sortSalary(boolean sorting) {
        table.sort(sorting ? new SalaryComparator() : new SalaryComparator().reversed());
    }

    public void sortExperience(boolean sorting) {
        table.sort(sorting ? new ExperienceComparator() : new ExperienceComparator().reversed());
    }

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

    public void filterBySex(String sex) {
        if (sex == null) return; 
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            if (!employer.getSex().equals(sex)) {
                iterator.remove();
            }
        }
    }

    public void filterBySalary(double salary, int option) {
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            boolean remove = false;
            switch (option) {
                case 1: 
                    remove = employer.getSalary() != salary;
                    break;
                case 2: 
                    remove = employer.getSalary() >= salary;
                    break;
                case 3: 
                    remove = employer.getSalary() <= salary;
                    break;
                case 4:
                    remove = employer.getSalary() > salary;
                    break;
                case 5: 
                    remove = employer.getSalary() < salary;
                    break;
                default:
                    return; 
            }
            if (remove) {
                iterator.remove();
            }
        }
    }

    public void filterByExperience(double experience, int option) {
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            boolean remove = false;
            switch (option) {
                case 1: 
                    remove = employer.getExperience() != experience;
                    break;
                case 2: 
                    remove = employer.getExperience() >= experience;
                    break;
                case 3: 
                    remove = employer.getExperience() <= experience;
                    break;
                case 4: 
                    remove = employer.getExperience() > experience;
                    break;
                case 5: 
                    remove = employer.getExperience() < experience;
                    break;
                default:
                    return; 
            }
            if (remove) {
                iterator.remove();
            }
        }
    }

    public void filterByName(String name) {
        if (name == null) return; 
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            if (!employer.getName().equals(name)) {
                iterator.remove();
            }
        }
    }

    public void filterBySurname(String surname) {
        if (surname == null) return; // Walidacja
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            if (!employer.getSurname().equals(surname)) {
                iterator.remove();
            }
        }
    }

    public void filterByDate(String date) {
        if (date == null) return; 
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            if (!employer.getDate().equals(date)) {
                iterator.remove();
            }
        }
    }

    public void filterByAge(int age, int option) {
        Iterator<ComparableEmployers> iterator = table.iterator();
        while (iterator.hasNext()) {
            ComparableEmployers employer = iterator.next();
            boolean remove = false;
            switch (option) {
                case 1: 
                    remove = employer.getAge() != age;
                    break;
                case 2: 
                    remove = employer.getAge() >= age;
                    break;
                case 3: 
                    remove = employer.getAge() <= age;
                    break;
                case 4: 
                    remove = employer.getAge() > age;
                    break;
                case 5:
                    remove = employer.getAge() < age;
                    break;
                default:
                    return; 
            }
            if (remove) {
                iterator.remove();
            }
        }
    }
    /*public void delete(String Surname) {
    	Iterator iterator = table.iterator();
    	While(iterator.hasNext())
    	
    }*/
}
