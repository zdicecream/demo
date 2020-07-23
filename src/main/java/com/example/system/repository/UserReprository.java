package com.example.system.repository;

import com.example.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import java.util.List;

@RepositoryRestResource
@Service
public interface UserReprository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.id = ?1 ")
    User getUserD(Integer id);
    @Query(value = "SELECT * from t_user u where id = ?1" ,nativeQuery = true)
    User getBydd(Integer id);

    List<User> findAllByNameLike(String name);

    List findFirstByNameLike(String name);
}
