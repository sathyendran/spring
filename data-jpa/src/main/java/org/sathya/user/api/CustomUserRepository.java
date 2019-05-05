package org.sathya.user.api;

import org.sathya.user.bom.User;

import java.util.List;

public interface CustomUserRepository {
    List<User> findByLastName(String lastName);
}
