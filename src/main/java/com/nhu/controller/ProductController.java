package com.nhu.controller;

import com.nhu.entity.Product;
import com.nhu.entity.ServiceContext;
import com.nhu.service.IProductService;
import com.nhu.ultils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAllProduct(@RequestBody ServiceContext serviceContext) {
        List<Product> entity = productService.getAllProduct(serviceContext);
        return new ResponseEntity<List<Product>>(entity, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        Product entity = productService.getProductById(id);
        return new ResponseEntity<Product>(entity, HttpStatus.OK);
    }

    @PostMapping("/creat")
    public ResponseEntity<?> creatProduct1(@RequestBody Product product) {
        try {
            productService.creatProduct(product);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @PostMapping("/creat1")
    public ResponseEntity<?> creatProduct1(@RequestBody(required = false) String productName, MultipartFile bannerImg,
                                           MultipartFile coverImg, long price, long sale, String description,
                                           int availability, String unit, long view, long revenue,
                                           int status, long sellerId, long categoryId, Date creatAt, Date updateAt
    ) {
        try {
            productService.creatProduct1(productName, bannerImg, coverImg, price, sale, description, availability, unit,
                    view, revenue, status, sellerId, categoryId, creatAt, updateAt);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/creat2")
    public ResponseEntity<String> creatProduct2(MultipartFile bannerImg) {
       String base64 = null;
        try {
            Validate validate = new Validate();
            base64 = validate.encodeFileToBase64Binary(bannerImg);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<String>(base64, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id, @RequestBody Product product) {
        try {
            productService.updateProduct(id, product);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
