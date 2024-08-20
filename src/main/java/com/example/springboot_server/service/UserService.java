// package com.example.springboot_server.service;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.stereotype.Service;

// import com.example.springboot_server.api.models.User;

// @Service
// public class UserService {

//     private List<User> userList;

//     public UserService() {
//         userList = new ArrayList<>();

//         User user1 = new User(1, "Srija", 20, "srija@mail.com");
//         User user2 = new User(2, "pritam", 26, "pritam@mail.com");
//         User user3 = new User(3, "Nahi", 40, "nasi@mail.com");
//         User user4 = new User(4, "Umang", 32, "umang@mail.com");
//         User user5 = new User(5, "Eva", 59, "eva@mail.com");

//         userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
//     }

//     public Optional<List<User>> find() {
//         return Optional.of(userList);
//     }

//     public Optional<User> findById(int id) {
//         Optional<User> optional = Optional.empty();
//         for (User user : userList)
//             if (id == user.getId())
//                 optional = Optional.of(user);
//         return optional;

//     }

//     public Optional<User> getUser(Integer id) {
//         Optional<User> optional = Optional.empty();
//         for (User user : userList) {
//             if (id == user.getId()) {
//                 optional = Optional.of(user);
//                 return optional;
//             }
//         }
//         return optional;
//     }

//     public User createUser(User user) {
//         int id = userList.isEmpty() ? 1 : userList.get(userList.size() - 1).getId() + 1;
//         User newuser = new User(id, user.getName(), user.getAge(), user.getEmail());
//         userList.add(newuser);
//         return newuser;
//     }

//     public Optional<User> updateById(int id, User user) {
//         Optional<User> existingUserOpt = findById(id);
//         if (existingUserOpt.isEmpty())
//             return Optional.empty();

//         int index = 0;

//         for (User user_ : userList) {
//             if (user_.getId() == id) {
//                 break;
//             }
//             index++;
//         }

//         userList.set(index, user);
//         return Optional.of(existingUserOpt.get());
//     }

//     public Optional<User> editUser(int id, User user) {
//         Optional<User> existingUserOpt = findById(id);
//         if (existingUserOpt.isEmpty()) {
//             return Optional.empty();
//         }

//         User existingUser = existingUserOpt.get();
//         if (user.getName() != null) {
//             existingUser.setName(user.getName());
//         }
//         if (user.getAge() != 0) {
//             existingUser.setAge(user.getAge());
//         }
//         if (user.getEmail() != null) {
//             existingUser.setEmail(user.getEmail());
//         }
//         return Optional.of(existingUser);
//     }

//     public Optional<User> deleteUser(int id) {
//         Optional<User> existingUserOpt = findById(id);
//         if (existingUserOpt.isEmpty())
//             return Optional.empty();

//         User existingUser = existingUserOpt.get();
//         userList.remove(existingUser);

//         return Optional.of(existingUser);
//     }

//     public String deleteAllUsers() {
//         userList.clear();
//         return "all users removed";
//     }

// }
