// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.internal;

import android.support.v4.content.ContextCompat;
import android.graphics.drawable.Drawable$ConstantState;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PointerIconCompat;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.design.R;
import android.util.AttributeSet;
import android.support.annotation.NonNull;
import android.content.Context;
import android.widget.TextView;
import android.support.v7.view.menu.MenuItemImpl;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.MenuView;
import android.widget.FrameLayout;

@RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
public class BottomNavigationItemView extends FrameLayout implements ItemView
{
    private static final int[] CHECKED_STATE_SET;
    public static final int INVALID_ITEM_POSITION = -1;
    private final int mDefaultMargin;
    private ImageView mIcon;
    private ColorStateList mIconTint;
    private MenuItemImpl mItemData;
    private int mItemPosition;
    private final TextView mLargeLabel;
    private final float mScaleDownFactor;
    private final float mScaleUpFactor;
    private final int mShiftAmount;
    private boolean mShiftingMode;
    private final TextView mSmallLabel;
    
    static {
        CHECKED_STATE_SET = new int[] { 16842912 };
    }
    
    public BottomNavigationItemView(@NonNull final Context context) {
        this(context, null);
    }
    
    public BottomNavigationItemView(@NonNull final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public BottomNavigationItemView(final Context context, final AttributeSet set, int dimensionPixelSize) {
        super(context, set, dimensionPixelSize);
        this.mItemPosition = -1;
        final Resources resources = this.getResources();
        dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_text_size);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_text_size);
        this.mDefaultMargin = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
        this.mShiftAmount = dimensionPixelSize - dimensionPixelSize2;
        this.mScaleUpFactor = dimensionPixelSize2 * 1.0f / dimensionPixelSize;
        this.mScaleDownFactor = dimensionPixelSize * 1.0f / dimensionPixelSize2;
        LayoutInflater.from(context).inflate(R.layout.design_bottom_navigation_item, (ViewGroup)this, true);
        this.setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
        this.mIcon = (ImageView)this.findViewById(R.id.icon);
        this.mSmallLabel = (TextView)this.findViewById(R.id.smallLabel);
        this.mLargeLabel = (TextView)this.findViewById(R.id.largeLabel);
    }
    
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }
    
    public int getItemPosition() {
        return this.mItemPosition;
    }
    
    public void initialize(final MenuItemImpl mItemData, final int n) {
        this.mItemData = mItemData;
        this.setCheckable(mItemData.isCheckable());
        this.setChecked(mItemData.isChecked());
        this.setEnabled(mItemData.isEnabled());
        this.setIcon(mItemData.getIcon());
        this.setTitle(mItemData.getTitle());
        this.setId(mItemData.getItemId());
    }
    
    public int[] onCreateDrawableState(final int n) {
        final int[] onCreateDrawableState = super.onCreateDrawableState(n + 1);
        if (this.mItemData != null && this.mItemData.isCheckable() && this.mItemData.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, BottomNavigationItemView.CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }
    
    public boolean prefersCondensedTitle() {
        return false;
    }
    
    public void setCheckable(final boolean b) {
        this.refreshDrawableState();
    }
    
    public void setChecked(final boolean b) {
        ViewCompat.setPivotX((View)this.mLargeLabel, (float)(this.mLargeLabel.getWidth() / 2));
        ViewCompat.setPivotY((View)this.mLargeLabel, (float)this.mLargeLabel.getBaseline());
        ViewCompat.setPivotX((View)this.mSmallLabel, (float)(this.mSmallLabel.getWidth() / 2));
        ViewCompat.setPivotY((View)this.mSmallLabel, (float)this.mSmallLabel.getBaseline());
        if (this.mShiftingMode) {
            if (b) {
                final FrameLayout$LayoutParams layoutParams = (FrameLayout$LayoutParams)this.mIcon.getLayoutParams();
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.mDefaultMargin;
                this.mIcon.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                this.mLargeLabel.setVisibility(0);
                ViewCompat.setScaleX((View)this.mLargeLabel, 1.0f);
                ViewCompat.setScaleY((View)this.mLargeLabel, 1.0f);
            }
            else {
                final FrameLayout$LayoutParams layoutParams2 = (FrameLayout$LayoutParams)this.mIcon.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.topMargin = this.mDefaultMargin;
                this.mIcon.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                this.mLargeLabel.setVisibility(4);
                ViewCompat.setScaleX((View)this.mLargeLabel, 0.5f);
                ViewCompat.setScaleY((View)this.mLargeLabel, 0.5f);
            }
            this.mSmallLabel.setVisibility(4);
        }
        else if (b) {
            final FrameLayout$LayoutParams layoutParams3 = (FrameLayout$LayoutParams)this.mIcon.getLayoutParams();
            layoutParams3.gravity = 49;
            layoutParams3.topMargin = this.mDefaultMargin + this.mShiftAmount;
            this.mIcon.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
            this.mLargeLabel.setVisibility(0);
            this.mSmallLabel.setVisibility(4);
            ViewCompat.setScaleX((View)this.mLargeLabel, 1.0f);
            ViewCompat.setScaleY((View)this.mLargeLabel, 1.0f);
            ViewCompat.setScaleX((View)this.mSmallLabel, this.mScaleUpFactor);
            ViewCompat.setScaleY((View)this.mSmallLabel, this.mScaleUpFactor);
        }
        else {
            final FrameLayout$LayoutParams layoutParams4 = (FrameLayout$LayoutParams)this.mIcon.getLayoutParams();
            layoutParams4.gravity = 49;
            layoutParams4.topMargin = this.mDefaultMargin;
            this.mIcon.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
            this.mLargeLabel.setVisibility(4);
            this.mSmallLabel.setVisibility(0);
            ViewCompat.setScaleX((View)this.mLargeLabel, this.mScaleDownFactor);
            ViewCompat.setScaleY((View)this.mLargeLabel, this.mScaleDownFactor);
            ViewCompat.setScaleX((View)this.mSmallLabel, 1.0f);
            ViewCompat.setScaleY((View)this.mSmallLabel, 1.0f);
        }
        this.refreshDrawableState();
    }
    
    public void setEnabled(final boolean b) {
        super.setEnabled(b);
        this.mSmallLabel.setEnabled(b);
        this.mLargeLabel.setEnabled(b);
        this.mIcon.setEnabled(b);
        if (b) {
            ViewCompat.setPointerIcon((View)this, PointerIconCompat.getSystemIcon(this.getContext(), 1002));
            return;
        }
        ViewCompat.setPointerIcon((View)this, null);
    }
    
    public void setIcon(Drawable drawable) {
        Drawable mutate = drawable;
        if (drawable != null) {
            final Drawable$ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            mutate = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(mutate, this.mIconTint);
        }
        this.mIcon.setImageDrawable(mutate);
    }
    
    public void setIconTintList(final ColorStateList mIconTint) {
        this.mIconTint = mIconTint;
        if (this.mItemData != null) {
            this.setIcon(this.mItemData.getIcon());
        }
    }
    
    public void setItemBackground(final int n) {
        Drawable drawable;
        if (n == 0) {
            drawable = null;
        }
        else {
            drawable = ContextCompat.getDrawable(this.getContext(), n);
        }
        ViewCompat.setBackground((View)this, drawable);
    }
    
    public void setItemPosition(final int mItemPosition) {
        this.mItemPosition = mItemPosition;
    }
    
    public void setShiftingMode(final boolean mShiftingMode) {
        this.mShiftingMode = mShiftingMode;
    }
    
    public void setShortcut(final boolean b, final char c) {
    }
    
    public void setTextColor(final ColorStateList list) {
        this.mSmallLabel.setTextColor(list);
        this.mLargeLabel.setTextColor(list);
    }
    
    public void setTitle(final CharSequence contentDescription) {
        this.mSmallLabel.setText(contentDescription);
        this.mLargeLabel.setText(contentDescription);
        this.setContentDescription(contentDescription);
    }
    
    public boolean showsIcon() {
        return true;
    }
}
