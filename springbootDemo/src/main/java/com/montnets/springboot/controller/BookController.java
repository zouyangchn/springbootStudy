package com.montnets.springboot.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montnets.springboot.bean.Book;
import com.montnets.springboot.bean.JsonResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/books")
public class BookController {

    // 创建线程安全的Map
    static Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());

    @ApiOperation(value="获取书籍列表", notes="")
    @RequestMapping(value={"/"}, method=RequestMethod.GET)
    public List<Book> getBookList() {
        // 处理"/books/"的GET请求，用来获取图书列表
        // 还可以通过@RequestParam传递参数来进行查询条件或者翻页信息的传递
        List<Book> r = new ArrayList<Book>(books.values());
        return r;
    }

    @ApiOperation(value="创建书籍", notes="根据Book对象创建书籍")
    @ApiImplicitParam(name = "book", value = "书籍实体对象Book", required = true, dataType = "Book")
    @RequestMapping(value="/", method=RequestMethod.POST,produces = "application/json")
    public JsonResult createBook(@RequestBody Book book) {
        // 处理"/books/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        books.put(book.getId(), book);
        JsonResult jr = new JsonResult();
        jr.setIsSuccessful(true);
        jr.setResultCode("0000");
        jr.setResultDesc("success");
        return jr;
    }

    @ApiOperation(value="获取书籍详细信息", notes="根据URL中的bookId来获取书籍详细信息")
    @ApiImplicitParam(name = "bookId", value = "书籍ID", required = true, dataType = "Long")
    @RequestMapping(value="/{bookId}", method=RequestMethod.GET)
    public Book getBook(@PathVariable Long bookId) {
        // 处理"/books/{id}"的GET请求，用来获取url中id值的Book信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return books.get(bookId);
    }

    @ApiOperation(value="更新书籍信息", notes="根据URL中的bookId来指定更新书籍，并根据传过来的Book信息来更新书籍详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookId", value = "书籍ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "book", value = "书籍详细实体book", required = true, dataType = "Book")
    })
    @RequestMapping(value="/{bookId}", method=RequestMethod.PUT)
    public JsonResult putBook(@PathVariable Long bookId, @RequestBody Book book) {
        // 处理"/books/{bookId}"的PUT请求，用来更新Book信息
        Book b = books.get(bookId);
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        books.put(bookId, b);
        JsonResult jr = new JsonResult();
        jr.setIsSuccessful(true);
        jr.setResultCode("0000");
        jr.setResultDesc("success");
        return jr;
    }

    @ApiOperation(value="删除书籍", notes="根据URL中的bookId来指定删除书籍")
    @ApiImplicitParam(name = "bookId", value = "书籍ID", required = true, dataType = "Long")
    @RequestMapping(value="/{bookId}", method=RequestMethod.DELETE)
    public JsonResult deleteBook(@PathVariable Long bookId) {
        // 处理"/books/{bookId}"的DELETE请求，用来删除Book
        books.remove(bookId);
        JsonResult jr = new JsonResult();
        jr.setIsSuccessful(true);
        jr.setResultCode("0000");
        jr.setResultDesc("success");
        return jr;
    }
}