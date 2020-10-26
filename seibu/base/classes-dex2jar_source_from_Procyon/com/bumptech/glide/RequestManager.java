// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide;

import com.bumptech.glide.load.model.file_descriptor.FileDescriptorModelLoader;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.bumptech.glide.load.model.stream.StreamByteArrayLoader;
import java.util.Iterator;
import com.bumptech.glide.signature.MediaStoreSignature;
import java.net.URL;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.load.model.stream.MediaStoreStreamLoader;
import android.net.Uri;
import java.io.File;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.signature.StringSignature;
import java.util.UUID;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import com.bumptech.glide.load.model.ModelLoader;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.Lifecycle;
import android.content.Context;
import com.bumptech.glide.manager.LifecycleListener;

public class RequestManager implements LifecycleListener
{
    private final Context context;
    private final Glide glide;
    private final Lifecycle lifecycle;
    private DefaultOptions options;
    private final OptionsApplier optionsApplier;
    private final RequestTracker requestTracker;
    private final RequestManagerTreeNode treeNode;
    
    public RequestManager(final Context context, final Lifecycle lifecycle, final RequestManagerTreeNode requestManagerTreeNode) {
        this(context, lifecycle, requestManagerTreeNode, new RequestTracker(), new ConnectivityMonitorFactory());
    }
    
    RequestManager(final Context context, final Lifecycle lifecycle, final RequestManagerTreeNode treeNode, final RequestTracker requestTracker, final ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.context = context.getApplicationContext();
        this.lifecycle = lifecycle;
        this.treeNode = treeNode;
        this.requestTracker = requestTracker;
        this.glide = Glide.get(context);
        this.optionsApplier = new OptionsApplier();
        final ConnectivityMonitor build = connectivityMonitorFactory.build(context, new RequestManagerConnectivityListener(requestTracker));
        if (Util.isOnBackgroundThread()) {
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public void run() {
                    lifecycle.addListener(RequestManager.this);
                }
            });
        }
        else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
    }
    
    private static <T> Class<T> getSafeClass(final T t) {
        if (t != null) {
            return (Class<T>)t.getClass();
        }
        return null;
    }
    
    private <T> DrawableTypeRequest<T> loadGeneric(final Class<T> obj) {
        final ModelLoader<T, InputStream> buildStreamModelLoader = Glide.buildStreamModelLoader(obj, this.context);
        final ModelLoader<T, ParcelFileDescriptor> buildFileDescriptorModelLoader = Glide.buildFileDescriptorModelLoader(obj, this.context);
        if (obj != null && buildStreamModelLoader == null && buildFileDescriptorModelLoader == null) {
            throw new IllegalArgumentException("Unknown type " + obj + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return this.optionsApplier.apply(new DrawableTypeRequest<T>((Class<Object>)obj, (ModelLoader<Object, InputStream>)buildStreamModelLoader, (ModelLoader<Object, ParcelFileDescriptor>)buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, this.optionsApplier));
    }
    
    public <T> DrawableTypeRequest<T> from(final Class<T> clazz) {
        return (DrawableTypeRequest<T>)this.loadGeneric((Class<Object>)clazz);
    }
    
    public DrawableTypeRequest<byte[]> fromBytes() {
        return (DrawableTypeRequest<byte[]>)(DrawableTypeRequest)this.loadGeneric(byte[].class).signature(new StringSignature(UUID.randomUUID().toString())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
    }
    
    public DrawableTypeRequest<File> fromFile() {
        return this.loadGeneric(File.class);
    }
    
    public DrawableTypeRequest<Uri> fromMediaStore() {
        return this.optionsApplier.apply(new DrawableTypeRequest<Uri>(Uri.class, new MediaStoreStreamLoader(this.context, Glide.buildStreamModelLoader(Uri.class, this.context)), Glide.buildFileDescriptorModelLoader(Uri.class, this.context), this.context, this.glide, this.requestTracker, this.lifecycle, this.optionsApplier));
    }
    
    public DrawableTypeRequest<Integer> fromResource() {
        return (DrawableTypeRequest<Integer>)(DrawableTypeRequest)this.loadGeneric(Integer.class).signature(ApplicationVersionSignature.obtain(this.context));
    }
    
    public DrawableTypeRequest<String> fromString() {
        return this.loadGeneric(String.class);
    }
    
    public DrawableTypeRequest<Uri> fromUri() {
        return this.loadGeneric(Uri.class);
    }
    
    @Deprecated
    public DrawableTypeRequest<URL> fromUrl() {
        return this.loadGeneric(URL.class);
    }
    
    public boolean isPaused() {
        Util.assertMainThread();
        return this.requestTracker.isPaused();
    }
    
    public DrawableTypeRequest<Uri> load(final Uri uri) {
        return (DrawableTypeRequest<Uri>)(DrawableTypeRequest)this.fromUri().load(uri);
    }
    
    public DrawableTypeRequest<File> load(final File file) {
        return (DrawableTypeRequest<File>)(DrawableTypeRequest)this.fromFile().load(file);
    }
    
    public DrawableTypeRequest<Integer> load(final Integer n) {
        return (DrawableTypeRequest<Integer>)(DrawableTypeRequest)this.fromResource().load(n);
    }
    
    public <T> DrawableTypeRequest<T> load(final T t) {
        return (DrawableTypeRequest<T>)(DrawableTypeRequest)this.loadGeneric((Class<Object>)getSafeClass((T)t)).load(t);
    }
    
    public DrawableTypeRequest<String> load(final String s) {
        return (DrawableTypeRequest<String>)(DrawableTypeRequest)this.fromString().load(s);
    }
    
    @Deprecated
    public DrawableTypeRequest<URL> load(final URL url) {
        return (DrawableTypeRequest<URL>)(DrawableTypeRequest)this.fromUrl().load(url);
    }
    
    public DrawableTypeRequest<byte[]> load(final byte[] array) {
        return (DrawableTypeRequest<byte[]>)(DrawableTypeRequest)this.fromBytes().load(array);
    }
    
    @Deprecated
    public DrawableTypeRequest<byte[]> load(final byte[] array, final String s) {
        return (DrawableTypeRequest<byte[]>)this.load(array).signature(new StringSignature(s));
    }
    
    public DrawableTypeRequest<Uri> loadFromMediaStore(final Uri uri) {
        return (DrawableTypeRequest<Uri>)(DrawableTypeRequest)this.fromMediaStore().load(uri);
    }
    
    @Deprecated
    public DrawableTypeRequest<Uri> loadFromMediaStore(final Uri uri, final String s, final long n, final int n2) {
        return (DrawableTypeRequest<Uri>)(DrawableTypeRequest)this.loadFromMediaStore(uri).signature(new MediaStoreSignature(s, n, n2));
    }
    
    @Override
    public void onDestroy() {
        this.requestTracker.clearRequests();
    }
    
    public void onLowMemory() {
        this.glide.clearMemory();
    }
    
    @Override
    public void onStart() {
        this.resumeRequests();
    }
    
    @Override
    public void onStop() {
        this.pauseRequests();
    }
    
    public void onTrimMemory(final int n) {
        this.glide.trimMemory(n);
    }
    
    public void pauseRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }
    
    public void pauseRequestsRecursive() {
        Util.assertMainThread();
        this.pauseRequests();
        final Iterator<RequestManager> iterator = this.treeNode.getDescendants().iterator();
        while (iterator.hasNext()) {
            iterator.next().pauseRequests();
        }
    }
    
    public void resumeRequests() {
        Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }
    
    public void resumeRequestsRecursive() {
        Util.assertMainThread();
        this.resumeRequests();
        final Iterator<RequestManager> iterator = this.treeNode.getDescendants().iterator();
        while (iterator.hasNext()) {
            iterator.next().resumeRequests();
        }
    }
    
    public void setDefaultOptions(final DefaultOptions options) {
        this.options = options;
    }
    
    public <A, T> GenericModelRequest<A, T> using(final ModelLoader<A, T> modelLoader, final Class<T> clazz) {
        return new GenericModelRequest<A, T>(modelLoader, clazz);
    }
    
    public ImageModelRequest<byte[]> using(final StreamByteArrayLoader streamByteArrayLoader) {
        return new ImageModelRequest<byte[]>(streamByteArrayLoader);
    }
    
    public <T> ImageModelRequest<T> using(final StreamModelLoader<T> streamModelLoader) {
        return new ImageModelRequest<T>(streamModelLoader);
    }
    
    public <T> VideoModelRequest<T> using(final FileDescriptorModelLoader<T> fileDescriptorModelLoader) {
        return new VideoModelRequest<T>(fileDescriptorModelLoader);
    }
    
    public interface DefaultOptions
    {
         <T> void apply(final GenericRequestBuilder<T, ?, ?, ?> p0);
    }
    
    public final class GenericModelRequest<A, T>
    {
        private final Class<T> dataClass;
        private final ModelLoader<A, T> modelLoader;
        
        GenericModelRequest(final ModelLoader<A, T> modelLoader, final Class<T> dataClass) {
            this.modelLoader = modelLoader;
            this.dataClass = dataClass;
        }
        
        public GenericTypeRequest from(final Class<A> clazz) {
            return new GenericTypeRequest(clazz);
        }
        
        public GenericTypeRequest load(final A a) {
            return new GenericTypeRequest(a);
        }
        
        public final class GenericTypeRequest
        {
            private final A model;
            private final Class<A> modelClass;
            private final boolean providedModel;
            
            GenericTypeRequest(final Class<A> modelClass) {
                this.providedModel = false;
                this.model = null;
                this.modelClass = modelClass;
            }
            
            GenericTypeRequest(final A model) {
                this.providedModel = true;
                this.model = model;
                this.modelClass = (Class<A>)getSafeClass(model);
            }
            
            public <Z> GenericTranscodeRequest<A, T, Z> as(final Class<Z> clazz) {
                final GenericTranscodeRequest<A, Object, Z> genericTranscodeRequest = RequestManager.this.optionsApplier.apply(new GenericTranscodeRequest<A, Object, Z>(RequestManager.this.context, RequestManager.this.glide, this.modelClass, GenericModelRequest.this.modelLoader, GenericModelRequest.this.dataClass, clazz, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier));
                if (this.providedModel) {
                    genericTranscodeRequest.load(this.model);
                }
                return (GenericTranscodeRequest<A, T, Z>)genericTranscodeRequest;
            }
        }
    }
    
    public final class ImageModelRequest<T>
    {
        private final ModelLoader<T, InputStream> loader;
        
        ImageModelRequest(final ModelLoader<T, InputStream> loader) {
            this.loader = loader;
        }
        
        public DrawableTypeRequest<T> from(final Class<T> clazz) {
            return RequestManager.this.optionsApplier.apply(new DrawableTypeRequest<T>(clazz, this.loader, null, RequestManager.this.context, RequestManager.this.glide, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier));
        }
        
        public DrawableTypeRequest<T> load(final T t) {
            return (DrawableTypeRequest<T>)(DrawableTypeRequest)this.from(getSafeClass(t)).load(t);
        }
    }
    
    class OptionsApplier
    {
        public <A, X extends GenericRequestBuilder<A, ?, ?, ?>> X apply(final X x) {
            if (RequestManager.this.options != null) {
                RequestManager.this.options.apply((GenericRequestBuilder<Object, ?, ?, ?>)x);
            }
            return x;
        }
    }
    
    private static class RequestManagerConnectivityListener implements ConnectivityListener
    {
        private final RequestTracker requestTracker;
        
        public RequestManagerConnectivityListener(final RequestTracker requestTracker) {
            this.requestTracker = requestTracker;
        }
        
        @Override
        public void onConnectivityChanged(final boolean b) {
            if (b) {
                this.requestTracker.restartRequests();
            }
        }
    }
    
    public final class VideoModelRequest<T>
    {
        private final ModelLoader<T, ParcelFileDescriptor> loader;
        
        VideoModelRequest(final ModelLoader<T, ParcelFileDescriptor> loader) {
            this.loader = loader;
        }
        
        public DrawableTypeRequest<T> load(final T t) {
            return (DrawableTypeRequest<T>)(DrawableTypeRequest)RequestManager.this.optionsApplier.apply(new DrawableTypeRequest<T>(getSafeClass(t), null, this.loader, RequestManager.this.context, RequestManager.this.glide, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier)).load(t);
        }
    }
}
