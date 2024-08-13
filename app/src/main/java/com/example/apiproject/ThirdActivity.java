package com.example.apiproject;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThirdActivity extends AppCompatActivity {

    //photos
    public static String api="https://jsonplaceholder.typicode.com";
    List<UserModel> allUserList;

    RecyclerView rcvMain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rcvMain=findViewById(R.id.RcvMain);

        rcvMain.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.getInstance().apiInterface.getUsers().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                //Log.e("api","OnSuccess"+ response.body().toString());

                allUserList=response.body();
                rcvMain.setAdapter(new UserAdapter(ThirdActivity.this,allUserList));

            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable throwable) {

                Log.e("api","onFailure:"+ throwable.getLocalizedMessage());

            }
        });


    }
}