package com.rusili.a0411mapfromscratch.network;

import com.rusili.a0411mapfromscratch.model.MuseumWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MuseumService {
    @GET("JDVila/storybook/master/museums.json")
    Call<MuseumWrapper> getMuseumWrapper();
}
