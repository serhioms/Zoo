package rd.mss.util.tail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DZip {

	public static void dzip(String fbase, String[] fnames, String destfolder, String destname, List<String> include) throws IOException {
		zip(fbase, fnames, destfolder + File.separator + destname, include);
		zip(destfolder + File.separator + destname, destfolder + File.separator + destname+".zip", null);
	}

	public static void zip(String base, String[] src, String dest, List<String> include) throws IOException {
		FileOutputStream destOut = new FileOutputStream(dest);
		ZipOutputStream destZip = new ZipOutputStream(destOut);
		
		for(String file: src) {
			File srcFile = new File(base +File.separator+ file);
			zip(srcFile, srcFile.getName(), destZip, include);
		}
		
		destZip.close();
		destOut.close();
	}

	public static void zip(String src, String dest, List<String> include) throws IOException {
		FileOutputStream destOut = new FileOutputStream(dest);
		ZipOutputStream destZip = new ZipOutputStream(destOut);
		File srcFile = new File(src);

		zip(srcFile, srcFile.getName(), destZip, include);
		
		destZip.close();
		destOut.close();
	}

	static List<String> folders = new ArrayList<>();
	
	public static void zip(File file, String fileName, ZipOutputStream dest, List<String> include) throws IOException {
		if (file.isHidden()) {
			return;
		}
		if (file.isDirectory()) {
			File[] children = file.listFiles();
			for (File childFile : children) {
				zip(childFile, fileName + "/" + childFile.getName(), dest, include);
			}
			return;
		}
		if( include == null || include.contains(file.getAbsolutePath())) {
			System.out.println(file);
			
			if( !folders.contains(file.getParent()) ) {
				folders.add(file.getParent());
				dest.putNextEntry(new ZipEntry(file.getParent() + "\\"));
				dest.closeEntry();
			}

			FileInputStream fis = new FileInputStream(file);
			ZipEntry zipEntry = new ZipEntry(fileName);
			dest.putNextEntry(zipEntry);
			
			byte[] bytes = new byte[10240];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				dest.write(bytes, 0, length);
			}
			fis.close();
		}
	}
}