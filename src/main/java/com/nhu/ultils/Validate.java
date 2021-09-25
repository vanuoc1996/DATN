package com.nhu.ultils;

import com.nhu.entity.Product;
import com.nhu.entity.ServiceContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class Validate {
    public ServiceContext checkServiceContext(ServiceContext serviceContext) {
        if (serviceContext.getPageSize()==null || serviceContext.getPageSize()==0) {
            serviceContext.setPageSize(10);
        }
        if (serviceContext.getPageNumber() == null || serviceContext.getPageNumber()==0) {
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
                             int status, long sellerId, long categoryId, Date creatAt, Date updateAt){

        return null;
    }
}
