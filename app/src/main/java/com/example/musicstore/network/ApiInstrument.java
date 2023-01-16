package com.example.musicstore.network;

import com.example.musicstore.model.Instrument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInstrument {
    @GET("Producto")
    Call<List<Instrument>> getInstruments();

    @GET("Producto/{id}")
    Call<Instrument> getInstrument(@Path("id") String id);
}
