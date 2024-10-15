package com.example.testtask.repository;

import com.example.testtask.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {
    List<UserDetail> findAllByUserId(Integer userId);
}
