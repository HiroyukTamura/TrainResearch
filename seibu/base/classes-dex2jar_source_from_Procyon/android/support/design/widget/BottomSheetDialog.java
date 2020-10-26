// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.support.annotation.LayoutRes;
import android.support.v4.view.ViewCompat;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.support.design.R;
import android.util.TypedValue;
import android.content.DialogInterface$OnCancelListener;
import android.view.View;
import android.support.annotation.StyleRes;
import android.support.annotation.NonNull;
import android.content.Context;
import android.widget.FrameLayout;
import android.support.v7.app.AppCompatDialog;

public class BottomSheetDialog extends AppCompatDialog
{
    private BottomSheetBehavior<FrameLayout> mBehavior;
    private BottomSheetBehavior.BottomSheetCallback mBottomSheetCallback;
    boolean mCancelable;
    private boolean mCanceledOnTouchOutside;
    private boolean mCanceledOnTouchOutsideSet;
    
    public BottomSheetDialog(@NonNull final Context context) {
        this(context, 0);
    }
    
    public BottomSheetDialog(@NonNull final Context context, @StyleRes final int n) {
        super(context, getThemeResId(context, n));
        this.mCancelable = true;
        this.mCanceledOnTouchOutside = true;
        this.mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onSlide(@NonNull final View view, final float n) {
            }
            
            @Override
            public void onStateChanged(@NonNull final View view, final int n) {
                if (n == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        this.supportRequestWindowFeature(1);
    }
    
    protected BottomSheetDialog(@NonNull final Context context, final boolean mCancelable, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        super(context, mCancelable, dialogInterface$OnCancelListener);
        this.mCancelable = true;
        this.mCanceledOnTouchOutside = true;
        this.mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onSlide(@NonNull final View view, final float n) {
            }
            
            @Override
            public void onStateChanged(@NonNull final View view, final int n) {
                if (n == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        this.supportRequestWindowFeature(1);
        this.mCancelable = mCancelable;
    }
    
    private static int getThemeResId(final Context context, final int n) {
        int resourceId = n;
        if (n == 0) {
            final TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
                return R.style.Theme_Design_Light_BottomSheetDialog;
            }
            resourceId = typedValue.resourceId;
        }
        return resourceId;
    }
    
    private View wrapInBottomSheet(final int n, final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout)View.inflate(this.getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup)null);
        View inflate = view;
        if (n != 0 && (inflate = view) == null) {
            inflate = this.getLayoutInflater().inflate(n, (ViewGroup)coordinatorLayout, false);
        }
        final FrameLayout frameLayout = (FrameLayout)coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        (this.mBehavior = BottomSheetBehavior.from(frameLayout)).setBottomSheetCallback(this.mBottomSheetCallback);
        this.mBehavior.setHideable(this.mCancelable);
        if (viewGroup$LayoutParams == null) {
            frameLayout.addView(inflate);
        }
        else {
            frameLayout.addView(inflate, viewGroup$LayoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                if (BottomSheetDialog.this.mCancelable && BottomSheetDialog.this.isShowing() && BottomSheetDialog.this.shouldWindowCloseOnTouchOutside()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.setAccessibilityDelegate((View)frameLayout, new AccessibilityDelegateCompat() {
            @Override
            public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (BottomSheetDialog.this.mCancelable) {
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                    return;
                }
                accessibilityNodeInfoCompat.setDismissable(false);
            }
            
            @Override
            public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
                if (n == 1048576 && BottomSheetDialog.this.mCancelable) {
                    BottomSheetDialog.this.cancel();
                    return true;
                }
                return super.performAccessibilityAction(view, n, bundle);
            }
        });
        return (View)coordinatorLayout;
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.getWindow().setLayout(-1, -1);
    }
    
    protected void onStart() {
        super.onStart();
        if (this.mBehavior != null) {
            this.mBehavior.setState(4);
        }
    }
    
    public void setCancelable(final boolean hideable) {
        super.setCancelable(hideable);
        if (this.mCancelable != hideable) {
            this.mCancelable = hideable;
            if (this.mBehavior != null) {
                this.mBehavior.setHideable(hideable);
            }
        }
    }
    
    public void setCanceledOnTouchOutside(final boolean b) {
        super.setCanceledOnTouchOutside(b);
        if (b && !this.mCancelable) {
            this.mCancelable = true;
        }
        this.mCanceledOnTouchOutside = b;
        this.mCanceledOnTouchOutsideSet = true;
    }
    
    @Override
    public void setContentView(@LayoutRes final int n) {
        super.setContentView(this.wrapInBottomSheet(n, null, null));
    }
    
    @Override
    public void setContentView(final View view) {
        super.setContentView(this.wrapInBottomSheet(0, view, null));
    }
    
    @Override
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super.setContentView(this.wrapInBottomSheet(0, view, viewGroup$LayoutParams));
    }
    
    boolean shouldWindowCloseOnTouchOutside() {
        if (!this.mCanceledOnTouchOutsideSet) {
            if (Build$VERSION.SDK_INT < 11) {
                this.mCanceledOnTouchOutside = true;
            }
            else {
                final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(new int[] { 16843611 });
                this.mCanceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
            this.mCanceledOnTouchOutsideSet = true;
        }
        return this.mCanceledOnTouchOutside;
    }
}
