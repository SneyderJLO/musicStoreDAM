package com.example.musicstore.network;

import com.example.musicstore.model.Instrument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInstrument {
    @GET("/Producto")
    Call<List<Instrument>> getInstruments();
}
