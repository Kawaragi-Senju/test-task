package com.example.testtask.repository;

import com.example.testtask.entity.User;
import com.example.testtask.entity.UserPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserPhotoRepository extends JpaRepository<UserPhoto, Integer> {
    List<UserPhoto> findAllByUserId(Integer userId);
}

