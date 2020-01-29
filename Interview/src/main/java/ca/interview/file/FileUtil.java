package ca.interview.file;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.Random;

public class FileUtil {

	private static final long staticDate = 1202084988000L; // 2008
	static boolean isStaticSate = false;
	
	static boolean deleteFile = true;
	static boolean deleteDir = true;
	
	public static void main(String[] args) {

		process("D:\\temp", "tmp");
	
		process("D:\\workspace\\2013\\interview\\.metadata\\.plugins\\org.eclipse.core.resources\\.history", "history");
		System.out.println("done");
	}

	
	private static void process(String filePath, String newname) {
		File file = new File(filePath);
		File newfile = new File(file.getParentFile()+"\\"+generateFileName(newname, file.getName().length()));
		File newdir = new File(file.getParentFile()+"\\"+newname);
		
		if( file.exists() ){
			if( file.isFile()){
				long lmd2 = file.lastModified();
				rename(file, newfile, lmd2);
				write(newfile);
				if( deleteFile && newfile.delete() ){
					System.out.printf("Delete file %s = %2$tD %2$tT:\n", newfile.getName(), new Date(lmd2));
				}
			} else if( file.isDirectory()){
				long lmd2 = file.lastModified();
				System.out.printf("Dir content %s = %2$tD %2$tT:\n", file.getName(), new Date(file.lastModified()));
				for(File subfile: file.listFiles() ){
					process(subfile.getAbsolutePath(), newname);
				}
				File newdir2 = new File(file.getParent()+"\\"+newname);
				rename(file, newdir2, lmd2);
				if( deleteDir && newdir2.delete() ){
					System.out.printf("Delete dir %s = %2$tD %2$tT:\n", newdir2.getName(), new Date(lmd2));
				}
			}
		}
	}

	private static String generateFileName(String newname, int length) {
		while( newname.length() < length ){
			newname += rnd.nextLong();
		}
		return newname+".rar";
	}

	static Random rnd = new Random();
	
	private static void write(File file) {
		System.out.printf("Write to %s\n", file.getName());
		try {
			long lmd = isStaticSate? staticDate: file.lastModified();

			RandomAccessFile raf = new RandomAccessFile(file.getAbsolutePath(), "rw");
			raf.seek(1);
			
			byte[] bytes = new byte[10240];
			for(long i=0, max=file.length()/bytes.length+2; i<max; i++){
				rnd.nextBytes(bytes);
				raf.write(bytes);
			}
			
			raf.close();
			file.setLastModified(lmd);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}


	private static void rename(File file, File newfile, long lmd2) {
		long lmd = isStaticSate? staticDate: lmd2;
		if( file.renameTo(newfile) )
		{
			System.out.printf("%s:%s = %3$tD %3$tT\n", newfile.isDirectory()?"Dir":(newfile.isFile()?"File":"???"), file.getName(), new Date(lmd));
			System.out.printf("Rename %s to %s\n", file.getName(), newfile.getName());
			file.renameTo(newfile);
			newfile.setLastModified(lmd);
		} 
		else
			System.out.printf("Can't rename to %s\n", file.getName());
	}
}
