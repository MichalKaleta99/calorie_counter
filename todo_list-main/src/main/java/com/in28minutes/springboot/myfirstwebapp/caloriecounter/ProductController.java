package com.in28minutes.springboot.myfirstwebapp.caloriecounter;


import com.in28minutes.springboot.myfirstwebapp.caloriecounter.eatenproduct.EatenProduct;
import com.in28minutes.springboot.myfirstwebapp.caloriecounter.eatenproduct.EatenProductRepository;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    private EatenProductRepository eatenProductRepository;

    private EatenProduct eatenProduct = new EatenProduct();

    public ProductController(ProductRepository productRepository, EatenProductRepository eatenProductRepository) {
        this.productRepository = productRepository;
        this.eatenProductRepository = eatenProductRepository;
    }

    @RequestMapping(value = "products")
    public String listAllProducts(ModelMap model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        IntroducedProduct introducedProduct = new IntroducedProduct();
        model.put("product",introducedProduct);
        return "products";
    }
    @RequestMapping(value="products", method = RequestMethod.POST)
    public String getProductMass(ModelMap model, @Valid IntroducedProduct introducedProduct, BindingResult result){
        if(result.hasErrors()){
            return "products";
        }
        double eatenProductMass = introducedProduct.getMass();
        Product product = productRepository.findByName(introducedProduct.getProductName());

        eatenProduct = eatenProduct.addEatenProduct(product, eatenProductMass);
        try{
            eatenProductRepository.save(eatenProduct);
        } catch (DataIntegrityViolationException ex) {
            System.out.println(ex);
        }
        return "redirect:products";
    }

    @RequestMapping(value="summary", method = RequestMethod.GET)
    public String listEatenProducts(ModelMap model) throws IllegalAccessException {
        List<EatenProduct> productList = eatenProductRepository.findAll();
        model.addAttribute("eatenProducts", productList);
        System.out.println(productList);
        Map<String, Double> fieldSums = eatenProduct.sumDoubleFields(productList);
        model.addAttribute("summaryEaten", fieldSums);
        System.out.println(fieldSums);
        return "summary";
    }
    @RequestMapping(value="delete-product")
    public String deleteToDo(@RequestParam int id){
        eatenProductRepository.deleteById(id);
        return "redirect:summary";
    }

    @PostMapping("/update-product")
    public String updateProduct(@RequestParam int id, @RequestParam float mass) {
        EatenProduct eatenProduct = eatenProductRepository.findById(id).orElse(null);
        if (eatenProduct != null) {
            eatenProduct.setmass(mass);
            eatenProductRepository.save(eatenProduct);
        }
        return "redirect:summary";
    }

}
