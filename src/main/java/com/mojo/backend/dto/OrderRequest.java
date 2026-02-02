package com.mojo.backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequest {
    private Long restaurantId;
    private List<OrderItemRequest> items;
}
