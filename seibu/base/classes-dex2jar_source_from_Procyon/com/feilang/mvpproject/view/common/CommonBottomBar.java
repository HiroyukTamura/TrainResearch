// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.view.common;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.SupportActivity;
import android.os.Parcelable;
import android.view.View$OnClickListener;
import android.support.v4.view.ViewCompat;
import android.animation.TimeInterpolator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.view.ViewGroup$LayoutParams;
import com.feilang.mvpproject.util.LayoutUtils;
import android.view.View;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import com.feilang.mvpproject.R;
import java.util.ArrayList;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.util.AttributeSet;
import android.content.Context;
import java.util.List;
import android.widget.LinearLayout$LayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

public class CommonBottomBar extends LinearLayout
{
    private static final int TRANSLATE_DURATION_MILLIS = 200;
    private int mBarBackground;
    private int mChildOrientation;
    private int mCurrentPosition;
    private int mIconSelectColor;
    private int mIconUnSelectColor;
    private final Interpolator mInterpolator;
    private OnTabSelectedListener mListener;
    private boolean mNoIcon;
    private boolean mNoTitle;
    private LinearLayout mTabLayout;
    private LinearLayout$LayoutParams mTabParams;
    private List<CommonBottomBarTab> mTabs;
    private int mTitleSelectColor;
    private int mTitleUnSelectColor;
    private boolean mVisible;
    
    public CommonBottomBar(final Context context) {
        this(context, null);
    }
    
    public CommonBottomBar(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public CommonBottomBar(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mInterpolator = (Interpolator)new AccelerateDecelerateInterpolator();
        this.mVisible = true;
        this.mTabs = new ArrayList<CommonBottomBarTab>();
        this.mCurrentPosition = 0;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.CommonBottomBar, n, 0);
        this.mIconUnSelectColor = obtainStyledAttributes.getColor(R.styleable.CommonBottomBar_iconUnSelectColor, ContextCompat.getColor(context, R.color.tab_unselect));
        this.mIconSelectColor = obtainStyledAttributes.getColor(R.styleable.CommonBottomBar_iconSelectColor, ContextCompat.getColor(context, R.color.colorPrimary));
        this.mTitleUnSelectColor = obtainStyledAttributes.getColor(R.styleable.CommonBottomBar_titleUnSelectColor, ContextCompat.getColor(context, R.color.tab_text_unselected));
        this.mTitleSelectColor = obtainStyledAttributes.getColor(R.styleable.CommonBottomBar_titleSelectColor, ContextCompat.getColor(context, R.color.tab_text_selected));
        this.mBarBackground = obtainStyledAttributes.getColor(R.styleable.CommonBottomBar_barBackground, ContextCompat.getColor(context, R.color.white));
        this.mNoTitle = obtainStyledAttributes.getBoolean(R.styleable.CommonBottomBar_noTitle, false);
        this.mNoIcon = obtainStyledAttributes.getBoolean(R.styleable.CommonBottomBar_noIcon, false);
        this.mChildOrientation = obtainStyledAttributes.getInt(R.styleable.CommonBottomBar_childOrientation, 1);
        obtainStyledAttributes.recycle();
        this.init(context, set);
    }
    
    private void init(final Context context, final AttributeSet set) {
        this.setOrientation(1);
        final View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.bottom_bar_top_line_color));
        this.addView(view, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, LayoutUtils.dpToPx(context, 1.0f)));
        (this.mTabLayout = new LinearLayout(context)).setBackgroundColor(this.mBarBackground);
        this.mTabLayout.setOrientation(0);
        this.addView((View)this.mTabLayout, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -1));
        this.mTabParams = new LinearLayout$LayoutParams(0, -1);
        this.mTabParams.weight = 1.0f;
    }
    
    private void toggle(final boolean mVisible, final boolean b, final boolean b2) {
        if (this.mVisible != mVisible || b2) {
            this.mVisible = mVisible;
            int height = this.getHeight();
            if (height == 0 && !b2) {
                final ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)new ViewTreeObserver$OnPreDrawListener() {
                        public boolean onPreDraw() {
                            final ViewTreeObserver viewTreeObserver = CommonBottomBar.this.getViewTreeObserver();
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
                            }
                            CommonBottomBar.this.toggle(mVisible, b, true);
                            return true;
                        }
                    });
                    return;
                }
            }
            if (mVisible) {
                height = 0;
            }
            if (b) {
                this.animate().setInterpolator((TimeInterpolator)this.mInterpolator).setDuration(200L).translationY((float)height);
                return;
            }
            ViewCompat.setTranslationY((View)this, (float)height);
        }
    }
    
    public CommonBottomBar addItem(final CommonBottomBarTab commonBottomBarTab) {
        commonBottomBarTab.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                if (CommonBottomBar.this.mListener == null) {
                    return;
                }
                final int tabPosition = commonBottomBarTab.getTabPosition();
                if (CommonBottomBar.this.mCurrentPosition == tabPosition) {
                    CommonBottomBar.this.mListener.onTabReselected(tabPosition);
                    return;
                }
                CommonBottomBar.this.mListener.onTabSelected(tabPosition, CommonBottomBar.this.mCurrentPosition);
                commonBottomBarTab.setSelected(true);
                CommonBottomBar.this.mListener.onTabUnselected(CommonBottomBar.this.mCurrentPosition);
                CommonBottomBar.this.mTabs.get(CommonBottomBar.this.mCurrentPosition).setSelected(false);
                CommonBottomBar.this.mCurrentPosition = tabPosition;
            }
        });
        commonBottomBarTab.setTitleSelectColor(this.mTitleSelectColor);
        commonBottomBarTab.setTitleUnSelectColor(this.mTitleUnSelectColor);
        commonBottomBarTab.setNoIcon(this.mNoIcon);
        commonBottomBarTab.setNoTitle(this.mNoTitle);
        commonBottomBarTab.setChildOrientation(this.mChildOrientation);
        commonBottomBarTab.setTabPosition(this.mTabLayout.getChildCount());
        commonBottomBarTab.setLayoutParams((ViewGroup$LayoutParams)this.mTabParams);
        this.mTabLayout.addView((View)commonBottomBarTab);
        this.mTabs.add(commonBottomBarTab);
        return this;
    }
    
    public int getCurrentItemPosition() {
        return this.mCurrentPosition;
    }
    
    public CommonBottomBarTab getItem(final int n) {
        if (this.mTabs.size() < n) {
            return null;
        }
        return this.mTabs.get(n);
    }
    
    public void hide() {
        this.hide(true);
    }
    
    public void hide(final boolean b) {
        this.toggle(false, b, false);
    }
    
    public boolean isVisible() {
        return this.mVisible;
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.mCurrentPosition != savedState.position) {
            this.mTabLayout.getChildAt(this.mCurrentPosition).setSelected(false);
            this.mTabLayout.getChildAt(savedState.position).setSelected(true);
        }
        this.mCurrentPosition = savedState.position;
    }
    
    protected Parcelable onSaveInstanceState() {
        return (Parcelable)new SavedState(super.onSaveInstanceState(), this.mCurrentPosition);
    }
    
    public void setCurrentItem(final int n) {
        this.mTabLayout.post((Runnable)new Runnable() {
            @Override
            public void run() {
                CommonBottomBar.this.mTabLayout.getChildAt(n).performClick();
            }
        });
    }
    
    public void setData(final SupportActivity supportActivity, final SupportFragment[] onTabSelectedListener, final int[] array, final String[] array2) {
        for (int i = 0; i < array.length; ++i) {
            this.addItem(new CommonBottomBarTab((Context)supportActivity, array[i], array2[i]));
        }
        this.setOnTabSelectedListener(onTabSelectedListener);
    }
    
    public void setOnTabSelectedListener(final OnTabSelectedListener mListener) {
        this.mListener = mListener;
    }
    
    public void setOnTabSelectedListener(final SupportFragment[] array) {
        this.setOnTabSelectedListener((OnTabSelectedListener)new OnTabSelectedListener() {
            @Override
            public void onTabReselected(final int n) {
            }
            
            @Override
            public void onTabSelected(final int n, final int n2) {
                ((SupportActivity)array[n2].getActivity()).showHideFragment((ISupportFragment)array[n], (ISupportFragment)array[n2]);
            }
            
            @Override
            public void onTabUnselected(final int n) {
            }
        });
    }
    
    public void show() {
        this.show(true);
    }
    
    public void show(final boolean b) {
        this.toggle(true, b, false);
    }
    
    public interface OnTabSelectedListener
    {
        void onTabReselected(final int p0);
        
        void onTabSelected(final int p0, final int p1);
        
        void onTabUnselected(final int p0);
    }
    
    static class SavedState extends View$BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        private int position;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState createFromParcel(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] newArray(final int n) {
                    return new SavedState[n];
                }
            };
        }
        
        public SavedState(final Parcel parcel) {
            super(parcel);
            this.position = parcel.readInt();
        }
        
        public SavedState(final Parcelable parcelable, final int position) {
            super(parcelable);
            this.position = position;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.position);
        }
    }
}
