package part03;

import javax.swing.ImageIcon;

import part01.BookStatus;
import part01.BookType;
import part01.Lendable;
import part01.iLibraryBook;

public class LibraryBookUpdated implements Lendable, iLibraryBook {

	private int id;

	private static int nextId = 1;

	private BookStatus status;

	private ImageIcon image;

	private int loanCount = 0;

	private BookUpdated book;

	public LibraryBookUpdated(String title, String author, String isbn, BookType type, int edition, String summary,
			double price) {

		this.book = new BookUpdated(title, author, isbn, type, edition, summary, price);

		setStatus(BookStatus.AVAILABLE);

		this.id = nextId;

		nextId++;

	}

	public void setTitle(String title) {

		this.book.setTitle(title);

	}

	public void setAuthor(String author) {

		this.book.setAuthor(author);

	}

	public void setIsbn(String isbn) {

		this.book.setIsbn(isbn);

	}

	public void setType(BookType type) {

		this.book.setType(type);

	}

	public void setEdition(int edition) {

		this.book.setEdition(edition);

	}

	public void setSummary(String summary) {

		this.book.setSummary(summary);

	}

	public void setPrice(double price) {

		this.book.setPrice(price);

	}

	public void setImageIcon(String path) {
		
		if(path != null) {

		ImageIcon img = new ImageIcon(path);

		this.image = img;
		
		}

	}

	public int getId() {

		return this.id;

	}

	public BookUpdated getBook() {

		return this.book;

	}

	public ImageIcon getImage() {

		if (image != null) {

			return image;

		} else {

			return null;

		}

	}

	public void bookLoaned() {

		loanCount++;

	}

	public int getLoanCount() {

		return this.loanCount;

	}

	public BookStatus getStatus() {

		return this.status;

	}

	public void setStatus(BookStatus st) {

		this.status = st;

	}

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

	public boolean checkout() {

		if (getStatus() == BookStatus.AVAILABLE) {

			setStatus(BookStatus.ON_LOAN);

			QUBLibraryUpdated.con.println("Book borrowed, set to on loan.");

			this.loanCount++;

			return true;

		} else {

			QUBLibraryUpdated.con.println("Book unavailable to checkout.");

			return false;

		}
		
	}

	public boolean checkIn() {

		if (getStatus() == BookStatus.ON_LOAN) {

			setStatus(BookStatus.AVAILABLE);

			QUBLibraryUpdated.con.println("Book returned, set to available.");

			return true;

		} else {

			QUBLibraryUpdated.con.println("Book unavailable to check in.");

			return false;

		}

	}

}