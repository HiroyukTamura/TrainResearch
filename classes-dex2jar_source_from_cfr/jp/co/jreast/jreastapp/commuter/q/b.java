/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.BitmapDrawable
 */
package jp.co.jreast.jreastapp.commuter.q;

import android.graphics.drawable.BitmapDrawable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatus;
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatusItem;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J9\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\r0\r2\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainservice/TrainServiceConverter;", "", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;)V", "checkShinkansen", "", "id", "", "createList", "", "Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;", "map", "", "Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatus;", "currentArea", "", "(Ljava/util/Map;I)[Ljp/co/jreast/jreastapp/commuter/model/LineServiceStatusItem;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b {
    private final p a;

    public b(p p2) {
        j.b(p2, "translationRepository");
        this.a = p2;
    }

    private final boolean a(String string2) {
        return m.b("86", "87", "88", "89", "90", "-1", "10115").contains(string2);
    }

    public final LineServiceStatusItem[] a(Map<String, ? extends Map<String, LineServiceStatus>> object, int n2) {
        Object map;
        boolean bl2;
        Object object2;
        Object object3 = this;
        j.b(object, "map");
        List<LineServiceStatusItem> list = n2 == LineServiceStatusItem.Area.KANTO.getCode() ? m.c(new LineServiceStatusItem(n2, "-2", LineServiceStatusItem.Type.IMAGE, null, null, null, 0, 64, null)) : (List<LineServiceStatusItem>)new ArrayList();
        Object object4 = object.get("1");
        if (object4 == null) {
            j.a();
        }
        if (((Map)object4).isEmpty() ^ true) {
            if (n2 == LineServiceStatusItem.Area.KANTO.getCode()) {
                object4 = ((b)object3).a.a(2131558519);
                list.add(new LineServiceStatusItem(n2, "-1", LineServiceStatusItem.Type.SUBTITLE, null, (String)object4, null, 0, 64, null));
            }
            object4 = new ArrayList();
            map = object.get("1");
            if (map == null) {
                j.a();
            }
            for (Map.Entry entry : ((Map)map).entrySet()) {
                object2 = (String)entry.getKey();
                LineServiceStatus object5 = (LineServiceStatus)entry.getValue();
                bl2 = n2 != LineServiceStatusItem.Area.KANTO.getCode();
                object5.setDetailVisibility(bl2);
                if (b.super.a((String)object2)) {
                    object4.add(new LineServiceStatusItem(n2, (String)object2, LineServiceStatusItem.Type.ROW, null, null, object5, 0, 64, null));
                    continue;
                }
                list.add(new LineServiceStatusItem(n2, (String)object2, LineServiceStatusItem.Type.ROW, null, null, object5, 0, 64, null));
            }
            if (list.size() > 1) {
                m.a(list, }
        }
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    