import java.util.ArrayList;

public class Analyzer {
	ArrayList<ComparableEmployers> table;
	public Analyzer(ArrayList<ComparableEmployers> table) {
		this.table = table;
	}
	public void sortAge(boolean sorting) {
		if(sorting==true) {
		table.sort(new AgeComparator());
		}
		else if(sorting ==false) {
			table.sort(new AgeComparator().reversed());
		}
	}
	public void sortSalary(boolean sorting) {
		if(sorting == true) {
		table.sort(new SalaryComparator());
		}
		else if(sorting == false) {
			table.sort(new SalaryComparator().reversed());
		}
	}
	public void sortExperience(boolean sorting){
		if(sorting == true) {
		table.sort(new ExperienceComparator());
		}
		else if(sorting== false) {
			table.sort(new ExperienceComparator().reversed());
		}
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
		for(ComparableEmployers employer:table) {
			if(employer.getSex() != sex) {
				table.remove(table.indexOf(employer));
			}
			
		}
			
	}

    public void filterBySalary(double salary, int option) {
        switch(option) {
        case 1:
        	for(ComparableEmployers employer:table) {
        		if(employer.getSalary() != salary) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 2:
        	for(ComparableEmployers employer:table) {
        		if(employer.getSalary() >= salary) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 3: 
        	for(ComparableEmployers employer:table) {
        		if(employer.getSalary() <= salary) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 4:
        	for(ComparableEmployers employer:table) {
        		if(employer.getSalary() > salary) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 5:
        	for(ComparableEmployers employer:table) {
        		if(employer.getSalary() < salary) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        }
    }
    public void filterByExperience(double experience, int option) {
        switch(option) {
        case 1:
        	for(ComparableEmployers employer:table) {
        		if(employer.getExperience() != experience) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 2:
        	for(ComparableEmployers employer:table) {
        		if(employer.getExperience() >= experience) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 3: 
        	for(ComparableEmployers employer:table) {
        		if(employer.getExperience() <= experience) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 4:
        	for(ComparableEmployers employer:table) {
        		if(employer.getExperience() > experience) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 5:
        	for(ComparableEmployers employer:table) {
        		if(employer.getExperience() < experience) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        }
    }
    public void filterByName(String name) {
		for(ComparableEmployers employer:table) {
			if(employer.getName() != name) {
				table.remove(table.indexOf(employer));
			}
			
		}
			
	}
    public void filterBySurname(String surname) {
		for(ComparableEmployers employer:table) {
			if(employer.getSurname() != surname) {
				table.remove(table.indexOf(employer));
			}
			
		}
			
	}
    public void filterByDate(String date) {
		for(ComparableEmployers employer:table) {
			if(employer.getDate() != date) {
				table.remove(table.indexOf(employer));
			}
			
		}
			
	}
    public void filterByAge(int age, int option) {
        switch(option) {
        case 1:
        	for(ComparableEmployers employer:table) {
        		if(employer.getAge() != age) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 2:
        	for(ComparableEmployers employer:table) {
        		if(employer.getAge() >= age) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 3: 
        	for(ComparableEmployers employer:table) {
        		if(employer.getAge() <= age) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 4:
        	for(ComparableEmployers employer:table) {
        		if(employer.getAge() > age) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        case 5:
        	for(ComparableEmployers employer:table) {
        		if(employer.getAge() < age) {
        			table.remove(table.indexOf(employer));
        		}
        		
        	}break;
        }
    }
	

}
