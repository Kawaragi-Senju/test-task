package com.example.testtask.service;

import com.example.testtask.entity.UserPhoto;
import com.example.testtask.repository.UserPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPhotoService {
    private final UserPhotoRepository userPhotoRepository;

    public List<UserPhoto> findAllByUserId(Integer userId) {
        return userPhotoRepository.findAllByUserId(userId);
    }

    public UserPhoto findById(Integer id) {
        return userPhotoRepository.findById(id).orElse(null);
    }

    public UserPhoto save(UserPhoto userPhoto) {
        return userPhotoRepository.save(userPhoto);
    }

    public void deleteById(Integer id) {
        userPhotoRepository.deleteById(id);
    }
}

