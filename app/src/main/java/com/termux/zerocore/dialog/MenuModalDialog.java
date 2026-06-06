package com.termux.zerocore.dialog;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.termux.R;
import com.termux.zerocore.config.mainmenu.config.MainMenuClickConfig;
import com.termux.zerocore.config.mainmenu.view.adapter.MainMenuItemAdapter;

import java.util.ArrayList;

public class MenuModalDialog extends BaseDialogCentre {

    private String mTitle;
    private ArrayList<MainMenuClickConfig> mItems;
    private Runnable mOnDismissCallback;

    public MenuModalDialog(@NonNull Context context, String title, ArrayList<MainMenuClickConfig> items) {
        super(context);
        mTitle = title;
        mItems = items;
    }

    @Override
    void initViewDialog(View mView) {
        TextView titleView = mView.findViewById(R.id.modal_title);
        TextView closeView = mView.findViewById(R.id.modal_close);
        RecyclerView recyclerView = mView.findViewById(R.id.modal_recycler);

        titleView.setText(mTitle);
        closeView.setOnClickListener(v -> {
            if (mOnDismissCallback != null) {
                mOnDismissCallback.run();
            }
            dismiss();
        });

        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        int spacing = (int) (8 * mContext.getResources().getDisplayMetrics().density);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, spacing, false));
        MainMenuItemAdapter adapter = new MainMenuItemAdapter(mContext, mItems);
        recyclerView.setAdapter(adapter);
    }

    @Override
    int getContentView() {
        return R.layout.dialog_menu_modal;
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = (int) (mContext.getResources().getDisplayMetrics().widthPixels * 0.85);
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

    public void setOnDismissCallback(Runnable callback) {
        mOnDismissCallback = callback;
    }
}
