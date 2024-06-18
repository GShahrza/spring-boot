package com.company.usertask.repository;

import com.company.usertask.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long > {

    @Query(value = "select p from Profile p left join fetch p.profileDetail pt")
    List<Profile> findAllForNative();
}
