package ps.concurrentincrementor;

/*
 * In a relevant language, create an array of 1000 numbers. Initialize all of the values in the array to zero. 
 * Create two threads that run concurrently and which increment each element of the array one time.
 * When both threads have finished running, all elements in the array should have the value of two. Verify this
 */

public class ArrayHolder implements ArrayContainer{
	private int array[];
	private int index;
	public ArrayHolder(){
		array = new int[1000];
		index=0;
	}
	
 /* This is a synchronized method to allow access to one thread at a time. Every time a value of new index is increased, 
 * current thread goes to sleep and the second thread is notified to perform the action. 
 */
	public synchronized void incrementValue() {	
		array[index] = array[index] + 1;
		if (array[index] == 2){
			index++;
			notify();
		}
		else{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
//		System.out.println(Thread.currentThread().getId()+" :  "+ index +": "+array[index-1]);
	}
	
	public int[] getArray(){
		return array.clone();
	}		
}
