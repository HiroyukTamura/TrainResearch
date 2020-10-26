// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide;

import com.bumptech.glide.request.animation.GlideAnimation;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import android.widget.ImageView;
import android.support.v4.app.FragmentActivity;
import android.annotation.TargetApi;
import android.app.Fragment;
import com.bumptech.glide.manager.RequestManagerRetriever;
import android.app.Activity;
import java.util.Iterator;
import java.util.List;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;
import android.view.View;
import android.util.Log;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.GifBitmapWrapperDrawableTranscoder;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.GlideBitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.model.stream.StreamByteArrayLoader;
import com.bumptech.glide.load.model.stream.HttpUrlGlideUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.stream.StreamUrlLoader;
import java.net.URL;
import com.bumptech.glide.load.model.stream.StreamUriLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorUriLoader;
import android.net.Uri;
import com.bumptech.glide.load.model.stream.StreamStringLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorStringLoader;
import com.bumptech.glide.load.model.stream.StreamResourceLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorResourceLoader;
import com.bumptech.glide.load.model.stream.StreamFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorFileLoader;
import com.bumptech.glide.load.resource.file.StreamFileDataLoadProvider;
import java.io.File;
import com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableLoadProvider;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.bitmap.ImageVideoDataLoadProvider;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDataLoadProvider;
import com.bumptech.glide.provider.DataLoadProvider;
import android.graphics.Bitmap;
import java.io.InputStream;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDataLoadProvider;
import android.os.Looper;
import android.content.Context;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import android.os.Handler;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.provider.DataLoadProviderRegistry;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

public class Glide
{
    private static final String TAG = "Glide";
    private static volatile Glide glide;
    private final CenterCrop bitmapCenterCrop;
    private final FitCenter bitmapFitCenter;
    private final BitmapPool bitmapPool;
    private final BitmapPreFiller bitmapPreFiller;
    private final DataLoadProviderRegistry dataLoadProviderRegistry;
    private final DecodeFormat decodeFormat;
    private final GifBitmapWrapperTransformation drawableCenterCrop;
    private final GifBitmapWrapperTransformation drawableFitCenter;
    private final Engine engine;
    private final ImageViewTargetFactory imageViewTargetFactory;
    private final GenericLoaderFactory loaderFactory;
    private final Handler mainHandler;
    private final MemoryCache memoryCache;
    private final TranscoderRegistry transcoderRegistry;
    
    Glide(final Engine engine, final MemoryCache memoryCache, final BitmapPool bitmapPool, final Context context, final DecodeFormat decodeFormat) {
        this.imageViewTargetFactory = new ImageViewTargetFactory();
        this.transcoderRegistry = new TranscoderRegistry();
        this.engine = engine;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.decodeFormat = decodeFormat;
        this.loaderFactory = new GenericLoaderFactory(context);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.bitmapPreFiller = new BitmapPreFiller(memoryCache, bitmapPool, decodeFormat);
        this.dataLoadProviderRegistry = new DataLoadProviderRegistry();
        final StreamBitmapDataLoadProvider streamBitmapDataLoadProvider = new StreamBitmapDataLoadProvider(bitmapPool, decodeFormat);
        this.dataLoadProviderRegistry.register(InputStream.class, Bitmap.class, streamBitmapDataLoadProvider);
        final FileDescriptorBitmapDataLoadProvider fileDescriptorBitmapDataLoadProvider = new FileDescriptorBitmapDataLoadProvider(bitmapPool, decodeFormat);
        this.dataLoadProviderRegistry.register(ParcelFileDescriptor.class, Bitmap.class, fileDescriptorBitmapDataLoadProvider);
        final ImageVideoDataLoadProvider imageVideoDataLoadProvider = new ImageVideoDataLoadProvider(streamBitmapDataLoadProvider, fileDescriptorBitmapDataLoadProvider);
        this.dataLoadProviderRegistry.register(ImageVideoWrapper.class, Bitmap.class, imageVideoDataLoadProvider);
        final GifDrawableLoadProvider gifDrawableLoadProvider = new GifDrawableLoadProvider(context, bitmapPool);
        this.dataLoadProviderRegistry.register(InputStream.class, GifDrawable.class, gifDrawableLoadProvider);
        this.dataLoadProviderRegistry.register(ImageVideoWrapper.class, GifBitmapWrapper.class, new ImageVideoGifDrawableLoadProvider(imageVideoDataLoadProvider, gifDrawableLoadProvider, bitmapPool));
        this.dataLoadProviderRegistry.register(InputStream.class, File.class, new StreamFileDataLoadProvider());
        this.register(File.class, ParcelFileDescriptor.class, new FileDescriptorFileLoader.Factory());
        this.register(File.class, InputStream.class, new StreamFileLoader.Factory());
        this.register(Integer.TYPE, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
        this.register(Integer.TYPE, InputStream.class, new StreamResourceLoader.Factory());
        this.register(Integer.class, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
        this.register(Integer.class, InputStream.class, new StreamResourceLoader.Factory());
        this.register(String.class, ParcelFileDescriptor.class, new FileDescriptorStringLoader.Factory());
        this.register(String.class, InputStream.class, new StreamStringLoader.Factory());
        this.register(Uri.class, ParcelFileDescriptor.class, new FileDescriptorUriLoader.Factory());
        this.register(Uri.class, InputStream.class, new StreamUriLoader.Factory());
        this.register(URL.class, InputStream.class, new StreamUrlLoader.Factory());
        this.register(GlideUrl.class, InputStream.class, new HttpUrlGlideUrlLoader.Factory());
        this.register(byte[].class, InputStream.class, new StreamByteArrayLoader.Factory());
        this.transcoderRegistry.register(Bitmap.class, GlideBitmapDrawable.class, new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool));
        this.transcoderRegistry.register(GifBitmapWrapper.class, GlideDrawable.class, new GifBitmapWrapperDrawableTranscoder(new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool)));
        this.bitmapCenterCrop = new CenterCrop(bitmapPool);
        this.drawableCenterCrop = new GifBitmapWrapperTransformation(bitmapPool, this.bitmapCenterCrop);
        this.bitmapFitCenter = new FitCenter(bitmapPool);
        this.drawableFitCenter = new GifBitmapWrapperTransformation(bitmapPool, this.bitmapFitCenter);
    }
    
    public static <T> ModelLoader<T, ParcelFileDescriptor> buildFileDescriptorModelLoader(final Class<T> clazz, final Context context) {
        return buildModelLoader(clazz, ParcelFileDescriptor.class, context);
    }
    
    public static <T> ModelLoader<T, ParcelFileDescriptor> buildFileDescriptorModelLoader(final T t, final Context context) {
        return buildModelLoader(t, ParcelFileDescriptor.class, context);
    }
    
    public static <T, Y> ModelLoader<T, Y> buildModelLoader(final Class<T> clazz, final Class<Y> clazz2, final Context context) {
        if (clazz == null) {
            if (Log.isLoggable("Glide", 3)) {
                Log.d("Glide", "Unable to load null model, setting placeholder only");
            }
            return null;
        }
        return get(context).getLoaderFactory().buildModelLoader(clazz, clazz2);
    }
    
    public static <T, Y> ModelLoader<T, Y> buildModelLoader(final T t, final Class<Y> clazz, final Context context) {
        Class<?> class1;
        if (t != null) {
            class1 = t.getClass();
        }
        else {
            class1 = null;
        }
        return buildModelLoader((Class<T>)class1, clazz, context);
    }
    
    public static <T> ModelLoader<T, InputStream> buildStreamModelLoader(final Class<T> clazz, final Context context) {
        return buildModelLoader(clazz, InputStream.class, context);
    }
    
    public static <T> ModelLoader<T, InputStream> buildStreamModelLoader(final T t, final Context context) {
        return buildModelLoader(t, InputStream.class, context);
    }
    
    public static void clear(final View view) {
        clear(new ClearTarget(view));
    }
    
    public static void clear(final FutureTarget<?> futureTarget) {
        futureTarget.clear();
    }
    
    public static void clear(final Target<?> target) {
        Util.assertMainThread();
        final Request request = target.getRequest();
        if (request != null) {
            request.clear();
            target.setRequest(null);
        }
    }
    
    public static Glide get(Context applicationContext) {
        if (Glide.glide == null) {
            Label_0126: {
                final List<GlideModule> parse;
                final GlideBuilder glideBuilder;
                synchronized (Glide.class) {
                    if (Glide.glide != null) {
                        break Label_0126;
                    }
                    applicationContext = applicationContext.getApplicationContext();
                    parse = new ManifestParser(applicationContext).parse();
                    glideBuilder = new GlideBuilder(applicationContext);
                    final Iterator<GlideModule> iterator = parse.iterator();
                    while (iterator.hasNext()) {
                        iterator.next().applyOptions(applicationContext, glideBuilder);
                    }
                }
                Glide.glide = glideBuilder.createGlide();
                final Iterator<GlideModule> iterator2 = parse.iterator();
                while (iterator2.hasNext()) {
                    final Context context;
                    iterator2.next().registerComponents(context, Glide.glide);
                }
            }
        }
        // monitorexit(Glide.class)
        return Glide.glide;
    }
    
    private GenericLoaderFactory getLoaderFactory() {
        return this.loaderFactory;
    }
    
    public static File getPhotoCacheDir(final Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }
    
    public static File getPhotoCacheDir(final Context context, final String child) {
        final File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file2;
            final File file = file2 = new File(cacheDir, child);
            if (!file.mkdirs()) {
                if (file.exists()) {
                    file2 = file;
                    if (file.isDirectory()) {
                        return file2;
                    }
                }
                file2 = null;
            }
            return file2;
        }
        if (Log.isLoggable("Glide", 6)) {
            Log.e("Glide", "default disk cache dir is null");
        }
        return null;
    }
    
    @Deprecated
    public static boolean isSetup() {
        return Glide.glide != null;
    }
    
    @Deprecated
    public static void setup(final GlideBuilder glideBuilder) {
        if (isSetup()) {
            throw new IllegalArgumentException("Glide is already setup, check with isSetup() first");
        }
        Glide.glide = glideBuilder.createGlide();
    }
    
    static void tearDown() {
        Glide.glide = null;
    }
    
    public static RequestManager with(final Activity activity) {
        return RequestManagerRetriever.get().get(activity);
    }
    
    @TargetApi(11)
    public static RequestManager with(final Fragment fragment) {
        return RequestManagerRetriever.get().get(fragment);
    }
    
    public static RequestManager with(final Context context) {
        return RequestManagerRetriever.get().get(context);
    }
    
    public static RequestManager with(final android.support.v4.app.Fragment fragment) {
        return RequestManagerRetriever.get().get(fragment);
    }
    
    public static RequestManager with(final FragmentActivity fragmentActivity) {
        return RequestManagerRetriever.get().get(fragmentActivity);
    }
    
     <T, Z> DataLoadProvider<T, Z> buildDataProvider(final Class<T> clazz, final Class<Z> clazz2) {
        return this.dataLoadProviderRegistry.get(clazz, clazz2);
    }
    
     <R> Target<R> buildImageViewTarget(final ImageView imageView, final Class<R> clazz) {
        return this.imageViewTargetFactory.buildTarget(imageView, clazz);
    }
    
     <Z, R> ResourceTranscoder<Z, R> buildTranscoder(final Class<Z> clazz, final Class<R> clazz2) {
        return this.transcoderRegistry.get(clazz, clazz2);
    }
    
    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.getEngine().clearDiskCache();
    }
    
    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
    }
    
    CenterCrop getBitmapCenterCrop() {
        return this.bitmapCenterCrop;
    }
    
    FitCenter getBitmapFitCenter() {
        return this.bitmapFitCenter;
    }
    
    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }
    
    DecodeFormat getDecodeFormat() {
        return this.decodeFormat;
    }
    
    GifBitmapWrapperTransformation getDrawableCenterCrop() {
        return this.drawableCenterCrop;
    }
    
    GifBitmapWrapperTransformation getDrawableFitCenter() {
        return this.drawableFitCenter;
    }
    
    Engine getEngine() {
        return this.engine;
    }
    
    Handler getMainHandler() {
        return this.mainHandler;
    }
    
    public void preFillBitmapPool(final PreFillType.Builder... array) {
        this.bitmapPreFiller.preFill(array);
    }
    
    public <T, Y> void register(final Class<T> clazz, final Class<Y> clazz2, final ModelLoaderFactory<T, Y> modelLoaderFactory) {
        final ModelLoaderFactory<T, Y> register = this.loaderFactory.register(clazz, clazz2, modelLoaderFactory);
        if (register != null) {
            register.teardown();
        }
    }
    
    public void setMemoryCategory(final MemoryCategory memoryCategory) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory.getMultiplier());
    }
    
    public void trimMemory(final int n) {
        Util.assertMainThread();
        this.memoryCache.trimMemory(n);
        this.bitmapPool.trimMemory(n);
    }
    
    @Deprecated
    public <T, Y> void unregister(final Class<T> clazz, final Class<Y> clazz2) {
        final ModelLoaderFactory<T, Y> unregister = this.loaderFactory.unregister(clazz, clazz2);
        if (unregister != null) {
            unregister.teardown();
        }
    }
    
    private static class ClearTarget extends ViewTarget<View, Object>
    {
        public ClearTarget(final View view) {
            super(view);
        }
        
        @Override
        public void onLoadCleared(final Drawable drawable) {
        }
        
        @Override
        public void onLoadFailed(final Exception ex, final Drawable drawable) {
        }
        
        @Override
        public void onLoadStarted(final Drawable drawable) {
        }
        
        @Override
        public void onResourceReady(final Object o, final GlideAnimation<? super Object> glideAnimation) {
        }
    }
}
