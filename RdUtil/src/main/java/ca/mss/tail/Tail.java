package ca.mss.tail;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tail {

	public static String ZIP_BASE = "C:\\tdmss\\workspace\\test";
	public static String ZIP_FOLDERS = "utilms FastNN DisruptorFlowDev FastFlowDev FastThreadPoolDev MultiTestDev syllogism";
	
	public static String DEST_FOLDER = "C:\\tdmss\\workspace\\test\\zip";
	public static String DEST_FNAME = UnTail.TAIL_MARKER;
	public static String PIC_SRC = "Vocation2019%s.png";
	
	public static String[] skip = new String[]{".settings", "LICENSE", "README.md"};

	public static void main(String[] args) throws IOException {
		if( args.length > 0 ) {
			String folderList = "";
			for(String folder: args) {
				folderList += folderList.isEmpty()? folder: " "+folder;
			}
			ZIP_FOLDERS = folderList;
		}

		DZip.dzip(ZIP_BASE, ZIP_FOLDERS.split(" "), DEST_FOLDER, DEST_FNAME, skip);

		String destFile = String.format(PIC_SRC, new SimpleDateFormat("d-m").format(new Date())); 
				
		UnTail.tail(PIC_SRC, DEST_FNAME+".zip", destFile, DEST_FOLDER);

		UnTail.main(new  String[] {destFile, DEST_FOLDER});
	}

}
