package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entiry.User;

@Service
public class UserService {
 @Autowired
 UserRepository userRepository;
 
 public User createUser(User user) {
	return userRepository.save(user);
	 
 }
 public List<User> createListOfUser(List<User> users) {
	return userRepository.saveAll(users);
	 
 }
 public User getUserById(int id) {
	 return userRepository.findById(id).orElse(null);
 }
 public List<User> getUsers() {
	 return userRepository.findAll();
 }
 public User updateUser(User user) {
	 Optional<User> optionalOldUser = userRepository.findById(user.getId());
	 if (optionalOldUser.isPresent()) {
         User oldUser = optionalOldUser.get();
         //update only the fields that are not null in the input user
         if(user.getName() != null){
             oldUser.setName(user.getName());
         }
         if(user.getAddress() != null){
             oldUser.setAddress(user.getAddress());
         }
         return userRepository.save(oldUser);
     } else {
         // Handle the case where the user doesn't exist.
         // Option 1: Return null
         // return null;

         // Option 2: Throw an exception
         throw new RuntimeException("User with ID " + user.getId() + " not found.");
     }
 }
 
 
 
}
