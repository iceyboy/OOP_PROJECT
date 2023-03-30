package part01;

public enum BookType {
	
	/**
	 * 
	 * Enumeration containing different possible types of the book.
	 * 
	 */
	
	FICTION("Stories from the imagination"),
	
	NON_FICTION("Factual, real-life experiences"),
	
	REFERENCE("Theories, Philosophies and common knowledge");
	
	private String spelling;
	
	private BookType(String str) {
		
		spelling = str;
		
	}
	
	/**
	 * 
	 * Method to return the description of the type.
	 * 
	 */
	
	public String toString() {
		
		return spelling;
		
	}

}

