// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import java.util.Set;

public interface RequestManagerTreeNode
{
    Set<RequestManager> getDescendants();
}
