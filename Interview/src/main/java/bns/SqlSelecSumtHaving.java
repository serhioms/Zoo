package bns;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SqlSelecSumtHaving {

	public Map<String, Integer> solution(List<User> users){
		return users.parallelStream()
				.filter(u->u.getYear().contentEquals("2020"))
				.collect(Collectors.toConcurrentMap(User::getName, User::getSum, (Integer t, Integer u)->t+u))
				.entrySet().parallelStream()
				.filter(pair->pair.getValue()>1000)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	@Test
	public void testSqlSelecSumtHaving() {
		
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

		assertEquals("{Bob=1004, Helen=1304}", solution(users).toString());
		
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
