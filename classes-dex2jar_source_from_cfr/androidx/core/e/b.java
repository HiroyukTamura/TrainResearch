/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.pm.Signature
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Handler
 */
package androidx.core.e;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.c.e;
import androidx.c.g;
import androidx.core.a.a.f;
import androidx.core.e.c;
import androidx.core.graphics.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class b {
    static final e<String, Typeface> a = new e(16);
    static final Object b;
    static final g<String, ArrayList<c.a<c>>> c;
    private static final androidx.core.e.c d;
    private static final Comparator<byte[]> e;

    static {
        d = new androidx.core.e.c("fonts", 10, 10000);
        b = new Object();
        c = new g();
        e = new Comparator<byte[]>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public int a(byte[] arrby, byte[] arrby2) {
                int n2;
                int n3;
                if (arrby.length != arrby2.length) {
                    n2 = arrby.length;
                    n3 = arrby2.length;
                    do {
                        return n2 - n3;
                        break;
                    } while (true);
                }
                for (n2 = 0; n2 < arrby.length; ++n2) {
                    if (arrby[n2] == arrby2[n2]) continue;
                    n3 = arrby[n2];
                    int n4 = arrby2[n2];
                    n2 = n3;
                    n3 = n4;
                    return n2 - n3;
                }
                return 0;
            }

            @Override
            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((byte[])object, (byte[])object2);
            }
        };
    }

    public static ProviderInfo a(PackageManager object, androidx.core.e.a object2, Resources object3) {
        String string2 = ((androidx.core.e.a)object2).a();
        ProviderInfo providerInfo = object.resolveContentProvider(string2, 0);
        if (providerInfo != null) {
            if (providerInfo.packageName.equals(((androidx.core.e.a)object2).b())) {
                object = b.a(object.getPackageInfo((String)providerInfo.packageName, (int)64).signatures);
                Collections.sort(object, e);
                object2 = b.a((androidx.core.e.a)object2, object3);
                for (int i2 = 0; i2 < object2.size(); ++i2) {
                    object3 = new ArrayList((Collection)object2.get(i2));
                    Collections.sort(object3, e);
                    if (!b.a((List<byte[]>)object, (List<byte[]>)object3)) continue;
                    return providerInfo;
                }
                return null;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Found content provider ");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(", but package was not ");
            ((StringBuilder)object).append(((androidx.core.e.a)object2).b());
            throw new PackageManager.NameNotFoundException(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No package found for authority: ");
        ((StringBuilder)object).append(string2);
        throw new PackageManager.NameNotFoundException(((StringBuilder)object).toString());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static Typeface a(Context object, androidx.core.e.a object2, f.a object3, Handler object4, boolean bl2, int n2, int n3) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append(((androidx.core.e.a)object2).f());
        charSequence.append("-");
        charSequence.append(n3);
        charSequence = charSequence.toString();
        Typeface typeface = a.a((String)charSequence);
        if (typeface != null) {
            if (object3 == null) return typeface;
            ((f.a)object3).a(typeface);
            return typeface;
        }
        if (bl2 && n2 == -1) {
            object = b.a((Context)object, (androidx.core.e.a)object2, n3);
            if (object3 == null) return ((c)object).a;
            if (((c)object).b == 0) {
                ((f.a)object3).a(((c)object).a, (Handler)object4);
                return ((c)object).a;
            }
            ((f.a)object3).a(((c)object).b, (Handler)object4);
            return ((c)object).a;
        }
        object2 = new Callable<c>((Context)object, (androidx.core.e.a)object2, n3, (String)charSequence){
            final /* synthetic */ Context a;
            final /* synthetic */ androidx.core.e.a b;
            final /* synthetic */ int c;
            final /* synthetic */ String d;
            {
                this.a = context;
                this.b = a2;
                this.c = n2;
                this.d = string2;
            }

            public c a() {
                c c2 = b.a(this.a, this.b, this.c);
                if (c2.a != null) {
                    b.a.a(this.d, c2.a);
                }
                return c2;
            }

            @Override
            public /* synthetic */ Object call() {
                return this.a();
            }
        };
        if (bl2) {
            return ((c)b.d.a(object2, (int)n2)).a;
        }
        object = object3 == null ? null : new c.a<c>((f.a)object3, (Handler)object4){
            final /* synthetic */ f.a a;
            final /* synthetic */ Handler b;
            {
                this.a = a2;
                this.b = handler;
            }

            @Override
            public void a(c c2) {
                if (c2 == null) {
                    this.a.a(1, this.b);
                    return;
                }
                if (c2.b == 0) {
                    this.a.a(c2.a, this.b);
                    return;
                }
                this.a.a(c2.b, this.b);
            }
        };
        object3 = b;
        // MONITORENTER : object3
        if (c.containsKey(charSequence)) {
            if (object != null) {
                c.get(charSequence).add((c.a<c>)object);
            }
            // MONITOREXIT : object3
            return null;
        }
        if (object != null) {
            object4 = new ArrayList();
            ((ArrayList)object4).add(object);
            c.put((String)charSequence, (ArrayList<c.a<c>>)object4);
        }
        // MONITOREXIT : object3
        d.a(object2, new c.a<c>((String)charSequence){
            final /* synthetic */ String a;
            {
                this.a = string2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(c c2) {
                ArrayList<c.a<c>> arrayList;
                Object object = b.b;
                synchronized (object) {
                    arrayList = b.c.get(this.a);
                    if (arrayList == null) {
                        return;
                    }
                    b.c.remove(this.a);
                }
                int n2 = 0;
                while (n2 < arrayList.size()) {
                    arrayList.get(n2).a(c2);
                    ++n2;
                }
                return;
            }
        });
        return null;
        catch (InterruptedException interruptedException) {
            return null;
        }
    }

    public static a a(Context context, CancellationSignal cancellationSignal, androidx.core.e.a a2) {
        ProviderInfo providerInfo = b.a(context.getPackageManager(), a2, context.getResources());
        if (providerInfo == null) {
            return new a(1, null);
        }
        return new a(0, b.a(context, a2, providerInfo.authority, cancellationSignal));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static c a(Context context, androidx.core.e.a object, int n2) {
        try {
            object = b.a(context, null, (androidx.core.e.a)object);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return new c(null, -1);
        }
        int n3 = ((a)object).a();
        int n4 = -3;
        if (n3 == 0) {
            if ((context = androidx.core.graphics.c.a(context, null, ((a)object).b(), n2)) == null) return new c((Typeface)context, n4);
            n4 = 0;
            return new c((Typeface)context, n4);
        }
        if (((a)object).a() != 1) return new c(null, n4);
        n4 = -2;
        return new c(null, n4);
    }

    private static List<List<byte[]>> a(androidx.core.e.a a2, Resources resources) {
        if (a2.d() != null) {
            return a2.d();
        }
        return androidx.core.a.a.c.a(resources, a2.e());
    }

    private static List<byte[]> a(Signature[] arrsignature) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        for (int i2 = 0; i2 < arrsignature.length; ++i2) {
            arrayList.add(arrsignature[i2].toByteArray());
        }
        return arrayList;
    }

    public static Map<Uri, ByteBuffer> a(Context context, b[] arrb, CancellationSignal cancellationSignal) {
        HashMap<b, ByteBuffer> hashMap = new HashMap<b, ByteBuffer>();
        for (b b2 : arrb) {
            if (b2.e() != 0 || hashMap.containsKey(b2 = b2.a())) continue;
            hashMap.put(b2, i.a(context, cancellationSignal, (Uri)b2));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (Arrays.equals(list.get(i2), list2.get(i2))) continue;
            return false;
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static b[] a(Context var0, androidx.core.e.a var1_2, String var2_3, CancellationSignal var3_4) {
        var14_5 = new ArrayList<E>();
        var16_6 = new Uri.Builder().scheme("content").authority(var2_3).build();
        var17_7 = new Uri.Builder().scheme("content").authority(var2_3).appendPath("file").build();
        var15_8 = null;
        var2_3 = var15_8;
        try {
            block15 : {
                if (Build.VERSION.SDK_INT > 16) {
                    var2_3 = var15_8;
                    var0 = var0.getContentResolver();
                    var2_3 = var15_8;
                    var1_2 = var1_2.c();
                    var2_3 = var15_8;
                    var0 = var0.query(var16_6, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{var1_2}, null, (CancellationSignal)var3_4);
                } else {
                    var2_3 = var15_8;
                    var0 = var0.getContentResolver();
                    var2_3 = var15_8;
                    var1_2 = var1_2.c();
                    var2_3 = var15_8;
                    var0 = var0.query(var16_6, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{var1_2}, null);
                }
                var1_2 = var14_5;
                if (var0 == null) break block15;
                var1_2 = var14_5;
                var2_3 = var0;
                if (var0.getCount() <= 0) break block15;
                var2_3 = var0;
                var7_9 = var0.getColumnIndex("result_code");
                var2_3 = var0;
                var3_4 = new ArrayList<E>();
                var2_3 = var0;
                var8_10 = var0.getColumnIndex("_id");
                var2_3 = var0;
                var9_11 = var0.getColumnIndex("file_id");
                var2_3 = var0;
                var10_12 = var0.getColumnIndex("font_ttc_index");
                var2_3 = var0;
                var11_13 = var0.getColumnIndex("font_weight");
                var2_3 = var0;
                var12_14 = var0.getColumnIndex("font_italic");
                do {
                    var2_3 = var0;
                    if (!var0.moveToNext()) break;
                    if (var7_9 != -1) {
                        var2_3 = var0;
                        var4_15 = var0.getInt(var7_9);
                    } else {
                        var4_15 = 0;
                    }
                    if (var10_12 != -1) {
                        var2_3 = var0;
                        var5_16 = var0.getInt(var10_12);
                    } else {
                        var5_16 = 0;
                    }
                    if (var9_11 == -1) {
                        var2_3 = var0;
                        var1_2 = ContentUris.withAppendedId((Uri)var16_6, (long)var0.getLong(var8_10));
                    } else {
                        var2_3 = var0;
                        var1_2 = ContentUris.withAppendedId((Uri)var17_7, (long)var0.getLong(var9_11));
                    }
                    if (var11_13 != -1) {
                        var2_3 = var0;
                        var6_17 = var0.getInt(var11_13);
                    } else {
                        var6_17 = 400;
                    }
                    if (var12_14 == -1) ** GOTO lbl-1000
                    var2_3 = var0;
                    if (var0.getInt(var12_14) == 1) {
                        var13_18 = true;
                    } else lbl-1000: // 2 sources:
                    {
                        var13_18 = false;
                    }
                    var2_3 = var0;
                    var3_4.add(new b((Uri)var1_2, var5_16, var6_17, var13_18, var4_15));
                } while (true);
                var1_2 = var3_4;
            }
            if (var0 == null) return var1_2.toArray(new b[0]);
        }
        catch (Throwable var0_1) {
            if (var2_3 == null) throw var0_1;
            var2_3.close();
            throw var0_1;
        }
        var0.close();
        return var1_2.toArray(new b[0]);
    }

    public static class a {
        private final int a;
        private final b[] b;

        public a(int n2, b[] arrb) {
            this.a = n2;
            this.b = arrb;
        }

        public int a() {
            return this.a;
        }

        public b[] b() {
            return this.b;
        }
    }

    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public b(Uri uri, int n2, int n3, boolean bl2, int n4) {
            this.a = androidx.core.g.e.a(uri);
            this.b = n2;
            this.c = n3;
            this.d = bl2;
            this.e = n4;
        }

        public Uri a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    private static final class c {
        final Typeface a;
        final int b;

        c(Typeface typeface, int n2) {
            this.a = typeface;
            this.b = n2;
        }
    }

}

