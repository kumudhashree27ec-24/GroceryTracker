package com.example.grocery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grocery.domain.Items;

@Repository 
public interface ItemsRepository extends JpaRepository<Items, Integer> {
    Items findByName(String name);
}
