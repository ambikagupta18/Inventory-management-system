package com.example.inventoryman.service;

import com.example.inventoryman.model.Item;
import com.example.inventoryman.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
/*       Service for Item              */
    List<Item> getAllItems();

    void saveItem(Item item);

    Item getItemById(long id);

    void deleteItemById(long id);

    List<Item> listAll(String keyword);

    Page<Item> findPaginated(int pageNo, int pageSize);

/*   Service for User               */
   /* void saveUser(User user);
    List<User> getAllUsers();
    void deleteUserById(long id);*/
}
