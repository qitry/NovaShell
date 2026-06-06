package com.termux.zerocore.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.termux.R;
import com.termux.zerocore.config.mainmenu.config.MainMenuClickConfig;
import com.termux.zerocore.config.mainmenu.view.adapter.MainMenuItemAdapter;

import java.util.ArrayList;

public class CategoryItemsDialog extends BaseDialogCentre {

    private String mCategoryTitle;
    private ArrayList<MainMenuClickConfig> mItems;

    public CategoryItemsDialog(@NonNull Context context, String categoryTitle, ArrayList<MainMenuClickConfig> items) {
        super(context);
        mCategoryTitle = categoryTitle;
        mItems = items;
    }

    @Override
    void initViewDialog(View mView) {
        TextView titleView = mView.findViewById(R.id.dialog_title);
        TextView closeView = mView.findViewById(R.id.dialog_close);
        RecyclerView recyclerView = mView.findViewById(R.id.dialog_recycler);

        titleView.setText(mCategoryTitle);
        closeView.setOnClickListener(v -> dismiss());

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        MainMenuItemAdapter adapter = new MainMenuItemAdapter(mContext, mItems);
        recyclerView.setAdapter(adapter);
    }

    @Override
    int getContentView() {
        return R.layout.dialog_category_items;
    }
}
