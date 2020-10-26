// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.FutureTarget;
import java.io.File;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.bumptech.glide.provider.FixedLoadProvider;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import android.content.Context;
import java.io.InputStream;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.ModelLoader;

public class DrawableTypeRequest<ModelType> extends DrawableRequestBuilder<ModelType> implements DownloadOptions
{
    private final ModelLoader<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader;
    private final RequestManager.OptionsApplier optionsApplier;
    private final ModelLoader<ModelType, InputStream> streamModelLoader;
    
    DrawableTypeRequest(final Class<ModelType> clazz, final ModelLoader<ModelType, InputStream> streamModelLoader, final ModelLoader<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader, final Context context, final Glide glide, final RequestTracker requestTracker, final Lifecycle lifecycle, final RequestManager.OptionsApplier optionsApplier) {
        super(context, clazz, buildProvider(glide, streamModelLoader, fileDescriptorModelLoader, GifBitmapWrapper.class, GlideDrawable.class, null), glide, requestTracker, lifecycle);
        this.streamModelLoader = streamModelLoader;
        this.fileDescriptorModelLoader = fileDescriptorModelLoader;
        this.optionsApplier = optionsApplier;
    }
    
    private static <A, Z, R> FixedLoadProvider<A, ImageVideoWrapper, Z, R> buildProvider(final Glide glide, final ModelLoader<A, InputStream> modelLoader, final ModelLoader<A, ParcelFileDescriptor> modelLoader2, final Class<Z> clazz, final Class<R> clazz2, final ResourceTranscoder<Z, R> resourceTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        ResourceTranscoder<Z, R> buildTranscoder;
        if ((buildTranscoder = resourceTranscoder) == null) {
            buildTranscoder = glide.buildTranscoder(clazz, clazz2);
        }
        return new FixedLoadProvider<A, ImageVideoWrapper, Z, R>((ModelLoader<Object, Object>)new ImageVideoModelLoader<A>((ModelLoader<Object, InputStream>)modelLoader, (ModelLoader<Object, ParcelFileDescriptor>)modelLoader2), (ResourceTranscoder<Object, Object>)buildTranscoder, (DataLoadProvider<Object, Object>)glide.buildDataProvider(ImageVideoWrapper.class, clazz));
    }
    
    private GenericTranscodeRequest<ModelType, InputStream, File> getDownloadOnlyRequest() {
        return this.optionsApplier.apply(new GenericTranscodeRequest<ModelType, InputStream, File>(File.class, (GenericRequestBuilder<ModelType, ?, ?, ?>)this, this.streamModelLoader, InputStream.class, File.class, this.optionsApplier));
    }
    
    public BitmapTypeRequest<ModelType> asBitmap() {
        return this.optionsApplier.apply(new BitmapTypeRequest<ModelType>((GenericRequestBuilder<ModelType, ?, ?, ?>)this, this.streamModelLoader, this.fileDescriptorModelLoader, this.optionsApplier));
    }
    
    public GifTypeRequest<ModelType> asGif() {
        return this.optionsApplier.apply(new GifTypeRequest<ModelType>((GenericRequestBuilder<ModelType, ?, ?, ?>)this, this.streamModelLoader, this.optionsApplier));
    }
    
    @Override
    public FutureTarget<File> downloadOnly(final int n, final int n2) {
        return this.getDownloadOnlyRequest().downloadOnly(n, n2);
    }
    
    @Override
    public <Y extends Target<File>> Y downloadOnly(final Y y) {
        return this.getDownloadOnlyRequest().downloadOnly(y);
    }
}
