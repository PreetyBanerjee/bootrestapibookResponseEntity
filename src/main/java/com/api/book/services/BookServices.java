package com.api.book.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookServices {
	
	@Autowired
	private BookRepository bookRepository;
//	private static List<Book> list=new ArrayList<>();
//	
//	static {
//		list.add(new Book(12,"Java Complete Reference","WER"));
//		list.add(new Book(23,"Head First Java","WjgsR"));
//		list.add(new Book(34,"Thing in Java","WomsER"));
//	}
	
//	get all books
	public List<Book> getAllBooks(){
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
//	get single book by id
	public Book getBookById(int id) {
//		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		Book book= null;
		try {
			book=this.bookRepository.findById(id);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		return book;
	}
	
	// adding the book
	public Book addBook(Book b) {
		Book result=bookRepository.save(b);
		return result;
	}
	
	// delete the book
	public void deleteBook(int bid) {
//		list=list.stream().filter(e->e.getId()!=bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	}
	
	//update the book
	public void updateBook(Book book, int bookId) {
//		list=list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookRepository.save(book);
	}

}
