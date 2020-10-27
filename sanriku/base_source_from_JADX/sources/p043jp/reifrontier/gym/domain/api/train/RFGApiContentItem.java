package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.C1006xbf250013;
import p041io.realm.RealmList;
import p041io.realm.RealmObject;
import p041io.realm.annotations.PrimaryKey;
import p041io.realm.annotations.RealmClass;
import p041io.realm.internal.RealmObjectProxy;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00064"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiContentItem;", "Lio/realm/RealmObject;", "()V", "access", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentAccess;", "getAccess", "()Ljp/reifrontier/gym/domain/api/train/RFGApiContentAccess;", "setAccess", "(Ljp/reifrontier/gym/domain/api/train/RFGApiContentAccess;)V", "button", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentButton;", "getButton", "()Ljp/reifrontier/gym/domain/api/train/RFGApiContentButton;", "setButton", "(Ljp/reifrontier/gym/domain/api/train/RFGApiContentButton;)V", "image", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentImage;", "getImage", "()Ljp/reifrontier/gym/domain/api/train/RFGApiContentImage;", "setImage", "(Ljp/reifrontier/gym/domain/api/train/RFGApiContentImage;)V", "infoList", "Lio/realm/RealmList;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentInfo;", "getInfoList", "()Lio/realm/RealmList;", "setInfoList", "(Lio/realm/RealmList;)V", "note", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentNote;", "getNote", "()Ljp/reifrontier/gym/domain/api/train/RFGApiContentNote;", "setNote", "(Ljp/reifrontier/gym/domain/api/train/RFGApiContentNote;)V", "order", "", "getOrder", "()I", "setOrder", "(I)V", "pKey", "", "getPKey", "()Ljava/lang/String;", "setPKey", "(Ljava/lang/String;)V", "title", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentTitle;", "getTitle", "()Ljp/reifrontier/gym/domain/api/train/RFGApiContentTitle;", "setTitle", "(Ljp/reifrontier/gym/domain/api/train/RFGApiContentTitle;)V", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@RealmClass
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiContentItem */
public class RFGApiContentItem extends RealmObject implements C1006xbf250013 {
    @SerializedName("access")
    private RFGApiContentAccess access;
    @SerializedName("button")
    private RFGApiContentButton button;
    @SerializedName("image")
    private RFGApiContentImage image;
    @SerializedName("info")
    private RealmList<RFGApiContentInfo> infoList;
    @SerializedName("note")
    private RFGApiContentNote note;
    @SerializedName("order")
    private int order;
    @SerializedName("pKey")
    @PrimaryKey
    private String pKey;
    @SerializedName("title")
    private RFGApiContentTitle title;

    public RFGApiContentItem() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        realmSet$pKey(uuid);
        realmSet$infoList(new RealmList());
    }

    public final RFGApiContentAccess getAccess() {
        return realmGet$access();
    }

    public final RFGApiContentButton getButton() {
        return realmGet$button();
    }

    public final RFGApiContentImage getImage() {
        return realmGet$image();
    }

    public final RealmList<RFGApiContentInfo> getInfoList() {
        return realmGet$infoList();
    }

    public final RFGApiContentNote getNote() {
        return realmGet$note();
    }

    public final int getOrder() {
        return realmGet$order();
    }

    public final String getPKey() {
        return realmGet$pKey();
    }

    public final RFGApiContentTitle getTitle() {
        return realmGet$title();
    }

    public RFGApiContentAccess realmGet$access() {
        return this.access;
    }

    public RFGApiContentButton realmGet$button() {
        return this.button;
    }

    public RFGApiContentImage realmGet$image() {
        return this.image;
    }

    public RealmList realmGet$infoList() {
        return this.infoList;
    }

    public RFGApiContentNote realmGet$note() {
        return this.note;
    }

    public int realmGet$order() {
        return this.order;
    }

    public String realmGet$pKey() {
        return this.pKey;
    }

    public RFGApiContentTitle realmGet$title() {
        return this.title;
    }

    public void realmSet$access(RFGApiContentAccess rFGApiContentAccess) {
        this.access = rFGApiContentAccess;
    }

    public void realmSet$button(RFGApiContentButton rFGApiContentButton) {
        this.button = rFGApiContentButton;
    }

    public void realmSet$image(RFGApiContentImage rFGApiContentImage) {
        this.image = rFGApiContentImage;
    }

    public void realmSet$infoList(RealmList realmList) {
        this.infoList = realmList;
    }

    public void realmSet$note(RFGApiContentNote rFGApiContentNote) {
        this.note = rFGApiContentNote;
    }

    public void realmSet$order(int i) {
        this.order = i;
    }

    public void realmSet$pKey(String str) {
        this.pKey = str;
    }

    public void realmSet$title(RFGApiContentTitle rFGApiContentTitle) {
        this.title = rFGApiContentTitle;
    }

    public final void setAccess(RFGApiContentAccess rFGApiContentAccess) {
        realmSet$access(rFGApiContentAccess);
    }

    public final void setButton(RFGApiContentButton rFGApiContentButton) {
        realmSet$button(rFGApiContentButton);
    }

    public final void setImage(RFGApiContentImage rFGApiContentImage) {
        realmSet$image(rFGApiContentImage);
    }

    public final void setInfoList(RealmList<RFGApiContentInfo> realmList) {
        Intrinsics.checkParameterIsNotNull(realmList, "<set-?>");
        realmSet$infoList(realmList);
    }

    public final void setNote(RFGApiContentNote rFGApiContentNote) {
        realmSet$note(rFGApiContentNote);
    }

    public final void setOrder(int i) {
        realmSet$order(i);
    }

    public final void setPKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        realmSet$pKey(str);
    }

    public final void setTitle(RFGApiContentTitle rFGApiContentTitle) {
        realmSet$title(rFGApiContentTitle);
    }
}
