package com.example.javaretrofit.Interface;

import com.example.javaretrofit.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostPlaceholderApi {


    @GET("posts")
    Call<List<Posts>> getPosts(); // siendo getPost() el metodo que me trae los post de la api
                                 // y los mete en mi Posts, modelo con las variables del json de la api


}
