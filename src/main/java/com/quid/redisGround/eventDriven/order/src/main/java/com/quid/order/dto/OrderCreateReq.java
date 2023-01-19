package com.quid.order.dto;

import java.util.Map;

public record OrderCreateReq(String userId, String productId, String price) {

    public Map<String, String> toMap() {
        return Map.of("userId", userId, "productId", productId, "price", price);
    }
}

