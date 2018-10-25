package com.home.shimmerrecyclerdemo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import com.home.shimmerrecyclerdemo.xmlparse.entities.Result;

public class RecyclerViewResultAdapter extends RecyclerView.Adapter<RecyclerViewResultAdapter.ViewHolder> {


    private List<Result> results;

    public RecyclerViewResultAdapter(List<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = results.get(position);
        holder.bindItem(result);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void updateData(List<Result> results) {
        this.results.addAll(results);
        notifyDataSetChanged();
    }

    public void clearData() {
        final int size = results.size();
        results.clear();
        notifyDataSetChanged();
        //notifyItemRangeRemoved(0, size);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txvName;
        TextView txvAddress;
        TextView txvRating;
        ImageView igvPhotoItem;

        public ViewHolder(View itemView) {

            super(itemView);
            txvName = itemView.findViewById(R.id.txv_name);
            txvAddress = itemView.findViewById(R.id.txv_address);
            txvRating = itemView.findViewById(R.id.txv_rating);
            igvPhotoItem = itemView.findViewById(R.id.igv_photo_item);
        }

        public void bindItem(Result result) {
            txvName.setText(result.getName());
            //txvAddress.setText(result.getFormattedAddress());
            //txvDistance.setText((Helper.getDistanceFromMyLocation(result.getGeometry().getLocation())));
            if (result.getPhoto() != null) {
                //imageLoader.load(igvPhotoItem, Helper.generateUrl(result.getPhotos().get(0).getPhotoReference()));
                Glide.with(igvPhotoItem.getContext()).load(Helper.generateUrl(result.getPhoto().getPhotoReference())).into(igvPhotoItem);
            } else {
                Glide.with(igvPhotoItem.getContext())
                        .load(R.drawable.background_blur)
                        .into(igvPhotoItem);
            }

            if (result.getRating() != null) {
                txvRating.setText(String.format("%s", result.getRating()));
                txvRating.setBackgroundColor(Color.parseColor("#129067"));
            } else {
                txvRating.setText("--");
                txvRating.setBackgroundColor(Color.parseColor("#a8a8a8"));
            }
        }
    }
}
