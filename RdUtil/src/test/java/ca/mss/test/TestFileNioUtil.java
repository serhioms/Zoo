package ca.mss.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import static ca.mss.utilms.FileNioUtil.*;

public class TestFileNioUtil {

	@Test
	public void TestReadByLineConsumer() {
		AtomicInteger count = new AtomicInteger(0);

		readByLineConsumer(getClassLoaderPath("test-file.txt"), (line) -> {
			count.incrementAndGet();
			return true;
		});

		assertEquals(7, count.get());
	}

	@Test
	public void TestReadByLineSupplier() {
		AtomicInteger count = new AtomicInteger(0);

		Supplier<String> supplier = readByLineSupplier(getClassLoaderPath("test-file.txt"));
		for(String line=supplier.get(); line != null; line=supplier.get()) {
			count.incrementAndGet();
		};

		assertEquals(7, count.get());
	}

	@Test
	public void TestWalkConsumer() {
		AtomicInteger count = new AtomicInteger(0);
		
		walkConsumer(getFilePath("src"), (file)->{
			count.incrementAndGet();
		});

		assertEquals(227, count.get());
	}

	@Test
	public void TestWalkSupplier() {
		int count = 0;
		
		Supplier<Path> supplier = walkSupplier(getFilePath("src"));

		for(Path path=supplier.get(); path != null; path=supplier.get()) {
			count++;
		};

		assertEquals(227, count);
	}

	@Test
	public void TestRead2List() {
		assertEquals(7, read2List(getClassLoaderPath("test-file.txt")).size());
	}

	@Test
	public void TestRead2ListFail() {
		try {
			read2List(getClassLoaderPath("abrakadabra.txt"));
			fail("Exception must be thrown!");
		} catch (Exception e) {}
	}
}
