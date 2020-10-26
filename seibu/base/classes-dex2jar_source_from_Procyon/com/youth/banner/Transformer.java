// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner;

import com.youth.banner.transformer.ZoomOutSlideTransformer;
import com.youth.banner.transformer.ZoomOutTranformer;
import com.youth.banner.transformer.ZoomInTransformer;
import com.youth.banner.transformer.TabletTransformer;
import com.youth.banner.transformer.StackTransformer;
import com.youth.banner.transformer.ScaleInOutTransformer;
import com.youth.banner.transformer.RotateUpTransformer;
import com.youth.banner.transformer.RotateDownTransformer;
import com.youth.banner.transformer.FlipVerticalTransformer;
import com.youth.banner.transformer.FlipHorizontalTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.CubeOutTransformer;
import com.youth.banner.transformer.CubeInTransformer;
import com.youth.banner.transformer.ForegroundToBackgroundTransformer;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;
import com.youth.banner.transformer.AccordionTransformer;
import com.youth.banner.transformer.DefaultTransformer;
import android.support.v4.view.ViewPager;

public class Transformer
{
    public static Class<? extends ViewPager.PageTransformer> Accordion;
    public static Class<? extends ViewPager.PageTransformer> BackgroundToForeground;
    public static Class<? extends ViewPager.PageTransformer> CubeIn;
    public static Class<? extends ViewPager.PageTransformer> CubeOut;
    public static Class<? extends ViewPager.PageTransformer> Default;
    public static Class<? extends ViewPager.PageTransformer> DepthPage;
    public static Class<? extends ViewPager.PageTransformer> FlipHorizontal;
    public static Class<? extends ViewPager.PageTransformer> FlipVertical;
    public static Class<? extends ViewPager.PageTransformer> ForegroundToBackground;
    public static Class<? extends ViewPager.PageTransformer> RotateDown;
    public static Class<? extends ViewPager.PageTransformer> RotateUp;
    public static Class<? extends ViewPager.PageTransformer> ScaleInOut;
    public static Class<? extends ViewPager.PageTransformer> Stack;
    public static Class<? extends ViewPager.PageTransformer> Tablet;
    public static Class<? extends ViewPager.PageTransformer> ZoomIn;
    public static Class<? extends ViewPager.PageTransformer> ZoomOut;
    public static Class<? extends ViewPager.PageTransformer> ZoomOutSlide;
    
    static {
        Transformer.Default = DefaultTransformer.class;
        Transformer.Accordion = AccordionTransformer.class;
        Transformer.BackgroundToForeground = BackgroundToForegroundTransformer.class;
        Transformer.ForegroundToBackground = ForegroundToBackgroundTransformer.class;
        Transformer.CubeIn = CubeInTransformer.class;
        Transformer.CubeOut = CubeOutTransformer.class;
        Transformer.DepthPage = DepthPageTransformer.class;
        Transformer.FlipHorizontal = FlipHorizontalTransformer.class;
        Transformer.FlipVertical = FlipVerticalTransformer.class;
        Transformer.RotateDown = RotateDownTransformer.class;
        Transformer.RotateUp = RotateUpTransformer.class;
        Transformer.ScaleInOut = ScaleInOutTransformer.class;
        Transformer.Stack = StackTransformer.class;
        Transformer.Tablet = TabletTransformer.class;
        Transformer.ZoomIn = ZoomInTransformer.class;
        Transformer.ZoomOut = ZoomOutTranformer.class;
        Transformer.ZoomOutSlide = ZoomOutSlideTransformer.class;
    }
}
