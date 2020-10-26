// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation<T> implements Transformation<T>
{
    private String id;
    private final Collection<? extends Transformation<T>> transformations;
    
    public MultiTransformation(final Collection<? extends Transformation<T>> transformations) {
        if (transformations.size() < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = transformations;
    }
    
    @SafeVarargs
    public MultiTransformation(final Transformation<T>... a) {
        if (a.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = Arrays.asList(a);
    }
    
    @Override
    public String getId() {
        if (this.id == null) {
            final StringBuilder sb = new StringBuilder();
            final Iterator<? extends Transformation<T>> iterator = this.transformations.iterator();
            while (iterator.hasNext()) {
                sb.append(((Transformation)iterator.next()).getId());
            }
            this.id = sb.toString();
        }
        return this.id;
    }
    
    @Override
    public Resource<T> transform(final Resource<T> obj, final int n, final int n2) {
        Resource<T> resource = obj;
        final Iterator<? extends Transformation<T>> iterator = this.transformations.iterator();
        while (iterator.hasNext()) {
            final Resource<T> transform = ((Transformation<T>)iterator.next()).transform(resource, n, n2);
            if (resource != null && !resource.equals(obj) && !resource.equals(transform)) {
                resource.recycle();
            }
            resource = transform;
        }
        return resource;
    }
}
