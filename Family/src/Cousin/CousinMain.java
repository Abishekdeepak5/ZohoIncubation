package Cousin;
import java.util.Scanner;

class Person{
	String name;
	String gender;
	Person father;
	Person mother;
	static Person[] persons;
	
	static String[][] familyPerson= {
	{"sanjay","m",null,null},{"sharmila","f",null,null},
	{"bala","m","sanjay","sharmila"},{"nisha","f",null,null},
	{"vicky","m",null,null},{"manisha","f","sanjay","sharmila"},
	{"santhiya","f","bala","nisha"},{"priya","f","bala","nisha"},{"yogesh","m","bala","nisha"},
	{"magesh","m","vicky","manisha"},{"vanaja","f","vicky","manisha"}};

	 Person(String name, String gender) {
	        this.name = name;
	        this.gender = gender;
	 }
	  
	static void setPerson() {
		int n=familyPerson.length;
		persons=new Person[n];
		//set name and gender
		for(int i=0;i<familyPerson.length;i++) {
			String name = familyPerson[i][0];
            String gender = familyPerson[i][1];
            persons[i] = new Person(name, gender);
		}
		//set father and mother
		for (int i = 0; i < n; i++) {
            String fatherName = familyPerson[i][2];
            String motherName = familyPerson[i][3];
            persons[i].father = getPersonByName(fatherName);
            persons[i].mother = getPersonByName(motherName);
        }
	}

	static Person getPersonByName(String name) {
        for (Person person : persons) {
            if (person != null && person.name.equals(name)) {
                return person;
            }
        }
        return null;
    }
	
	static Person[] findUncleAunty(String personName) {
		Person[] uncleAunty;
		uncleAunty=new Person[familyPerson.length];
		Person person=getPersonByName(personName);
		int i=0;
		if(person.father!=null) {
			for(Person p:persons) {
				if(person.father.father!=null && person.father.father==p.father && person.father.mother!=null && person.father.mother==p.mother && !p.name.equals(person.father.name)) {
					uncleAunty[i++]=p;
				}
			}
		}
		if(person.mother!=null) {
			for(Person p:persons) {
				if (p != null && person.mother.father!=null && p.father == person.mother.father && person.mother.mother!=null && p.mother == person.mother.mother && !p.name.equals(person.mother.name)) {
            		uncleAunty[i++]=p;
				}
			}
		}
		Person[] cousins=findCousin(uncleAunty,person,i);
		return cousins;
	}
	
	static Person[] findCousin(Person[] uncleAunty,Person person,int count) {
		Person[] cousins=new Person[persons.length];
		int cnt=0;
		for(int i=0;i<count;i++) {
			Person auntOrUncle = uncleAunty[i];
			for(Person p:persons) {
				if(person.gender.equals("m")) {
					if(p.gender.equals("f") && (p.father==auntOrUncle || p.mother==auntOrUncle)){
						cousins[cnt++]=p;
					}
				}
				else {
					if(p.gender.equals("m") && (p.father==auntOrUncle || p.mother==auntOrUncle)){
						cousins[cnt++]=p;
					}
				}
				
			}	
		}
		return cousins;
		
	}
	static void  printPerson() {
		for(Person p:persons) {
			if(p!=null) {
				System.out.print(p.name);
			}
			System.out.println();
		}
	}
}
public class CousinMain {
	
	public static void main(String[] args) {
		Person.setPerson();
		Person[] uncleAunty=Person.findUncleAunty("magesh");
		for(Person p:uncleAunty) {
			if(p!=null)
				System.out.println(p.name);
		}
	}

}
