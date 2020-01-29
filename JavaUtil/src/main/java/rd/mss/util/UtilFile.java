package rd.mss.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class UtilFile {

	public static List<String> readFileToList(String filePath) throws ExceptionUtil {
		try {
			Path path = Paths.get(filePath);
			if( !path.toFile().exists() ){
				path = Paths.get(UtilFile.class.getClassLoader().getResource(filePath).getPath().replaceFirst("/", ""));
			}
			return Files.readAllLines(path);
		} catch(Exception e){
			throw new ExceptionUtil("Can't read from: "+filePath, e);	
		}
	}

	public static BufferedWriter createFileInFolder(String filePath) throws ExceptionUtil {
		String[] fileArray = filePath.split("\\\\");
		String folderPath = "";
		
		for(int i=0,max=fileArray.length-1; i<max; i++){
			folderPath += folderPath.isEmpty()? fileArray[i]: File.separatorChar+fileArray[i];
			File folder = new File(folderPath);
			if( !folder.exists()){
				if( !folder.mkdirs() ){
					throw new ExceptionUtil("Can't creatre folder: "+folderPath);
				}
			}
		}
		return UtilFile.writeFileTo(filePath);
	}

	private static BufferedWriter writeFileTo(String filePath) throws ExceptionUtil{
		try {
			return new BufferedWriter(new FileWriter(filePath));
		} catch (IOException e) {
			throw new ExceptionUtil("Can't write to file: "+filePath);
		}
	}
	
}
