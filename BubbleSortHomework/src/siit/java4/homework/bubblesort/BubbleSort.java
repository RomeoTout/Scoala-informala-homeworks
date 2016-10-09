package siit.java4.homework.bubblesort;

public class BubbleSort {
	/**
	 * a generic method that iterates through the items of a list, 
	 * compares the first two items and swappes their position if the second one
	 * is smaller.
	 * @param listToSort = the list that will be sorted
	 * @return the same list but sorted
	 */
	public <T extends Comparable<T>> T[] bubblesorter(T[] listToSort){
		T temporaryValue;
		boolean changed=true;
		for(int j=1; j<listToSort.length&changed;j++){
			changed = false;
			for(int i=0;i<listToSort.length-j;i++){
				if(listToSort[i].compareTo(listToSort[i+1])>0){
					temporaryValue=listToSort[i];
					listToSort[i]=listToSort[i+1];
					listToSort[i+1]=temporaryValue;
					changed=true;
				}
			}
			
		}
		return listToSort;
	}
}
