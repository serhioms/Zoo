package junit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import rd.mss.util.ExceptionUtil;
import rd.mss.util.UtilFile;

public class JavaFileUnpack {

	@Test
	public void test() throws IOException, ExceptionUtil {
		String root = "root";
		List<String> content = UtilFile.readFileToList("scan.txt");
		BufferedWriter writer = null;
		
		for(String str: content ){
			try {
				if( str.isEmpty() ){
					continue;
				}
				
				if( str.startsWith("JV: ")){
					if( writer != null ){
						writer.flush();
						writer.close();
					}
					writer = UtilFile.createFileInFolder(root+File.separator+str.replaceFirst("JV: ", ""));
					continue;
				}
				
				str = str.replaceAll("PAK","package");
				str = str.replaceAll("IMP","import");
				str = str.replaceAll("PUB","public");
				str = str.replaceAll("PRV","private");
				str = str.replaceAll("PRT","protected");
				str = str.replaceAll("INT","interface");
				str = str.replaceAll("THWE","Throwable");
				str = str.replaceAll("STC","static");
				str = str.replaceAll("VD","void");
				str = str.replaceAll("THW","throw");
				str = str.replaceAll("BRK","break");
				str = str.replaceAll("EXC","Exception");
				str = str.replaceAll("SSOPF","Systemout.printf");
				str = str.replaceAll("SSOPN","Systemout.println");
				str = str.replaceAll("SSO","System.out");
				str = str.replaceAll("SSEPF","System.err.printf");
				str = str.replaceAll("SSEPN","System.err.println");
				str = str.replaceAll("SSE","System.err");
				str = str.replaceAll("SWH","switch");
				str = str.replaceAll("CS","case");
				str = str.replaceAll("NLL","null");
				str = str.replaceAll("STR","String");

				str = str.replaceAll("!!","{");
				str = str.replaceAll("\\?\\?","}");
				
				writer.write(str);
				writer.write("\n");

			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		writer.flush();
		writer.close();
	}

}
