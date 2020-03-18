package com.example.bookshop_admin.controller;

        import com.example.bookshop_admin.dto.BookCondition;
        import com.example.bookshop_admin.dto.BookInfo;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.web.PageableDefault;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @RequestMapping(method = RequestMethod.GET)
    public List<BookInfo> query(BookCondition bookCondition,@PageableDefault(size = 10) Pageable pageable){
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<BookInfo> books = new ArrayList<BookInfo>();
        books.add(new BookInfo());
        books.add(new BookInfo());
        books.add(new BookInfo());
        return books;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public BookInfo getInfo(@PathVariable Long id){
        System.out.println(id);
        BookInfo bookInfo = new BookInfo();
        bookInfo.setName("菊花侠大战桃花怪");
        return bookInfo;
    }
}
