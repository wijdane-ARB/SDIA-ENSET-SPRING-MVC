package enset.sdiaensetspringmvc.web;

import enset.sdiaensetspringmvc.entities.Products;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import enset.sdiaensetspringmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "products";

    }
    @GetMapping("/")
    public String home() {
        return "redirect:/index";

    }
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/index";
    }
    @GetMapping("/newProduct")
    public String newProduct(Model model) {
        Products product = new Products();
        model.addAttribute("product", product);
        return "newProduct";

    }
    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Products product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "newProduct";
        productRepository.save(product);
        return "redirect:/newProduct";

    }
}
