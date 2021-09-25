package com.nhu.service.impl;

import com.nhu.entity.Product;
import com.nhu.entity.ServiceContext;
import com.nhu.repository.ProductRepository;
import com.nhu.service.IProductService;
import com.nhu.ultils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {
    Validate validate = new Validate();

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct(ServiceContext serviceContext) {
        serviceContext = validate.checkServiceContext(serviceContext);
        Page<Product> listProduct = null;
        if (serviceContext.getSortType().equals("DESC")) {
            listProduct = productRepository.findAll(PageRequest.of(serviceContext.getPageNumber(), serviceContext.getPageSize(), Sort.by(serviceContext.getSortField()).descending()));
        } else {
            listProduct = productRepository.findAll(PageRequest.of(serviceContext.getPageNumber(), serviceContext.getPageSize(), Sort.by(serviceContext.getSortField()).ascending()));
        }
        return listProduct.getContent();
    }

    @Override
    public Product getProductById(long id) {
        if (productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public void creatProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(long id, Product newProduct) {
        Product product = getProductById(id);
        newProduct.setId(product.getId());
        creatProduct(newProduct);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void creatProduct1(String productName, MultipartFile bannerImg, MultipartFile coverImg, long price, long sale, String description, int availability, String unit, long view, long revenue, int status, long sellerId, long categoryId, Date creatAt, Date updateAt) {

    }
}
