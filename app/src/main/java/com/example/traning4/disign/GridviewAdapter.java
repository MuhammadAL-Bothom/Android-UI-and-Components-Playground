package com.example.traning4.disign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.traning4.R;
import com.example.traning4.modle.Models;

import java.util.List;

public class GridviewAdapter extends ArrayAdapter<Models> {

    public GridviewAdapter(@NonNull Context context, @NonNull List<Models> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HolderView holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.grid_view_list, parent, false);
            holder = new HolderView(convertView);
            convertView.setTag(holder);
        } else {
            holder = (HolderView) convertView.getTag();
        }

        Models model = getItem(position);
            holder.icons.setImageResource(model.getIconid());
            holder.names.setText(model.getName());


        return convertView;
    }

    private static class HolderView {
        private final ImageView icons;
        private final TextView names;

        public HolderView(View view) {
            icons = view.findViewById(R.id.icon_id);
            names = view.findViewById(R.id.name_id);
        }
    }
}
