package part03;

public class consoleMenu {
	
	private String items[];
	
	private String title;

	public consoleMenu(String title, String data[]) {	 
		
		this.title = title;
		
		this.items = data;
			
	}

	public int getUserChoice() {
		
		display();
		
		int value = 0;
		
		do {
		
			QUBLibraryUpdated.con.println("Enter Selection: ");
		
		try {
			
		String valueString = QUBLibraryUpdated.con.readLn();
		
		value = Integer.parseInt(valueString);
		

		if((value < 1 || value > 8)) {
		
			QUBLibraryUpdated.con.println("Invalid Response ");
		
		}
		
		} catch (Exception e) {
	         
	           System.out.println("Invalid Response ");
	           
	        }
		
		
		}while(value < 1 || value > 8);
		
		return value;
		
	}

	private void display() {
		
		QUBLibraryUpdated.con.println(title);
		
		for (int i = 0; i < title.length(); i++) {
			
			QUBLibraryUpdated.con.print("+");
			
		}
		
		QUBLibraryUpdated.con.println();
		
		for (int opt = 1; opt <= items.length; opt++) {
			
			QUBLibraryUpdated.con.println(opt + ". " + items[opt - 1]);
			
		}
		
		QUBLibraryUpdated.con.println();
		
	}
	
}
