package part01;

public class Book implements iBook {

	private String title;

	private String author;

	private String isbn;

	private BookType type;

	private int edition;

	private String summary;

	private double price;
	
	/**
	 * 
	 * Constructor to create a book object.
	 * 
	 * @param title
	 * @param author
	 * @param isbn
	 * @param type
	 * @param edition
	 * @param summary
	 * @param price
	 */

	public Book(String title, String author, String isbn, BookType type, int edition, String summary, double price) {

		this.title = title;

		this.author = author;

		this.isbn = isbn;

		this.type = type;

		this.edition = edition;

		this.summary = summary;

		this.price = price;

	}
	
	/**
	 * 
	 * Setter to set the title of the book. 
	 * Includes validation to make sure the title matches the requirements needed.
	 * 
	 * @param title
	 */

	public void setTitle(String title) {

		try {

			if (title.length() < 10 || title.length() > 100) {

				throw new IllegalArgumentException("Title must be between 10 and 100 characters, try again.");

			} else {

				this.title = title;

			}

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}
	
	/**
	 * 
	 * Setter to set the author of the book.
	 * Includes validation to make sure the author matches the requirements needed.
	 * 
	 * @param author
	 */

	public void setAuthor(String author) {

		try {

			if (author.length() < 10 || author.length() > 100) {

				throw new IllegalArgumentException("Author must be between 10 and 100 characters, try again.");

			} else {

				this.author = author;

			}

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}
	
	/**
	 * 
	 * Setter to set the isbn of the book.
	 * Includes validation to make sure the isbn matches the requirements needed.
	 * 
	 * @param isbn
	 */

	public void setIsbn(String isbn) {

		try {

			if (isbn.length() != 10) {

				throw new IllegalArgumentException("ISBN must be exactly 10 digits, try again.");

			} else {

				this.isbn = isbn;

			}

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}
	
	/**
	 * 
	 * Setter to set the type of the book.
	 * Includes validation to make sure the type matches the requirements needed.
	 * 
	 * @param type
	 */

	public void setType(BookType type) {

		try {

			this.type = type;

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}
	
	/**
	 * 
	 * Setter to set the edition of the book.
	 * Includes validation to make sure the edition matches the requirements needed.
	 * 
	 * @param edition
	 */

	public void setEdition(int edition) {

		try {

			if (!(edition >= 1)) {

				throw new IllegalArgumentException("Edition must be 1 or greater, try again.");

			} else {

				this.edition = edition;

			}

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}
	
	/**
	 * 
	 * Setter to set the summary of the book.
	 * Includes validation to make sure the summary matches the requirements needed.
	 * 
	 * @param summary
	 */

	public void setSummary(String summary) {

		try {

			if (summary.length() < 20 || summary.length() > 150) {

				throw new IllegalArgumentException("Title must be between 20 and 150 characters, try again.");

			} else {

				this.summary = summary;

			}

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}
	
	/**
	 * 
	 * Setter to set the price of the book.
	 * Includes validation to make sure the price matches the requirements needed.
	 * 
	 * @param price
	 */

	public void setPrice(double price) {

		try {

			if (!(price > 0)) {

				throw new IllegalArgumentException("Price must be greater than £0.00, try again.");

			} else {

				this.price = price;

			}

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}
	
	/**
	 * 
	 * Returns title of the book.
	 * 
	 * @return
	 */

	public String getTitle() {

		return this.title;

	}

	
	/**
	 * 
	 * Return author of the book.
	 * 
	 * @return
	 */
	
	public String getAuthor() {

		return this.author;

	}

	/**
	 * 
	 * Return isbn of the book.
	 * 
	 * @return
	 */
	
	public String getIsbn() {

		return this.isbn;

	}

	/**
	 * 
	 * Return type of the book.
	 * 
	 * @return
	 */
	
	public BookType getType() {

		return this.type;

	}

	/**
	 * 
	 * Return edition of the book.
	 * 
	 * @return
	 */
	
	public int getEdition() {

		return this.edition;

	}

	/**
	 * 
	 * Return summary of the book.
	 * 
	 * @return
	 */
	
	public String getSummary() {

		return this.summary;

	}

	/**
	 * 
	 * Return price of the book.
	 * 
	 * @return
	 */
	
	public double getPrice() {

		return this.price;

	}

	/**
	 * 
	 * Method to return a string containing the details of the book.
	 * 
	 * @return
	 */
	
	public String toString() {

		String priceFormat = String.format("%.2f", getPrice());

		String result = "";

		result += getTitle() + " by " + getAuthor() + "\n";

		result += "ISBN: " + getIsbn() + "\n";

		result += "Type: " + getType() + "\n";

		result += "Edition: " + getEdition() + "\n";

		result += "Summary: " + getSummary() + "\n";

		result += "Price: £" + priceFormat + "\n";

		return result;

	}

}
