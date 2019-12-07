import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.*;

public class PhoneBook {

	private HashMap<String, Long> phoneBook;
	
	public PhoneBook(int BookSize) {
		phoneBook = new HashMap<String,Long>(BookSize);
	}
	
	public void describe() {
		System.out.println("The phone book has " + phoneBook.size() + " numbers saved");
		
		for (Entry<String, Long> entry : phoneBook.entrySet()) {
		    System.out.println("The name is: " + entry.getKey() + " with the number: " + entry.getValue());
		}
	}
	
	public void add (String name, Long number) {
		phoneBook.put(name, number);
	}

	public void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream("phonebook.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(phoneBook);
			out.close();
			fileOut.close();
		 } 
		 catch (IOException e) {
			e.printStackTrace();
		 }
	}
	
	public static void main(String[] args) {
		if (args.length<1) {
			System.out.println("Insufficient amount of arguments");
			System.exit(0);
		}
		
		PhoneBook book = new PhoneBook(Integer.parseInt(args[0]));
		Scanner input = new Scanner(System.in);
		String name;
		Long number;
		
		for (int i=0; i<Integer.parseInt(args[0]);i++) {
			System.out.println("Enter the name: ");
			name = input.nextLine();
			
			System.out.println("Enter the number: ");
			number = input.nextLong();
			input.nextLine();
			book.add(name,number);
		}
		
		input.close();
		book.describe();
		book.save();
	}

}
