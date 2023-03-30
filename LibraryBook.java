package part01;

import javax.swing.ImageIcon;

public class LibraryBook implements Lendable, iLibraryBook {

	private int id;

	private static int nextId = 1;

	private BookStatus status;

	private ImageIcon image;

	private int loanCount = 0;

	private Book book;
	
	/**
	 * 
	 * Constructor to create the LibraryBook object.
	 * Sets the status to available and increments the id count.
	 * 
	 * @param title
	 * @param author
	 * @param isbn
	 * @param type
	 * @param edition
	 * @param summary
	 * @param price
	 */

	public LibraryBook(String title, String author, String isbn, BookType type, int edition, String summary,
			double price) {

		this.book = new Book(title, author, isbn, type, edition, summary, price);

		setStatus(BookStatus.AVAILABLE);

		this.id = nextId;

		nextId++;

	}
	
	/**
	 * 
	 * Setter to set the title of the book. 
	 * 
	 * @param title
	 */

	public void setTitle(String title) {

		this.book.setTitle(title);

	}
	
	/**
	 * 
	 * Setter to set the author of the book.
	 * 
	 * @param author
	 */

	public void setAuthor(String author) {

		this.book.setAuthor(author);

	}

	/**
	 * 
	 * Setter to set the isbn of the book. 
	 * 
	 * @param isbn
	 */
	
	public void setIsbn(String isbn) {

		this.book.setIsbn(isbn);

	}

	/**
	 * 
	 * Setter to set the type of the book. 
	 * 
	 * @param type
	 */
	
	public void setType(BookType type) {

		this.book.setType(type);

	}
	
	/**
	 * 
	 * Setter to set the edition of the book. 
	 * 
	 * @param edition
	 */

	public void setEdition(int edition) {

		this.book.setEdition(edition);

	}
	
	/**
	 * 
	 * Setter to set the summary of the book. 
	 * 
	 * @param summary
	 */

	public void setSummary(String summary) {

		this.book.setSummary(summary);

	}
	
	/**
	 * 
	 * Setter to set the price of the book. 
	 * 
	 * @param price
	 */

	public void setPrice(double price) {

		this.book.setPrice(price);

	}
	
	/**
	 * 
	 * Setter to set the image of the book. 
	 * Creates new ImageIcon and sets it with the path string.
	 * 
	 * @param path
	 */

	public void setImageIcon(String path) {
		
		if(path != null) {

		ImageIcon img = new ImageIcon(path);

		this.image = img;
		
		}

	}
	
	/**
	 * 
	 * Returns id of the book.
	 * 
	 * @return
	 */

	public int getId() {

		return this.id;

	}

	/**
	 * 
	 * Returns the book.
	 * 
	 * @return
	 */
	
	public Book getBook() {

		return this.book;

	}
	
	/**
	 * 
	 * Returns image of the book if it's not null.
	 * 
	 * @return
	 */

	public ImageIcon getImage() {

		if (image != null) {

			return image;

		} else {

			return null;

		}

	}
	
	/**
	 * 
	 * Increments the loan count.
	 * 
	 */

	public void bookLoaned() {

		loanCount++;

	}
	
	/**
	 * 
	 * Returns the current loan count.
	 * 
	 * @return
	 */

	public int getLoanCount() {

		return this.loanCount;

	}
	
	/**
	 * 
	 * Returns the status of the book.
	 * 
	 */

	public BookStatus getStatus() {

		return this.status;

	}
	
	/**
	 * 
	 * Sets the status of the book.
	 * 
	 */

	public void setStatus(BookStatus st) {

		this.status = st;

	}
	
	/**
	 * 
	 * Method to return a string containing the details of the book.
	 * 
	 * @return
	 */

	public String toString() {
		
		String priceFormat = String.format("%.2f", this.book.getPrice());
		
		String str = "";
		
		str += this.getId() + ", ";
		
		str += this.book.getTitle() + ", ";
		
		str += this.book.getAuthor() + ", ";
		
		str += this.book.getIsbn() + ", ";
		
		str += this.book.getType() + ", ";
		
		str += this.book.getEdition() + ", ";
		
		str += this.book.getSummary() + ", ";
		
		str += "£" + priceFormat + ".";
		
		return str;
		
	}
	
	/**
	 * 
	 * Method to check out a book, if the book is available it will set the status to on loan and return true.
	 * If book is borrowed the loan count will increment.
	 * 
	 */

	public boolean checkout() {

		if (getStatus() == BookStatus.AVAILABLE) {

			setStatus(BookStatus.ON_LOAN);

			System.out.println("Book borrowed, set to on loan.");

			this.loanCount++;

			return true;

		} else {

			System.out.println("Book unavailable to checkout.");

			return false;

		}
		
	}
	
	/**
	 * 
	 * Method to check in a book, if the book is on loan it will set the status to available and return true.
	 * 
	 */

	public boolean checkIn() {

		if (getStatus() == BookStatus.ON_LOAN) {

			setStatus(BookStatus.AVAILABLE);

			System.out.println("Book returned, set to available.");

			return true;

		} else {

			System.out.println("Book unavailable to check in.");

			return false;

		}

	}

}