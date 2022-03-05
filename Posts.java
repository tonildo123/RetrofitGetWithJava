package com.example.javaretrofit.Model;

public class Posts {

    /* Este tendra todos los atributos que tiene el objeto Json

                      ejemplo
                      {
                        "userId": 1,
                        "id": 1,
                        "title": "ejemplo title",
                        "body": "ejemplo body"
                      }

     */


    private int userId;
    private int id;
    private String title;
    private String body;


    public Posts() {

    }

    public Posts(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
