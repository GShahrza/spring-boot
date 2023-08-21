package com.company.usertask.repository;

import com.company.usertask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {


   @Query(value = "select f from User f left join f.accounts")
   List<User> getAllUsers();


   @Query(value = "select f from User f LEFT JOIN f.accounts a WHERE a.accountId = ?1 ")
   User getUserByAccountId(Long account_id);

}
