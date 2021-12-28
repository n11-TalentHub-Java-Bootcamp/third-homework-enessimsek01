package service;

import entity.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.entityservice.ProductReviewEntityService;

import java.util.List;

@Service
public class ProductReviewServiceImpl {
    @Autowired
    private ProductReviewEntityService productReviewEntityService;

    public List<ProductReview> findAll() {
        return productReviewEntityService.findAll();
    }

    public ProductReview findById(String id) {
        return productReviewEntityService.findById(id);
    }
    public ProductReview save(ProductReview productReview) {
        return productReviewEntityService.save(productReview);
    }

    public void deleteById(String id) {
        productReviewEntityService.delete(id);
    }
}
