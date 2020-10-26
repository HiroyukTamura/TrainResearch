// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.annotation.SuppressLint;

@SuppressLint({ "NewApi" })
public final class zzj extends zzl
{
    private Fragment zzaSB;
    
    private zzj(final Fragment zzaSB) {
        this.zzaSB = zzaSB;
    }
    
    public static zzj zza(final Fragment fragment) {
        if (fragment != null) {
            return new zzj(fragment);
        }
        return null;
    }
    
    @Override
    public final Bundle getArguments() {
        return this.zzaSB.getArguments();
    }
    
    @Override
    public final int getId() {
        return this.zzaSB.getId();
    }
    
    @Override
    public final boolean getRetainInstance() {
        return this.zzaSB.getRetainInstance();
    }
    
    @Override
    public final String getTag() {
        return this.zzaSB.getTag();
    }
    
    @Override
    public final int getTargetRequestCode() {
        return this.zzaSB.getTargetRequestCode();
    }
    
    @Override
    public final boolean getUserVisibleHint() {
        return this.zzaSB.getUserVisibleHint();
    }
    
    @Override
    public final IObjectWrapper getView() {
        return zzn.zzw(this.zzaSB.getView());
    }
    
    @Override
    public final boolean isAdded() {
        return this.zzaSB.isAdded();
    }
    
    @Override
    public final boolean isDetached() {
        return this.zzaSB.isDetached();
    }
    
    @Override
    public final boolean isHidden() {
        return this.zzaSB.isHidden();
    }
    
    @Override
    public final boolean isInLayout() {
        return this.zzaSB.isInLayout();
    }
    
    @Override
    public final boolean isRemoving() {
        return this.zzaSB.isRemoving();
    }
    
    @Override
    public final boolean isResumed() {
        return this.zzaSB.isResumed();
    }
    
    @Override
    public final boolean isVisible() {
        return this.zzaSB.isVisible();
    }
    
    @Override
    public final void setHasOptionsMenu(final boolean hasOptionsMenu) {
        this.zzaSB.setHasOptionsMenu(hasOptionsMenu);
    }
    
    @Override
    public final void setMenuVisibility(final boolean menuVisibility) {
        this.zzaSB.setMenuVisibility(menuVisibility);
    }
    
    @Override
    public final void setRetainInstance(final boolean retainInstance) {
        this.zzaSB.setRetainInstance(retainInstance);
    }
    
    @Override
    public final void setUserVisibleHint(final boolean userVisibleHint) {
        this.zzaSB.setUserVisibleHint(userVisibleHint);
    }
    
    @Override
    public final void startActivity(final Intent intent) {
        this.zzaSB.startActivity(intent);
    }
    
    @Override
    public final void startActivityForResult(final Intent intent, final int n) {
        this.zzaSB.startActivityForResult(intent, n);
    }
    
    @Override
    public final void zzC(final IObjectWrapper objectWrapper) {
        this.zzaSB.registerForContextMenu((View)zzn.zzE(objectWrapper));
    }
    
    @Override
    public final void zzD(final IObjectWrapper objectWrapper) {
        this.zzaSB.unregisterForContextMenu((View)zzn.zzE(objectWrapper));
    }
    
    @Override
    public final IObjectWrapper zztA() {
        return zzn.zzw(this.zzaSB.getResources());
    }
    
    @Override
    public final zzk zztB() {
        return zza(this.zzaSB.getTargetFragment());
    }
    
    @Override
    public final IObjectWrapper zzty() {
        return zzn.zzw(this.zzaSB.getActivity());
    }
    
    @Override
    public final zzk zztz() {
        return zza(this.zzaSB.getParentFragment());
    }
}
