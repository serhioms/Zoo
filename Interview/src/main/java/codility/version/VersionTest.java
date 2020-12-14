package codility.version;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

// 88%
public class VersionTest {
    // ... write your unit tests here ...

    @Test
    public void exampleTest1() {
    	try {
    		Version version = new Version(null);
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(errorVersionMustNotBeNull, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail("No exception thrown when null version passed to constructor: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }
    
    @Test
    public void exampleTest2() {
    	try {
            Version version = new Version("ABC");
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(errorVersionMustMatchPattern, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail(": "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest5() {
    	try {
            Assert.assertEquals(true, new Version("3.8.1-SNAPSHOT").isSnapshot());
            Assert.assertEquals(false, new Version("3.8.1").isSnapshot());
    	} catch(Exception e) {
    		Assert.fail("Snupsot is not recognized correctly - always false: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }
    
    @Test
    public void exampleTest61() {
    	try {
            Version version1 = new Version("3.8.1-SNAPSHOT");
            Assert.assertEquals(+1, version1.compareTo(null));
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(errorOtherMustNotBeNull, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail("Comparision with null not allowed: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }
    
    @Test
    public void exampleTest62() {
    	try {
            Version version1 = new Version("3.8.0");
            Version version2 = new Version("3.8.0");
            Assert.assertEquals(0, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest63() {
    	try {
            Version version1 = new Version("3.8.1");
            Version version2 = new Version("3.8.0");
            Assert.assertEquals(+1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest64() {
    	try {
            Version version1 = new Version("3.8.0-SNAPSHOT");
            Version version2 = new Version("3.8.0");
            Assert.assertEquals(-1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest641() {
    	try {
            Version version1 = new Version("3.8.0-SNAPSHOT");
            Version version2 = new Version("4.4.4");
            Assert.assertEquals(-1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("The snapshot version must always be lower than any non-snapshot version eg. 1.0.0-SNAPSHOT < 1.0.0: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest65() {
    	try {
            Version version1 = new Version("3.8.0");
            Version version2 = new Version("3.8.0-SNAPSHOT");
            Assert.assertEquals(+1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest66() {
    	try {
            Version version1 = new Version("3.8.0-SNAPSHOT");
            Version version2 = new Version("3.8.0-SNAPSHOT");
            Assert.assertEquals(0, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest67() {
    	try {
            Version version1 = new Version("3.8.1-SNAPSHOT");
            Version version2 = new Version("3.8.0-SNAPSHOT");
            Assert.assertEquals(+1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }


    @Test
    public void exampleTest68() {
    	try {
            Version version1 = new Version("3.8.1-SNAPSHOT");
            Version version2 = new Version("3.9-SNAPSHOT");
            Assert.assertEquals(-1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest69() {
    	try {
            Version version1 = new Version("3.8.1-SNAPSHOT");
            Version version2 = new Version("3.0-SNAPSHOT");
            Assert.assertEquals(+1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }
    
    @Test
    public void exampleTest70() {
    	try {
            Assert.assertEquals(true, new Version("3.8.1-SNAPSHOT").isSnapshot());
            Assert.assertEquals(false, new Version("3.8.1").isSnapshot());
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }
    
    @Test
    public void exampleTest7() {
    	try {
    		Version version = new Version("3.8.1-GARBIDGE");
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(errorVersionMustMatchPattern, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail("Any suffix allowed: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest71() {
    	try {
    		Version version = new Version("3.8.1-snapshot");
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(errorVersionMustMatchPattern, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail("Any suffix allowed: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest8() {
    	try {
    		Version version = new Version("3.8.0.1");
    		Assert.fail("Expected exception!");
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(errorVersionMustMatchPattern, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail("More then 3 parts allowed: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }
    
    @Test
    public void exampleTest9() {
    	try {
            Version version1 = new Version("3.8.1-SNAPSHOT");
            Version version2 = new Version("3.0-SNAPSHOT");
            Assert.assertEquals(+1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Comparision reversed: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }
    
    @Test
    public void exampleTest91() {
    	try {
            Version version = new Version("3.8.0");
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest92() {
    	try {
            Version version = new Version("3.8");
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }


    @Test
    public void exampleTest93() {
    	try {
            Version version = new Version("3");
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }


    @Test
    public void exampleTest94() {
    	try {
            Version version = new Version("3.8.0-SNAPSHOT");
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }  
    
    
    // ???????????????? Subtle bug ???????????????????
    
    
    
    // expected error messages:

    static final String errorVersionMustNotBeNull = "'version' must not be null!";
    static final String errorOtherMustNotBeNull =  "'other' must not be null!";
    static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";
}
