package interview.singlton;

import org.junit.Test;

public class TestSinglton {

	/*
	Final hi(1) = 73 mls
	Synchronized hi(2) = 2323 mls
	SynchronizedOptimized hi(3) = 192 mls
	NonBlocked hi(4) = 190 mls
	*/
	
	@Test
	public void test1() {
		
		System.out.println("Test class singlton...\n");

		for(SingltonFinalFast.start(); SingltonFinalFast.instance.next(); );
		SingltonFinalFast.instance.hi("FinalFast");

		for(SingltonFinal.start(); SingltonFinal.instance().next(); );
		SingltonFinal.instance().hi("Final");
		
		for(SingltonSynchronized.start(); SingltonSynchronized.instance().next(); );
		SingltonSynchronized.instance().hi("Synchronized");
		
		for(SingltonSynchronizedOptimized.start(); SingltonSynchronizedOptimized.instance().next(); );
		SingltonSynchronizedOptimized.instance().hi("SynchronizedOptimized");
		
		for(SingltonFinalLazy.start(); SingltonFinalLazy.instance().next(); );
		SingltonFinalLazy.instance().hi("FinalLazy");

		System.out.println("end\n");

		// fail("Not yet implemented");
	}

	@Test
	public void test6() {
		
		System.out.println("MechanicalSymphaty Test class singlton...\n");

		SingltonFinalFast.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonFinalFast.instance.work();
		SingltonFinalFast.instance.hi("FinalFast");

		SingltonFinal.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonFinal.instance().work();
		SingltonFinal.instance().hi("Final");
		
		SingltonSynchronized.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonSynchronized.instance().work();
		SingltonSynchronized.instance().hi("Synchronized");
		
		SingltonSynchronizedOptimized.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonSynchronizedOptimized.instance().work();
		SingltonSynchronizedOptimized.instance().hi("SynchronizedOptimized");
		
		SingltonFinalLazy.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonFinalLazy.instance().work();
		SingltonFinalLazy.instance().hi("FinalLazy");

		System.out.println("end\n");

		// fail("Not yet implemented");
	}

	@Test
	public void test5() {
		
		System.out.println("\nTest enum singlton...\n");

		for(SingltonFinalFastEnum.start(); SingltonFinalFastEnum.singlton.instance.next(); );
		SingltonFinalFastEnum.singlton.instance.hi("FinalFast");

		for(SingltonFinalEnum.start(); SingltonFinalEnum.singlton.instance().next(); );
		SingltonFinalEnum.singlton.instance().hi("Final");
		
		for(SingltonSynchronizedEnum.start(); SingltonSynchronizedEnum.singlton.instance().next(); );
		SingltonSynchronizedEnum.singlton.instance().hi("Synchronized");
		
		for(SingltonSynchronizedOptimizedEnum.start(); SingltonSynchronizedOptimizedEnum.singlton.instance().next(); );
		SingltonSynchronizedOptimizedEnum.singlton.instance().hi("SynchronizedOptimized");
		
		for(SingltonFinalLazyEnum.start(); SingltonFinalLazyEnum.singlton.instance().next(); );
		SingltonFinalLazyEnum.singlton.instance().hi("FinalLazy");

		System.out.println("end\n");

		// fail("Not yet implemented");
	}


	@Test
	public void test7() {
		
		System.out.println("\nMechanicalSymphaty Test enum singlton...\n");

		SingltonFinalFastEnum.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonFinalFastEnum.singlton.instance.work();
		SingltonFinalFastEnum.singlton.instance.hi("FinalFast");

		SingltonFinalEnum.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonFinalEnum.singlton.instance().work();
		SingltonFinalEnum.singlton.instance().hi("Final");
		
		SingltonSynchronizedEnum.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonSynchronizedEnum.singlton.instance().work();
		SingltonSynchronizedEnum.singlton.instance().hi("Synchronized");
		
		SingltonSynchronizedOptimizedEnum.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonSynchronizedOptimizedEnum.singlton.instance().work();
		SingltonSynchronizedOptimizedEnum.singlton.instance().hi("SynchronizedOptimized");
		
		SingltonFinalLazyEnum.start();
		for(long i=0; i<Greating._100000000L; i++ ) SingltonFinalLazyEnum.singlton.instance().work();
		SingltonFinalLazyEnum.singlton.instance().hi("FinalLazy");

		System.out.println("end\n");

		// fail("Not yet implemented");
	}


}
