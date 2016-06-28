package com.exmaple.noadres.pumoodrabianie;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {

    String url = "https://api.github.com";

    TextView login;
    TextView strona;
    TextView gitNazwa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (TextView) findViewById(R.id.login);
        strona = (TextView) findViewById(R.id.strona);
        gitNazwa = (TextView) findViewById(R.id.gitNazwa);

        RestAdapter radapter = new RestAdapter.Builder().setEndpoint(url).build();

        MInterface restInt = radapter.create(MInterface.class);

        restInt.getUser(new Callback<Pojo>() {
            @Override
            public void success(Pojo model, Response response) {
                login.setText("Login: " + model.getLogin());
                strona.setText("Website: " + model.getBlog());
                gitNazwa.setText("Git URL: " + model.getHtmlUrl());
            }

            @Override
            public void failure(RetrofitError error) {

                String err = error.getMessage();
            }
        });

    }
}
