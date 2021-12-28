package service;

import entity.ProductReview;

import java.util.List;

public interface ProductReviewService {

    List<ProductReview> findAll();

    ProductReview findById(String id);

    ProductReview save(ProductReview productReview);

    void delete(String id);
}
