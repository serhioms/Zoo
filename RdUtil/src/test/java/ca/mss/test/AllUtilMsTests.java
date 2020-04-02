package ca.mss.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAsync.class, TestEvalUtil.class, TestFileNioUtil.class,
		TestJava.class, TestJS.class, TestListIterator.class, TestPojoTransformer.class, TestStrUtil.class,
		TestThreadContext.class })
public class AllUtilMsTests {

}
