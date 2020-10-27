package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import com.google.android.gms.actions.SearchIntents;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p015c.p016a.p017a.p018a.C0695c;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag_Deleter;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag_Relation;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag_Schema;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cR\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyTagDao;", "", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "relation", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityDailyTag_Relation;", "getRelation", "()Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityDailyTag_Relation;", "schema", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityDailyTag_Schema;", "getSchema", "()Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityDailyTag_Schema;", "deleteBefore", "", "targetDay", "Ljava/util/Calendar;", "find", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityDailyTag;", "date", "Ljava/util/Date;", "findByTag", "", "query", "", "save", "dailyTag", "updateTime", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyTagDao */
public final class RFLDailyTagDao {

    /* renamed from: a */
    private final RFLOrmaHolder f3335a;

    public RFLDailyTagDao(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "rflOrmaHolder");
        this.f3335a = rFLOrmaHolder;
    }

    /* renamed from: a */
    private final RFLEntityDailyTag_Relation m3809a() {
        RFLEntityDailyTag_Relation relationOfRFLEntityDailyTag = this.f3335a.getORMA().relationOfRFLEntityDailyTag();
        Intrinsics.checkExpressionValueIsNotNull(relationOfRFLEntityDailyTag, "rflOrmaHolder.ORMA.relationOfRFLEntityDailyTag()");
        return relationOfRFLEntityDailyTag;
    }

    /* renamed from: b */
    private final RFLEntityDailyTag_Schema m3810b() {
        RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema = RFLEntityDailyTag_Schema.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(rFLEntityDailyTag_Schema, "RFLEntityDailyTag_Schema.INSTANCE");
        return rFLEntityDailyTag_Schema;
    }

    public final void deleteBefore(Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "targetDay");
        RFLEntityDailyTag_Deleter deleteFromRFLEntityDailyTag = this.f3335a.getORMA().deleteFromRFLEntityDailyTag();
        Date time = calendar.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "targetDay.time");
        deleteFromRFLEntityDailyTag.dateLt(RFLDailyUtilsKt.second(time)).execute();
    }

    public final RFLEntityDailyTag find(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        return (RFLEntityDailyTag) this.f3335a.getORMA().selectFromRFLEntityDailyTag().dateEq(RFLDailyUtilsKt.second(RFLDailyUtilsKt.start(date))).valueOrNull();
    }

    public final List<RFLEntityDailyTag> findByTag(String str) {
        Intrinsics.checkParameterIsNotNull(str, SearchIntents.EXTRA_QUERY);
        RFLEntityDailyTag_Relation a = m3809a();
        StringBuilder sb = new StringBuilder();
        C0695c<RFLEntityDailyTag, String> cVar = m3810b().dailyTag;
        Intrinsics.checkExpressionValueIsNotNull(cVar, "schema.dailyTag");
        sb.append(cVar.getEscapedName());
        sb.append(" LIKE ?");
        String sb2 = sb.toString();
        List<RFLEntityDailyTag> list = ((RFLEntityDailyTag_Relation) a.where((CharSequence) sb2, '%' + str + '%')).selector().toList();
        Intrinsics.checkExpressionValueIsNotNull(list, "relation.where(\"${schema…                .toList()");
        return list;
    }

    public final void save(Date date, String str, int i) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Intrinsics.checkParameterIsNotNull(str, "dailyTag");
        this.f3335a.getORMA().prepareInsertIntoRFLEntityDailyTag(5).mo19796a(new RFLEntityDailyTag(date, str, i));
    }
}
