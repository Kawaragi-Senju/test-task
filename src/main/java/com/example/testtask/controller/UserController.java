package com.example.testtask.controller;

import com.example.testtask.entity.User;
import com.example.testtask.entity.UserDetail;
import com.example.testtask.entity.UserPhoto;
import com.example.testtask.service.UserDetailService;
import com.example.testtask.service.UserPhotoService;
import com.example.testtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserDetailService userDetailService;
    private final UserPhotoService userPhotoService;

    // Методы для User
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.findById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Методы для UserDetail
    @GetMapping("/{userId}/details")
    public List<UserDetail> getUserDetails(@PathVariable Integer userId) {
        return userDetailService.findAllByUserId(userId);
    }

    @GetMapping("/{userId}/details/{id}")
    public ResponseEntity<UserDetail> getUserDetailById(@PathVariable Integer userId, @PathVariable Integer id) {
        UserDetail detail = userDetailService.findById(id);
        return detail != null ? ResponseEntity.ok(detail) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{userId}/details")
    public UserDetail createUserDetail(@PathVariable Integer userId, @RequestBody UserDetail userDetail) {
        userDetail.setUserId(userId);
        return userDetailService.save(userDetail);
    }

    @PutMapping("/{userId}/details/{id}")
    public ResponseEntity<UserDetail> updateUserDetail(@PathVariable Integer userId, @PathVariable Integer id, @RequestBody UserDetail userDetail) {
        userDetail.setId(id);
        userDetail.setUserId(userId);
        return ResponseEntity.ok(userDetailService.save(userDetail));
    }

    @DeleteMapping("/{userId}/details/{id}")
    public ResponseEntity<Void> deleteUserDetail(@PathVariable Integer userId, @PathVariable Integer id) {
        userDetailService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Методы для UserPhoto
    @GetMapping("/{userId}/photos")
    public List<UserPhoto> getUserPhotos(@PathVariable Integer userId) {
        return userPhotoService.findAllByUserId(userId);
    }

    @GetMapping("/{userId}/photos/{id}")
    public ResponseEntity<UserPhoto> getUserPhotoById(@PathVariable Integer userId, @PathVariable Integer id) {
        UserPhoto photo = userPhotoService.findById(id);
        return photo != null ? ResponseEntity.ok(photo) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{userId}/photos")
    public UserPhoto createUserPhoto(@PathVariable Integer userId, @RequestBody UserPhoto userPhoto) {
        userPhoto.setUserId(userId);
        return userPhotoService.save(userPhoto);
    }

    @PutMapping("/{userId}/photos/{id}")
    public ResponseEntity<UserPhoto> updateUserPhoto(@PathVariable Integer userId, @PathVariable Integer id, @RequestBody UserPhoto userPhoto) {
        userPhoto.setId(id);
        userPhoto.setUserId(userId);
        return ResponseEntity.ok(userPhotoService.save(userPhoto));
    }

    @DeleteMapping("/{userId}/photos/{id}")
    public ResponseEntity<Void> deleteUserPhoto(@PathVariable Integer userId, @PathVariable Integer id) {
        userPhotoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

