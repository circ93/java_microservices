package it.corso.example.thymeleafproject.Controller;

import it.corso.example.thymeleafproject.business.interfaces.CategoryBO;
import it.corso.example.thymeleafproject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    CategoryBO categoryBO;

    @GetMapping(value = {"/createCat"})
    public ModelAndView createCategory() {

        return new ModelAndView("createCat.html");
    }

    @PostMapping(value = {"/createCat"})
    public String createCategory(Model model, @RequestParam String name) {

        if (name == null) {
            String msg = "Il nome inserito non è valido!";
            model.addAttribute("msg", msg);
            return "createCat.html";

        } else {
            Category _cat = new Category(name);
            String msg = categoryBO.save(_cat);
            model.addAttribute("msg", msg);
            return "redirect:/home";
        }

    }
}
