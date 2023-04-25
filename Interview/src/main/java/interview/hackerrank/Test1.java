package interview.hackerrank;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		assertEquals(	"0", 
				summ(	"0", 
						"0"));
	}
	
	@Test
	public void test2() {
		assertEquals( "1 0 0 9 8", 
				summ(	"9 9 9 9", 
							"9 9"));
	}
	
	@Test
	public void test3() {
		assertEquals( "1 0 0 9 9 8", 
				summ(	"9 9 9 9 9", 
							"9 9 9"));
	}
	
	@Test
	public void test4() {
		assertEquals(     "7 5 4 3 0 9 8", 
				summ(	"9 9 9 0 1 1 2 3", 
						"9 9 0 0 1 3 3 4"));
    }

	@Test
	public void test5() {
		assertEquals(	"8 0 7", 
				summ(	"2 4 3", 
						"5 6 4"));
	}
	

	public String summ(String a, String b) {
		String c = "";
		
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        LinkedList<Integer> l3 = new LinkedList<>();
        
        Arrays.stream(a.split(" ")).forEach(i->l1.add(Integer.parseInt(i)));
        Arrays.stream(b.split(" ")).forEach(i->l2.add(Integer.parseInt(i)));
        
        while( l1.size() < l2.size() ){
            l1.add(0);
        }
        while( l2.size() < l1.size() ){
            l2.add(0);
        }
        
        Integer reminder=0;
        
        while(!l1.isEmpty() ){
            Integer e1 = l1.pop();
            Integer e2 = l2.pop();
            
            if( l3.isEmpty() && e1 == 0 && e2 == 0 ){
            	if( l1.isEmpty()) {
                    c = "0";
            	}
                continue;
            }
            Integer e3 = e1+e2+reminder;
            Integer od = e3 / 10;
            if( od > 0  ){
                e3 = e3 % 10;
                reminder = od;
            } else {
                reminder = 0;
            }
            
            c = (e3) + (c.isEmpty()?"":" ") + c;
        }
        if( reminder > 0 ) {
            c = (reminder) + (c.isEmpty()?"":" ") + c;
        }
        
        return c;
    }

	public String[] readStdin() throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 2 4 3, 5 6 4
        br.close();
        return input.split(",");
	}
}