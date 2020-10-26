/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import com.b.a.f;
import com.b.a.s;
import com.b.a.u;
import d.d;
import d.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.m.a.b;
import jp.co.jreast.jreastapp.commuter.model.Station;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.z;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u000f\u001a\u00020\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\bJ\b\u0010\u001b\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/UserStationHistoryRepository;", "", "saveDir", "Ljava/io/File;", "okioUtil", "Ljp/co/jreast/jreastapp/commuter/repository/di/OkioUtil;", "stationList", "", "Ljp/co/jreast/jreastapp/commuter/model/Station;", "(Ljava/io/File;Ljp/co/jreast/jreastapp/commuter/repository/di/OkioUtil;Ljava/util/List;)V", "saveFileName", "", "saveFilePath", "getSaveFilePath", "()Ljava/io/File;", "count", "", "get", "", "getMoshiAdaptor", "Lcom/squareup/moshi/JsonAdapter;", "register", "", "station", "remove", "rename", "renameStation", "save", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class t {
    public static final a a = new a(null);
    private final String b;
    private final File c;
    private final b d;
    private final List<Station> e;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public t(File list, b list2, List<Station> list3) {
        block4 : {
            j.b(list, "saveDir");
            j.b(list2, "okioUtil");
            j.b(list3, "stationList");
            this.d = list2;
            this.e = list3;
            this.b = "candidateStationHistory.json";
            this.c = new File((File)((Object)list), this.b);
            try {
                list = this.d.b(this.c).p();
                break block4;
            }
            catch (FileNotFoundException fileNotFoundException) {}
            list = "";
        }
        list2 = (CharSequence)((Object)list);
        if (list2 == null) return;
        if (n.a((CharSequence)((Object)list2))) {
            return;
        }
        boolean bl2 = false;
        if (bl2) {
            return;
        }
        list2 = this.e;
        list = this.d().a((String)((Object)list));
        if (list == null) throw new kotlin.t("null cannot be cast to non-null type kotlin.collections.MutableList<jp.co.jreast.jreastapp.commuter.model.Station>");
        list2.addAll(z.a(list));
    }

    public /* synthetic */ t(File file, b b2, List list, int n2, g g2) {
        if ((n2 & 4) != 0) {
            list = new ArrayList();
        }
        this(file, b2, list);
    }

    private final void c() {
        String string2 = this.d().a(this.e);
        d d2 = this.d.a(this.c);
        d2.b(string2);
        d2.flush();
        d2.close();
    }

    private final f<List<Station>> d() {
        f<List<Station>> f2 = new s.a().a(new com.b.a.b.a.b()).a().a(u.a((Type)((Object)List.class), new Type[]{(Type)((Object)Station.class)}));
        j.a(f2, "moshi.adapter<List<Station>>(type)");
        return f2;
    }

    public final int a() {
        return this.e.size();
    }

    public final void a(Station station) {
        j.b(station, "station");
        Object object = this.e;
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!j.a((Object)((Station)e2).getCode(), (Object)station.getCode())) continue;
            collection.add(e2);
        }
        if ((collection = (Collection)((List)collection)).isEmpty() ^ true) {
            this.e.removeAll(collection);
        }
        if (this.e.size() == 20) {
            this.e.remove(19);
        }
        this.e.add(0, station);
        this.c();
    }

    public final List<Station> b() {
        return this.e;
    }

    public final void b(Station station) {
        j.b(station, "renameStation");
        Iterator iterator = ((Iterable)this.e).iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            if (j.a((Object)((Station)iterator.next()).getCode(), (Object)station.getCode())) {
                this.e.set(n2, station);
                return;
            }
            ++n2;
        }
    }

    public final void c(Station station) {
        j.b(station, "station");
        this.e.remove(station);
        this.c();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/UserStationHistoryRepository$Companion;", "", "()V", "LIMIT_HISTORY", "", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

