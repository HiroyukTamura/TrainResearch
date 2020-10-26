// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
import java.util.HashSet;
import android.database.ContentObserver;
import android.os.Handler;
import java.util.TreeMap;
import java.util.Map;
import android.database.Cursor;
import android.content.ContentResolver;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import android.net.Uri;

public class hi
{
    private static Uri CONTENT_URI;
    private static Uri zzbUa;
    private static Pattern zzbUb;
    private static Pattern zzbUc;
    private static final AtomicBoolean zzbUd;
    private static HashMap<String, String> zzbUe;
    private static HashMap<String, Boolean> zzbUf;
    private static HashMap<String, Integer> zzbUg;
    private static HashMap<String, Long> zzbUh;
    private static HashMap<String, Float> zzbUi;
    private static Object zzbUj;
    private static boolean zzbUk;
    private static String[] zzbUl;
    
    static {
        hi.CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
        hi.zzbUa = Uri.parse("content://com.google.android.gsf.gservices/prefix");
        hi.zzbUb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        hi.zzbUc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
        zzbUd = new AtomicBoolean();
        hi.zzbUf = new HashMap<String, Boolean>();
        hi.zzbUg = new HashMap<String, Integer>();
        hi.zzbUh = new HashMap<String, Long>();
        hi.zzbUi = new HashMap<String, Float>();
        hi.zzbUl = new String[0];
    }
    
    public static long getLong(final ContentResolver contentResolver, final String s, long long1) {
        final Object zzb = zzb(contentResolver);
        final Long n = zza(hi.zzbUh, s, 0L);
        if (n != null) {
            return n;
        }
        final String zza = zza(contentResolver, s, null);
        while (true) {
            Label_0092: {
                if (zza != null) {
                    break Label_0092;
                }
                Long value = n;
                long1 = 0L;
                final HashMap<String, Long> zzbUh = hi.zzbUh;
                synchronized (hi.class) {
                    if (zzb == hi.zzbUj) {
                        zzbUh.put(s, value);
                        hi.zzbUe.remove(s);
                    }
                    return long1;
                }
                try {
                    long1 = Long.parseLong(zza);
                    value = long1;
                }
                catch (NumberFormatException ex) {
                    value = n;
                    long1 = 0L;
                }
            }
            continue;
        }
    }
    
    private static <T> T zza(final HashMap<String, T> hashMap, final String s, final T t) {
        while (true) {
            synchronized (hi.class) {
                if (!hashMap.containsKey(s)) {
                    return null;
                }
                final T value = hashMap.get(s);
                if (value != null) {
                    return value;
                }
            }
            return t;
        }
    }
    
    public static String zza(final ContentResolver contentResolver, String s, String s2) {
    Label_0193_Outer:
        while (true) {
            final String s3 = null;
            s2 = null;
            Object zzbUl = null;
            // monitorexit(hi.class)
            Object zzbUj = null;
            Label_0155: {
            Label_0150:
                while (true) {
                    int n = 0;
                    Label_0297: {
                        synchronized (hi.class) {
                            zza(contentResolver);
                            zzbUj = hi.zzbUj;
                            if (hi.zzbUe.containsKey(s)) {
                                s = hi.zzbUe.get(s);
                                String s4 = (String)zzbUl;
                                if (s != null) {
                                    s4 = s;
                                }
                                return s4;
                            }
                            zzbUl = hi.zzbUl;
                            final int length = ((String)zzbUl).length;
                            n = 0;
                            if (n >= length) {
                                break Label_0155;
                            }
                            if (!s.startsWith(zzbUl[n])) {
                                break Label_0297;
                            }
                            if (!hi.zzbUk || hi.zzbUe.isEmpty()) {
                                zzc(contentResolver, hi.zzbUl);
                                if (hi.zzbUe.containsKey(s)) {
                                    s = hi.zzbUe.get(s);
                                    String s5 = s3;
                                    if (s != null) {
                                        s5 = s;
                                    }
                                    return s5;
                                }
                            }
                        }
                        break Label_0150;
                    }
                    ++n;
                    continue Label_0193_Outer;
                }
                return null;
            }
            // monitorexit(hi.class)
            final Cursor query = contentResolver.query(hi.CONTENT_URI, (String[])null, (String)null, new String[] { s }, (String)null);
            while (true) {
                if (query != null) {
                    try {
                        if (!query.moveToFirst()) {
                            zza(zzbUj, s, null);
                            return null;
                        }
                        final String string = query.getString(1);
                        String s6;
                        if ((s6 = string) != null) {
                            s6 = string;
                            if (string.equals(null)) {
                                s6 = null;
                            }
                        }
                        zza(zzbUj, s, s6);
                        s = s2;
                        if (s6 != null) {
                            s = s6;
                        }
                        return s;
                    }
                    finally {
                        if (query != null) {
                            query.close();
                        }
                    }
                    return;
                }
                continue;
            }
        }
    }
    
    private static Map<String, String> zza(ContentResolver query, final String... array) {
        query = (ContentResolver)query.query(hi.zzbUa, (String[])null, (String)null, array, (String)null);
        final TreeMap<String, String> treeMap = new TreeMap<String, String>();
        if (query == null) {
            return treeMap;
        }
        try {
            while (((Cursor)query).moveToNext()) {
                treeMap.put(((Cursor)query).getString(0), ((Cursor)query).getString(1));
            }
        }
        finally {
            ((Cursor)query).close();
        }
        ((Cursor)query).close();
        return;
    }
    
    private static void zza(final ContentResolver contentResolver) {
        if (hi.zzbUe == null) {
            hi.zzbUd.set(false);
            hi.zzbUe = new HashMap<String, String>();
            hi.zzbUj = new Object();
            hi.zzbUk = false;
            contentResolver.registerContentObserver(hi.CONTENT_URI, true, (ContentObserver)new hj(null));
        }
        else if (hi.zzbUd.getAndSet(false)) {
            hi.zzbUe.clear();
            hi.zzbUf.clear();
            hi.zzbUg.clear();
            hi.zzbUh.clear();
            hi.zzbUi.clear();
            hi.zzbUj = new Object();
            hi.zzbUk = false;
        }
    }
    
    private static void zza(final Object o, final String key, final String value) {
        synchronized (hi.class) {
            if (o == hi.zzbUj) {
                hi.zzbUe.put(key, value);
            }
        }
    }
    
    private static Object zzb(final ContentResolver contentResolver) {
        synchronized (hi.class) {
            zza(contentResolver);
            return hi.zzbUj;
        }
    }
    
    public static void zzb(final ContentResolver contentResolver, String... array) {
        int n = 0;
        if (array.length == 0) {
            return;
        }
        while (true) {
            while (true) {
                Label_0189: {
                Label_0176:
                    while (true) {
                        final HashSet<Object> set;
                        final ArrayList<String> list;
                        synchronized (hi.class) {
                            zza(contentResolver);
                            set = new HashSet<Object>((hi.zzbUl.length + array.length << 2) / 3 + 1);
                            set.addAll(Arrays.asList(hi.zzbUl));
                            list = new ArrayList<String>();
                            final int length = array.length;
                            if (n < length) {
                                final String s = array[n];
                                if (set.add(s)) {
                                    list.add(s);
                                }
                                break Label_0189;
                            }
                            else if (list.isEmpty()) {
                                array = new String[0];
                                if (!hi.zzbUk || hi.zzbUe.isEmpty()) {
                                    zzc(contentResolver, hi.zzbUl);
                                    return;
                                }
                                break Label_0176;
                            }
                        }
                        hi.zzbUl = set.toArray(new String[set.size()]);
                        array = list.toArray(new String[list.size()]);
                        continue;
                    }
                    if (array.length != 0) {
                        zzc(contentResolver, array);
                        return;
                    }
                    return;
                }
                ++n;
                continue;
            }
        }
    }
    
    private static void zzc(final ContentResolver contentResolver, final String[] array) {
        hi.zzbUe.putAll(zza(contentResolver, array));
        hi.zzbUk = true;
    }
}
