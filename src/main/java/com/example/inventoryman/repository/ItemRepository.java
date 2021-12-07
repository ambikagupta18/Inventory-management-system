package com.example.inventoryman.repository;

import com.example.inventoryman.model.Item;
import com.example.inventoryman.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("SELECT p FROM Item p WHERE p.name LIKE %?1%")
    public Page<Item> findAll(String keyword,Pageable pageable);

}
