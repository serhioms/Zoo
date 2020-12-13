package codility.version;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class VersionTest {
    // ... write your unit tests here ...
    
    public static class Version implements Comparable<Version> {
    
        public static final String errorVersionMustNotBeNull = "'version' must not be null!";
        public static final String errorOtherMustNotBeNull =  "'other' must not be null!";
        public static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

        private static Pattern versionPattern = Pattern.compile("\\d+(\\.\\d+){0,2}(-SNAPSHOT)?");
    
        final private String version;

        Version(){
            this(null);
        }

        Version(String version){
            if( version == null ){
                throw new IllegalArgumentException(errorVersionMustNotBeNull);
            }
            if( !versionPattern.matcher(version).matches() ) {
                throw new IllegalArgumentException(errorVersionMustMatchPattern);
            }
            this.version = version;
        }

    	public String getVersion() {
    		return version;
    	}
    
    	public boolean isSnapshot(){
    		return version.contains("-SNAPSHOT");
    	}
    
    	@Override
    	public int compareTo(Version o) {
    	    if( o == null ){
                throw new IllegalArgumentException(errorOtherMustNotBeNull);
    	    }
    		String[] split1 = version.split("-");
    		String[] split2 = o.getVersion().split("-");
    		int r1 = split1[0].compareTo(split2[0]);
    		int r2 = Integer.compare(split1.length,split2.length);
    		return r1<0?-1:r1>0?+1:r2==0?0:r2>0?-1:+1;
    	}
        
        @Override
    	public int hashCode() {
    		return version.hashCode();
    	}
    }

    @Test
    public void exampleTest() {
    	try {
            Version version = new Version("3.8.0");
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest_1() {
    	try {
            Version version = new Version("3.8");
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }


    @Test
    public void exampleTest_2() {
    	try {
            Version version = new Version("3");
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest_3() {
    	try {
            Version version = new Version("");
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(Version.errorVersionMustMatchPattern, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest2() {
    	try {
            Version version = new Version("3.8.0-SNAPSHOT");
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest3() {
    	try {
    		Version version = new Version(null);
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(Version.errorVersionMustNotBeNull, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest4() {
    	try {
    		Version version = new Version("3.8.0.1");
    		Assert.fail("Expected exception!");
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(Version.errorVersionMustMatchPattern, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }


    @Test
    public void exampleTest5() {
    	try {
            Version version1 = new Version("3.8.0");
            Version version2 = new Version("3.8.0");
            Assert.assertEquals(0, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest6() {
    	try {
            Version version1 = new Version("3.8.1");
            Version version2 = new Version("3.8.0");
            Assert.assertEquals(+1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest7() {
    	try {
            Version version1 = new Version("3.8.0-SNAPSHOT");
            Version version2 = new Version("3.8.0");
            Assert.assertEquals(-1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest8() {
    	try {
            Version version1 = new Version("3.8.0");
            Version version2 = new Version("3.8.0-SNAPSHOT");
            Assert.assertEquals(+1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest9() {
    	try {
            Version version1 = new Version("3.8.0-SNAPSHOT");
            Version version2 = new Version("3.8.0-SNAPSHOT");
            Assert.assertEquals(0, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest10() {
    	try {
            Version version1 = new Version("3.8.1-SNAPSHOT");
            Version version2 = new Version("3.8.0-SNAPSHOT");
            Assert.assertEquals(+1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }


    @Test
    public void exampleTest11() {
    	try {
            Version version1 = new Version("3.8.1-SNAPSHOT");
            Version version2 = new Version("3.9-SNAPSHOT");
            Assert.assertEquals(-1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest12() {
    	try {
            Version version1 = new Version("3.8.1-SNAPSHOT");
            Version version2 = new Version("3.0-SNAPSHOT");
            Assert.assertEquals(+1, version1.compareTo(version2));
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }


    @Test
    public void exampleTest13() {
    	try {
            Version version1 = new Version("3.8.1-SNAPSHOT");
            Assert.assertEquals(+1, version1.compareTo(null));
    	} catch(IllegalArgumentException e) {
    		Assert.assertEquals(Version.errorOtherMustNotBeNull, e.getMessage());
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }

    @Test
    public void exampleTest14() {
    	try {
            Assert.assertEquals(true, new Version("3.8.1-SNAPSHOT").isSnapshot());
            Assert.assertEquals(false, new Version("3.8.1").isSnapshot());
    	} catch(Exception e) {
    		Assert.fail("Unexpected exception: "+e.getClass().getName()+" "+e.getMessage());
    	}
    }
}
