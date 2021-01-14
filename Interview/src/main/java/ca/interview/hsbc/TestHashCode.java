package ca.interview.hsbc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHashCode {

	User user = new User();

	@Test
	public void test() {
		assertEquals(1040875472, hashCodeSimple());
		assertEquals(1126852444, hashCodeStandard());
		assertEquals(1126643907, hashCodeIntelliJ());
		assertEquals(-603879282, hashCodeEclipse());
	}

	/* 
	 * can produce different results for unequal objects
	 */
	public int hashCodeSimple() {
	    return (int) user.id * user.name.hashCode() * user.email.hashCode();
	}	
	
	/*Let's have a look at a “standard” implementation that uses 
	 * two primes numbers to add even more uniqueness to computed hash codes:
	 */
	public int hashCodeStandard() {
	    int hash = 7;
	    hash = 31 * hash + (int) user.id;
	    hash = 31 * hash + (user.name == null ? 0 : user.name.hashCode());
	    hash = 31 * hash + (user.email == null ? 0 : user.email.hashCode());
	    return hash;
	}	
	
	/*
	 * IntelliJ IDEA generates the following implementation:
	 */
	public int hashCodeIntelliJ() {
	    int result = (int) (user.id ^ (user.id >>> 32));
	    result = 31 * result + user.name.hashCode();
	    result = 31 * result + user.email.hashCode();
	    return result;
	}
	
	/*
	 * Eclipse produces this one:
	 */
	public int hashCodeEclipse() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((user.email == null) ? 0 : user.email.hashCode());
	    result = prime * result + (int) (user.id ^ (user.id >>> 32));
	    result = prime * result + ((user.name == null) ? 0 : user.name.hashCode());
	    return result;
	}
	
	
	//@lombok.EqualsAndHashCode 
	static public class User {
	    public long id = 114;
	    public String name = "Paul";
	    public String email = "paul@gmail.com";
	    
	    
	}
}
