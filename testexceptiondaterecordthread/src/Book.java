public record Book(String title, String autor, int ISBN, String publicationDate) {

    public Book(){
        this("efrv934j","t",5,"4545");
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN=" + ISBN +
                ", publicationDate=" + publicationDate +
                '}';
    }

}
