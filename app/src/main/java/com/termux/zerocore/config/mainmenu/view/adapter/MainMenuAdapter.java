package com.termux.zerocore.config.mainmenu.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.termux.R;
import com.termux.zerocore.config.mainmenu.data.MainMenuCategoryData;
import com.termux.zerocore.config.mainmenu.view.viewholder.MainMenuViewHolder;
import com.termux.zerocore.dialog.MenuModalDialog;

import java.util.ArrayList;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewHolder> {
    private Context mContext;
    private ArrayList<MainMenuCategoryData> mMainMenuCategoryData;

    public MainMenuAdapter(Context context, ArrayList<MainMenuCategoryData> mainMenuCategoryData) {
        mContext = context;
        mMainMenuCategoryData = mainMenuCategoryData;
    }

    @NonNull
    @Override
    public MainMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainMenuViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_menu_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewHolder holder, int position) {
        MainMenuCategoryData category = mMainMenuCategoryData.get(position);
        holder.mTitle.setText(category.mTitle);
        holder.itemView.setOnClickListener(v -> {
            MenuModalDialog dialog = new MenuModalDialog(mContext, category.mTitle, category.mClickArrayList);
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return mMainMenuCategoryData.size();
    }

    public void release() {
        mContext = null;
        for (int i = 0; i < mMainMenuCategoryData.size(); i++) {
            MainMenuCategoryData category = mMainMenuCategoryData.get(i);
            for (int j = 0; j < category.mClickArrayList.size(); j++) {
                category.mClickArrayList.get(j).release();
            }
        }
    }
}
