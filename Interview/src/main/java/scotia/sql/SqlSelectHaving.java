package scotia.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SqlSelectHaving {

	public static void main(String[] args) {
		
		List<User> users = new ArrayList<>(100);
		users.add(new User("Bob","2020",101));
		users.add(new User("Bob","2020",201));
		users.add(new User("Bob","2020",301));
		users.add(new User("Bob","2020",401));
		users.add(new User("Bob","2019",501));
		users.add(new User("Bob","2019",601));
		users.add(new User("Mike","2020",101));
		users.add(new User("Mike","2020",201));
		users.add(new User("Mike","2020",301));
		users.add(new User("Mike","2019",401));
		users.add(new User("Mike","2019",501));
		users.add(new User("Helen","2019",601));
		users.add(new User("Helen","2020",101));
		users.add(new User("Helen","2020",201));
		users.add(new User("Helen","2020",301));
		users.add(new User("Helen","2020",701));
		users.add(new User("Helen","2019",501));
		users.add(new User("Helen","2019",601));
		
		Map<String, Integer> result = users.parallelStream()
			.filter(u->u.getYear().contentEquals("2020"))
			.collect(Collectors.toConcurrentMap(User::getName, User::getSum, (Integer t, Integer u)->t+u))
			.entrySet().parallelStream()
			.filter(pair->pair.getValue()>1000)
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		System.out.println(result);
		
	}

	static class User {
		public final String name;
		public final String year;
		public final Integer sum;
		public User(String name, String year, Integer sum) {
			this.name = name;
			this.year = year;
			this.sum = sum;
		}
		public String getName() {
			return name;
		}
		public String getYear() {
			return year;
		}
		public Integer getSum() {
			return sum;
		}
	}
}
