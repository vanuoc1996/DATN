package com.nhu.service;

import com.nhu.entity.Product;
import com.nhu.entity.ServiceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public interface IProductService {
    public List<Product> getAllProduct(ServiceContext serviceContext);

    public Product getProductById(long id);

    public void creatProduct(Product product);

    public void updateProduct(long id, Product newProduct);

    public void deleteProduct(long id);

    public void creatProduct1(String productName, MultipartFile bannerImg,
                              MultipartFile coverImg, long price, long sale, String description,
                              int availability, String unit, long view, long revenue,
                              int status, long sellerId, long categoryId, Date creatAt, Date updateAt
    );
}
