package com.exmaple.noadres.pumoodrabianie;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Ardian on 2016-06-25.
 */
public interface MInterface {
    @GET("/users/AdrianTestGit")
    void getUser(Callback<Pojo> uscb);
}
