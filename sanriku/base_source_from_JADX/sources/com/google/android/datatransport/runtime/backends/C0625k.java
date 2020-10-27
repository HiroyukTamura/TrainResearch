package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.datatransport.runtime.backends.k */
class C0625k implements C0617e {

    /* renamed from: a */
    private final C0626a f276a;

    /* renamed from: b */
    private final C0623i f277b;

    /* renamed from: c */
    private final Map<String, C0628m> f278c = new HashMap();

    /* renamed from: com.google.android.datatransport.runtime.backends.k$a */
    static class C0626a {

        /* renamed from: a */
        private final Context f279a;

        /* renamed from: b */
        private Map<String, String> f280b = null;

        C0626a(Context context) {
            this.f279a = context;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
        @androidx.annotation.Nullable
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.datatransport.runtime.backends.C0616d mo9548a(java.lang.String r15) {
            /*
                r14 = this;
                java.lang.String r0 = "Could not instantiate %s"
                java.lang.String r1 = "Could not instantiate %s."
                java.util.Map<java.lang.String, java.lang.String> r2 = r14.f280b
                r3 = 0
                java.lang.String r4 = "BackendRegistry"
                r5 = 0
                if (r2 != 0) goto L_0x0093
                android.content.Context r2 = r14.f279a
                android.content.pm.PackageManager r6 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x002f }
                if (r6 != 0) goto L_0x0017
                java.lang.String r2 = "Context has no PackageManager."
                goto L_0x0028
            L_0x0017:
                android.content.ComponentName r7 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x002f }
                java.lang.Class<com.google.android.datatransport.runtime.backends.TransportBackendDiscovery> r8 = com.google.android.datatransport.runtime.backends.TransportBackendDiscovery.class
                r7.<init>(r2, r8)     // Catch:{ NameNotFoundException -> 0x002f }
                r2 = 128(0x80, float:1.794E-43)
                android.content.pm.ServiceInfo r2 = r6.getServiceInfo(r7, r2)     // Catch:{ NameNotFoundException -> 0x002f }
                if (r2 != 0) goto L_0x002c
                java.lang.String r2 = "TransportBackendDiscovery has no service info."
            L_0x0028:
                android.util.Log.w(r4, r2)     // Catch:{ NameNotFoundException -> 0x002f }
                goto L_0x0034
            L_0x002c:
                android.os.Bundle r2 = r2.metaData     // Catch:{ NameNotFoundException -> 0x002f }
                goto L_0x0035
            L_0x002f:
                java.lang.String r2 = "Application info not found."
                android.util.Log.w(r4, r2)
            L_0x0034:
                r2 = r3
            L_0x0035:
                if (r2 != 0) goto L_0x0041
                java.lang.String r2 = "Could not retrieve metadata, returning empty list of transport backends."
                android.util.Log.w(r4, r2)
                java.util.Map r2 = java.util.Collections.emptyMap()
                goto L_0x0091
            L_0x0041:
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                java.util.Set r7 = r2.keySet()
                java.util.Iterator r7 = r7.iterator()
            L_0x004e:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x0090
                java.lang.Object r8 = r7.next()
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r9 = r2.get(r8)
                boolean r10 = r9 instanceof java.lang.String
                if (r10 == 0) goto L_0x004e
                java.lang.String r10 = "backend:"
                boolean r10 = r8.startsWith(r10)
                if (r10 == 0) goto L_0x004e
                java.lang.String r9 = (java.lang.String) r9
                r10 = -1
                java.lang.String r11 = ","
                java.lang.String[] r9 = r9.split(r11, r10)
                int r10 = r9.length
                r11 = 0
            L_0x0075:
                if (r11 >= r10) goto L_0x004e
                r12 = r9[r11]
                java.lang.String r12 = r12.trim()
                boolean r13 = r12.isEmpty()
                if (r13 == 0) goto L_0x0084
                goto L_0x008d
            L_0x0084:
                r13 = 8
                java.lang.String r13 = r8.substring(r13)
                r6.put(r12, r13)
            L_0x008d:
                int r11 = r11 + 1
                goto L_0x0075
            L_0x0090:
                r2 = r6
            L_0x0091:
                r14.f280b = r2
            L_0x0093:
                java.util.Map<java.lang.String, java.lang.String> r2 = r14.f280b
                java.lang.Object r15 = r2.get(r15)
                java.lang.String r15 = (java.lang.String) r15
                if (r15 != 0) goto L_0x009e
                return r3
            L_0x009e:
                r2 = 1
                java.lang.Class r6 = java.lang.Class.forName(r15)     // Catch:{ ClassNotFoundException -> 0x00e3, IllegalAccessException -> 0x00d9, InstantiationException -> 0x00cf, NoSuchMethodException -> 0x00c2, InvocationTargetException -> 0x00b8 }
                java.lang.Class<com.google.android.datatransport.runtime.backends.d> r7 = com.google.android.datatransport.runtime.backends.C0616d.class
                java.lang.Class r6 = r6.asSubclass(r7)     // Catch:{ ClassNotFoundException -> 0x00e3, IllegalAccessException -> 0x00d9, InstantiationException -> 0x00cf, NoSuchMethodException -> 0x00c2, InvocationTargetException -> 0x00b8 }
                java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x00e3, IllegalAccessException -> 0x00d9, InstantiationException -> 0x00cf, NoSuchMethodException -> 0x00c2, InvocationTargetException -> 0x00b8 }
                java.lang.reflect.Constructor r6 = r6.getDeclaredConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00e3, IllegalAccessException -> 0x00d9, InstantiationException -> 0x00cf, NoSuchMethodException -> 0x00c2, InvocationTargetException -> 0x00b8 }
                java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x00e3, IllegalAccessException -> 0x00d9, InstantiationException -> 0x00cf, NoSuchMethodException -> 0x00c2, InvocationTargetException -> 0x00b8 }
                java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ ClassNotFoundException -> 0x00e3, IllegalAccessException -> 0x00d9, InstantiationException -> 0x00cf, NoSuchMethodException -> 0x00c2, InvocationTargetException -> 0x00b8 }
                com.google.android.datatransport.runtime.backends.d r6 = (com.google.android.datatransport.runtime.backends.C0616d) r6     // Catch:{ ClassNotFoundException -> 0x00e3, IllegalAccessException -> 0x00d9, InstantiationException -> 0x00cf, NoSuchMethodException -> 0x00c2, InvocationTargetException -> 0x00b8 }
                return r6
            L_0x00b8:
                r1 = move-exception
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r5] = r15
                java.lang.String r15 = java.lang.String.format(r0, r2)
                goto L_0x00cb
            L_0x00c2:
                r1 = move-exception
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r5] = r15
                java.lang.String r15 = java.lang.String.format(r0, r2)
            L_0x00cb:
                android.util.Log.w(r4, r15, r1)
                goto L_0x00f1
            L_0x00cf:
                r0 = move-exception
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r5] = r15
                java.lang.String r15 = java.lang.String.format(r1, r2)
                goto L_0x00ee
            L_0x00d9:
                r0 = move-exception
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r5] = r15
                java.lang.String r15 = java.lang.String.format(r1, r2)
                goto L_0x00ee
            L_0x00e3:
                r0 = move-exception
                java.lang.Object[] r1 = new java.lang.Object[r2]
                r1[r5] = r15
                java.lang.String r15 = "Class %s is not found."
                java.lang.String r15 = java.lang.String.format(r15, r1)
            L_0x00ee:
                android.util.Log.w(r4, r15, r0)
            L_0x00f1:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.backends.C0625k.C0626a.mo9548a(java.lang.String):com.google.android.datatransport.runtime.backends.d");
        }
    }

    C0625k(Context context, C0623i iVar) {
        C0626a aVar = new C0626a(context);
        this.f276a = aVar;
        this.f277b = iVar;
    }

    @Nullable
    public synchronized C0628m get(String str) {
        if (this.f278c.containsKey(str)) {
            return this.f278c.get(str);
        }
        C0616d a = this.f276a.mo9548a(str);
        if (a == null) {
            return null;
        }
        C0628m create = a.create(this.f277b.mo9546a(str));
        this.f278c.put(str, create);
        return create;
    }
}
