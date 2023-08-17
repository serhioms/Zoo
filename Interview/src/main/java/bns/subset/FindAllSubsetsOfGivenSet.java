package bns.subset;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class FindAllSubsetsOfGivenSet {

    @Test
    public void testSubSetsStream() {

        List<String> set = Arrays.asList("A", "B", "C", "D");
        SubSets subset = new SubSets(set.size());

        String result = "";
        while (subset.hasNext()) {
            result += "[" + subset.next().map(i -> set.get(i)).collect(Collectors.joining(", ")) + "];";
        }
        assertEquals("[A, B, C, D];[A, B, C];[A, B, D];[A, B];[A, C, D];[A, C];[A, D];[A];[B, C, D];[B, C];[B, D];[B];[C, D];[C];[D];", result);
    }

    @Test
    public void testSubSetsLambda() {

        List<String> set = Arrays.asList("A", "B", "C", "D");
        SubSets subset = new SubSets(set.size());

        String[] result = new String[]{""};
        while (subset.hasNext()) {
            subset.next(stack -> {
                result[0] += "["+stack.stream().map(i -> set.get(i)).collect(Collectors.joining(", "))+"];";
                return 0;
            });
        }
        assertEquals("[A, B, C, D];[A, B, C];[A, B, D];[A, B];[A, C, D];[A, C];[A, D];[A];[B, C, D];[B, C];[B, D];[B];[C, D];[C];[D];", result[0]);
    }
}
