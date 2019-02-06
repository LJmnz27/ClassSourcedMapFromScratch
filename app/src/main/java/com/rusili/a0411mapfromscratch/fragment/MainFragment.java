package com.rusili.a0411mapfromscratch.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rusili.a0411mapfromscratch.R;
import com.rusili.a0411mapfromscratch.controller.MuseumsAdapter;
import com.rusili.a0411mapfromscratch.model.MuseumWrapper;
import com.rusili.a0411mapfromscratch.network.MuseumService;
import com.rusili.a0411mapfromscratch.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerview);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        MuseumService museumService = retrofit.create(MuseumService.class);
        Call<MuseumWrapper> museumWrapperCall = museumService.getMuseumWrapper();
        museumWrapperCall.enqueue(new Callback<MuseumWrapper>() {
            @Override
            public void onResponse(Call<MuseumWrapper> call, Response<MuseumWrapper> response) {
                Log.d("joestag", "onResponse: " + response.body().getMuseums().get(0).getName());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(new MuseumsAdapter(response.body().getMuseums()));
            }

            @Override
            public void onFailure(Call<MuseumWrapper> call, Throwable t) {
                Log.d("joestag", "onFailure" + t.getMessage());
            }
        });

        return rootView;
    }
}
