package src.main.java.random;

public class CollectionObject {

	int[] arr;
	public CollectionObject(int[] arr) {
		this.arr = arr;
	}
	

	public CollectionObject top(int d) {
		int[] subArr = new int[d];
		for(int i=0; i<d; i++) {
			subArr[i] = arr[i];
		}
		
		CollectionObject collectionObject = new CollectionObject(subArr);
		return collectionObject;
	}
	
//	
//	public CollectionObject shuffle(CollectionObject collectionObject) {
//		
//	}
}
