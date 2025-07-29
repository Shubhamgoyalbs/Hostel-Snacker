package com.shubham.backend.controller.user;

import com.shubham.backend.body.ProductResponse;
import com.shubham.backend.service.user.ProductBySellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/products/sellers")
public class ProductBySellerController {

    @Autowired
    private ProductBySellerService productBySellerService;

    @RequestMapping("/{userId}")
    public List<ProductResponse> getProductsBySeller(Long userId) {
        return productBySellerService.getProductsBySeller(userId);
    }
}
