package com.travelmanagement.services.user;

import com.travelmanagement.dao.user.UsersDao;
import com.travelmanagement.model.user.UsersModel;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

    private final UsersDao usersDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServicesImpl(UsersDao usersDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersDao = usersDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void createUser(UsersModel usersModel){
        usersModel.setPassword(
                bCryptPasswordEncoder.encode(usersModel.getPassword())
        );
        usersDao.addUser(usersModel);
    }

    @Override
    public UsersModel getUser(String username) {
        return usersDao.getUser(username);
    }

    @Override
    public List<UsersModel> getAllUsers() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        List<UsersModel> usersModels = new ArrayList<>();
        if(usersDao.getAllUsers().size() > 0) {
            for (UsersModel user : usersDao.getAllUsers()) {
                if (!user.getUsername().equals(username)) {
                    usersModels.add(user);
                }
            }
            return usersModels;
        }
        else
            throw new NullPointerException("No users found");
    }

    @Override
    public void updateUser(UsersModel user) {
        usersDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        usersDao.deleteUser(id);
    }

    @Override
    public UsersModel getUserById(int id) {
        return usersDao.getUserById(id);
    }
}
