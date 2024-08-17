package com.ims.controller;

import com.ims.model.Item;
import com.ims.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping
    public String viewAllItems(Model model) {
        model.addAttribute("items", itemService.fetchAllItems());
        return "items";
    }

    @PostMapping
    public String saveNewItem(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/new")
    public String newItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "new_item";
    }

    @GetMapping("/edit/{id}")
    public String modifyItem(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.fetchItemById(id));
        return "edit_item";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }

}