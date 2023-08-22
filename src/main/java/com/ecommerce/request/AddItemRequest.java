package com.ecommerce.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddItemRequest {
    private Long productId;
    private String size;
    private int quantity;
    private Integer price ;
}
