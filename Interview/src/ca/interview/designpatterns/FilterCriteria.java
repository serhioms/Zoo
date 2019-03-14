package ca.interview.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class FilterCriteria {

	// Step 1
	// Create a class on which criteria is to be applied.

	static public class Person {

		private String name;
		private String gender;
		private String maritalStatus;

		public Person(String name, String gender, String maritalStatus) {
			this.name = name;
			this.gender = gender;
			this.maritalStatus = maritalStatus;
		}

		public String getName() {
			return name;
		}

		public String getGender() {
			return gender;
		}

		public String getMaritalStatus() {
			return maritalStatus;
		}
	}

	// Step 2
	// Create an interface for Criteria.

	static public interface Criteria {
		public List<Person> meetCriteria(List<Person> persons);
	}

	// Step 3
	// Create concrete classes implementing the Criteria interface.

	static public class CriteriaMale implements Criteria {

		@Override
		public List<Person> meetCriteria(List<Person> persons) {
			List<Person> malePersons = new ArrayList<Person>();
			for (Person person : persons) {
				if (person.getGender().equalsIgnoreCase("MALE")) {
					malePersons.add(person);
				}
			}
			return malePersons;
		}
	}

	static public class CriteriaFemale implements Criteria {

		@Override
		public List<Person> meetCriteria(List<Person> persons) {
			List<Person> femalePersons = new ArrayList<Person>();
			for (Person person : persons) {
				if (person.getGender().equalsIgnoreCase("FEMALE")) {
					femalePersons.add(person);
				}
			}
			return femalePersons;
		}
	}

	static public class CriteriaSingle implements Criteria {

		@Override
		public List<Person> meetCriteria(List<Person> persons) {
			List<Person> singlePersons = new ArrayList<Person>();
			for (Person person : persons) {
				if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
					singlePersons.add(person);
				}
			}
			return singlePersons;
		}
	}

	static public class AndCriteria implements Criteria {

		private Criteria criteria;
		private Criteria otherCriteria;

		public AndCriteria(Criteria criteria, Criteria otherCriteria) {
			this.criteria = criteria;
			this.otherCriteria = otherCriteria;
		}

		@Override
		public List<Person> meetCriteria(List<Person> persons) {
			List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
			return otherCriteria.meetCriteria(firstCriteriaPersons);
		}
	}

	static public class OrCriteria implements Criteria {

		private Criteria criteria;
		private Criteria otherCriteria;

		public OrCriteria(Criteria criteria, Criteria otherCriteria) {
			this.criteria = criteria;
			this.otherCriteria = otherCriteria;
		}

		@Override
		public List<Person> meetCriteria(List<Person> persons) {
			List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
			List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

			for (Person person : otherCriteriaItems) {
				if (!firstCriteriaItems.contains(person)) {
					firstCriteriaItems.add(person);
				}
			}
			return firstCriteriaItems;
		}
	}

	// Step4
	// Use different Criteria and their combination to filter out persons.

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Robert", "Male", "Single"));
		persons.add(new Person("John", "Male", "Married"));
		persons.add(new Person("Laura", "Female", "Married"));
		persons.add(new Person("Diana", "Female", "Single"));
		persons.add(new Person("Mike", "Male", "Single"));
		persons.add(new Person("Bobby", "Male", "Single"));

		Criteria male = new CriteriaMale();
		Criteria female = new CriteriaFemale();
		Criteria single = new CriteriaSingle();
		Criteria singleMale = new AndCriteria(single, male);
		Criteria singleOrFemale = new OrCriteria(single, female);

		System.out.println("Males: ");
		printPersons(male.meetCriteria(persons));

		System.out.println("\nFemales: ");
		printPersons(female.meetCriteria(persons));

		System.out.println("\nSingle Males: ");
		printPersons(singleMale.meetCriteria(persons));

		System.out.println("\nSingle Or Females: ");
		printPersons(singleOrFemale.meetCriteria(persons));
	}

	public static void printPersons(List<Person> persons) {
		for (Person person : persons) {
			System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender()
					+ ", Marital Status : " + person.getMaritalStatus() + " ]");
		}
	}
}
