package part01;

import java.util.Scanner;

public class QUBLibrary {
	
	/**
	 * 
	 * Creates a new instance of the library object.
	 * 
	 */

	private static Library qubLibrary = new Library();
	
	/**
	 * 
	 * Scanner for taking input from the user.
	 * 
	 */
	
	private static Scanner input = new Scanner(System.in);
	
	static int count = 0;

	public static void main(String[] args) {
		
		//Method that adds books to the library for testing purposes.
				
		initialize();

		String[] options = { "List All Books", "List Books by Status", "Add a Book", "Remove a Book", "Borrow a Book",
				"Return a Book", "Display Ranked List", "Exit" };

		Menu libraryMenu = new Menu("Library Menu", options);
		
		//Boolean to keep the menu looping.

		boolean finished = false;

		do {

			int option = libraryMenu.getUserChoice();

			switch (option) {
			
			//Case to run the list method.

			case 1:

				for (int i = 0; i < qubLibrary.list().length; i++) {

					System.out.println(qubLibrary.list()[i]);

				}

				break;
				
			//Case to run the list by status method.

			case 2:

				System.out.println("Select status");
				
				System.out.println("1. Available");
				
				System.out.println("2. On Loan");
				
				System.out.println("3. Withdrawn");

				int choice = input.nextInt();
				
				input.nextLine();

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
					
					System.out.println("Invalid selection.");

				}

				if (qubLibrary.list(status).length == 0) {

					System.out.println("No books available that match");

				} else {

					for (int i = 0; i < qubLibrary.list(status).length; i++) {

						System.out.println(qubLibrary.list(status)[i]);

					}

				}

				break;
				
			//Case to run the addBook method.

			case 3:

				addBook();

				break;
				
			//Case to run the removeBook method.
				
			case 4:

				removeBook();

				break;
				
			//Case to run the borrowBook method.
				
			case 5:
				
				//For loop to only display available books, as they are the only ones that can be borrowed.

				for (int i = 0; i < qubLibrary.list(BookStatus.AVAILABLE).length; i++) {

					System.out.println(qubLibrary.list(BookStatus.AVAILABLE)[i]);

				}

				System.out.println("Enter the id of the book you would like to borrow.");

				int idBorrow = input.nextInt() - 1;

				qubLibrary.borrowBook(idBorrow);

				break;
				
			//Case to run the returnBook method.
				
			case 6:
				
				//For loop to only display on loan books, as they are the only ones that can be returned.

				for (int i = 0; i < qubLibrary.list(BookStatus.ON_LOAN).length; i++) {

					System.out.println(qubLibrary.list(BookStatus.ON_LOAN)[i]);

				}

				System.out.println("Enter the id of the book you would like to return.");

				int idReturn = input.nextInt() - 1;

				qubLibrary.returnBook(idReturn);

				break;
				
			//Case to run the mostPopular method.
			
			case 7:

				for (int i = 0; i < qubLibrary.list().length; i++) {

					System.out.println(qubLibrary.mostPopular()[i]);

				}

				break;

			//Case to close the program.	
			
			case 8:

				finished = true;

				break;

			default:

				System.out.println("Not a valid option.");

			}

		} while (!finished);

	}

	//Method that adds books to the library for testing purposes.
	
	public static void initialize() {

		LibraryBook book1 = new LibraryBook("The Hunger Games", "Suzanne Collins", "1234567899", BookType.FICTION, 1,
				"Twelve boys and twelve girls are forced to appear in a live event called The Hunger Games. There is only one rule: kill or be killed.",
				10);
		
		book1.setImageIcon("Images/b1.jpg");
		
		LibraryBook book2 = new LibraryBook("Harry Potter", "JK Rowling", "1234567899", BookType.FICTION, 2,
				"Harry Potter and the Philosopher's Stone is an enthralling start to Harry's journey toward coming to terms with his past and facing his future.",
				10);
		
		book2.setImageIcon("Images/b2.jpg");
		
		LibraryBook book3 = new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", "1234567899", BookType.FICTION,
				3,
				"The novel chronicles an era that Fitzgerald himself dubbed the Jazz Age. Following the shock and chaos of World War 1.",
				10);
		
		book3.setImageIcon("Images/b3.jpg");
		
		LibraryBook book4 = new LibraryBook("War and Peace", "Leo Tolstoy", "1234567899", BookType.NON_FICTION, 4,
				"Epic in scale, War and Peace delineates in graphic detail events leading up to Napoleon's invasion of Russia.",
				10);
		
		book4.setImageIcon("Images/b4.jpg");
		
		LibraryBook book5 = new LibraryBook("Beyond Good and Evil", "Friedrich Nietzsche", "1234567899",
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

		System.out.println("Add a new book.");

		String title = null, author = null, isbn = null, summary = null, path = null;
		
		BookType type = null;
		
		int edition = 0;
		
		double price = 0;

		LibraryBook book = new LibraryBook(title, author, isbn, type, edition, summary, price);

		do {

			System.out.print("Enter Title: (String)" + "\n");

			title = input.nextLine().trim();

			book.setTitle(title);

		} while (!isValidTitle(title));

		do {

			System.out.print("Enter Author: (String)" + "\n");

			author = input.nextLine().trim();

			book.setAuthor(author);

		} while (!isValidAuthor(author));
		
		do {

		System.out.print("Enter Isbn: (String)" + "\n");

		isbn = input.nextLine().trim();

		book.setIsbn(isbn);
		
		} while (!isValidIsbn(isbn));
		
		type = selectType();

		book.setType(type);
			
		do {

		System.out.print("Enter Edition: (Integer)" + "\n");

		edition = input.nextInt();
		
		input.nextLine();

		book.setEdition(edition);
		
		} while (!isValidEdition(edition));
				
		do {

		System.out.print("Enter Summary: (String)" + "\n");

		summary = input.nextLine().trim();

		book.setSummary(summary);
		
		} while (!isValidSummary(summary));
		
		do {

		System.out.print("Enter Price: (Double)" + "\n");

		price = input.nextDouble();
		
		input.nextLine();

		book.setPrice(price);
		
		} while (!isValidPrice(price));
		
		do {

		System.out.println("Enter image pathway: (String)" + "\n");

		path = input.nextLine().trim();

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
		
			Menu typeSelect = new Menu("Select a Type", options);

			choice = typeSelect.getUserChoice();

			switch (choice) {
			
			case 1:
				
				type =  BookType.FICTION;

			case 2:
				
				type = BookType.NON_FICTION;

			case 3:
				
				type = BookType.REFERENCE;

			default:
			
				type = null;

			}

	} while (!isValidType(choice));

	return type;
	
	}
	
	//The following few methods are used to check if the users input passes the proper criteria.

	public static boolean isValidType(int choice) {

		if (choice < 1 || choice > 3) {

			System.out.println("Type must be between 1-3, try again.");

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

			System.out.println(qubLibrary.list(BookStatus.AVAILABLE)[i]);

		}

		System.out.println("Enter the id of the book you want to remove.");

		int choice = input.nextInt() - 1;

		input.nextLine();

		qubLibrary.list(BookStatus.AVAILABLE)[choice].setStatus(BookStatus.WITHDRAW);

		System.out.println("succesfully removed");

	}

}
