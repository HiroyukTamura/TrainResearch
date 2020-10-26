// 
// Decompiled by Procyon v0.5.36
// 

package com.google.protobuf;

import java.util.logging.Logger;

abstract class GeneratedExtensionRegistryLoader<T extends zzd>
{
    private static final Logger logger;
    
    static {
        logger = Logger.getLogger(zzb.class.getName());
    }
    
    protected abstract T getInstance();
}
