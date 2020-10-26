// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import android.content.SharedPreferences;
import java.util.Iterator;
import android.support.annotation.NonNull;
import android.content.Context;
import java.util.HashSet;
import java.util.HashMap;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.Map;

public class Once
{
    private static Map<String, Set<Integer>> hostMap;
    private static Map<Integer, Once> runMap;
    private WeakReference<Object> host;
    private Set<String> runSet;
    
    static {
        Once.runMap = new HashMap<Integer, Once>();
        Once.hostMap = new HashMap<String, Set<Integer>>();
    }
    
    private Once() {
        this.runSet = new HashSet<String>();
    }
    
    private Once(final Object referent) {
        this.runSet = new HashSet<String>();
        this.host = new WeakReference<Object>(referent);
    }
    
    private static void addHost(final Object o) {
        final String name = o.getClass().getName();
        final int hashCode = o.hashCode();
        Set<Integer> set;
        if ((set = Once.hostMap.get(name)) == null) {
            set = new HashSet<Integer>();
            Once.hostMap.put(name, set);
        }
        set.add(hashCode);
    }
    
    public static Once app(@NonNull final Context context) {
        return AppOnce.instance(context.getApplicationContext());
    }
    
    public static Once host(@NonNull final Object o) {
        addHost(o);
        final Integer value = o.hashCode();
        Once once;
        if ((once = Once.runMap.get(value)) == null) {
            once = new Once(o);
            Once.runMap.put(value, once);
        }
        return once;
    }
    
    private static void purgeOthers(final Object o) {
        if (o != null) {
            final String name = o.getClass().getName();
            final int hashCode = o.hashCode();
            final Set<Integer> set = Once.hostMap.get(name);
            if (set != null) {
                for (final Integer n : set) {
                    if (n != Integer.valueOf(hashCode)) {
                        Once.runMap.remove(n);
                    }
                }
            }
        }
    }
    
    private boolean runIfExists(final Set<String> set, final String s, final Runnable runnable) {
        if (!set.contains(s)) {
            set.add(s);
            runnable.run();
            return true;
        }
        return false;
    }
    
    public OnceNg run(@NonNull final String s, @NonNull final Runnable runnable) {
        return new OnceNg(this, this.runIfExists(this.runSet, s, runnable));
    }
    
    public Once self() {
        purgeOthers(this.host);
        return this;
    }
    
    private static class AppOnce extends Once
    {
        private static String PREF_NAME;
        private static AppOnce _instance;
        SharedPreferences pref;
        
        static {
            AppOnce.PREF_NAME = "ONCE";
        }
        
        private AppOnce(final Context context) {
            super(null);
            this.pref = context.getSharedPreferences(AppOnce.PREF_NAME, 0);
        }
        
        public static Once instance(final Context context) {
            if (AppOnce._instance == null) {
                AppOnce._instance = new AppOnce(context);
            }
            return AppOnce._instance;
        }
        
        @Override
        public OnceNg run(@NonNull final String s, @NonNull final Runnable runnable) {
            boolean b = false;
            if (!this.pref.getBoolean(s, false)) {
                this.pref.edit().putBoolean(s, (boolean)Boolean.TRUE).commit();
                runnable.run();
                b = true;
            }
            return new OnceNg(this, b);
        }
    }
    
    public static class OnceNg
    {
        private boolean ok;
        private Once once;
        
        public OnceNg(final Once once, final boolean ok) {
            this.once = once;
            this.ok = ok;
        }
        
        public Once ng(final Runnable runnable) {
            if (!this.ok) {
                runnable.run();
            }
            return this.once;
        }
    }
}
