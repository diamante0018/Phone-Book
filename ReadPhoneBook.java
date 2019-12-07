import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.HashMap;

public class ReadPhoneBook {
    private HashMap<String, Long> phoneBook;

    public ReadPhoneBook(int BookSize) {
        phoneBook = new HashMap<String, Long>(BookSize);
    }

    public void read(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            phoneBook = (HashMap<String,Long>) in.readObject();
            in.close();
            fileIn.close();
         } 
         catch (IOException i) {
            i.printStackTrace();
            return;
         } 
         catch (ClassNotFoundException c) {
            System.out.println("PhoneBook class not found");
            c.printStackTrace();
            return;
       }
    }

    public void describe() {
		System.out.println("The phone book has " + phoneBook.size() + " numbers saved");
		
		for (Entry<String, Long> entry : phoneBook.entrySet()) {
		    System.out.println("The name is: " + entry.getKey() + " with the number: " + entry.getValue());
		}
	}

    public static void main(String [] args) {
        if (args.length<1) {
			System.out.println("Insufficient amount of arguments");
			System.exit(0);
        }
        
        ReadPhoneBook read = new ReadPhoneBook(Integer.parseInt(args[0]));
        read.read("phonebook.ser");
        read.describe();
    }
}