package com.termux.zerocore.config.mainmenu.view.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainMenuItemViewHolder extends RecyclerView.ViewHolder {
    public TextView mCodeTitle;
    public LinearLayout mItemlayout;

    public MainMenuItemViewHolder(@NonNull View itemView) {
        super(itemView);
        mCodeTitle = itemView.findViewById(R.id.code_title);
        mItemlayout = itemView.findViewById(R.id.item_layout);
    }
}
