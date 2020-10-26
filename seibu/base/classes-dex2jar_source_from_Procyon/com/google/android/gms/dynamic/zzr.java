// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public final class zzr extends zzl
{
    private Fragment zzaSE;
    
    private zzr(final Fragment zzaSE) {
        this.zzaSE = zzaSE;
    }
    
    public static zzr zza(final Fragment fragment) {
        if (fragment != null) {
            return new zzr(fragment);
        }
        return null;
    }
    
    @Override
    public final Bundle getArguments() {
        return this.zzaSE.getArguments();
    }
    
    @Override
    public final int getId() {
        return this.zzaSE.getId();
    }
    
    @Override
    public final boolean getRetainInstance() {
        return this.zzaSE.getRetainInstance();
    }
    
    @Override
    public final String getTag() {
        return this.zzaSE.getTag();
    }
    
    @Override
    public final int getTargetRequestCode() {
        return this.zzaSE.getTargetRequestCode();
    }
    
    @Override
    public final boolean getUserVisibleHint() {
        return this.zzaSE.getUserVisibleHint();
    }
    
    @Override
    public final IObjectWrapper getView() {
        return zzn.zzw(this.zzaSE.getView());
    }
    
    @Override
    public final boolean isAdded() {
        return this.zzaSE.isAdded();
    }
    
    @Override
    public final boolean isDetached() {
        return this.zzaSE.isDetached();
    }
    
    @Override
    public final boolean isHidden() {
        return this.zzaSE.isHidden();
    }
    
    @Override
    public final boolean isInLayout() {
        return this.zzaSE.isInLayout();
    }
    
    @Override
    public final boolean isRemoving() {
        return this.zzaSE.isRemoving();
    }
    
    @Override
    public final boolean isResumed() {
        return this.zzaSE.isResumed();
    }
    
    @Override
    public final boolean isVisible() {
        return this.zzaSE.isVisible();
    }
    
    @Override
    public final void setHasOptionsMenu(final boolean hasOptionsMenu) {
        this.zzaSE.setHasOptionsMenu(hasOptionsMenu);
    }
    
    @Override
    public final void setMenuVisibility(final boolean menuVisibility) {
        this.zzaSE.setMenuVisibility(menuVisibility);
    }
    
    @Override
    public final void setRetainInstance(final boolean retainInstance) {
        this.zzaSE.setRetainInstance(retainInstance);
    }
    
    @Override
    public final void setUserVisibleHint(final boolean userVisibleHint) {
        this.zzaSE.setUserVisibleHint(userVisibleHint);
    }
    
    @Override
    public final void startActivity(final Intent intent) {
        this.zzaSE.startActivity(intent);
    }
    
    @Override
    public final void startActivityForResult(final Intent intent, final int n) {
        this.zzaSE.startActivityForResult(intent, n);
    }
    
    @Override
    public final void zzC(final IObjectWrapper objectWrapper) {
        this.zzaSE.registerForContextMenu(zzn.zzE(objectWrapper));
    }
    
    @Override
    public final void zzD(final IObjectWrapper objectWrapper) {
        this.zzaSE.unregisterForContextMenu(zzn.zzE(objectWrapper));
    }
    
    @Override
    public final IObjectWrapper zztA() {
        return zzn.zzw(this.zzaSE.getResources());
    }
    
    @Override
    public final zzk zztB() {
        return zza(this.zzaSE.getTargetFragment());
    }
    
    @Override
    public final IObjectWrapper zzty() {
        return zzn.zzw(this.zzaSE.getActivity());
    }
    
    @Override
    public final zzk zztz() {
        return zza(this.zzaSE.getParentFragment());
    }
}
