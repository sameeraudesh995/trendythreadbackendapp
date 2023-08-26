package com.ecommerce.request;

import com.ecommerce.model.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString
public class CreateProductRequest {

    private String title;
    private String description;
    private int price;
    private int discountPrice;
    private int discountPresent;
    private int quantity;
    private String brand;
    private String color;
    private Set<Size> size=new HashSet<>();
    private String imageUrl;
    private String topLavelCategory;
    private String secondLavelCategory;
    private String thirdLavelCategory;



}
