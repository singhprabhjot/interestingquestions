package ps.concurrentincrementor;

public class Test {
	ArrayHolder arrayHolder;
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
		arrayHolder = new ArrayHolder();
		IncrementorThread firstIncrementor = new IncrementorThread(arrayHolder);
		IncrementorThread secondIncrementor = new IncrementorThread(arrayHolder);
		firstThread  = new Thread(firstIncrementor);
		secondThread = new Thread(secondIncrementor);
		firstThread.start();
		secondThread.start();			
	}
	
	private  void testValues() {
		int array[] =arrayHolder.getArray();
		boolean isError = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i]!=2){
				isError = true;
				break;
			}
		}
		
		if (!isError){
			System.out.println("Application Running Fine");
		}
		else{
			System.out.println("Application not running as expected");
		}
		
	}

	
}
