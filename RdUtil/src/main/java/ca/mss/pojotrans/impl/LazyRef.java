package ca.mss.pojotrans.impl;

public class LazyRef<C> {

	private Class<C> c;
	private C ref;
	
	public LazyRef(Class<C> c) {
		this.c = c;
	}

	public C get() throws InstantiationException, IllegalAccessException {
		if( ref == null ){
			ref = c.newInstance();
		}
		return ref;
	}
	
	public boolean isNull(){
		return ref == null;
	}

	public Class<?> getRefClass() {
		return c;
	}
}
