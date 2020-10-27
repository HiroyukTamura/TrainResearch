package p043jp.reifrontier.gym.domain.api;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\rH&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\rH&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\rH&J\b\u0010\u001b\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGPanelData;", "", "date", "", "getDate", "()Ljava/lang/String;", "dayNumber", "", "getDayNumber", "()I", "type", "getType", "bicyclePointF", "", "bikePointText", "distanceBikeText", "distanceRunText", "metsText", "otherPointText", "point", "pointF", "stepText", "train", "trainPointF", "trainPointText", "walk", "walkPointF", "walkPointText", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGPanelData */
public interface RFGPanelData {
    float bicyclePointF();

    String bikePointText();

    String distanceBikeText();

    String distanceRunText();

    String getDate();

    int getDayNumber();

    String getType();

    String metsText();

    String otherPointText();

    String point();

    float pointF();

    String stepText();

    String train();

    float trainPointF();

    String trainPointText();

    String walk();

    float walkPointF();

    String walkPointText();
}
