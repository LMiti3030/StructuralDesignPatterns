package mititelu.laura.another.ex;

import java.util.ArrayList;
import java.util.List;

public class BookPrinter extends Printer{

    private Book book;

    public BookPrinter(Book book){
        this.book = book;
    }

    @Override
    protected List<Detail> getDetails() {
        List<Detail> details = new ArrayList<>();
        details.add(new Detail("Author", book.getAuthor()));
        details.add(new Detail("Pages", String.valueOf(book.getPages())));

        return details;
    }

    @Override
    protected String getHeader() {
        return book.getTitle();
    }
}
