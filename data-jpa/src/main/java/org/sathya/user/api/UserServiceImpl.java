package org.sathya.user.api;

import org.sathya.user.bom.User;
import org.sathya.user.messaging.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserRequest create(UserRequest userRequest) {
        logger.debug("Creating the user : {}",userRequest);
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);
        userRepository.save(user);
        userRequest.setId(user.getId());
        return userRequest;
    }

    @Override
    public UserRequest update(UserRequest userRequest) {
        logger.debug("Updating the user : {}",userRequest);
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);
        userRepository.save(user);
        return userRequest;
    }

    @Override
    public List<UserRequest> getUser() {
        List<User> users = userRepository.findAll();
        List<UserRequest> userRequests = new ArrayList<>(users.size());
        users.forEach(user -> {
            UserRequest userRequest = new UserRequest();
            BeanUtils.copyProperties(user,userRequest);
            userRequests.add(userRequest);
        });
        return userRequests;
    }

    @Override
    public UserRequest get(long id) {
        Optional<User> byId = userRepository.findById(id);
        User user = null;
        if (byId.isPresent()){
            user = byId.get();
            UserRequest userRequest = new UserRequest();
            BeanUtils.copyProperties(user,userRequest);
            return  userRequest;
        }
        return null;
    }
}
