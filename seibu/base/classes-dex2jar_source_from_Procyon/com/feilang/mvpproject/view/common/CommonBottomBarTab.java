// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.view.common;

import android.text.TextUtils;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import com.feilang.mvpproject.R;
import android.util.TypedValue;
import android.util.AttributeSet;
import android.support.annotation.DrawableRes;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.content.Context;
import android.widget.FrameLayout;

public class CommonBottomBarTab extends FrameLayout
{
    private static int mChildOrientation;
    private static int mIconSelectColor;
    private static int mIconUnSelectColor;
    private static boolean mNoIcon;
    private static boolean mNoTitle;
    private static int mTitleSelectColor;
    private static int mTitleUnSelectColor;
    private Context mContext;
    private ImageView mIcon;
    private LinearLayout mLContainer;
    private int mSelectIcon;
    private int mTabPosition;
    private TextView mTvTitle;
    private TextView mTvUnreadCount;
    private int mUnSelectIcon;
    
    public CommonBottomBarTab(final Context context, @DrawableRes final int mSelectIcon, @DrawableRes final int mUnSelectIcon, final CharSequence charSequence) {
        this(context, null, mUnSelectIcon, charSequence);
        this.mSelectIcon = mSelectIcon;
        this.mUnSelectIcon = mUnSelectIcon;
    }
    
    public CommonBottomBarTab(final Context context, @DrawableRes final int n, final CharSequence charSequence) {
        this(context, null, n, charSequence);
    }
    
    public CommonBottomBarTab(final Context context, final AttributeSet set, final int n, final int n2, final CharSequence charSequence) {
        super(context, set, n);
        this.mTabPosition = -1;
        this.init(context, n2, charSequence);
    }
    
    public CommonBottomBarTab(final Context context, final AttributeSet set, final int n, final CharSequence charSequence) {
        this(context, set, 0, n, charSequence);
    }
    
    private int dip2px(final Context context, final float n) {
        return (int)TypedValue.applyDimension(1, n, context.getResources().getDisplayMetrics());
    }
    
    private void init(final Context mContext, int dip2px, final CharSequence text) {
        this.mContext = mContext;
        final TypedArray obtainStyledAttributes = mContext.obtainStyledAttributes(new int[] { R.attr.selectableItemBackgroundBorderless });
        this.setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        obtainStyledAttributes.recycle();
        (this.mLContainer = new LinearLayout(mContext)).setOrientation(1);
        this.mLContainer.setGravity(17);
        final FrameLayout$LayoutParams layoutParams = new FrameLayout$LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mLContainer.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.mIcon = new ImageView(mContext);
        final int n = (int)TypedValue.applyDimension(1, 27.0f, this.getResources().getDisplayMetrics());
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(n, n);
        this.mIcon.setImageResource(dip2px);
        this.mIcon.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        this.mIcon.setColorFilter(CommonBottomBarTab.mIconUnSelectColor);
        this.mLContainer.addView((View)this.mIcon);
        (this.mTvTitle = new TextView(mContext)).setText(text);
        this.mTvTitle.getPaint().setFakeBoldText(true);
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-2, -2);
        layoutParams3.topMargin = (int)TypedValue.applyDimension(1, 2.0f, this.getResources().getDisplayMetrics());
        this.mTvTitle.setTextSize(1, 10.0f);
        this.mTvTitle.setTextColor(CommonBottomBarTab.mTitleUnSelectColor);
        this.mTvTitle.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        this.mLContainer.addView((View)this.mTvTitle);
        this.addView((View)this.mLContainer);
        dip2px = this.dip2px(mContext, 20.0f);
        final int dip2px2 = this.dip2px(mContext, 5.0f);
        (this.mTvUnreadCount = new TextView(mContext)).setBackgroundResource(R.drawable.textview_msg_bubble_bg);
        this.mTvUnreadCount.setMinWidth(dip2px);
        this.mTvUnreadCount.setTextColor(-1);
        this.mTvUnreadCount.setPadding(dip2px2, 0, dip2px2, 0);
        this.mTvUnreadCount.setGravity(17);
        final FrameLayout$LayoutParams layoutParams4 = new FrameLayout$LayoutParams(-2, dip2px);
        layoutParams4.gravity = 17;
        layoutParams4.leftMargin = this.dip2px(mContext, 17.0f);
        layoutParams4.bottomMargin = this.dip2px(mContext, 14.0f);
        this.mTvUnreadCount.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
        this.mTvUnreadCount.setVisibility(8);
        this.addView((View)this.mTvUnreadCount);
    }
    
    public int getTabPosition() {
        return this.mTabPosition;
    }
    
    public int getUnreadCount() {
        int intValue = 0;
        if (TextUtils.isEmpty((CharSequence)this.mTvUnreadCount.getText().toString())) {
            return 0;
        }
        if (this.mTvUnreadCount.getText().toString().equals("99+")) {
            return 99;
        }
        try {
            intValue = Integer.valueOf(this.mTvUnreadCount.getText().toString());
            return intValue;
        }
        catch (Exception ex) {
            return intValue;
        }
    }
    
    public void setChildOrientation(int n) {
        CommonBottomBarTab.mChildOrientation = n;
        this.mLContainer.setOrientation(n);
        if (n == 0) {
            n = (int)TypedValue.applyDimension(1, 27.0f, this.getResources().getDisplayMetrics());
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(n, n);
            layoutParams.rightMargin = this.dip2px(this.mContext, 3.0f);
            this.mIcon.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        }
    }
    
    public void setIconSelectColor(final int n) {
        CommonBottomBarTab.mIconSelectColor = n;
        this.mIcon.setColorFilter(n);
    }
    
    public void setIconUnSelectColor(final int n) {
        CommonBottomBarTab.mIconUnSelectColor = n;
        this.mIcon.setColorFilter(n);
    }
    
    public void setNoIcon(final boolean mNoIcon) {
        CommonBottomBarTab.mNoIcon = mNoIcon;
        final ImageView mIcon = this.mIcon;
        int visibility;
        if (mNoIcon) {
            visibility = 8;
        }
        else {
            visibility = 0;
        }
        mIcon.setVisibility(visibility);
    }
    
    public void setNoTitle(final boolean mNoTitle) {
        CommonBottomBarTab.mNoTitle = mNoTitle;
        final TextView mTvTitle = this.mTvTitle;
        int visibility;
        if (mNoTitle) {
            visibility = 8;
        }
        else {
            visibility = 0;
        }
        mTvTitle.setVisibility(visibility);
    }
    
    public void setSelected(final boolean selected) {
        super.setSelected(selected);
        if (this.mUnSelectIcon != 0) {
            final ImageView mIcon = this.mIcon;
            int imageResource;
            if (selected) {
                imageResource = this.mSelectIcon;
            }
            else {
                imageResource = this.mUnSelectIcon;
            }
            mIcon.setImageResource(imageResource);
        }
        else if (this.mIcon != null) {
            final ImageView mIcon2 = this.mIcon;
            int colorFilter;
            if (selected) {
                colorFilter = CommonBottomBarTab.mIconSelectColor;
            }
            else {
                colorFilter = CommonBottomBarTab.mIconUnSelectColor;
            }
            mIcon2.setColorFilter(colorFilter);
        }
        if (this.mTvTitle != null) {
            final TextView mTvTitle = this.mTvTitle;
            int textColor;
            if (selected) {
                textColor = CommonBottomBarTab.mTitleSelectColor;
            }
            else {
                textColor = CommonBottomBarTab.mTitleUnSelectColor;
            }
            mTvTitle.setTextColor(textColor);
        }
    }
    
    public void setTabPosition(final int mTabPosition) {
        this.mTabPosition = mTabPosition;
        if (mTabPosition == 0) {
            this.setSelected(true);
        }
    }
    
    public void setTitleSelectColor(final int n) {
        CommonBottomBarTab.mTitleSelectColor = n;
        this.mTvTitle.setTextColor(n);
    }
    
    public void setTitleUnSelectColor(final int n) {
        CommonBottomBarTab.mTitleUnSelectColor = n;
        this.mTvTitle.setTextColor(n);
    }
    
    public void setUnreadCount(final int i) {
        if (i <= 0) {
            this.mTvUnreadCount.setText((CharSequence)String.valueOf(0));
            this.mTvUnreadCount.setVisibility(8);
            return;
        }
        this.mTvUnreadCount.setVisibility(0);
        if (i > 99) {
            this.mTvUnreadCount.setText((CharSequence)"99+");
            return;
        }
        this.mTvUnreadCount.setText((CharSequence)String.valueOf(i));
    }
}
