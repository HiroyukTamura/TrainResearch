package p043jp.reifrontier.gym.data.train.adapter;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.RealmList;
import p043jp.reifrontier.gym.data.train.spot.RFGButtonType;
import p043jp.reifrontier.gym.data.train.spot.RFGColorType;
import p043jp.reifrontier.gym.data.train.spot.RFGContent;
import p043jp.reifrontier.gym.data.train.spot.RFGContentAccess;
import p043jp.reifrontier.gym.data.train.spot.RFGContentButton;
import p043jp.reifrontier.gym.data.train.spot.RFGContentImage;
import p043jp.reifrontier.gym.data.train.spot.RFGContentInfo;
import p043jp.reifrontier.gym.data.train.spot.RFGContentItem;
import p043jp.reifrontier.gym.data.train.spot.RFGContentNote;
import p043jp.reifrontier.gym.data.train.spot.RFGContentTitle;
import p043jp.reifrontier.gym.data.train.spot.RFGNoteTextSizeType;
import p043jp.reifrontier.gym.data.train.spot.RFGSpotType;
import p043jp.reifrontier.gym.data.train.spot.RFGTitleTextSizeType;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContent;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentAccess;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentButton;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentImage;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentInfo;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentItem;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentNote;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContentTitle;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u001d"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/adapter/RFGContentAdapter;", "", "()V", "convertContent", "Ljp/reifrontier/gym/data/train/spot/RFGContent;", "content", "Ljp/reifrontier/gym/domain/api/train/RFGApiContent;", "convertContentAccess", "Ljp/reifrontier/gym/data/train/spot/RFGContentAccess;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentAccess;", "convertContentButton", "Ljp/reifrontier/gym/data/train/spot/RFGContentButton;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentButton;", "convertContentImage", "Ljp/reifrontier/gym/data/train/spot/RFGContentImage;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentImage;", "convertContentInfo", "Ljp/reifrontier/gym/data/train/spot/RFGContentInfo;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentInfo;", "convertContentItem", "Ljp/reifrontier/gym/data/train/spot/RFGContentItem;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentItem;", "convertContentNote", "Ljp/reifrontier/gym/data/train/spot/RFGContentNote;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentNote;", "convertContentTitle", "Ljp/reifrontier/gym/data/train/spot/RFGContentTitle;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContentTitle;", "fromApi", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.adapter.RFGContentAdapter */
public final class RFGContentAdapter {
    private final RFGContent convertContent(RFGApiContent rFGApiContent) {
        int id = rFGApiContent.getId();
        int date = rFGApiContent.getDate();
        String title = rFGApiContent.getTitle();
        Integer stationId = rFGApiContent.getStationId();
        RealmList<RFGApiContentItem> contents = rFGApiContent.getContents();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(contents, 10));
        for (RFGApiContentItem rFGApiContentItem : contents) {
            Intrinsics.checkExpressionValueIsNotNull(rFGApiContentItem, "it");
            arrayList.add(convertContentItem(rFGApiContentItem));
        }
        return new RFGContent(id, date, title, stationId, arrayList, RFGSpotType.Companion.getType(rFGApiContent.getSpotType()), rFGApiContent.getUpdateAt());
    }

    private final RFGContentAccess convertContentAccess(RFGApiContentAccess rFGApiContentAccess) {
        if (rFGApiContentAccess != null) {
            return new RFGContentAccess(rFGApiContentAccess.getAddress(), rFGApiContentAccess.getAccess(), rFGApiContentAccess.getLat(), rFGApiContentAccess.getLon());
        }
        return null;
    }

    private final RFGContentButton convertContentButton(RFGApiContentButton rFGApiContentButton) {
        if (rFGApiContentButton != null) {
            return new RFGContentButton(rFGApiContentButton.getLabel(), RFGButtonType.Companion.getType(rFGApiContentButton.getType()), rFGApiContentButton.getValue(), RFGColorType.Companion.getType(rFGApiContentButton.getColor()), rFGApiContentButton.getAnalytics());
        }
        return null;
    }

    private final RFGContentImage convertContentImage(RFGApiContentImage rFGApiContentImage) {
        if (rFGApiContentImage != null) {
            return new RFGContentImage(rFGApiContentImage.getPath(), rFGApiContentImage.getWidth(), rFGApiContentImage.getHeight(), rFGApiContentImage.getFull());
        }
        return null;
    }

    private final RFGContentInfo convertContentInfo(RFGApiContentInfo rFGApiContentInfo) {
        return new RFGContentInfo(rFGApiContentInfo.getTitle(), rFGApiContentInfo.getContents());
    }

    private final RFGContentItem convertContentItem(RFGApiContentItem rFGApiContentItem) {
        RFGContentTitle convertContentTitle = convertContentTitle(rFGApiContentItem.getTitle());
        RFGContentNote convertContentNote = convertContentNote(rFGApiContentItem.getNote());
        RFGContentImage convertContentImage = convertContentImage(rFGApiContentItem.getImage());
        RFGContentAccess convertContentAccess = convertContentAccess(rFGApiContentItem.getAccess());
        RealmList<RFGApiContentInfo> infoList = rFGApiContentItem.getInfoList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(infoList, 10));
        for (RFGApiContentInfo rFGApiContentInfo : infoList) {
            Intrinsics.checkExpressionValueIsNotNull(rFGApiContentInfo, "it");
            arrayList.add(convertContentInfo(rFGApiContentInfo));
        }
        return new RFGContentItem(convertContentTitle, convertContentNote, convertContentImage, convertContentAccess, arrayList, convertContentButton(rFGApiContentItem.getButton()), rFGApiContentItem.getOrder());
    }

    private final RFGContentNote convertContentNote(RFGApiContentNote rFGApiContentNote) {
        if (rFGApiContentNote != null) {
            return new RFGContentNote(rFGApiContentNote.getValue(), RFGNoteTextSizeType.Companion.getType(rFGApiContentNote.getSize()), rFGApiContentNote.getBold(), RFGColorType.Companion.getType(rFGApiContentNote.getColor()));
        }
        return null;
    }

    private final RFGContentTitle convertContentTitle(RFGApiContentTitle rFGApiContentTitle) {
        if (rFGApiContentTitle != null) {
            return new RFGContentTitle(rFGApiContentTitle.getValue(), RFGTitleTextSizeType.Companion.getType(rFGApiContentTitle.getSize()));
        }
        return null;
    }

    public final RFGContent fromApi(RFGApiContent rFGApiContent) {
        Intrinsics.checkParameterIsNotNull(rFGApiContent, FirebaseAnalytics.Param.CONTENT);
        return convertContent(rFGApiContent);
    }
}
