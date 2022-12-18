package com.in28minutes.springboot.myfirstwebapp.caloriecounter.eatenproduct;

import com.in28minutes.springboot.myfirstwebapp.caloriecounter.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EatenProductRepository extends JpaRepository<EatenProduct, Integer> {



}
