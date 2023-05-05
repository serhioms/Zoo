package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class TestUtil {

    public static int[] readIntArray(String filePath) {
        try {
            String[] strarr = null;
            InputStream in = new FileInputStream(filePath);
            if (in != null) {
                Scanner scanner = new Scanner(in);
                while (scanner.hasNext()) {
                    strarr = scanner.next().split(",");
                }
            }
            int[] arr = Arrays.stream(strarr).mapToInt(Integer::parseInt).toArray();
            return arr;
        } catch(Exception e){
            return null;
        }
    }

}
