package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1007x116808d4;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiContentNote;", "Lio/realm/RealmObject;", "()V", "bold", "", "getBold", "()Z", "setBold", "(Z)V", "color", "", "getColor", "()I", "setColor", "(I)V", "pKey", "", "getPKey", "()Ljava/lang/String;", "setPKey", "(Ljava/lang/String;)V", "size", "getSize", "setSize", "value", "getValue", "setValue", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiContentNote */
public class RFGApiContentNote extends RealmObject implements C1007x116808d4 {
    @SerializedName("bold")
    private boolean bold;
    @SerializedName("color")
    private int color;
    @SerializedName("pKey")
    @PrimaryKey
    private String pKey;
    @SerializedName("size")
    private int size;
    @SerializedName("value")
    private String value;

    public RFGApiContentNote() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        realmSet$pKey(uuid);
        realmSet$value("");
        realmSet$size(1);
        realmSet$color(1);
    }

    public final boolean getBold() {
        return realmGet$bold();
    }

    public final int getColor() {
        return realmGet$color();
    }

    public final String getPKey() {
        return realmGet$pKey();
    }

    public final int getSize() {
        return realmGet$size();
    }

    public final String getValue() {
        return realmGet$value();
    }

    public boolean realmGet$bold() {
        return this.bold;
    }

    public int realmGet$color() {
        return this.color;
    }

    public String realmGet$pKey() {
        return this.pKey;
    }

    public int realmGet$size() {
        return this.size;
    }

    public String realmGet$value() {
        return this.value;
    }

    public void realmSet$bold(boolean z) {
        this.bold = z;
    }

    public void realmSet$color(int i) {
        this.color = i;
    }

    public void realmSet$pKey(String str) {
        this.pKey = str;
    }

    public void realmSet$size(int i) {
        this.size = i;
    }

    public void realmSet$value(String str) {
        this.value = str;
    }

    public final void setBold(boolean z) {
        realmSet$bold(z);
    }

    public final void setColor(int i) {
        realmSet$color(i);
    }

    public final void setPKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$pKey(str);
    }

    public final void setSize(int i) {
        realmSet$size(i);
    }

    public final void setValue(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$value(str);
    }
}
