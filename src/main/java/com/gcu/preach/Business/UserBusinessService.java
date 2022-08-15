package com.gcu.preach.Business;



import com.gcu.preach.dao.UserRepository;
import com.gcu.preach.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class UserBusinessService implements UserBusinessServiceInterface, UserDetailsService {
    public static String userName = "";
    @Autowired
    private UserRepository userRepository;

    public boolean authenticateUser(String username, String password) {
        UserModel user = userRepository.getUserByUsername(username);
        if (user != null) {
            return user.getUserPassword().equals(password);
        }
        return false;
    }

    public boolean registerUser(UserModel userModel) {
        userRepository.create(userModel);
        return true;
    }

    public UserModel getUserByUsername(String username) {
        return userRepository.getUserByUsername(userName);
    }

    @Override
    public boolean update(UserModel userModel) {
        return userRepository.update(userModel);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.getUserByUsername(username);
        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            userName = user.getUserName();
            return new User(user.getUserName(), user.getUserPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("User not found");
        }

    }
}