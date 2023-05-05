package util;

import org.junit.AfterClass;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestAutomation {

    static protected List<TestImplementation> implList = new ArrayList<>(100);
    static protected List<String> implLabel = new ArrayList<>(100);
    static protected List<long[]> resultList = new ArrayList<>(1024);
    static protected int testIdx = -1;

    protected int reportIdx = 0;

    protected static <T extends TestImplementation> void addImplementation(T impl, String label) {
        implList.add(impl);
        implLabel.add(label);
    }

    protected void runAllImplementations(Consumer<TestImplementation> test) {
        for (TestImplementation item : implList) {
            long start = System.nanoTime();
            test.accept(item);
            long end = System.nanoTime();
            resultList.get(testIdx)[++reportIdx] = end - start;
        }
    }

    @AfterClass
    public static void afterClass() {
        for(int i = 0, maxi = resultList.get(0).length; i<maxi; ++i){
            long total = 0;
            for(int j = 0, maxj = resultList.size(); j<maxj; ++j){
                total += resultList.get(j)[i];
            }
            System.out.printf("Report %15s = %,15d ns\n", implLabel.get(i), total);
        }
    }

    @Before
    public void before() {
        ++testIdx;
        reportIdx = -1;
        resultList.add(new long[implList.size()]);
    }


}
