package controller;

import entity.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import service.ProductReviewService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/productReviews/")
public class ProductReviewController {
    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping
    public MappingJacksonValue findAll(){
        List<ProductReview> productReviewList= productReviewService.findAll();
        MappingJacksonValue mapping= new MappingJacksonValue(productReviewList);
        return mapping;
    }
    @GetMapping("{id}")
    public MappingJacksonValue findById(@PathVariable String id){
        ProductReview productReview= productReviewService.findById(id);
        WebMvcLinkBuilder linkToUrun = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
        EntityModel entityModel = EntityModel.of(productReview);
        entityModel.add(linkToUrun.withRel("all-productreviews"));
        MappingJacksonValue mapping= new MappingJacksonValue(entityModel);
        return mapping;
    }

    public ResponseEntity<Object> save(@Valid @RequestBody ProductReview productReview){
        productReview= productReviewService.save(productReview);
        return new ResponseEntity<>(productReview, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        productReviewService.delete(id);
    }
}
