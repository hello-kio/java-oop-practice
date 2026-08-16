import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Add Member");
            System.out.println("4. Display Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Display Issued Books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    Book book = new Book(bookId, title, author);

                    library.addBook(book);

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();

                    sc.nextLine();

                    System.out.print("Enter Member Adhaar Number: ");
                    int adhaarNumber = sc.nextLine();

                    sc.nextLine();

                    System.out.print("Enter Member Phone number: ");
                    int phoneNumber = sc.nextLine();

                    sc.nextLine();

                    ystem.out.print("Enter Member Address : ");
                    String memberAddress = sc.nextLine();

                    Member member =
                        new Member(memberId, name);

                    library.addMember(member);

                    break;

                case 4:

                    library.displayMembers();

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int issueMemberId = sc.nextInt();

                    library.issueBook(
                        issueBookId,
                        issueMemberId
                    );

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    library.returnBook(returnBookId);

                    break;

                case 7:

                    library.displayIssuedBooks();

                    break;

                case 8:

                    System.out.println(
                        "Thank you for using the Library Management System."
                    );

                    sc.close();

                    return;

                default:

                    System.out.println(
                        "Invalid choice."
                    );
            }
        }
    }
}