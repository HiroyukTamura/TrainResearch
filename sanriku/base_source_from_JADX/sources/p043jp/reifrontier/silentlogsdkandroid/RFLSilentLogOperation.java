package p043jp.reifrontier.silentlogsdkandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.C1126c;
import org.greenrobot.eventbus.C1129m;
import org.greenrobot.eventbus.ThreadMode;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogAdListener;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogWeatherListener;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.bus.InvalidToken;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLActivityPoiManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdjustTrackPointManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLPointClient;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLLogout;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivityPoi;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLPredict;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTag;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdCampaign;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResType;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLLogTree;
import p048l.p049a.C1122a;
import p078g.p079a.C1696b;
import p078g.p079a.C1697c;
import p078g.p079a.C1699e;
import p078g.p079a.C1714r;
import p078g.p079a.C1718v;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;
import p078g.p079a.p100z.C1741d;
import p078g.p079a.p100z.C1742e;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000ê\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u00002\u00020\u0001:\u0002Ü\u0002B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J.\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\u0019\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\b\u0001J=\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020h2\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020]H\u0000¢\u0006\u0003\b\u0001JR\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u001e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u001a\b\u0002\u0010\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001eH\u0001¢\u0006\u0003\b \u0001JA\u0010¡\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u001e2\t\u0010\u0001\u001a\u0004\u0018\u00010\u001e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0001¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0010\u0010¤\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b¥\u0001J^\u0010¦\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001e2\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010¨\u0001\u001a\u00020]2\u001a\b\u0002\u0010\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0001H\u0002J!\u0010©\u0001\u001a\u00030\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020WH\u0000¢\u0006\u0003\bª\u0001J&\u0010«\u0001\u001a\u00030\u00012\u001a\b\u0002\u0010\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0001H\u0002J\u0016\u0010¬\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0­\u0001H\u0002J8\u0010®\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0003\u0010£\u0001J\n\u0010¯\u0001\u001a\u00030\u0001H\u0002J\u0019\u0010°\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020]H\u0000¢\u0006\u0003\b²\u0001J\u001a\u0010³\u0001\u001a\u00030\u00012\b\u0010´\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bµ\u0001J$\u0010¶\u0001\u001a\u00030\u00012\b\u0010·\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030¸\u0001H\u0000¢\u0006\u0003\b¹\u0001J\u0019\u0010º\u0001\u001a\u00030\u00012\u0007\u0010»\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\b¼\u0001J\u0012\u0010½\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0003\b¾\u0001J\u001a\u0010¿\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030À\u0001H\u0001¢\u0006\u0003\bÁ\u0001J \u0010Â\u0001\u001a\t\u0012\u0004\u0012\u00020]0Ã\u00012\b\u0010·\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÄ\u0001J\u0010\u0010Å\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÆ\u0001J\u000f\u0010Ç\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\bÈ\u0001J\u0010\u0010É\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÊ\u0001J\b\u0010Ë\u0001\u001a\u00030\u0001J\u0016\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u0001H\u0000¢\u0006\u0003\bÍ\u0001J\u000f\u0010Î\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\bÏ\u0001J\u001a\u0010Ð\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030Ñ\u0001H\u0000¢\u0006\u0003\bÒ\u0001J\u000f\u0010Ó\u0001\u001a\u00020]H\u0000¢\u0006\u0003\bÔ\u0001J\n\u0010Õ\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010Ö\u0001\u001a\u00020]J\u000f\u0010×\u0001\u001a\u00020]H\u0000¢\u0006\u0003\bØ\u0001J\u000f\u0010Ù\u0001\u001a\u00020]H\u0000¢\u0006\u0003\bÚ\u0001J\u000f\u0010Û\u0001\u001a\u00020]H\u0000¢\u0006\u0003\bÜ\u0001J\u000f\u0010Ý\u0001\u001a\u00020]H\u0000¢\u0006\u0003\bÞ\u0001J\u0018\u0010ß\u0001\u001a\u00020]2\u0007\u0010\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\bà\u0001J \u0010á\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0Ã\u00012\b\u0010·\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bâ\u0001J \u0010ã\u0001\u001a\t\u0012\u0004\u0012\u00020]0Ã\u00012\b\u0010·\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bä\u0001J\u0012\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001H\u0000¢\u0006\u0003\bç\u0001J\u0019\u0010è\u0001\u001a\u00030\u00012\u0007\u0010é\u0001\u001a\u00020]H\u0000¢\u0006\u0003\bê\u0001J#\u0010ë\u0001\u001a\n\u0012\u0005\u0012\u00030ì\u00010Ã\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001eH\u0002J\u001c\u0010í\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001eH\u0003J\u0010\u0010î\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0003\bï\u0001J\u0014\u0010ð\u0001\u001a\u00030\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0007J\u0010\u0010ó\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bô\u0001J$\u0010õ\u0001\u001a\u00030\u00012\b\u0010ö\u0001\u001a\u00030\u00012\b\u0010÷\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bø\u0001J\n\u0010ù\u0001\u001a\u00030\u0001H\u0002J\n\u0010ú\u0001\u001a\u00030\u0001H\u0002J\u0019\u0010û\u0001\u001a\u00030\u00012\u0007\u0010ü\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\bý\u0001J\u0017\u0010þ\u0001\u001a\n\u0012\u0005\u0012\u00030ÿ\u00010Ã\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030\u0002H\u0000¢\u0006\u0003\b\u0002J.\u0010\u0002\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J;\u0010\u0002\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u001b\u0010\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0­\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J.\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0001\u001a\u00030\u0002H\u0001¢\u0006\u0003\b\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J5\u0010\u0002\u001a\u00030\u00022\u000f\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020\u00012\b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J>\u0010\u0002\u001a\u00030\u00022\u000f\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020\u00012\b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020]H\u0000¢\u0006\u0003\b\u0002J-\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u001e2\b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J\u001b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u001eJ\u0019\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u001eH\u0000¢\u0006\u0003\b\u0002J\u0019\u0010 \u0002\u001a\u00030\u00012\u0007\u0010¡\u0002\u001a\u00020\u001eH\u0000¢\u0006\u0003\b¢\u0002J\u0011\u0010£\u0002\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020]J\u0019\u0010¤\u0002\u001a\u00030\u00012\u0007\u0010¥\u0002\u001a\u00020\u001eH\u0000¢\u0006\u0003\b¦\u0002J\u001d\u0010§\u0002\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020]2\b\u0010\u0001\u001a\u00030¨\u0002H\u0007J\u0011\u0010©\u0002\u001a\u00030\u00012\u0007\u0010ª\u0002\u001a\u00020]J\u0019\u0010«\u0002\u001a\u00030\u00012\u0007\u0010¬\u0002\u001a\u00020\u001eH\u0000¢\u0006\u0003\b­\u0002J\u0019\u0010®\u0002\u001a\u00030\u00012\u0007\u0010¯\u0002\u001a\u00020]H\u0000¢\u0006\u0003\b°\u0002J+\u0010±\u0002\u001a\u00030\u00012\u0007\u0010²\u0002\u001a\u00020\u001e2\u0007\u0010³\u0002\u001a\u00020\u001e2\u0007\u0010´\u0002\u001a\u00020\u001eH\u0000¢\u0006\u0003\bµ\u0002J\u0019\u0010¶\u0002\u001a\u00030\u00012\u0007\u0010·\u0002\u001a\u00020]H\u0000¢\u0006\u0003\b¸\u0002J\u001a\u0010¹\u0002\u001a\u00030\u00012\b\u0010º\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b»\u0002J\u0019\u0010¼\u0002\u001a\u00030\u00012\u0007\u0010½\u0002\u001a\u00020]H\u0000¢\u0006\u0003\b¾\u0002J\u000f\u0010¿\u0002\u001a\u00020]H\u0000¢\u0006\u0003\bÀ\u0002J\n\u0010Á\u0002\u001a\u00030\u0001H\u0002J\u001a\u0010Â\u0002\u001a\u00030\u00012\b\u0010Ã\u0002\u001a\u00030Ä\u0002H\u0000¢\u0006\u0003\bÅ\u0002J-\u0010Æ\u0002\u001a\u00030\u00012\u001b\u0010Ç\u0002\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u00010\u0001H\u0000¢\u0006\u0003\bÈ\u0002J\u0010\u0010É\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÊ\u0002J\n\u0010Ë\u0002\u001a\u00030\u0001H\u0002J\u0010\u0010Ì\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÍ\u0002J\u0010\u0010Î\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÏ\u0002J$\u0010Ð\u0002\u001a\u00030\u00012\u0018\u0010\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0001H\u0002J\u001a\u0010Ñ\u0002\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÒ\u0002J\u001a\u0010Ó\u0002\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÔ\u0002J\"\u0010Õ\u0002\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010»\u0001\u001a\u00020\u001eH\u0001¢\u0006\u0003\bÖ\u0002J\u0010\u0010×\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\bØ\u0002J\u0019\u0010Ù\u0002\u001a\u00030\u00012\u0007\u0010Ú\u0002\u001a\u00020\u001eH\u0000¢\u0006\u0003\bÛ\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020-8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u0002038\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u0002098\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010>\u001a\u00020?8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010D\u001a\u00020E8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001e\u0010J\u001a\u00020K8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u000e\u0010\\\u001a\u00020]X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010`\u001a\u00020a8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u000e\u0010f\u001a\u00020]X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX.¢\u0006\u0002\n\u0000R\u001e\u0010i\u001a\u00020j8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001e\u0010o\u001a\u00020p8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001e\u0010u\u001a\u00020v8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001f\u0010{\u001a\u00020|8\u0000@\u0000X.¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u0010\u0001¨\u0006Ý\u0002"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/RFLSilentLogOperation;", "", "()V", "accountManager", "Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "getAccountManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "setAccountManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;)V", "activityPoiManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLActivityPoiManager;", "getActivityPoiManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLActivityPoiManager;", "setActivityPoiManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLActivityPoiManager;)V", "adManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdManager;", "getAdManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdManager;", "setAdManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdManager;)V", "adjustTrackPointManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdjustTrackPointManager;", "getAdjustTrackPointManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdjustTrackPointManager;", "setAdjustTrackPointManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdjustTrackPointManager;)V", "clientContext", "Landroid/content/Context;", "clientId", "", "clientSecret", "dailyLoader", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader;", "getDailyLoader$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader;", "setDailyLoader$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader;)V", "dailyManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyManager;", "getDailyManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyManager;", "setDailyManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyManager;)V", "dailyTagManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyTagManager;", "getDailyTagManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyTagManager;", "setDailyTagManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyTagManager;)V", "dailyUtils", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "getDailyUtils$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "setDailyUtils$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;)V", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "getDataLogger$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "setDataLogger$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;)V", "eventBus", "Lorg/greenrobot/eventbus/EventBus;", "getEventBus$silentlogsdkandroid_release", "()Lorg/greenrobot/eventbus/EventBus;", "setEventBus$silentlogsdkandroid_release", "(Lorg/greenrobot/eventbus/EventBus;)V", "googleFitManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager;", "getGoogleFitManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager;", "setGoogleFitManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager;)V", "h1Client", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "getH1Client$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "setH1Client$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;)V", "internalOperation", "Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation;", "getInternalOperation", "()Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation;", "setInternalOperation", "(Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation;)V", "internalOperationListener", "Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation$SilentLogInternalOperationListener;", "getInternalOperationListener", "()Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation$SilentLogInternalOperationListener;", "setInternalOperationListener", "(Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation$SilentLogInternalOperationListener;)V", "isRefreshingToken", "", "lastEventReceiveTime", "", "locationManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager;", "getLocationManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager;", "setLocationManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager;)V", "mServiceStop", "operationListener", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$SilentLogOperationListener;", "ormaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "getOrmaHolder", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "setOrmaHolder", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "pointClient", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLPointClient;", "getPointClient$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/data/api/RFLPointClient;", "setPointClient$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/data/api/RFLPointClient;)V", "weatherClient", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLWeatherClient;", "getWeatherClient$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/data/api/RFLWeatherClient;", "setWeatherClient$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/data/api/RFLWeatherClient;)V", "weatherManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager;", "getWeatherManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager;", "setWeatherManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager;)V", "acquiredEvent", "", "triggerPoiId", "", "addDailyTag", "targetDate", "Ljava/util/Date;", "dailyTags", "", "listener", "Ljp/reifrontier/silentlogsdkandroid/SilentLogDailyTagListener;", "addJrFormAsync", "jrForm", "addJrFormAsync$silentlogsdkandroid_release", "build", "aClientContext", "aListener", "aClientId", "aClientSecret", "aStaging", "build$silentlogsdkandroid_release", "connectApi", "username", "gender", "birthday", "privateKeyMap", "", "connectApi$silentlogsdkandroid_release", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;Ljava/util/Map;)V", "connectApiViaLogin", "password", "connectApiViaLogin$silentlogsdkandroid_release", "connectApiWithPass", "connectApiWithPass$silentlogsdkandroid_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;)V", "connectGoogleFitClient", "connectGoogleFitClient$silentlogsdkandroid_release", "create", "originalUserName", "regist", "createInternalOperation", "createInternalOperation$silentlogsdkandroid_release", "createJDAccount", "createJDAccountInfo", "Lkotlin/Pair;", "createUser", "createWithoutListener", "enableTransportPrediction", "enable", "enableTransportPrediction$silentlogsdkandroid_release", "entryCampaignAsync", "adEntryType", "entryCampaignAsync$silentlogsdkandroid_release", "findWeather", "date", "Ljp/reifrontier/silentlogsdkandroid/SilentLogWeatherListener$OnCompletedFind;", "findWeather$silentlogsdkandroid_release", "forgetPassword", "email", "forgetPassword$silentlogsdkandroid_release", "getBirthDay", "getBirthDay$silentlogsdkandroid_release", "getCampaign", "Ljp/reifrontier/silentlogsdkandroid/SilentLogAdListener$OnCompletedGetCampaign;", "getCampaign$silentlogsdkandroid_release", "getDataWithAdjustTrackPoint", "Lio/reactivex/Single;", "getDataWithAdjustTrackPoint$silentlogsdkandroid_release", "getEntryType", "getEntryType$silentlogsdkandroid_release", "getExtraUserId", "getExtraUserId$silentlogsdkandroid_release", "getGender", "getGender$silentlogsdkandroid_release", "getInstallDate", "getJrForms", "getJrForms$silentlogsdkandroid_release", "getSilentLogUserId", "getSilentLogUserId$silentlogsdkandroid_release", "getTodayStepCountByGoogleFit", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$SilentLogStepsListener;", "getTodayStepCountByGoogleFit$silentlogsdkandroid_release", "hasAuth", "hasAuth$silentlogsdkandroid_release", "initSettingIfNeed", "isEnableTwoWeekSetting", "isEntryCampaign", "isEntryCampaign$silentlogsdkandroid_release", "isLogin", "isLogin$silentlogsdkandroid_release", "isMilePointAuth", "isMilePointAuth$silentlogsdkandroid_release", "isRegistLogin", "isRegistLogin$silentlogsdkandroid_release", "isValidPassword", "isValidPassword$silentlogsdkandroid_release", "loadDailyFromDate", "loadDailyFromDate$silentlogsdkandroid_release", "loadDailyWithTag", "loadDailyWithTag$silentlogsdkandroid_release", "loadLocation", "Landroid/location/Location;", "loadLocation$silentlogsdkandroid_release", "loadUserProfileIfNeed", "force", "loadUserProfileIfNeed$silentlogsdkandroid_release", "login", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "loginWithoutListener", "logoutApi", "logoutApi$silentlogsdkandroid_release", "onReceiveInvalidToken", "invalidToken", "Ljp/reifrontier/silentlogsdkandroid/bus/InvalidToken;", "onStart", "onStart$silentlogsdkandroid_release", "permissionResult", "requestCode", "grantResults", "permissionResult$silentlogsdkandroid_release", "reRegisterEventBus", "refreshTokenWhenInvalid", "registerRemoteToken", "tokenString", "registerRemoteToken$silentlogsdkandroid_release", "release", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$LogoutResult;", "release$silentlogsdkandroid_release", "releaseWithoutLogout", "Lio/reactivex/Completable;", "releaseWithoutLogout$silentlogsdkandroid_release", "removeDailyTag", "replaceDailyTag", "responseAd", "campId", "responseType", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResType;", "Ljp/reifrontier/silentlogsdkandroid/SilentLogAdListener$OnCompletedResponseAd;", "responseAd$silentlogsdkandroid_release", "restart", "saveActivityAdjustTrackPoint", "adjustTrackPoints", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "fromDate", "toDate", "saveActivityAdjustTrackPoint$silentlogsdkandroid_release", "saveActivityPoi", "poiList", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivityPoi;", "removePredict", "saveActivityPoi$silentlogsdkandroid_release", "saveActivityTag", "activityTag", "saveActivityTag$silentlogsdkandroid_release", "saveDailyNote", "dailyNote", "savePointSystemKey", "pointSystemKey", "savePointSystemKey$silentlogsdkandroid_release", "saveSl2Id", "sl2Id", "saveSl2Id$silentlogsdkandroid_release", "setAltitudePrediction", "setBaseUrl", "baseUrl", "setBaseUrl$silentlogsdkandroid_release", "setEnableTwoWeekSetting", "Ljp/reifrontier/silentlogsdkandroid/SilentLogTwoWeekSettingListener;", "setJapanOnly", "japanOnly", "setPointUrl", "pointUrl", "setPointUrl$silentlogsdkandroid_release", "setSendPushToken", "sendPushToken", "setSendPushToken$silentlogsdkandroid_release", "setServiceName", "service", "geofence", "foreground", "setServiceName$silentlogsdkandroid_release", "setStepPerMinutesPriority", "useSdkSteps", "setStepPerMinutesPriority$silentlogsdkandroid_release", "setTrackingPriorityType", "type", "setTrackingPriorityType$silentlogsdkandroid_release", "setUseAdvertisingId", "useAdvertisingId", "setUseAdvertisingId$silentlogsdkandroid_release", "shouldLoadUserProfile", "shouldLoadUserProfile$silentlogsdkandroid_release", "startForegroundService", "startFromService", "intent", "Landroid/content/Intent;", "startFromService$silentlogsdkandroid_release", "startGeofence", "list", "startGeofence$silentlogsdkandroid_release", "startTracking", "startTracking$silentlogsdkandroid_release", "stopForegroundService", "stopGeofence", "stopGeofence$silentlogsdkandroid_release", "stopTracking", "stopTracking$silentlogsdkandroid_release", "syncPrivateKeys", "updateBirthday", "updateBirthday$silentlogsdkandroid_release", "updateGender", "updateGender$silentlogsdkandroid_release", "updatePassword", "updatePassword$silentlogsdkandroid_release", "uploadForceTest", "uploadForceTest$silentlogsdkandroid_release", "writeLog", "message", "writeLog$silentlogsdkandroid_release", "InternalData", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation */
public final class RFLSilentLogOperation {

    /* renamed from: a */
    private SilentLogInternalOperation f721a;
    public RFLAccountManager accountManager;
    public RFLActivityPoiManager activityPoiManager;
    public RFLAdManager adManager;
    public RFLAdjustTrackPointManager adjustTrackPointManager;

    /* renamed from: b */
    private SilentLogInternalOperation.SilentLogInternalOperationListener f722b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f723c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f724d;
    public RFLDailyLoader dailyLoader;
    public RFLDailyManager dailyManager;
    public RFLDailyTagManager dailyTagManager;
    public RFLDailyUtils dailyUtils;
    public RFLDataLogger dataLogger;

    /* renamed from: e */
    private String f725e;
    public C1126c eventBus;

    /* renamed from: f */
    private String f726f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SilentLogOperation.SilentLogOperationListener f727g;
    public RFLGoogleFitManager googleFitManager;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f728h;
    public RFLH1Client h1Client;

    /* renamed from: i */
    private long f729i;
    public RFLLocationManager locationManager;
    public RFLOrmaHolder ormaHolder;
    public RFLPointClient pointClient;
    public RFLWeatherClient weatherClient;
    public RFLWeatherManager weatherManager;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$a */
    private static final class C1017a {
        @SerializedName("sdk_name")

        /* renamed from: a */
        private final String f730a;
        @SerializedName("support_os")

        /* renamed from: b */
        private final String f731b;
        @SerializedName("configuration_version")

        /* renamed from: c */
        private final String f732c;
        @SerializedName("use_internal_methods")

        /* renamed from: d */
        private final Boolean f733d;

        public C1017a() {
            this((String) null, (String) null, (String) null, (Boolean) null, 15, (DefaultConstructorMarker) null);
        }

        public C1017a(String str, String str2, String str3, Boolean bool) {
            this.f730a = str;
            this.f731b = str2;
            this.f732c = str3;
            this.f733d = bool;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C1017a(String str, String str2, String str3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool);
        }

        /* renamed from: a */
        public final boolean mo21496a() {
            return !(Intrinsics.areEqual((Object) this.f730a, (Object) "SilentLogSDK") ^ true) && !(Intrinsics.areEqual((Object) this.f731b, (Object) "Android") ^ true) && !(Intrinsics.areEqual((Object) this.f732c, (Object) "1") ^ true) && !(Intrinsics.areEqual((Object) this.f733d, (Object) true) ^ true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1017a)) {
                return false;
            }
            C1017a aVar = (C1017a) obj;
            return Intrinsics.areEqual((Object) this.f730a, (Object) aVar.f730a) && Intrinsics.areEqual((Object) this.f731b, (Object) aVar.f731b) && Intrinsics.areEqual((Object) this.f732c, (Object) aVar.f732c) && Intrinsics.areEqual((Object) this.f733d, (Object) aVar.f733d);
        }

        public int hashCode() {
            String str = this.f730a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f731b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f732c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Boolean bool = this.f733d;
            if (bool != null) {
                i = bool.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("InternalData(sdkName=");
            a.append(this.f730a);
            a.append(", supportOs=");
            a.append(this.f731b);
            a.append(", configurationVersion=");
            a.append(this.f732c);
            a.append(", useInternalMethods=");
            a.append(this.f733d);
            a.append(")");
            return a.toString();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$a0 */
    static final class C1018a0<T> implements C1741d<Integer> {

        /* renamed from: a */
        final /* synthetic */ SilentLogAdListener.OnCompletedResponseAd f734a;

        /* renamed from: b */
        final /* synthetic */ RFLAdResType f735b;

        /* renamed from: c */
        final /* synthetic */ int f736c;

        C1018a0(SilentLogAdListener.OnCompletedResponseAd onCompletedResponseAd, RFLAdResType rFLAdResType, int i) {
            this.f734a = onCompletedResponseAd;
            this.f735b = rFLAdResType;
            this.f736c = i;
        }

        /* renamed from: a */
        public final void accept(Integer num) {
            this.f734a.onResult(num != null && num.intValue() == 800, this.f735b, this.f736c);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$b */
    static final class C1019b extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        final /* synthetic */ SilentLogDailyTagListener f737a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1019b(SilentLogDailyTagListener silentLogDailyTagListener) {
            super(0);
            this.f737a = silentLogDailyTagListener;
        }

        public final void invoke() {
            SilentLogDailyTagListener silentLogDailyTagListener = this.f737a;
            if (silentLogDailyTagListener != null) {
                silentLogDailyTagListener.onCompleted();
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$b0 */
    static final class C1020b0<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ SilentLogAdListener.OnCompletedResponseAd f738a;

        /* renamed from: b */
        final /* synthetic */ RFLAdResType f739b;

        /* renamed from: c */
        final /* synthetic */ int f740c;

        C1020b0(SilentLogAdListener.OnCompletedResponseAd onCompletedResponseAd, RFLAdResType rFLAdResType, int i) {
            this.f738a = onCompletedResponseAd;
            this.f739b = rFLAdResType;
            this.f740c = i;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK] Error:: POST ad/response API error=", th, "it")), new Object[0]);
            this.f738a.onResult(false, this.f739b, this.f740c);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$c */
    static final class C1021c extends Lambda implements Function1<Boolean, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f741a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1021c(RFLSilentLogOperation rFLSilentLogOperation) {
            super(1);
            this.f741a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void mo21503a(boolean z) {
            RFLSilentLogOperation.access$getOperationListener$p(this.f741a).resultForLoadUserProfile(z);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21503a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$c0 */
    static final class C1022c0 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f742a;

        C1022c0(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f742a = rFLSilentLogOperation;
        }

        public final void run() {
            RFLSilentLogOperation.access$getClientContext$p(this.f742a).stopService(new Intent(RFLSilentLogOperation.access$getClientContext$p(this.f742a), Class.forName(RFLSharedHolder.INSTANCE.serviceName())));
            C1122a.m1596a("[SilentLogSDK] Debug::Stop Service", new Object[0]);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$d */
    static final class C1023d<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f743a;

        /* renamed from: b */
        final /* synthetic */ String f744b;

        /* renamed from: c */
        final /* synthetic */ String f745c;

        /* renamed from: d */
        final /* synthetic */ Map f746d;

        /* renamed from: e */
        final /* synthetic */ String f747e;

        /* renamed from: f */
        final /* synthetic */ String f748f;

        /* renamed from: g */
        final /* synthetic */ String f749g;

        /* renamed from: h */
        final /* synthetic */ boolean f750h;

        C1023d(RFLSilentLogOperation rFLSilentLogOperation, String str, String str2, Map map, String str3, String str4, String str5, boolean z) {
            this.f743a = rFLSilentLogOperation;
            this.f744b = str;
            this.f745c = str2;
            this.f746d = map;
            this.f747e = str3;
            this.f748f = str4;
            this.f749g = str5;
            this.f750h = z;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            SilentLogOperation.SilentLogOperationListener silentLogOperationListener;
            SilentLogOperation.ConnectResult connectResult;
            int code = aPIResponse.getCode();
            if (code == 200) {
                Object data = aPIResponse.getData();
                if (data != null) {
                    RFLCreate rFLCreate = (RFLCreate) data;
                    String token = rFLCreate.getToken();
                    if (!(token == null || token.length() == 0)) {
                        RFLSharedHolder.INSTANCE.setUsername(this.f744b);
                        RFLSharedHolder.INSTANCE.setPassword(this.f745c);
                        RFLSharedHolder.INSTANCE.setAccessToken(rFLCreate.getToken());
                        RFLSharedHolder.INSTANCE.setSilentLogUserId(rFLCreate.getUserId());
                        RFLSilentLogOperation.access$getOperationListener$p(this.f743a).resultForConnectApi(SilentLogOperation.ConnectResult.Success, rFLCreate.getUserId());
                        this.f743a.m1400b(this.f746d);
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate");
                }
            } else if (code == 404) {
                this.f743a.m1394a(this.f744b, this.f747e, this.f745c, this.f748f, this.f749g, this.f750h, this.f746d);
                return;
            } else if (code == 406) {
                silentLogOperationListener = RFLSilentLogOperation.access$getOperationListener$p(this.f743a);
                connectResult = SilentLogOperation.ConnectResult.FailRestricted;
                silentLogOperationListener.resultForConnectApi(connectResult, (String) null);
            }
            silentLogOperationListener = RFLSilentLogOperation.access$getOperationListener$p(this.f743a);
            connectResult = SilentLogOperation.ConnectResult.FailLogin;
            silentLogOperationListener.resultForConnectApi(connectResult, (String) null);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "logoutResponse", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLLogout;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$d0 */
    static final class C1024d0<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f751a;

        /* renamed from: b */
        final /* synthetic */ String f752b;

        /* renamed from: c */
        final /* synthetic */ String f753c;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$d0$a */
        static final class C1025a extends Lambda implements Function1<C1714r<RFLH1Client.APIResponse>, Unit> {

            /* renamed from: a */
            final /* synthetic */ Ref.ObjectRef f754a;

            /* renamed from: b */
            final /* synthetic */ CountDownLatch f755b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1025a(Ref.ObjectRef objectRef, CountDownLatch countDownLatch) {
                super(1);
                this.f754a = objectRef;
                this.f755b = countDownLatch;
            }

            /* renamed from: a */
            public final void mo21507a(C1714r<RFLH1Client.APIResponse> rVar) {
                Intrinsics.checkParameterIsNotNull(rVar, "task");
                this.f754a.element = rVar;
                this.f755b.countDown();
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                mo21507a((C1714r) obj);
                return Unit.INSTANCE;
            }
        }

        C1024d0(RFLSilentLogOperation rFLSilentLogOperation, String str, String str2) {
            this.f751a = rFLSilentLogOperation;
            this.f752b = str;
            this.f753c = str2;
        }

        /* renamed from: a */
        public final C1714r<RFLH1Client.APIResponse> apply(Response<RFLLogout> response) {
            Intrinsics.checkParameterIsNotNull(response, "logoutResponse");
            C1122a.m1596a("[SilentLogSDK]::Debug responseCode=" + response.code(), new Object[0]);
            this.f751a.getAccountManager$silentlogsdkandroid_release().logoutSDK();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            this.f751a.getAccountManager$silentlogsdkandroid_release().create(this.f752b, (String) null, this.f753c, RFLAccountManager.DEFAULT_GENDER, RFLAccountManager.DEFAULT_BIRTHDAY, false, new C1025a(objectRef, countDownLatch));
            countDownLatch.await();
            return (C1714r) objectRef.element;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$e */
    static final class C1026e<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f756a;

        C1026e(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f756a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            RFLSilentLogOperation.access$getOperationListener$p(this.f756a).resultForConnectApi(SilentLogOperation.ConnectResult.FailLogin, (String) null);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$e0 */
    static final class C1027e0<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f757a;

        /* renamed from: b */
        final /* synthetic */ SilentLogTwoWeekSettingListener f758b;

        /* renamed from: c */
        final /* synthetic */ String f759c;

        /* renamed from: d */
        final /* synthetic */ String f760d;

        /* renamed from: e */
        final /* synthetic */ boolean f761e;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$e0$a */
        static final class C1028a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1027e0 f762a;

            C1028a(C1027e0 e0Var) {
                this.f762a = e0Var;
            }

            public final void run() {
                this.f762a.f758b.onCompleted(false);
            }
        }

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "userProfileResult", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$e0$b */
        static final class C1029b extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: a */
            final /* synthetic */ C1027e0 f763a;

            @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "removeResult", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
            /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$e0$b$a */
            static final class C1030a extends Lambda implements Function1<Boolean, Unit> {

                /* renamed from: a */
                final /* synthetic */ C1029b f764a;

                /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$e0$b$a$a */
                static final class C1031a implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ C1030a f765a;

                    /* renamed from: b */
                    final /* synthetic */ boolean f766b;

                    C1031a(C1030a aVar, boolean z) {
                        this.f765a = aVar;
                        this.f766b = z;
                    }

                    public final void run() {
                        this.f765a.f764a.f763a.f758b.onCompleted(this.f766b);
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1030a(C1029b bVar) {
                    super(1);
                    this.f764a = bVar;
                }

                /* renamed from: a */
                public final void mo21512a(boolean z) {
                    if (z) {
                        StringBuilder a = C0681a.m330a("[SilentLogSDK] Debug::EnableTwoWeekSetting(");
                        a.append(this.f764a.f763a.f761e);
                        a.append(") success.");
                        C1122a.m1596a(a.toString(), new Object[0]);
                    } else {
                        C1122a.m1599b("[SilentLogSDK] Error::EnableTwoWeekSetting Error:removeTwoWeekData", new Object[0]);
                    }
                    new Handler(Looper.getMainLooper()).post(new C1031a(this, z));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    mo21512a(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }
            }

            /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$e0$b$b */
            static final class C1032b implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C1029b f767a;

                C1032b(C1029b bVar) {
                    this.f767a = bVar;
                }

                public final void run() {
                    this.f767a.f763a.f758b.onCompleted(false);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1029b(C1027e0 e0Var) {
                super(1);
                this.f763a = e0Var;
            }

            /* renamed from: a */
            public final void mo21511a(boolean z) {
                RFLSilentLogOperation.access$getOperationListener$p(this.f763a.f757a).resultForLoadUserProfile(z);
                if (z) {
                    this.f763a.f757a.getDailyManager$silentlogsdkandroid_release().removeTwoWeekData(new C1030a(this));
                    return;
                }
                C1122a.m1599b("[SilentLogSDK] Error::EnableTwoWeekSetting loadUserProfile failed", new Object[0]);
                new Handler(Looper.getMainLooper()).post(new C1032b(this));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                mo21511a(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }

        /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$e0$c */
        static final class C1033c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1027e0 f768a;

            C1033c(C1027e0 e0Var) {
                this.f768a = e0Var;
            }

            public final void run() {
                this.f768a.f758b.onCompleted(false);
            }
        }

        C1027e0(RFLSilentLogOperation rFLSilentLogOperation, SilentLogTwoWeekSettingListener silentLogTwoWeekSettingListener, String str, String str2, boolean z) {
            this.f757a = rFLSilentLogOperation;
            this.f758b = silentLogTwoWeekSettingListener;
            this.f759c = str;
            this.f760d = str2;
            this.f761e = z;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            Handler handler;
            Runnable runnable;
            if (aPIResponse.getCode() == 200) {
                Object data = aPIResponse.getData();
                if (data != null) {
                    RFLCreate rFLCreate = (RFLCreate) data;
                    String token = rFLCreate.getToken();
                    if (token == null || token.length() == 0) {
                        C1122a.m1599b("[SilentLogSDK] Error::EnableTwoWeekSetting Error:token is null", new Object[0]);
                        handler = new Handler(Looper.getMainLooper());
                        runnable = new C1028a(this);
                    } else {
                        RFLSharedHolder.INSTANCE.setUsername(this.f759c);
                        RFLSharedHolder.INSTANCE.setPassword(this.f760d);
                        RFLSharedHolder.INSTANCE.setAccessToken(rFLCreate.getToken());
                        RFLSharedHolder.INSTANCE.setSilentLogUserId(rFLCreate.getUserId());
                        this.f757a.getAccountManager$silentlogsdkandroid_release().loadUserProfile(new C1029b(this));
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate");
                }
            } else {
                StringBuilder a = C0681a.m330a("[SilentLogSDK] Error::EnableTwoWeekSetting ErrorCode:");
                a.append(aPIResponse.getCode());
                C1122a.m1599b(a.toString(), new Object[0]);
                handler = new Handler(Looper.getMainLooper());
                runnable = new C1033c(this);
            }
            handler.post(runnable);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$f */
    static final class C1034f<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f769a;

        /* renamed from: b */
        final /* synthetic */ String f770b;

        /* renamed from: c */
        final /* synthetic */ String f771c;

        C1034f(RFLSilentLogOperation rFLSilentLogOperation, String str, String str2) {
            this.f769a = rFLSilentLogOperation;
            this.f770b = str;
            this.f771c = str2;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            SilentLogOperation.SilentLogOperationListener silentLogOperationListener;
            SilentLogOperation.ConnectResult connectResult;
            int code = aPIResponse.getCode();
            if (code == 200) {
                Object data = aPIResponse.getData();
                if (data != null) {
                    RFLCreate rFLCreate = (RFLCreate) data;
                    String token = rFLCreate.getToken();
                    if (!(token == null || token.length() == 0)) {
                        RFLSharedHolder.INSTANCE.setUsername(this.f770b);
                        RFLSharedHolder.INSTANCE.setPassword(this.f771c);
                        RFLSharedHolder.INSTANCE.setAccessToken(rFLCreate.getToken());
                        RFLSharedHolder.INSTANCE.setSilentLogUserId(rFLCreate.getUserId());
                        RFLSilentLogOperation.access$getOperationListener$p(this.f769a).resultForConnectApi(SilentLogOperation.ConnectResult.Success, rFLCreate.getUserId());
                        this.f769a.m1400b((Map<String, ? extends Object>) null);
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate");
                }
            } else if (code == 406) {
                silentLogOperationListener = RFLSilentLogOperation.access$getOperationListener$p(this.f769a);
                connectResult = SilentLogOperation.ConnectResult.FailRestricted;
                silentLogOperationListener.resultForConnectApi(connectResult, (String) null);
            }
            silentLogOperationListener = RFLSilentLogOperation.access$getOperationListener$p(this.f769a);
            connectResult = SilentLogOperation.ConnectResult.FailLogin;
            silentLogOperationListener.resultForConnectApi(connectResult, (String) null);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$f0 */
    static final class C1035f0<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ SilentLogTwoWeekSettingListener f772a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$f0$a */
        static final class C1036a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1035f0 f773a;

            C1036a(C1035f0 f0Var) {
                this.f773a = f0Var;
            }

            public final void run() {
                this.f773a.f772a.onCompleted(false);
            }
        }

        C1035f0(SilentLogTwoWeekSettingListener silentLogTwoWeekSettingListener) {
            this.f772a = silentLogTwoWeekSettingListener;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK] Error::EnableTwoWeekSetting Error:%", th, "it")), new Object[0]);
            new Handler(Looper.getMainLooper()).post(new C1036a(this));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$g */
    static final class C1037g<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f774a;

        C1037g(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f774a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            Intrinsics.checkExpressionValueIsNotNull(th, "it");
            C1122a.m1599b("login Error :%s", th.getLocalizedMessage());
            RFLSilentLogOperation.access$getOperationListener$p(this.f774a).resultForConnectApi(SilentLogOperation.ConnectResult.FailLogin, (String) null);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$g0 */
    static final class C1038g0 extends Lambda implements Function1<Boolean, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f775a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1038g0(RFLSilentLogOperation rFLSilentLogOperation) {
            super(1);
            this.f775a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void mo21520a(boolean z) {
            if (z) {
                this.f775a.getAccountManager$silentlogsdkandroid_release().syncAdvertisingId();
                this.f775a.getAccountManager$silentlogsdkandroid_release().syncPushToken();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21520a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$h */
    static final class C1039h<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f776a;

        /* renamed from: b */
        final /* synthetic */ String f777b;

        /* renamed from: c */
        final /* synthetic */ String f778c;

        /* renamed from: d */
        final /* synthetic */ String f779d;

        /* renamed from: e */
        final /* synthetic */ String f780e;

        /* renamed from: f */
        final /* synthetic */ boolean f781f;

        C1039h(RFLSilentLogOperation rFLSilentLogOperation, String str, String str2, String str3, String str4, boolean z) {
            this.f776a = rFLSilentLogOperation;
            this.f777b = str;
            this.f778c = str2;
            this.f779d = str3;
            this.f780e = str4;
            this.f781f = z;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            SilentLogOperation.SilentLogOperationListener silentLogOperationListener;
            SilentLogOperation.ConnectResult connectResult;
            int code = aPIResponse.getCode();
            if (code == 200) {
                Object data = aPIResponse.getData();
                if (data != null) {
                    RFLCreate rFLCreate = (RFLCreate) data;
                    String token = rFLCreate.getToken();
                    if (!(token == null || token.length() == 0)) {
                        RFLSharedHolder.INSTANCE.setUsername(this.f777b);
                        RFLSharedHolder.INSTANCE.setPassword(this.f778c);
                        RFLSharedHolder.INSTANCE.setAccessToken(rFLCreate.getToken());
                        RFLSharedHolder.INSTANCE.setSilentLogUserId(rFLCreate.getUserId());
                        RFLSilentLogOperation.access$getOperationListener$p(this.f776a).resultForConnectApi(SilentLogOperation.ConnectResult.Success, rFLCreate.getUserId());
                        this.f776a.m1400b((Map<String, ? extends Object>) null);
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate");
                }
            } else if (code == 404) {
                RFLSilentLogOperation rFLSilentLogOperation = this.f776a;
                String str = this.f777b;
                RFLSilentLogOperation.m1396a(rFLSilentLogOperation, str, str, this.f778c, this.f779d, this.f780e, this.f781f, (Map) null, 64, (Object) null);
                return;
            } else if (code == 406) {
                silentLogOperationListener = RFLSilentLogOperation.access$getOperationListener$p(this.f776a);
                connectResult = SilentLogOperation.ConnectResult.FailRestricted;
                silentLogOperationListener.resultForConnectApi(connectResult, (String) null);
            }
            silentLogOperationListener = RFLSilentLogOperation.access$getOperationListener$p(this.f776a);
            connectResult = SilentLogOperation.ConnectResult.FailLogin;
            silentLogOperationListener.resultForConnectApi(connectResult, (String) null);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$h0 */
    static final class C1040h0 extends Lambda implements Function2<Boolean, Date, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f782a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1040h0(RFLSilentLogOperation rFLSilentLogOperation) {
            super(2);
            this.f782a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void mo21522a(boolean z, Date date) {
            RFLSilentLogOperation.access$getOperationListener$p(this.f782a).resultForUpdateBirthday(z, date);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            mo21522a(((Boolean) obj).booleanValue(), (Date) obj2);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$i */
    static final class C1041i<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f783a;

        C1041i(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f783a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            Intrinsics.checkExpressionValueIsNotNull(th, "it");
            C1122a.m1599b("login Error :%s", th.getLocalizedMessage());
            RFLSilentLogOperation.access$getOperationListener$p(this.f783a).resultForConnectApi(SilentLogOperation.ConnectResult.FailLogin, (String) null);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$i0 */
    static final class C1042i0 extends Lambda implements Function2<Boolean, Integer, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f784a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1042i0(RFLSilentLogOperation rFLSilentLogOperation) {
            super(2);
            this.f784a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void mo21524a(boolean z, int i) {
            RFLSilentLogOperation.access$getOperationListener$p(this.f784a).resultForUpdateGender(z, i);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            mo21524a(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "task", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$j */
    static final class C1043j extends Lambda implements Function1<C1714r<RFLH1Client.APIResponse>, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f785a;

        /* renamed from: b */
        final /* synthetic */ String f786b;

        /* renamed from: c */
        final /* synthetic */ String f787c;

        /* renamed from: d */
        final /* synthetic */ Map f788d;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$j$a */
        static final class C1044a<T> implements C1741d<RFLH1Client.APIResponse> {

            /* renamed from: a */
            final /* synthetic */ C1043j f789a;

            C1044a(C1043j jVar) {
                this.f789a = jVar;
            }

            /* renamed from: a */
            public final void accept(RFLH1Client.APIResponse aPIResponse) {
                if (aPIResponse.getCode() == 200) {
                    Object data = aPIResponse.getData();
                    if (data != null) {
                        RFLCreate rFLCreate = (RFLCreate) data;
                        String token = rFLCreate.getToken();
                        if (!(token == null || token.length() == 0)) {
                            RFLSharedHolder.INSTANCE.setUsername(this.f789a.f786b);
                            RFLSharedHolder.INSTANCE.setPassword(this.f789a.f787c);
                            RFLSharedHolder.INSTANCE.setAccessToken(rFLCreate.getToken());
                            RFLSharedHolder.INSTANCE.setSilentLogUserId(rFLCreate.getUserId());
                            RFLSilentLogOperation.access$getOperationListener$p(this.f789a.f785a).resultForConnectApi(SilentLogOperation.ConnectResult.Success, rFLCreate.getUserId());
                            C1043j jVar = this.f789a;
                            jVar.f785a.m1400b(jVar.f788d);
                            return;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate");
                    }
                }
                RFLSilentLogOperation.access$getOperationListener$p(this.f789a.f785a).resultForConnectApi(SilentLogOperation.ConnectResult.FailCreate, (String) null);
            }
        }

        /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$j$b */
        static final class C1045b<T> implements C1741d<Throwable> {

            /* renamed from: a */
            final /* synthetic */ C1043j f790a;

            C1045b(C1043j jVar) {
                this.f790a = jVar;
            }

            /* renamed from: a */
            public final void accept(Throwable th) {
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                C1122a.m1599b("create Error:%s", th.getLocalizedMessage());
                RFLSilentLogOperation.access$getOperationListener$p(this.f790a.f785a).resultForConnectApi(SilentLogOperation.ConnectResult.FailCreate, (String) null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1043j(RFLSilentLogOperation rFLSilentLogOperation, String str, String str2, Map map) {
            super(1);
            this.f785a = rFLSilentLogOperation;
            this.f786b = str;
            this.f787c = str2;
            this.f788d = map;
        }

        /* renamed from: a */
        public final void mo21525a(C1714r<RFLH1Client.APIResponse> rVar) {
            Intrinsics.checkParameterIsNotNull(rVar, "task");
            rVar.mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1044a(this), new C1045b(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21525a((C1714r) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$j0 */
    static final class C1046j0<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f791a;

        /* renamed from: b */
        final /* synthetic */ String f792b;

        /* renamed from: c */
        final /* synthetic */ String f793c;

        C1046j0(RFLSilentLogOperation rFLSilentLogOperation, String str, String str2) {
            this.f791a = rFLSilentLogOperation;
            this.f792b = str;
            this.f793c = str2;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            SilentLogInternalOperation.SilentLogInternalOperationListener silentLogInternalOperationListener;
            boolean z;
            if (aPIResponse.getCode() == 200) {
                RFLSharedHolder.INSTANCE.setUsername(this.f792b);
                RFLSharedHolder.INSTANCE.setPassword(this.f793c);
                silentLogInternalOperationListener = this.f791a.getInternalOperationListener();
                if (silentLogInternalOperationListener != null) {
                    z = true;
                } else {
                    return;
                }
            } else {
                silentLogInternalOperationListener = this.f791a.getInternalOperationListener();
                if (silentLogInternalOperationListener != null) {
                    z = false;
                } else {
                    return;
                }
            }
            silentLogInternalOperationListener.resultForUpdatePassword(z);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "task", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$k */
    static final class C1047k extends Lambda implements Function1<C1714r<RFLH1Client.APIResponse>, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f794a;

        /* renamed from: b */
        final /* synthetic */ String f795b;

        /* renamed from: c */
        final /* synthetic */ String f796c;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$k$a */
        static final class C1048a<T> implements C1741d<RFLH1Client.APIResponse> {

            /* renamed from: a */
            final /* synthetic */ C1047k f797a;

            /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$k$a$a */
            static final class C1049a extends Lambda implements Function1<Boolean, Unit> {

                /* renamed from: a */
                public static final C1049a f798a = new C1049a();

                C1049a() {
                    super(1);
                }

                /* renamed from: a */
                public final void mo21531a(boolean z) {
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    mo21531a(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }
            }

            C1048a(C1047k kVar) {
                this.f797a = kVar;
            }

            /* renamed from: a */
            public final void accept(RFLH1Client.APIResponse aPIResponse) {
                this.f797a.f794a.f728h = false;
                if (aPIResponse.getCode() == 200) {
                    Object data = aPIResponse.getData();
                    if (data != null) {
                        RFLCreate rFLCreate = (RFLCreate) data;
                        String token = rFLCreate.getToken();
                        if (token == null || token.length() == 0) {
                            C1122a.m1599b("[SilentLogSDK] Error:: Create Error: token is null", new Object[0]);
                            return;
                        }
                        RFLSharedHolder.INSTANCE.setUsername(this.f797a.f795b);
                        RFLSharedHolder.INSTANCE.setPassword(this.f797a.f796c);
                        RFLSharedHolder.INSTANCE.setAccessToken(rFLCreate.getToken());
                        this.f797a.f794a.getAccountManager$silentlogsdkandroid_release().loadUserProfile(C1049a.f798a);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate");
                }
            }
        }

        /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$k$b */
        static final class C1050b<T> implements C1741d<Throwable> {

            /* renamed from: a */
            final /* synthetic */ C1047k f799a;

            C1050b(C1047k kVar) {
                this.f799a = kVar;
            }

            /* renamed from: a */
            public final void accept(Throwable th) {
                this.f799a.f794a.f728h = false;
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                C1122a.m1599b("[SilentLogSDK] Error:: Create Error:%s", th.getLocalizedMessage());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1047k(RFLSilentLogOperation rFLSilentLogOperation, String str, String str2) {
            super(1);
            this.f794a = rFLSilentLogOperation;
            this.f795b = str;
            this.f796c = str2;
        }

        /* renamed from: a */
        public final void mo21529a(C1714r<RFLH1Client.APIResponse> rVar) {
            Intrinsics.checkParameterIsNotNull(rVar, "task");
            rVar.mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1048a(this), new C1050b(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21529a((C1714r) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$k0 */
    static final class C1051k0<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f800a;

        C1051k0(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f800a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            Intrinsics.checkExpressionValueIsNotNull(th, "it");
            C1122a.m1599b("login Error :%s", th.getLocalizedMessage());
            SilentLogInternalOperation.SilentLogInternalOperationListener internalOperationListener = this.f800a.getInternalOperationListener();
            if (internalOperationListener != null) {
                internalOperationListener.resultForUpdatePassword(false);
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$l */
    static final class C1052l extends Lambda implements Function1<Boolean, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f801a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1052l(RFLSilentLogOperation rFLSilentLogOperation) {
            super(1);
            this.f801a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void mo21534a(boolean z) {
            RFLSilentLogOperation.access$getOperationListener$p(this.f801a).resultForLoadUserProfile(z);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21534a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$m */
    static final class C1053m extends Lambda implements Function1<RFLWeather, Unit> {

        /* renamed from: a */
        final /* synthetic */ SilentLogWeatherListener.OnCompletedFind f802a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1053m(SilentLogWeatherListener.OnCompletedFind onCompletedFind) {
            super(1);
            this.f802a = onCompletedFind;
        }

        /* renamed from: a */
        public final void mo21535a(RFLWeather rFLWeather) {
            this.f802a.result(rFLWeather);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21535a((RFLWeather) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$n */
    static final class C1054n extends Lambda implements Function2<Boolean, String, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f803a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1054n(RFLSilentLogOperation rFLSilentLogOperation) {
            super(2);
            this.f803a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void mo21536a(boolean z, String str) {
            SilentLogInternalOperation.SilentLogInternalOperationListener internalOperationListener = this.f803a.getInternalOperationListener();
            if (internalOperationListener != null) {
                internalOperationListener.resultForForgetPassword(z, str);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            mo21536a(((Boolean) obj).booleanValue(), (String) obj2);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$o */
    static final class C1055o<T> implements C1741d<List<? extends RFLAdCampaign>> {

        /* renamed from: a */
        final /* synthetic */ SilentLogAdListener.OnCompletedGetCampaign f804a;

        C1055o(SilentLogAdListener.OnCompletedGetCampaign onCompletedGetCampaign) {
            this.f804a = onCompletedGetCampaign;
        }

        /* renamed from: a */
        public final void accept(List<RFLAdCampaign> list) {
            SilentLogAdListener.OnCompletedGetCampaign onCompletedGetCampaign = this.f804a;
            Intrinsics.checkExpressionValueIsNotNull(list, "it");
            onCompletedGetCampaign.onResult(true, list);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$p */
    static final class C1056p<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ SilentLogAdListener.OnCompletedGetCampaign f805a;

        C1056p(SilentLogAdListener.OnCompletedGetCampaign onCompletedGetCampaign) {
            this.f805a = onCompletedGetCampaign;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK] Error:: GET ad/campaign API error=", th, "it")), new Object[0]);
            this.f805a.onResult(false, CollectionsKt__CollectionsKt.emptyList());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$q */
    static final class C1057q extends Lambda implements Function3<Boolean, Date, Integer, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f806a;

        /* renamed from: b */
        final /* synthetic */ SilentLogOperation.SilentLogStepsListener f807b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1057q(RFLSilentLogOperation rFLSilentLogOperation, SilentLogOperation.SilentLogStepsListener silentLogStepsListener) {
            super(3);
            this.f806a = rFLSilentLogOperation;
            this.f807b = silentLogStepsListener;
        }

        /* renamed from: a */
        public final void mo21539a(boolean z, Date date, int i) {
            Intrinsics.checkParameterIsNotNull(date, "<anonymous parameter 1>");
            this.f807b.resultTodaySteps(z, i);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            mo21539a(((Boolean) obj).booleanValue(), (Date) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$r */
    static final class C1058r extends Lambda implements Function1<Boolean, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f808a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1058r(RFLSilentLogOperation rFLSilentLogOperation) {
            super(1);
            this.f808a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void mo21541a(boolean z) {
            RFLSilentLogOperation.access$getOperationListener$p(this.f808a).resultForLoadUserProfile(z);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21541a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$s */
    static final class C1059s<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f809a;

        /* renamed from: b */
        final /* synthetic */ String f810b;

        /* renamed from: c */
        final /* synthetic */ String f811c;

        C1059s(RFLSilentLogOperation rFLSilentLogOperation, String str, String str2) {
            this.f809a = rFLSilentLogOperation;
            this.f810b = str;
            this.f811c = str2;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            if (aPIResponse.getCode() == 200) {
                this.f809a.f728h = false;
                Object data = aPIResponse.getData();
                if (data != null) {
                    RFLCreate rFLCreate = (RFLCreate) data;
                    String token = rFLCreate.getToken();
                    if (token == null || token.length() == 0) {
                        C1122a.m1599b("[SilentLogSDK] Error:: Create Error: token is null", new Object[0]);
                    } else {
                        RFLSharedHolder.INSTANCE.setUsername(this.f810b);
                        RFLSharedHolder.INSTANCE.setPassword(this.f811c);
                        RFLSharedHolder.INSTANCE.setAccessToken(rFLCreate.getToken());
                        this.f809a.m1400b((Map<String, ? extends Object>) null);
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate");
                }
            }
            RFLSilentLogOperation.access$getOperationListener$p(this.f809a).resultForLogoutApi(SilentLogOperation.LogoutResult.Success);
            this.f809a.m1398b();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$t */
    static final class C1060t<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f812a;

        C1060t(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f812a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f812a.f728h = false;
            Intrinsics.checkExpressionValueIsNotNull(th, "it");
            C1122a.m1599b("[SilentLogSDK] Error:: Login Error:%s", th.getLocalizedMessage());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$u */
    static final class C1061u<T> implements C1741d<Response<RFLLogout>> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f813a;

        C1061u(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f813a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void accept(Response<RFLLogout> response) {
            SilentLogOperation.SilentLogOperationListener silentLogOperationListener;
            SilentLogOperation.LogoutResult logoutResult;
            int code = response.code();
            if (code != 200) {
                if (code != 500) {
                    StringBuilder a = C0681a.m330a("[SilentLogSDK] Error:: Logout error=");
                    RFLLogout body = response.body();
                    String str = null;
                    a.append(body != null ? body.getError() : null);
                    a.append(" description=");
                    RFLLogout body2 = response.body();
                    if (body2 != null) {
                        str = body2.getErrorDescription();
                    }
                    a.append(str);
                    C1122a.m1599b(a.toString(), new Object[0]);
                } else {
                    StringBuilder a2 = C0681a.m330a("[SilentLogSDK] Error:: Logout error=");
                    a2.append(response.code());
                    C1122a.m1599b(a2.toString(), new Object[0]);
                }
                silentLogOperationListener = RFLSilentLogOperation.access$getOperationListener$p(this.f813a);
                logoutResult = SilentLogOperation.LogoutResult.Fail;
            } else {
                this.f813a.getAccountManager$silentlogsdkandroid_release().logoutSDK();
                silentLogOperationListener = RFLSilentLogOperation.access$getOperationListener$p(this.f813a);
                logoutResult = SilentLogOperation.LogoutResult.Success;
            }
            silentLogOperationListener.resultForLogoutApi(logoutResult);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$v */
    static final class C1062v<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f814a;

        C1062v(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f814a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK] Error:: Logout error=", th, "error")), new Object[0]);
            RFLSilentLogOperation.access$getOperationListener$p(this.f814a).resultForLogoutApi(SilentLogOperation.LogoutResult.Fail);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$w */
    static final class C1063w<T, R> implements C1742e<T, R> {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f815a;

        C1063w(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f815a = rFLSilentLogOperation;
        }

        /* renamed from: a */
        public final SilentLogOperation.LogoutResult apply(Response<RFLLogout> response) {
            Intrinsics.checkParameterIsNotNull(response, "response");
            int code = response.code();
            if (code != 200) {
                if (code != 500) {
                    StringBuilder a = C0681a.m330a("[SilentLogSDK] Error:: Logout error=");
                    RFLLogout body = response.body();
                    String str = null;
                    a.append(body != null ? body.getError() : null);
                    a.append(" description=");
                    RFLLogout body2 = response.body();
                    if (body2 != null) {
                        str = body2.getErrorDescription();
                    }
                    a.append(str);
                    C1122a.m1599b(a.toString(), new Object[0]);
                } else {
                    C1122a.m1599b("[SilentLogSDK] Error:: Logout error 500", new Object[0]);
                }
                return SilentLogOperation.LogoutResult.Fail;
            }
            boolean grant = RFLSharedHolder.INSTANCE.grant();
            this.f815a.getOrmaHolder().deleteAll();
            RFLSharedHolder.INSTANCE.deleteAll();
            RFLSharedHolder.INSTANCE.setGrant(grant);
            this.f815a.f723c = true;
            return SilentLogOperation.LogoutResult.Success;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$x */
    static final class C1064x implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLSilentLogOperation f816a;

        C1064x(RFLSilentLogOperation rFLSilentLogOperation) {
            this.f816a = rFLSilentLogOperation;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "it");
            boolean grant = RFLSharedHolder.INSTANCE.grant();
            this.f816a.getOrmaHolder().deleteAll();
            RFLSharedHolder.INSTANCE.deleteAll();
            RFLSharedHolder.INSTANCE.setGrant(grant);
            this.f816a.f723c = true;
            cVar.onComplete();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$y */
    static final class C1065y extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        final /* synthetic */ SilentLogDailyTagListener f817a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1065y(SilentLogDailyTagListener silentLogDailyTagListener) {
            super(0);
            this.f817a = silentLogDailyTagListener;
        }

        public final void invoke() {
            SilentLogDailyTagListener silentLogDailyTagListener = this.f817a;
            if (silentLogDailyTagListener != null) {
                silentLogDailyTagListener.onCompleted();
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$z */
    static final class C1066z extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        final /* synthetic */ SilentLogDailyTagListener f818a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1066z(SilentLogDailyTagListener silentLogDailyTagListener) {
            super(0);
            this.f818a = silentLogDailyTagListener;
        }

        public final void invoke() {
            SilentLogDailyTagListener silentLogDailyTagListener = this.f818a;
            if (silentLogDailyTagListener != null) {
                silentLogDailyTagListener.onCompleted();
            }
        }
    }

    /* renamed from: a */
    private final C1714r<RFLH1Client.APIResponse> m1391a(String str, String str2) {
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        return rFLH1Client.login(str, str2);
    }

    /* renamed from: a */
    private final Pair<String, String> m1392a() {
        String clientId = RFLSharedHolder.INSTANCE.clientId();
        String a = C0681a.m328a(new Object[]{RFLSharedHolder.INSTANCE.uuid(), Long.valueOf(System.currentTimeMillis() / ((long) 1000)), clientId}, 3, "%s%s%sSDK@silentlog.com", "java.lang.String.format(this, *args)");
        return new Pair<>(a, RFLDailyUtilsKt.md5(a));
    }

    /* renamed from: a */
    private final void m1393a(int i) {
        Context context = this.f724d;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clientContext");
        }
        Intent intent = new Intent(context, Class.forName(RFLSharedHolder.INSTANCE.serviceName()));
        Context context2 = this.f724d;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clientContext");
        }
        context2.stopService(intent);
        RFLDailyManager rFLDailyManager = this.dailyManager;
        if (rFLDailyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
        }
        rFLDailyManager.startFromGeoFence(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m1394a(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, ? extends Object> map) {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        rFLAccountManager.create(str, str2, str3, str4, str5, z, new C1043j(this, str, str3, map));
    }

    /* renamed from: a */
    private final void m1395a(Map<String, ? extends Object> map) {
        Pair<String, String> a = m1392a();
        m1394a(a.component1(), (String) null, a.component2(), RFLAccountManager.DEFAULT_GENDER, RFLAccountManager.DEFAULT_BIRTHDAY, false, map);
    }

    /* renamed from: a */
    static /* synthetic */ void m1396a(RFLSilentLogOperation rFLSilentLogOperation, String str, String str2, String str3, String str4, String str5, boolean z, Map map, int i, Object obj) {
        rFLSilentLogOperation.m1394a(str, str2, str3, str4, str5, z, (i & 64) != 0 ? null : map);
    }

    /* renamed from: a */
    static /* synthetic */ void m1397a(RFLSilentLogOperation rFLSilentLogOperation, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        rFLSilentLogOperation.m1395a((Map<String, ? extends Object>) map);
    }

    public static final /* synthetic */ Context access$getClientContext$p(RFLSilentLogOperation rFLSilentLogOperation) {
        Context context = rFLSilentLogOperation.f724d;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clientContext");
        }
        return context;
    }

    public static final /* synthetic */ SilentLogOperation.SilentLogOperationListener access$getOperationListener$p(RFLSilentLogOperation rFLSilentLogOperation) {
        SilentLogOperation.SilentLogOperationListener silentLogOperationListener = rFLSilentLogOperation.f727g;
        if (silentLogOperationListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operationListener");
        }
        return silentLogOperationListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m1398b() {
        String clientId = RFLSharedHolder.INSTANCE.clientId();
        String uuid = RFLSharedHolder.INSTANCE.uuid();
        String a = C0681a.m328a(new Object[]{uuid, Long.valueOf(System.currentTimeMillis() / ((long) 1000)), clientId}, 3, "%s%s%sSDK@silentlog.com", "java.lang.String.format(this, *args)");
        String md5 = RFLDailyUtilsKt.md5(a);
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        rFLAccountManager.create(a, uuid, md5, RFLAccountManager.DEFAULT_GENDER, RFLAccountManager.DEFAULT_BIRTHDAY, false, new C1047k(this, a, md5));
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: b */
    private final void m1399b(String str, String str2) {
        m1391a(str, str2).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1059s(this, str, str2), new C1060t(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m1400b(Map<String, ? extends Object> map) {
        C1038g0 g0Var = new C1038g0(this);
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        Map<String, Object> removeDefaultPrivateKey$silentlogsdkandroid_release = rFLAccountManager.removeDefaultPrivateKey$silentlogsdkandroid_release(map);
        if (removeDefaultPrivateKey$silentlogsdkandroid_release == null || removeDefaultPrivateKey$silentlogsdkandroid_release.isEmpty()) {
            RFLAccountManager rFLAccountManager2 = this.accountManager;
            if (rFLAccountManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            rFLAccountManager2.loadUserProfile(g0Var);
            return;
        }
        RFLAccountManager rFLAccountManager3 = this.accountManager;
        if (rFLAccountManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        rFLAccountManager3.updatePrivateKey(removeDefaultPrivateKey$silentlogsdkandroid_release, g0Var);
    }

    /* renamed from: c */
    private final void m1401c() {
        RFLSharedHolder rFLSharedHolder = RFLSharedHolder.INSTANCE;
        Context context = this.f724d;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clientContext");
        }
        rFLSharedHolder.initialize(context);
        RFLSharedHolder rFLSharedHolder2 = RFLSharedHolder.INSTANCE;
        String str = this.f725e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clientId");
        }
        rFLSharedHolder2.setClientId(str);
        RFLSharedHolder rFLSharedHolder3 = RFLSharedHolder.INSTANCE;
        String str2 = this.f726f;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clientSecret");
        }
        rFLSharedHolder3.setClientSecret(str2);
        RFLSharedHolder.INSTANCE.setPriorityType(1);
        if (!RFLSharedHolder.INSTANCE.firstLaunch()) {
            long time = RFLDailyUtilsKt.start(new Date()).getTime();
            RFLSharedHolder.INSTANCE.setLaunch(true);
            RFLSharedHolder rFLSharedHolder4 = RFLSharedHolder.INSTANCE;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
            rFLSharedHolder4.setUUID(uuid);
            RFLSharedHolder.INSTANCE.setInstallDate(time);
            RFLSharedHolder.INSTANCE.setLoadTime(time);
            RFLSharedHolder.INSTANCE.setEventTime(time);
        }
    }

    public static /* synthetic */ void connectApi$silentlogsdkandroid_release$default(RFLSilentLogOperation rFLSilentLogOperation, String str, Integer num, Date date, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = null;
        }
        rFLSilentLogOperation.connectApi$silentlogsdkandroid_release(str, num, date, map);
    }

    /* renamed from: d */
    private final void m1402d() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar.mo21908c(this);
        C1126c cVar2 = this.eventBus;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar2.mo21907b(this);
    }

    /* renamed from: e */
    private final void m1403e() {
        String username = RFLSharedHolder.INSTANCE.username();
        String password = RFLSharedHolder.INSTANCE.password();
        boolean z = true;
        if (username.length() > 0) {
            if (password.length() <= 0) {
                z = false;
            }
            if (z) {
                m1399b(username, password);
                return;
            }
        }
        SilentLogOperation.SilentLogOperationListener silentLogOperationListener = this.f727g;
        if (silentLogOperationListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operationListener");
        }
        silentLogOperationListener.resultForLogoutApi(SilentLogOperation.LogoutResult.Success);
        m1398b();
    }

    /* renamed from: f */
    private final void m1404f() {
        new Handler().postDelayed(new C1022c0(this), 1000);
        if (RFLSharedHolder.INSTANCE.tracking()) {
            RFLLocationManager rFLLocationManager = this.locationManager;
            if (rFLLocationManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationManager");
            }
            rFLLocationManager.start();
            RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
            if (rFLGoogleFitManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
            }
            rFLGoogleFitManager.connect();
        }
    }

    /* renamed from: g */
    private final void m1405g() {
        try {
            if (hasAuth$silentlogsdkandroid_release()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[SilentLogSDK]::Debug startForegroundService ");
                Class<?> cls = Class.forName(RFLSharedHolder.INSTANCE.foregroundName());
                Intrinsics.checkExpressionValueIsNotNull(cls, "Class.forName(RFLSharedHolder.foregroundName())");
                sb.append(cls.getSimpleName());
                C1122a.m1596a(sb.toString(), new Object[0]);
                Context context = this.f724d;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clientContext");
                }
                Intent intent = new Intent(context, Class.forName(RFLSharedHolder.INSTANCE.foregroundName()));
                if (Build.VERSION.SDK_INT >= 26) {
                    Context context2 = this.f724d;
                    if (context2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clientContext");
                    }
                    context2.startForegroundService(intent);
                    return;
                }
                Context context3 = this.f724d;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clientContext");
                }
                context3.startService(intent);
            }
        } catch (ClassNotFoundException unused) {
            C1122a.m1599b("[SilentLogSDK] Error::Valid ForegroundService Required!!", new Object[0]);
        }
    }

    /* renamed from: h */
    private final void m1406h() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[SilentLogSDK]::Debug stopForegroundService ");
            Class<?> cls = Class.forName(RFLSharedHolder.INSTANCE.foregroundName());
            Intrinsics.checkExpressionValueIsNotNull(cls, "Class.forName(RFLSharedHolder.foregroundName())");
            sb.append(cls.getSimpleName());
            C1122a.m1596a(sb.toString(), new Object[0]);
            Context context = this.f724d;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clientContext");
            }
            Intent intent = new Intent(context, Class.forName(RFLSharedHolder.INSTANCE.foregroundName()));
            Context context2 = this.f724d;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clientContext");
            }
            context2.stopService(intent);
        } catch (ClassNotFoundException unused) {
            C1122a.m1599b("[SilentLogSDK] Error::Valid ForegroundService Required!!", new Object[0]);
        }
    }

    public final void addDailyTag(Date date, List<String> list, SilentLogDailyTagListener silentLogDailyTagListener) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(list, "dailyTags");
        RFLDailyTagManager rFLDailyTagManager = this.dailyTagManager;
        if (rFLDailyTagManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyTagManager");
        }
        rFLDailyTagManager.addDailyTagAsync(date, list, new C1019b(silentLogDailyTagListener));
    }

    public final void addJrFormAsync$silentlogsdkandroid_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "jrForm");
        if (RFLOperationValidator.INSTANCE.isCampaignId(str)) {
            RFLAccountManager rFLAccountManager = this.accountManager;
            if (rFLAccountManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            rFLAccountManager.addJrFormAsync$silentlogsdkandroid_release(str, new C1021c(this));
            return;
        }
        throw new IllegalArgumentException("param is not jr-form.");
    }

    public final void build$silentlogsdkandroid_release(Context context, SilentLogOperation.SilentLogOperationListener silentLogOperationListener, String str, String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "aClientContext");
        Intrinsics.checkParameterIsNotNull(silentLogOperationListener, "aListener");
        Intrinsics.checkParameterIsNotNull(str, "aClientId");
        Intrinsics.checkParameterIsNotNull(str2, "aClientSecret");
        if (!RFLOperationValidator.INSTANCE.isSilentLogClientId(str) || !RFLOperationValidator.INSTANCE.isSilentLogClientSecret(str2)) {
            throw new IllegalArgumentException("unknown params");
        } else if (this.f723c) {
            RFLAppComponent.SdkComponent.INSTANCE.initComponent$silentlogsdkandroid_release(context);
            RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
            if (component$silentlogsdkandroid_release != null) {
                component$silentlogsdkandroid_release.inject(this);
            }
            this.f724d = context;
            this.f727g = silentLogOperationListener;
            this.f725e = str;
            this.f726f = str2;
            C1122a.m1598a((C1122a.C1125c) new RFLLogTree());
            m1401c();
            RFLAccountManager rFLAccountManager = this.accountManager;
            if (rFLAccountManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            rFLAccountManager.build(str);
            RFLH1Client rFLH1Client = this.h1Client;
            if (rFLH1Client == null) {
                Intrinsics.throwUninitializedPropertyAccessException("h1Client");
            }
            rFLH1Client.build(context, z);
            RFLPointClient rFLPointClient = this.pointClient;
            if (rFLPointClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pointClient");
            }
            rFLPointClient.build(context, z);
            RFLWeatherClient rFLWeatherClient = this.weatherClient;
            if (rFLWeatherClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("weatherClient");
            }
            rFLWeatherClient.build(z);
            if (RFLSharedHolder.INSTANCE.tracking()) {
                RFLDailyManager rFLDailyManager = this.dailyManager;
                if (rFLDailyManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
                }
                SilentLogOperation.SilentLogOperationListener silentLogOperationListener2 = this.f727g;
                if (silentLogOperationListener2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("operationListener");
                }
                rFLDailyManager.build(context, silentLogOperationListener2);
                RFLLocationManager rFLLocationManager = this.locationManager;
                if (rFLLocationManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationManager");
                }
                rFLLocationManager.start();
                RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
                if (rFLGoogleFitManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
                }
                rFLGoogleFitManager.connect();
            }
            this.f723c = false;
            m1402d();
        }
    }

    @SuppressLint({"CheckResult"})
    public final void connectApi$silentlogsdkandroid_release(String str, Integer num, Date date, Map<String, ? extends Object> map) {
        if (!RFLOperationValidator.INSTANCE.isUserName(str) || !RFLOperationValidator.INSTANCE.isPrivateKey(map)) {
            throw new IllegalArgumentException("any params is invalid.");
        } else if (isLogin$silentlogsdkandroid_release()) {
        } else {
            if (str == null) {
                m1395a(map);
                return;
            }
            RFLAccountManager rFLAccountManager = this.accountManager;
            if (rFLAccountManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            String genderString = rFLAccountManager.getGenderString(num);
            RFLAccountManager rFLAccountManager2 = this.accountManager;
            if (rFLAccountManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            String birthdayString = rFLAccountManager2.getBirthdayString(date);
            boolean z = (num == null || num.intValue() == 0 || date == null) ? false : true;
            String a = C0681a.m328a(new Object[]{str, RFLSharedHolder.INSTANCE.clientId()}, 2, "%s%sSDK@silentlog.com", "java.lang.String.format(this, *args)");
            String md5 = RFLDailyUtilsKt.md5(a);
            Intrinsics.checkExpressionValueIsNotNull(m1391a(a, md5).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1023d(this, a, md5, map, str, genderString, birthdayString, z), new C1026e(this)), "login(email, password)\n …                        )");
        }
    }

    @SuppressLint({"CheckResult"})
    public final void connectApiViaLogin$silentlogsdkandroid_release(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        m1391a(str, str2).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1034f(this, str, str2), new C1037g(this));
    }

    @SuppressLint({"CheckResult"})
    public final void connectApiWithPass$silentlogsdkandroid_release(String str, String str2, Integer num, Date date) {
        if (isLogin$silentlogsdkandroid_release()) {
            return;
        }
        if (str != null && str2 != null) {
            RFLAccountManager rFLAccountManager = this.accountManager;
            if (rFLAccountManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            String genderString = rFLAccountManager.getGenderString(num);
            RFLAccountManager rFLAccountManager2 = this.accountManager;
            if (rFLAccountManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            Intrinsics.checkExpressionValueIsNotNull(m1391a(str, str2).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1039h(this, str, str2, genderString, rFLAccountManager2.getBirthdayString(date), (num == null || num.intValue() == 0 || date == null) ? false : true), new C1041i(this)), "login(username, password…                       })");
        } else if (str == null || str2 != null) {
            m1397a(this, (Map) null, 1, (Object) null);
        } else {
            C1122a.m1596a("call connectApi(" + str + ", " + num + ", " + date + ')', new Object[0]);
            connectApi$silentlogsdkandroid_release$default(this, str, num, date, (Map) null, 8, (Object) null);
        }
    }

    public final void connectGoogleFitClient$silentlogsdkandroid_release() {
        RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
        if (rFLGoogleFitManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
        }
        rFLGoogleFitManager.connect();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x005e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void createInternalOperation$silentlogsdkandroid_release(android.content.Context r5, p043jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation.SilentLogInternalOperationListener r6) {
        /*
            r4 = this;
            java.lang.String r0 = "clientContext"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            r0 = 0
            r4.f721a = r0
            android.content.res.AssetManager r1 = r5.getAssets()
            java.lang.String r2 = ""
            java.lang.String[] r1 = r1.list(r2)
            if (r1 == 0) goto L_0x006a
            java.lang.String r2 = "clientContext.assets.list(\"\") ?: return"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.lang.String r2 = "silentlog-internal.json"
            boolean r1 = kotlin.collections.ArraysKt___ArraysKt.contains((T[]) r1, r2)
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ Exception -> 0x006a }
            java.io.InputStream r5 = r5.open(r2)     // Catch:{ Exception -> 0x006a }
            com.google.gson.stream.JsonReader r1 = new com.google.gson.stream.JsonReader     // Catch:{ Exception -> 0x005e }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x005e }
            r2.<init>(r5)     // Catch:{ Exception -> 0x005e }
            r1.<init>(r2)     // Catch:{ Exception -> 0x005e }
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ Exception -> 0x005e }
            r2.<init>()     // Catch:{ Exception -> 0x005e }
            java.lang.Class<jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$a> r3 = p043jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation.C1017a.class
            java.lang.Object r1 = r2.fromJson((com.google.gson.stream.JsonReader) r1, (java.lang.reflect.Type) r3)     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = "Gson().fromJson(jsonRead…InternalData::class.java)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)     // Catch:{ Exception -> 0x005e }
            jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation$a r1 = (p043jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation.C1017a) r1     // Catch:{ Exception -> 0x005e }
            boolean r1 = r1.mo21496a()     // Catch:{ Exception -> 0x005e }
            if (r1 == 0) goto L_0x005e
            jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation r1 = new jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation     // Catch:{ Exception -> 0x005e }
            r1.<init>(r4)     // Catch:{ Exception -> 0x005e }
            r1.setListener$silentlogsdkandroid_release(r6)     // Catch:{ Exception -> 0x005e }
            r4.f721a = r1     // Catch:{ Exception -> 0x005e }
            goto L_0x005e
        L_0x005c:
            r6 = move-exception
            goto L_0x0064
        L_0x005e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005c }
            kotlin.p045io.CloseableKt.closeFinally(r5, r0)     // Catch:{ Exception -> 0x006a }
            goto L_0x006a
        L_0x0064:
            throw r6     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r0 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r5, r6)     // Catch:{ Exception -> 0x006a }
            throw r0     // Catch:{ Exception -> 0x006a }
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation.createInternalOperation$silentlogsdkandroid_release(android.content.Context, jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation$SilentLogInternalOperationListener):void");
    }

    public final void createUser(String str, String str2, Integer num, Date date) {
        Integer num2 = num;
        Date date2 = date;
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(str, "username");
        String str4 = str2;
        Intrinsics.checkParameterIsNotNull(str2, "password");
        if (!isLogin$silentlogsdkandroid_release()) {
            RFLAccountManager rFLAccountManager = this.accountManager;
            if (rFLAccountManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            String genderString = rFLAccountManager.getGenderString(num);
            RFLAccountManager rFLAccountManager2 = this.accountManager;
            if (rFLAccountManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            m1396a(this, str, str, str2, genderString, rFLAccountManager2.getBirthdayString(date2), (num2 == null || num.intValue() == 0 || date2 == null) ? false : true, (Map) null, 64, (Object) null);
        }
    }

    public final void enableTransportPrediction$silentlogsdkandroid_release(boolean z) {
        RFLSharedHolder.INSTANCE.setPrediction(z);
    }

    public final void entryCampaignAsync$silentlogsdkandroid_release(int i) {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        rFLAccountManager.setEntryCampaign$silentlogsdkandroid_release(i, new C1052l(this));
    }

    public final void findWeather$silentlogsdkandroid_release(Date date, SilentLogWeatherListener.OnCompletedFind onCompletedFind) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Intrinsics.checkParameterIsNotNull(onCompletedFind, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RFLWeatherManager rFLWeatherManager = this.weatherManager;
        if (rFLWeatherManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherManager");
        }
        rFLWeatherManager.findWeather(date, new C1053m(onCompletedFind));
    }

    public final void forgetPassword$silentlogsdkandroid_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        if (RFLOperationValidator.INSTANCE.isEmailAddress(str)) {
            RFLAccountManager rFLAccountManager = this.accountManager;
            if (rFLAccountManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            rFLAccountManager.forgetPassword(str, new C1054n(this));
            return;
        }
        throw new IllegalArgumentException("param is not mail address.");
    }

    public final RFLAccountManager getAccountManager$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager;
    }

    public final RFLActivityPoiManager getActivityPoiManager$silentlogsdkandroid_release() {
        RFLActivityPoiManager rFLActivityPoiManager = this.activityPoiManager;
        if (rFLActivityPoiManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityPoiManager");
        }
        return rFLActivityPoiManager;
    }

    public final RFLAdManager getAdManager$silentlogsdkandroid_release() {
        RFLAdManager rFLAdManager = this.adManager;
        if (rFLAdManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adManager");
        }
        return rFLAdManager;
    }

    public final RFLAdjustTrackPointManager getAdjustTrackPointManager$silentlogsdkandroid_release() {
        RFLAdjustTrackPointManager rFLAdjustTrackPointManager = this.adjustTrackPointManager;
        if (rFLAdjustTrackPointManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adjustTrackPointManager");
        }
        return rFLAdjustTrackPointManager;
    }

    public final Date getBirthDay$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager.getBirthDay();
    }

    @SuppressLint({"CheckResult"})
    public final void getCampaign$silentlogsdkandroid_release(SilentLogAdListener.OnCompletedGetCampaign onCompletedGetCampaign) {
        Intrinsics.checkParameterIsNotNull(onCompletedGetCampaign, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RFLAdManager rFLAdManager = this.adManager;
        if (rFLAdManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adManager");
        }
        rFLAdManager.getCampaign().mo27429a(C1721a.m2428a()).mo27432a(new C1055o(onCompletedGetCampaign), new C1056p(onCompletedGetCampaign));
    }

    public final RFLDailyLoader getDailyLoader$silentlogsdkandroid_release() {
        RFLDailyLoader rFLDailyLoader = this.dailyLoader;
        if (rFLDailyLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyLoader");
        }
        return rFLDailyLoader;
    }

    public final RFLDailyManager getDailyManager$silentlogsdkandroid_release() {
        RFLDailyManager rFLDailyManager = this.dailyManager;
        if (rFLDailyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
        }
        return rFLDailyManager;
    }

    public final RFLDailyTagManager getDailyTagManager$silentlogsdkandroid_release() {
        RFLDailyTagManager rFLDailyTagManager = this.dailyTagManager;
        if (rFLDailyTagManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyTagManager");
        }
        return rFLDailyTagManager;
    }

    public final RFLDailyUtils getDailyUtils$silentlogsdkandroid_release() {
        RFLDailyUtils rFLDailyUtils = this.dailyUtils;
        if (rFLDailyUtils == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
        }
        return rFLDailyUtils;
    }

    public final RFLDataLogger getDataLogger$silentlogsdkandroid_release() {
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        return rFLDataLogger;
    }

    public final C1714r<Boolean> getDataWithAdjustTrackPoint$silentlogsdkandroid_release(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        RFLDailyManager rFLDailyManager = this.dailyManager;
        if (rFLDailyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
        }
        return rFLDailyManager.loadDailyWithAdjustTrackPoint(date);
    }

    public final int getEntryType$silentlogsdkandroid_release() {
        return RFLSharedHolder.INSTANCE.adEntryType();
    }

    public final C1126c getEventBus$silentlogsdkandroid_release() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        return cVar;
    }

    public final String getExtraUserId$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager.getExtraUserId();
    }

    public final int getGender$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager.getGender();
    }

    public final RFLGoogleFitManager getGoogleFitManager$silentlogsdkandroid_release() {
        RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
        if (rFLGoogleFitManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
        }
        return rFLGoogleFitManager;
    }

    public final RFLH1Client getH1Client$silentlogsdkandroid_release() {
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        return rFLH1Client;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getInstallDate();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Date getInstallDate() {
        /*
            r4 = this;
            jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder r0 = p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder.INSTANCE
            jp.reifrontier.silentlogsdkandroid.domain.api.RFLPrivate r0 = r0.profilePrivateKey()
            java.lang.String r1 = "yyyyMMdd'T'HHmmss'Z'"
            r2 = 0
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.getInstallDate()
            if (r0 == 0) goto L_0x0018
            jp.reifrontier.silentlogsdkandroid.utils.DateEx r3 = p043jp.reifrontier.silentlogsdkandroid.utils.DateEx.INSTANCE
            java.util.Date r0 = r3.parse(r0, r1)
            goto L_0x0019
        L_0x0018:
            r0 = r2
        L_0x0019:
            jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder r3 = p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder.INSTANCE
            jp.reifrontier.silentlogsdkandroid.domain.api.RFLUserProfile r3 = r3.userProfile()
            if (r3 == 0) goto L_0x002d
            java.lang.String r3 = r3.getFirstDate()
            if (r3 == 0) goto L_0x002d
            jp.reifrontier.silentlogsdkandroid.utils.DateEx r2 = p043jp.reifrontier.silentlogsdkandroid.utils.DateEx.INSTANCE
            java.util.Date r2 = r2.parse(r3, r1)
        L_0x002d:
            if (r0 == 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r0 = r2
        L_0x0031:
            if (r0 == 0) goto L_0x0034
            goto L_0x0039
        L_0x0034:
            java.util.Date r0 = new java.util.Date
            r0.<init>()
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation.getInstallDate():java.util.Date");
    }

    public final SilentLogInternalOperation getInternalOperation() {
        return this.f721a;
    }

    public final SilentLogInternalOperation.SilentLogInternalOperationListener getInternalOperationListener() {
        return this.f722b;
    }

    public final List<String> getJrForms$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager.getJrForms$silentlogsdkandroid_release();
    }

    public final RFLLocationManager getLocationManager$silentlogsdkandroid_release() {
        RFLLocationManager rFLLocationManager = this.locationManager;
        if (rFLLocationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        return rFLLocationManager;
    }

    public final RFLOrmaHolder getOrmaHolder() {
        RFLOrmaHolder rFLOrmaHolder = this.ormaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ormaHolder");
        }
        return rFLOrmaHolder;
    }

    public final RFLPointClient getPointClient$silentlogsdkandroid_release() {
        RFLPointClient rFLPointClient = this.pointClient;
        if (rFLPointClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointClient");
        }
        return rFLPointClient;
    }

    public final String getSilentLogUserId$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager.getSilentLogUserId();
    }

    public final void getTodayStepCountByGoogleFit$silentlogsdkandroid_release(SilentLogOperation.SilentLogStepsListener silentLogStepsListener) {
        Intrinsics.checkParameterIsNotNull(silentLogStepsListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
        if (rFLGoogleFitManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
        }
        rFLGoogleFitManager.getTodayStepCount(new C1057q(this, silentLogStepsListener));
    }

    public final RFLWeatherClient getWeatherClient$silentlogsdkandroid_release() {
        RFLWeatherClient rFLWeatherClient = this.weatherClient;
        if (rFLWeatherClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherClient");
        }
        return rFLWeatherClient;
    }

    public final RFLWeatherManager getWeatherManager$silentlogsdkandroid_release() {
        RFLWeatherManager rFLWeatherManager = this.weatherManager;
        if (rFLWeatherManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherManager");
        }
        return rFLWeatherManager;
    }

    public final boolean hasAuth$silentlogsdkandroid_release() {
        return RFLSharedHolder.INSTANCE.grant();
    }

    public final boolean isEnableTwoWeekSetting() {
        return RFLSharedHolder.INSTANCE.isEnableTwoWeekSetting();
    }

    public final boolean isEntryCampaign$silentlogsdkandroid_release() {
        return RFLSharedHolder.INSTANCE.adEntryType() > 0;
    }

    public final boolean isLogin$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager.isLogin();
    }

    public final boolean isMilePointAuth$silentlogsdkandroid_release() {
        return RFLSharedHolder.INSTANCE.isMilePointAuth();
    }

    public final boolean isRegistLogin$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager.isRegistLogin();
    }

    public final boolean isValidPassword$silentlogsdkandroid_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "password");
        String password = RFLSharedHolder.INSTANCE.password();
        if (!Intrinsics.areEqual((Object) password, (Object) "")) {
            return Intrinsics.areEqual((Object) str, (Object) password);
        }
        return false;
    }

    public final C1714r<String> loadDailyFromDate$silentlogsdkandroid_release(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        RFLDailyManager rFLDailyManager = this.dailyManager;
        if (rFLDailyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
        }
        return rFLDailyManager.loadDaily(date);
    }

    public final C1714r<Boolean> loadDailyWithTag$silentlogsdkandroid_release(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        RFLDailyManager rFLDailyManager = this.dailyManager;
        if (rFLDailyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
        }
        return rFLDailyManager.loadDailyWithTag(date);
    }

    public final Location loadLocation$silentlogsdkandroid_release() {
        RFLLocationManager rFLLocationManager = this.locationManager;
        if (rFLLocationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        return rFLLocationManager.getCurrentLocation$silentlogsdkandroid_release();
    }

    public final void loadUserProfileIfNeed$silentlogsdkandroid_release(boolean z) {
        if (RFLSharedHolder.INSTANCE.profilePrivateKey() == null || z) {
            RFLAccountManager rFLAccountManager = this.accountManager;
            if (rFLAccountManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            rFLAccountManager.loadUserProfile(new C1058r(this));
            return;
        }
        SilentLogOperation.SilentLogOperationListener silentLogOperationListener = this.f727g;
        if (silentLogOperationListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operationListener");
        }
        silentLogOperationListener.resultForLoadUserProfile(true);
    }

    @SuppressLint({"CheckResult"})
    public final void logoutApi$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        rFLAccountManager.logout().mo27429a(C1721a.m2428a()).mo27432a(new C1061u(this), new C1062v(this));
    }

    @C1129m(threadMode = ThreadMode.MAIN)
    public final void onReceiveInvalidToken(InvalidToken invalidToken) {
        Intrinsics.checkParameterIsNotNull(invalidToken, "invalidToken");
        if (!this.f728h) {
            this.f728h = true;
            m1403e();
        }
    }

    public final void onStart$silentlogsdkandroid_release() {
        if (RFLSharedHolder.INSTANCE.tracking()) {
            RFLLocationManager rFLLocationManager = this.locationManager;
            if (rFLLocationManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationManager");
            }
            rFLLocationManager.start();
        }
    }

    public final void permissionResult$silentlogsdkandroid_release(int i, int i2) {
        if (i == SilentLogOperation.Companion.getInstance().getSILENT_LOG_SDK_GPS_PERMISSION() && i2 == 0) {
            boolean hasAuth$silentlogsdkandroid_release = hasAuth$silentlogsdkandroid_release();
            RFLLocationManager rFLLocationManager = this.locationManager;
            if (rFLLocationManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationManager");
            }
            rFLLocationManager.grantLocation();
            if (!hasAuth$silentlogsdkandroid_release) {
                m1405g();
            }
        }
    }

    public final void registerRemoteToken$silentlogsdkandroid_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tokenString");
        if (RFLOperationValidator.INSTANCE.isGcmToken(str)) {
            RFLSharedHolder.INSTANCE.setTempPushToken(str);
            RFLAccountManager rFLAccountManager = this.accountManager;
            if (rFLAccountManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountManager");
            }
            rFLAccountManager.syncPushToken();
            return;
        }
        throw new IllegalArgumentException("param is not token.");
    }

    public final C1714r<SilentLogOperation.LogoutResult> release$silentlogsdkandroid_release() {
        stopTracking$silentlogsdkandroid_release();
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        C1714r<R> b = rFLAccountManager.logout().mo27435b(new C1063w(this));
        Intrinsics.checkExpressionValueIsNotNull(b, "accountManager.logout()\n…      }\n                }");
        return b;
    }

    public final C1696b releaseWithoutLogout$silentlogsdkandroid_release() {
        stopTracking$silentlogsdkandroid_release();
        C1696b a = C1696b.m2386a((C1699e) new C1064x(this)).mo27420a(C1683a.m2378b());
        Intrinsics.checkExpressionValueIsNotNull(a, "Completable.create {\n   …scribeOn(Schedulers.io())");
        return a;
    }

    public final void removeDailyTag(Date date, List<String> list, SilentLogDailyTagListener silentLogDailyTagListener) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(list, "dailyTags");
        RFLDailyTagManager rFLDailyTagManager = this.dailyTagManager;
        if (rFLDailyTagManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyTagManager");
        }
        rFLDailyTagManager.removeDailyTagAsync(date, list, new C1065y(silentLogDailyTagListener));
    }

    public final void replaceDailyTag(Date date, List<Pair<String, String>> list, SilentLogDailyTagListener silentLogDailyTagListener) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(list, "dailyTags");
        RFLDailyTagManager rFLDailyTagManager = this.dailyTagManager;
        if (rFLDailyTagManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyTagManager");
        }
        rFLDailyTagManager.replaceDailyTagAsync(date, list, new C1066z(silentLogDailyTagListener));
    }

    @SuppressLint({"CheckResult"})
    public final void responseAd$silentlogsdkandroid_release(int i, RFLAdResType rFLAdResType, SilentLogAdListener.OnCompletedResponseAd onCompletedResponseAd) {
        Intrinsics.checkParameterIsNotNull(rFLAdResType, "responseType");
        Intrinsics.checkParameterIsNotNull(onCompletedResponseAd, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RFLLocationManager rFLLocationManager = this.locationManager;
        if (rFLLocationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        rFLLocationManager.responseAd(i, rFLAdResType).mo27429a(C1721a.m2428a()).mo27432a(new C1018a0(onCompletedResponseAd, rFLAdResType, i), new C1020b0(onCompletedResponseAd, rFLAdResType, i));
    }

    public final C1696b saveActivityAdjustTrackPoint$silentlogsdkandroid_release(List<RFLTrackPoint> list, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(list, "adjustTrackPoints");
        RFLAdjustTrackPointManager rFLAdjustTrackPointManager = this.adjustTrackPointManager;
        if (rFLAdjustTrackPointManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adjustTrackPointManager");
        }
        return rFLAdjustTrackPointManager.replace(list, i, i2);
    }

    public final C1696b saveActivityPoi$silentlogsdkandroid_release(List<RFLActivityPoi> list, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(list, "poiList");
        RFLActivityPoiManager rFLActivityPoiManager = this.activityPoiManager;
        if (rFLActivityPoiManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityPoiManager");
        }
        return rFLActivityPoiManager.replace(list, i, i2, z);
    }

    public final void saveActivityTag$silentlogsdkandroid_release(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "activityTag");
        RFLTag rFLTag = new RFLTag(str, "custom", "json", (RFLPredict) null, (RFLActivityPoi) null);
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        rFLDataLogger.insertTag(rFLTag, i, i2).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27431a();
    }

    public final void saveDailyNote(Date date, String str) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(str, "dailyNote");
        RFLDailyManager rFLDailyManager = this.dailyManager;
        if (rFLDailyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
        }
        rFLDailyManager.updateDailyNote(date, str);
    }

    public final void savePointSystemKey$silentlogsdkandroid_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pointSystemKey");
        if (RFLOperationValidator.INSTANCE.isPointSystemKey(str)) {
            RFLSharedHolder.INSTANCE.setPointSystemKey(str);
            return;
        }
        throw new IllegalArgumentException("param is not point-system-key");
    }

    public final void saveSl2Id$silentlogsdkandroid_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "sl2Id");
        if (RFLOperationValidator.INSTANCE.isSl2Id(str)) {
            RFLSharedHolder.INSTANCE.setSl2Id(str);
            return;
        }
        throw new IllegalArgumentException("param is not sl2-id");
    }

    public final void setAccountManager$silentlogsdkandroid_release(RFLAccountManager rFLAccountManager) {
        Intrinsics.checkParameterIsNotNull(rFLAccountManager, "<set-?>");
        this.accountManager = rFLAccountManager;
    }

    public final void setActivityPoiManager$silentlogsdkandroid_release(RFLActivityPoiManager rFLActivityPoiManager) {
        Intrinsics.checkParameterIsNotNull(rFLActivityPoiManager, "<set-?>");
        this.activityPoiManager = rFLActivityPoiManager;
    }

    public final void setAdManager$silentlogsdkandroid_release(RFLAdManager rFLAdManager) {
        Intrinsics.checkParameterIsNotNull(rFLAdManager, "<set-?>");
        this.adManager = rFLAdManager;
    }

    public final void setAdjustTrackPointManager$silentlogsdkandroid_release(RFLAdjustTrackPointManager rFLAdjustTrackPointManager) {
        Intrinsics.checkParameterIsNotNull(rFLAdjustTrackPointManager, "<set-?>");
        this.adjustTrackPointManager = rFLAdjustTrackPointManager;
    }

    public final void setAltitudePrediction(boolean z) {
        RFLSharedHolder.INSTANCE.setAltitudePrediction(z);
    }

    public final void setBaseUrl$silentlogsdkandroid_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "baseUrl");
        if (RFLOperationValidator.INSTANCE.isUrl(str)) {
            RFLSharedHolder.INSTANCE.setBaseUrl(str);
            return;
        }
        throw new IllegalArgumentException("param is not url.");
    }

    public final void setDailyLoader$silentlogsdkandroid_release(RFLDailyLoader rFLDailyLoader) {
        Intrinsics.checkParameterIsNotNull(rFLDailyLoader, "<set-?>");
        this.dailyLoader = rFLDailyLoader;
    }

    public final void setDailyManager$silentlogsdkandroid_release(RFLDailyManager rFLDailyManager) {
        Intrinsics.checkParameterIsNotNull(rFLDailyManager, "<set-?>");
        this.dailyManager = rFLDailyManager;
    }

    public final void setDailyTagManager$silentlogsdkandroid_release(RFLDailyTagManager rFLDailyTagManager) {
        Intrinsics.checkParameterIsNotNull(rFLDailyTagManager, "<set-?>");
        this.dailyTagManager = rFLDailyTagManager;
    }

    public final void setDailyUtils$silentlogsdkandroid_release(RFLDailyUtils rFLDailyUtils) {
        Intrinsics.checkParameterIsNotNull(rFLDailyUtils, "<set-?>");
        this.dailyUtils = rFLDailyUtils;
    }

    public final void setDataLogger$silentlogsdkandroid_release(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "<set-?>");
        this.dataLogger = rFLDataLogger;
    }

    @SuppressLint({"CheckResult"})
    public final void setEnableTwoWeekSetting(boolean z, SilentLogTwoWeekSettingListener silentLogTwoWeekSettingListener) {
        Intrinsics.checkParameterIsNotNull(silentLogTwoWeekSettingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (isEnableTwoWeekSetting() == z) {
            silentLogTwoWeekSettingListener.onCompleted(true);
            return;
        }
        RFLSharedHolder.INSTANCE.setEnableTwoWeekSetting(z);
        Pair<String, String> a = m1392a();
        String component1 = a.component1();
        String component2 = a.component2();
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        rFLAccountManager.logout().mo27430a(new C1024d0(this, component1, component2)).mo27434b(C1683a.m2378b()).mo27432a(new C1027e0(this, silentLogTwoWeekSettingListener, component1, component2, z), new C1035f0(silentLogTwoWeekSettingListener));
    }

    public final void setEventBus$silentlogsdkandroid_release(C1126c cVar) {
        Intrinsics.checkParameterIsNotNull(cVar, "<set-?>");
        this.eventBus = cVar;
    }

    public final void setGoogleFitManager$silentlogsdkandroid_release(RFLGoogleFitManager rFLGoogleFitManager) {
        Intrinsics.checkParameterIsNotNull(rFLGoogleFitManager, "<set-?>");
        this.googleFitManager = rFLGoogleFitManager;
    }

    public final void setH1Client$silentlogsdkandroid_release(RFLH1Client rFLH1Client) {
        Intrinsics.checkParameterIsNotNull(rFLH1Client, "<set-?>");
        this.h1Client = rFLH1Client;
    }

    public final void setInternalOperation(SilentLogInternalOperation silentLogInternalOperation) {
        this.f721a = silentLogInternalOperation;
    }

    public final void setInternalOperationListener(SilentLogInternalOperation.SilentLogInternalOperationListener silentLogInternalOperationListener) {
        this.f722b = silentLogInternalOperationListener;
    }

    public final void setJapanOnly(boolean z) {
        RFLSharedHolder.INSTANCE.setLocationJapanOnly(z);
    }

    public final void setLocationManager$silentlogsdkandroid_release(RFLLocationManager rFLLocationManager) {
        Intrinsics.checkParameterIsNotNull(rFLLocationManager, "<set-?>");
        this.locationManager = rFLLocationManager;
    }

    public final void setOrmaHolder(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "<set-?>");
        this.ormaHolder = rFLOrmaHolder;
    }

    public final void setPointClient$silentlogsdkandroid_release(RFLPointClient rFLPointClient) {
        Intrinsics.checkParameterIsNotNull(rFLPointClient, "<set-?>");
        this.pointClient = rFLPointClient;
    }

    public final void setPointUrl$silentlogsdkandroid_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pointUrl");
        if (RFLOperationValidator.INSTANCE.isUrl(str)) {
            RFLSharedHolder.INSTANCE.setPointUrl(str);
            return;
        }
        throw new IllegalArgumentException("param is not url.");
    }

    public final void setSendPushToken$silentlogsdkandroid_release(boolean z) {
        RFLSharedHolder.INSTANCE.setSendPushToken(z);
    }

    public final void setServiceName$silentlogsdkandroid_release(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(str2, "geofence");
        Intrinsics.checkParameterIsNotNull(str3, "foreground");
        if (!RFLOperationValidator.INSTANCE.isPackageName(str) || !RFLOperationValidator.INSTANCE.isPackageName(str2) || !RFLOperationValidator.INSTANCE.isPackageName(str3)) {
            throw new IllegalArgumentException("any params is not package-name.");
        }
        RFLSharedHolder.INSTANCE.setServiceName(str);
        RFLSharedHolder.INSTANCE.setGeoFenceName(str2);
        RFLSharedHolder.INSTANCE.setForegroundName(str3);
        if (RFLSharedHolder.INSTANCE.tracking()) {
            m1405g();
        }
    }

    public final void setStepPerMinutesPriority$silentlogsdkandroid_release(boolean z) {
        RFLDailyLoader rFLDailyLoader = this.dailyLoader;
        if (rFLDailyLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyLoader");
        }
        rFLDailyLoader.setUseSdkStepPerMinutes(z);
    }

    public final void setTrackingPriorityType$silentlogsdkandroid_release(int i) {
        RFLSharedHolder.INSTANCE.setPriorityType(i);
    }

    public final void setUseAdvertisingId$silentlogsdkandroid_release(boolean z) {
        RFLSharedHolder.INSTANCE.setUseAdvertisingId(z);
    }

    public final void setWeatherClient$silentlogsdkandroid_release(RFLWeatherClient rFLWeatherClient) {
        Intrinsics.checkParameterIsNotNull(rFLWeatherClient, "<set-?>");
        this.weatherClient = rFLWeatherClient;
    }

    public final void setWeatherManager$silentlogsdkandroid_release(RFLWeatherManager rFLWeatherManager) {
        Intrinsics.checkParameterIsNotNull(rFLWeatherManager, "<set-?>");
        this.weatherManager = rFLWeatherManager;
    }

    public final boolean shouldLoadUserProfile$silentlogsdkandroid_release() {
        return RFLSharedHolder.INSTANCE.profilePrivateKey() == null;
    }

    public final void startFromService$silentlogsdkandroid_release(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        if (!this.f723c) {
            String stringExtra = intent.getStringExtra("kRFL_TRIGGER");
            if (stringExtra != null && stringExtra.length() > 3) {
                String substring = stringExtra.substring(0, 3);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (Intrinsics.areEqual((Object) substring, (Object) "eve")) {
                    List split$default = StringsKt__StringsKt.split$default((CharSequence) stringExtra, new String[]{"-e!!e-"}, false, 0, 6, (Object) null);
                    if (split$default.size() == 2) {
                        C1122a.m1600c("[SilentLogSDK] Info::Start Event::From %s", split$default.get(0));
                        m1393a(Integer.parseInt((String) split$default.get(1)));
                        return;
                    }
                    return;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f729i > 5000) {
                C1122a.m1600c(C0681a.m320a("[SilentLogSDK] Info::Restart Operation::From ", stringExtra), new Object[0]);
                this.f729i = currentTimeMillis;
                m1404f();
                return;
            }
            C1122a.m1600c(C0681a.m320a("[SilentLogSDK] Info::Ignore Operation::From ", stringExtra), new Object[0]);
        }
    }

    public final void startGeofence$silentlogsdkandroid_release(List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        if (RFLOperationValidator.INSTANCE.isCustomGeofenceParams(list)) {
            RFLLocationManager rFLLocationManager = this.locationManager;
            if (rFLLocationManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationManager");
            }
            rFLLocationManager.startGeofenceFromClient(list);
            return;
        }
        throw new IllegalArgumentException("list is not geofence params");
    }

    public final void startTracking$silentlogsdkandroid_release() {
        if (!RFLSharedHolder.INSTANCE.tracking()) {
            RFLSharedHolder.INSTANCE.setTracking(true);
            if (!this.f723c) {
                RFLDailyManager rFLDailyManager = this.dailyManager;
                if (rFLDailyManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
                }
                Context context = this.f724d;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clientContext");
                }
                SilentLogOperation.SilentLogOperationListener silentLogOperationListener = this.f727g;
                if (silentLogOperationListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("operationListener");
                }
                rFLDailyManager.build(context, silentLogOperationListener);
                RFLLocationManager rFLLocationManager = this.locationManager;
                if (rFLLocationManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationManager");
                }
                rFLLocationManager.start();
                RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
                if (rFLGoogleFitManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
                }
                rFLGoogleFitManager.connect();
                m1405g();
            }
        }
    }

    public final void stopGeofence$silentlogsdkandroid_release() {
        RFLLocationManager rFLLocationManager = this.locationManager;
        if (rFLLocationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        rFLLocationManager.stopGeofenceFromClient();
    }

    public final void stopTracking$silentlogsdkandroid_release() {
        if (RFLSharedHolder.INSTANCE.tracking()) {
            RFLSharedHolder.INSTANCE.setTracking(false);
            if (!this.f723c) {
                m1406h();
                RFLDailyManager rFLDailyManager = this.dailyManager;
                if (rFLDailyManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
                }
                rFLDailyManager.release();
                RFLLocationManager rFLLocationManager = this.locationManager;
                if (rFLLocationManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationManager");
                }
                rFLLocationManager.stop();
                RFLGoogleFitManager rFLGoogleFitManager = this.googleFitManager;
                if (rFLGoogleFitManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("googleFitManager");
                }
                rFLGoogleFitManager.disconnect();
            }
        }
    }

    public final void updateBirthday$silentlogsdkandroid_release(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "birthday");
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        rFLAccountManager.updateBirthday(date, new C1040h0(this));
    }

    public final void updateGender$silentlogsdkandroid_release(int i) {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        rFLAccountManager.updateGender(i, new C1042i0(this));
    }

    @SuppressLint({"CheckResult"})
    public final void updatePassword$silentlogsdkandroid_release(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "password");
        Intrinsics.checkParameterIsNotNull(str2, "email");
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.postProfile(str).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1046j0(this, str2, str), new C1051k0(this));
    }

    public final void uploadForceTest$silentlogsdkandroid_release() {
        RFLDailyManager rFLDailyManager = this.dailyManager;
        if (rFLDailyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyManager");
        }
        rFLDailyManager.forceCreateDaily();
    }

    public final void writeLog$silentlogsdkandroid_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        if (RFLOperationValidator.INSTANCE.isWriteLog(str)) {
            C1122a.m1600c(":::%s", str);
            return;
        }
        throw new IllegalArgumentException("message is not log.");
    }
}
