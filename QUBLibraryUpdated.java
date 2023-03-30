package part03;

import part01.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import console.Console;

public class QUBLibraryUpdated {
	
	/**
	 * 
	 * Create console object.
	 * 
	 */
	
	static Console con = new Console(true);
	
	/**
	 * 
	 * Creates a new instance of the library object.
	 * 
	 */

	private static LibraryUpdated qubLibrary = new LibraryUpdated();
	
	static int count = 0;

	public static void main(String[] args) {
		
		//Setting up the console.
			
		con.setSize(500, 815);
		
		con.setVisible(true);
		
		con.setBgColour(Color.GRAY);
		
		con.setColour(Color.WHITE);
		
		//Method that adds books to the library for testing purposes.
		
		initialize();

		String[] options = { "List All Books", "List Books by Status", "Add a Book", "Remove a Book", "Borrow a Book",
				"Return a Book", "Display Ranked List", "Exit" };

		consoleMenu libraryMenu = new consoleMenu("Library Menu", options);
		
		//Boolean to keep the menu looping.
		
		boolean finished = false;

		do {
			
			//Setting font to begin with.
			
			con.setFont(new Font("Courier", Font.BOLD, 20));
			
			//Header for the top of the menu.
			
			ImageIcon header = new ImageIcon("Images/header.jpg");

			con.print(header);
			
			con.println();
			
			con.println();
		
			int option = libraryMenu.getUserChoice();

			switch (option) {
			
			//Case to run the list method.

			case 1:
				
				con.clear();
				
				con.setFont(new Font("Courier", Font.BOLD, 10));

				for (int i = 0; i < qubLibrary.list().length; i++) {
					
					con.println();
					
					con.print(qubLibrary.list()[i].getImage());
					
					con.print(" ");
					
					con.println();
					
					con.println();
					
					con.println(qubLibrary.list()[i]);
					
					con.println();

				}
				
				con.print("Hit RETURN to continue.");
				
				con.readLn();
				
				con.clear();
				
				break;
				
			//Case to run the list by status method.	

			case 2:
				
				con.clear();
				
				con.setFont(new Font("Courier", Font.BOLD, 10));

				con.println("Select status");
				
				con.println("1. Available");
				
				con.println("2. On Loan");
				
				con.println("3. Withdrawn");
				
				String choiceString = con.readLn();

				int choice = Integer.parseInt(choiceString);

				BookStatus status = null;

				switch (choice) {

				case 1:
					
					status = BookStatus.AVAILABLE;
					
					break;
					
				case 2:
					
					status = BookStatus.ON_LOAN;
					
					break;
					
				case 3:
					
					status = BookStatus.WITHDRAW;
					
					break;
					
				default:
					
					con.println("Invalid selection.");

				}

				if (qubLibrary.list(status).length == 0) {

					con.println("No books available that match");

				} else {

					for (int i = 0; i < qubLibrary.list(status).length; i++) {
						
						con.println();
						
						con.print(qubLibrary.list(status)[i].getImage());
						
						con.println();
						
						con.println(qubLibrary.list(status)[i]);

					}

				}
				
				con.print("Hit RETURN to continue.");
				
				con.readLn();
				
				con.clear();

				break;
				
			//Case to run the addBook method.
				
			case 3:
				
				con.clear();

				con.setFont(new Font("Courier", Font.BOLD, 15));
				
				addBook();
				
				con.print("Hit RETURN to continue.");
				
				con.readLn();
				
				con.clear();

				break;
			
			//Case to run the removeBook method.
				
			case 4:
				
				con.clear();
				
				con.setFont(new Font("Courier", Font.BOLD, 10));

				removeBook();
				
				con.print("Hit RETURN to continue.");
				
				con.readLn();
				
				con.clear();

				break;
				
			//Case to run the borrowBook method.
				
			case 5:

				con.clear();
				
				con.setFont(new Font("Courier", Font.BOLD, 10));
				
				//For loop to only display available books, as they are the only ones that can be borrowed.
				
				for (int i = 0; i < qubLibrary.list(BookStatus.AVAILABLE).length; i++) {
					
					con.println();
					
					con.print(qubLibrary.list(BookStatus.AVAILABLE)[i].getImage());
					
					con.println();

					con.println(qubLibrary.list(BookStatus.AVAILABLE)[i]);

				}

				con.println("Enter the id of the book you would like to borrow.");
				
				String stringIdBorrow = con.readLn();

				int idBorrow = Integer.parseInt(stringIdBorrow) - 1;

				qubLibrary.borrowBook(idBorrow);
				
				con.print("Hit RETURN to continue.");
				
				con.readLn();
				
				con.clear();

				break;
				
			//Case to run the returnBook method.
				
			case 6:
				
				con.clear();
				
				con.setFont(new Font("Courier", Font.BOLD, 10));
				
				//For loop to only display on loan books, as they are the only ones that can be returned.

				for (int i = 0; i < qubLibrary.list(BookStatus.ON_LOAN).length; i++) {
					
					con.println();
					
					con.print(qubLibrary.list(BookStatus.ON_LOAN)[i].getImage());
					
					con.println();
					
					con.println(qubLibrary.list(BookStatus.ON_LOAN)[i]);

				}

				con.println("Enter the id of the book you would like to return.");
				
				String stringIdReturn = con.readLn();

				int idReturn = Integer.parseInt(stringIdReturn) - 1;

				qubLibrary.returnBook(idReturn);
				
				con.print("Hit RETURN to continue.");
				
				con.readLn();
				
				con.clear();

				break;
				
			//Case to run the mostPopular method.
				
			case 7:
				
				con.clear();
				
				con.setFont(new Font("Courier", Font.BOLD, 10));

				for (int i = 0; i < qubLibrary.list().length; i++) {
					
					con.println();
					
					con.print(qubLibrary.mostPopular()[i].getImage());
					
					con.println();

					con.println(qubLibrary.mostPopular()[i]);

				}
				
				con.print("Hit RETURN to continue.");
				
				con.readLn();
				
				con.clear();

				break;

			//Case to close the program.
				
			case 8:
				
				con.clear();
				
				finished = true;
				
				System.exit(0);

				break;

			default:

				con.println("Not a valid option.");

			}

		} while (!finished);

	}
	
	//Method that adds books to the library for testing purposes.

	public static void initialize() {

		LibraryBookUpdated book1 = new LibraryBookUpdated("The Hunger Games", "Suzanne Collins", "1234567899", BookType.FICTION, 1,
				"Twelve boys and twelve girls are forced to appear in a live event called The Hunger Games. There is only one rule: kill or be killed.",
				10);
		
		book1.setImageIcon("Images/b1.jpg");
		
		LibraryBookUpdated book2 = new LibraryBookUpdated("Harry Potter", "JK Rowling", "1234567899", BookType.FICTION, 2,
				"Harry Potter and the Philosopher's Stone is an enthralling start to Harry's journey toward coming to terms with his past and facing his future.",
				10);
		
		book2.setImageIcon("Images/b2.jpg");
		
		LibraryBookUpdated book3 = new LibraryBookUpdated("The Great Gatsby", "F. Scott Fitzgerald", "1234567899", BookType.FICTION,
				3,
				"The novel chronicles an era that Fitzgerald himself dubbed the Jazz Age. Following the shock and chaos of World War 1.",
				10);
		
		book3.setImageIcon("Images/b3.jpg");
		
		LibraryBookUpdated book4 = new LibraryBookUpdated("War and Peace", "Leo Tolstoy", "1234567899", BookType.NON_FICTION, 4,
				"Epic in scale, War and Peace delineates in graphic detail events leading up to Napoleon's invasion of Russia.",
				10);
		
		book4.setImageIcon("Images/b4.jpg");
		
		LibraryBookUpdated book5 = new LibraryBookUpdated("Beyond Good and Evil", "Friedrich Nietzsche", "1234567899",
				BookType.REFERENCE, 5,
				"Beyond Good and Evil: Prelude to a Philosophy of the Future is a book by philosopher Friedrich Nietzsche that covers ideas in his previous work.",
				10);
		
		book5.setImageIcon("Images/b5.jpg");

		qubLibrary.add(book1);
		
		qubLibrary.add(book2);
		
		qubLibrary.add(book3);
		
		qubLibrary.add(book4);
		
		qubLibrary.add(book5);

	}
	
	/**
	 * 
	 * Method that takes in user input to add a book to the array.
	 * 
	 */

	public static void addBook() {

		con.println("Add a new book.");

		String title = null, author = null, isbn = null, summary = null, path = null;
		
		BookType type = null;
		
		int edition = 0;
		
		double price = 0;

		LibraryBookUpdated book = new LibraryBookUpdated(title, author, isbn, type, edition, summary, price);

		do {

			con.print("Enter Title: (String)" + "\n");

			title = con.readLn().trim();

			book.setTitle(title);

		} while (!isValidTitle(title));

		do {

			con.print("Enter Author: (String)" + "\n");

			author = con.readLn().trim();

			book.setAuthor(author);

		} while (!isValidAuthor(author));
		
		do {

		con.print("Enter Isbn: (String)" + "\n");

		isbn = con.readLn().trim();

		book.setIsbn(isbn);
		
		} while (!isValidIsbn(isbn));		
		
		type = selectType();

		book.setType(type);
		
		do {

		con.print("Enter Edition: (Integer)" + "\n");
		
		String stringEdition = con.readLn();

		edition = Integer.parseInt(stringEdition);

		book.setEdition(edition);
		
		} while (!isValidEdition(edition));
				
		do {

		con.print("Enter Summary: (String)" + "\n");

		summary = con.readLn().trim();

		book.setSummary(summary);
		
		} while (!isValidSummary(summary));
		
		do {

		con.print("Enter Price: (Double)" + "\n");
		
		String stringPrice = con.readLn();

		price = Double.parseDouble(stringPrice);

		book.setPrice(price);
		
		} while (!isValidPrice(price));
		
		do {

		con.println("Enter image pathway: (String)" + "\n");

		path = con.readLn().trim();

		book.setImageIcon(path);
		
		} while (!isValidImage(path));

		book.setStatus(BookStatus.AVAILABLE);
		
		qubLibrary.add(book);

		count++;

	}
	
	/**
	 * 
	 * Method to get users selected type.
	 * 
	 * @return
	 */

	public static BookType selectType() {

		String options[] = { "Fiction", "Non Fiction", "Reference" };
		
		int choice = 0;

		BookType type = null;

		do {
		
			consoleMenu typeSelect = new consoleMenu("Select a Type", options);

			choice = typeSelect.getUserChoice();
			
			if(choice == 1) {
				
				type = BookType.FICTION;
				
			}else if(choice == 2) {
				
				type = BookType.NON_FICTION;
				
			}else if(choice == 3) {
				
				type = BookType.REFERENCE;
				
			}else type = null;

	} while (!isValidType(choice));

	return type;
	
	}
	
	//The following few methods are used to check if the users input passes the proper criteria.

	public static boolean isValidType(int choice) {

		if (choice < 1 || choice > 3) {

			return false;

		} else {
			
			return true;
			
		}

	}

	public static boolean isValidTitle(String title) {

		if (title.length() < 10 || title.length() > 100) {

			return false;

		} else {
			
			return true;
			
		}

	}

	public static boolean isValidIsbn(String isbn) {

		if (isbn.length() != 10) {

			return false;

		} else {
			
			return true;
			
		}

	}

	public static boolean isValidEdition(int edition) {

		if (edition < 1) {

			return false;

		} else {
			
			return true;
			
		}

	}

	public static boolean isValidSummary(String summary) {

		if (summary.length() < 20 || summary.length() > 150) {

			return false;

		} else {
			
			return true;
			
		}

	}

	public static boolean isValidPrice(double price) {

		if (!(price > 0)) {

			return false;

		} else {
			
			return true;
			
		}

	}

	public static boolean isValidImage(String image) {

		if (image == null) {

			return false;

		} else {
			
			return true;
			
		}

	}

	public static boolean isValidAuthor(String author) {

		if (author.length() < 10 || author.length() > 100) {

			return false;

		} else {
			
			return true;
			
		}

	}
	
	/**
	 * 
	 * Method to remove a book by setting it as withdrawn.
	 * 
	 */

	public static void removeBook() {

		for (int i = 0; i < qubLibrary.list(BookStatus.AVAILABLE).length; i++) {

			con.println();
			
			con.print(qubLibrary.list(BookStatus.AVAILABLE)[i].getImage());
			
			con.println();

			con.println(qubLibrary.list(BookStatus.AVAILABLE)[i]);

		}

		con.println("Enter the id of the book you want to remove.");
		
		String stringChoice = con.readLn();

		int choice = Integer.parseInt(stringChoice) - 1;

		qubLibrary.list(BookStatus.AVAILABLE)[choice].setStatus(BookStatus.WITHDRAW);

		con.println("succesfully removed");

	}

}
