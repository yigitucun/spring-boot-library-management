package com.ali.library.api.controllers;

import com.ali.library.dataAccess.abstracts.IBookRepository;
import com.ali.library.entities.concretes.Book;
import com.ali.library.forms.BookForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexController {
    private final IBookRepository bookRepository;

    public IndexController(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String index(Model model){
        BookForm form = new BookForm();
        List<Book> books = this.bookRepository.findAll();
        model.addAttribute("books",books);
        model.addAttribute("form",form);
        return "index";
    }

    @GetMapping("delete/{id}")
    public String index(@PathVariable int id){
        this.bookRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping
    public String index(@Valid @ModelAttribute("form") BookForm form, BindingResult result,Model model){
        if (result.hasErrors()){
            List<Book> books = this.bookRepository.findAll();
            model.addAttribute("books",books);
            return "index";
        }
        this.bookRepository.save(form.toEntity(form));
        return "redirect:/";
    }

}
