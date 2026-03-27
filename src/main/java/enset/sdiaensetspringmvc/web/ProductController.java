package enset.sdiaensetspringmvc.web;

import enset.sdiaensetspringmvc.entities.Products;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import enset.sdiaensetspringmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/user/index")
    public String index(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "products";

    }
    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";

    }
    @PostMapping("/admin/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }
    @GetMapping("/admin/newProduct")
    public String newProduct(Model model) {
        Products product = new Products();
        model.addAttribute("product", product);
        return "newProduct";

    }
    @PostMapping("/admin/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Products product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "newProduct";
        productRepository.save(product);
        return "redirect:/admin/newProduct";

    }
    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }
}
