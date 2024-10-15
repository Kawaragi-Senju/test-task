package com.example.testtask.service;

import com.example.testtask.entity.UserDetail;
import com.example.testtask.repository.UserDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailService {
    private final UserDetailRepository userDetailRepository;

    public List<UserDetail> findAllByUserId(Integer userId) {
        return userDetailRepository.findAllByUserId(userId);
    }

    public UserDetail findById(Integer id) {
        return userDetailRepository.findById(id).orElse(null);
    }

    public UserDetail save(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    public void deleteById(Integer id) {
        userDetailRepository.deleteById(id);
    }
}

