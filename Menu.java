package part01;

import java.util.Scanner;

public class Menu {

	private String items[];

	private String title;

	private Scanner input;

	public Menu(String title, String data[]) {

		this.title = title;

		this.items = data;

		this.input = new Scanner(System.in);

	}

	public int getUserChoice() {

		display();

		int value = 0;

		do {

			System.out.print("Enter Selection: ");

			try {

				value = input.nextInt();

				if ((value < 1 || value > 8)) {

					System.out.println("Invalid Response ");

				}

			} catch (Exception e) {

				input.next();
				
				System.out.println("Invalid Response ");

			}

		} while (value < 1 || value > 8);

		return value;

	}

	private void display() {

		System.out.println(title);

		for (int i = 0; i < title.length(); i++) {

			System.out.print("+");

		}

		System.out.println();

		for (int opt = 1; opt <= items.length; opt++) {

			System.out.println(opt + ". " + items[opt - 1]);

		}

		System.out.println();

	}

}