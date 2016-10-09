package siit.java4.homework.bubblesort;

public class Book implements Comparable<Book>{
	/**
	 * numberOfPages of the book
	 * author of the book
	 * title of the book
	 */
	int numberOfPages;
	String author;
	String title;
	public Book(int numberOfPages, String author, String title) {
		super();
		this.numberOfPages = numberOfPages;
		this.author = author;
		this.title = title;
	}
	/**
	 * sorts books after number of pages
	 * checks for duplicate
	 */
	@Override
	public int compareTo(Book arg0) {
		if(this.numberOfPages==arg0.numberOfPages&&this.title==arg0.title&&this.author==arg0.author){
		return 0;
		} else if(this.numberOfPages<arg0.numberOfPages){
			return 1;
		} else{
			return -1;
		}
	}
}
