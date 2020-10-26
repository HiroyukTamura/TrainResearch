// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import android.content.res.Resources;
import android.os.Build$VERSION;
import android.support.v4.widget.TextViewCompat;
import android.widget.Toast;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import android.annotation.TargetApi;
import android.support.v7.app.ActionBar;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.text.Layout;
import android.support.v4.view.PointerIconCompat;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View$OnLongClickListener;
import java.lang.ref.WeakReference;
import android.support.v7.content.res.AppCompatResources;
import android.support.annotation.DrawableRes;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.LinearLayout;
import android.support.annotation.RestrictTo;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.support.annotation.ColorInt;
import java.util.Iterator;
import android.view.View$MeasureSpec;
import android.view.ViewParent;
import android.support.annotation.Nullable;
import android.widget.LinearLayout$LayoutParams;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.support.annotation.NonNull;
import android.content.res.TypedArray;
import android.support.design.R;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import android.content.res.ColorStateList;
import java.util.ArrayList;
import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.util.Pools;
import android.support.v4.view.ViewPager;
import android.widget.HorizontalScrollView;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView
{
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    private static final int INVALID_WIDTH = -1;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> sTabPool;
    private AdapterChangeListener mAdapterChangeListener;
    private int mContentInsetStart;
    private OnTabSelectedListener mCurrentVpSelectedListener;
    int mMode;
    private TabLayoutOnPageChangeListener mPageChangeListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private final int mRequestedTabMaxWidth;
    private final int mRequestedTabMinWidth;
    private ValueAnimatorCompat mScrollAnimator;
    private final int mScrollableTabMinWidth;
    private OnTabSelectedListener mSelectedListener;
    private final ArrayList<OnTabSelectedListener> mSelectedListeners;
    private Tab mSelectedTab;
    private boolean mSetupViewPagerImplicitly;
    final int mTabBackgroundResId;
    int mTabGravity;
    int mTabMaxWidth;
    int mTabPaddingBottom;
    int mTabPaddingEnd;
    int mTabPaddingStart;
    int mTabPaddingTop;
    private final SlidingTabStrip mTabStrip;
    int mTabTextAppearance;
    ColorStateList mTabTextColors;
    float mTabTextMultiLineSize;
    float mTabTextSize;
    private final Pools.Pool<TabView> mTabViewPool;
    private final ArrayList<Tab> mTabs;
    ViewPager mViewPager;
    
    static {
        sTabPool = new Pools.SynchronizedPool<Tab>(16);
    }
    
    public TabLayout(final Context context) {
        this(context, null);
    }
    
    public TabLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public TabLayout(Context context, final AttributeSet set, int n) {
        super(context, set, n);
        this.mTabs = new ArrayList<Tab>();
        this.mTabMaxWidth = Integer.MAX_VALUE;
        this.mSelectedListeners = new ArrayList<OnTabSelectedListener>();
        this.mTabViewPool = new Pools.SimplePool<TabView>(12);
        ThemeUtils.checkAppCompatTheme(context);
        this.setHorizontalScrollBarEnabled(false);
        super.addView((View)(this.mTabStrip = new SlidingTabStrip(context)), 0, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -1));
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.TabLayout, n, R.style.Widget_Design_TabLayout);
        this.mTabStrip.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.mTabStrip.setSelectedIndicatorColor(obtainStyledAttributes.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.mTabPaddingBottom = n;
        this.mTabPaddingEnd = n;
        this.mTabPaddingTop = n;
        this.mTabPaddingStart = n;
        this.mTabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.mTabPaddingStart);
        this.mTabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
        this.mTabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
        this.mTabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
        this.mTabTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        context = (Context)context.obtainStyledAttributes(this.mTabTextAppearance, android.support.v7.appcompat.R.styleable.TextAppearance);
        try {
            this.mTabTextSize = (float)((TypedArray)context).getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.mTabTextColors = ((TypedArray)context).getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
            ((TypedArray)context).recycle();
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.mTabTextColors = obtainStyledAttributes.getColorStateList(R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                n = obtainStyledAttributes.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0);
                this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), n);
            }
            this.mRequestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.mRequestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.mTabBackgroundResId = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.mContentInsetStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.mMode = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabMode, 1);
            this.mTabGravity = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            context = (Context)this.getResources();
            this.mTabTextMultiLineSize = (float)((Resources)context).getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.mScrollableTabMinWidth = ((Resources)context).getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            this.applyModeAndGravity();
        }
        finally {
            ((TypedArray)context).recycle();
        }
    }
    
    private void addTabFromItemView(@NonNull final TabItem tabItem) {
        final Tab tab = this.newTab();
        if (tabItem.mText != null) {
            tab.setText(tabItem.mText);
        }
        if (tabItem.mIcon != null) {
            tab.setIcon(tabItem.mIcon);
        }
        if (tabItem.mCustomLayout != 0) {
            tab.setCustomView(tabItem.mCustomLayout);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            tab.setContentDescription(tabItem.getContentDescription());
        }
        this.addTab(tab);
    }
    
    private void addTabView(final Tab tab) {
        this.mTabStrip.addView((View)tab.mView, tab.getPosition(), (ViewGroup$LayoutParams)this.createLayoutParamsForTabs());
    }
    
    private void addViewInternal(final View view) {
        if (view instanceof TabItem) {
            this.addTabFromItemView((TabItem)view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }
    
    private void animateToTab(final int n) {
        if (n == -1) {
            return;
        }
        if (this.getWindowToken() == null || !ViewCompat.isLaidOut((View)this) || this.mTabStrip.childrenNeedLayout()) {
            this.setScrollPosition(n, 0.0f, true);
            return;
        }
        final int scrollX = this.getScrollX();
        final int calculateScrollXForTab = this.calculateScrollXForTab(n, 0.0f);
        if (scrollX != calculateScrollXForTab) {
            this.ensureScrollAnimator();
            this.mScrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
            this.mScrollAnimator.start();
        }
        this.mTabStrip.animateIndicatorToPosition(n, 300);
    }
    
    private void applyModeAndGravity() {
        int max = 0;
        if (this.mMode == 0) {
            max = Math.max(0, this.mContentInsetStart - this.mTabPaddingStart);
        }
        ViewCompat.setPaddingRelative((View)this.mTabStrip, max, 0, 0, 0);
        switch (this.mMode) {
            case 1: {
                this.mTabStrip.setGravity(1);
                break;
            }
            case 0: {
                this.mTabStrip.setGravity(8388611);
                break;
            }
        }
        this.updateTabViews(true);
    }
    
    private int calculateScrollXForTab(int width, final float n) {
        int width2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        final View child = this.mTabStrip.getChildAt(width);
        View child2;
        if (width + 1 < this.mTabStrip.getChildCount()) {
            child2 = this.mTabStrip.getChildAt(width + 1);
        }
        else {
            child2 = null;
        }
        if (child != null) {
            width = child.getWidth();
        }
        else {
            width = 0;
        }
        if (child2 != null) {
            width2 = child2.getWidth();
        }
        final int n2 = child.getLeft() + width / 2 - this.getWidth() / 2;
        width = (int)((width + width2) * 0.5f * n);
        if (ViewCompat.getLayoutDirection((View)this) == 0) {
            return n2 + width;
        }
        return n2 - width;
    }
    
    private void configureTab(final Tab element, int i) {
        element.setPosition(i);
        this.mTabs.add(i, element);
        int size;
        for (size = this.mTabs.size(), ++i; i < size; ++i) {
            this.mTabs.get(i).setPosition(i);
        }
    }
    
    private static ColorStateList createColorStateList(final int n, int n2) {
        final int[][] array = new int[2][];
        final int[] array2 = new int[2];
        array[0] = TabLayout.SELECTED_STATE_SET;
        array2[0] = n2;
        n2 = 0 + 1;
        array[n2] = TabLayout.EMPTY_STATE_SET;
        array2[n2] = n;
        return new ColorStateList(array, array2);
    }
    
    private LinearLayout$LayoutParams createLayoutParamsForTabs() {
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -1);
        this.updateTabViewLayoutParams(linearLayout$LayoutParams);
        return linearLayout$LayoutParams;
    }
    
    private TabView createTabView(@NonNull final Tab tab) {
        TabView tabView;
        if (this.mTabViewPool != null) {
            tabView = this.mTabViewPool.acquire();
        }
        else {
            tabView = null;
        }
        TabView tabView2 = tabView;
        if (tabView == null) {
            tabView2 = new TabView(this.getContext());
        }
        tabView2.setTab(tab);
        tabView2.setFocusable(true);
        tabView2.setMinimumWidth(this.getTabMinWidth());
        return tabView2;
    }
    
    private void dispatchTabReselected(@NonNull final Tab tab) {
        for (int i = this.mSelectedListeners.size() - 1; i >= 0; --i) {
            this.mSelectedListeners.get(i).onTabReselected(tab);
        }
    }
    
    private void dispatchTabSelected(@NonNull final Tab tab) {
        for (int i = this.mSelectedListeners.size() - 1; i >= 0; --i) {
            this.mSelectedListeners.get(i).onTabSelected(tab);
        }
    }
    
    private void dispatchTabUnselected(@NonNull final Tab tab) {
        for (int i = this.mSelectedListeners.size() - 1; i >= 0; --i) {
            this.mSelectedListeners.get(i).onTabUnselected(tab);
        }
    }
    
    private void ensureScrollAnimator() {
        if (this.mScrollAnimator == null) {
            (this.mScrollAnimator = ViewUtils.createAnimator()).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.mScrollAnimator.setDuration(300L);
            this.mScrollAnimator.addUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)new ValueAnimatorCompat.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                    TabLayout.this.scrollTo(valueAnimatorCompat.getAnimatedIntValue(), 0);
                }
            });
        }
    }
    
    private int getDefaultHeight() {
        final int n = 0;
        int index = 0;
        final int size = this.mTabs.size();
        int n2;
        while (true) {
            n2 = n;
            if (index >= size) {
                break;
            }
            final Tab tab = this.mTabs.get(index);
            if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                n2 = 1;
                break;
            }
            ++index;
        }
        if (n2 != 0) {
            return 72;
        }
        return 48;
    }
    
    private float getScrollPosition() {
        return this.mTabStrip.getIndicatorPosition();
    }
    
    private int getTabMinWidth() {
        if (this.mRequestedTabMinWidth != -1) {
            return this.mRequestedTabMinWidth;
        }
        if (this.mMode == 0) {
            return this.mScrollableTabMinWidth;
        }
        return 0;
    }
    
    private int getTabScrollRange() {
        return Math.max(0, this.mTabStrip.getWidth() - this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
    }
    
    private void removeTabViewAt(final int n) {
        final TabView tabView = (TabView)this.mTabStrip.getChildAt(n);
        this.mTabStrip.removeViewAt(n);
        if (tabView != null) {
            tabView.reset();
            this.mTabViewPool.release(tabView);
        }
        this.requestLayout();
    }
    
    private void setSelectedTabView(final int n) {
        final int childCount = this.mTabStrip.getChildCount();
        if (n < childCount) {
            for (int i = 0; i < childCount; ++i) {
                this.mTabStrip.getChildAt(i).setSelected(i == n);
            }
        }
    }
    
    private void setupWithViewPager(@Nullable final ViewPager mViewPager, final boolean autoRefresh, final boolean mSetupViewPagerImplicitly) {
        if (this.mViewPager != null) {
            if (this.mPageChangeListener != null) {
                this.mViewPager.removeOnPageChangeListener((ViewPager.OnPageChangeListener)this.mPageChangeListener);
            }
            if (this.mAdapterChangeListener != null) {
                this.mViewPager.removeOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)this.mAdapterChangeListener);
            }
        }
        if (this.mCurrentVpSelectedListener != null) {
            this.removeOnTabSelectedListener(this.mCurrentVpSelectedListener);
            this.mCurrentVpSelectedListener = null;
        }
        if (mViewPager != null) {
            this.mViewPager = mViewPager;
            if (this.mPageChangeListener == null) {
                this.mPageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.mPageChangeListener.reset();
            mViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.mPageChangeListener);
            this.addOnTabSelectedListener(this.mCurrentVpSelectedListener = (OnTabSelectedListener)new ViewPagerOnTabSelectedListener(mViewPager));
            final PagerAdapter adapter = mViewPager.getAdapter();
            if (adapter != null) {
                this.setPagerAdapter(adapter, autoRefresh);
            }
            if (this.mAdapterChangeListener == null) {
                this.mAdapterChangeListener = new AdapterChangeListener();
            }
            this.mAdapterChangeListener.setAutoRefresh(autoRefresh);
            mViewPager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)this.mAdapterChangeListener);
            this.setScrollPosition(mViewPager.getCurrentItem(), 0.0f, true);
        }
        else {
            this.mViewPager = null;
            this.setPagerAdapter(null, false);
        }
        this.mSetupViewPagerImplicitly = mSetupViewPagerImplicitly;
    }
    
    private void updateAllTabs() {
        for (int i = 0; i < this.mTabs.size(); ++i) {
            this.mTabs.get(i).updateView();
        }
    }
    
    private void updateTabViewLayoutParams(final LinearLayout$LayoutParams linearLayout$LayoutParams) {
        if (this.mMode == 1 && this.mTabGravity == 0) {
            linearLayout$LayoutParams.width = 0;
            linearLayout$LayoutParams.weight = 1.0f;
            return;
        }
        linearLayout$LayoutParams.width = -2;
        linearLayout$LayoutParams.weight = 0.0f;
    }
    
    public void addOnTabSelectedListener(@NonNull final OnTabSelectedListener onTabSelectedListener) {
        if (!this.mSelectedListeners.contains(onTabSelectedListener)) {
            this.mSelectedListeners.add(onTabSelectedListener);
        }
    }
    
    public void addTab(@NonNull final Tab tab) {
        this.addTab(tab, this.mTabs.isEmpty());
    }
    
    public void addTab(@NonNull final Tab tab, final int n) {
        this.addTab(tab, n, this.mTabs.isEmpty());
    }
    
    public void addTab(@NonNull final Tab tab, final int n, final boolean b) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        this.configureTab(tab, n);
        this.addTabView(tab);
        if (b) {
            tab.select();
        }
    }
    
    public void addTab(@NonNull final Tab tab, final boolean b) {
        this.addTab(tab, this.mTabs.size(), b);
    }
    
    public void addView(final View view) {
        this.addViewInternal(view);
    }
    
    public void addView(final View view, final int n) {
        this.addViewInternal(view);
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.addViewInternal(view);
    }
    
    public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.addViewInternal(view);
    }
    
    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }
    
    int dpToPx(final int n) {
        return Math.round(this.getResources().getDisplayMetrics().density * n);
    }
    
    public FrameLayout$LayoutParams generateLayoutParams(final AttributeSet set) {
        return this.generateDefaultLayoutParams();
    }
    
    public int getSelectedTabPosition() {
        if (this.mSelectedTab != null) {
            return this.mSelectedTab.getPosition();
        }
        return -1;
    }
    
    @Nullable
    public Tab getTabAt(final int index) {
        if (index < 0 || index >= this.getTabCount()) {
            return null;
        }
        return this.mTabs.get(index);
    }
    
    public int getTabCount() {
        return this.mTabs.size();
    }
    
    public int getTabGravity() {
        return this.mTabGravity;
    }
    
    int getTabMaxWidth() {
        return this.mTabMaxWidth;
    }
    
    public int getTabMode() {
        return this.mMode;
    }
    
    @Nullable
    public ColorStateList getTabTextColors() {
        return this.mTabTextColors;
    }
    
    @NonNull
    public Tab newTab() {
        Tab tab;
        if ((tab = TabLayout.sTabPool.acquire()) == null) {
            tab = new Tab();
        }
        tab.mParent = this;
        tab.mView = this.createTabView(tab);
        return tab;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager == null) {
            final ViewParent parent = this.getParent();
            if (parent instanceof ViewPager) {
                this.setupWithViewPager((ViewPager)parent, true, true);
            }
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mSetupViewPagerImplicitly) {
            this.setupWithViewPager(null);
            this.mSetupViewPagerImplicitly = false;
        }
    }
    
    protected void onMeasure(int childMeasureSpec, int n) {
        final int a = this.dpToPx(this.getDefaultHeight()) + this.getPaddingTop() + this.getPaddingBottom();
        switch (View$MeasureSpec.getMode(n)) {
            case Integer.MIN_VALUE: {
                n = View$MeasureSpec.makeMeasureSpec(Math.min(a, View$MeasureSpec.getSize(n)), 1073741824);
                break;
            }
            case 0: {
                n = View$MeasureSpec.makeMeasureSpec(a, 1073741824);
                break;
            }
        }
        final int size = View$MeasureSpec.getSize(childMeasureSpec);
        if (View$MeasureSpec.getMode(childMeasureSpec) != 0) {
            int mRequestedTabMaxWidth;
            if (this.mRequestedTabMaxWidth > 0) {
                mRequestedTabMaxWidth = this.mRequestedTabMaxWidth;
            }
            else {
                mRequestedTabMaxWidth = size - this.dpToPx(56);
            }
            this.mTabMaxWidth = mRequestedTabMaxWidth;
        }
        super.onMeasure(childMeasureSpec, n);
        if (this.getChildCount() == 1) {
            final View child = this.getChildAt(0);
            childMeasureSpec = 0;
            switch (this.mMode) {
                case 0: {
                    if (child.getMeasuredWidth() < this.getMeasuredWidth()) {
                        childMeasureSpec = 1;
                    }
                    else {
                        childMeasureSpec = 0;
                    }
                    break;
                }
                case 1: {
                    if (child.getMeasuredWidth() != this.getMeasuredWidth()) {
                        childMeasureSpec = 1;
                    }
                    else {
                        childMeasureSpec = 0;
                    }
                    break;
                }
            }
            if (childMeasureSpec != 0) {
                childMeasureSpec = getChildMeasureSpec(n, this.getPaddingTop() + this.getPaddingBottom(), child.getLayoutParams().height);
                child.measure(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), childMeasureSpec);
            }
        }
    }
    
    void populateFromPagerAdapter() {
        this.removeAllTabs();
        if (this.mPagerAdapter != null) {
            final int count = this.mPagerAdapter.getCount();
            for (int i = 0; i < count; ++i) {
                this.addTab(this.newTab().setText(this.mPagerAdapter.getPageTitle(i)), false);
            }
            if (this.mViewPager != null && count > 0) {
                final int currentItem = this.mViewPager.getCurrentItem();
                if (currentItem != this.getSelectedTabPosition() && currentItem < this.getTabCount()) {
                    this.selectTab(this.getTabAt(currentItem));
                }
            }
        }
    }
    
    public void removeAllTabs() {
        for (int i = this.mTabStrip.getChildCount() - 1; i >= 0; --i) {
            this.removeTabViewAt(i);
        }
        final Iterator<Tab> iterator = this.mTabs.iterator();
        while (iterator.hasNext()) {
            final Tab tab = iterator.next();
            iterator.remove();
            tab.reset();
            TabLayout.sTabPool.release(tab);
        }
        this.mSelectedTab = null;
    }
    
    public void removeOnTabSelectedListener(@NonNull final OnTabSelectedListener o) {
        this.mSelectedListeners.remove(o);
    }
    
    public void removeTab(final Tab tab) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        this.removeTabAt(tab.getPosition());
    }
    
    public void removeTabAt(final int index) {
        int position;
        if (this.mSelectedTab != null) {
            position = this.mSelectedTab.getPosition();
        }
        else {
            position = 0;
        }
        this.removeTabViewAt(index);
        final Tab tab = this.mTabs.remove(index);
        if (tab != null) {
            tab.reset();
            TabLayout.sTabPool.release(tab);
        }
        for (int size = this.mTabs.size(), i = index; i < size; ++i) {
            this.mTabs.get(i).setPosition(i);
        }
        if (position == index) {
            Tab tab2;
            if (this.mTabs.isEmpty()) {
                tab2 = null;
            }
            else {
                tab2 = this.mTabs.get(Math.max(0, index - 1));
            }
            this.selectTab(tab2);
        }
    }
    
    void selectTab(final Tab tab) {
        this.selectTab(tab, true);
    }
    
    void selectTab(final Tab mSelectedTab, final boolean b) {
        final Tab mSelectedTab2 = this.mSelectedTab;
        if (mSelectedTab2 == mSelectedTab) {
            if (mSelectedTab2 != null) {
                this.dispatchTabReselected(mSelectedTab);
                this.animateToTab(mSelectedTab.getPosition());
            }
        }
        else {
            int position;
            if (mSelectedTab != null) {
                position = mSelectedTab.getPosition();
            }
            else {
                position = -1;
            }
            if (b) {
                if ((mSelectedTab2 == null || mSelectedTab2.getPosition() == -1) && position != -1) {
                    this.setScrollPosition(position, 0.0f, true);
                }
                else {
                    this.animateToTab(position);
                }
                if (position != -1) {
                    this.setSelectedTabView(position);
                }
            }
            if (mSelectedTab2 != null) {
                this.dispatchTabUnselected(mSelectedTab2);
            }
            if ((this.mSelectedTab = mSelectedTab) != null) {
                this.dispatchTabSelected(mSelectedTab);
            }
        }
    }
    
    @Deprecated
    public void setOnTabSelectedListener(@Nullable final OnTabSelectedListener mSelectedListener) {
        if (this.mSelectedListener != null) {
            this.removeOnTabSelectedListener(this.mSelectedListener);
        }
        if ((this.mSelectedListener = mSelectedListener) != null) {
            this.addOnTabSelectedListener(mSelectedListener);
        }
    }
    
    void setPagerAdapter(@Nullable final PagerAdapter mPagerAdapter, final boolean b) {
        if (this.mPagerAdapter != null && this.mPagerAdapterObserver != null) {
            this.mPagerAdapter.unregisterDataSetObserver(this.mPagerAdapterObserver);
        }
        this.mPagerAdapter = mPagerAdapter;
        if (b && mPagerAdapter != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new PagerAdapterObserver();
            }
            mPagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        this.populateFromPagerAdapter();
    }
    
    void setScrollAnimatorListener(final ValueAnimatorCompat.AnimatorListener animatorListener) {
        this.ensureScrollAnimator();
        this.mScrollAnimator.addListener(animatorListener);
    }
    
    public void setScrollPosition(final int n, final float n2, final boolean b) {
        this.setScrollPosition(n, n2, b, true);
    }
    
    void setScrollPosition(final int n, final float n2, final boolean b, final boolean b2) {
        final int round = Math.round(n + n2);
        if (round >= 0 && round < this.mTabStrip.getChildCount()) {
            if (b2) {
                this.mTabStrip.setIndicatorPositionFromTabPosition(n, n2);
            }
            if (this.mScrollAnimator != null && this.mScrollAnimator.isRunning()) {
                this.mScrollAnimator.cancel();
            }
            this.scrollTo(this.calculateScrollXForTab(n, n2), 0);
            if (b) {
                this.setSelectedTabView(round);
            }
        }
    }
    
    public void setSelectedTabIndicatorColor(@ColorInt final int selectedIndicatorColor) {
        this.mTabStrip.setSelectedIndicatorColor(selectedIndicatorColor);
    }
    
    public void setSelectedTabIndicatorHeight(final int selectedIndicatorHeight) {
        this.mTabStrip.setSelectedIndicatorHeight(selectedIndicatorHeight);
    }
    
    public void setTabGravity(final int mTabGravity) {
        if (this.mTabGravity != mTabGravity) {
            this.mTabGravity = mTabGravity;
            this.applyModeAndGravity();
        }
    }
    
    public void setTabMode(final int mMode) {
        if (mMode != this.mMode) {
            this.mMode = mMode;
            this.applyModeAndGravity();
        }
    }
    
    public void setTabTextColors(final int n, final int n2) {
        this.setTabTextColors(createColorStateList(n, n2));
    }
    
    public void setTabTextColors(@Nullable final ColorStateList mTabTextColors) {
        if (this.mTabTextColors != mTabTextColors) {
            this.mTabTextColors = mTabTextColors;
            this.updateAllTabs();
        }
    }
    
    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable final PagerAdapter pagerAdapter) {
        this.setPagerAdapter(pagerAdapter, false);
    }
    
    public void setupWithViewPager(@Nullable final ViewPager viewPager) {
        this.setupWithViewPager(viewPager, true);
    }
    
    public void setupWithViewPager(@Nullable final ViewPager viewPager, final boolean b) {
        this.setupWithViewPager(viewPager, b, false);
    }
    
    public boolean shouldDelayChildPressedState() {
        return this.getTabScrollRange() > 0;
    }
    
    void updateTabViews(final boolean b) {
        for (int i = 0; i < this.mTabStrip.getChildCount(); ++i) {
            final View child = this.mTabStrip.getChildAt(i);
            child.setMinimumWidth(this.getTabMinWidth());
            this.updateTabViewLayoutParams((LinearLayout$LayoutParams)child.getLayoutParams());
            if (b) {
                child.requestLayout();
            }
        }
    }
    
    private class AdapterChangeListener implements OnAdapterChangeListener
    {
        private boolean mAutoRefresh;
        
        AdapterChangeListener() {
        }
        
        @Override
        public void onAdapterChanged(@NonNull final ViewPager viewPager, @Nullable final PagerAdapter pagerAdapter, @Nullable final PagerAdapter pagerAdapter2) {
            if (TabLayout.this.mViewPager == viewPager) {
                TabLayout.this.setPagerAdapter(pagerAdapter2, this.mAutoRefresh);
            }
        }
        
        void setAutoRefresh(final boolean mAutoRefresh) {
            this.mAutoRefresh = mAutoRefresh;
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    public @interface Mode {
    }
    
    public interface OnTabSelectedListener
    {
        void onTabReselected(final Tab p0);
        
        void onTabSelected(final Tab p0);
        
        void onTabUnselected(final Tab p0);
    }
    
    private class PagerAdapterObserver extends DataSetObserver
    {
        PagerAdapterObserver() {
        }
        
        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }
        
        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }
    
    private class SlidingTabStrip extends LinearLayout
    {
        private ValueAnimatorCompat mIndicatorAnimator;
        private int mIndicatorLeft;
        private int mIndicatorRight;
        private int mSelectedIndicatorHeight;
        private final Paint mSelectedIndicatorPaint;
        int mSelectedPosition;
        float mSelectionOffset;
        
        SlidingTabStrip(final Context context) {
            super(context);
            this.mSelectedPosition = -1;
            this.mIndicatorLeft = -1;
            this.mIndicatorRight = -1;
            this.setWillNotDraw(false);
            this.mSelectedIndicatorPaint = new Paint();
        }
        
        private void updateIndicatorPosition() {
            final View child = this.getChildAt(this.mSelectedPosition);
            int n;
            int n2;
            if (child != null && child.getWidth() > 0) {
                final int left = child.getLeft();
                final int right = child.getRight();
                n = left;
                n2 = right;
                if (this.mSelectionOffset > 0.0f) {
                    n = left;
                    n2 = right;
                    if (this.mSelectedPosition < this.getChildCount() - 1) {
                        final View child2 = this.getChildAt(this.mSelectedPosition + 1);
                        n = (int)(this.mSelectionOffset * child2.getLeft() + (1.0f - this.mSelectionOffset) * left);
                        n2 = (int)(this.mSelectionOffset * child2.getRight() + (1.0f - this.mSelectionOffset) * right);
                    }
                }
            }
            else {
                n2 = -1;
                n = -1;
            }
            this.setIndicatorPosition(n, n2);
        }
        
        void animateIndicatorToPosition(final int n, final int n2) {
            if (this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
            final boolean b = ViewCompat.getLayoutDirection((View)this) == 1;
            final View child = this.getChildAt(n);
            if (child == null) {
                this.updateIndicatorPosition();
            }
            else {
                final int left = child.getLeft();
                final int right = child.getRight();
                int mIndicatorLeft;
                int mIndicatorRight;
                if (Math.abs(n - this.mSelectedPosition) <= 1) {
                    mIndicatorLeft = this.mIndicatorLeft;
                    mIndicatorRight = this.mIndicatorRight;
                }
                else {
                    final int dpToPx = TabLayout.this.dpToPx(24);
                    if (n < this.mSelectedPosition) {
                        if (b) {
                            mIndicatorRight = (mIndicatorLeft = left - dpToPx);
                        }
                        else {
                            mIndicatorRight = (mIndicatorLeft = right + dpToPx);
                        }
                    }
                    else if (b) {
                        mIndicatorRight = (mIndicatorLeft = right + dpToPx);
                    }
                    else {
                        mIndicatorRight = (mIndicatorLeft = left - dpToPx);
                    }
                }
                if (mIndicatorLeft != left || mIndicatorRight != right) {
                    final ValueAnimatorCompat animator = ViewUtils.createAnimator();
                    (this.mIndicatorAnimator = animator).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                    animator.setDuration(n2);
                    animator.setFloatValues(0.0f, 1.0f);
                    animator.addUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)new ValueAnimatorCompat.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                            final float animatedFraction = valueAnimatorCompat.getAnimatedFraction();
                            SlidingTabStrip.this.setIndicatorPosition(AnimationUtils.lerp(mIndicatorLeft, left, animatedFraction), AnimationUtils.lerp(mIndicatorRight, right, animatedFraction));
                        }
                    });
                    animator.addListener((ValueAnimatorCompat.AnimatorListener)new ValueAnimatorCompat.AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(final ValueAnimatorCompat valueAnimatorCompat) {
                            SlidingTabStrip.this.mSelectedPosition = n;
                            SlidingTabStrip.this.mSelectionOffset = 0.0f;
                        }
                    });
                    animator.start();
                }
            }
        }
        
        boolean childrenNeedLayout() {
            for (int i = 0; i < this.getChildCount(); ++i) {
                if (this.getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }
        
        public void draw(final Canvas canvas) {
            super.draw(canvas);
            if (this.mIndicatorLeft >= 0 && this.mIndicatorRight > this.mIndicatorLeft) {
                canvas.drawRect((float)this.mIndicatorLeft, (float)(this.getHeight() - this.mSelectedIndicatorHeight), (float)this.mIndicatorRight, (float)this.getHeight(), this.mSelectedIndicatorPaint);
            }
        }
        
        float getIndicatorPosition() {
            return this.mSelectedPosition + this.mSelectionOffset;
        }
        
        protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
            super.onLayout(b, n, n2, n3, n4);
            if (this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
                this.animateIndicatorToPosition(this.mSelectedPosition, Math.round((1.0f - this.mIndicatorAnimator.getAnimatedFraction()) * this.mIndicatorAnimator.getDuration()));
                return;
            }
            this.updateIndicatorPosition();
        }
        
        protected void onMeasure(final int n, final int n2) {
            super.onMeasure(n, n2);
            if (View$MeasureSpec.getMode(n) == 1073741824 && TabLayout.this.mMode == 1 && TabLayout.this.mTabGravity == 1) {
                final int childCount = this.getChildCount();
                int n3 = 0;
                int max;
                for (int i = 0; i < childCount; ++i, n3 = max) {
                    final View child = this.getChildAt(i);
                    max = n3;
                    if (child.getVisibility() == 0) {
                        max = Math.max(n3, child.getMeasuredWidth());
                    }
                }
                if (n3 > 0) {
                    final int dpToPx = TabLayout.this.dpToPx(16);
                    int n4 = 0;
                    int n6;
                    if (n3 * childCount <= this.getMeasuredWidth() - dpToPx * 2) {
                        int n5 = 0;
                        while (true) {
                            n6 = n4;
                            if (n5 >= childCount) {
                                break;
                            }
                            final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)this.getChildAt(n5).getLayoutParams();
                            if (linearLayout$LayoutParams.width != n3 || linearLayout$LayoutParams.weight != 0.0f) {
                                linearLayout$LayoutParams.width = n3;
                                linearLayout$LayoutParams.weight = 0.0f;
                                n4 = 1;
                            }
                            ++n5;
                        }
                    }
                    else {
                        TabLayout.this.mTabGravity = 0;
                        TabLayout.this.updateTabViews(false);
                        n6 = 1;
                    }
                    if (n6 != 0) {
                        super.onMeasure(n, n2);
                    }
                }
            }
        }
        
        void setIndicatorPosition(final int mIndicatorLeft, final int mIndicatorRight) {
            if (mIndicatorLeft != this.mIndicatorLeft || mIndicatorRight != this.mIndicatorRight) {
                this.mIndicatorLeft = mIndicatorLeft;
                this.mIndicatorRight = mIndicatorRight;
                ViewCompat.postInvalidateOnAnimation((View)this);
            }
        }
        
        void setIndicatorPositionFromTabPosition(final int mSelectedPosition, final float mSelectionOffset) {
            if (this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
            this.mSelectedPosition = mSelectedPosition;
            this.mSelectionOffset = mSelectionOffset;
            this.updateIndicatorPosition();
        }
        
        void setSelectedIndicatorColor(final int color) {
            if (this.mSelectedIndicatorPaint.getColor() != color) {
                this.mSelectedIndicatorPaint.setColor(color);
                ViewCompat.postInvalidateOnAnimation((View)this);
            }
        }
        
        void setSelectedIndicatorHeight(final int mSelectedIndicatorHeight) {
            if (this.mSelectedIndicatorHeight != mSelectedIndicatorHeight) {
                this.mSelectedIndicatorHeight = mSelectedIndicatorHeight;
                ViewCompat.postInvalidateOnAnimation((View)this);
            }
        }
    }
    
    public static final class Tab
    {
        public static final int INVALID_POSITION = -1;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        TabLayout mParent;
        private int mPosition;
        private Object mTag;
        private CharSequence mText;
        TabView mView;
        
        Tab() {
            this.mPosition = -1;
        }
        
        @Nullable
        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }
        
        @Nullable
        public View getCustomView() {
            return this.mCustomView;
        }
        
        @Nullable
        public Drawable getIcon() {
            return this.mIcon;
        }
        
        public int getPosition() {
            return this.mPosition;
        }
        
        @Nullable
        public Object getTag() {
            return this.mTag;
        }
        
        @Nullable
        public CharSequence getText() {
            return this.mText;
        }
        
        public boolean isSelected() {
            if (this.mParent == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return this.mParent.getSelectedTabPosition() == this.mPosition;
        }
        
        void reset() {
            this.mParent = null;
            this.mView = null;
            this.mTag = null;
            this.mIcon = null;
            this.mText = null;
            this.mContentDesc = null;
            this.mPosition = -1;
            this.mCustomView = null;
        }
        
        public void select() {
            if (this.mParent == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.mParent.selectTab(this);
        }
        
        @NonNull
        public Tab setContentDescription(@StringRes final int n) {
            if (this.mParent == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return this.setContentDescription(this.mParent.getResources().getText(n));
        }
        
        @NonNull
        public Tab setContentDescription(@Nullable final CharSequence mContentDesc) {
            this.mContentDesc = mContentDesc;
            this.updateView();
            return this;
        }
        
        @NonNull
        public Tab setCustomView(@LayoutRes final int n) {
            return this.setCustomView(LayoutInflater.from(this.mView.getContext()).inflate(n, (ViewGroup)this.mView, false));
        }
        
        @NonNull
        public Tab setCustomView(@Nullable final View mCustomView) {
            this.mCustomView = mCustomView;
            this.updateView();
            return this;
        }
        
        @NonNull
        public Tab setIcon(@DrawableRes final int n) {
            if (this.mParent == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return this.setIcon(AppCompatResources.getDrawable(this.mParent.getContext(), n));
        }
        
        @NonNull
        public Tab setIcon(@Nullable final Drawable mIcon) {
            this.mIcon = mIcon;
            this.updateView();
            return this;
        }
        
        void setPosition(final int mPosition) {
            this.mPosition = mPosition;
        }
        
        @NonNull
        public Tab setTag(@Nullable final Object mTag) {
            this.mTag = mTag;
            return this;
        }
        
        @NonNull
        public Tab setText(@StringRes final int n) {
            if (this.mParent == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return this.setText(this.mParent.getResources().getText(n));
        }
        
        @NonNull
        public Tab setText(@Nullable final CharSequence mText) {
            this.mText = mText;
            this.updateView();
            return this;
        }
        
        void updateView() {
            if (this.mView != null) {
                this.mView.update();
            }
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    public @interface TabGravity {
    }
    
    public static class TabLayoutOnPageChangeListener implements OnPageChangeListener
    {
        private int mPreviousScrollState;
        private int mScrollState;
        private final WeakReference<TabLayout> mTabLayoutRef;
        
        public TabLayoutOnPageChangeListener(final TabLayout referent) {
            this.mTabLayoutRef = new WeakReference<TabLayout>(referent);
        }
        
        @Override
        public void onPageScrollStateChanged(final int mScrollState) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = mScrollState;
        }
        
        @Override
        public void onPageScrolled(final int n, final float n2, final int n3) {
            final TabLayout tabLayout = this.mTabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.setScrollPosition(n, n2, this.mScrollState != 2 || this.mPreviousScrollState == 1, this.mScrollState != 2 || this.mPreviousScrollState != 0);
            }
        }
        
        @Override
        public void onPageSelected(final int n) {
            final TabLayout tabLayout = this.mTabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != n && n < tabLayout.getTabCount()) {
                tabLayout.selectTab(tabLayout.getTabAt(n), this.mScrollState == 0 || (this.mScrollState == 2 && this.mPreviousScrollState == 0));
            }
        }
        
        void reset() {
            this.mScrollState = 0;
            this.mPreviousScrollState = 0;
        }
    }
    
    class TabView extends LinearLayout implements View$OnLongClickListener
    {
        private ImageView mCustomIconView;
        private TextView mCustomTextView;
        private View mCustomView;
        private int mDefaultMaxLines;
        private ImageView mIconView;
        private Tab mTab;
        private TextView mTextView;
        
        public TabView(final Context context) {
            super(context);
            this.mDefaultMaxLines = 2;
            if (TabLayout.this.mTabBackgroundResId != 0) {
                ViewCompat.setBackground((View)this, AppCompatResources.getDrawable(context, TabLayout.this.mTabBackgroundResId));
            }
            ViewCompat.setPaddingRelative((View)this, TabLayout.this.mTabPaddingStart, TabLayout.this.mTabPaddingTop, TabLayout.this.mTabPaddingEnd, TabLayout.this.mTabPaddingBottom);
            this.setGravity(17);
            this.setOrientation(1);
            this.setClickable(true);
            ViewCompat.setPointerIcon((View)this, PointerIconCompat.getSystemIcon(this.getContext(), 1002));
        }
        
        private float approximateLineWidth(final Layout layout, final int n, final float n2) {
            return layout.getLineWidth(n) * (n2 / layout.getPaint().getTextSize());
        }
        
        private void updateTextAndIcon(@Nullable final TextView textView, @Nullable final ImageView imageView) {
            Drawable icon;
            if (this.mTab != null) {
                icon = this.mTab.getIcon();
            }
            else {
                icon = null;
            }
            CharSequence text;
            if (this.mTab != null) {
                text = this.mTab.getText();
            }
            else {
                text = null;
            }
            CharSequence contentDescription;
            if (this.mTab != null) {
                contentDescription = this.mTab.getContentDescription();
            }
            else {
                contentDescription = null;
            }
            if (imageView != null) {
                if (icon != null) {
                    imageView.setImageDrawable(icon);
                    imageView.setVisibility(0);
                    this.setVisibility(0);
                }
                else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable)null);
                }
                imageView.setContentDescription(contentDescription);
            }
            boolean b;
            if (!TextUtils.isEmpty(text)) {
                b = true;
            }
            else {
                b = false;
            }
            if (textView != null) {
                if (b) {
                    textView.setText(text);
                    textView.setVisibility(0);
                    this.setVisibility(0);
                }
                else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence)null);
                }
                textView.setContentDescription(contentDescription);
            }
            if (imageView != null) {
                final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)imageView.getLayoutParams();
                int dpToPx;
                final int n = dpToPx = 0;
                if (b) {
                    dpToPx = n;
                    if (imageView.getVisibility() == 0) {
                        dpToPx = TabLayout.this.dpToPx(8);
                    }
                }
                if (dpToPx != viewGroup$MarginLayoutParams.bottomMargin) {
                    viewGroup$MarginLayoutParams.bottomMargin = dpToPx;
                    imageView.requestLayout();
                }
            }
            if (!b && !TextUtils.isEmpty(contentDescription)) {
                this.setOnLongClickListener((View$OnLongClickListener)this);
                return;
            }
            this.setOnLongClickListener((View$OnLongClickListener)null);
            this.setLongClickable(false);
        }
        
        public Tab getTab() {
            return this.mTab;
        }
        
        @TargetApi(14)
        public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)ActionBar.Tab.class.getName());
        }
        
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName((CharSequence)ActionBar.Tab.class.getName());
        }
        
        public boolean onLongClick(final View view) {
            final int[] array = new int[2];
            final Rect rect = new Rect();
            this.getLocationOnScreen(array);
            this.getWindowVisibleDisplayFrame(rect);
            final Context context = this.getContext();
            final int width = this.getWidth();
            final int height = this.getHeight();
            final int n = array[1];
            final int n2 = height / 2;
            int n3 = array[0] + width / 2;
            if (ViewCompat.getLayoutDirection(view) == 0) {
                n3 = context.getResources().getDisplayMetrics().widthPixels - n3;
            }
            final Toast text = Toast.makeText(context, this.mTab.getContentDescription(), 0);
            if (n + n2 < rect.height()) {
                text.setGravity(8388661, n3, array[1] + height - rect.top);
            }
            else {
                text.setGravity(81, 0, height);
            }
            text.show();
            return true;
        }
        
        public void onMeasure(int measureSpec, final int n) {
            final int size = View$MeasureSpec.getSize(measureSpec);
            final int mode = View$MeasureSpec.getMode(measureSpec);
            final int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                measureSpec = View$MeasureSpec.makeMeasureSpec(TabLayout.this.mTabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(measureSpec, n);
            if (this.mTextView != null) {
                this.getResources();
                final float mTabTextSize = TabLayout.this.mTabTextSize;
                final int mDefaultMaxLines = this.mDefaultMaxLines;
                int maxLines;
                float mTabTextMultiLineSize;
                if (this.mIconView != null && this.mIconView.getVisibility() == 0) {
                    maxLines = 1;
                    mTabTextMultiLineSize = mTabTextSize;
                }
                else {
                    maxLines = mDefaultMaxLines;
                    mTabTextMultiLineSize = mTabTextSize;
                    if (this.mTextView != null) {
                        maxLines = mDefaultMaxLines;
                        mTabTextMultiLineSize = mTabTextSize;
                        if (this.mTextView.getLineCount() > 1) {
                            mTabTextMultiLineSize = TabLayout.this.mTabTextMultiLineSize;
                            maxLines = mDefaultMaxLines;
                        }
                    }
                }
                final float textSize = this.mTextView.getTextSize();
                final int lineCount = this.mTextView.getLineCount();
                final int maxLines2 = TextViewCompat.getMaxLines(this.mTextView);
                if (mTabTextMultiLineSize != textSize || (maxLines2 >= 0 && maxLines != maxLines2)) {
                    int n3;
                    final int n2 = n3 = 1;
                    Label_0241: {
                        if (TabLayout.this.mMode == 1) {
                            n3 = n2;
                            if (mTabTextMultiLineSize > textSize) {
                                n3 = n2;
                                if (lineCount == 1) {
                                    final Layout layout = this.mTextView.getLayout();
                                    if (layout != null) {
                                        n3 = n2;
                                        if (this.approximateLineWidth(layout, 0, mTabTextMultiLineSize) <= this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()) {
                                            break Label_0241;
                                        }
                                    }
                                    n3 = 0;
                                }
                            }
                        }
                    }
                    if (n3 != 0) {
                        this.mTextView.setTextSize(0, mTabTextMultiLineSize);
                        this.mTextView.setMaxLines(maxLines);
                        super.onMeasure(measureSpec, n);
                    }
                }
            }
        }
        
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.mTab != null) {
                if (!performClick) {
                    this.playSoundEffect(0);
                }
                this.mTab.select();
                performClick = true;
            }
            return performClick;
        }
        
        void reset() {
            this.setTab(null);
            this.setSelected(false);
        }
        
        public void setSelected(final boolean b) {
            boolean b2;
            if (this.isSelected() != b) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            super.setSelected(b);
            if (b2 && b && Build$VERSION.SDK_INT < 16) {
                this.sendAccessibilityEvent(4);
            }
            if (this.mTextView != null) {
                this.mTextView.setSelected(b);
            }
            if (this.mIconView != null) {
                this.mIconView.setSelected(b);
            }
            if (this.mCustomView != null) {
                this.mCustomView.setSelected(b);
            }
        }
        
        void setTab(@Nullable final Tab mTab) {
            if (mTab != this.mTab) {
                this.mTab = mTab;
                this.update();
            }
        }
        
        final void update() {
            final Tab mTab = this.mTab;
            View customView;
            if (mTab != null) {
                customView = mTab.getCustomView();
            }
            else {
                customView = null;
            }
            if (customView != null) {
                final ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup)parent).removeView(customView);
                    }
                    this.addView(customView);
                }
                this.mCustomView = customView;
                if (this.mTextView != null) {
                    this.mTextView.setVisibility(8);
                }
                if (this.mIconView != null) {
                    this.mIconView.setVisibility(8);
                    this.mIconView.setImageDrawable((Drawable)null);
                }
                this.mCustomTextView = (TextView)customView.findViewById(16908308);
                if (this.mCustomTextView != null) {
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mCustomTextView);
                }
                this.mCustomIconView = (ImageView)customView.findViewById(16908294);
            }
            else {
                if (this.mCustomView != null) {
                    this.removeView(this.mCustomView);
                    this.mCustomView = null;
                }
                this.mCustomTextView = null;
                this.mCustomIconView = null;
            }
            if (this.mCustomView == null) {
                if (this.mIconView == null) {
                    final ImageView mIconView = (ImageView)LayoutInflater.from(this.getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup)this, false);
                    this.addView((View)mIconView, 0);
                    this.mIconView = mIconView;
                }
                if (this.mTextView == null) {
                    final TextView mTextView = (TextView)LayoutInflater.from(this.getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup)this, false);
                    this.addView((View)mTextView);
                    this.mTextView = mTextView;
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mTextView);
                }
                TextViewCompat.setTextAppearance(this.mTextView, TabLayout.this.mTabTextAppearance);
                if (TabLayout.this.mTabTextColors != null) {
                    this.mTextView.setTextColor(TabLayout.this.mTabTextColors);
                }
                this.updateTextAndIcon(this.mTextView, this.mIconView);
            }
            else if (this.mCustomTextView != null || this.mCustomIconView != null) {
                this.updateTextAndIcon(this.mCustomTextView, this.mCustomIconView);
            }
            this.setSelected(mTab != null && mTab.isSelected());
        }
    }
    
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener
    {
        private final ViewPager mViewPager;
        
        public ViewPagerOnTabSelectedListener(final ViewPager mViewPager) {
            this.mViewPager = mViewPager;
        }
        
        @Override
        public void onTabReselected(final Tab tab) {
        }
        
        @Override
        public void onTabSelected(final Tab tab) {
            this.mViewPager.setCurrentItem(tab.getPosition());
        }
        
        @Override
        public void onTabUnselected(final Tab tab) {
        }
    }
}
