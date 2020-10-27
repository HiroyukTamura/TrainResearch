package p043jp.reifrontier.gym.domain.api;

import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.RealmObject;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxyInterface;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserSummary;", "Lio/realm/RealmObject;", "()V", "distanceBike", "", "getDistanceBike", "()Ljava/lang/String;", "setDistanceBike", "(Ljava/lang/String;)V", "distanceRun", "getDistanceRun", "setDistanceRun", "metsBike", "getMetsBike", "setMetsBike", "metsRun", "getMetsRun", "setMetsRun", "metsStep", "getMetsStep", "setMetsStep", "step", "getStep", "setStep", "allMets", "bike", "bikeMets", "run", "runMets", "stepMets", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserSummary */
public class RFGUserSummary extends RealmObject implements jp_reifrontier_gym_domain_api_RFGUserSummaryRealmProxyInterface {
    @SerializedName("distance_bicycle")
    private String distanceBike;
    @SerializedName("distance_run")
    private String distanceRun;
    @SerializedName("mets_bike")
    private String metsBike;
    @SerializedName("mets_run")
    private String metsRun;
    @SerializedName("mets_wlk")
    private String metsStep;
    @SerializedName("steps")
    private String step;

    public RFGUserSummary() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$step(RFGDef.DEFAULT_GYM_ID);
        realmSet$distanceBike(IdManager.DEFAULT_VERSION_NAME);
        realmSet$distanceRun(IdManager.DEFAULT_VERSION_NAME);
        realmSet$metsStep(RFGDef.DEFAULT_GYM_ID);
        realmSet$metsBike(IdManager.DEFAULT_VERSION_NAME);
        realmSet$metsRun(IdManager.DEFAULT_VERSION_NAME);
    }

    public final String allMets() {
        if (getMetsStep() == null || getMetsBike() == null || getMetsRun() == null) {
            return "0.00";
        }
        String metsStep2 = getMetsStep();
        if (metsStep2 == null) {
            Intrinsics.throwNpe();
        }
        double parseDouble = Double.parseDouble(metsStep2);
        String metsBike2 = getMetsBike();
        if (metsBike2 == null) {
            Intrinsics.throwNpe();
        }
        double parseDouble2 = Double.parseDouble(metsBike2);
        String metsRun2 = getMetsRun();
        if (metsRun2 == null) {
            Intrinsics.throwNpe();
        }
        return C0681a.m328a(new Object[]{Double.valueOf(parseDouble + parseDouble2 + Double.parseDouble(metsRun2))}, 1, "%.2f", "java.lang.String.format(this, *args)");
    }

    public final String bike() {
        if (getDistanceBike() == null) {
            return "0.0km";
        }
        String distanceBike2 = getDistanceBike();
        if (distanceBike2 == null) {
            Intrinsics.throwNpe();
        }
        return C0681a.m328a(new Object[]{Double.valueOf(Double.parseDouble(distanceBike2))}, 1, "%.1fkm", "java.lang.String.format(this, *args)");
    }

    public final String bikeMets() {
        if (getMetsBike() == null) {
            return "0.0METs-h";
        }
        String metsBike2 = getMetsBike();
        if (metsBike2 == null) {
            Intrinsics.throwNpe();
        }
        return C0681a.m328a(new Object[]{Double.valueOf(Double.parseDouble(metsBike2))}, 1, "%.1fMETs-h", "java.lang.String.format(this, *args)");
    }

    public String getDistanceBike() {
        return realmGet$distanceBike();
    }

    public String getDistanceRun() {
        return realmGet$distanceRun();
    }

    public String getMetsBike() {
        return realmGet$metsBike();
    }

    public String getMetsRun() {
        return realmGet$metsRun();
    }

    public String getMetsStep() {
        return realmGet$metsStep();
    }

    public String getStep() {
        return realmGet$step();
    }

    public String realmGet$distanceBike() {
        return this.distanceBike;
    }

    public String realmGet$distanceRun() {
        return this.distanceRun;
    }

    public String realmGet$metsBike() {
        return this.metsBike;
    }

    public String realmGet$metsRun() {
        return this.metsRun;
    }

    public String realmGet$metsStep() {
        return this.metsStep;
    }

    public String realmGet$step() {
        return this.step;
    }

    public void realmSet$distanceBike(String str) {
        this.distanceBike = str;
    }

    public void realmSet$distanceRun(String str) {
        this.distanceRun = str;
    }

    public void realmSet$metsBike(String str) {
        this.metsBike = str;
    }

    public void realmSet$metsRun(String str) {
        this.metsRun = str;
    }

    public void realmSet$metsStep(String str) {
        this.metsStep = str;
    }

    public void realmSet$step(String str) {
        this.step = str;
    }

    public final String run() {
        if (getDistanceRun() == null) {
            return "0.0km";
        }
        String distanceRun2 = getDistanceRun();
        if (distanceRun2 == null) {
            Intrinsics.throwNpe();
        }
        return C0681a.m328a(new Object[]{Double.valueOf(Double.parseDouble(distanceRun2))}, 1, "%.1fkm", "java.lang.String.format(this, *args)");
    }

    public final String runMets() {
        if (getMetsRun() == null) {
            return "0.0METs-h";
        }
        String metsRun2 = getMetsRun();
        if (metsRun2 == null) {
            Intrinsics.throwNpe();
        }
        return C0681a.m328a(new Object[]{Double.valueOf(Double.parseDouble(metsRun2))}, 1, "%.1fMETs-h", "java.lang.String.format(this, *args)");
    }

    public void setDistanceBike(String str) {
        realmSet$distanceBike(str);
    }

    public void setDistanceRun(String str) {
        realmSet$distanceRun(str);
    }

    public void setMetsBike(String str) {
        realmSet$metsBike(str);
    }

    public void setMetsRun(String str) {
        realmSet$metsRun(str);
    }

    public void setMetsStep(String str) {
        realmSet$metsStep(str);
    }

    public void setStep(String str) {
        realmSet$step(str);
    }

    public final String step() {
        if (getStep() == null) {
            return "0歩";
        }
        String step2 = getStep();
        if (step2 == null) {
            Intrinsics.throwNpe();
        }
        List split$default = StringsKt__StringsKt.split$default((CharSequence) step2, new String[]{"."}, false, 0, 6, (Object) null);
        return split$default.size() > 1 ? C0681a.m324a(new StringBuilder(), (String) split$default.get(0), "歩") : Intrinsics.stringPlus(getStep(), "歩");
    }

    public final String stepMets() {
        if (getMetsStep() == null) {
            return "0.0METs-h";
        }
        String metsStep2 = getMetsStep();
        if (metsStep2 == null) {
            Intrinsics.throwNpe();
        }
        return C0681a.m328a(new Object[]{Double.valueOf(Double.parseDouble(metsStep2))}, 1, "%.1fMETs-h", "java.lang.String.format(this, *args)");
    }
}
