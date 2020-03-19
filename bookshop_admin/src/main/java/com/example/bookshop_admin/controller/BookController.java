package com.example.bookshop_admin.controller;

        import com.example.bookshop_admin.dto.BookCondition;
        import com.example.bookshop_admin.dto.BookInfo;
        import com.fasterxml.jackson.annotation.JsonView;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.web.PageableDefault;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @GetMapping
    @JsonView(BookInfo.GetListView.class)
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

    @GetMapping("/{id:\\d}")
    @JsonView(BookInfo.GetInfoView.class)
    public BookInfo getInfo(@PathVariable Long id,@CookieValue String tooken, @RequestHeader String auth ){
       throw new RuntimeException("test");
        /*System.out.println(tooken);
        System.out.println(auth);
        System.out.println(id);
        BookInfo bookInfo = new BookInfo();
        bookInfo.setName("菊花侠大战桃花怪");
        return bookInfo;*/
    }

    @PostMapping
    public BookInfo create(@Valid @RequestBody BookInfo info, BindingResult result){
        if(result.hasErrors()) {
            result.getAllErrors().stream().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
        }
        info.setId(1L);
        info.setName("war and space");
        info.setContent("what");
        info.setPublishDate(new Date());
        return info;
    }

    @PutMapping("/{id:\\d}")
    public BookInfo update(@Valid @RequestBody BookInfo info, BindingResult result){
        if(result.hasErrors()) {
            result.getAllErrors().stream().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
        }
        info.setId(1L);
        info.setName("war and space");
        info.setContent("what");
        info.setPublishDate(new Date());
        return info;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        System.out.println(id);
    }

}
