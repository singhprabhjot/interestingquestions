package ps.concurrentincrementor;

import java.util.Scanner;

public class Test {
	ArrayContainer arrayContainer;
	Thread firstThread;
	Thread secondThread;
	
	public static void main(String s[]){
		Test test = new Test();
		test.startTest();
		test.waitForThreadsToFinish();
		test.testValues();	
	}
	
	private void waitForThreadsToFinish() {
		// To wait till both threads finish their work
		try {
			firstThread.join();
			secondThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void startTest(){	
		arrayContainer = new ArrayHolderRedefined();
//		arrayContainer = new ArrayHolder();
		IncrementorThread firstIncrementor = new IncrementorThread(arrayContainer);
		IncrementorThread secondIncrementor = new IncrementorThread(arrayContainer);
		firstThread  = new Thread(firstIncrementor);
		secondThread = new Thread(secondIncrementor);
		firstThread.start();
		secondThread.start();			
	}
	
	private  void testValues() {
		int array[] =arrayContainer.getArray();
		boolean isError = false;
		for (int i = 0; i < array.length-1; i++) {
			if (array[i]!=2){
				isError = true;
				break;
			}
		}
		
		if (!isError){
			System.out.println("Application Running As Expected");
		}
		else{
			System.out.println("Application not running as expected");
		}	
	}
}
