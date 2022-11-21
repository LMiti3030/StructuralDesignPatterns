package mititelu.laura.another.ex;

public class BridgeDemo {

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setClassification("Action");
        movie.setTitle("John Wick");
        movie.setRuntime("2:15");
        movie.setYear("2014");

        Formatter printFormatter = new PrintFormatter();
        Printer moviePrinter = new MoviePrinter(movie);

        String printedMaterial = moviePrinter.print(printFormatter);

        System.out.println(printedMaterial);

        Formatter htmlFormatter = new HtmlFormatter();
        String htmlMaterial = moviePrinter.print(htmlFormatter);
        System.out.println(htmlMaterial);

        Book book = new Book();
        book.setTitle("Pride and Prejudice");
        book.setAuthor("Jane Austen");
        book.setPages(250);
        Printer bookPrinter = new BookPrinter(book);
        String bookMaterial = bookPrinter.print(printFormatter);
        System.out.println(bookMaterial);
        String bookHtml = bookPrinter.print(htmlFormatter);
        System.out.println(bookHtml);


    }

}
