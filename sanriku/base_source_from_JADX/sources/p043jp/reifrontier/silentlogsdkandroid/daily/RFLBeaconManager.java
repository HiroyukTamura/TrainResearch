package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.content.Context;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\bH&R5\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManager;", "", "onEnterAdTrigger", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "triggerId", "", "getOnEnterAdTrigger", "()Lkotlin/jvm/functions/Function1;", "setOnEnterAdTrigger", "(Lkotlin/jvm/functions/Function1;)V", "hasBluetoothPermission", "", "context", "Landroid/content/Context;", "parseIBeaconUUID", "", "data", "", "startMonitoring", "adTrigger", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrigger;", "stopAllMonitoring", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManager */
public interface RFLBeaconManager {

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManager$DefaultImpls */
    public static final class DefaultImpls {
        public static boolean hasBluetoothPermission(RFLBeaconManager rFLBeaconManager, Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            return ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_ADMIN") == 0;
        }

        public static String parseIBeaconUUID(RFLBeaconManager rFLBeaconManager, byte[] bArr) {
            if (bArr == null || bArr.length < 27) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[6])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            stringBuffer.append(format);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[7])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
            stringBuffer.append(format2);
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[8])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format3, "java.lang.String.format(format, *args)");
            stringBuffer.append(format3);
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String format4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[9])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format4, "java.lang.String.format(format, *args)");
            stringBuffer.append(format4);
            stringBuffer.append("-");
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            String format5 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[10])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format5, "java.lang.String.format(format, *args)");
            stringBuffer.append(format5);
            StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
            String format6 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[11])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format6, "java.lang.String.format(format, *args)");
            stringBuffer.append(format6);
            stringBuffer.append("-");
            StringCompanionObject stringCompanionObject7 = StringCompanionObject.INSTANCE;
            String format7 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[12])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format7, "java.lang.String.format(format, *args)");
            stringBuffer.append(format7);
            StringCompanionObject stringCompanionObject8 = StringCompanionObject.INSTANCE;
            String format8 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[13])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format8, "java.lang.String.format(format, *args)");
            stringBuffer.append(format8);
            stringBuffer.append("-");
            StringCompanionObject stringCompanionObject9 = StringCompanionObject.INSTANCE;
            String format9 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[14])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format9, "java.lang.String.format(format, *args)");
            stringBuffer.append(format9);
            StringCompanionObject stringCompanionObject10 = StringCompanionObject.INSTANCE;
            String format10 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[15])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format10, "java.lang.String.format(format, *args)");
            stringBuffer.append(format10);
            stringBuffer.append("-");
            StringCompanionObject stringCompanionObject11 = StringCompanionObject.INSTANCE;
            String format11 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[16])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format11, "java.lang.String.format(format, *args)");
            stringBuffer.append(format11);
            StringCompanionObject stringCompanionObject12 = StringCompanionObject.INSTANCE;
            String format12 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[17])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format12, "java.lang.String.format(format, *args)");
            stringBuffer.append(format12);
            StringCompanionObject stringCompanionObject13 = StringCompanionObject.INSTANCE;
            String format13 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[18])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format13, "java.lang.String.format(format, *args)");
            stringBuffer.append(format13);
            StringCompanionObject stringCompanionObject14 = StringCompanionObject.INSTANCE;
            String format14 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[19])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format14, "java.lang.String.format(format, *args)");
            stringBuffer.append(format14);
            StringCompanionObject stringCompanionObject15 = StringCompanionObject.INSTANCE;
            String format15 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[20])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format15, "java.lang.String.format(format, *args)");
            stringBuffer.append(format15);
            StringCompanionObject stringCompanionObject16 = StringCompanionObject.INSTANCE;
            String format16 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[21])}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format16, "java.lang.String.format(format, *args)");
            stringBuffer.append(format16);
            return stringBuffer.toString();
        }
    }

    Function1<Integer, Unit> getOnEnterAdTrigger();

    boolean hasBluetoothPermission(Context context);

    String parseIBeaconUUID(byte[] bArr);

    void setOnEnterAdTrigger(Function1<? super Integer, Unit> function1);

    void startMonitoring(RFLAdTrigger rFLAdTrigger);

    void stopAllMonitoring();
}
