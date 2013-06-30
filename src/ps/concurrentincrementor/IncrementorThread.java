package ps.concurrentincrementor;

public class IncrementorThread implements Runnable{
	private ArrayContainer arrayContainer;
	
	public IncrementorThread(ArrayContainer arrayContainer){
		this.arrayContainer = arrayContainer;
	}

	@Override
	public void run() {
		for (int i=0;i<1000;i++){
			arrayContainer.incrementValue();
		}
	}

}
