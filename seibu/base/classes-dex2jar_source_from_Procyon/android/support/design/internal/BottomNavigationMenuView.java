// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.internal;

import android.view.View$MeasureSpec;
import android.support.v4.view.ViewCompat;
import android.support.annotation.Nullable;
import android.content.res.Resources;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.view.MenuItem;
import android.view.View;
import android.os.Build$VERSION;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View$OnClickListener;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v4.util.Pools;
import android.content.res.ColorStateList;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.MenuView;
import android.view.ViewGroup;

@RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
public class BottomNavigationMenuView extends ViewGroup implements MenuView
{
    private final int mActiveItemMaxWidth;
    private final BottomNavigationAnimationHelperBase mAnimationHelper;
    private BottomNavigationItemView[] mButtons;
    private final int mInactiveItemMaxWidth;
    private final int mInactiveItemMinWidth;
    private int mItemBackgroundRes;
    private final int mItemHeight;
    private ColorStateList mItemIconTint;
    private final Pools.Pool<BottomNavigationItemView> mItemPool;
    private ColorStateList mItemTextColor;
    private MenuBuilder mMenu;
    private final View$OnClickListener mOnClickListener;
    private BottomNavigationPresenter mPresenter;
    private int mSelectedItemId;
    private int mSelectedItemPosition;
    private boolean mShiftingMode;
    private int[] mTempChildWidths;
    
    public BottomNavigationMenuView(final Context context) {
        this(context, null);
    }
    
    public BottomNavigationMenuView(final Context context, final AttributeSet set) {
        super(context, set);
        this.mItemPool = new Pools.SynchronizedPool<BottomNavigationItemView>(5);
        this.mShiftingMode = true;
        this.mSelectedItemId = 0;
        this.mSelectedItemPosition = 0;
        final Resources resources = this.getResources();
        this.mInactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.mInactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.mActiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.mItemHeight = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        if (Build$VERSION.SDK_INT >= 14) {
            this.mAnimationHelper = new BottomNavigationAnimationHelperIcs();
        }
        else {
            this.mAnimationHelper = new BottomNavigationAnimationHelperBase();
        }
        this.mOnClickListener = (View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                final MenuItemImpl itemData = ((BottomNavigationItemView)view).getItemData();
                if (!BottomNavigationMenuView.this.mMenu.performItemAction((MenuItem)itemData, BottomNavigationMenuView.this.mPresenter, 0)) {
                    ((MenuItem)itemData).setChecked(true);
                }
            }
        };
        this.mTempChildWidths = new int[5];
    }
    
    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemView;
        if ((bottomNavigationItemView = this.mItemPool.acquire()) == null) {
            bottomNavigationItemView = new BottomNavigationItemView(this.getContext());
        }
        return bottomNavigationItemView;
    }
    
    public void buildMenuView() {
        this.removeAllViews();
        if (this.mButtons != null) {
            final BottomNavigationItemView[] mButtons = this.mButtons;
            for (int length = mButtons.length, i = 0; i < length; ++i) {
                this.mItemPool.release(mButtons[i]);
            }
        }
        if (this.mMenu.size() == 0) {
            this.mSelectedItemId = 0;
            this.mSelectedItemPosition = 0;
            this.mButtons = null;
            return;
        }
        this.mButtons = new BottomNavigationItemView[this.mMenu.size()];
        this.mShiftingMode = (this.mMenu.size() > 3);
        for (int j = 0; j < this.mMenu.size(); ++j) {
            this.mPresenter.setUpdateSuspended(true);
            this.mMenu.getItem(j).setCheckable(true);
            this.mPresenter.setUpdateSuspended(false);
            final BottomNavigationItemView newItem = this.getNewItem();
            (this.mButtons[j] = newItem).setIconTintList(this.mItemIconTint);
            newItem.setTextColor(this.mItemTextColor);
            newItem.setItemBackground(this.mItemBackgroundRes);
            newItem.setShiftingMode(this.mShiftingMode);
            newItem.initialize((MenuItemImpl)this.mMenu.getItem(j), 0);
            newItem.setItemPosition(j);
            newItem.setOnClickListener(this.mOnClickListener);
            this.addView((View)newItem);
        }
        this.mSelectedItemPosition = Math.min(this.mMenu.size() - 1, this.mSelectedItemPosition);
        this.mMenu.getItem(this.mSelectedItemPosition).setChecked(true);
    }
    
    @Nullable
    public ColorStateList getIconTintList() {
        return this.mItemIconTint;
    }
    
    public int getItemBackgroundRes() {
        return this.mItemBackgroundRes;
    }
    
    public ColorStateList getItemTextColor() {
        return this.mItemTextColor;
    }
    
    public int getSelectedItemId() {
        return this.mSelectedItemId;
    }
    
    public int getWindowAnimations() {
        return 0;
    }
    
    public void initialize(final MenuBuilder mMenu) {
        this.mMenu = mMenu;
    }
    
    protected void onLayout(final boolean b, int i, int n, int n2, int n3) {
        final int childCount = this.getChildCount();
        n2 -= i;
        n3 -= n;
        n = 0;
        View child;
        for (i = 0; i < childCount; ++i) {
            child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection((View)this) == 1) {
                    child.layout(n2 - n - child.getMeasuredWidth(), 0, n2 - n, n3);
                }
                else {
                    child.layout(n, 0, child.getMeasuredWidth() + n, n3);
                }
                n += child.getMeasuredWidth();
            }
        }
    }
    
    protected void onMeasure(int i, int size) {
        size = View$MeasureSpec.getSize(i);
        final int childCount = this.getChildCount();
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824);
        if (this.mShiftingMode) {
            i = childCount - 1;
            final int min = Math.min(size - this.mInactiveItemMinWidth * i, this.mActiveItemMaxWidth);
            final int min2 = Math.min((size - min) / i, this.mInactiveItemMaxWidth);
            size = size - min - min2 * i;
            int[] mTempChildWidths;
            int n;
            int n2;
            int[] mTempChildWidths2;
            for (i = 0; i < childCount; ++i, size = n2) {
                mTempChildWidths = this.mTempChildWidths;
                if (i == this.mSelectedItemPosition) {
                    n = min;
                }
                else {
                    n = min2;
                }
                mTempChildWidths[i] = n;
                n2 = size;
                if (size > 0) {
                    mTempChildWidths2 = this.mTempChildWidths;
                    ++mTempChildWidths2[i];
                    n2 = size - 1;
                }
            }
        }
        else {
            if (childCount == 0) {
                i = 1;
            }
            else {
                i = childCount;
            }
            final int min3 = Math.min(size / i, this.mActiveItemMaxWidth);
            size -= min3 * childCount;
            int n3;
            int[] mTempChildWidths3;
            for (i = 0; i < childCount; ++i, size = n3) {
                this.mTempChildWidths[i] = min3;
                if ((n3 = size) > 0) {
                    mTempChildWidths3 = this.mTempChildWidths;
                    ++mTempChildWidths3[i];
                    n3 = size - 1;
                }
            }
        }
        size = 0;
        View child;
        for (i = 0; i < childCount; ++i) {
            child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                child.measure(View$MeasureSpec.makeMeasureSpec(this.mTempChildWidths[i], 1073741824), measureSpec);
                child.getLayoutParams().width = child.getMeasuredWidth();
                size += child.getMeasuredWidth();
            }
        }
        this.setMeasuredDimension(ViewCompat.resolveSizeAndState(size, View$MeasureSpec.makeMeasureSpec(size, 1073741824), 0), ViewCompat.resolveSizeAndState(this.mItemHeight, measureSpec, 0));
    }
    
    public void setIconTintList(final ColorStateList list) {
        this.mItemIconTint = list;
        if (this.mButtons != null) {
            final BottomNavigationItemView[] mButtons = this.mButtons;
            for (int length = mButtons.length, i = 0; i < length; ++i) {
                mButtons[i].setIconTintList(list);
            }
        }
    }
    
    public void setItemBackgroundRes(final int n) {
        this.mItemBackgroundRes = n;
        if (this.mButtons != null) {
            final BottomNavigationItemView[] mButtons = this.mButtons;
            for (int length = mButtons.length, i = 0; i < length; ++i) {
                mButtons[i].setItemBackground(n);
            }
        }
    }
    
    public void setItemTextColor(final ColorStateList list) {
        this.mItemTextColor = list;
        if (this.mButtons != null) {
            final BottomNavigationItemView[] mButtons = this.mButtons;
            for (int length = mButtons.length, i = 0; i < length; ++i) {
                mButtons[i].setTextColor(list);
            }
        }
    }
    
    public void setPresenter(final BottomNavigationPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }
    
    void tryRestoreSelectedItemId(final int mSelectedItemId) {
        for (int size = this.mMenu.size(), i = 0; i < size; ++i) {
            final MenuItem item = this.mMenu.getItem(i);
            if (mSelectedItemId == item.getItemId()) {
                this.mSelectedItemId = mSelectedItemId;
                this.mSelectedItemPosition = i;
                item.setChecked(true);
                break;
            }
        }
    }
    
    public void updateMenuView() {
        final int size = this.mMenu.size();
        if (size != this.mButtons.length) {
            this.buildMenuView();
        }
        else {
            final int mSelectedItemId = this.mSelectedItemId;
            for (int i = 0; i < size; ++i) {
                final MenuItem item = this.mMenu.getItem(i);
                if (item.isChecked()) {
                    this.mSelectedItemId = item.getItemId();
                    this.mSelectedItemPosition = i;
                }
            }
            if (mSelectedItemId != this.mSelectedItemId) {
                this.mAnimationHelper.beginDelayedTransition(this);
            }
            for (int j = 0; j < size; ++j) {
                this.mPresenter.setUpdateSuspended(true);
                this.mButtons[j].initialize((MenuItemImpl)this.mMenu.getItem(j), 0);
                this.mPresenter.setUpdateSuspended(false);
            }
        }
    }
}
