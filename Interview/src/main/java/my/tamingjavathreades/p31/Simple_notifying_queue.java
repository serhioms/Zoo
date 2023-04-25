package my.tamingjavathreades.p31;


/** Race Conditions and Spin Locks
 * 
 * A race condition occurs when two threads try to access the same object at the same time, and the
 * behavior of the code changes depending on who wins.
 *  
 * I'll show you how to cure a race condition with the Simple_notifying_queue class, which
 * demonstrates a blocking queue used by one thread to notify another when some event occurs.
 * The basic notion is that a thread that tries to dequeue from an empty queue will block until some other
 * thread puts something in the queue.
 * 
 * The queue is implemented as a ring buffer...
 * 
 * The wait() call doesn't return until the method that calls notify() releases the monitor.
 */

public class Simple_notifying_queue {

	private static final int QUEUE_SIZE = 10;
	
	private Object[] queue = new Object[QUEUE_SIZE];
	private int head = 0;
	private int tail = 0;

	public synchronized void enqueue(Object item) {
		tail = ++tail % QUEUE_SIZE;
		queue[tail] = item;
		this.notify(); // The "this" is there only to improve readability.
	}

	public synchronized boolean isEmpty() {
		return head == tail;
	}
		
	public synchronized Object dequeue() {
		try { 
			
			// If the queue is empty, wait for some other thread to
			// enqueue something. The following test MUST be a while,
			// not an if, statement.


			/* That innocuous while loop (Listing 2.1, line 22) is pretty important.
			 * First, consider what would
			 * happen if you replaced the notify() call with a call to notifyAll(). Imagine that several threads were
			 * simultaneously trying to dequeue something from the same empty queue. All of these threads are
			 * blocked on a single condition variable, waiting for an enqueue operation to be executed. When
			 * enqueue() sets the condition to true by calling notifyAll(), the threads are all released from the wait
			 * (moved from a suspended to a runnable state). The released threads all try to acquire the monitor at
			 * once, but only one wins and gets the mutex, dequeueing the (one-and-only) object.
			 * 
			 * That's one of the reasons why we need that while
			 * statement�the other threads will all loop back up, notice that the queue is empty, and go back to
			 * waiting. This sort of loop is called a spin lock.
			*/
			while (head == tail){
				this.wait();
			}
			
		} catch (InterruptedException e) {
			// If we get here, we were not actually notified.
			// returning null doesn't indicate that the
			// queue is empty, only that the waiting was
			// abandoned.

			return null;
		}

		// Remove the object from the queue. Note that the assignment
		// of null to the vacated slot is essential. If I didn't do
		// it, the reference to the dequeued object could stay alive
		// until the queue is garbage collected, even though the object
		// has been "removed" from the queue. Who says there's no such
		// thing as a memory leak in Java?

		head = ++head % QUEUE_SIZE;
		Object dequeued_object = queue[head];
		queue[head] = null;
		return dequeued_object;
	}

	static public void main(String[] args) throws InterruptedException {

		Simple_notifying_queue queue = new Simple_notifying_queue();
		
		queue.enqueue("Ganetta");
		queue.enqueue("Lisetta");
		queue.enqueue("Annetta");
		queue.enqueue("Gorgetta");

		while( !queue.isEmpty() ){
			System.out.println( queue.dequeue() );
		}

		System.out.println( queue.dequeue() );
		
		queue.enqueue("Antuanetta");

		while( !queue.isEmpty() ){
			System.out.println( queue.dequeue() );
		}
	}
	
}
