package com.semrekkers.traveladvice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sem Rekkers on 9-1-2017.
 */

public class ReisAdviesArrayAdapter extends ArrayAdapter<ReisAdviesItem> {

    public ReisAdviesArrayAdapter(Context context, List<ReisAdviesItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReisAdviesItem ta = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.listview_item_reis_advies, parent, false);
            viewHolder.locationTextView = (TextView) convertView.findViewById(R.id.locationTextView);
            viewHolder.lastModifiedTextView = (TextView) convertView.findViewById(R.id.lastModifiedTextView);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.locationTextView.setText(ta.Location);
        viewHolder.lastModifiedTextView.setText(ta.LastModified);

        return convertView;
    }

    public static class ViewHolder {
        TextView locationTextView;
        TextView lastModifiedTextView;
    }
}
