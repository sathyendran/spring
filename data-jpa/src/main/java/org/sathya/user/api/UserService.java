package org.sathya.user.api;

import org.sathya.user.messaging.UserRequest;

import java.util.List;

public interface UserService {
    UserRequest create(UserRequest userRequest);

    UserRequest update(UserRequest userRequest);

    List<UserRequest> getUser();

    UserRequest get(long id);

    public List<UserRequest> findByLastName(String lastName);
}
