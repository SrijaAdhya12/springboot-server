package com.example.springboot_server.api.models;

public class Post {
    private int id;
    private String title;
    private String body;
    private String media;
    private int authorId;

    public Post(int id, String title, String body, String media, int createdById) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.media = media;
        this.authorId = createdById;
    }

    public int getId() {
        return id;
    }

    public void setId(int postid) {
        this.id = postid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int AuthorId) {
        this.authorId = AuthorId;
    }
}
