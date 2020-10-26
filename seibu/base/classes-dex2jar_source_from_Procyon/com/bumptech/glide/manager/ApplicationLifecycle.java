// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.manager;

class ApplicationLifecycle implements Lifecycle
{
    @Override
    public void addListener(final LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
