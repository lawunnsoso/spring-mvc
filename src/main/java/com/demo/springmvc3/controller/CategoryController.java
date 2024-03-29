package com.demo.springmvc3.controller;

import com.demo.springmvc3.model.Category;
import com.demo.springmvc3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String creata(ModelMap model){
        model.addAttribute("category",new Category());
        return "categoryForm";
    }
    @PostMapping("/category")
    public String process(@Valid Category category, BindingResult result){
        if(result.hasErrors()){
            return "categoryForm";
        }
        categoryService.create(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories")
    public String showAllCategories(ModelMap model){
        model.addAttribute("categories",categoryService.findAll());
        return "categories";
    }
}
