// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class DataLayer
{
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT;
    private static String[] zzbEd;
    private static final Pattern zzbEe;
    private final ConcurrentHashMap<zzb, Integer> zzbEf;
    private final Map<String, Object> zzbEg;
    private final ReentrantLock zzbEh;
    private final LinkedList<Map<String, Object>> zzbEi;
    private final zzc zzbEj;
    private final CountDownLatch zzbEk;
    
    static {
        OBJECT_NOT_PRESENT = new Object();
        DataLayer.zzbEd = "gtm.lifetime".toString().split("\\.");
        zzbEe = Pattern.compile("(\\d+)\\s*([smhd]?)");
    }
    
    DataLayer() {
        this((zzc)new zzao());
    }
    
    DataLayer(final zzc zzbEj) {
        this.zzbEj = zzbEj;
        this.zzbEf = new ConcurrentHashMap<zzb, Integer>();
        this.zzbEg = new HashMap<String, Object>();
        this.zzbEh = new ReentrantLock();
        this.zzbEi = new LinkedList<Map<String, Object>>();
        this.zzbEk = new CountDownLatch(1);
        this.zzbEj.zza(new zzap(this));
    }
    
    public static List<Object> listOf(final Object... array) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length; ++i) {
            list.add(array[i]);
        }
        return list;
    }
    
    public static Map<String, Object> mapOf(final Object... array) {
        if (array.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (int i = 0; i < array.length; i += 2) {
            if (!(array[i] instanceof String)) {
                final String value = String.valueOf(array[i]);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(value).length() + 21).append("key is not a string: ").append(value).toString());
            }
            hashMap.put((String)array[i], array[i + 1]);
        }
        return hashMap;
    }
    
    private final void zza(final Map<String, Object> map, final String s, final Collection<zza> collection) {
        for (final Map.Entry<String, Object> entry : map.entrySet()) {
            String s2;
            if (s.length() == 0) {
                s2 = "";
            }
            else {
                s2 = ".";
            }
            final String s3 = entry.getKey();
            final String string = new StringBuilder(String.valueOf(s).length() + String.valueOf(s2).length() + String.valueOf(s3).length()).append(s).append(s2).append(s3).toString();
            if (entry.getValue() instanceof Map) {
                this.zza(entry.getValue(), string, collection);
            }
            else {
                if (string.equals("gtm.lifetime")) {
                    continue;
                }
                collection.add(new zza(string, entry.getValue()));
            }
        }
    }
    
    private final void zzb(final List<Object> list, final List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); ++i) {
            final List<Object> value = list.get(i);
            if (value instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                this.zzb(value, (List)list2.get(i));
            }
            else if (value instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap<String, Object>());
                }
                this.zzd((Map<String, Object>)value, list2.get(i));
            }
            else if (value != DataLayer.OBJECT_NOT_PRESENT) {
                list2.set(i, value);
            }
        }
    }
    
    private final void zzd(final Map<String, Object> map, final Map<String, Object> map2) {
        for (final String s : map.keySet()) {
            final ArrayList<Object> value = map.get(s);
            if (value instanceof List) {
                if (!(map2.get(s) instanceof List)) {
                    map2.put(s, new ArrayList<Object>());
                }
                this.zzb(value, map2.get(s));
            }
            else if (value instanceof Map) {
                if (!(map2.get(s) instanceof Map)) {
                    map2.put(s, new HashMap());
                }
                this.zzd((Map<String, Object>)value, (Map)map2.get(s));
            }
            else {
                map2.put(s, value);
            }
        }
    }
    
    private static Long zzfd(String s) {
        final Matcher matcher = DataLayer.zzbEe.matcher(s);
        if (!matcher.matches()) {
            s = String.valueOf(s);
            if (s.length() != 0) {
                s = "unknown _lifetime: ".concat(s);
            }
            else {
                s = new String("unknown _lifetime: ");
            }
            zzdj.zzaS(s);
            return null;
        }
        long long1 = 0L;
    Label_0091_Outer:
        while (true) {
            while (true) {
                while (true) {
                    try {
                        long1 = Long.parseLong(matcher.group(1));
                        if (long1 > 0L) {
                            break;
                        }
                        s = String.valueOf(s);
                        if (s.length() != 0) {
                            s = "non-positive _lifetime: ".concat(s);
                            zzdj.zzaS(s);
                            return null;
                        }
                    }
                    catch (NumberFormatException ex) {
                        final String value = String.valueOf(s);
                        String concat;
                        if (value.length() != 0) {
                            concat = "illegal number in _lifetime value: ".concat(value);
                        }
                        else {
                            concat = new String("illegal number in _lifetime value: ");
                        }
                        zzdj.zzaT(concat);
                        long1 = 0L;
                        continue Label_0091_Outer;
                    }
                    break;
                }
                s = new String("non-positive _lifetime: ");
                continue;
            }
        }
        final String group = matcher.group(2);
        if (group.length() == 0) {
            return long1;
        }
        switch (group.charAt(0)) {
            default: {
                s = String.valueOf(s);
                if (s.length() != 0) {
                    s = "unknown units in _lifetime: ".concat(s);
                }
                else {
                    s = new String("unknown units in _lifetime: ");
                }
                zzdj.zzaT(s);
                return null;
            }
            case 's': {
                return long1 * 1000L;
            }
            case 'm': {
                return long1 * 1000L * 60L;
            }
            case 'h': {
                return long1 * 1000L * 60L * 60L;
            }
            case 'd': {
                return long1 * 1000L * 60L * 60L * 24L;
            }
        }
    }
    
    static Map<String, Object> zzn(final String s, final Object o) {
        final HashMap<String, Map<String, Object>> hashMap = (HashMap<String, Map<String, Object>>)new HashMap<String, Map<String, Map<String, Object>>>();
        final String[] split = s.toString().split("\\.");
        int i = 0;
        Map<String, Object> map = (Map<String, Object>)hashMap;
        while (i < split.length - 1) {
            final HashMap<String, Map<String, Map<String, Object>>> hashMap2 = new HashMap<String, Map<String, Map<String, Object>>>();
            map.put(split[i], hashMap2);
            ++i;
            map = (Map<String, Object>)hashMap2;
        }
        map.put(split[split.length - 1], o);
        return (Map<String, Object>)hashMap;
    }
    
    private final void zzr(final Map<String, Object> e) {
        while (true) {
            this.zzbEh.lock();
            // monitorexit(iterator2)
            Label_0203: {
                while (true) {
                    int n;
                    Map<String, Object> map;
                    try {
                        this.zzbEi.offer(e);
                        if (this.zzbEh.getHoldCount() != 1) {
                            break Label_0203;
                        }
                        n = 0;
                        map = this.zzbEi.poll();
                        if (map == null) {
                            break Label_0203;
                        }
                        synchronized (this.zzbEg) {
                            for (final String s : map.keySet()) {
                                this.zzd(zzn(s, map.get(s)), this.zzbEg);
                            }
                        }
                    }
                    finally {
                        this.zzbEh.unlock();
                    }
                    final Iterator<zzb> iterator2 = (Iterator<zzb>)this.zzbEf.keySet().iterator();
                    while (iterator2.hasNext()) {
                        iterator2.next().zzp(map);
                    }
                    ++n;
                    if (n > 500) {
                        this.zzbEi.clear();
                        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                    }
                    continue;
                }
            }
            final Map<String, Object> map2;
            final Object zzs = zzs(map2);
            Long zzfd;
            if (zzs == null) {
                zzfd = null;
            }
            else {
                zzfd = zzfd(zzs.toString());
            }
            if (zzfd != null) {
                final ArrayList<zza> list = new ArrayList<zza>();
                this.zza(map2, "", list);
                this.zzbEj.zza(list, zzfd);
            }
            this.zzbEh.unlock();
        }
    }
    
    private static Object zzs(Map<String, Object> value) {
        final String[] zzbEd = DataLayer.zzbEd;
        final int length = zzbEd.length;
        int n = 0;
        Object o;
        while (true) {
            o = value;
            if (n >= length) {
                break;
            }
            final String s = zzbEd[n];
            if (!(value instanceof Map)) {
                o = null;
                break;
            }
            value = ((Map<String, Object>)value).get(s);
            ++n;
        }
        return o;
    }
    
    public Object get(final String s) {
        while (true) {
            while (true) {
                int n;
                synchronized (this.zzbEg) {
                    final Map<String, Object> zzbEg = this.zzbEg;
                    final String[] split = s.split("\\.");
                    final int length = split.length;
                    final Map<String, Object> map = zzbEg;
                    n = 0;
                    if (n >= length) {
                        return map;
                    }
                    final String s2 = split[n];
                    if (!(map instanceof Map)) {
                        return null;
                    }
                    if (map.get(s2) == null) {
                        return null;
                    }
                }
                ++n;
                continue;
            }
        }
    }
    
    public void push(final String s, final Object o) {
        this.push(zzn(s, o));
    }
    
    public void push(final Map<String, Object> map) {
        while (true) {
            try {
                this.zzbEk.await();
                this.zzr(map);
            }
            catch (InterruptedException ex) {
                zzdj.zzaT("DataLayer.push: unexpected InterruptedException");
                continue;
            }
            break;
        }
    }
    
    public void pushEvent(final String s, final Map<String, Object> m) {
        final HashMap<String, String> hashMap = new HashMap<String, String>((Map<? extends String, ? extends String>)m);
        hashMap.put("event", s);
        this.push((Map<String, Object>)hashMap);
    }
    
    @Override
    public String toString() {
        synchronized (this.zzbEg) {
            final StringBuilder sb = new StringBuilder();
            for (final Map.Entry<String, Object> entry : this.zzbEg.entrySet()) {
                sb.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", entry.getKey(), entry.getValue()));
            }
        }
        final StringBuilder sb2;
        // monitorexit(map)
        return sb2.toString();
    }
    
    final void zza(final zzb key) {
        this.zzbEf.put(key, 0);
    }
    
    final void zzfc(final String s) {
        this.push(s, null);
        this.zzbEj.zzfe(s);
    }
    
    static final class zza
    {
        public final Object mValue;
        public final String zzBN;
        
        zza(final String zzBN, final Object mValue) {
            this.zzBN = zzBN;
            this.mValue = mValue;
        }
        
        @Override
        public final boolean equals(final Object o) {
            if (o instanceof zza) {
                final zza zza = (zza)o;
                if (this.zzBN.equals(zza.zzBN) && this.mValue.equals(zza.mValue)) {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public final int hashCode() {
            return Arrays.hashCode(new Integer[] { this.zzBN.hashCode(), this.mValue.hashCode() });
        }
        
        @Override
        public final String toString() {
            final String zzBN = this.zzBN;
            final String value = String.valueOf(this.mValue.toString());
            return new StringBuilder(String.valueOf(zzBN).length() + 13 + String.valueOf(value).length()).append("Key: ").append(zzBN).append(" value: ").append(value).toString();
        }
    }
    
    interface zzb
    {
        void zzp(final Map<String, Object> p0);
    }
    
    interface zzc
    {
        void zza(final zzaq p0);
        
        void zza(final List<zza> p0, final long p1);
        
        void zzfe(final String p0);
    }
}
