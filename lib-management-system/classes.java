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

}