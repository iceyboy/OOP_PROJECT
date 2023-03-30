package part02;

import part01.*;

public class libraryTesting {

	public static void main(String[] args) {

		initialize();
		testCase1();
		testCase2();
		testCase3();
		testCase4();
		testCase5();
		testCase6();
		testCase7();
		testCase8();
		testCase9();
		testCase10();
		testCase11();
		testCase12();
		testCase13();
		testCase14();
		testCase15();
		testCase16();
		testCase17();
		testCase18();
		testCase19();
		testCase20();
		testCase21();
		testCase22();
		testCase23();
		testCase24();
		testCase25();

	}

	private static Library library = new Library();

	// Method to add books to the library for testing purposes.

	private static void initialize() {

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

		library.add(book1);

		library.add(book2);

		library.add(book3);

		library.add(book4);

		library.add(book5);

	}
	
	//Method to print out the different objects in an array.

	private static void printArray(LibraryBook[] array) {

		for (int i = 0; i < array.length; i++) {

			System.out.println(array[i]);

		}

	}

	public static void testCase1() {

		System.out.println("TC1 - Testing borrowBook with valid data" + "\n");

		System.out.println("+++++++++++++++++Start TC1+++++++++++++++++++" + "\n");

		try {

			System.out.println("Running borrowBook" + "\n");

			System.out.println("\n" + "Borrow book output: " + library.borrowBook(0) + "\n");

		} catch (Exception e) {

			System.out.println("Exception - borrow failed." + "\n");

		}

		System.out.println("List of borrowed books below:" + "\n");

		printArray(library.list(BookStatus.ON_LOAN));

		System.out.println("\n" + "+++++++++++++++++++End TC1++++++++++++++++++++\n" + "\n");

	}

	public static void testCase2() {

		System.out.println("TC2 - Testing borrowBook with invalid data" + "\n");

		System.out.println("+++++++++++++++++Start TC1+++++++++++++++++++" + "\n");

		try {

			System.out.println("Running borrowBook" + "\n");

			System.out.println("Borrow book output: " + library.borrowBook(-1) + "\n");

		} catch (Exception e) {

			System.out.println("Exception - borrow failed." + "\n");

		}

		System.out.println("List of borrowed books below:" + "\n");

		printArray(library.list(BookStatus.ON_LOAN));

		System.out.println("\n" + "+++++++++++++++++++End TC2++++++++++++++++++++\n" + "\n");

	}

	public static void testCase3() {

		System.out.println("TC3 - Testing returnBook with valid data" + "\n");

		System.out.println("+++++++++++++++++Start TC3+++++++++++++++++++" + "\n");

		try {

			System.out.println("Running returnBook" + "\n");

			System.out.println("\n" + "Return book output: " + library.returnBook(0) + "\n");

		} catch (Exception e) {

			System.out.println("Exception - return failed." + "\n");

		}

		System.out.println("List of borrowed books below:" + "\n");

		printArray(library.list(BookStatus.ON_LOAN));

		System.out.println("\n" + "+++++++++++++++++++End TC3++++++++++++++++++++\n" + "\n");

	}

	public static void testCase4() {

		System.out.println("TC4 - Testing returnBook with invalid data" + "\n");

		System.out.println("+++++++++++++++++Start TC4+++++++++++++++++++" + "\n");

		try {

			System.out.println("Running returnBook" + "\n");

			System.out.println("\n" + "Return book output: " + library.returnBook(-1) + "\n");

		} catch (Exception e) {

			System.out.println("Exception - return failed." + "\n");

		}

		System.out.println("List of borrowed books below:" + "\n");

		printArray(library.list(BookStatus.ON_LOAN));

		System.out.println("\n" + "+++++++++++++++++++End TC4++++++++++++++++++++\n" + "\n");

	}

	public static void testCase5() {

		System.out.println("TC5 - Testing list with valid data" + "\n");

		System.out.println("+++++++++++++++++Start TC5+++++++++++++++++++" + "\n");

		try {

			System.out.println("Running list" + "\n");

			System.out.println("List output: " + "\n");

			printArray(library.list());

		} catch (Exception e) {

			System.out.println("Exception - list failed." + "\n");

		}

		System.out.println("\n" + "+++++++++++++++++++End TC5++++++++++++++++++++\n" + "\n");

	}

	public static void testCase6() {

		System.out.println("TC6 - Testing list with empty list" + "\n");

		System.out.println("+++++++++++++++++Start TC6+++++++++++++++++++" + "\n");

		Library emptyListLibrary = new Library();

		try {

			System.out.println("Running list" + "\n");

			System.out.println("List output: " + "\n");

			printArray(emptyListLibrary.list());

		} catch (Exception e) {

			System.out.println("Exception - list failed." + "\n");

		}

		System.out.println("\n" + "+++++++++++++++++++End TC6++++++++++++++++++++\n" + "\n");

	}

	public static void testCase7() {

		System.out.println("TC7 - Testing list(Status) with valid data for available books" + "\n");

		System.out.println("+++++++++++++++++Start TC7+++++++++++++++++++" + "\n");

		try {

			System.out.println("Running list" + "\n");

			System.out.println("\n" + "List output: " + "\n");

			printArray(library.list(BookStatus.AVAILABLE));

		} catch (Exception e) {

			System.out.println("Exception - list failed." + "\n");

		}

		System.out.println("\n" + "+++++++++++++++++++End TC7++++++++++++++++++++\n" + "\n");

	}

	public static void testCase8() {

		System.out.println("TC8 - Testing list(Status) with valid data for on loan books" + "\n");

		System.out.println("+++++++++++++++++Start TC8+++++++++++++++++++" + "\n");

		library.borrowBook(0);
		
		library.borrowBook(1);

		try {

			System.out.println("Running list" + "\n");

			System.out.println("\n" + "List output: " + "\n");

			printArray(library.list(BookStatus.ON_LOAN));

		} catch (Exception e) {

			System.out.println("Exception - list failed." + "\n");

		}

		library.returnBook(0);
		
		library.returnBook(1);

		System.out.println("\n" + "+++++++++++++++++++End TC8++++++++++++++++++++\n" + "\n");

	}

	public static void testCase9() {

		System.out.println("TC9 - Testing list(Status) with valid data for withdrawn books" + "\n");

		System.out.println("+++++++++++++++++Start TC9+++++++++++++++++++" + "\n");

		library.list()[0].setStatus(BookStatus.WITHDRAW);

		try {

			System.out.println("Running list" + "\n");

			System.out.println("\n" + "List output: " + "\n");

			printArray(library.list(BookStatus.WITHDRAW));

		} catch (Exception e) {

			System.out.println("Exception - list failed." + "\n");

		}

		library.list()[0].setStatus(BookStatus.AVAILABLE);

		System.out.println("\n" + "+++++++++++++++++++End TC9++++++++++++++++++++\n" + "\n");

	}

	public static void testCase10() {

		System.out.println("TC10 - Testing list(Status) with no books available" + "\n");

		System.out.println("+++++++++++++++++Start TC10+++++++++++++++++++" + "\n");

		library.borrowBook(0);
		
		library.borrowBook(1);
		
		library.borrowBook(2);
		
		library.borrowBook(3);
		
		library.borrowBook(4);

		try {

			System.out.println("\n" + "Running list" + "\n");

			System.out.println("\n" + "List output: " + "\n");

			printArray(library.list(BookStatus.AVAILABLE));

		} catch (Exception e) {

			System.out.println("Exception - list failed." + "\n");

		}

		library.returnBook(0);
		
		library.returnBook(1);
		
		library.returnBook(2);
		
		library.returnBook(3);
		
		library.returnBook(4);

		System.out.println("\n" + "+++++++++++++++++++End TC10++++++++++++++++++++\n" + "\n");

	}

	public static void testCase11() {

		System.out.println("TC11 - Testing list(Status) with no books on loan" + "\n");

		System.out.println("+++++++++++++++++Start TC11+++++++++++++++++++" + "\n");

		try {

			System.out.println("Running list" + "\n");

			System.out.println("\n" + "List output: " + "\n");

			printArray(library.list(BookStatus.ON_LOAN));

		} catch (Exception e) {

			System.out.println("Exception - list failed." + "\n");

		}

		System.out.println("\n" + "+++++++++++++++++++End TC11++++++++++++++++++++\n" + "\n");

	}

	public static void testCase12() {

		System.out.println("TC12 - Testing list(Status) with no books withdrawn" + "\n");

		System.out.println("+++++++++++++++++Start TC12+++++++++++++++++++" + "\n");

		try {

			System.out.println("Running list" + "\n");

			System.out.println("\n" + "List output: " + "\n");

			printArray(library.list(BookStatus.WITHDRAW));

		} catch (Exception e) {

			System.out.println("Exception - list failed." + "\n");

		}

		System.out.println("\n" + "+++++++++++++++++++End TC12++++++++++++++++++++\n" + "\n");

	}

	public static void testCase13() {

		System.out.println("TC13 - Testing mostPopular with valid data" + "\n");

		System.out.println("+++++++++++++++++Start TC13+++++++++++++++++++" + "\n");

		library.borrowBook(2);
		
		library.returnBook(2);
		
		library.borrowBook(2);
		
		library.returnBook(2);
	
		library.borrowBook(2);
		
		library.returnBook(2);
		
		library.borrowBook(2);
		
		library.returnBook(2);

		try {

			System.out.println("\n" + "Running mostPopular" + "\n");

			System.out.println("\n" + "mostPopular output: " + "\n");

			printArray(library.mostPopular());

		} catch (Exception e) {

			System.out.println("Exception - mostPopular failed." + "\n");

		}

		System.out.println("\n" + "+++++++++++++++++++End TC13++++++++++++++++++++\n" + "\n");

	}

	public static void testCase14() {

		System.out.println("TC14 - Testing mostPopular with no books" + "\n");

		System.out.println("+++++++++++++++++Start TC14+++++++++++++++++++" + "\n");

		Library emptyPopularLibrary = new Library();

		try {

			System.out.println("\n" + "Running mostPopular" + "\n");

			System.out.println("\n" + "mostPopular output: " + "\n");

			printArray(emptyPopularLibrary.mostPopular());

		} catch (Exception e) {

			System.out.println("Exception - mostPopular failed." + "\n");

		}

		System.out.println("\n" + "+++++++++++++++++++End TC14++++++++++++++++++++\n" + "\n");

	}

	public static void testCase15() {

		System.out.println("TC15 - Testing search with valid data" + "\n");

		System.out.println("+++++++++++++++++Start TC15+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running search" + "\n");

			System.out.println("\n" + "search output: " + "\n");

			System.out.println(library.search(0));

		} catch (Exception e) {

			System.out.println("Exception - search failed." + "\n");

		}

		System.out.println("\n" + "+++++++++++++++++++End TC15++++++++++++++++++++\n" + "\n");

	}

	public static void testCase16() {

		System.out.println("TC16 - Testing search with invalid data" + "\n");

		System.out.println("+++++++++++++++++Start TC16+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running search" + "\n");

			System.out.println("\n" + "search output: " + "\n");

			System.out.println(library.search(-1));

		} catch (Exception e) {

			System.out.println("Exception - search failed." + "\n");

		}

		System.out.println("\n" + "+++++++++++++++++++End TC16++++++++++++++++++++\n" + "\n");

	}

	public static void testCase17() {

		System.out.println("TC17 - Testing add with valid data" + "\n");

		System.out.println("+++++++++++++++++Start TC17+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running add" + "\n");

			LibraryBook book = new LibraryBook("Charlotte's Web", "E.B Whiteeeee", "1234567899", BookType.FICTION, 2, "The novel tells the story of a livestock pig named Wilbur and his friendship with a barn spider named Charlotte.",10);

			book.setImageIcon("Images/b7.jpg");

			library.add(book);

			System.out.println("List output: ");

		} catch (Exception e) {

			System.out.println("Exception - add failed." + "\n");

		}

		printArray(library.list());

		System.out.println("\n" + "+++++++++++++++++++End TC17++++++++++++++++++++\n" + "\n");

	}

	public static void testCase18() {

		System.out.println("TC18 - Testing add with null data" + "\n");

		System.out.println("+++++++++++++++++Start TC18+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running add" + "\n");

			LibraryBook book = new LibraryBook(null, null, null, null, 0, null, 0);

			book.setImageIcon("Images/b7.jpg");

			library.add(book);

			System.out.println("List output: ");

		} catch (Exception e) {

			System.out.println("Exception - add failed." + "\n");

		}

		printArray(library.list());

		System.out.println("\n" + "+++++++++++++++++++End TC18++++++++++++++++++++\n" + "\n");

	}

	public static void testCase19() {

		System.out.println("TC19 - Testing add with invalid title" + "\n");

		System.out.println("+++++++++++++++++Start TC19+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running add" + "\n");

			LibraryBook book = new LibraryBook("a", "E.B Whiteeeee", "1234567899", BookType.FICTION, 2,
					"The novel tells the story of a livestock pig named Wilbur and his friendship with a barn spider named Charlotte.",
					10);

			book.setImageIcon("Images/b7.jpg");

			library.add(book);

			System.out.println("\n" + "List output: ");

		} catch (Exception e) {

			System.out.println("Exception - add failed." + "\n");

		}

		printArray(library.list());

		System.out.println("\n" + "+++++++++++++++++++End TC19++++++++++++++++++++\n" + "\n");

	}

	public static void testCase20() {

		System.out.println("TC20 - Testing add with invalid author" + "\n");

		System.out.println("+++++++++++++++++Start TC20+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running add" + "\n");

			LibraryBook book = new LibraryBook("Charlotte's Web", "a", "1234567899", BookType.FICTION, 2,
					"The novel tells the story of a livestock pig named Wilbur and his friendship with a barn spider named Charlotte.",
					10);

			book.setImageIcon("Images/b7.jpg");

			library.add(book);

			System.out.println("\n" + "List output: ");

		} catch (Exception e) {

			System.out.println("Exception - add failed." + "\n");

		}

		printArray(library.list());

		System.out.println("\n" + "+++++++++++++++++++End TC20++++++++++++++++++++\n" + "\n");

	}

	public static void testCase21() {

		System.out.println("TC21 - Testing add with invalid isbn" + "\n");

		System.out.println("+++++++++++++++++Start TC21+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running add" + "\n");

			LibraryBook book = new LibraryBook("Charlotte's Web", "E.B Whiteeeee", "a", BookType.FICTION, 2,
					"The novel tells the story of a livestock pig named Wilbur and his friendship with a barn spider named Charlotte.",
					10);

			book.setImageIcon("Images/b7.jpg");

			library.add(book);

			System.out.println("\n" + "List output: ");

		} catch (Exception e) {

			System.out.println("Exception - add failed." + "\n");

		}

		printArray(library.list());

		System.out.println("\n" + "+++++++++++++++++++End TC21++++++++++++++++++++\n" + "\n");

	}

	public static void testCase22() {

		System.out.println("TC22 - Testing add with invalid edition" + "\n");

		System.out.println("+++++++++++++++++Start TC22+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running add" + "\n");

			LibraryBook book = new LibraryBook("Charlotte's Web", "E.B Whiteeeee", "1234567899", BookType.FICTION, -1,
					"The novel tells the story of a livestock pig named Wilbur and his friendship with a barn spider named Charlotte.",
					10);

			book.setImageIcon("Images/b7.jpg");

			library.add(book);

			System.out.println("\n" + "List output: ");

		} catch (Exception e) {

			System.out.println("Exception - add failed." + "\n");

		}

		printArray(library.list());

		System.out.println("\n" + "+++++++++++++++++++End TC22++++++++++++++++++++\n" + "\n");

	}

	public static void testCase23() {

		System.out.println("TC23 - Testing add with invalid summary" + "\n");

		System.out.println("+++++++++++++++++Start TC23+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running add" + "\n");

			LibraryBook book = new LibraryBook("Charlotte's Web", "E.B Whiteeeee", "1234567899", BookType.FICTION, 2,
					"a", 10);

			book.setImageIcon("Images/b7.jpg");

			library.add(book);

			System.out.println("\n" + "List output: ");

		} catch (Exception e) {

			System.out.println("Exception - add failed." + "\n");

		}

		printArray(library.list());

		System.out.println("\n" + "+++++++++++++++++++End TC23++++++++++++++++++++\n" + "\n");

	}

	public static void testCase24() {

		System.out.println("TC24 - Testing add with invalid price" + "\n");

		System.out.println("+++++++++++++++++Start TC24+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running add" + "\n");

			LibraryBook book = new LibraryBook("Charlotte's Web", "E.B Whiteeeee", "1234567899", BookType.FICTION, 2,
					"The novel tells the story of a livestock pig named Wilbur and his friendship with a barn spider named Charlotte.",
					-1);

			book.setImageIcon("Images/b7.jpg");

			library.add(book);

			System.out.println("\n" + "List output: ");

		} catch (Exception e) {

			System.out.println("Exception - add failed." + "\n");

		}

		printArray(library.list());

		System.out.println("\n" + "+++++++++++++++++++End TC24++++++++++++++++++++\n" + "\n");

	}

	public static void testCase25() {

		System.out.println("TC25 - Testing add with null image" + "\n");

		System.out.println("+++++++++++++++++Start TC25+++++++++++++++++++" + "\n");

		try {

			System.out.println("\n" + "Running add" + "\n");

			LibraryBook book = new LibraryBook("Charlotte's Web", "E.B Whiteeeee", "1234567899", BookType.FICTION, 2,
					"The novel tells the story of a livestock pig named Wilbur and his friendship with a barn spider named Charlotte.",
					10);

			book.setImageIcon(null);

			library.add(book);

			System.out.println("\n" + "List output: ");

		} catch (Exception e) {

			System.out.println("Exception - add failed." + "\n");

		}

		printArray(library.list());

		System.out.println("\n" + "+++++++++++++++++++End TC25++++++++++++++++++++\n" + "\n");

	}

}
