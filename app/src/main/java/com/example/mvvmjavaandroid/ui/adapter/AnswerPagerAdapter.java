package com.example.mvvmjavaandroid.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmjavaandroid.R;
import com.example.mvvmjavaandroid.model.api.pojo.Item;

public class AnswerPagerAdapter extends PagedListAdapter<Item, AnswerPagerAdapter.PagerViewHolder> {

    private Context mContext;

    public AnswerPagerAdapter(Context context) {
        super(DIFF_CALL_BACK);
        mContext = context;
    }

    @NonNull
    @Override
    public PagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method could be used but due unavailability of inflater param, not being used
//        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);

        //this is another method of inflating layout in adapter
//        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        layoutInflater.inflate(R.layout.row_user, null, false);

        //one more way to do it
//        ((Activity)mContext).getLayoutInflater().inflate()

        View view = LayoutInflater.from(mContext).inflate(R.layout.row_user, null, false);
        return new PagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerViewHolder holder, int position) {
        Item item = getItem(position);

        if (item != null) {
            holder.textView.setText(item.owner.display_name);
            Glide.with(mContext)
                    .load(item.owner.profile_image)
                    .into(holder.imageView);
        } else {
            Toast.makeText(mContext, "Item is null", Toast.LENGTH_LONG).show();
        }
    }

    class PagerViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    private static DiffUtil.ItemCallback<Item> DIFF_CALL_BACK = new DiffUtil.ItemCallback<Item>() {
        @Override
        public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return (oldItem.answer_id == newItem.answer_id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.equals(newItem);
        }
    };
}
