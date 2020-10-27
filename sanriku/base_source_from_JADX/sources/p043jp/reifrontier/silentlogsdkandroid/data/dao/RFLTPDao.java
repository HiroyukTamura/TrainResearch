package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import android.database.Cursor;
import com.google.gson.Gson;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTP;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTP_Deleter;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTP_Relation;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTP_Schema;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.DateEx;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTPDao;", "", "()V", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "getRflOrmaHolder", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "setRflOrmaHolder", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "deleteBefore", "", "targetDay", "Ljava/util/Calendar;", "find", "", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityTP;", "dateString", "", "getDataFromList", "", "trackPoint", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "insert", "updateByDateTimezone", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLTPDao */
public final class RFLTPDao {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public RFLOrmaHolder rflOrmaHolder;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTPDao$Companion;", "", "()V", "DATE_FORMAT", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLTPDao$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RFLTPDao() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final byte[] m3811a(RFLTrackPoint rFLTrackPoint) {
        String json = new Gson().toJson((Object) rFLTrackPoint);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(trackPoint)");
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
        RFLEntityTP_Relation relationOfRFLEntityTP = rFLOrmaHolder.getORMA().relationOfRFLEntityTP();
        Intrinsics.checkExpressionValueIsNotNull(relationOfRFLEntityTP, "rflOrmaHolder.ORMA.relationOfRFLEntityTP()");
        Cursor executeWithColumns = relationOfRFLEntityTP.selector().executeWithColumns(RFLEntityTP_Schema.INSTANCE.date.name);
        Intrinsics.checkExpressionValueIsNotNull(executeWithColumns, "tpDao.selector().execute…chema.INSTANCE.date.name)");
        if (executeWithColumns.getCount() != 0) {
            executeWithColumns.moveToFirst();
            RFLEntityTP_Deleter rFLEntityTP_Deleter = (RFLEntityTP_Deleter) relationOfRFLEntityTP.deleter().mo19938or();
            long timeInMillis = calendar.getTimeInMillis();
            boolean z = false;
            do {
                String string = executeWithColumns.getString(0);
                DateEx dateEx = DateEx.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(string, "dbDate");
                Date parse = dateEx.parse(string, "yyyy-MM-dd");
                if (parse != null && parse.getTime() < timeInMillis) {
                    rFLEntityTP_Deleter.dateEq(string);
                    z = true;
                }
            } while (executeWithColumns.moveToNext());
            executeWithColumns.close();
            if (z) {
                rFLEntityTP_Deleter.execute();
            }
        }
    }

    public final List<RFLEntityTP> find(String str) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        List<RFLEntityTP> list = rFLOrmaHolder.getORMA().selectFromRFLEntityTP().dateEq(str).toList();
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

    public final void insert(String str, RFLTrackPoint rFLTrackPoint) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint, "trackPoint");
        RFLEntityTP rFLEntityTP = new RFLEntityTP(str, m3811a(rFLTrackPoint));
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().prepareInsertIntoRFLEntityTP(5).mo19796a(rFLEntityTP);
    }

    public final void setRflOrmaHolder(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "<set-?>");
        this.rflOrmaHolder = rFLOrmaHolder;
    }

    public final void updateByDateTimezone(RFLTrackPoint rFLTrackPoint, String str) {
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint, "trackPoint");
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().updateRFLEntityTP().dateEq(str).data(m3811a(rFLTrackPoint)).execute();
    }
}
