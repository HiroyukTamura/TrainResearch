// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v7.view;

import android.support.v7.appcompat.R;
import android.content.res.AssetManager;
import android.support.annotation.StyleRes;
import android.content.Context;
import android.content.res.Resources$Theme;
import android.view.LayoutInflater;
import android.support.annotation.RestrictTo;
import android.content.ContextWrapper;

@RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
public class ContextThemeWrapper extends ContextWrapper
{
    private LayoutInflater mInflater;
    private Resources$Theme mTheme;
    private int mThemeResource;
    
    public ContextThemeWrapper(final Context context, @StyleRes final int mThemeResource) {
        super(context);
        this.mThemeResource = mThemeResource;
    }
    
    public ContextThemeWrapper(final Context context, final Resources$Theme mTheme) {
        super(context);
        this.mTheme = mTheme;
    }
    
    private void initializeTheme() {
        final boolean b = this.mTheme == null;
        if (b) {
            this.mTheme = this.getResources().newTheme();
            final Resources$Theme theme = this.getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        this.onApplyThemeResource(this.mTheme, this.mThemeResource, b);
    }
    
    public AssetManager getAssets() {
        return this.getResources().getAssets();
    }
    
    public Object getSystemService(final String anObject) {
        if ("layout_inflater".equals(anObject)) {
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(this.getBaseContext()).cloneInContext((Context)this);
            }
            return this.mInflater;
        }
        return this.getBaseContext().getSystemService(anObject);
    }
    
    public Resources$Theme getTheme() {
        if (this.mTheme != null) {
            return this.mTheme;
        }
        if (this.mThemeResource == 0) {
            this.mThemeResource = R.style.Theme_AppCompat_Light;
        }
        this.initializeTheme();
        return this.mTheme;
    }
    
    public int getThemeResId() {
        return this.mThemeResource;
    }
    
    protected void onApplyThemeResource(final Resources$Theme resources$Theme, final int n, final boolean b) {
        resources$Theme.applyStyle(n, true);
    }
    
    public void setTheme(final int mThemeResource) {
        if (this.mThemeResource != mThemeResource) {
            this.mThemeResource = mThemeResource;
            this.initializeTheme();
        }
    }
}
