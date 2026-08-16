class Book{
    private int bookId;
    private String name;
    private String author;
    private boolean available;
}

// this is encapsulation : we don't want anyone to modify this code 

class Book {

    private int bookId;
    private String name;
    private String author;
    private boolean available;

    public Book(int bookId, String name, String author) { // this constructor 
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.available = true;//default 
    }

    //because every element is private in this class that is why we can't directly access that 
    //and we have to make a meathod to do so ;
    public int getBookId() {
        return bookId;
    }

    public String getname() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void displayBook() {
        System.out.println(
            "ID: " + bookId + " | name: " + name +" | Author: " + author +" | Available: " + available );
    }
}

// Book b1 = new Book(101, "abc", "hooman");


//member class of library ;

class Member{

    private String name ;
    private int memberId ;
    private String memberAddress ;
    private int adhaarNumber ;
    private int phoneNumber ;

    public Member(String name,int memberId , int adhaarNumber, int memberAddress,String phoneNumber){
        this.name = name ; 
        this.memberId = memberId;
        this.adhaarNumber = adhaarNumber;
        this.memberAddress = memberAddress ;
        this.phoneNumber = phoneNumber ;
    } 

        public String getName() {
            return name;
        }

public void setName(String name) {
    this.name = name;
}

public int getMemberId() {
    return memberId;
}

public void setMemberId(int memberId) {
    this.memberId = memberId;
}

public int getAdhaarNumber() {
    return adhaarNumber;
}

public void setAdhaarNumber(int adhaarNumber) {
    this.adhaarNumber = adhaarNumber;
}

public int getMemberAddress() {
    return memberAddress;
}

public void setMemberAddress(int memberAddress) {
    this.memberAddress = memberAddress;
}

public String getPhoneNumber() {
    return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}

public void displayMember() {
    System.out.println("Name: " + name +" | Member ID: " + memberId +" | Aadhaar Number: " + adhaarNumber +" | Address: " + memberAddress +" | Phone Number: " + phoneNumber );
}

}



class Library {

    private ArrayList<Book> books_collection;
    private ArrayList<Member> members;
    private ArrayList<IssueRecord> records;

    //  BOOK MEATHODS ----------------------------------
    public void addBook(Book book){
        books_collection.add(book);
        System.out.println("Book added successfully! 👍");
    }

    public void displayBooks() {

    if (books_collection.isEmpty()) {
        System.out.println("No books available.");
        return;
    }

    for (Book book : books_collection) {
        book.displayBook();
    }
    }

    public Book findBook(int bookId) {

    for (Book book : books_collection) {

            if (book.getBookId() == bookId) {
                return ;
            }
        }

        return null;
    }
        //if we find the book then return the book object otherwise nope ;


    //  MEMBER meathods  ----------------------------------
    public void addMember(Member member) {

    members.add(member);

    System.out.println("Member registered successfully.");
}

public void displayMembers() {

    if (members.isEmpty()) {
        System.out.println("No members registered.");
        return;
    }

    for (Member member : members) {
        member.displayMember();
    }
}
    public void issueBook(int bookId, int memberId) {

    Book book = findBook(bookId);

    if (book == null) {
        System.out.println("Book not found.");
        return;
    }

    if (!book.isAvailable()) {
        System.out.println("Book is already issued.");
        return;
    }

    Member member = findMember(memberId);

    if (member == null) {
        System.out.println("Member not found.");
        return;
    }

    book.setAvailable(false);

    System.out.println(
        "Book issued to " + member.getName()
    );
}


public void issueBook(int bookId, int memberId) {

    Book book = findBook(bookId);

    if (book == null) {
        System.out.println("Book not found.");
        return;
    }

    if (!book.isAvailable()) {
        System.out.println("Book is already issued.");
        return;
    }

    Member member = findMember(memberId);

    if (member == null) {
        System.out.println("Member not found.");
        return;
    }

    book.setAvailable(false);

    System.out.println(
        "Book issued to " + member.getName()
    );
}

public Member findMember(int memberId) {

    for (Member member : members) {

        if (member.getMemberId() == memberId) {
            return member;
        }
    }

    return null;
}
        //  ISSUE BOOK ----------------------------------

    public void issueBook(int bookId, int memberId) {

        Book book = findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        Member member = findMember(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already issued.");
            return;
        }

        book.setAvailable(false);

        IssueRecord record =
            new IssueRecord(book, member);

        records.add(record);

        System.out.println(
            "Book issued successfully to "
            + member.getName()
        );
    }

    public void returnBook(int bookId) {

        Book book = findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        for (IssueRecord record : records) {

            if (record.getBook().getBookId() == bookId && !record.isReturned() ) {

                record.returnBook();

                book.setAvailable(true);

                System.out.println("Book returned successfully.");

                return;
            }
        }

        System.out.println("This book is not issued.");
    }

    public void displayIssuedBooks() {

        boolean found = false;

        for (IssueRecord record : records) {

            if (!record.isReturned()) {

                found = true;

                System.out.println( "Book: " + record.getBook().getTitle()+ " | Borrowed by: "+ record.getMember().getName()+ " | Issue Date: "+ record.getIssueDate()  );
            }
        }

        if (!found) {
            System.out.println("No books are currently issued.");
        }
    }


}



class IssueRecord {

    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate returnDate;


    public IssueRecord(Book book, Member member) {

        this.book = book;
        this.member = member;
        this.issueDate = LocalDate.now();
        this.returnDate = null;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void returnBook() {
        returnDate = LocalDate.now();
    }

    public boolean isReturned() {
        return returnDate != null;
    }

}





