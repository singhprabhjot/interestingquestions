package ps.concurrentincrementor;

public class IncrementorThread implements Runnable{
	private ArrayHolder arrayHolder;
	
	public IncrementorThread(ArrayHolder arrayHolder){
		this.arrayHolder = arrayHolder;
	}

	@Override
	public void run() {
		for (int i=0;i<1000;i++){
				try {
					arrayHolder.incrementValue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
