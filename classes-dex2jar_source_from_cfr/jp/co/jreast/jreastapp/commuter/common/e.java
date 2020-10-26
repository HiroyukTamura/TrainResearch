/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 */
package jp.co.jreast.jreastapp.commuter.common;

import android.content.Context;
import android.media.MediaScannerConnection;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/ImagesMediaWrapper;", "", "()V", "scanFile", "", "context", "Landroid/content/Context;", "paths", "", "", "mimeTypes", "callback", "Landroid/media/MediaScannerConnection$OnScanCompletedListener;", "(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e {
    public final void a(Context context, String[] arrstring, String[] arrstring2, MediaScannerConnection.OnScanCompletedListener onScanCompletedListener) {
        j.b((Object)context, "context");
        j.b(arrstring, "paths");
        MediaScannerConnection.scanFile((Context)context, (String[])arrstring, (String[])arrstring2, (MediaScannerConnection.OnScanCompletedListener)onScanCompletedListener);
    }
}

