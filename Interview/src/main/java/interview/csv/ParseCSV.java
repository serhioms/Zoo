package interview.csv;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ParseCSV {

	private FileInputStream fis = null;
	private DataInputStream dis = null;
	private InputStreamReader isr = null;
	private BufferedReader br = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final String filePath = "data\\test3.csv";
		final String columnNumber = "2";
		final String fragment = "'\"b\"'";
		
		ParseCSV parser = new ParseCSV();
		
		try {
			parser.openFile(filePath);

			int found = parser.parse(Integer.parseInt(columnNumber), fragment);
			
			System.out.println(found);
		}catch( Throwable t){
			System.err.println("Error while parsing ["+filePath+"] with [column="+columnNumber+"][fragment="+fragment+"] due to ["+t.getMessage()+"]");
			t.printStackTrace();
		} finally {
			parser.closeFile();
		}
		
	}

	private void openFile(String file) throws Throwable {
		fis = new FileInputStream(file);
		dis = new DataInputStream(fis);
		isr = new InputStreamReader(dis);
		br = new BufferedReader(isr);
	}

	private void closeFile() {
		try {
			if( br != null )
				br.close();
			if( isr != null )
				isr.close();
			if( dis != null )
				dis.close();
			if( fis != null )
				fis.close();
		} catch(Throwable t){
			// Quite
		}
	}

	private enum CSV {
		QuotationDelimited("'\"", "\"'"),
		ApostrofDelimited("'","'"),
		CommaDelimited();

		final public String starts;
		final public String ends;
		
		private CSV(String starts, String ends){
			this.starts = starts;
			this.ends = ends;
		}
		
		private CSV(){
			this.starts = null;
			this.ends = null;
		}
		
		static public CSV getStyle(String fragment){
			CSV[] csv = CSV.values();
			for(int i=0; i<csv.length; i++){

				if( csv[i].starts != null && fragment.startsWith(csv[i].starts))
					if( csv[i].ends != null && fragment.endsWith(csv[i].ends))
							return csv[i];
				
				return csv[i];
			}
			return CSV.CommaDelimited;
		}
	}
	
	private int parse(int columnNumber, String fragment) throws Throwable {
		int found = 0;


		CSV style = CSV.getStyle(fragment);
		
		for(String row=br.readLine(); row != null; row=br.readLine()){

			String[] columns = null;
			
			switch( style ){
			case ApostrofDelimited:
				System.out.println("Apostrof");
				break;
			case QuotationDelimited:
				columns = row.split(style.starts+","+style.ends);
				break;
			case CommaDelimited:
				System.out.println("Comma");
				break;
			default:
				throw new RuntimeException("Unknown fragment format ["+fragment+"]");
			}
		}
		
		return found;
	}

}
