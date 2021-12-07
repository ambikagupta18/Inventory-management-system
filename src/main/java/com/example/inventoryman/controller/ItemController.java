package com.example.inventoryman.controller;

import com.example.inventoryman.model.Item;
import com.example.inventoryman.model.User;
import com.example.inventoryman.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    /******************     Login Controller          *********************/

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/test")
    public String home() {
        return "redirect:/";
    }


    /******************    Item Controller   ***************/


    @GetMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        return findPaginated(1, model, keyword);

    }

    @GetMapping("/showNewProductForm")
    public String showNewItemForm(Model model) {

        Item item = new Item();
        model.addAttribute("item", item);
        return "new_item";
    }

    @PostMapping("/saveProduct")
    public String saveItem(@Valid @ModelAttribute("item") Item item, BindingResult br) throws IOException {
        if (br.hasErrors()) {
            return "new_item";
        } else {
            itemService.saveItem(item);
            return "redirect:/";
        }
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Item item = itemService.getItemById(id);

        model.addAttribute("item", item);
        return "update_item";

    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteItem(@PathVariable(value = "id") long id) {

        this.itemService.deleteItemById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model, @Param("keyword") String keyword) {
        int pageSize = 5;

        Page<Item> page = itemService.findPaginated(pageNo, pageSize, keyword);
        List<Item> listItems = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listItems", listItems);
        model.addAttribute("keyword", keyword);
        return "index";
    }


}
