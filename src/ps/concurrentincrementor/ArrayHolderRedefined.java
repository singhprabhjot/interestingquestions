package ps.concurrentincrementor;

import java.util.HashMap;

public class ArrayHolderRedefined implements ArrayContainer{
	HashMap<Long,Integer> indexMap;
	int array[];
	
	public ArrayHolderRedefined() {
		indexMap =	new HashMap<Long, Integer>();
		array = new int[1000];
	}
	
	public synchronized void incrementValue(){
		long currentThread = Thread.currentThread().getId();
		int index = getIndex(currentThread);
		array[index] = array[index]+1;		
//		System.out.println(Thread.currentThread().getId() + " : "+ index + ":"+array[index]);
	}

	private int getIndex(long threadId) {
		if (indexMap.containsKey(threadId)){
			int indexToUpdate = indexMap.get(threadId);
			indexToUpdate++;
			indexMap.put(threadId, indexToUpdate);
			return indexToUpdate;
		}
		else {
			indexMap.put(threadId, 0);
			return 0;
		}
		
	}
	
	public int[] getArray(){
		return array.clone();
	}
	
}
