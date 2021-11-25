package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.User;
import net.skhu.mapper.UserMapper;
import net.skhu.model.UserRegister;

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findByUserid(String userid) {
        return userMapper.findByUserid(userid);
    }

    public User createDto(UserRegister userRegister) {
        User user = new User();
        user.setUserid(userRegister.getUserid());
        user.setPassword(userRegister.getPasswd1());
        user.setName(userRegister.getName());
        user.setEmail(userRegister.getEmail());
        user.setEnabled(true);
        user.setUserType("학생");
        if (userRegister.getDepartmentId() != 0)
            user.setDepartmentId(userRegister.getDepartmentId());
        return user;
    }

    public void insert(UserRegister userRegister) {
        User user = createDto(userRegister);
        userMapper.insert(user);
    }

}

