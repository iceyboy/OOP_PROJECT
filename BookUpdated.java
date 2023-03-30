package part03;

import part01.BookType;
import part01.iBook;

public class BookUpdated implements iBook{

	private String title;
	
	private String author;
	
	private String isbn;
	
	private BookType type;
	
	private int edition;
	
	private String summary;
	
	private double price;

	public BookUpdated(String title, String author, String isbn, BookType type, int edition, String summary, double price) {

		this.title = title;
		
		this.author = author;
		
		this.isbn = isbn;
		
		this.type = type;
		
		this.edition = edition;
		
		this.summary = summary;
		
		this.price = price;

	}

	public void setTitle(String title) {

		try {
			
			if (title.length() < 10 || title.length() > 100) {

				throw new IllegalArgumentException("Title must be between 10 and 100 characters, try again.");

			} else {

				this.title = title;
				
			}

		} catch (IllegalArgumentException e) {

			QUBLibraryUpdated.con.println(e.getMessage());

		}

	}

	public void setAuthor(String author) {

		try {
			
			if (author.length() < 10 || author.length() > 100) {

				throw new IllegalArgumentException("Author must be between 10 and 100 characters, try again.");

			} else {

				this.author = author;
				
			}

		} catch (IllegalArgumentException e) {

			QUBLibraryUpdated.con.println(e.getMessage());

		}

	}

	public void setIsbn(String isbn) {

		try {
			
			if ((isbn.length() != 10)) {

				throw new IllegalArgumentException("ISBN must be exactly 10 digits, try again.");

			} else {

				this.isbn = isbn;
				
			}

		} catch (IllegalArgumentException e) {

			QUBLibraryUpdated.con.println(e.getMessage());

		}

	}

	public void setType(BookType type) {

		try {

			this.type = type;

		} catch (IllegalArgumentException e) {

			QUBLibraryUpdated.con.println(e.getMessage());

		}

	}

	public void setEdition(int edition) {

		try {
			
			if (!(edition >= 1)) {

				throw new IllegalArgumentException("Edition must be 1 or greater, try again.");

			} else {

				this.edition = edition;
				
			}

		} catch (IllegalArgumentException e) {

			QUBLibraryUpdated.con.println(e.getMessage());

		}

	}

	public void setSummary(String summary) {

		try {
			
			if (summary.length() < 20 || summary.length() > 150) {

				throw new IllegalArgumentException("Title must be between 20 and 150 characters, try again.");

			} else {

				this.summary = summary;
				
			}

		} catch (IllegalArgumentException e) {

			QUBLibraryUpdated.con.println(e.getMessage());

		}

	}

	public void setPrice(double price) {

		try {
			
			if (!(price > 0)) {

				throw new IllegalArgumentException("Price must be greater than £0.00, try again.");

			} else {

				this.price = price;
				
			}

		} catch (IllegalArgumentException e) {

			QUBLibraryUpdated.con.println(e.getMessage());

		}

	}

	public String getTitle() {

		return this.title;

	}

	public String getAuthor() {

		return this.author;

	}

	public String getIsbn() {

		return this.isbn;

	}

	public BookType getType() {

		return this.type;

	}

	public int getEdition() {

		return this.edition;

	}

	public String getSummary() {

		return this.summary;

	}

	public double getPrice() {

		return this.price;

	}

	public String toString() {

		String priceFormat = String.format("%.2f", price);
		
		String result = "";
		
		result += title + " by " + author + "\n";
		
		result += "ISBN: " + isbn + "\n";
		
		result += "Type: " + type.toString() + "\n";
		
		result += "Edition: " + edition + "\n";
		
		result += "Summary: " + summary + "\n";
		
		result += "Price: £" + priceFormat + "\n";
		
		return result;

	}

}
