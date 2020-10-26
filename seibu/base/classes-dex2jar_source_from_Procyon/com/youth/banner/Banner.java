// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner;

import android.view.View$OnClickListener;
import java.util.Collection;
import android.view.MotionEvent;
import android.widget.RelativeLayout$LayoutParams;
import android.support.v4.view.PagerAdapter;
import java.lang.reflect.Field;
import android.util.Log;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.res.TypedArray;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.ImageView$ScaleType;
import java.util.ArrayList;
import android.util.AttributeSet;
import com.youth.banner.view.BannerViewPager;
import com.youth.banner.listener.OnBannerListener;
import android.widget.LinearLayout;
import android.view.View;
import java.util.List;
import com.youth.banner.loader.ImageLoaderInterface;
import android.util.DisplayMetrics;
import android.content.Context;
import android.widget.TextView;
import com.youth.banner.listener.OnBannerClickListener;
import android.widget.ImageView;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;

public class Banner extends FrameLayout implements OnPageChangeListener
{
    private BannerPagerAdapter adapter;
    private int bannerBackgroundImage;
    private ImageView bannerDefaultImage;
    private OnBannerClickListener bannerListener;
    private int bannerStyle;
    private TextView bannerTitle;
    private Context context;
    private int count;
    private int currentItem;
    private int delayTime;
    private DisplayMetrics dm;
    private int gravity;
    private WeakHandler handler;
    private ImageLoaderInterface imageLoader;
    private List imageUrls;
    private List<View> imageViews;
    private LinearLayout indicator;
    private List<ImageView> indicatorImages;
    private LinearLayout indicatorInside;
    private int indicatorSize;
    private boolean isAutoPlay;
    private boolean isScroll;
    private int lastPosition;
    private OnBannerListener listener;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mIndicatorSelectedResId;
    private int mIndicatorUnselectedResId;
    private int mIndicatorWidth;
    private int mLayoutResId;
    private OnPageChangeListener mOnPageChangeListener;
    private BannerScroller mScroller;
    private TextView numIndicator;
    private TextView numIndicatorInside;
    private int scaleType;
    private int scrollTime;
    public String tag;
    private final Runnable task;
    private int titleBackground;
    private int titleHeight;
    private int titleTextColor;
    private int titleTextSize;
    private LinearLayout titleView;
    private List<String> titles;
    private BannerViewPager viewPager;
    
    public Banner(final Context context) {
        this(context, null);
    }
    
    public Banner(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public Banner(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.tag = "banner";
        this.mIndicatorMargin = 5;
        this.bannerStyle = 1;
        this.delayTime = 2000;
        this.scrollTime = 800;
        this.isAutoPlay = true;
        this.isScroll = true;
        this.mIndicatorSelectedResId = R.drawable.gray_radius;
        this.mIndicatorUnselectedResId = R.drawable.white_radius;
        this.mLayoutResId = R.layout.banner;
        this.count = 0;
        this.gravity = -1;
        this.lastPosition = 1;
        this.scaleType = 1;
        this.handler = new WeakHandler();
        this.task = new Runnable() {
            @Override
            public void run() {
                if (Banner.this.count > 1 && Banner.this.isAutoPlay) {
                    Banner.this.currentItem = Banner.this.currentItem % (Banner.this.count + 1) + 1;
                    if (Banner.this.currentItem != 1) {
                        Banner.this.viewPager.setCurrentItem(Banner.this.currentItem);
                        Banner.this.handler.postDelayed(Banner.this.task, Banner.this.delayTime);
                        return;
                    }
                    Banner.this.viewPager.setCurrentItem(Banner.this.currentItem, false);
                    Banner.this.handler.post(Banner.this.task);
                }
            }
        };
        this.context = context;
        this.titles = new ArrayList<String>();
        this.imageUrls = new ArrayList();
        this.imageViews = new ArrayList<View>();
        this.indicatorImages = new ArrayList<ImageView>();
        this.dm = context.getResources().getDisplayMetrics();
        this.indicatorSize = this.dm.widthPixels / 80;
        this.initView(context, set);
    }
    
    private void createIndicator() {
        this.indicatorImages.clear();
        this.indicator.removeAllViews();
        this.indicatorInside.removeAllViews();
        for (int i = 0; i < this.count; ++i) {
            final ImageView imageView = new ImageView(this.context);
            imageView.setScaleType(ImageView$ScaleType.CENTER_CROP);
            final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(this.mIndicatorWidth, this.mIndicatorHeight);
            linearLayout$LayoutParams.leftMargin = this.mIndicatorMargin;
            linearLayout$LayoutParams.rightMargin = this.mIndicatorMargin;
            if (i == 0) {
                imageView.setImageResource(this.mIndicatorSelectedResId);
            }
            else {
                imageView.setImageResource(this.mIndicatorUnselectedResId);
            }
            this.indicatorImages.add(imageView);
            if (this.bannerStyle == 1 || this.bannerStyle == 4) {
                this.indicator.addView((View)imageView, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
            }
            else if (this.bannerStyle == 5) {
                this.indicatorInside.addView((View)imageView, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
            }
        }
    }
    
    private void handleTypedArray(final Context context, final AttributeSet set) {
        if (set == null) {
            return;
        }
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.Banner);
        this.mIndicatorWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_width, this.indicatorSize);
        this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_height, this.indicatorSize);
        this.mIndicatorMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_margin, 5);
        this.mIndicatorSelectedResId = obtainStyledAttributes.getResourceId(R.styleable.Banner_indicator_drawable_selected, R.drawable.gray_radius);
        this.mIndicatorUnselectedResId = obtainStyledAttributes.getResourceId(R.styleable.Banner_indicator_drawable_unselected, R.drawable.white_radius);
        this.scaleType = obtainStyledAttributes.getInt(R.styleable.Banner_image_scale_type, this.scaleType);
        this.delayTime = obtainStyledAttributes.getInt(R.styleable.Banner_delay_time, 2000);
        this.scrollTime = obtainStyledAttributes.getInt(R.styleable.Banner_scroll_time, 800);
        this.isAutoPlay = obtainStyledAttributes.getBoolean(R.styleable.Banner_is_auto_play, true);
        this.titleBackground = obtainStyledAttributes.getColor(R.styleable.Banner_title_background, -1);
        this.titleHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_title_height, -1);
        this.titleTextColor = obtainStyledAttributes.getColor(R.styleable.Banner_title_textcolor, -1);
        this.titleTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_title_textsize, -1);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(R.styleable.Banner_banner_layout, this.mLayoutResId);
        this.bannerBackgroundImage = obtainStyledAttributes.getResourceId(R.styleable.Banner_banner_default_image, R.drawable.no_banner);
        obtainStyledAttributes.recycle();
    }
    
    private void initImages() {
        this.imageViews.clear();
        if (this.bannerStyle == 1 || this.bannerStyle == 4 || this.bannerStyle == 5) {
            this.createIndicator();
        }
        else {
            if (this.bannerStyle == 3) {
                this.numIndicatorInside.setText((CharSequence)("1/" + this.count));
                return;
            }
            if (this.bannerStyle == 2) {
                this.numIndicator.setText((CharSequence)("1/" + this.count));
            }
        }
    }
    
    private void initView(final Context context, final AttributeSet set) {
        this.imageViews.clear();
        this.handleTypedArray(context, set);
        final View inflate = LayoutInflater.from(context).inflate(this.mLayoutResId, (ViewGroup)this, true);
        this.bannerDefaultImage = (ImageView)inflate.findViewById(R.id.bannerDefaultImage);
        this.viewPager = (BannerViewPager)inflate.findViewById(R.id.bannerViewPager);
        this.titleView = (LinearLayout)inflate.findViewById(R.id.titleView);
        this.indicator = (LinearLayout)inflate.findViewById(R.id.circleIndicator);
        this.indicatorInside = (LinearLayout)inflate.findViewById(R.id.indicatorInside);
        this.bannerTitle = (TextView)inflate.findViewById(R.id.bannerTitle);
        this.numIndicator = (TextView)inflate.findViewById(R.id.numIndicator);
        this.numIndicatorInside = (TextView)inflate.findViewById(R.id.numIndicatorInside);
        this.bannerDefaultImage.setImageResource(this.bannerBackgroundImage);
        this.initViewPagerScroll();
    }
    
    private void initViewPagerScroll() {
        try {
            final Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            (this.mScroller = new BannerScroller(this.viewPager.getContext())).setDuration(this.scrollTime);
            declaredField.set(this.viewPager, this.mScroller);
        }
        catch (Exception ex) {
            Log.e(this.tag, ex.getMessage());
        }
    }
    
    private void setBannerStyleUI() {
        int visibility;
        if (this.count > 1) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        switch (this.bannerStyle) {
            default: {}
            case 1: {
                this.indicator.setVisibility(visibility);
            }
            case 2: {
                this.numIndicator.setVisibility(visibility);
            }
            case 3: {
                this.numIndicatorInside.setVisibility(visibility);
                this.setTitleStyleUI();
            }
            case 4: {
                this.indicator.setVisibility(visibility);
                this.setTitleStyleUI();
            }
            case 5: {
                this.indicatorInside.setVisibility(visibility);
                this.setTitleStyleUI();
            }
        }
    }
    
    private void setData() {
        this.currentItem = 1;
        if (this.adapter == null) {
            this.adapter = new BannerPagerAdapter();
            this.viewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)this);
        }
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.setFocusable(true);
        this.viewPager.setCurrentItem(1);
        if (this.gravity != -1) {
            this.indicator.setGravity(this.gravity);
        }
        if (this.isScroll && this.count > 1) {
            this.viewPager.setScrollable(true);
        }
        else {
            this.viewPager.setScrollable(false);
        }
        if (this.isAutoPlay) {
            this.startAutoPlay();
        }
    }
    
    private void setImageList(final List<?> list) {
        if (list == null || list.size() <= 0) {
            this.bannerDefaultImage.setVisibility(0);
            Log.e(this.tag, "The image data set is empty.");
        }
        else {
            this.bannerDefaultImage.setVisibility(8);
            this.initImages();
            for (int i = 0; i <= this.count + 1; ++i) {
                View imageView = null;
                if (this.imageLoader != null) {
                    imageView = this.imageLoader.createImageView(this.context);
                }
                Object scaleType;
                if ((scaleType = imageView) == null) {
                    scaleType = new ImageView(this.context);
                }
                this.setScaleType((View)scaleType);
                Object o;
                if (i == 0) {
                    o = list.get(this.count - 1);
                }
                else if (i == this.count + 1) {
                    o = list.get(0);
                }
                else {
                    o = list.get(i - 1);
                }
                this.imageViews.add((View)scaleType);
                if (this.imageLoader != null) {
                    this.imageLoader.displayImage(this.context, o, (View)scaleType);
                }
                else {
                    Log.e(this.tag, "Please set images loader.");
                }
            }
        }
    }
    
    private void setScaleType(final View view) {
        if (view instanceof ImageView) {
            final ImageView imageView = (ImageView)view;
            switch (this.scaleType) {
                case 0: {
                    imageView.setScaleType(ImageView$ScaleType.CENTER);
                }
                case 1: {
                    imageView.setScaleType(ImageView$ScaleType.CENTER_CROP);
                }
                case 2: {
                    imageView.setScaleType(ImageView$ScaleType.CENTER_INSIDE);
                }
                case 3: {
                    imageView.setScaleType(ImageView$ScaleType.FIT_CENTER);
                }
                case 4: {
                    imageView.setScaleType(ImageView$ScaleType.FIT_END);
                }
                case 5: {
                    imageView.setScaleType(ImageView$ScaleType.FIT_START);
                }
                case 6: {
                    imageView.setScaleType(ImageView$ScaleType.FIT_XY);
                }
                case 7: {
                    imageView.setScaleType(ImageView$ScaleType.MATRIX);
                }
            }
        }
    }
    
    private void setTitleStyleUI() {
        if (this.titles.size() != this.imageUrls.size()) {
            throw new RuntimeException("[Banner] --> The number of titles and images is different");
        }
        if (this.titleBackground != -1) {
            this.titleView.setBackgroundColor(this.titleBackground);
        }
        if (this.titleHeight != -1) {
            this.titleView.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, this.titleHeight));
        }
        if (this.titleTextColor != -1) {
            this.bannerTitle.setTextColor(this.titleTextColor);
        }
        if (this.titleTextSize != -1) {
            this.bannerTitle.setTextSize(0, (float)this.titleTextSize);
        }
        if (this.titles != null && this.titles.size() > 0) {
            this.bannerTitle.setText((CharSequence)this.titles.get(0));
            this.bannerTitle.setVisibility(0);
            this.titleView.setVisibility(0);
        }
    }
    
    public boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        if (this.isAutoPlay) {
            final int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                this.startAutoPlay();
            }
            else if (action == 0) {
                this.stopAutoPlay();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
    
    public Banner isAutoPlay(final boolean isAutoPlay) {
        this.isAutoPlay = isAutoPlay;
        return this;
    }
    
    public void onPageScrollStateChanged(final int n) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(n);
        }
        switch (n) {
            case 0: {
                if (this.currentItem == 0) {
                    this.viewPager.setCurrentItem(this.count, false);
                    return;
                }
                if (this.currentItem == this.count + 1) {
                    this.viewPager.setCurrentItem(1, false);
                    return;
                }
                break;
            }
            case 1: {
                if (this.currentItem == this.count + 1) {
                    this.viewPager.setCurrentItem(1, false);
                    return;
                }
                if (this.currentItem == 0) {
                    this.viewPager.setCurrentItem(this.count, false);
                    return;
                }
                break;
            }
        }
    }
    
    public void onPageScrolled(final int n, final float n2, final int n3) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(this.toRealPosition(n), n2, n3);
        }
    }
    
    public void onPageSelected(int n) {
        this.currentItem = n;
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(this.toRealPosition(n));
        }
        if (this.bannerStyle == 1 || this.bannerStyle == 4 || this.bannerStyle == 5) {
            this.indicatorImages.get((this.lastPosition - 1 + this.count) % this.count).setImageResource(this.mIndicatorUnselectedResId);
            this.indicatorImages.get((n - 1 + this.count) % this.count).setImageResource(this.mIndicatorSelectedResId);
            this.lastPosition = n;
        }
        int count;
        if ((count = n) == 0) {
            count = this.count;
        }
        if ((n = count) > this.count) {
            n = 1;
        }
        switch (this.bannerStyle) {
            default: {}
            case 2: {
                this.numIndicator.setText((CharSequence)(n + "/" + this.count));
            }
            case 3: {
                this.numIndicatorInside.setText((CharSequence)(n + "/" + this.count));
                this.bannerTitle.setText((CharSequence)this.titles.get(n - 1));
            }
            case 4: {
                this.bannerTitle.setText((CharSequence)this.titles.get(n - 1));
            }
            case 5: {
                this.bannerTitle.setText((CharSequence)this.titles.get(n - 1));
            }
        }
    }
    
    public void releaseBanner() {
        this.handler.removeCallbacksAndMessages(null);
    }
    
    public Banner setBannerAnimation(final Class<? extends PageTransformer> clazz) {
        try {
            this.setPageTransformer(true, (PageTransformer)clazz.newInstance());
            return this;
        }
        catch (Exception ex) {
            Log.e(this.tag, "Please set the PageTransformer class");
            return this;
        }
    }
    
    public Banner setBannerStyle(final int bannerStyle) {
        this.bannerStyle = bannerStyle;
        return this;
    }
    
    public Banner setBannerTitles(final List<String> titles) {
        this.titles = titles;
        return this;
    }
    
    public Banner setDelayTime(final int delayTime) {
        this.delayTime = delayTime;
        return this;
    }
    
    public Banner setImageLoader(final ImageLoaderInterface imageLoader) {
        this.imageLoader = imageLoader;
        return this;
    }
    
    public Banner setImages(final List<?> imageUrls) {
        this.imageUrls = imageUrls;
        this.count = imageUrls.size();
        return this;
    }
    
    public Banner setIndicatorGravity(final int n) {
        switch (n) {
            default: {
                return this;
            }
            case 5: {
                this.gravity = 19;
                return this;
            }
            case 6: {
                this.gravity = 17;
                return this;
            }
            case 7: {
                this.gravity = 21;
                return this;
            }
        }
    }
    
    public Banner setOffscreenPageLimit(final int offscreenPageLimit) {
        if (this.viewPager != null) {
            this.viewPager.setOffscreenPageLimit(offscreenPageLimit);
        }
        return this;
    }
    
    @Deprecated
    public Banner setOnBannerClickListener(final OnBannerClickListener bannerListener) {
        this.bannerListener = bannerListener;
        return this;
    }
    
    public Banner setOnBannerListener(final OnBannerListener listener) {
        this.listener = listener;
        return this;
    }
    
    public void setOnPageChangeListener(final OnPageChangeListener mOnPageChangeListener) {
        this.mOnPageChangeListener = mOnPageChangeListener;
    }
    
    public Banner setPageTransformer(final boolean b, final PageTransformer pageTransformer) {
        this.viewPager.setPageTransformer(b, pageTransformer);
        return this;
    }
    
    public Banner setViewPagerIsScroll(final boolean isScroll) {
        this.isScroll = isScroll;
        return this;
    }
    
    public Banner start() {
        this.setBannerStyleUI();
        this.setImageList(this.imageUrls);
        this.setData();
        return this;
    }
    
    public void startAutoPlay() {
        this.handler.removeCallbacks(this.task);
        this.handler.postDelayed(this.task, this.delayTime);
    }
    
    public void stopAutoPlay() {
        this.handler.removeCallbacks(this.task);
    }
    
    public int toRealPosition(int n) {
        final int n2 = n = (n - 1) % this.count;
        if (n2 < 0) {
            n = n2 + this.count;
        }
        return n;
    }
    
    public void update(final List<?> list) {
        this.imageUrls.clear();
        this.imageViews.clear();
        this.indicatorImages.clear();
        this.imageUrls.addAll(list);
        this.count = this.imageUrls.size();
        this.start();
    }
    
    public void update(final List<?> list, final List<String> list2) {
        this.titles.clear();
        this.titles.addAll(list2);
        this.update(list);
    }
    
    public void updateBannerStyle(final int bannerStyle) {
        this.indicator.setVisibility(8);
        this.numIndicator.setVisibility(8);
        this.numIndicatorInside.setVisibility(8);
        this.indicatorInside.setVisibility(8);
        this.bannerTitle.setVisibility(8);
        this.titleView.setVisibility(8);
        this.bannerStyle = bannerStyle;
        this.start();
    }
    
    class BannerPagerAdapter extends PagerAdapter
    {
        @Override
        public void destroyItem(final ViewGroup viewGroup, final int n, final Object o) {
            viewGroup.removeView((View)o);
        }
        
        @Override
        public int getCount() {
            return Banner.this.imageViews.size();
        }
        
        @Override
        public Object instantiateItem(final ViewGroup viewGroup, final int n) {
            viewGroup.addView((View)Banner.this.imageViews.get(n));
            final View view = Banner.this.imageViews.get(n);
            if (Banner.this.bannerListener != null) {
                view.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                    public void onClick(final View view) {
                        Log.e(Banner.this.tag, "\u4f60\u6b63\u5728\u4f7f\u7528\u65e7\u7248\u70b9\u51fb\u4e8b\u4ef6\u63a5\u53e3\uff0c\u4e0b\u6807\u662f\u4ece1\u5f00\u59cb\uff0c\u4e3a\u4e86\u4f53\u9a8c\u8bf7\u66f4\u6362\u4e3asetOnBannerListener\uff0c\u4e0b\u6807\u4ece0\u5f00\u59cb\u8ba1\u7b97");
                        Banner.this.bannerListener.OnBannerClick(n);
                    }
                });
            }
            if (Banner.this.listener != null) {
                view.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                    public void onClick(final View view) {
                        Banner.this.listener.OnBannerClick(Banner.this.toRealPosition(n));
                    }
                });
            }
            return view;
        }
        
        @Override
        public boolean isViewFromObject(final View view, final Object o) {
            return view == o;
        }
    }
}
