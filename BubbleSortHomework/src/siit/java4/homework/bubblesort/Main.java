package siit.java4.homework.bubblesort;

/**
 * @author Romeo Tout
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		BubbleSort bubSort= new BubbleSort();
		
		Integer[] listOfNumbers = new Integer[] {3, 8, 15, 25, 9, 5, 1, 29};
		bubSort.bubblesorter(listOfNumbers);
		for(int i=0; i<listOfNumbers.length; i++){
		System.out.print(listOfNumbers[i]+" ");
		}
	}

}
