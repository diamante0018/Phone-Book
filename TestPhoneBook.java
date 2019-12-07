import java.util.*;

public class TestPhoneBook {
    public static void main(String[] args) {
        if (args.length<3) {
            System.out.println("Insufficient amount of arguments");
        }

        if (args[0].equals("create")) {
            if (Integer.parseInt(args[2]) < 1) {
                System.out.println("size is too small");
                System.exit(0);
            }
            else {
                PhoneBook book = new PhoneBook(Integer.parseInt(args[2]));
                Scanner input = new Scanner(System.in);
                String name;
		        Long number;

                for (int i=0; i<Integer.parseInt(args[2]);i++) {
                    System.out.println("Enter the name: ");
                    name = input.nextLine();
                    
                    System.out.println("Enter the number: ");
                    number = input.nextLong();
                    input.nextLine();
                    book.add(name,number);
                }
                
                input.close();
                book.describe();
                book.save(args[1]);
            }
        }

        if (args[0].equals("read")) {
            if (Integer.parseInt(args[2]) < 1) {
                System.out.println("size is too small");
                System.exit(0);
            }
            else {
                ReadPhoneBook file = new ReadPhoneBook(Integer.parseInt(args[2]));
                file.read(args[1]);
                file.describe();
            }
        }
    }
}