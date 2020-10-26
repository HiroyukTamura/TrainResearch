// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base;

import org.androidannotations.api.builder.FragmentBuilder;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import org.androidannotations.api.view.OnViewChangedNotifier;
import android.view.View;
import org.androidannotations.api.view.HasViews;

public final class BaseFragment_ extends BaseFragment implements HasViews
{
    private android.view.View contentView_;
    private final OnViewChangedNotifier onViewChangedNotifier_;
    
    public BaseFragment_() {
        this.onViewChangedNotifier_ = new OnViewChangedNotifier();
    }
    
    public static FragmentBuilder_ builder() {
        return new FragmentBuilder_();
    }
    
    private void init_(final Bundle bundle) {
    }
    
    public <T extends android.view.View> T internalFindViewById(final int n) {
        if (this.contentView_ == null) {
            return null;
        }
        return (T)this.contentView_.findViewById(n);
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        final OnViewChangedNotifier replaceNotifier = OnViewChangedNotifier.replaceNotifier(this.onViewChangedNotifier_);
        this.init_(bundle);
        super.onCreate(bundle);
        OnViewChangedNotifier.replaceNotifier(replaceNotifier);
    }
    
    @Override
    public android.view.View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return this.contentView_ = super.onCreateView(layoutInflater, viewGroup, bundle);
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.contentView_ = null;
    }
    
    public void onViewCreated(final android.view.View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.onViewChangedNotifier_.notifyViewChanged((HasViews)this);
    }
    
    public static class FragmentBuilder_ extends FragmentBuilder<FragmentBuilder_, BaseFragment>
    {
        public BaseFragment build() {
            final BaseFragment_ baseFragment_ = new BaseFragment_();
            baseFragment_.setArguments(this.args);
            return baseFragment_;
        }
    }
}
