import java.util.*;

public class Cataloc {


    Map<String, Book> catalog;

    List<Book> list = new ArrayList<>();


    void addBook(Book book){
        catalog = new HashMap<>();
        catalog.put(book.getIsbn(), book);
        list.add(book);

    };
   public void removeBook(String isbn){
        boolean chck = false;
       for (int i=0; i<list.size(); i++) {
           if (list.get(i).getIsbn()==isbn){
               chck = true;
               list.remove(i);
               System.out.println("remove isbn : "+isbn);
           }
       }
        if (!chck){
            System.out.println("isbn not find");
        }
    }
    String getBook(String isbn){

        boolean chck = false;
        for (Book book: list) {
            if (book.getIsbn()==isbn){
                chck = true;
                System.out.println("Isbn "+book.getIsbn());
                System.out.println("Author "+book.getAuthor());
                System.out.println("Title "+book.getTitle());
                System.out.println("Aviable "+book.isAvailable());
            }
        }
        if (!chck){
            System.out.println("isbn not find");
        }
        return null;
    };
    List<Book> listBooks(){

        return list;
    };
    void checkOutBook(String isbn){

        boolean chck = false;
        for (Book book: list) {
            if (book.getIsbn()==isbn){
                chck = true;
              //  System.out.println("Aviable is: "+book.isAvailable());
            }
        }
        if (!chck){
            System.out.println("Aviable is false");
        }
    };
    void checkInBook(String isbn){

        for (Book book: list) {
            if (book.getIsbn()==isbn){
                System.out.println("Aviable is: "+book.isAvailable());
            }
        }

    }

}
