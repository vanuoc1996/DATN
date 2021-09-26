package com.nhu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "banner_img", nullable = false)
    private String bannerImg;

    @Column(name = "cover_img", nullable = false)
    private String coverImg;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "sale")
    private long sale;

    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private int availability;

    @Column(name = "unit")
    private String unit;

    @Column(name = "view")
    private Long view;

    @Column(name = "revenue")
    private Long revenue;

    @Column(name = "returned")
    private Long returned;

    @Column(name = "status")
    private int status;

    @Column(name = "seller_id")
    private Long sellerId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "creat_at")
    private Date creatAt = new Date();

    @Column(name = "update_at")
    private Date updateAt = new Date();;
}
