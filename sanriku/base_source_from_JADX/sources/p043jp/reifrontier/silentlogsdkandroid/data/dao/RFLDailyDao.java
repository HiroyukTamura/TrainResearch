package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import android.database.Cursor;
import com.google.gson.Gson;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDaily;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDaily_Deleter;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDaily_Relation;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDaily_Schema;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.DateEx;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyDao;", "", "()V", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "getRflOrmaHolder", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "setRflOrmaHolder", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "deleteBefore", "", "targetDay", "Ljava/util/Calendar;", "find", "", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityDaily;", "dateString", "", "timezone", "getDataFromList", "", "daily", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "insert", "updateByDateTimezone", "updateDaily", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyDao */
public final class RFLDailyDao {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public RFLOrmaHolder rflOrmaHolder;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyDao$Companion;", "", "()V", "DATE_FORMAT", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyDao$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RFLDailyDao() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final byte[] m3808a(RFLDaily rFLDaily) {
        String json = new Gson().toJson((Object) rFLDaily);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(daily)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public final void deleteBefore(Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "targetDay");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        RFLEntityDaily_Relation relationOfRFLEntityDaily = rFLOrmaHolder.getORMA().relationOfRFLEntityDaily();
        Intrinsics.checkExpressionValueIsNotNull(relationOfRFLEntityDaily, "rflOrmaHolder.ORMA.relationOfRFLEntityDaily()");
        Cursor executeWithColumns = relationOfRFLEntityDaily.selector().executeWithColumns(RFLEntityDaily_Schema.INSTANCE.date.name);
        Intrinsics.checkExpressionValueIsNotNull(executeWithColumns, "relation.selector().exec…chema.INSTANCE.date.name)");
        if (executeWithColumns.getCount() != 0) {
            executeWithColumns.moveToFirst();
            RFLEntityDaily_Deleter rFLEntityDaily_Deleter = (RFLEntityDaily_Deleter) relationOfRFLEntityDaily.deleter().mo19938or();
            long timeInMillis = calendar.getTimeInMillis();
            boolean z = false;
            do {
                String string = executeWithColumns.getString(0);
                DateEx dateEx = DateEx.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(string, "dbDate");
                Date parse = dateEx.parse(string, "yyyy-MM-dd");
                if (parse != null && parse.getTime() < timeInMillis) {
                    rFLEntityDaily_Deleter.dateEq(string);
                    z = true;
                }
            } while (executeWithColumns.moveToNext());
            executeWithColumns.close();
            if (z) {
                rFLEntityDaily_Deleter.execute();
            }
        }
    }

    public final List<RFLEntityDaily> find(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        List<RFLEntityDaily> list = rFLOrmaHolder.getORMA().selectFromRFLEntityDaily().dateEq(str).timezoneEq(str2).toList();
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

    public final void insert(String str, String str2, RFLDaily rFLDaily) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        Intrinsics.checkParameterIsNotNull(rFLDaily, "daily");
        RFLEntityDaily rFLEntityDaily = new RFLEntityDaily(str, str2, m3808a(rFLDaily));
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().prepareInsertIntoRFLEntityDaily(5).mo19796a(rFLEntityDaily);
    }

    public final void setRflOrmaHolder(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "<set-?>");
        this.rflOrmaHolder = rFLOrmaHolder;
    }

    public final void updateByDateTimezone(RFLDaily rFLDaily, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(rFLDaily, "updateDaily");
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(str2, "timezone");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().updateRFLEntityDaily().dateEq(str).timezoneEq(str2).data(m3808a(rFLDaily)).execute();
    }
}
