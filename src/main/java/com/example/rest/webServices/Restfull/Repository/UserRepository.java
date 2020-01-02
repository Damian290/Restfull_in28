package com.example.rest.webServices.Restfull.Repository;

import com.example.rest.webServices.Restfull.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Acer on 2020-01-02.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
