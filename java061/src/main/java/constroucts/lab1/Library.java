package constroucts.lab1;

public class Library {
    void displayBook(Book book) {
        System.out.println("Title: " + book.title);
        System.out.println("Author: " + book.author);
        System.out.println("Year: " + book.publication);
        System.out.println("----------------------");

    }

    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("Java Basics", "John Doe", 2020);
        Book b2 = new Book("Python Guide", "Anna Smith", 2021);
        Book b3 = new Book("C Programming", "David Lee", 2019);


        library.displayBook(b1);
        library.displayBook(b2);
        library.displayBook(b3);
    }

}
