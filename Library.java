package part01;

import java.util.ArrayList;

public class Library implements iLibrary {

	private ArrayList<LibraryBook> books;
	
	/**
	 * 
	 * Constructor to create the library object.
	 * Creates the books arraylist.
	 * 
	 */

	public Library() {

		this.books = new ArrayList<LibraryBook>();

	}
	
	/**
	 * 
	 * Method that borrows a book. 
	 * Return true if book has been borrowed, false if not.
	 * 
	 */
	
	public boolean borrowBook(int id) {

		if (search(id).checkout() == true) {

			return true;

		} else {

			return false;

		}

	}
	
	/**
	 * 
	 * Method that returns a book. 
	 * Return true if book has been returned, false if not.
	 * 
	 */

	public boolean returnBook(int id) {

		if (search(id).checkIn() == true) {

			return true;

		} else {

			return false;

		}

	}
	
	/**
	 * 
	 * Method that returns a list of all current books in the arraylist.
	 * Contains a for loop that iterates through the arraylist and fills the array.
	 * 
	 */

	public LibraryBook[] list() {

		LibraryBook[] list = new LibraryBook[books.size()];

		for (int i = 0; i < books.size(); i++) {

			list[i] = books.get(i);

		}

		return list;

	}

	/**
	 * 
	 * Method that returns a list current books in the arraylist that matches the status parameter.
	 * Contains a for loop that iterates through the arraylist and fills the array.
	 * 
	 */
	
	public LibraryBook[] list(BookStatus stat) {

		int countOfStat = 0;

		for (int i = 0; i < books.size(); i++) {

			if (books.get(i).getStatus() == stat) {

				countOfStat++;

			}

		}

		LibraryBook[] list = new LibraryBook[countOfStat];

		int j = 0;

		for (int i = 0; i < books.size(); i++) {

			if (books.get(i).getStatus() == stat) {

				list[j] = books.get(i);

				j++;

			}

		}

		return list;

	}
	
	/**
	 * 
	 * Method that returns a list of all current books in the arraylist ranked by how many times they have been borrowed.
	 * Creates a copy of the arraylist of books and send it through a bubble sort based on getLoanCount().
	 * 
	 */

	public LibraryBook[] mostPopular() {

		LibraryBook[] list = new LibraryBook[books.size()];

		@SuppressWarnings("unchecked")
		ArrayList<LibraryBook> copy = (ArrayList<LibraryBook>) books.clone();

		int swaps;

		do {

			swaps = 0;

			for (int i = 0; i < (copy.size() - 1); i++) {

				int j = i + 1;

				if (copy.get(i).getLoanCount() < copy.get(j).getLoanCount()) {

					LibraryBook temp = copy.get(i);

					copy.set(i, copy.get(j));

					copy.set((j), temp);

					swaps++;

				}

			}

		} while (swaps > 0);

		for (int i = 0; i < copy.size(); i++) {

			list[i] = copy.get(i);

		}

		return list;

	}
	
	/**
	 * 
	 * Method that takes in an int parameter and returns the corresponding book.
	 * 
	 */

	public LibraryBook search(int id) {

		if (books.get(id) != null) {

			return books.get(id);

		} else {

			System.out.println("Cannot find a book with that id.");

			return null;

		}

	}
	
	/**
	 * 
	 * Method to add a libraryBook to the arraylist. 
	 * Checks the libraryBook for multiple criteria before adding to the arraylist.
	 * If the book fails any of the criteria it will print out a message notifying the user why it has failed.
	 * 
	 */

	public boolean add(LibraryBook bk) {

		if (bk.getImage() != null) {

			if ((bk.getBook().getTitle().length() >= 10) && (bk.getBook().getTitle().length() <= 100)) {

				if ((bk.getBook().getAuthor().length() >= 10) && (bk.getBook().getAuthor().length() <= 100)) {

					if ((bk.getBook().getIsbn().length() == 10) && (isNumber(bk.getBook().getIsbn())) == true) {

						if (bk.getBook().getEdition() >= 1) {

							if ((bk.getBook().getSummary().length() >= 20)
									&& (bk.getBook().getSummary().length() <= 150)) {

								if (bk.getBook().getPrice() > 0.00) {

									this.books.add(bk);

									return true;

								} else if (bk.getBook().getPrice() <= 0.00) {
									
									System.out.println("Price must be greater than 0.00.");

								}
								
							} else if ((bk.getBook().getSummary().length() < 20)
									|| (bk.getBook().getSummary().length() > 150)) {
								
								System.out.println("Summary must be between 20 and 150 characters.");

							}

						} else if (bk.getBook().getEdition() < 1) {
							
							System.out.println("Edition must be atleast 1.");

						}

					} else if (bk.getBook().getIsbn().length() != 10) {
						
						System.out.println("ISBN must be exactly 10 characters.");

					}

				} else if ((bk.getBook().getAuthor().length() < 10) || (bk.getBook().getAuthor().length() > 100)) {
					
					System.out.println("Author must be between 10 and 100 characters.");

				}

			} else if ((bk.getBook().getTitle().length() < 10) || (bk.getBook().getTitle().length() > 100)) {
				
				System.out.println("Title must be between 10 and 100 characters.");

			}

		} else if (bk.getImage() == null) {
			
			System.out.println("Image must not be null.");

		}

		return false;

	}
	
	/**
	 * 
	 * Method to check if the parameter string (isbn) contains only digits.
	 * Returns true if it does and false if not.
	 * 
	 * @param string
	 * @return
	 */
	
	private static boolean isNumber(String string) {

		int count = 0;

		for (int i = 0; i < string.length(); i++) {

			if (Character.isDigit(string.charAt(i))) {

				count++;

			}

		}

		if (count == 10) {

			return true;
			
		} else {
			
			return false;
			
		}

	}

}
