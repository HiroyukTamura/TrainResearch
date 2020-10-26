/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 */
package jp.co.jreast.jreastapp.commuter;

import android.content.res.AssetManager;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d.b;
import kotlin.d.c;
import kotlin.e.b.j;
import kotlin.i.d;
import kotlin.i.n;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\n"}, d2={"Ljp/co/jreast/jreastapp/commuter/CsvReader;", "", "()V", "getCsvContent", "", "", "", "assetManager", "Landroid/content/res/AssetManager;", "fileName", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class ai {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final List<String[]> a(AssetManager object, String iterator) {
        Throwable throwable2222;
        j.b(object, "assetManager");
        j.b(iterator, "fileName");
        object = object.open(iterator);
        j.a(object, "assetManager.open(fileName)");
        Object object2 = new InputStreamReader((InputStream)object, d.a);
        iterator = null;
        object = iterator;
        String string2 = c.a((InputStreamReader)object2);
        b.a((Closeable)object2, (Throwable)((Object)iterator));
        iterator = n.b((CharSequence)n.a(string2, "\r", "\n", false, 4, null), new String[]{"\n"}, false, 0, 6, null);
        object = new ArrayList();
        iterator = ((Iterable)((Object)iterator)).iterator();
        while (iterator.hasNext()) {
            object2 = n.b((CharSequence)((String)iterator.next()), new String[]{","}, false, 0, 6, null);
            if (object2.size() != 3) continue;
            if (object2 == null) throw new t("null cannot be cast to non-null type java.util.Collection<T>");
            if ((object2 = object2.toArray(new String[0])) == null) throw new t("null cannot be cast to non-null type kotlin.Array<T>");
            ((ArrayList)object).add(object2);
        }
        return (List)object;
        {
            catch (Throwable throwable2222) {
            }
            catch (Throwable throwable3) {}
            object = throwable3;
            {
                throw throwable3;
            }
        }
        b.a((Closeable)object2, (Throwable)object);
        throw throwable2222;
    }
}

