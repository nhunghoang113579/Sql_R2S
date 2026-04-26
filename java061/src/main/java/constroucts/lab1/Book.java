package constroucts.lab1;

public class Book {
        String title;
        String author;
        int publication;

        public Book(String title, String author, int publication) {
            this.title = title;
            this.author = author;
            this.publication = publication;
        }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publication=" + publication +
                '}';
    }
}


