package com.example.intentfilepermission;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    public static final String TAG = ImageAdapter.class.getName();
    public LayoutInflater layoutInflater;
    private List<String> mUrls;

    public ImageAdapter(Context context, List<String> urls) {
        layoutInflater = LayoutInflater.from(context);
        this.mUrls = urls;
    }

    @Override
    @NonNull
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                              int viewType) {
        View view = layoutInflater.inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.bindData(mUrls.get(position));
    }

    @Override
    public int getItemCount() {
        return mUrls != null ? mUrls.size() : 0;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public ImageViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.image);
        }

        public void bindData(String url) {
            Log.d(TAG, url);
            Picasso.get().load(url).into(mImageView);
        }
    }
}
