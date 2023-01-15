package com.example.musicstore.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicstore.R;

public class GaleriaInstrumentosAdapter extends BaseAdapter {
    private Context mContext;
    public String[] instrumentos = {
            "Guitarra 1",
            "Guitarra 2",
            "Guitarra 3",
            "Guitarra 4",
            "Guitarra 5",
            "Guitarra 6",
            "Guitarra 7",
            "Guitarra 8",
            "Guitarra 9",
            "Guitarra 10",
            "Guitarra 11",
            "Guitarra 12",
    };
    public int[] imageArray = {
            R.drawable.guitarra_01,
            R.drawable.guitarra_02,
            R.drawable.guitarra_03,
            R.drawable.guitarra_04,
            R.drawable.guitarra_05,
            R.drawable.guitarra_06,
            R.drawable.guitarra_07,
            R.drawable.guitarra_08,
            R.drawable.guitarra_09,
            R.drawable.guitarra_10,
            R.drawable.guitarra_11,
            R.drawable.guitarra_12,
    };

    public GaleriaInstrumentosAdapter(Context c) {
        this.mContext = c;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int i) {
        return imageArray[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        TextView textView = new TextView(mContext);
        imageView.setImageResource(imageArray[i]);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(500, 1200));
        textView.setText(instrumentos[i]);
        textView.setTextSize(20);
        textView.setPadding(0, 0, 0, 0);
        textView.setLayoutParams(new ViewGroup.LayoutParams(500, 1200));
        textView.setGravity(1);
        textView.setTextColor(0xFF000000);
        textView.setBackgroundColor(0xFF000000);
        textView.setAlpha(0.5f);
//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        v = inflater.inflate(R.layout.grid_item, null);
        return imageView;
//
//
//        // TODO Auto-generated method stub
//        View grid;
//        LayoutInflater inflater = (LayoutInflater) mContext
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        if (view == null) {
//            grid = new View(mContext);
//            grid = inflater.inflate(R.layout.grid_single, null);
//            TextView textView = grid.findViewById(R.id.grid_text);
//            ImageView imageView = grid.findViewById(R.id.grid_image);
//            textView.setText(instrumentos[i]);
//            imageView.setImageResource(imageArray[i]);
//        } else {
//            grid = (View) convertView;
//        }
//
//        return grid;
    }
}
