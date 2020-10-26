// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.loader;

import android.content.Context;
import java.io.Serializable;
import android.view.View;

public interface ImageLoaderInterface<T extends View> extends Serializable
{
    T createImageView(final Context p0);
    
    void displayImage(final Context p0, final Object p1, final T p2);
}
