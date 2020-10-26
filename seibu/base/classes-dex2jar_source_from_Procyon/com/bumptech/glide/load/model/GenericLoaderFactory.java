// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import java.util.Iterator;
import java.util.HashMap;
import com.bumptech.glide.load.data.DataFetcher;
import android.content.Context;
import java.util.Map;

public class GenericLoaderFactory
{
    private static final ModelLoader NULL_MODEL_LOADER;
    private final Map<Class, Map<Class, ModelLoader>> cachedModelLoaders;
    private final Context context;
    private final Map<Class, Map<Class, ModelLoaderFactory>> modelClassToResourceFactories;
    
    static {
        NULL_MODEL_LOADER = new ModelLoader() {
            @Override
            public DataFetcher getResourceFetcher(final Object o, final int n, final int n2) {
                throw new NoSuchMethodError("This should never be called!");
            }
            
            @Override
            public String toString() {
                return "NULL_MODEL_LOADER";
            }
        };
    }
    
    public GenericLoaderFactory(final Context context) {
        this.modelClassToResourceFactories = new HashMap<Class, Map<Class, ModelLoaderFactory>>();
        this.cachedModelLoaders = new HashMap<Class, Map<Class, ModelLoader>>();
        this.context = context.getApplicationContext();
    }
    
    private <T, Y> void cacheModelLoader(final Class<T> clazz, final Class<Y> clazz2, final ModelLoader<T, Y> modelLoader) {
        Object o;
        if ((o = this.cachedModelLoaders.get(clazz)) == null) {
            o = new HashMap<Class<Y>, ModelLoader<T, Y>>();
            this.cachedModelLoaders.put(clazz, (Map<Class, ModelLoader>)o);
        }
        ((Map<Class<Y>, ModelLoader<T, Y>>)o).put(clazz2, modelLoader);
    }
    
    private <T, Y> void cacheNullLoader(final Class<T> clazz, final Class<Y> clazz2) {
        this.cacheModelLoader(clazz, clazz2, GenericLoaderFactory.NULL_MODEL_LOADER);
    }
    
    private <T, Y> ModelLoader<T, Y> getCachedLoader(final Class<T> clazz, final Class<Y> clazz2) {
        final Map<Class, ModelLoader> map = this.cachedModelLoaders.get(clazz);
        ModelLoader<T, Y> modelLoader = null;
        if (map != null) {
            modelLoader = map.get(clazz2);
        }
        return modelLoader;
    }
    
    private <T, Y> ModelLoaderFactory<T, Y> getFactory(final Class<T> clazz, final Class<Y> clazz2) {
        final Map<Class, ModelLoaderFactory> map = this.modelClassToResourceFactories.get(clazz);
        ModelLoaderFactory<T, Y> modelLoaderFactory = null;
        if (map != null) {
            modelLoaderFactory = map.get(clazz2);
        }
        ModelLoaderFactory<T, Y> modelLoaderFactory2;
        if ((modelLoaderFactory2 = modelLoaderFactory) == null) {
            final Iterator<Class> iterator = this.modelClassToResourceFactories.keySet().iterator();
            while (true) {
                modelLoaderFactory2 = modelLoaderFactory;
                if (!iterator.hasNext()) {
                    break;
                }
                final Class clazz3 = iterator.next();
                if (!clazz3.isAssignableFrom(clazz)) {
                    continue;
                }
                final Map<Class, ModelLoaderFactory> map2 = this.modelClassToResourceFactories.get(clazz3);
                if (map2 == null) {
                    continue;
                }
                modelLoaderFactory2 = (ModelLoaderFactory<T, Y>)map2.get(clazz2);
                if ((modelLoaderFactory = modelLoaderFactory2) != null) {
                    break;
                }
            }
        }
        return modelLoaderFactory2;
    }
    
    public <T, Y> ModelLoader<T, Y> buildModelLoader(final Class<T> clazz, final Class<Y> clazz2) {
        while (true) {
            Object o = null;
            synchronized (this) {
                final ModelLoader<T, Object> cachedLoader = this.getCachedLoader((Class<T>)clazz, (Class<Object>)clazz2);
                if (cachedLoader != null) {
                    if (GenericLoaderFactory.NULL_MODEL_LOADER.equals(cachedLoader)) {
                        o = null;
                    }
                    else {
                        o = cachedLoader;
                    }
                    return (ModelLoader<T, Y>)o;
                }
                final ModelLoaderFactory<T, Y> factory = this.getFactory((Class<T>)clazz, clazz2);
                if (factory != null) {
                    this.cacheModelLoader((Class<T>)clazz, clazz2, (ModelLoader<T, Y>)factory.build(this.context, this));
                    return (ModelLoader<T, Y>)o;
                }
                this.cacheNullLoader((Class<T>)clazz, clazz2);
            }
            return (ModelLoader<T, Y>)o;
        }
    }
    
    @Deprecated
    public <T, Y> ModelLoader<T, Y> buildModelLoader(final Class<T> clazz, final Class<Y> clazz2, final Context context) {
        synchronized (this) {
            return this.buildModelLoader(clazz, clazz2);
        }
    }
    
    public <T, Y> ModelLoaderFactory<T, Y> register(final Class<T> clazz, final Class<Y> clazz2, final ModelLoaderFactory<T, Y> modelLoaderFactory) {
        synchronized (this) {
            this.cachedModelLoaders.clear();
            Object o;
            if ((o = this.modelClassToResourceFactories.get(clazz)) == null) {
                o = new HashMap<Class<Y>, ModelLoaderFactory<T, Y>>();
                this.modelClassToResourceFactories.put(clazz, (Map<Class, ModelLoaderFactory>)o);
            }
            final ModelLoaderFactory<T, Y> modelLoaderFactory2 = ((Map<Class<Y>, ModelLoaderFactory<T, Y>>)o).put(clazz2, modelLoaderFactory);
            ModelLoaderFactory<T, Y> modelLoaderFactory3;
            if ((modelLoaderFactory3 = modelLoaderFactory2) != null) {
                final Iterator<Map<Class, ModelLoaderFactory>> iterator = this.modelClassToResourceFactories.values().iterator();
                do {
                    modelLoaderFactory3 = modelLoaderFactory2;
                    if (iterator.hasNext()) {
                        continue;
                    }
                    return modelLoaderFactory3;
                } while (!iterator.next().containsValue(modelLoaderFactory2));
                modelLoaderFactory3 = null;
            }
            return modelLoaderFactory3;
        }
    }
    
    public <T, Y> ModelLoaderFactory<T, Y> unregister(final Class<T> clazz, final Class<Y> clazz2) {
        synchronized (this) {
            this.cachedModelLoaders.clear();
            final ModelLoaderFactory<T, Y> modelLoaderFactory = null;
            final Map<Class, ModelLoaderFactory> map = this.modelClassToResourceFactories.get(clazz);
            ModelLoaderFactory<T, Y> modelLoaderFactory2 = modelLoaderFactory;
            if (map != null) {
                modelLoaderFactory2 = map.remove(clazz2);
            }
            return modelLoaderFactory2;
        }
    }
}
