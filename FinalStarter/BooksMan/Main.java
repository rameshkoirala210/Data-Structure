import java.util.HashMap;
import java.util.ArrayList;
class Book{
  String title, ISBN;
  ArrayList<String> authors;

  public Book (String title, String ISBN, String authors){
    this.title = title;
    this.ISBN = ISBN;
    this.authors = new ArrayList<String>();
    if (authors != null) {
      String [] authorArray = authors.split(", ");
      for (int i = 0; i < authorArray.length; i++) {
        this.authors.add(authorArray[i]);
      }
    }
  }
  public String getISBN() {
    return ISBN;
  }

  public String getTitle() {
    return title;
  }

  public ArrayList<String> getAuthors() {
    return authors;
  }
}

public class Main {
  public static HashMap<String, Book> buildMap(Book[] s) {
    HashMap<String, Book> books = new HashMap<String, Book>();

    if (s != null) {
	 // TODO Write the statements here: to manage each book from the parameter array reference to the hashmap
      for (int i = 0; i < s.length; i++){
        books.put(s[i].getTitle(), s[i]);
      }
    }
    return books;
  }

  public static void main(String argv[]) {
    Book[] bookArray = new Book[4];
    for (int i = 0; i < 4; i++) {
      bookArray[i] = new Book((new Integer(i)).toString(), (new Integer(i)).toString(), "ITSC2214" );
    }

    HashMap<String, Book> books = Main.buildMap(bookArray);
    System.out.println("The total number of books is " + books.size());
    for (int i = 0; i < 4; i++) {
      System.out.println("Book[" + i + "] is " + books.get((new Integer(i)).toString()).getTitle());
    }
  }
}