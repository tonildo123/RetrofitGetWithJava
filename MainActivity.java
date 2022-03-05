package com.example.javaretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.javaretrofit.Interface.PostPlaceholderApi;
import com.example.javaretrofit.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tvPosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPosts = (TextView) findViewById(R.id.tvPosts);
        getPosts();
    }

    private void getPosts(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/") // no es necesario poner posts del end ponit completo
                .addConverterFactory(GsonConverterFactory.create())// por la notacion en la clase interface
                .build();

        // now call api

        PostPlaceholderApi placeholderApi = retrofit.create(PostPlaceholderApi.class);

        Call<List<Posts>> call = placeholderApi.getPosts();
        call.enqueue(new Callback<List<Posts>>() { // usando retrofit en background
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                if(!response.isSuccessful()){

                    tvPosts.setText("Error : "+response.code());
                    return;

                }



                List<Posts> postsList = response.body();

                String contenido = ""; // lo concateno con el contenido del json

                for(Posts post : postsList){ // uso for each

                    contenido += "UserId : "+post.getUserId()+"\n";
                    contenido += "Id : "+post.getId()+"\n";
                    contenido += "Title : "+post.getTitle()+"\n";
                    contenido += "Body : "+post.getBody()+"\n\n";


                }

                tvPosts.setText(contenido);


            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

                tvPosts.setText("motivo del error : "+t.getMessage());
            }
        });

    }
}