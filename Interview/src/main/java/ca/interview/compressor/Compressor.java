package ca.interview.compressor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Compressor {

	private String inputFile;

	// Inputs
	FileInputStream fis = null; 
	DataInputStream dis = null; 
	InputStreamReader isr = null; 
	BufferedReader br = null; 

	// Outputs
	FileOutputStream fos = null; 
	DataOutputStream dos = null; 
	OutputStreamWriter osw = null; 
	BufferedWriter bw = null; 

	public Compressor(String inputFile) {
		super();
		this.inputFile = inputFile;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if( args.length != 2 ){
			System.out.println("Use like this, please:");
			System.out.println("java -cp bin ca.interview.compressor.Compressor <command> file");
			System.out.println("<command> - [compress|decompress]");
			System.exit(1);
		}
		
		final String command = args[0].toLowerCase(); 
		final String inputFile = args[1];

		//final String command = "compress"; 
		//final String inputFile = "data/textfile.txt";
		
		//final String command = "decompress"; 
		//final String inputFile = "data/textfile.txt.cmp";
		
		String outputFile = null;
		
		Compressor compresor = new Compressor(inputFile);
		
		if( "compress".equals(command) ){
			if( (outputFile = compresor.compressFile()) != null )
				System.out.println("Successfully compressed to ["+outputFile+"]");
		
		} else if( "decompress".equals(command) ){
			if( (outputFile = compresor.decompressFile()) != null )
				System.out.println("Successfully decompressed to ["+outputFile+"]");
		} else {
			System.out.println("Error. Unknown command ["+command+"]. Must be [compress] or [decompress]");
		}

		if( outputFile != null )
			System.exit(0);
		else
			System.exit(1);
	}

	private void openInputFile() throws Throwable{
		fis = new FileInputStream(inputFile); 
		dis = new DataInputStream(fis); 
		isr = new InputStreamReader(dis); 
		br = new BufferedReader(isr); 
	}
	
	private void closeInputFile() {
		try {
			if( br != null )
				br.close();
			if( isr != null )
				isr.close();
			if( dis != null )
				dis.close();
			if( fis != null )
				fis.close();
		}catch(Throwable t){
			// Quietly
		}
	}
	
	private void openOutputFile(String fileName) throws Throwable{
		fos = new FileOutputStream(fileName);
		dos = new DataOutputStream(fos); 
		osw = new OutputStreamWriter(dos); 
		bw = new BufferedWriter(osw); 
	}
	
	private void closeOutputFile() {
		try {
			if( fos != null )
				fos.flush();
			if( dos != null )
				dos.flush();
			if( osw != null )
				osw.flush();
			if( bw != null )
				bw.flush();
		} catch(Throwable t){
			// Quietly
		} finally {
			try {
				if( bw != null )
					bw.close();
				if( osw != null )
					osw.close();
				if( dos != null )
					dos.close();
				if( fos != null )
					fos.close();
			} catch(Throwable t){
				// Quietly
			}
		}
	}
	
	private void writeOutputFile(char[] buff, int counter) throws Throwable {
		bw.write(Integer.toString(counter));
		bw.write(buff);
	}
	
	private void writeOutputFile(char[] buff, String countertsr) throws Throwable {
		int counter = Integer.parseInt(countertsr);
		while( counter-- > 0 )
			bw.write(buff);
	}
	
	private String compressFile(){
		String out = getOutputFile(inputFile + ".cmp");

		try {
			
			openInputFile();
			openOutputFile(out);
			
			char[] readchar = new char[1];
			
			char[] lastchar = new char[1];
			int counter = -1;
			
			while( br.read(readchar) == 1){
				if( readchar[0] >= '0' && readchar[0] <= '9'){
					throw new RuntimeException("Error. Input file ["+inputFile+"] must contain non digit characters only");
				}
				if( counter == -1){
					counter = 1;
					lastchar[0] = readchar[0];
				} else if( readchar[0] == lastchar[0])
					counter++;
				else {
					writeOutputFile(lastchar, counter);
					counter = 1;
					lastchar[0] = readchar[0];
				}
			}
			// last char
			if( counter > 0 ){
				writeOutputFile(lastchar, counter);
			}
		}catch( Throwable t){
			out = null;
			System.err.println("Can not compress file ["+inputFile+"] due to ["+t.getMessage()+"]");
			t.printStackTrace();
		} finally {
			closeInputFile();
			closeOutputFile();
		}
		return out;
	}

	private String getOutputFile(String outputFile){
		File file = new File(outputFile);
		
		for(int i=1; file.exists(); i++ ){
			if( file.getParentFile().exists() )
				file = new File(file.getParentFile().getAbsolutePath()+"/Copy "+i+" of "+file.getName());
			else
				file = new File("Copy "+i+" of "+file.getName());
		}
		
		return file.getAbsolutePath();
	}
	
	private String decompressFile(){
		String out = getOutputFile(inputFile.replace(".cmp", "")); 
		try {

			openInputFile();
			openOutputFile(out);
			
			char[] readchar = new char[1];
			
			String counter = "";
			
			while( br.read(readchar) == 1){
				if( readchar[0] >= '0' && readchar[0] <= '9'){
					counter += readchar[0];
					continue;
				} else {
					writeOutputFile(readchar, counter);
					counter = "";
				}
			}
			
		}catch( Throwable t){
			out = null;
			System.err.println("Can not decompress file ["+inputFile+"] due to ["+t.getMessage()+"]");
			t.printStackTrace();
		} finally {
			closeInputFile();
			closeOutputFile();
		}
		return out;
	}
	
	
}
