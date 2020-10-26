/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 */
package jp.co.jreast.jreastapp.commuter.common;

import android.content.res.AssetManager;
import com.b.a.b.a.b;
import com.b.a.f;
import com.b.a.s;
import com.b.a.u;
import d.e;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineListInformation;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.d.c;
import kotlin.e.b.j;
import kotlin.i.d;

@Metadata(bv={1, 0, 2}, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\r0\fH\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0016\u001a\u00020\u0011J\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0016\u001a\u00020\u0011J*\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\r2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\r0\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/LocalJsonUtil;", "", "saveDir", "Ljava/io/File;", "okioUtil", "Ljp/co/jreast/jreastapp/commuter/repository/di/OkioUtil;", "assetManager", "Landroid/content/res/AssetManager;", "(Ljava/io/File;Ljp/co/jreast/jreastapp/commuter/repository/di/OkioUtil;Landroid/content/res/AssetManager;)V", "getAssetManager", "()Landroid/content/res/AssetManager;", "fromJsonStringToList", "", "T", "type", "Ljava/lang/reflect/Type;", "jsonString", "", "fromListToJsonString", "list", "getSaveDir", "loadListFromAsset", "filePath", "loadListFromLocalFile", "saveJsonStringToLocalFile", "", "fileName", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class k {
    private final File a;
    private final jp.co.jreast.jreastapp.commuter.m.a.b b;
    private final AssetManager c;

    public k(File file, jp.co.jreast.jreastapp.commuter.m.a.b b2, AssetManager assetManager) {
        j.b(file, "saveDir");
        j.b(b2, "okioUtil");
        j.b((Object)assetManager, "assetManager");
        this.a = file;
        this.b = b2;
        this.c = assetManager;
    }

    private final File a() {
        if (!this.a.exists()) {
            this.a.mkdir();
        }
        return this.a;
    }

    private final <T> String a(Type object, List<? extends T> list) {
        object = u.a((Type)((Object)List.class), new Type[]{object});
        object = new s.a().a(new b()).a().a((Type)object).a(list);
        j.a(object, "adapter.toJson(list)");
        return object;
    }

    private final <T> List<T> a(Type object, String string2) {
        boolean bl2 = ((CharSequence)string2).length() == 0;
        if (bl2) {
            return m.a();
        }
        object = u.a((Type)((Object)List.class), new Type[]{object});
        object = (List)new s.a().a(new b()).a().a((Type)object).a(string2);
        if (object != null) {
            return object;
        }
        return m.a();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final <T> List<T> a(String object) {
        Throwable throwable3222;
        j.b(object, "filePath");
        if (((String)object).hashCode() != 819076795) {
            return m.a();
        }
        if (!((String)object).equals("RailwayList.json")) return m.a();
        object = this.c.open((String)object);
        j.a(object, "assetManager.open(filePath)");
        Closeable closeable = new InputStreamReader((InputStream)object, d.a);
        Throwable throwable2 = null;
        object = throwable2;
        String string2 = c.a((InputStreamReader)closeable);
        kotlin.d.b.a(closeable, throwable2);
        return this.a((Type)((Object)RailwayLineListInformation.class), string2);
        {
            catch (Throwable throwable3222) {
            }
            catch (Throwable throwable4) {}
            object = throwable4;
            {
                throw throwable4;
            }
        }
        kotlin.d.b.a(closeable, (Throwable)object);
        throw throwable3222;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public final <T> void a(String var1_1, Type var2_2, List<? extends T> var3_5) {
        j.b(var1_1, "fileName");
        j.b(var2_2, "type");
        j.b(var3_5, "list");
        var4_6 = this.a();
        if (var1_1.hashCode() != 1716903039) {
            return;
        }
        if (!var1_1.equals("trainLocationHistory.json")) ** GOTO lbl19
        var1_1 = new File(var4_6, (String)var1_1);
        var1_1 = this.b.a((File)var1_1);
        try {
            var1_1.b(this.a(var2_2, var3_5));
            var1_1.flush();
        }
        catch (Throwable var2_3) {
            var1_1.close();
            throw var2_3;
        }
lbl17: // 2 sources:
        do {
            var1_1.close();
lbl19: // 2 sources:
            return;
            break;
        } while (true);
        catch (IOException var2_4) {
            ** continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final <T> List<T> b(String object) {
        Object object2;
        block3 : {
            j.b(object, "filePath");
            object2 = this.a();
            if (((String)object).hashCode() != 1716903039) {
                return m.a();
            }
            if (!((String)object).equals("trainLocationHistory.json")) return m.a();
            object = new File((File)object2, (String)object);
            try {
                object = this.b.b((File)object).p();
                break block3;
            }
            catch (IOException iOException) {}
            object = "";
        }
        object2 = (Type)((Object)RailwayLineInformation.class);
        j.a(object, "jsonData");
        return this.a((Type)object2, (String)object);
    }
}

