package ca.mss.tail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DZip {

	public static void dzip(String fbase, String[] fnames, String destfolder, String destname, String[] skip) throws IOException {
		List<String> asList = Arrays.asList(skip);
		zip(fbase, fnames, destfolder + File.separator + destname, asList);
		zip(destfolder + File.separator + destname, destfolder + File.separator + destname+".zip", asList);
	}

	public static void zip(String base, String[] src, String dest, List<String> skip) throws IOException {
		FileOutputStream destOut = new FileOutputStream(dest);
		ZipOutputStream destZip = new ZipOutputStream(destOut);
		
		for(String file: src) {
			File srcFile = new File(base +File.separator+ file);
			if( !skip.contains(srcFile.getName())) {
				zip(srcFile, srcFile.getName(), destZip, skip);
			}
		}
		
		destZip.close();
		destOut.close();
	}

	public static void zip(String src, String dest, List<String> skip) throws IOException {
		FileOutputStream destOut = new FileOutputStream(dest);
		ZipOutputStream destZip = new ZipOutputStream(destOut);
		File srcFile = new File(src);

		if( !skip.contains(srcFile.getName())) {
			zip(srcFile, srcFile.getName(), destZip, skip);
		}
		
		destZip.close();
		destOut.close();
	}

	public static void zip(File file, String fileName, ZipOutputStream dest, List<String> skip) throws IOException {
		if (file.isHidden()) {
			return;
		}
		if( skip.contains(fileName)) {
			return;
		}
		if (file.isDirectory()) {
			if (fileName.endsWith("/")) {
				dest.putNextEntry(new ZipEntry(fileName));
				dest.closeEntry();
			} else {
				dest.putNextEntry(new ZipEntry(fileName + "/"));
				dest.closeEntry();
			}
			File[] children = file.listFiles();
			for (File childFile : children) {
				if( !skip.contains(childFile.getName())) {
					zip(childFile, fileName + "/" + childFile.getName(), dest, skip);
				}
			}
			return;
		}
		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(fileName);
		dest.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			dest.write(bytes, 0, length);
		}
		fis.close();
	}
}