package com.example.inventoryman.service;


import com.example.inventoryman.model.Item;
import com.example.inventoryman.model.User;
import com.example.inventoryman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repos;


    @Override
    public User save(User user){
        return repos.save(user);
    }


        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            User user = repos.findByEmail(username);
            if(user == null) {
                throw new UsernameNotFoundException("Invalid username or password.");
            }
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getItems()));
        }

        private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Item> items){
            return items.stream().map(item -> new SimpleGrantedAuthority(item.getName())).collect(Collectors.toList());
        }


}
