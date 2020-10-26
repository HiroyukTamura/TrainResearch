// 
// Decompiled by Procyon v0.5.36
// 

package me.yokeyword.fragmentation;

import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import android.view.MotionEvent;
import android.support.v7.app.AppCompatActivity;

public class SupportActivity extends AppCompatActivity implements ISupportActivity
{
    final SupportActivityDelegate mDelegate;
    
    public SupportActivity() {
        this.mDelegate = new SupportActivityDelegate((ISupportActivity)this);
    }
    
    @Override
    public boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        return this.mDelegate.dispatchTouchEvent(motionEvent) || super.dispatchTouchEvent(motionEvent);
    }
    
    @Override
    public ExtraTransaction extraTransaction() {
        return this.mDelegate.extraTransaction();
    }
    
    public <T extends ISupportFragment> T findFragment(final Class<T> clazz) {
        return (T)SupportHelper.findFragment(this.getSupportFragmentManager(), (Class)clazz);
    }
    
    @Override
    public FragmentAnimator getFragmentAnimator() {
        return this.mDelegate.getFragmentAnimator();
    }
    
    @Override
    public SupportActivityDelegate getSupportDelegate() {
        return this.mDelegate;
    }
    
    public ISupportFragment getTopFragment() {
        return SupportHelper.getTopFragment(this.getSupportFragmentManager());
    }
    
    public void loadMultipleRootFragment(final int n, final int n2, final ISupportFragment... array) {
        this.mDelegate.loadMultipleRootFragment(n, n2, array);
    }
    
    public void loadRootFragment(final int n, @NonNull final ISupportFragment supportFragment) {
        this.mDelegate.loadRootFragment(n, supportFragment);
    }
    
    public void loadRootFragment(final int n, final ISupportFragment supportFragment, final boolean b, final boolean b2) {
        this.mDelegate.loadRootFragment(n, supportFragment, b, b2);
    }
    
    @Override
    public final void onBackPressed() {
        this.mDelegate.onBackPressed();
    }
    
    @Override
    public void onBackPressedSupport() {
        this.mDelegate.onBackPressedSupport();
    }
    
    @Override
    protected void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        this.mDelegate.onCreate(bundle);
    }
    
    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return this.mDelegate.onCreateFragmentAnimator();
    }
    
    @Override
    protected void onDestroy() {
        this.mDelegate.onDestroy();
        super.onDestroy();
    }
    
    @Override
    protected void onPostCreate(@Nullable final Bundle bundle) {
        super.onPostCreate(bundle);
        this.mDelegate.onPostCreate(bundle);
    }
    
    public void pop() {
        this.mDelegate.pop();
    }
    
    public void popTo(final Class<?> clazz, final boolean b) {
        this.mDelegate.popTo((Class)clazz, b);
    }
    
    public void popTo(final Class<?> clazz, final boolean b, final Runnable runnable) {
        this.mDelegate.popTo((Class)clazz, b, runnable);
    }
    
    public void popTo(final Class<?> clazz, final boolean b, final Runnable runnable, final int n) {
        this.mDelegate.popTo((Class)clazz, b, runnable, n);
    }
    
    public void replaceFragment(final ISupportFragment supportFragment, final boolean b) {
        this.mDelegate.replaceFragment(supportFragment, b);
    }
    
    public void setDefaultFragmentBackground(@DrawableRes final int defaultFragmentBackground) {
        this.mDelegate.setDefaultFragmentBackground(defaultFragmentBackground);
    }
    
    @Override
    public void setFragmentAnimator(final FragmentAnimator fragmentAnimator) {
        this.mDelegate.setFragmentAnimator(fragmentAnimator);
    }
    
    public void showHideFragment(final ISupportFragment supportFragment) {
        this.mDelegate.showHideFragment(supportFragment);
    }
    
    public void showHideFragment(final ISupportFragment supportFragment, final ISupportFragment supportFragment2) {
        this.mDelegate.showHideFragment(supportFragment, supportFragment2);
    }
    
    public void start(final ISupportFragment supportFragment) {
        this.mDelegate.start(supportFragment);
    }
    
    public void start(final ISupportFragment supportFragment, final int n) {
        this.mDelegate.start(supportFragment, n);
    }
    
    public void startForResult(final ISupportFragment supportFragment, final int n) {
        this.mDelegate.startForResult(supportFragment, n);
    }
    
    public void startWithPop(final ISupportFragment supportFragment) {
        this.mDelegate.startWithPop(supportFragment);
    }
}
