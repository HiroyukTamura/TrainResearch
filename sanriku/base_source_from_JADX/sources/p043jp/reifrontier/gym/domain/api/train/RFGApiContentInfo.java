package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1005x73df4298;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiContentInfo;", "Lio/realm/RealmObject;", "()V", "contents", "", "getContents", "()Ljava/lang/String;", "setContents", "(Ljava/lang/String;)V", "pKey", "getPKey", "setPKey", "title", "getTitle", "setTitle", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiContentInfo */
public class RFGApiContentInfo extends RealmObject implements C1005x73df4298 {
    @SerializedName("contents")
    private String contents;
    @SerializedName("pKey")
    @PrimaryKey
    private String pKey;
    @SerializedName("title")
    private String title;

    public RFGApiContentInfo() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        realmSet$pKey(uuid);
    }

    public final String getContents() {
        return realmGet$contents();
    }

    public final String getPKey() {
        return realmGet$pKey();
    }

    public final String getTitle() {
        return realmGet$title();
    }

    public String realmGet$contents() {
        return this.contents;
    }

    public String realmGet$pKey() {
        return this.pKey;
    }

    public String realmGet$title() {
        return this.title;
    }

    public void realmSet$contents(String str) {
        this.contents = str;
    }

    public void realmSet$pKey(String str) {
        this.pKey = str;
    }

    public void realmSet$title(String str) {
        this.title = str;
    }

    public final void setContents(String str) {
        realmSet$contents(str);
    }

    public final void setPKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$pKey(str);
    }

    public final void setTitle(String str) {
        realmSet$title(str);
    }
}
