// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import android.widget.ImageView$ScaleType;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.Glide;
import android.widget.ImageView;
import android.view.ViewGroup$LayoutParams;
import android.widget.ListAdapter;
import android.widget.GridView;
import android.view.WindowManager$LayoutParams;
import android.view.Window;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.annotation.TargetApi;
import android.os.Build$VERSION;
import android.graphics.Point;
import android.util.TypedValue;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.app.Activity;
import android.view.OrientationEventListener;

public class LayoutUtils
{
    static boolean mFixedOrientation;
    static boolean mLandManual;
    static DIRECTION mLastOrientation;
    static OrientationEventListener mOrientListener;
    static boolean mPortManual;
    
    public static void addOnSoftKeyBoardVisibleListener(final Activity activity, final OnSoftKeyBoardVisibleListener onSoftKeyBoardVisibleListener) {
        final View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                final Rect rect = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect);
                onSoftKeyBoardVisibleListener.onSoftKeyBoardVisible((rect.bottom - rect.top) / (double)decorView.getHeight() < 0.8);
            }
        });
    }
    
    public static int dpToPx(final Context context, final float n) {
        return (int)(n * context.getResources().getDisplayMetrics().density + 0.5f);
    }
    
    public static float dpToPxWithFloat(final Context context, final float n) {
        return (float)(int)(n * context.getResources().getDisplayMetrics().density + 0.5f);
    }
    
    public static void fullscreen(final Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(getFullscreenUiFlags());
        activity.getWindow().addFlags(1280);
    }
    
    public static int getDefaultStatusBarHeight(final Context context) {
        int dimensionPixelSize = 0;
        final int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
        }
        int dpToPx;
        if ((dpToPx = dimensionPixelSize) == 0) {
            dpToPx = dpToPx(context, 24.0f);
        }
        return dpToPx;
    }
    
    public static int getDefaultToolbarHeight(final Context context) {
        final WindowManager windowManager = (WindowManager)context.getSystemService("window");
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int dpToPx;
        if ((dpToPx = (int)new TypedValue().getDimension(displayMetrics)) == 0) {
            dpToPx = dpToPx(context, 48.0f);
        }
        return dpToPx;
    }
    
    public static Point getFullScreenSize(final Context context) {
        final WindowManager windowManager = (WindowManager)context.getSystemService("window");
        final Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point;
    }
    
    @TargetApi(14)
    private static int getFullscreenUiFlags() {
        int n = 1;
        if (Build$VERSION.SDK_INT >= 16) {
            n = (0x1 | 0x404);
        }
        return n;
    }
    
    public static int getScreenWidth(final Context context) {
        final WindowManager windowManager = (WindowManager)context.getSystemService("window");
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
    
    public static void hideSoftInput(final Activity activity) {
        hideSoftInputInner(activity);
        AppEventBus.getInstance().post(activity.getSystemService("input_method"));
    }
    
    public static void hideSoftInputInner(final Activity activity) {
        final InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService("input_method");
        if (inputMethodManager.isActive() && activity.getCurrentFocus() != null) {
            final View currentFocus = activity.getCurrentFocus();
            if (currentFocus.getWindowToken() != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }
    
    public static void hideSoftInputInner(final Activity activity, final View view) {
        final InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService("input_method");
        if (inputMethodManager.isActive() && view != null && view.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    
    public static boolean isFullscreen(final Activity activity) {
        return (activity.getWindow().getAttributes().flags & 0x400) > 0;
    }
    
    public static boolean isLandscape(final Activity activity) {
        return activity.getRequestedOrientation() == 0 || activity.getResources().getConfiguration().orientation == 2;
    }
    
    public static boolean isPortrait(final Activity activity) {
        return activity.getRequestedOrientation() == 1 || activity.getResources().getConfiguration().orientation == 1;
    }
    
    public static boolean isShowingInput(final Activity activity) {
        final InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService("input_method");
        return activity.getCurrentFocus() != null && inputMethodManager.isActive();
    }
    
    public static boolean isShowingInputAtCurrentFocus(final Activity activity) {
        final InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService("input_method");
        final View currentFocus = activity.getCurrentFocus();
        return currentFocus != null && inputMethodManager.isActive(currentFocus);
    }
    
    public static boolean isTouchInView(final View view, final MotionEvent motionEvent) {
        final int[] array = new int[2];
        view.getLocationOnScreen(array);
        final int n = (int)motionEvent.getRawX();
        final int n2 = (int)motionEvent.getRawY();
        final int n3 = array[0];
        final int n4 = array[1];
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        return n2 >= n4 && n2 <= n4 + measuredHeight && n >= n3 && n <= n3 + measuredWidth;
    }
    
    public static void landscape(final Activity activity) {
        if (!isLandscape(activity)) {
            LayoutUtils.mLandManual = true;
            LayoutUtils.mPortManual = false;
            activity.setRequestedOrientation(0);
        }
        fullscreen(activity);
    }
    
    public static void normalscreen(final Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(0);
        activity.getWindow().clearFlags(1024);
    }
    
    public static void portrait(final Activity activity) {
        if (isLandscape(activity)) {
            LayoutUtils.mLandManual = false;
            LayoutUtils.mPortManual = true;
            activity.setRequestedOrientation(1);
        }
        normalscreen(activity);
    }
    
    public static int pxToDp(final Context context, final float n) {
        return (int)(n / context.getResources().getDisplayMetrics().density + 0.5f);
    }
    
    public static float pxToDpWithFloat(final Context context, final float n) {
        return (float)(int)(n / context.getResources().getDisplayMetrics().density + 0.5f);
    }
    
    public static int pxToSp(final Context context, final float n) {
        return (int)(n / context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }
    
    public static void setDialogMaxHeight(final Context context, final AlertDialog alertDialog, int n) {
        final Window window = alertDialog.getWindow();
        final WindowManager$LayoutParams attributes = window.getAttributes();
        window.getDecorView().measure(View$MeasureSpec.makeMeasureSpec(0, 0), View$MeasureSpec.makeMeasureSpec(0, 0));
        final int dpToPx = dpToPx(context, (float)n);
        n = 0;
        if (alertDialog.getListView().getAdapter().getCount() > 0) {
            final View view = alertDialog.getListView().getAdapter().getView(0, (View)null, (ViewGroup)alertDialog.getListView());
            view.measure(View$MeasureSpec.makeMeasureSpec(0, 0), View$MeasureSpec.makeMeasureSpec(0, 0));
            n = 0 + view.getMeasuredHeight() * alertDialog.getListView().getAdapter().getCount();
        }
        if (window.getDecorView().getMeasuredHeight() + n > dpToPx) {
            attributes.height = dpToPx;
        }
        alertDialog.getWindow().setAttributes(attributes);
    }
    
    public static void setGridViewHeightBasedOnChild(final GridView gridView, final Context context) {
        final ListAdapter adapter = gridView.getAdapter();
        if (adapter == null) {
            return;
        }
        int height = adapter.getCount() / 4 * getScreenWidth(context) / 4;
        if (adapter.getCount() % 4 > 0) {
            height += getScreenWidth(context) / 4;
        }
        final ViewGroup$LayoutParams layoutParams = gridView.getLayoutParams();
        layoutParams.height = height;
        gridView.setLayoutParams(layoutParams);
    }
    
    public static void setImageHeightByWidth(final Context context, final String s, final ImageView imageView) {
        Glide.with(context).load(s).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(final Exception ex, final String s, final Target<GlideDrawable> target, final boolean b) {
                return false;
            }
            
            @Override
            public boolean onResourceReady(final GlideDrawable glideDrawable, final String s, final Target<GlideDrawable> target, final boolean b, final boolean b2) {
                if (imageView == null) {
                    return false;
                }
                if (imageView.getScaleType() != ImageView$ScaleType.FIT_XY) {
                    imageView.setScaleType(ImageView$ScaleType.FIT_XY);
                }
                final ViewGroup$LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = imageView.getPaddingTop() + Math.round(glideDrawable.getIntrinsicHeight() * ((imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight()) / (float)glideDrawable.getIntrinsicWidth())) + imageView.getPaddingBottom();
                imageView.setLayoutParams(layoutParams);
                return false;
            }
        }).dontAnimate().dontTransform().into(imageView);
    }
    
    @TargetApi(19)
    public static void setTransparencyBar(final Activity activity) {
        final Window window = activity.getWindow();
        if (Build$VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        else if (Build$VERSION.SDK_INT >= 19) {
            window.setFlags(67108864, 67108864);
        }
    }
    
    public static void showSoftInput(final Activity activity, final View view) {
        view.requestFocus();
        ((InputMethodManager)activity.getSystemService("input_method")).showSoftInput(view, 2);
    }
    
    public static int spToPx(final Context context, final float n) {
        return (int)(n * context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }
    
    public static void startMonitorOrientation(final Activity activity) {
        DIRECTION mLastOrientation;
        if (isLandscape(activity)) {
            mLastOrientation = DIRECTION.LAND;
        }
        else {
            mLastOrientation = DIRECTION.PORT;
        }
        LayoutUtils.mLastOrientation = mLastOrientation;
        (LayoutUtils.mOrientListener = new OrientationEventListener(activity) {
            public void onOrientationChanged(int n) {
                if (!LayoutUtils.mFixedOrientation && (LayoutUtils.mPortManual || LayoutUtils.mLandManual)) {
                    final int n2 = 0;
                    final int n3 = 0;
                    if ((n >= 0 && n <= 30) || n >= 330) {
                        n = n3;
                        if (LayoutUtils.mLastOrientation == DIRECTION.LAND) {
                            LayoutUtils.mLastOrientation = DIRECTION.PORT;
                            n = 1;
                        }
                        if (n != 0 && LayoutUtils.mLandManual && LayoutUtils.isLandscape(activity)) {
                            activity.setRequestedOrientation(1);
                            LayoutUtils.mLandManual = false;
                            LayoutUtils.mPortManual = true;
                        }
                    }
                    else if (n >= 230 && n <= 310) {
                        n = n2;
                        if (LayoutUtils.mLastOrientation == DIRECTION.PORT) {
                            LayoutUtils.mLastOrientation = DIRECTION.LAND;
                            n = 1;
                        }
                        if (n != 0 && LayoutUtils.mPortManual && LayoutUtils.isPortrait(activity)) {
                            activity.setRequestedOrientation(0);
                            LayoutUtils.mPortManual = false;
                            LayoutUtils.mLandManual = true;
                        }
                    }
                }
            }
        }).enable();
    }
    
    public static void stopMonitorOrientation(final Activity activity) {
        LayoutUtils.mOrientListener.disable();
        LayoutUtils.mLandManual = false;
        LayoutUtils.mPortManual = false;
    }
    
    enum DIRECTION
    {
        LAND, 
        PORT;
    }
    
    public interface OnSoftKeyBoardVisibleListener
    {
        void onSoftKeyBoardVisible(final boolean p0);
    }
}
