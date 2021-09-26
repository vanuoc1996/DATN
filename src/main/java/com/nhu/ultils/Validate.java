package com.nhu.ultils;

import com.nhu.entity.Product;
import com.nhu.entity.ServiceContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;
import java.util.Date;

public class Validate {
    public ServiceContext checkServiceContext(ServiceContext serviceContext) {
        if (serviceContext.getPageSize() == null || serviceContext.getPageSize() == 0) {
            serviceContext.setPageSize(10);
        }
        if (serviceContext.getPageNumber() == null || serviceContext.getPageNumber() == 0) {
            serviceContext.setPageNumber(0);
        }
        if (serviceContext.getSortType() == null || serviceContext.getSortType().equals("")) {
            serviceContext.setSortType("ASC");
        }
        if (serviceContext.getSortField() == null || serviceContext.getSortField().equals("")) {
            serviceContext.setSortField("id");
        }
        return serviceContext;
    }

    public Product toProduct(String productName, MultipartFile bannerImg,
                             MultipartFile coverImg, long price, long sale, String description,
                             int availability, String unit, long view, long revenue,
                             int status, long sellerId, long categoryId, Date creatAt, Date updateAt) {
        Product product = new Product();
        product.setProductName(productName);
        product.setBannerImg(encodeFileToBase64Binary(bannerImg));
        product.setCoverImg(encodeFileToBase64Binary(coverImg));
        product.setPrice(price);
        product.setSale(sale);
        product.setDescription(description);
        product.setAvailability(availability);
        product.setUnit(unit);
        product.setView(view);
        product.setRevenue(revenue);
        product.setStatus(status);
        product.setSellerId(sellerId);
        product.setCategoryId(categoryId);
        if (creatAt == null){
            creatAt = new Date();
            product.setCreatAt(creatAt);
        }
        if (updateAt == null){
            updateAt = new Date();
            product.setCreatAt(updateAt);
        }
        return product;
    }

    public String encodeFileToBase64Binary(MultipartFile multipartFile) {
        String encodedfile = null;
        File file = new File("src/main/resources/targetFile.tmp");
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }
}
