// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.module;

import java.util.Iterator;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import android.content.Context;

public final class ManifestParser
{
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private final Context context;
    
    public ManifestParser(final Context context) {
        this.context = context;
    }
    
    private static GlideModule parseModule(String ex) {
        try {
            final Serializable forName;
            ex = (ClassNotFoundException)(forName = Class.forName((String)ex));
            final GlideModule glideModule = ((Class<GlideModule>)forName).newInstance();
            final GlideModule glideModule3;
            final GlideModule glideModule2 = glideModule3 = glideModule;
            final boolean b = glideModule3 instanceof GlideModule;
            if (!b) {
                final StringBuilder sb = new StringBuilder();
                final String s = "Expected instanceof GlideModule, but found: ";
                final StringBuilder sb2 = sb.append(s);
                final GlideModule glideModule4 = glideModule2;
                final StringBuilder sb3 = sb2.append(glideModule4);
                final String s2 = sb3.toString();
                throw new RuntimeException(s2);
            }
            return glideModule2;
        }
        catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", ex);
        }
        GlideModule glideModule2;
        try {
            final Serializable forName = ex;
            final GlideModule glideModule = ((Class<GlideModule>)forName).newInstance();
            final GlideModule glideModule3;
            glideModule2 = (glideModule3 = glideModule);
            final boolean b = glideModule3 instanceof GlideModule;
            if (!b) {
                final StringBuilder sb = new StringBuilder();
                final String s = "Expected instanceof GlideModule, but found: ";
                final StringBuilder sb2 = sb.append(s);
                final GlideModule glideModule4 = glideModule2;
                final StringBuilder sb3 = sb2.append(glideModule4);
                final String s2 = sb3.toString();
                throw new RuntimeException(s2);
            }
        }
        catch (InstantiationException cause) {
            throw new RuntimeException("Unable to instantiate GlideModule implementation for " + ex, cause);
        }
        catch (IllegalAccessException cause2) {
            throw new RuntimeException("Unable to instantiate GlideModule implementation for " + ex, cause2);
        }
        return glideModule2;
    }
    
    public List<GlideModule> parse() {
        final ArrayList<GlideModule> list = new ArrayList<GlideModule>();
        try {
            final ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                for (final String s : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(s))) {
                        list.add(parseModule(s));
                    }
                }
            }
        }
        catch (PackageManager$NameNotFoundException cause) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", (Throwable)cause);
        }
        return list;
    }
}
