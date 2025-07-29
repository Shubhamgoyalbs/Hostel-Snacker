package com.shubham.backend.service.user;

import com.shubham.backend.body.ProductResponse;
import com.shubham.backend.entity.User;
import com.shubham.backend.entity.UserProduct;
import com.shubham.backend.repository.UserProductRepo;
import com.shubham.backend.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBySellerService {

    private final UserRepo userRepo;
    private final UserProductRepo userProductRepo;

    public ProductBySellerService(UserRepo userRepo, UserProductRepo userProductRepo) {
        this.userRepo = userRepo;
        this.userProductRepo = userProductRepo;
    }

    public List<ProductResponse> getProductsBySeller(Long userId) {
        List<UserProduct> UPS = userProductRepo.findAllByUserId(userId);

        return UPS.stream()
                .map(this::convertToProductResponse)
                .toList();
    }

    private ProductResponse convertToProductResponse(UserProduct userProduct) {
        ProductResponse response = new ProductResponse();
        response.setQuantity(userProduct.getQuantity());
        response.setProductId(userProduct.getProduct().getProductId());
        response.setName(userProduct.getProduct().getName());
        response.setDescription(userProduct.getProduct().getDescription());
        response.setPrice(userProduct.getProduct().getPrice());
        response.setImageUrl(userProduct.getProduct().getImageUrl());

        return response;
    }
}
