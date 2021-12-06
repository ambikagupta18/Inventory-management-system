package com.example.inventoryman.service;

import com.example.inventoryman.model.Item;
import com.example.inventoryman.model.User;
import com.example.inventoryman.repository.ItemRepository;
import com.example.inventoryman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository repo;
    @Autowired
    private UserRepository repos;
    /*             ServiceImpl for Items               */
    @Override
    public List<Item> getAllItems() {
        return repo.findAll();

    }
    @Override
    public List<Item> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    @Override
    public void saveItem(Item item) {
        this.repo.save(item);
    }

    @Override
    public Item getItemById(long id) {
        Optional<Item> optional = repo.findById(id);
        Item item = null;
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        return item;
    }

    @Override
    public void deleteItemById(long id) {
        this.repo.deleteById(id);
    }

    @Override
    public Page<Item> findPaginated(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo -1,pageSize);
        return this.repo.findAll(pageable);
    }


    /*   User Login and Register                     */
   /* @Override
    public void saveUser(User user) {
        this.repos.save(user);
    }
    @Override
    public List<User> getAllUsers() {
        return repos.findAll();

    }
//delete register user
    @Override
    public void deleteUserById(long id) {
        this.repos.deleteById(id);
    }*/
}
