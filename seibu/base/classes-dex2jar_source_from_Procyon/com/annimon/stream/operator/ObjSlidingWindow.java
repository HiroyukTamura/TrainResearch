// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Collection;
import java.util.ArrayList;
import com.annimon.stream.internal.Compat;
import java.util.Queue;
import java.util.Iterator;
import java.util.List;
import com.annimon.stream.iterator.LsaIterator;

public class ObjSlidingWindow<T> extends LsaIterator<List<T>>
{
    private final Iterator<? extends T> iterator;
    private final Queue<T> queue;
    private final int stepWidth;
    private final int windowSize;
    
    public ObjSlidingWindow(final Iterator<? extends T> iterator, final int windowSize, final int stepWidth) {
        this.iterator = iterator;
        this.windowSize = windowSize;
        this.stepWidth = stepWidth;
        this.queue = Compat.queue();
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public List<T> nextIteration() {
        for (int size = this.queue.size(); size < this.windowSize && this.iterator.hasNext(); ++size) {
            this.queue.offer((T)this.iterator.next());
        }
        final ArrayList<T> list = new ArrayList<T>((Collection<? extends T>)this.queue);
        for (int min = Math.min(this.queue.size(), this.stepWidth), i = 0; i < min; ++i) {
            this.queue.poll();
        }
        for (int windowSize = this.windowSize; windowSize < this.stepWidth && this.iterator.hasNext(); ++windowSize) {
            this.iterator.next();
        }
        return list;
    }
}
