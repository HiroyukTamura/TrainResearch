// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import android.content.res.Resources$NotFoundException;
import android.util.Log;
import com.bumptech.glide.load.data.DataFetcher;
import android.content.Context;
import android.net.Uri;
import android.content.res.Resources;

public class ResourceLoader<T> implements ModelLoader<Integer, T>
{
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader<Uri, T> uriLoader;
    
    public ResourceLoader(final Context context, final ModelLoader<Uri, T> modelLoader) {
        this(context.getResources(), modelLoader);
    }
    
    public ResourceLoader(final Resources resources, final ModelLoader<Uri, T> uriLoader) {
        this.resources = resources;
        this.uriLoader = uriLoader;
    }
    
    @Override
    public DataFetcher<T> getResourceFetcher(final Integer obj, final int n, final int n2) {
        final Uri uri = null;
        while (true) {
            try {
                final Uri parse = Uri.parse("android.resource://" + this.resources.getResourcePackageName((int)obj) + '/' + this.resources.getResourceTypeName((int)obj) + '/' + this.resources.getResourceEntryName((int)obj));
                if (parse != null) {
                    return this.uriLoader.getResourceFetcher(parse, n, n2);
                }
            }
            catch (Resources$NotFoundException ex) {
                Uri parse = uri;
                if (Log.isLoggable("ResourceLoader", 5)) {
                    Log.w("ResourceLoader", "Received invalid resource id: " + obj, (Throwable)ex);
                    parse = uri;
                }
                continue;
            }
            break;
        }
        return null;
    }
}
