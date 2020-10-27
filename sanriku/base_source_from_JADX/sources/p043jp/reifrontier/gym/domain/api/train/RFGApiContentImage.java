package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1004x7399afb3;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiContentImage;", "Lio/realm/RealmObject;", "()V", "full", "", "getFull", "()Z", "setFull", "(Z)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "pKey", "", "getPKey", "()Ljava/lang/String;", "setPKey", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "width", "getWidth", "setWidth", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiContentImage */
public class RFGApiContentImage extends RealmObject implements C1004x7399afb3 {
    @SerializedName("full")
    private boolean full;
    @SerializedName("height")
    private int height;
    @SerializedName("pKey")
    @PrimaryKey
    private String pKey;
    @SerializedName("path")
    private String path;
    @SerializedName("width")
    private int width;

    public RFGApiContentImage() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        realmSet$pKey(uuid);
        realmSet$path("");
    }

    public final boolean getFull() {
        return realmGet$full();
    }

    public final int getHeight() {
        return realmGet$height();
    }

    public final String getPKey() {
        return realmGet$pKey();
    }

    public final String getPath() {
        return realmGet$path();
    }

    public final int getWidth() {
        return realmGet$width();
    }

    public boolean realmGet$full() {
        return this.full;
    }

    public int realmGet$height() {
        return this.height;
    }

    public String realmGet$pKey() {
        return this.pKey;
    }

    public String realmGet$path() {
        return this.path;
    }

    public int realmGet$width() {
        return this.width;
    }

    public void realmSet$full(boolean z) {
        this.full = z;
    }

    public void realmSet$height(int i) {
        this.height = i;
    }

    public void realmSet$pKey(String str) {
        this.pKey = str;
    }

    public void realmSet$path(String str) {
        this.path = str;
    }

    public void realmSet$width(int i) {
        this.width = i;
    }

    public final void setFull(boolean z) {
        realmSet$full(z);
    }

    public final void setHeight(int i) {
        realmSet$height(i);
    }

    public final void setPKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$pKey(str);
    }

    public final void setPath(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$path(str);
    }

    public final void setWidth(int i) {
        realmSet$width(i);
    }
}
