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

    // �����̰߳�ȫ��Map
    static Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());

    @ApiOperation(value="��ȡ�鼮�б�", notes="")
    @RequestMapping(value={"/"}, method=RequestMethod.GET)
    public List<Book> getBookList() {
        // ����"/books/"��GET����������ȡͼ���б�
        // ������ͨ��@RequestParam���ݲ��������в�ѯ�������߷�ҳ��Ϣ�Ĵ���
        List<Book> r = new ArrayList<Book>(books.values());
        return r;
    }

    @ApiOperation(value="�����鼮", notes="����Book���󴴽��鼮")
    @ApiImplicitParam(name = "book", value = "�鼮ʵ�����Book", required = true, dataType = "Book")
    @RequestMapping(value="/", method=RequestMethod.POST,produces = "application/json")
    public JsonResult createBook(@RequestBody Book book) {
        // ����"/books/"��POST������������User
        // ����@ModelAttribute�󶨲���֮�⣬������ͨ��@RequestParam��ҳ���д��ݲ���
        books.put(book.getId(), book);
        JsonResult jr = new JsonResult();
        jr.setIsSuccessful(true);
        jr.setResultCode("0000");
        jr.setResultDesc("success");
        return jr;
    }

    @ApiOperation(value="��ȡ�鼮��ϸ��Ϣ", notes="����URL�е�bookId����ȡ�鼮��ϸ��Ϣ")
    @ApiImplicitParam(name = "bookId", value = "�鼮ID", required = true, dataType = "Long")
    @RequestMapping(value="/{bookId}", method=RequestMethod.GET)
    public Book getBook(@PathVariable Long bookId) {
        // ����"/books/{id}"��GET����������ȡurl��idֵ��Book��Ϣ
        // url�е�id��ͨ��@PathVariable�󶨵������Ĳ�����
        return books.get(bookId);
    }

    @ApiOperation(value="�����鼮��Ϣ", notes="����URL�е�bookId��ָ�������鼮�������ݴ�������Book��Ϣ�������鼮��ϸ��Ϣ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookId", value = "�鼮ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "book", value = "�鼮��ϸʵ��book", required = true, dataType = "Book")
    })
    @RequestMapping(value="/{bookId}", method=RequestMethod.PUT)
    public JsonResult putBook(@PathVariable Long bookId, @RequestBody Book book) {
        // ����"/books/{bookId}"��PUT������������Book��Ϣ
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

    @ApiOperation(value="ɾ���鼮", notes="����URL�е�bookId��ָ��ɾ���鼮")
    @ApiImplicitParam(name = "bookId", value = "�鼮ID", required = true, dataType = "Long")
    @RequestMapping(value="/{bookId}", method=RequestMethod.DELETE)
    public JsonResult deleteBook(@PathVariable Long bookId) {
        // ����"/books/{bookId}"��DELETE��������ɾ��Book
        books.remove(bookId);
        JsonResult jr = new JsonResult();
        jr.setIsSuccessful(true);
        jr.setResultCode("0000");
        jr.setResultDesc("success");
        return jr;
    }
}