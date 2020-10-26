// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import com.google.common.primitives.Primitives;
import javax.annotation.Nullable;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.io.Serializable;

public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable
{
    private final ImmutableMap<Class<? extends B>, B> delegate;
    
    private ImmutableClassToInstanceMap(final ImmutableMap<Class<? extends B>, B> delegate) {
        this.delegate = delegate;
    }
    
    public static <B> Builder<B> builder() {
        return new Builder<B>();
    }
    
    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(final Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap<B>)map;
        }
        return new Builder<B>().putAll((Map<? extends Class<?>, ?>)map).build();
    }
    
    @Override
    protected Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
    
    @Nullable
    @Override
    public <T extends B> T getInstance(final Class<T> clazz) {
        return (T)this.delegate.get(Preconditions.checkNotNull(clazz));
    }
    
    @Deprecated
    @Override
    public <T extends B> T putInstance(final Class<T> clazz, final T t) {
        throw new UnsupportedOperationException();
    }
    
    public static final class Builder<B>
    {
        private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder;
        
        public Builder() {
            this.mapBuilder = ImmutableMap.builder();
        }
        
        private static <B, T extends B> T cast(final Class<T> clazz, final B obj) {
            return Primitives.wrap(clazz).cast(obj);
        }
        
        public ImmutableClassToInstanceMap<B> build() {
            return new ImmutableClassToInstanceMap<B>(this.mapBuilder.build(), null);
        }
        
        public <T extends B> Builder<B> put(final Class<T> clazz, final T t) {
            this.mapBuilder.put((Class<? extends B>)clazz, t);
            return this;
        }
        
        public <T extends B> Builder<B> putAll(final Map<? extends Class<? extends T>, ? extends T> map) {
            for (final Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                final Class<? extends B> clazz = (Class<? extends B>)entry.getKey();
                this.mapBuilder.put(clazz, cast((Class<B>)clazz, (T)entry.getValue()));
            }
            return this;
        }
    }
}
