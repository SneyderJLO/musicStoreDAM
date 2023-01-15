package com.example.musicstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicstore.model.Instrument;
import com.example.musicstore.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GaleriaInstrumentosAdapter extends BaseAdapter {
    private Context mContext;
    private List<Instrument> instruments;

    public GaleriaInstrumentosAdapter(Context c, List<Instrument> instruments) {
        this.mContext = c;
        this.instruments = instruments;
    }

    @Override
    public int getCount() {
        return instruments.size();
    }

    @Override
    public Object getItem(int i) {
        return instruments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.instrument_card, null);

        String title = instruments.get(i).getName();
        int image = instruments.get(i).getImage();

        TextView txtTitle = v.findViewById(R.id.txtTitle);
        ImageView imgInstrument = v.findViewById(R.id.imageInstrument);

        Picasso.get()
                .load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg")
                .error(R.drawable.ic_launcher_background)
                .into(imgInstrument);

        txtTitle.setText(title);
//        imgInstrument.setImageResource(image);

        return v;
    }
}
