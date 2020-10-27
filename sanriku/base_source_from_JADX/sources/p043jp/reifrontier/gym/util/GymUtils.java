package p043jp.reifrontier.gym.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J9\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u0010&J(\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020-H\u0002J\u000e\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004J\u0010\u00102\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u00103\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0004J(\u00107\u001a\u0004\u0018\u0001082\u0006\u0010!\u001a\u00020\"2\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rJ \u0010;\u001a\u0004\u0018\u0001082\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u0018J\u000e\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0004J\u000e\u0010B\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006C"}, mo21739d2 = {"Ljp/reifrontier/gym/util/GymUtils;", "", "()V", "GOOGLE_FIT_PACKAGE_NAME", "", "PATTERN_EMAIL", "PATTERN_PASSWORD", "PATTERN_PHONE", "PATTERN_POST", "PATTERN_SURVEY", "checkPlayServices", "", "context", "Landroid/content/Context;", "createImageFile", "Ljava/io/File;", "distance", "", "fLat", "", "fLng", "tLat", "tLng", "findBestSampleSize", "", "actualWidth", "actualHeight", "desiredWidth", "desiredHeight", "genderFrom", "type", "genderTo", "getDataColumn", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getResizedDimension", "maxPrimary", "maxSecondary", "actualPrimary", "actualSecondary", "getRotatedMatrix", "Landroid/graphics/Matrix;", "filePath", "matrix", "imageUrl", "path", "isDownloadsDocument", "isMediaDocument", "isNotBlank", "string", "isSurvey", "resize", "Landroid/graphics/Bitmap;", "mMaxWidth", "mMaxHeight", "resizeBitmap", "size", "validateEmail", "email", "validatePassword", "validatePhone", "validatePost", "validateUsername", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.util.GymUtils */
public final class GymUtils {
    public static final String GOOGLE_FIT_PACKAGE_NAME = "com.google.android.apps.fitness";
    public static final GymUtils INSTANCE = new GymUtils();
    private static final String PATTERN_EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)+$";
    private static final String PATTERN_PASSWORD = "^[a-zA-Z\\d]{8,30}$";
    private static final String PATTERN_PHONE = "^0[0-9]{1,4}-[0-9]{1,4}-[0-9]{4}$";
    private static final String PATTERN_POST = "^[0-9]{3}-[0-9]{4}$";
    private static final String PATTERN_SURVEY = "^https://jp.surveymonkey[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+[?]userid=";

    private GymUtils() {
    }

    private final int findBestSampleSize(int i, int i2, int i3, int i4) {
        double d = (double) i;
        double d2 = (double) i3;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = (double) i2;
        double d4 = (double) i4;
        Double.isNaN(d3);
        Double.isNaN(d4);
        double min = Math.min(d / d2, d3 / d4);
        float f = 1.0f;
        while (((double) (((float) 2) * f)) <= min) {
            f *= 2.0f;
        }
        return (int) f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getDataColumn(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) {
        /*
            r8 = this;
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch:{ all -> 0x0031 }
            r6 = 0
            r2 = r10
            r4 = r11
            r5 = r12
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0031 }
            if (r9 == 0) goto L_0x002b
            boolean r10 = r9.moveToFirst()     // Catch:{ all -> 0x0028 }
            r11 = 1
            if (r10 != r11) goto L_0x002b
            int r10 = r9.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ all -> 0x0028 }
            r9.close()
            return r10
        L_0x0028:
            r10 = move-exception
            r7 = r9
            goto L_0x0032
        L_0x002b:
            if (r9 == 0) goto L_0x0030
            r9.close()
        L_0x0030:
            return r7
        L_0x0031:
            r10 = move-exception
        L_0x0032:
            if (r7 == 0) goto L_0x0037
            r7.close()
        L_0x0037:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.util.GymUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    private final int getResizedDimension(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            double d = (double) i2;
            double d2 = (double) i4;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = (double) i3;
            Double.isNaN(d3);
            return (int) (d3 * (d / d2));
        } else if (i2 == 0) {
            return i;
        } else {
            double d4 = (double) i4;
            double d5 = (double) i3;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = d4 / d5;
            double d7 = (double) i;
            Double.isNaN(d7);
            double d8 = (double) i2;
            if (d7 * d6 >= d8) {
                return i;
            }
            Double.isNaN(d8);
            return (int) (d8 / d6);
        }
    }

    private final Matrix getRotatedMatrix(String str, Matrix matrix) {
        try {
            switch (new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0)) {
                case 2:
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 3:
                    matrix.postRotate(180.0f);
                    break;
                case 4:
                    break;
                case 5:
                    matrix.postRotate(90.0f);
                    break;
                case 6:
                    matrix.postRotate(90.0f);
                    break;
                case 7:
                    matrix.postRotate(-90.0f);
                    break;
                case 8:
                    matrix.postRotate(-90.0f);
                    break;
            }
            matrix.postScale(1.0f, -1.0f);
            return matrix;
        } catch (IOException e) {
            e.printStackTrace();
            return matrix;
        }
    }

    private final boolean isDownloadsDocument(Uri uri) {
        return Intrinsics.areEqual((Object) "com.android.providers.downloads.documents", (Object) uri.getAuthority());
    }

    private final boolean isMediaDocument(Uri uri) {
        return Intrinsics.areEqual((Object) "com.android.providers.media.documents", (Object) uri.getAuthority());
    }

    public final boolean checkPlayServices(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
    }

    public final File createImageFile(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String a = C0681a.m321a("JPEG_", new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()), "_");
        File dir = context.getDir("cache", 0);
        Intrinsics.checkExpressionValueIsNotNull(dir, "context.getDir(\"cache\", Context.MODE_PRIVATE)");
        File file = new File(C0681a.m320a(dir.getAbsolutePath(), "/Img"));
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            return File.createTempFile(a, ".jpg", file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final float distance(double d, double d2, double d3, double d4) {
        Location location = new Location("gym_android");
        location.setLatitude(d);
        location.setLongitude(d2);
        Location location2 = new Location("gym_android");
        location2.setLatitude(d3);
        location2.setLongitude(d4);
        return location.distanceTo(location2);
    }

    public final String genderFrom(String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        return Intrinsics.areEqual((Object) str, (Object) RFLAccountManager.DEFAULT_GENDER) ? "男性" : "女性";
    }

    public final String genderTo(String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        return Intrinsics.areEqual((Object) str, (Object) "男性") ? RFLAccountManager.DEFAULT_GENDER : "female";
    }

    public final String imageUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        return "https://s3-ap-northeast-1.amazonaws.com/h2.analytics.development/users/" + str;
    }

    public final boolean isNotBlank(String str) {
        Intrinsics.checkParameterIsNotNull(str, "string");
        return !StringsKt__StringsJVMKt.isBlank(str);
    }

    public final boolean isSurvey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "string");
        return Pattern.compile(PATTERN_SURVEY).matcher(str).find();
    }

    public final Bitmap resize(Uri uri, int i, int i2, Context context) throws IOException {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(context, "context");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
        boolean z = false;
        boolean z2 = openInputStream != null;
        if (!_Assertions.ENABLED || z2) {
            if (openInputStream == null) {
                Intrinsics.throwNpe();
            }
            openInputStream.close();
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            int resizedDimension = getResizedDimension(i, i2, i3, i4);
            int resizedDimension2 = getResizedDimension(i2, i, i4, i3);
            options.inJustDecodeBounds = false;
            options.inSampleSize = findBestSampleSize(i3, i4, resizedDimension, resizedDimension2);
            InputStream openInputStream2 = context.getContentResolver().openInputStream(uri);
            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, (Rect) null, options);
            if (openInputStream2 != null) {
                z = true;
            }
            if (!_Assertions.ENABLED || z) {
                if (openInputStream2 == null) {
                    Intrinsics.throwNpe();
                }
                openInputStream2.close();
                if (decodeStream == null) {
                    return decodeStream;
                }
                if (decodeStream.getWidth() <= resizedDimension && decodeStream.getHeight() <= resizedDimension2) {
                    return decodeStream;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, resizedDimension, resizedDimension2, true);
                decodeStream.recycle();
                return createScaledBitmap;
            }
            throw new AssertionError("Assertion failed");
        }
        throw new AssertionError("Assertion failed");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0102, code lost:
        if (r5 == null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013b, code lost:
        if (r5 == null) goto L_0x0104;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap resizeBitmap(android.content.Context r21, android.net.Uri r22, int r23) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            r4 = 0
            android.content.ContentResolver r0 = r21.getContentResolver()     // Catch:{ FileNotFoundException -> 0x001b }
            java.io.InputStream r0 = r0.openInputStream(r3)     // Catch:{ FileNotFoundException -> 0x001b }
            r5 = r0
            goto L_0x0020
        L_0x001b:
            r0 = move-exception
            r0.printStackTrace()
            r5 = r4
        L_0x0020:
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options
            r6.<init>()
            r7 = 1
            r6.inJustDecodeBounds = r7
            android.graphics.BitmapFactory.decodeStream(r5, r4, r6)
            if (r5 != 0) goto L_0x0030
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ IOException -> 0x0034 }
        L_0x0030:
            r5.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0038:
            android.content.ContentResolver r0 = r21.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0041 }
            java.io.InputStream r5 = r0.openInputStream(r3)     // Catch:{ FileNotFoundException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0045:
            int r0 = r6.outWidth
            float r0 = (float) r0
            r8 = r23
            float r8 = (float) r8
            float r0 = r0 / r8
            int r6 = r6.outHeight
            float r6 = (float) r6
            float r6 = r6 / r8
            r8 = 2
            float r9 = (float) r8
            int r10 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x0077
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 <= 0) goto L_0x0077
            android.graphics.BitmapFactory$Options r9 = new android.graphics.BitmapFactory$Options
            r9.<init>()
            int r10 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r10 <= 0) goto L_0x0064
            r0 = r6
        L_0x0064:
            double r10 = (double) r0
            double r10 = java.lang.Math.floor(r10)
            int r0 = (int) r10
            r6 = 2
        L_0x006b:
            if (r6 > r0) goto L_0x0072
            r9.inSampleSize = r6
            int r6 = r6 * 2
            goto L_0x006b
        L_0x0072:
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r5, r4, r9)
            goto L_0x007b
        L_0x0077:
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r5)
        L_0x007b:
            r9 = r0
            if (r5 != 0) goto L_0x0081
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ IOException -> 0x0085 }
        L_0x0081:
            r5.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0089:
            if (r9 == 0) goto L_0x01de
            int r13 = r9.getHeight()
            int r12 = r9.getWidth()
            boolean r0 = r1.isMediaDocument(r3)
            java.lang.String r5 = ""
            if (r0 == 0) goto L_0x0111
            java.lang.String r0 = android.provider.DocumentsContract.getDocumentId(r22)
            java.lang.String r3 = "strDocId"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            kotlin.text.Regex r3 = new kotlin.text.Regex
            java.lang.String r4 = ":"
            r3.<init>((java.lang.String) r4)
            r4 = 0
            java.util.List r0 = r3.split(r0, r4)
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x00df
            int r3 = r0.size()
            java.util.ListIterator r3 = r0.listIterator(r3)
        L_0x00be:
            boolean r5 = r3.hasPrevious()
            if (r5 == 0) goto L_0x00df
            java.lang.Object r5 = r3.previous()
            java.lang.String r5 = (java.lang.String) r5
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00d2
            r5 = 1
            goto L_0x00d3
        L_0x00d2:
            r5 = 0
        L_0x00d3:
            if (r5 != 0) goto L_0x00be
            int r3 = r3.nextIndex()
            int r3 = r3 + r7
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.take(r0, r3)
            goto L_0x00e3
        L_0x00df:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x00e3:
            java.lang.String[] r3 = new java.lang.String[r4]
            java.lang.Object[] r0 = r0.toArray(r3)
            if (r0 == 0) goto L_0x0109
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r3 = r0.length
            int r3 = r3 - r7
            r0 = r0[r3]
            android.net.Uri r3 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            java.lang.String r5 = "MediaStore.Images.Media.EXTERNAL_CONTENT_URI"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r5)
            java.lang.String[] r5 = new java.lang.String[r7]
            r5[r4] = r0
            java.lang.String r0 = "_id=?"
            java.lang.String r5 = r1.getDataColumn(r2, r3, r0, r5)
            if (r5 != 0) goto L_0x01ce
        L_0x0104:
            kotlin.jvm.internal.Intrinsics.throwNpe()
            goto L_0x01ce
        L_0x0109:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r2)
            throw r0
        L_0x0111:
            boolean r0 = r1.isDownloadsDocument(r3)
            if (r0 == 0) goto L_0x013e
            java.lang.String r0 = android.provider.DocumentsContract.getDocumentId(r22)
            java.lang.String r3 = "content://downloads/public_downloads"
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r5 = "java.lang.Long.valueOf(id)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            long r5 = r0.longValue()
            android.net.Uri r0 = android.content.ContentUris.withAppendedId(r3, r5)
            java.lang.String r3 = "contentUri"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r5 = r1.getDataColumn(r2, r0, r4, r4)
            if (r5 != 0) goto L_0x01ce
            goto L_0x0104
        L_0x013e:
            java.lang.String r0 = r22.getAuthority()
            java.lang.String r4 = "sanriku-app"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            java.lang.String r4 = "uri.toString()"
            if (r0 == 0) goto L_0x0196
            java.lang.String r14 = r22.toString()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r4)
            java.lang.String r0 = "/"
            java.lang.String[] r15 = new java.lang.String[]{r0}
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            java.util.List r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r14, (java.lang.String[]) r15, (boolean) r16, (int) r17, (int) r18, (java.lang.Object) r19)
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.last(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r2 = r21.getFilesDir()
            java.lang.String r2 = r2.toString()
            r3.append(r2)
            java.lang.String r2 = "/zips/"
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            java.lang.String r5 = r2.getAbsolutePath()
            java.lang.String r0 = "shareFile.absolutePath"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            goto L_0x01ce
        L_0x0196:
            java.lang.String r0 = r22.getAuthority()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x01ce
            java.lang.String r14 = r22.toString()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r4)
            java.lang.String r0 = "file://"
            java.lang.String[] r15 = new java.lang.String[]{r0}
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            java.util.List r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r14, (java.lang.String[]) r15, (boolean) r16, (int) r17, (int) r18, (java.lang.Object) r19)
            int r2 = r0.size()
            if (r2 != r8) goto L_0x01c6
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x01cd
        L_0x01c6:
            java.lang.String r0 = r22.toString()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
        L_0x01cd:
            r5 = r0
        L_0x01ce:
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            android.graphics.Matrix r14 = r1.getRotatedMatrix(r5, r0)
            r10 = 0
            r11 = 0
            r15 = 1
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r9, r10, r11, r12, r13, r14, r15)
        L_0x01de:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.util.GymUtils.resizeBitmap(android.content.Context, android.net.Uri, int):android.graphics.Bitmap");
    }

    public final boolean validateEmail(String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        return Pattern.compile(PATTERN_EMAIL).matcher(str).matches();
    }

    public final boolean validatePassword(String str) {
        Intrinsics.checkParameterIsNotNull(str, "string");
        return Pattern.compile(PATTERN_PASSWORD).matcher(str).matches();
    }

    public final boolean validatePhone(String str) {
        Intrinsics.checkParameterIsNotNull(str, "string");
        return Pattern.compile(PATTERN_PHONE).matcher(str).matches();
    }

    public final boolean validatePost(String str) {
        Intrinsics.checkParameterIsNotNull(str, "string");
        return Pattern.compile(PATTERN_POST).matcher(str).matches();
    }

    public final boolean validateUsername(String str) {
        Intrinsics.checkParameterIsNotNull(str, "string");
        return Pattern.compile(PATTERN_EMAIL).matcher(str).matches();
    }
}
