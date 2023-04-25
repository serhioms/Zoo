package my.tamingjavathreades.p10;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*

AWT library and and the Swing extensions to AWT as well.) AWT
processes operating-system events on a special thread, created by AWT when a program "realizes"
(makes visible) its first window. As a consequence, most programs have at least two threads running:
the "main" thread, on which main() executes, and the AWT thread, which processes events that come
in from the operating system and calls any registered listeners in response to those events. It's
important to note that all your listener methods run on the AWT thread, not on the main thread (where
the listener object is typically created).

There are two main difficulties to this architecture. First, although the listeners run on the AWT
thread, they are typically inner-class objects that access an outerclass object that was, in turn, created
by (and is accessed by) the main thread.

The handler for the Sleep button
puts the current thread (which will be the Swing event-handler thread) to sleep for five seconds. The
Hello button just prints "Hello world" on the console. During the five seconds that elapse after you
press the Sleep button, pressing the Hello button has no effect. If you click the Hello button five
times, "Hello world" is printed five times as soon as the sleep finishes. The button-press events are
queued up while the Swing thread is sleeping, and they are serviced when the Swing thread wakes up.

*/


@SuppressWarnings("serial")
class Hang extends JFrame {
	
	public Hang() {
		JButton b1 = new JButton("Sleep");
		JButton b2 = new JButton("Hello");

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
				}
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Hello world");
			}
		});

		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(b1);

		getContentPane().add(b2);
		pack();
		show();
	}

	public static void main(String[] args) {
		new Hang();
	}
}


