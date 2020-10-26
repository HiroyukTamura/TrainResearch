/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 */
package jp.co.jreast.jreastapp.commuter.candidatestation;

import android.content.res.AssetManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.ai;
import jp.co.jreast.jreastapp.commuter.candidatestation.f;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.model.Station;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Ljp/co/jreast/jreastapp/commuter/candidatestation/LocalStationRepository;", "", "csvReader", "Ljp/co/jreast/jreastapp/commuter/CsvReader;", "assetManager", "Landroid/content/res/AssetManager;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "searcher", "Ljp/co/jreast/jreastapp/commuter/candidatestation/LocalStationSearcher;", "(Ljp/co/jreast/jreastapp/commuter/CsvReader;Landroid/content/res/AssetManager;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/candidatestation/LocalStationSearcher;)V", "csvContent", "", "", "", "getCandidateStations", "Ljp/co/jreast/jreastapp/commuter/model/Station;", "stationName", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e {
    private final List<String[]> a;
    private final ai b;
    private AssetManager c;
    private final p d;
    private final f e;

    public e(ai object, AssetManager assetManager, p p2, f f2) {
        j.b(object, "csvReader");
        j.b((Object)assetManager, "assetManager");
        j.b(p2, "translationRepository");
        j.b(f2, "searcher");
        this.b = object;
        this.c = assetManager;
        this.d = p2;
        this.e = f2;
        object = this.d.a(2131558493);
        this.a = this.b.a(this.c, (String)object);
    }

    public /* synthetic */ e(ai ai2, AssetManager assetManager, p p2, f f2, int n2, g g2) {
        if ((n2 & 1) != 0) {
            ai2 = new ai();
        }
        this(ai2, assetManager, p2, f2);
    }

    public final List<Station> a(String object) {
        Object object2;
        j.b(object, "stationName");
        boolean bl2 = ((CharSequence)object).length() == 0;
        if (bl2) {
            return m.a();
        }
        object = this.e.a((String)object);
        Collection<Object> collection = this.e.a((String)object, this.a);
        Collection<Object> collection2 = this.e.b((String)object, (List<String[]>)collection);
        Object object3 = this.e.c((String)object, (List<String[]>)collection2);
        object = this.e.d((String)object, (List<String[]>)object3);
        Iterator iterator = collection;
        collection = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (collection2.contains((String[])object2)) continue;
            collection.add(object2);
        }
        iterator = collection2;
        collection2 = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (object3.contains((String[])object2)) continue;
            collection2.add(object2);
        }
        iterator = (Iterable)object3;
        object3 = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (object.contains((String[])object2)) continue;
            object3.add(object2);
        }
        object3 = m.b(m.b(m.b((Collection)object, (Iterable)object3), (Iterable)collection2), (Iterable)collection);
        object = new ArrayList(m.a(object3, 10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            collection = (String[])object3.next();
            object.add(new Station((String)((Object)collection[0]), (String)((Object)collection[1])));
        }
        return (List)object;
    }
}

