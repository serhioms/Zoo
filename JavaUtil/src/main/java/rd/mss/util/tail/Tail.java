package rd.mss.util.tail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Tail {
	public static String ZIP_BASE = "C:\\tdmss\\workspace\\test";
	public static String ZIP_FOLDERS = "rd\\Zoo mss\\syllogism"; // "mss\\syllogism rd\\Zoo";
	
	public static String DEST_FOLDER = "C:\\tdmss\\workspace\\test\\zip";
	public static String DEST_FNAME = UnTail.TAIL_MARKER;
	public static String PIC_SRC = "Vocation2020%s.png";
	
	public static void main(String[] args) throws IOException {
		if( args.length > 0 ) {
			String folderList = "";
			for(String folder: args) {
				folderList += folderList.isEmpty()? folder: " "+folder;
			}
			ZIP_FOLDERS = folderList;
		}

		DZip.dzip(ZIP_BASE, ZIP_FOLDERS.split(" "), DEST_FOLDER, DEST_FNAME, includeFilter("filter.txt", ZIP_BASE, ZIP_FOLDERS.split(" ")));

		String destFile = String.format(PIC_SRC, new SimpleDateFormat("d-m").format(new Date())); 
				
		UnTail.tail(PIC_SRC, DEST_FNAME+".zip", destFile, DEST_FOLDER);

		UnTail.main(new  String[] {destFile, DEST_FOLDER});
	}

	private static List<String> includeFilter(String file, String root, String[] projs) throws FileNotFoundException {
		Scanner s = new Scanner(new File(file));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()) {
			String str = s.next();
			str = str.replaceFirst("modified:", "");
			str = str.replaceFirst("new file:", "");
			str = str.replaceFirst("renamed:", "");
			str = str.replaceFirst(" ", "");
			if( str.isEmpty() ) {
				continue;
			}
			str = str.replaceAll("\\/", "\\\\");
			for(String proj: projs ) {
				String str2 = root+"\\"+proj+"\\"+str;
				
				System.out.printf("\"%s\"\n", str2);
				list.add(str2);
			}
		}
		s.close();
		return list;
	}

}
