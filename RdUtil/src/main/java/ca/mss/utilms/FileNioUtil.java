package ca.mss.utilms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FileNioUtil {

	public FileNioUtil() {
	}

	static public class ReadByLineIterator implements Iterator<String> {
		private LinkedBlockingQueue<String> queue;

		public ReadByLineIterator(Path path) {
			this(path, new LinkedBlockingQueue<String>());
		}
	
		public ReadByLineIterator(Path path, Predicate<String> consumer) {
			this(path, consumer, Runnable::run);
		}
	
		public ReadByLineIterator(Path path, Predicate<String> consumer, Executor executor){
			executor.execute(()->FileNioUtil.readByLineConsumer(path, consumer));
		}
	
		public ReadByLineIterator(Path path, LinkedBlockingQueue<String> queue) {
			this(path, queue::add, Runnable::run);
			this.queue = queue;
		}
	
		public ReadByLineIterator(Path path, LinkedBlockingQueue<String> queue, Executor executor) {
			this(path, queue::add, executor);
			this.queue = queue;
		}
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
	
		@Override
		public String next() {
			return queue.poll();
		}
	}
	
	static public class WalkIterator implements Iterator<Path> {
		private LinkedBlockingQueue<Path> queue;

		public WalkIterator(Path path) {
			this(path, new LinkedBlockingQueue<Path>());
		}
	
		public WalkIterator(Path path, Consumer<Path> consumer, Executor executor){
			executor.execute(()->FileNioUtil.walkConsumer(path, consumer));
		}
	
		public WalkIterator(Path path, LinkedBlockingQueue<Path> queue) {
			this(path, queue::add, Runnable::run);
			this.queue = queue;
		}
	
		public WalkIterator(Path path, LinkedBlockingQueue<Path> queue, Executor executor) {
			this(path, queue::add, executor);
			this.queue = queue;
		}
		
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
	
		@Override
		public Path next() {
			return queue.poll();
		}
	}
	
	public static Path getClassLoaderPath(String file){
		return Paths.get(FileNioUtil.class.getClassLoader().getResource(file).getPath().replaceFirst("/", ""));
	}
	
	public static Path getFilePath(String file){
		return Paths.get(file);
	}
	
	public static Path getDirPath(String dir){
		return Paths.get(dir);
	}
	
	public static void writeByLineSupplier(Path path, Supplier<String> supplier) throws UtilException {
		BufferedWriter writer = null;
		try {
			writer = write2File(path);
			for(String line=supplier.get(); line != null; line=supplier.get()){
				writer.write(line);
				writer.write("\n");
			}
		} catch (IOException e) {
			throw new RuntimeException("Can't write into: "+path);
		} finally {
			if( writer != null ){
				try {
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException("Can't close: "+path);
				}
			}
		}
	}
	
	public static BufferedWriter write2File(Path path){
		try {
			if( path.getParent() != null && Files.notExists(path.getParent())){
				Files.createDirectory(path.getParent());
			}
			return Files.newBufferedWriter(path);
		} catch (Exception e) {
			throw new RuntimeException("Can't write file to: "+path);
		}
	}

	public static void readByLineConsumer(Path path, Predicate<String> consumer) throws UtilException {
		BufferedReader reader = null;
		try {
			reader = Files.newBufferedReader(path);
			for(String line=reader.readLine(); line != null; line = reader.readLine()) {
				if( !consumer.test(line)){
					return;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Can't read: "+path);
		} finally {
			if( reader != null ){
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException("Can't close: "+path);
				}
			}
		}
	}

	public static Supplier<String> readByLineSupplier(Path path) throws UtilException {
		ReadByLineIterator iterator = new ReadByLineIterator(path); 
		return ()->{
			return iterator.next();
		};
	}

	public static List<String> read2List(Path path) throws UtilException {
		try {
			return Files.readAllLines(path);
		} catch (Exception e) {
			throw new RuntimeException("Can't read from: "+path, e);
		}
	}


	public static InputStream read2Stream(Path path) throws UtilException {
		try {
			return Files.newInputStream(path);
		} catch (Exception e) {
			throw new RuntimeException("Can't read from: "+path, e);
		}
	}

	public static String read2String(Path path) throws UtilException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(read2Stream(path));
			return scanner.useDelimiter("\\A").next();
		} finally {
			scanner.close();
		}
	}

	public static void walkConsumer(Path path, Consumer<Path> consumer) throws UtilException {
		try {
			Files.walk(path).filter(Files::isRegularFile).forEach(consumer::accept);
		} catch (Exception e) {
			throw new RuntimeException("Can't walk through: "+path, e);
		}
	}

	public static Supplier<Path> walkSupplier(Path path) throws UtilException {
		WalkIterator iterator = new WalkIterator(path); 
		return ()->{
			return iterator.next();
		};
	}

	public static void delete(Path path) {
		try {
			Files.delete(path);
		} catch (Exception e) {
			throw new RuntimeException("Can't delete: "+path, e);
		}
	}
}
