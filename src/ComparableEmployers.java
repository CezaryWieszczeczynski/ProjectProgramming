import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class ComparableEmployers {
		private String name;
		private String surname;
		private Integer age;
		private String date;
		private String sex;
		private Double salary;
		private Integer Experience;
		
	public ComparableEmployers(String name, String surname, Integer age, String date, String sex, Double salary) {
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
		this.setDate(date);
		this.setSex(sex);
		this.setSalary(salary);
		
	}
	public Integer getExperience() {
		return Experience;
	}
	public void setExperience() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate dateExperience = LocalDate.parse(date, formatter);
		LocalDate today = LocalDate.now();
		Period period = Period.between(dateExperience, today);
		this.Experience = period.getYears();
	}
	
	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	};
	

	

}
class AgeComparator implements Comparator<ComparableEmployers>{

	@Override
	public int compare(ComparableEmployers o1, ComparableEmployers o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}	
}
class SalaryComparator implements Comparator<ComparableEmployers>{

	@Override
	public int compare(ComparableEmployers o1, ComparableEmployers o2) {
		return Double.compare(o1.getSalary(), o2.getSalary());
	}
	
}
class ExperienceComparator implements Comparator<ComparableEmployers>{
	public int compare(ComparableEmployers o1, ComparableEmployers o2)|{
		return Integer.compare(o1.getExperience(), o2.getExperience());
	}
}