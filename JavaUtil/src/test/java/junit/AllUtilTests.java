package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.eval.TestUtilEval;
import junit.match.TestMatch;
import junit.script.TestScript;

@RunWith(Suite.class)
@SuiteClasses({ TestScript.class, TestMatch.class, TestUtilEval.class })
public class AllUtilTests {

}
