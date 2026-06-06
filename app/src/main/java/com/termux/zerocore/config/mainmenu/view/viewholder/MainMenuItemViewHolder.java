package com.termux.zerocore.config.mainmenu.view.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.termux.R;

public class MainMenuItemViewHolder extends RecyclerView.ViewHolder {
    public TextView mCodeTitle;
    public ImageView mCodeIcon;
    public LinearLayout mItemlayout;

    public MainMenuItemViewHolder(@NonNull View itemView) {
        super(itemView);
        mCodeTitle = itemView.findViewById(R.id.code_title);
        mCodeIcon = itemView.findViewById(R.id.code_icon);
        mItemlayout = itemView.findViewById(R.id.item_layout);
    }
}
