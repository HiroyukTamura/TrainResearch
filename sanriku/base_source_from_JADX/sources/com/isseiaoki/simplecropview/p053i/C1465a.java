package com.isseiaoki.simplecropview.p053i;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.isseiaoki.simplecropview.i.a */
public class C1465a {

    /* renamed from: a */
    public static int f1534a;

    /* renamed from: b */
    public static int f1535b;

    /* renamed from: a */
    public static int m1985a(Context context, Uri uri) {
        int i = 0;
        if (uri.getAuthority().toLowerCase().endsWith("media")) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"orientation"}, (String) null, (String[]) null, (String) null);
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        cursor.close();
                        return i;
                    }
                }
                if (cursor == null) {
                    return 0;
                }
            } catch (RuntimeException unused) {
                if (cursor == null) {
                    return 0;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            cursor.close();
            return i;
        }
        File b = m1992b(context, uri);
        if (b == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(b.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            e.getMessage();
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[LOOP:0: B:16:0x002d->B:21:0x0039, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0038 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m1986a(android.content.Context r3, android.net.Uri r4, int r5) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            r2 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0022, all -> 0x001d }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0022, all -> 0x001d }
            android.graphics.BitmapFactory.decodeStream(r3, r2, r0)     // Catch:{ FileNotFoundException -> 0x001b, all -> 0x0018 }
            m1990a(r3)
            goto L_0x0025
        L_0x0018:
            r4 = move-exception
            r2 = r3
            goto L_0x001e
        L_0x001b:
            r2 = r3
            goto L_0x0022
        L_0x001d:
            r4 = move-exception
        L_0x001e:
            m1990a(r2)
            throw r4
        L_0x0022:
            m1990a(r2)
        L_0x0025:
            int r3 = r0.outWidth
            f1534a = r3
            int r3 = r0.outHeight
            f1535b = r3
        L_0x002d:
            int r3 = r0.outWidth
            int r3 = r3 / r1
            if (r3 > r5) goto L_0x0039
            int r3 = r0.outHeight
            int r3 = r3 / r1
            if (r3 <= r5) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            return r1
        L_0x0039:
            int r1 = r1 * 2
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.p053i.C1465a.m1986a(android.content.Context, android.net.Uri, int):int");
    }

    /* renamed from: a */
    public static Bitmap m1987a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m1988a(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) {
        /*
            java.lang.String r0 = "_display_name"
            java.lang.String r1 = "_data"
            java.lang.String[] r4 = new java.lang.String[]{r1, r0}
            r8 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ all -> 0x0046 }
            r7 = 0
            r3 = r10
            r5 = r11
            r6 = r12
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0046 }
            if (r9 == 0) goto L_0x0040
            boolean r11 = r9.moveToFirst()     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x0040
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x003d }
            java.lang.String r11 = "content://com.google.android.gallery3d"
            boolean r10 = r10.startsWith(r11)     // Catch:{ all -> 0x003d }
            if (r10 == 0) goto L_0x002e
            int r10 = r9.getColumnIndex(r0)     // Catch:{ all -> 0x003d }
            goto L_0x0032
        L_0x002e:
            int r10 = r9.getColumnIndex(r1)     // Catch:{ all -> 0x003d }
        L_0x0032:
            r11 = -1
            if (r10 == r11) goto L_0x0040
            java.lang.String r10 = r9.getString(r10)     // Catch:{ all -> 0x003d }
            r9.close()
            return r10
        L_0x003d:
            r10 = move-exception
            r8 = r9
            goto L_0x0047
        L_0x0040:
            if (r9 == 0) goto L_0x0045
            r9.close()
        L_0x0045:
            return r8
        L_0x0046:
            r10 = move-exception
        L_0x0047:
            if (r8 == 0) goto L_0x004c
            r8.close()
        L_0x004c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.p053i.C1465a.m1988a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    /* renamed from: a */
    public static void m1989a(Context context, Uri uri, Uri uri2, int i, int i2) {
        if (uri != null && uri2 != null) {
            try {
                File b = m1992b(context, uri);
                File b2 = m1992b(context, uri2);
                if (b == null) {
                    return;
                }
                if (b2 != null) {
                    String absolutePath = b.getAbsolutePath();
                    String absolutePath2 = b2.getAbsolutePath();
                    ExifInterface exifInterface = new ExifInterface(absolutePath);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_DATETIME);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_FLASH);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_FOCAL_LENGTH);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE_REF);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_DATESTAMP);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_PROCESSING_METHOD);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_TIMESTAMP);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_MAKE);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_MODEL);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_WHITE_BALANCE);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_TIME);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER);
                    arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS);
                    if (Build.VERSION.SDK_INT >= 23) {
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_DATETIME_DIGITIZED);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_DIGITIZED);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_ORIGINAL);
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_DIGITIZED);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_ORIGINAL);
                    }
                    ExifInterface exifInterface2 = new ExifInterface(absolutePath2);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        String attribute = exifInterface.getAttribute(str);
                        if (!TextUtils.isEmpty(attribute)) {
                            exifInterface2.setAttribute(str, attribute);
                        }
                    }
                    exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i));
                    exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i2));
                    exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, String.valueOf(0));
                    exifInterface2.saveAttributes();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m1990a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[SYNTHETIC, Splitter:B:19:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003d A[SYNTHETIC, Splitter:B:25:0x003d] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m1991b(android.content.Context r3, android.net.Uri r4, int r5) {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x002e, all -> 0x002c }
            java.io.InputStream r1 = r1.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x002e, all -> 0x002c }
            if (r1 == 0) goto L_0x0021
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ FileNotFoundException -> 0x001f }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x001f }
            int r3 = m1986a((android.content.Context) r3, (android.net.Uri) r4, (int) r5)     // Catch:{ FileNotFoundException -> 0x001f }
            r2.inSampleSize = r3     // Catch:{ FileNotFoundException -> 0x001f }
            r3 = 0
            r2.inJustDecodeBounds = r3     // Catch:{ FileNotFoundException -> 0x001f }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch:{ FileNotFoundException -> 0x001f }
            r0 = r3
            goto L_0x0021
        L_0x001f:
            r3 = move-exception
            goto L_0x0030
        L_0x0021:
            if (r1 == 0) goto L_0x0038
            r1.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0038
        L_0x0027:
            r3 = move-exception
            r3.getMessage()
            goto L_0x0038
        L_0x002c:
            r3 = move-exception
            goto L_0x003b
        L_0x002e:
            r3 = move-exception
            r1 = r0
        L_0x0030:
            r3.getMessage()     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0038
            r1.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0038:
            return r0
        L_0x0039:
            r3 = move-exception
            r0 = r1
        L_0x003b:
            if (r0 == 0) goto L_0x0045
            r0.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r4 = move-exception
            r4.getMessage()
        L_0x0045:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.p053i.C1465a.m1991b(android.content.Context, android.net.Uri, int):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0161 A[RETURN] */
    @android.annotation.TargetApi(19)
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File m1992b(android.content.Context r6, android.net.Uri r7) {
        /*
            r0 = 1
            r1 = 0
            if (r0 == 0) goto L_0x0125
            boolean r2 = android.provider.DocumentsContract.isDocumentUri(r6, r7)
            if (r2 == 0) goto L_0x0125
            java.lang.String r2 = r7.getAuthority()
            java.lang.String r3 = "com.android.externalstorage.documents"
            boolean r2 = r3.equals(r2)
            java.lang.String r3 = ":"
            r4 = 0
            if (r2 == 0) goto L_0x0047
            java.lang.String r6 = android.provider.DocumentsContract.getDocumentId(r7)
            java.lang.String[] r6 = r6.split(r3)
            r7 = r6[r4]
            java.lang.String r2 = "primary"
            boolean r7 = r2.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0158
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            r7.append(r2)
            java.lang.String r2 = "/"
            r7.append(r2)
            r6 = r6[r0]
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            goto L_0x0159
        L_0x0047:
            java.lang.String r2 = r7.getAuthority()
            java.lang.String r5 = "com.android.providers.downloads.documents"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x006b
            java.lang.String r7 = android.provider.DocumentsContract.getDocumentId(r7)
            java.lang.String r0 = "content://downloads/public_downloads"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            long r2 = r7.longValue()
            android.net.Uri r7 = android.content.ContentUris.withAppendedId(r0, r2)
            goto L_0x0142
        L_0x006b:
            java.lang.String r2 = r7.getAuthority()
            java.lang.String r5 = "com.android.providers.media.documents"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00b1
            java.lang.String r7 = android.provider.DocumentsContract.getDocumentId(r7)
            java.lang.String[] r7 = r7.split(r3)
            r2 = r7[r4]
            java.lang.String r3 = "image"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x008c
            android.net.Uri r2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x00a3
        L_0x008c:
            java.lang.String r3 = "video"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x0097
            android.net.Uri r2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto L_0x00a3
        L_0x0097:
            java.lang.String r3 = "audio"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x00a2
            android.net.Uri r2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            goto L_0x00a3
        L_0x00a2:
            r2 = r1
        L_0x00a3:
            java.lang.String[] r3 = new java.lang.String[r0]
            r7 = r7[r0]
            r3[r4] = r7
            java.lang.String r7 = "_id=?"
            java.lang.String r6 = m1988a(r6, r2, r7, r3)
            goto L_0x0159
        L_0x00b1:
            java.lang.String r0 = r7.getAuthority()
            java.lang.String r2 = "com.google.android.apps.docs.storage"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0158
            java.io.File r0 = new java.io.File
            java.io.File r2 = r6.getCacheDir()
            java.lang.String r3 = "tmp"
            r0.<init>(r2, r3)
            java.lang.String r0 = r0.getAbsolutePath()
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ IOException -> 0x011c, all -> 0x0112 }
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r6 = r6.openFileDescriptor(r7, r2)     // Catch:{ IOException -> 0x011c, all -> 0x0112 }
            if (r6 != 0) goto L_0x00df
            m1990a(r1)
            m1990a(r1)
            goto L_0x0124
        L_0x00df:
            java.io.FileDescriptor r6 = r6.getFileDescriptor()     // Catch:{ IOException -> 0x011c, all -> 0x0112 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x011c, all -> 0x0112 }
            r7.<init>(r6)     // Catch:{ IOException -> 0x011c, all -> 0x0112 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0110, all -> 0x010b }
            r6.<init>(r0)     // Catch:{ IOException -> 0x0110, all -> 0x010b }
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x011e, all -> 0x0109 }
        L_0x00f1:
            int r3 = r7.read(r2)     // Catch:{ IOException -> 0x011e, all -> 0x0109 }
            r5 = -1
            if (r3 == r5) goto L_0x00fc
            r6.write(r2, r4, r3)     // Catch:{ IOException -> 0x011e, all -> 0x0109 }
            goto L_0x00f1
        L_0x00fc:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x011e, all -> 0x0109 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x011e, all -> 0x0109 }
            m1990a(r7)
            m1990a(r6)
            r1 = r2
            goto L_0x0124
        L_0x0109:
            r0 = move-exception
            goto L_0x010e
        L_0x010b:
            r6 = move-exception
            r0 = r6
            r6 = r1
        L_0x010e:
            r1 = r7
            goto L_0x0115
        L_0x0110:
            r6 = r1
            goto L_0x011e
        L_0x0112:
            r6 = move-exception
            r0 = r6
            r6 = r1
        L_0x0115:
            m1990a(r1)
            m1990a(r6)
            throw r0
        L_0x011c:
            r6 = r1
            r7 = r6
        L_0x011e:
            m1990a(r7)
            m1990a(r6)
        L_0x0124:
            return r1
        L_0x0125:
            java.lang.String r0 = r7.getScheme()
            java.lang.String r2 = "content"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0147
            java.lang.String r0 = r7.getAuthority()
            java.lang.String r2 = "com.google.android.apps.photos.content"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0142
            java.lang.String r6 = r7.getLastPathSegment()
            goto L_0x0159
        L_0x0142:
            java.lang.String r6 = m1988a(r6, r7, r1, r1)
            goto L_0x0159
        L_0x0147:
            java.lang.String r6 = r7.getScheme()
            java.lang.String r0 = "file"
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0158
            java.lang.String r6 = r7.getPath()
            goto L_0x0159
        L_0x0158:
            r6 = r1
        L_0x0159:
            if (r6 == 0) goto L_0x0161
            java.io.File r7 = new java.io.File
            r7.<init>(r6)
            return r7
        L_0x0161:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.p053i.C1465a.m1992b(android.content.Context, android.net.Uri):java.io.File");
    }

    /* renamed from: c */
    public static void m1993c(Context context, Uri uri) {
        ContentValues contentValues = new ContentValues();
        File b = m1992b(context, uri);
        if (b != null && b.exists()) {
            contentValues.put("_size", Long.valueOf(b.length()));
        }
        context.getContentResolver().update(uri, contentValues, (String) null, (String[]) null);
    }
}
