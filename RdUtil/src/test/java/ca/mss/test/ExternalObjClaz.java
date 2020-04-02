package ca.mss.test;

public class ExternalObjClaz {

	static public String external1(String arg){
		return "xe";
	}

	static public String external2(String arg1, String arg2){
		return "xexe";
	}

	public String external3(String arg1, String arg2){
		return "xexe";
	}
	
	public String label1="A", label2="B";
	@SuppressWarnings("unused")
	private String label4="C";
	
	public DotObject2 obj2 = new DotObject2();
	public DotObject3 obj3 = new DotObject3();

	public String getLabel1() {
		return label1;
	}
	
	public DotObject2 getObj2() {
		return obj2;
	}

	public DotObject3 getObj3() {
		return obj3;
	}

	public static class DotObject2 {
		final public String label;
		
		public DotObject2() {
			this.label = "B";
		}
		
		public DotObject2(String label) {
			this.label = label;
		}
		
		public String getLabel() {
			return label;
		}
	}
	
	public static class DotObject3 {
		final public DotObject2 obj2 = new DotObject2("C");
		
		public DotObject2 getObj2() {
			return obj2;
		}
	}
}
