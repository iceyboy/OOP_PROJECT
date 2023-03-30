package part03;

import java.util.ArrayList;

import part01.BookStatus;

public class LibraryUpdated {

	private ArrayList<LibraryBookUpdated> books;

	public LibraryUpdated() {

		this.books = new ArrayList<LibraryBookUpdated>();

	}

	public boolean borrowBook(int id) {

		if (search(id).checkout() == true) {

			return true;

		} else {

			return false;

		}

	}

	public boolean returnBook(int id) {

		if (search(id).checkIn() == true) {

			return true;

		} else {

			return false;

		}

	}

	public LibraryBookUpdated[] list() {

		LibraryBookUpdated[] list = new LibraryBookUpdated[books.size()];

		for (int i = 0; i < books.size(); i++) {

			list[i] = books.get(i);

		}

		return list;

	}

	public LibraryBookUpdated[] list(BookStatus stat) {

		int countOfStat = 0;

		for (int i = 0; i < books.size(); i++) {

			if (books.get(i).getStatus() == stat) {

				countOfStat++;

			}

		}

		LibraryBookUpdated[] list = new LibraryBookUpdated[countOfStat];

		int j = 0;

		for (int i = 0; i < books.size(); i++) {

			if (books.get(i).getStatus() == stat) {

				list[j] = books.get(i);

				j++;

			}

		}

		return list;

	}

	public LibraryBookUpdated[] mostPopular() {

		LibraryBookUpdated[] list = new LibraryBookUpdated[books.size()];

		@SuppressWarnings("unchecked")
		ArrayList<LibraryBookUpdated> copy = (ArrayList<LibraryBookUpdated>) books.clone();

		int swaps;

		do {

			swaps = 0;

			for (int i = 0; i < (copy.size() - 1); i++) {

				int j = i + 1;

				if (copy.get(i).getLoanCount() < copy.get(j).getLoanCount()) {

					LibraryBookUpdated temp = copy.get(i);

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

	public LibraryBookUpdated search(int id) {

		if (books.get(id) != null) {

			return books.get(id);

		} else {

			QUBLibraryUpdated.con.println("Cannot find a book with that id.");

			return null;

		}

	}

	public boolean add(LibraryBookUpdated bk) {

		if (bk.getImage() != null) {

			if ((bk.getBook().getTitle().length() >= 10) && (bk.getBook().getTitle().length() <= 100)) {

				if ((bk.getBook().getAuthor().length() >= 10) && (bk.getBook().getAuthor().length() <= 100)) {

					if (bk.getBook().getIsbn().length() == 10) {

						if (bk.getBook().getEdition() >= 1) {

							if ((bk.getBook().getSummary().length() >= 20)
									&& (bk.getBook().getSummary().length() <= 150)) {

								if (bk.getBook().getPrice() > 0.00) {

									this.books.add(bk);

									return true;

								} else if (bk.getBook().getPrice() <= 0.00) {
									
									QUBLibraryUpdated.con.println("Price must be greater than 0.00.");

								}
								
							} else if ((bk.getBook().getSummary().length() < 20)
									|| (bk.getBook().getSummary().length() > 150)) {
								
								QUBLibraryUpdated.con.println("Summary must be between 20 and 150 characters.");

							}

						} else if (bk.getBook().getEdition() < 1) {
							
							QUBLibraryUpdated.con.println("Edition must be atleast 1.");

						}

					} else if (bk.getBook().getIsbn().length() != 10) {
						
						QUBLibraryUpdated.con.println("ISBN must be exactly 10 characters.");

					}

				} else if ((bk.getBook().getAuthor().length() < 10) || (bk.getBook().getAuthor().length() > 100)) {
					
					QUBLibraryUpdated.con.println("Author must be between 10 and 100 characters.");

				}

			} else if ((bk.getBook().getTitle().length() < 10) || (bk.getBook().getTitle().length() > 100)) {
				
				QUBLibraryUpdated.con.println("Title must be between 10 and 100 characters.");

			}

		} else if (bk.getImage() == null) {
			
			QUBLibraryUpdated.con.println("Image must not be null.");

		}

		return false;

	}

}
