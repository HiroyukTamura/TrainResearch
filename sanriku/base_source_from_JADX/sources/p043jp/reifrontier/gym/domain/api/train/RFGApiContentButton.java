package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1003xf6a02694;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiContentButton;", "Lio/realm/RealmObject;", "()V", "analytics", "", "getAnalytics", "()Ljava/lang/String;", "setAnalytics", "(Ljava/lang/String;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "label", "getLabel", "setLabel", "pKey", "getPKey", "setPKey", "type", "getType", "setType", "value", "getValue", "setValue", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiContentButton */
public class RFGApiContentButton extends RealmObject implements C1003xf6a02694 {
    @SerializedName("analytics")
    private String analytics;
    @SerializedName("color")
    private int color;
    @SerializedName("label")
    private String label;
    @SerializedName("pKey")
    @PrimaryKey
    private String pKey;
    @SerializedName("type")
    private int type;
    @SerializedName("value")
    private String value;

    public RFGApiContentButton() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        realmSet$pKey(uuid);
        realmSet$type(1);
        realmSet$color(1);
    }

    public final String getAnalytics() {
        return realmGet$analytics();
    }

    public final int getColor() {
        return realmGet$color();
    }

    public final String getLabel() {
        return realmGet$label();
    }

    public final String getPKey() {
        return realmGet$pKey();
    }

    public final int getType() {
        return realmGet$type();
    }

    public final String getValue() {
        return realmGet$value();
    }

    public String realmGet$analytics() {
        return this.analytics;
    }

    public int realmGet$color() {
        return this.color;
    }

    public String realmGet$label() {
        return this.label;
    }

    public String realmGet$pKey() {
        return this.pKey;
    }

    public int realmGet$type() {
        return this.type;
    }

    public String realmGet$value() {
        return this.value;
    }

    public void realmSet$analytics(String str) {
        this.analytics = str;
    }

    public void realmSet$color(int i) {
        this.color = i;
    }

    public void realmSet$label(String str) {
        this.label = str;
    }

    public void realmSet$pKey(String str) {
        this.pKey = str;
    }

    public void realmSet$type(int i) {
        this.type = i;
    }

    public void realmSet$value(String str) {
        this.value = str;
    }

    public final void setAnalytics(String str) {
        realmSet$analytics(str);
    }

    public final void setColor(int i) {
        realmSet$color(i);
    }

    public final void setLabel(String str) {
        realmSet$label(str);
    }

    public final void setPKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$pKey(str);
    }

    public final void setType(int i) {
        realmSet$type(i);
    }

    public final void setValue(String str) {
        realmSet$value(str);
    }
}
