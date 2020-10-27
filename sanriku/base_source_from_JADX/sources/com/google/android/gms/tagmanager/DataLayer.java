package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p009e.p010a.p011a.p012a.C0681a;

@VisibleForTesting
public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    private static final String[] zzafn = "gtm.lifetime".split("\\.");
    private static final Pattern zzafo = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<zzb, Integer> zzafp;
    private final Map<String, Object> zzafq;
    private final ReentrantLock zzafr;
    private final LinkedList<Map<String, Object>> zzafs;
    private final zzc zzaft;
    /* access modifiers changed from: private */
    public final CountDownLatch zzafu;

    static final class zza {
        public final String mKey;
        public final Object mValue;

        zza(String str, Object obj) {
            this.mKey = str;
            this.mValue = obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return this.mKey.equals(zza.mKey) && this.mValue.equals(zza.mValue);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.mKey.hashCode()), Integer.valueOf(this.mValue.hashCode())});
        }

        public final String toString() {
            String str = this.mKey;
            String obj = this.mValue.toString();
            return C0681a.m314a(C0681a.m336b(obj, C0681a.m336b(str, 13)), "Key: ", str, " value: ", obj);
        }
    }

    interface zzb {
        void zzc(Map<String, Object> map);
    }

    interface zzc {
        void zza(zzaq zzaq);

        void zza(List<zza> list, long j);

        void zzas(String str);
    }

    @VisibleForTesting
    DataLayer() {
        this(new zzao());
    }

    DataLayer(zzc zzc2) {
        this.zzaft = zzc2;
        this.zzafp = new ConcurrentHashMap<>();
        this.zzafq = new HashMap();
        this.zzafr = new ReentrantLock();
        this.zzafs = new LinkedList<>();
        this.zzafu = new CountDownLatch(1);
        this.zzaft.zza(new zzap(this));
    }

    @VisibleForTesting
    public static List<Object> listOf(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object add : objArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    @VisibleForTesting
    public static Map<String, Object> mapOf(Object... objArr) {
        if (objArr.length % 2 == 0) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (i < objArr.length) {
                if (objArr[i] instanceof String) {
                    hashMap.put(objArr[i], objArr[i + 1]);
                    i += 2;
                } else {
                    String valueOf = String.valueOf(objArr[i]);
                    throw new IllegalArgumentException(C0681a.m312a(valueOf.length() + 21, "key is not a string: ", valueOf));
                }
            }
            return hashMap;
        }
        throw new IllegalArgumentException("expected even number of key-value pairs");
    }

    @VisibleForTesting
    private final void zza(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add((Object) null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                zza((List<Object>) (List) obj, (List<Object>) (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                zzb((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    private final void zza(Map<String, Object> map, String str, Collection<zza> collection) {
        for (Map.Entry next : map.entrySet()) {
            String str2 = str.length() == 0 ? "" : ".";
            String str3 = (String) next.getKey();
            String a = C0681a.m313a(C0681a.m336b(str3, str2.length() + str.length()), str, str2, str3);
            if (next.getValue() instanceof Map) {
                zza((Map) next.getValue(), a, collection);
            } else if (!a.equals("gtm.lifetime")) {
                collection.add(new zza(a, next.getValue()));
            }
        }
    }

    @VisibleForTesting
    private static Long zzar(String str) {
        long j;
        long j2;
        long j3;
        Matcher matcher = zzafo.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            zzdi.zzaw(valueOf.length() != 0 ? "unknown _lifetime: ".concat(valueOf) : new String("unknown _lifetime: "));
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            zzdi.zzac(valueOf2.length() != 0 ? "illegal number in _lifetime value: ".concat(valueOf2) : new String("illegal number in _lifetime value: "));
            j = 0;
        }
        if (j <= 0) {
            String valueOf3 = String.valueOf(str);
            zzdi.zzaw(valueOf3.length() != 0 ? "non-positive _lifetime: ".concat(valueOf3) : new String("non-positive _lifetime: "));
            return null;
        }
        String group = matcher.group(2);
        if (group.length() == 0) {
            return Long.valueOf(j);
        }
        char charAt = group.charAt(0);
        if (charAt != 'd') {
            if (charAt == 'h') {
                j3 = j * 1000 * 60;
            } else if (charAt == 'm') {
                j3 = j * 1000;
            } else if (charAt != 's') {
                String valueOf4 = String.valueOf(str);
                zzdi.zzac(valueOf4.length() != 0 ? "unknown units in _lifetime: ".concat(valueOf4) : new String("unknown units in _lifetime: "));
                return null;
            } else {
                j2 = j * 1000;
            }
            j2 = j3 * 60;
        } else {
            j2 = j * 1000 * 60 * 60 * 24;
        }
        return Long.valueOf(j2);
    }

    @VisibleForTesting
    private final void zzb(Map<String, Object> map, Map<String, Object> map2) {
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof List) {
                if (!(map2.get(next) instanceof List)) {
                    map2.put(next, new ArrayList());
                }
                zza((List<Object>) (List) obj, (List<Object>) (List) map2.get(next));
            } else if (obj instanceof Map) {
                if (!(map2.get(next) instanceof Map)) {
                    map2.put(next, new HashMap());
                }
                zzb((Map) obj, (Map) map2.get(next));
            } else {
                map2.put(next, obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zze(Map<String, Object> map) {
        Long l;
        this.zzafr.lock();
        try {
            this.zzafs.offer(map);
            int i = 0;
            if (this.zzafr.getHoldCount() == 1) {
                int i2 = 0;
                while (true) {
                    Map poll = this.zzafs.poll();
                    if (poll == null) {
                        break;
                    }
                    synchronized (this.zzafq) {
                        for (String str : poll.keySet()) {
                            zzb(zzg(str, poll.get(str)), this.zzafq);
                        }
                    }
                    for (zzb zzc2 : this.zzafp.keySet()) {
                        zzc2.zzc(poll);
                    }
                    i2++;
                    if (i2 > 500) {
                        this.zzafs.clear();
                        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                    }
                }
            }
            String[] strArr = zzafn;
            int length = strArr.length;
            Object obj = map;
            while (true) {
                l = null;
                if (i >= length) {
                    break;
                }
                String str2 = strArr[i];
                if (!(obj instanceof Map)) {
                    obj = null;
                    break;
                } else {
                    obj = ((Map) obj).get(str2);
                    i++;
                }
            }
            if (obj != null) {
                l = zzar(obj.toString());
            }
            if (l != null) {
                ArrayList arrayList = new ArrayList();
                zza(map, "", arrayList);
                this.zzaft.zza(arrayList, l.longValue());
            }
            this.zzafr.unlock();
        } catch (Throwable th) {
            this.zzafr.unlock();
            throw th;
        }
    }

    static Map<String, Object> zzg(String str, Object obj) {
        HashMap hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        HashMap hashMap2 = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap3 = new HashMap();
            hashMap2.put(split[i], hashMap3);
            i++;
            hashMap2 = hashMap3;
        }
        hashMap2.put(split[split.length - 1], obj);
        return hashMap;
    }

    public Object get(String str) {
        synchronized (this.zzafq) {
            Object obj = this.zzafq;
            for (String str2 : str.split("\\.")) {
                if (!(obj instanceof Map)) {
                    return null;
                }
                obj = ((Map) obj).get(str2);
                if (obj == null) {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String str, Object obj) {
        push(zzg(str, obj));
    }

    public void push(Map<String, Object> map) {
        try {
            this.zzafu.await();
        } catch (InterruptedException unused) {
            zzdi.zzac("DataLayer.push: unexpected InterruptedException");
        }
        zze(map);
    }

    public void pushEvent(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("event", str);
        push(hashMap);
    }

    public String toString() {
        String sb;
        synchronized (this.zzafq) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : this.zzafq.entrySet()) {
                sb2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{next.getKey(), next.getValue()}));
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzb zzb2) {
        this.zzafp.put(zzb2, 0);
    }

    /* access modifiers changed from: package-private */
    public final void zzaq(String str) {
        push(str, (Object) null);
        this.zzaft.zzas(str);
    }
}
