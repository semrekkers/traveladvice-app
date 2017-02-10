package com.semrekkers.traveladvice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
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

public class TravelAdviceArrayAdapter extends ArrayAdapter<TravelAdvice> {

    public TravelAdviceArrayAdapter(Context context, List<TravelAdvice> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TravelAdvice ta = getItem(position);

        ProfileItemViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ProfileItemViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.listview_item_profile, parent, false);
            viewHolder.profileImage = (ImageView) convertView.findViewById(R.id.profileImage);
            viewHolder.profileTitle = (TextView) convertView.findViewById(R.id.profileTitle);
            viewHolder.profileSubTitle = (TextView) convertView.findViewById(R.id.profileSubTitle);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ProfileItemViewHolder) convertView.getTag();
        }

        viewHolder.profileTitle.setText(ta.Location);
        viewHolder.profileSubTitle.setText(ta.Type);

        return convertView;
    }

    public static class ProfileItemViewHolder {
        ImageView profileImage;
        TextView profileTitle;
        TextView profileSubTitle;
    }
}
