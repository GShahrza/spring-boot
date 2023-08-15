package com.company.usertask.dao.repository;

import com.company.usertask.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select u.user_created_at,u.user_updated_at,u.first_name,u.last_name,a.* from users u\n" +
            "left join account a using (user_id);",nativeQuery = true)
    List<User> getAllUsersAndAccounts();
}
