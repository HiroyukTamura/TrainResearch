/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.common.k;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineListInformation;
import jp.co.jreast.jreastapp.commuter.model.RailwayListKind;
import jp.co.jreast.jreastapp.commuter.trainlocation.l;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u000bJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;", "", "jsonUtil", "Ljp/co/jreast/jreastapp/commuter/common/LocalJsonUtil;", "searcher", "Ljp/co/jreast/jreastapp/commuter/trainlocation/LocalRailwaySearcher;", "(Ljp/co/jreast/jreastapp/commuter/common/LocalJsonUtil;Ljp/co/jreast/jreastapp/commuter/trainlocation/LocalRailwaySearcher;)V", "railwayFileList", "", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineListInformation;", "getAppName", "", "pageType", "", "getAreaKindId", "getAreaKindName", "getCandidateRailways", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "lineName", "getCount", "getRailwayInformationByUrl", "url", "getRailways", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class f {
    private final List<RailwayLineListInformation> a;
    private final l b;

    public f(k k2, l l2) {
        j.b(k2, "jsonUtil");
        j.b(l2, "searcher");
        this.b = l2;
        this.a = k2.a("RailwayList.json");
    }

    public final int a() {
        return ((Collection)this.a).size();
    }

    public final List<RailwayLineInformation> a(int n2) {
        Object object2;
        block2 : {
            for (Object object2 : (Iterable)this.a) {
                boolean bl2 = ((RailwayLineListInformation)object2).getKind().getKindId() == n2;
                if (!bl2) continue;
                break block2;
            }
            object2 = null;
        }
        object2 = (RailwayLineListInformation)object2;
        if (object2 != null && (object2 = ((RailwayLineListInformation)object2).getLines()) != null) {
            return object2;
        }
        return m.a();
    }

    public final List<RailwayLineInformation> a(String object) {
        Object object2;
        j.b(object, "lineName");
        boolean bl2 = ((CharSequence)object).length() == 0;
        if (bl2) {
            return m.a();
        }
        Collection<RailwayLineInformation> collection = new ArrayList();
        Object object3 = this.a.iterator();
        while (object3.hasNext()) {
            collection.addAll((Collection)object3.next().getLines());
        }
        object = this.b.a((String)object);
        object3 = this.b.a((String)object, (List<RailwayLineInformation>)collection);
        Collection<RailwayLineInformation> collection2 = this.b.b((String)object, (List<RailwayLineInformation>)object3);
        collection = this.b.c((String)object, (List<RailwayLineInformation>)collection2);
        object = this.b.d((String)object, (List<RailwayLineInformation>)collection);
        Iterator iterator = (Iterable)object3;
        object3 = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (collection2.contains((RailwayLineInformation)object2)) continue;
            object3.add(object2);
        }
        object3 = (List)object3;
        iterator = collection2;
        collection2 = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (collection.contains((RailwayLineInformation)object2)) continue;
            collection2.add((RailwayLineInformation)object2);
        }
        iterator = collection;
        collection = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (object.contains((RailwayLineInformation)object2)) continue;
            collection.add((RailwayLineInformation)object2);
        }
        return m.b(m.b(m.b((Collection)object, (Iterable)collection), (Iterable)collection2), (Iterable)object3);
    }

    public final int b(int n2) {
        int n3;
        Object object;
        block4 : {
            block3 : {
                boolean bl2;
                Iterator iterator = ((Iterable)this.a).iterator();
                do {
                    boolean bl3 = iterator.hasNext();
                    n3 = 0;
                    if (!bl3) break block3;
                } while (!(bl2 = ((RailwayLineListInformation)(object = (Object)iterator.next())).getKind().getKindId() == n2));
                break block4;
            }
            object = null;
        }
        object = (RailwayLineListInformation)object;
        n2 = n3;
        if (object != null) {
            object = ((RailwayLineListInformation)object).getKind();
            n2 = n3;
            if (object != null) {
                n2 = ((RailwayListKind)object).getKindId();
            }
        }
        return n2;
    }

    public final RailwayLineInformation b(String object) {
        j.b(object, "url");
        Object object2 = null;
        if (n.b((CharSequence)object, (CharSequence)"com-static/ew01/static/trainnet/trainnetTop.html", false, 2, null)) {
            Iterator<RailwayLineListInformation> iterator = this.a.iterator();
            object = object2;
            while (iterator.hasNext()) {
                block6 : {
                    object2 = ((Iterable)iterator.next().getLines()).iterator();
                    while (object2.hasNext()) {
                        object = object2.next();
                        if (!j.a((Object)((RailwayLineInformation)object).getJrId(), (Object)"68")) continue;
                        break block6;
                    }
                    object = null;
                }
                object = object2 = (RailwayLineInformation)object;
                if (object2 == null) continue;
                return object2;
            }
        } else {
            String string2 = n.c((String)object, "lineCode=", null, 2, null);
            Iterator<RailwayLineListInformation> iterator = this.a.iterator();
            object = object2;
            while (iterator.hasNext()) {
                block7 : {
                    object2 = ((Iterable)iterator.next().getLines()).iterator();
                    while (object2.hasNext()) {
                        object = object2.next();
                        if (!j.a((Object)((RailwayLineInformation)object).getLineCode(), (Object)string2)) continue;
                        break block7;
                    }
                    object = null;
                }
                object = object2 = (RailwayLineInformation)object;
                if (object2 == null) continue;
                object = object2;
                break;
            }
        }
        return object;
    }

    public final String c(int n2) {
        Object object2;
        block2 : {
            for (Object object2 : (Iterable)this.a) {
                boolean bl2 = ((RailwayLineListInformation)object2).getKind().getKindId() == n2;
                if (!bl2) continue;
                break block2;
            }
            object2 = null;
        }
        object2 = (RailwayLineListInformation)object2;
        if (object2 != null && (object2 = ((RailwayLineListInformation)object2).getKind()) != null && (object2 = ((RailwayListKind)object2).getKindName()) != null) {
            return object2;
        }
        return "";
    }

    public final String d(int n2) {
        Object object2;
        block2 : {
            for (Object object2 : (Iterable)this.a) {
                boolean bl2 = ((RailwayLineListInformation)object2).getKind().getKindId() == n2;
                if (!bl2) continue;
                break block2;
            }
            object2 = null;
        }
        object2 = (RailwayLineListInformation)object2;
        if (object2 != null && (object2 = ((RailwayLineListInformation)object2).getKind()) != null && (object2 = ((RailwayListKind)object2).getAppName()) != null) {
            return object2;
        }
        return "";
    }
}

