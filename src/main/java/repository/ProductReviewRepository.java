package repository;

import entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductReviewRepository extends MongoRepository<ProductReview,String> {

    List<ProductReview> findAllByProductId(String productId);
}
