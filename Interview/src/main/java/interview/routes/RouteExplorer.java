package interview.routes;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RouteExplorer {

	private Map<String, Set<String>> stations = new HashMap<String, Set<String>>();
	private List<String> routes = new ArrayList<String>();
	private List<String> availableRoutes = new ArrayList<String>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if( args.length != 1 ){
			System.out.println("Try");
			System.out.println("java -cp bin  other.routes.RouteExplorer data\\stations.csv");
			System.exit(1);
		}
		
		RouteExplorer re = new RouteExplorer();
		
		re.readStations(args[0]);
		
		//re.availableRoutes("Ely".toLowerCase(), "London".toLowerCase());

		//re.availableRoutes("Moscow".toLowerCase(), "London".toLowerCase());
		
        Console console = System.console();
        String start = console.readLine("Enter start station>");   
        String end = console.readLine("Enter end station>");   
        
		re.availableRoutes(start.toLowerCase(), end.toLowerCase());
		
		System.exit(0);

	}
	
	private List<String> readTextFile(String path) {
		List<String> result = new ArrayList<String>();

		FileInputStream fstream = null;
		DataInputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {

			fstream = new FileInputStream(path);
			in = new DataInputStream(fstream);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			
			
			for(String strLine = br.readLine(); strLine != null; strLine = br.readLine()) {
				result.add(strLine);
			}
			in.close();
			
		} catch( Throwable e) {
			new RuntimeException("Can not read from file ["+path+"]");
		} finally {
				try {
					if( br != null )
						br.close();
					if( isr != null )
						isr.close();
					if( in != null )
						in.close();
					if( fstream != null )
						fstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return result;
	}
	
	public void readStations(String path){
		stations.clear();
/*		
		addStations("eLy", "Cambridge");
		addStations("cAmbridge", "haRlow");
		addStations("haRlow", "london");
		addStations("cambridgE", "stansted");
		addStations("staNsted", "londoN");

		addStations("haRlow", "elY"); // add dad loop
		addStations("moscow", "peterburg"); // add other railways

		addStations("haRlow", "New York"); // add intermediate station
		addStations("new york", "london"); // add intermediate station
		addStations("staNsted", "new york"); // add intermediate station
*/
		List<String> file = readTextFile(path);
		
		Iterator<String> iter=file.iterator();
		
		for(int rownum=1; iter.hasNext(); rownum++){
			String row = iter.next();
			
			row = row.trim();
			
			if( row.length() == 0)
				continue; // skip empty lines
			
			row = row.toLowerCase();
			
			String[] table = row.split(",");
			
			if( table.length != 2 ){
				throw new RuntimeException("Wrong stations file format ["+path+"]. Must be exactly [2] stations in each row splitted by comma [,] but there are ["+table.length+"] instead in line ["+rownum+"]");
			}
			
			addStations(table[0], table[1]);
		}
	}
	
	private void addStations(String from, String to){
		
		Set<String> destinations = null;
		
		from = from.toLowerCase();
		
		if( stations.containsKey(from) ){
			destinations = stations.get(from);
		} else {
			destinations = new HashSet<String>();
			stations.put(from, destinations);
		}
		
		to = to.toLowerCase();
		
		destinations.add(to);
	}
	
	public void availableRoutes(final String start, final String end){
		System.out.println("Available routes from ["+start+"] to ["+end+"] are:");

		routes.clear();
		availableRoutes.clear();
		
		routes.add(start);
		searchAvailableRoutes(start, start, end);
		
		if( availableRoutes.size() == 0 ){
			System.out.println("N/A");
		}
		
		System.out.println();
	}

	private void searchAvailableRoutes(final String start, final String from, final String end){
		
		Set<String> ends = stations.get(from);
		if( ends != null ){
			for( Iterator<String> iter = ends.iterator(); iter.hasNext(); ){
				final String to = iter.next();
				
				if( start.equals(to) )
					continue; // skip dad loops
				
				routes.add(to);
				
				if( end.equals(to) )
					printAvailableRoute();
				else 
					searchAvailableRoutes(start, to, end);
				
				
				routes.remove(routes.size()-1); // next end   
			}
		}
	}

	private void printAvailableRoute(){
		String route = "";
		
		for( Iterator<String> station = routes.iterator(); station.hasNext(); ){
			route += station.next();
			if( station.hasNext() )
				route += "->";
		}
		
		availableRoutes.add(route);
		
		System.out.println(route);
	}
	
}
