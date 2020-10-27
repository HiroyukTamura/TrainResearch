package p043jp.reifrontier.gym.domain.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.domain.api.RFGFeed;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/app/RFGAdapterWeight;", "", "feed", "Ljp/reifrontier/gym/domain/api/RFGFeed;", "(Ljp/reifrontier/gym/domain/api/RFGFeed;)V", "getFeed", "()Ljp/reifrontier/gym/domain/api/RFGFeed;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.app.RFGAdapterWeight */
public final class RFGAdapterWeight {
    private final RFGFeed feed;

    public RFGAdapterWeight(RFGFeed rFGFeed) {
        Intrinsics.checkParameterIsNotNull(rFGFeed, "feed");
        this.feed = rFGFeed;
    }

    public static /* synthetic */ RFGAdapterWeight copy$default(RFGAdapterWeight rFGAdapterWeight, RFGFeed rFGFeed, int i, Object obj) {
        if ((i & 1) != 0) {
            rFGFeed = rFGAdapterWeight.feed;
        }
        return rFGAdapterWeight.copy(rFGFeed);
    }

    public final RFGFeed component1() {
        return this.feed;
    }

    public final RFGAdapterWeight copy(RFGFeed rFGFeed) {
        Intrinsics.checkParameterIsNotNull(rFGFeed, "feed");
        return new RFGAdapterWeight(rFGFeed);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFGAdapterWeight) && Intrinsics.areEqual((Object) this.feed, (Object) ((RFGAdapterWeight) obj).feed);
        }
        return true;
    }

    public final RFGFeed getFeed() {
        return this.feed;
    }

    public int hashCode() {
        RFGFeed rFGFeed = this.feed;
        if (rFGFeed != null) {
            return rFGFeed.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGAdapterWeight(feed=");
        a.append(this.feed);
        a.append(")");
        return a.toString();
    }
}
