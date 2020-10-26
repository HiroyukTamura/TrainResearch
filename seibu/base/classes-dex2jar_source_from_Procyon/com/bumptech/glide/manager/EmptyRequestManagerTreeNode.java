// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.manager;

import java.util.Collections;
import com.bumptech.glide.RequestManager;
import java.util.Set;

final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode
{
    @Override
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
