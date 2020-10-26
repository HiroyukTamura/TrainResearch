// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class zzg extends PathClassLoader
{
    zzg(final String s, final ClassLoader classLoader) {
        super(s, classLoader);
    }
    
    protected final Class<?> loadClass(final String s, final boolean b) throws ClassNotFoundException {
        if (!s.startsWith("java.") && !s.startsWith("android.")) {
            try {
                return (Class<?>)this.findClass(s);
            }
            catch (ClassNotFoundException ex) {}
        }
        return (Class<?>)super.loadClass(s, b);
    }
}
