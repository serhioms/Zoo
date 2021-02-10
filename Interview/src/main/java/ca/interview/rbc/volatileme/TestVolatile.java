package ca.interview.rbc.volatileme;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestVolatileVieBarriers.class, TestVolatileViePhaser.class})
public class TestVolatile {

	/*
		final int T = 10000;
		final int N = 100000;
 PHASER 38,370 mls + atomic 64,898 mls + lock 62,946 mls
        Sync volatile =        6,970 mls
        Lock volatile =        6,992 mls
    Lock non volatile =           70 mls
    Sync non volatile =           66 mls
Non sync non volatile =          136 mls
    Non sync volatile =    1,567,886 mls
               atomic =    3,397,694 mls
    
 BARRIERS 25,850 mls  + atomic 52,431 mls + lock 53,183 mls
        Sync volatile =        7,644 mls
        Lock volatile =        7,088 mls
    Lock non volatile =           97 mls
    Sync non volatile =          138 mls
Non sync non volatile =          270 mls
    Non sync volatile =      121,483 mls
               atomic =      225,416 mls
        
		final int T = 100;
		final int N = 10000000;
 PHASER 23,231 mls
        Sync volatile =        6,973 mls
    Sync non volatile =           61 mls
Non sync non volatile =       29,000 mls
    Non sync volatile =    1,515,425 mls

 BARRIERS 22,542 mls
        Sync volatile =        7,133 mls
    Sync non volatile =           60 mls
Non sync non volatile =          163 mls
    Non sync volatile =    1,516,700 mls

		final int T = 10;
		final int N = 100000000;
 PHASER 22,819 mls + atomic 51,153 mls
        Sync volatile =        6,968 mls
    Sync non volatile =           60 mls
Non sync non volatile =          464 mls
    Non sync volatile =      153,894 mls
               atomic =      284,596 mls

 BARRIERS 22,847 mls + atomic 51,807 mls
        Sync volatile =        6,941 mls
    Sync non volatile =           55 mls
Non sync non volatile =          111 mls
    Non sync volatile =      142,707 mls
               atomic =      267,002 mls
    */
}
