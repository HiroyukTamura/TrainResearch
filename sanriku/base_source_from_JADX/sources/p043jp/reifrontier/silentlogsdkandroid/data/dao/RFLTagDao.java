package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTag;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTag;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0016"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTagDao;", "", "()V", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "getRflOrmaHolder", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "setRflOrmaHolder", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "deleteUserTag", "", "from", "", "to", "find", "", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityTag;", "getDataFromTag", "", "tag", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTag;", "insert", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLTagDao */
public final class RFLTagDao {
    public RFLOrmaHolder rflOrmaHolder;

    public RFLTagDao() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final byte[] m3812a(RFLTag rFLTag) {
        String json = new Gson().toJson((Object) rFLTag);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(tag)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public final void deleteUserTag(int i, int i2) {
        List<RFLEntityTag> find = find(i, i2);
        ArrayList arrayList = new ArrayList();
        for (T next : find) {
            RFLEntityTag rFLEntityTag = (RFLEntityTag) next;
            boolean z = true;
            if (!(!Intrinsics.areEqual((Object) rFLEntityTag.getTag().getTagOwner(), (Object) "user")) || !(!Intrinsics.areEqual((Object) rFLEntityTag.getTag().getTagOwner(), (Object) "poi.osm"))) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().deleteFromRFLEntityTag().fromDateEq(i).toDateEq(i2).execute();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RFLEntityTag rFLEntityTag2 = (RFLEntityTag) it.next();
            RFLOrmaHolder rFLOrmaHolder2 = this.rflOrmaHolder;
            if (rFLOrmaHolder2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
            }
            rFLOrmaHolder2.getORMA().insertIntoRFLEntityTag(rFLEntityTag2);
        }
    }

    public final List<RFLEntityTag> find(int i) {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        List<RFLEntityTag> list = rFLOrmaHolder.getORMA().selectFromRFLEntityTag().fromDateEq(i).toList();
        Intrinsics.checkExpressionValueIsNotNull(list, "rflOrmaHolder.ORMA\n     …                .toList()");
        return list;
    }

    public final List<RFLEntityTag> find(int i, int i2) {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        List<RFLEntityTag> list = rFLOrmaHolder.getORMA().selectFromRFLEntityTag().fromDateEq(i).toDateEq(i2).toList();
        Intrinsics.checkExpressionValueIsNotNull(list, "rflOrmaHolder.ORMA\n     …                .toList()");
        return list;
    }

    public final RFLOrmaHolder getRflOrmaHolder() {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        return rFLOrmaHolder;
    }

    public final void insert(int i, int i2, RFLTag rFLTag) {
        Intrinsics.checkParameterIsNotNull(rFLTag, "tag");
        RFLEntityTag rFLEntityTag = new RFLEntityTag(i, i2, m3812a(rFLTag));
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().insertIntoRFLEntityTag(rFLEntityTag);
    }

    public final void setRflOrmaHolder(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "<set-?>");
        this.rflOrmaHolder = rFLOrmaHolder;
    }
}
