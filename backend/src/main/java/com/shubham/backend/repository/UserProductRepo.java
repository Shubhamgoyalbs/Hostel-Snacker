package com.shubham.backend.repository;

import com.shubham.backend.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;
import java.util.List;

@Repository
public interface UserProductRepo extends JpaRepository<UserProduct, Integer> {
    List<UserProduct> findAllByProductId(Long productId);

    List<UserProduct> findAllByUserId(Long userId);

    List<UserProduct> findAllByUserIdAndListed(Long sellerId, boolean b);

    <T> ScopedValue<T> findByUserIdAndProductId(Long sellerId, Long productId);
}
