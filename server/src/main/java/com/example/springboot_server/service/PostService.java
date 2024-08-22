// package com.example.springboot_server.service;

// import com.example.springboot_server.api.models.Post;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.stereotype.Service;

// @Service
// public class PostService {
//     private List<Post> postList;

//     public PostService() {
//         postList = new ArrayList<>();

//         Post post1 = new Post(1, "Rainy Day", "Carried an umbrella",
//                 "https://upload.wikimedia.org/wikipedia/commons/2/26/Sunny_day_in_India.jpg", 1);
//         Post post2 = new Post(2, "Lunar", "Lunar Eclipse",
//                 "https://upload.wikimedia.org/wikipedia/commons/2/26/Sunny_day_in_India.jpg", 2);
//         Post post3 = new Post(3, "Vacay", "Vacay at Mumbai",
//                 "https://upload.wikimedia.org/wikipedia/commons/2/26/Sunny_day_in_India.jpg", 3);
//         Post post4 = new Post(4, "Vacay", "Vacay at Mumbai",
//                 "https://upload.wikimedia.org/wikipedia/commons/2/26/Sunny_day_in_India.jpg", 4);
//         Post post5 = new Post(5, "Movie time", "Horror Movie",
//                 "https://upload.wikimedia.org/wikipedia/commons/2/26/Sunny_day_in_India.jpg", 5);

//         postList.addAll(Arrays.asList(post1, post2, post3, post4, post5));

//     }

//     public Optional<List<Post>> find() {
//         return Optional.of(postList);
//     }

//     public Optional<Post> findById(int id) {
//         Optional<Post> optional = Optional.empty();
//         for (Post post : postList)
//             if (id == post.getId())
//                 optional = Optional.of(post);
//         return optional;
//     }

//     public Post createPost(Post post) {
//         int id = postList.isEmpty() ? 1 : postList.get(postList.size() - 1).getId() + 1;
//         Post newpost = new Post(id, post.getTitle(), post.getBody(), post.getMedia(), post.getAuthorId());
//         postList.add(newpost);
//         return newpost;
//     }

//     public Optional<Post> editPost(int id, Post post) {
//         Optional<Post> existingPostOpt = findById(id);
//         if (existingPostOpt.isEmpty()) {
//             return Optional.empty();
//         }

//         Post existingPost = existingPostOpt.get();
//         if (post.getTitle() != null) {
//             existingPost.setTitle(post.getTitle());
//         }
//         if (post.getBody() != null) {
//             existingPost.setBody(post.getBody());
//         }
//         if (post.getMedia() != null) {
//             existingPost.setMedia(post.getMedia());
//         }
//         if (post.getMedia() != null) {
//             existingPost.setMedia(post.getMedia());
//         }
//         if (post.getMedia() != null) {
//             existingPost.setMedia(post.getMedia());
//         }
//         if (post.getAuthorId() != 0) {
//             existingPost.setAuthorId(post.getAuthorId());
//         }

//         return Optional.of(existingPost);
//     }

//     public Optional<Post> updateById(int id, Post post) {
//         Optional<Post> existingPostOpt = findById(id);
//         if (existingPostOpt.isEmpty())
//             return Optional.empty();

//         int index = 0;

//         for (Post post_ : postList) {
//             if (post_.getId() == id) {
//                 break;
//             }
//             index++;
//         }

//         postList.set(index, post);
//         return Optional.of(existingPostOpt.get());
//     }

//     public Optional<Post> deletePost(int id) {
//         Optional<Post> existingPostOpt = findById(id);
//         if (existingPostOpt.isEmpty())
//             return Optional.empty();

//         Post existingPost = existingPostOpt.get();
//         postList.remove(existingPost);

//         return Optional.of(existingPost);
//     }

//     public String deleteAllPosts() {
//         postList.clear();
//         return "all users removed";
//     }

// }
