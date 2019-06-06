package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.leading.shop.services.CategoryService;
import vn.edu.leading.shop.services.ProductService;
import vn.edu.leading.shop.services.SupplierService;

@Controller
public class HomeController {
    public final CategoryService categoryService;

    private final ProductService productService;

    private final SupplierService supplierService;

    public HomeController(CategoryService categoryService, ProductService productService, SupplierService supplierService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.supplierService = supplierService;
    }

    @GetMapping("/")
    public String home (Model model){
        model.addAttribute("products",productService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("suppliers",supplierService.findAll());
        return "home/product";
    }
    @GetMapping("/product-detail/{id}")
    public String productDetail (@PathVariable("id") Long id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "home/product-detail";
    }
    @GetMapping("/cart")
    public String cart() {
        return "home/cart";
    }

}
