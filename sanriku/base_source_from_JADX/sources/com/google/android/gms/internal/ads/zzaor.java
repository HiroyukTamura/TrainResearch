package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

public final class zzaor extends zzapb {
    private static final Set<String> zzdik = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int height = -1;
    private final Object lock = new Object();
    private int width = -1;
    private zzapa zzdau;
    private final zzbek zzdce;
    private final Activity zzdia;
    private String zzdil = "top-right";
    private boolean zzdim = true;
    private int zzdin = 0;
    private int zzdio = 0;
    private int zzdip = 0;
    private int zzdiq = 0;
    private zzbfz zzdir;
    private ImageView zzdis;
    private LinearLayout zzdit;
    private PopupWindow zzdiu;
    private RelativeLayout zzdiv;
    private ViewGroup zzdiw;

    public zzaor(zzbek zzbek, zzapa zzapa) {
        super(zzbek, "resize");
        this.zzdce = zzbek;
        this.zzdia = zzbek.zzzh();
        this.zzdau = zzapa;
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdin = i;
            this.zzdio = i2;
            PopupWindow popupWindow = this.zzdiu;
        }
    }

    public final void zzac(boolean z) {
        synchronized (this.lock) {
            if (this.zzdiu != null) {
                this.zzdiu.dismiss();
                this.zzdiv.removeView(this.zzdce.getView());
                if (this.zzdiw != null) {
                    this.zzdiw.removeView(this.zzdis);
                    this.zzdiw.addView(this.zzdce.getView());
                    this.zzdce.zza(this.zzdir);
                }
                if (z) {
                    zzdx("default");
                    if (this.zzdau != null) {
                        this.zzdau.zzud();
                    }
                }
                this.zzdiu = null;
                this.zzdiv = null;
                this.zzdiw = null;
                this.zzdit = null;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a5, code lost:
        if (r5 == 5) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01a7, code lost:
        r5 = ((r1.zzdin + r1.zzdip) + r1.width) - 50;
        r8 = r1.zzdio;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01b3, code lost:
        r5 = ((r1.zzdin + r1.zzdip) + r1.width) - 50;
        r8 = r1.zzdio;
        r15 = r1.zzdiq;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01c1, code lost:
        r5 = ((r1.zzdin + r1.zzdip) + (r1.width / 2)) - 25;
        r8 = r1.zzdio;
        r15 = r1.zzdiq;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d4, code lost:
        r5 = r1.zzdin + r1.zzdip;
        r8 = r1.zzdio;
        r15 = r1.zzdiq;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01de, code lost:
        r8 = ((r8 + r15) + r1.height) - 50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01e1, code lost:
        r5 = ((r1.zzdin + r1.zzdip) + (r1.width / 2)) - 25;
        r8 = ((r1.zzdio + r1.zzdiq) + (r1.height / 2)) - 25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01f8, code lost:
        r5 = ((r1.zzdin + r1.zzdip) + (r1.width / 2)) - 25;
        r8 = r1.zzdio;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0208, code lost:
        r5 = r1.zzdin + r1.zzdip;
        r8 = r1.zzdio;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0210, code lost:
        r8 = r8 + r1.zzdiq;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0211, code lost:
        if (r5 < 0) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0214, code lost:
        if ((r5 + 50) > r7) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0218, code lost:
        if (r8 < r6[0]) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x021d, code lost:
        if ((r8 + 50) <= r6[1]) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x019a, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x019b, code lost:
        if (r5 == 0) goto L_0x0208;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x019d, code lost:
        if (r5 == 1) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x019f, code lost:
        if (r5 == 2) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a1, code lost:
        if (r5 == 3) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a3, code lost:
        if (r5 == 4) goto L_0x01c1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x022d A[Catch:{ RuntimeException -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x022f A[Catch:{ RuntimeException -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x028d A[Catch:{ RuntimeException -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0294 A[Catch:{ RuntimeException -> 0x044c }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x041b A[Catch:{ RuntimeException -> 0x044c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.Object r2 = r1.lock
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzdv(r0)     // Catch:{ all -> 0x04a2 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzbek r3 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbfz r3 = r3.zzabh()     // Catch:{ all -> 0x04a2 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzdv(r0)     // Catch:{ all -> 0x04a2 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzbek r3 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbfz r3 = r3.zzabh()     // Catch:{ all -> 0x04a2 }
            boolean r3 = r3.zzaco()     // Catch:{ all -> 0x04a2 }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzdv(r0)     // Catch:{ all -> 0x04a2 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzbek r3 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            boolean r3 = r3.zzabo()     // Catch:{ all -> 0x04a2 }
            if (r3 == 0) goto L_0x0043
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzdv(r0)     // Catch:{ all -> 0x04a2 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a2 }
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a2 }
            int r3 = com.google.android.gms.internal.ads.zzaxa.zzel(r3)     // Catch:{ all -> 0x04a2 }
            r1.width = r3     // Catch:{ all -> 0x04a2 }
        L_0x0062:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a2 }
            if (r3 != 0) goto L_0x0081
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a2 }
            int r3 = com.google.android.gms.internal.ads.zzaxa.zzel(r3)     // Catch:{ all -> 0x04a2 }
            r1.height = r3     // Catch:{ all -> 0x04a2 }
        L_0x0081:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a2 }
            if (r3 != 0) goto L_0x00a0
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a2 }
            int r3 = com.google.android.gms.internal.ads.zzaxa.zzel(r3)     // Catch:{ all -> 0x04a2 }
            r1.zzdip = r3     // Catch:{ all -> 0x04a2 }
        L_0x00a0:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a2 }
            if (r3 != 0) goto L_0x00bf
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a2 }
            int r3 = com.google.android.gms.internal.ads.zzaxa.zzel(r3)     // Catch:{ all -> 0x04a2 }
            r1.zzdiq = r3     // Catch:{ all -> 0x04a2 }
        L_0x00bf:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a2 }
            if (r3 != 0) goto L_0x00db
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a2 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x04a2 }
            r1.zzdim = r3     // Catch:{ all -> 0x04a2 }
        L_0x00db:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x04a2 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04a2 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04a2 }
            if (r3 != 0) goto L_0x00eb
            r1.zzdil = r0     // Catch:{ all -> 0x04a2 }
        L_0x00eb:
            int r0 = r1.width     // Catch:{ all -> 0x04a2 }
            r3 = 1
            r4 = 0
            if (r0 < 0) goto L_0x00f7
            int r0 = r1.height     // Catch:{ all -> 0x04a2 }
            if (r0 < 0) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzdv(r0)     // Catch:{ all -> 0x04a2 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x0101:
            android.app.Activity r0 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x04a2 }
            if (r0 == 0) goto L_0x049b
            android.view.View r5 = r0.getDecorView()     // Catch:{ all -> 0x04a2 }
            if (r5 != 0) goto L_0x0111
            goto L_0x049b
        L_0x0111:
            com.google.android.gms.internal.ads.zzaxa r5 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            android.app.Activity r6 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            int[] r5 = r5.zze((android.app.Activity) r6)     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzaxa r6 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            android.app.Activity r7 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            int[] r6 = r6.zzf(r7)     // Catch:{ all -> 0x04a2 }
            r7 = r5[r4]     // Catch:{ all -> 0x04a2 }
            r5 = r5[r3]     // Catch:{ all -> 0x04a2 }
            int r8 = r1.width     // Catch:{ all -> 0x04a2 }
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = -1
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x0225
            int r8 = r1.width     // Catch:{ all -> 0x04a2 }
            if (r8 <= r7) goto L_0x013a
            goto L_0x0225
        L_0x013a:
            int r8 = r1.height     // Catch:{ all -> 0x04a2 }
            if (r8 < r14) goto L_0x0222
            int r8 = r1.height     // Catch:{ all -> 0x04a2 }
            if (r8 <= r5) goto L_0x0144
            goto L_0x0222
        L_0x0144:
            int r8 = r1.height     // Catch:{ all -> 0x04a2 }
            if (r8 != r5) goto L_0x0150
            int r5 = r1.width     // Catch:{ all -> 0x04a2 }
            if (r5 != r7) goto L_0x0150
            java.lang.String r5 = "Cannot resize to a full-screen ad."
            goto L_0x0227
        L_0x0150:
            boolean r5 = r1.zzdim     // Catch:{ all -> 0x04a2 }
            if (r5 == 0) goto L_0x0220
            java.lang.String r5 = r1.zzdil     // Catch:{ all -> 0x04a2 }
            int r8 = r5.hashCode()     // Catch:{ all -> 0x04a2 }
            switch(r8) {
                case -1364013995: goto L_0x0190;
                case -1012429441: goto L_0x0186;
                case -655373719: goto L_0x017c;
                case 1163912186: goto L_0x0172;
                case 1288627767: goto L_0x0168;
                case 1755462605: goto L_0x015e;
                default: goto L_0x015d;
            }     // Catch:{ all -> 0x04a2 }
        L_0x015d:
            goto L_0x019a
        L_0x015e:
            java.lang.String r8 = "top-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a2 }
            if (r5 == 0) goto L_0x019a
            r5 = 1
            goto L_0x019b
        L_0x0168:
            java.lang.String r8 = "bottom-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a2 }
            if (r5 == 0) goto L_0x019a
            r5 = 4
            goto L_0x019b
        L_0x0172:
            java.lang.String r8 = "bottom-right"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a2 }
            if (r5 == 0) goto L_0x019a
            r5 = 5
            goto L_0x019b
        L_0x017c:
            java.lang.String r8 = "bottom-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a2 }
            if (r5 == 0) goto L_0x019a
            r5 = 3
            goto L_0x019b
        L_0x0186:
            java.lang.String r8 = "top-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a2 }
            if (r5 == 0) goto L_0x019a
            r5 = 0
            goto L_0x019b
        L_0x0190:
            java.lang.String r8 = "center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a2 }
            if (r5 == 0) goto L_0x019a
            r5 = 2
            goto L_0x019b
        L_0x019a:
            r5 = -1
        L_0x019b:
            if (r5 == 0) goto L_0x0208
            if (r5 == r3) goto L_0x01f8
            if (r5 == r13) goto L_0x01e1
            if (r5 == r11) goto L_0x01d4
            if (r5 == r10) goto L_0x01c1
            if (r5 == r9) goto L_0x01b3
            int r5 = r1.zzdin     // Catch:{ all -> 0x04a2 }
            int r8 = r1.zzdip     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdio     // Catch:{ all -> 0x04a2 }
            goto L_0x0205
        L_0x01b3:
            int r5 = r1.zzdin     // Catch:{ all -> 0x04a2 }
            int r8 = r1.zzdip     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdio     // Catch:{ all -> 0x04a2 }
            int r15 = r1.zzdiq     // Catch:{ all -> 0x04a2 }
            goto L_0x01d0
        L_0x01c1:
            int r5 = r1.zzdin     // Catch:{ all -> 0x04a2 }
            int r8 = r1.zzdip     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04a2 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdio     // Catch:{ all -> 0x04a2 }
            int r15 = r1.zzdiq     // Catch:{ all -> 0x04a2 }
        L_0x01d0:
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04a2 }
            goto L_0x01de
        L_0x01d4:
            int r5 = r1.zzdin     // Catch:{ all -> 0x04a2 }
            int r8 = r1.zzdip     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            int r8 = r1.zzdio     // Catch:{ all -> 0x04a2 }
            int r15 = r1.zzdiq     // Catch:{ all -> 0x04a2 }
            goto L_0x01d0
        L_0x01de:
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x0211
        L_0x01e1:
            int r5 = r1.zzdin     // Catch:{ all -> 0x04a2 }
            int r8 = r1.zzdip     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04a2 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdio     // Catch:{ all -> 0x04a2 }
            int r15 = r1.zzdiq     // Catch:{ all -> 0x04a2 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04a2 }
            int r15 = r15 / r13
            int r8 = r8 + r15
            int r8 = r8 + -25
            goto L_0x0211
        L_0x01f8:
            int r5 = r1.zzdin     // Catch:{ all -> 0x04a2 }
            int r8 = r1.zzdip     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04a2 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdio     // Catch:{ all -> 0x04a2 }
        L_0x0205:
            int r15 = r1.zzdiq     // Catch:{ all -> 0x04a2 }
            goto L_0x0210
        L_0x0208:
            int r5 = r1.zzdin     // Catch:{ all -> 0x04a2 }
            int r8 = r1.zzdip     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            int r8 = r1.zzdio     // Catch:{ all -> 0x04a2 }
            goto L_0x0205
        L_0x0210:
            int r8 = r8 + r15
        L_0x0211:
            if (r5 < 0) goto L_0x022a
            int r5 = r5 + r14
            if (r5 > r7) goto L_0x022a
            r5 = r6[r4]     // Catch:{ all -> 0x04a2 }
            if (r8 < r5) goto L_0x022a
            int r8 = r8 + r14
            r5 = r6[r3]     // Catch:{ all -> 0x04a2 }
            if (r8 <= r5) goto L_0x0220
            goto L_0x022a
        L_0x0220:
            r5 = 1
            goto L_0x022b
        L_0x0222:
            java.lang.String r5 = "Height is too small or too large."
            goto L_0x0227
        L_0x0225:
            java.lang.String r5 = "Width is too small or too large."
        L_0x0227:
            com.google.android.gms.internal.ads.zzazw.zzfc(r5)     // Catch:{ all -> 0x04a2 }
        L_0x022a:
            r5 = 0
        L_0x022b:
            if (r5 != 0) goto L_0x022f
            r5 = 0
            goto L_0x028b
        L_0x022f:
            boolean r5 = r1.zzdim     // Catch:{ all -> 0x04a2 }
            if (r5 == 0) goto L_0x0244
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04a2 }
            int r6 = r1.zzdin     // Catch:{ all -> 0x04a2 }
            int r7 = r1.zzdip     // Catch:{ all -> 0x04a2 }
            int r6 = r6 + r7
            r5[r4] = r6     // Catch:{ all -> 0x04a2 }
            int r6 = r1.zzdio     // Catch:{ all -> 0x04a2 }
            int r7 = r1.zzdiq     // Catch:{ all -> 0x04a2 }
            int r6 = r6 + r7
            r5[r3] = r6     // Catch:{ all -> 0x04a2 }
            goto L_0x028b
        L_0x0244:
            com.google.android.gms.internal.ads.zzaxa r5 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            android.app.Activity r6 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            int[] r5 = r5.zze((android.app.Activity) r6)     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzaxa r6 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            android.app.Activity r7 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            int[] r6 = r6.zzf(r7)     // Catch:{ all -> 0x04a2 }
            r5 = r5[r4]     // Catch:{ all -> 0x04a2 }
            int r7 = r1.zzdin     // Catch:{ all -> 0x04a2 }
            int r8 = r1.zzdip     // Catch:{ all -> 0x04a2 }
            int r7 = r7 + r8
            int r8 = r1.zzdio     // Catch:{ all -> 0x04a2 }
            int r15 = r1.zzdiq     // Catch:{ all -> 0x04a2 }
            int r8 = r8 + r15
            if (r7 >= 0) goto L_0x0268
            r7 = 0
            goto L_0x0271
        L_0x0268:
            int r15 = r1.width     // Catch:{ all -> 0x04a2 }
            int r15 = r15 + r7
            if (r15 <= r5) goto L_0x0271
            int r7 = r1.width     // Catch:{ all -> 0x04a2 }
            int r7 = r5 - r7
        L_0x0271:
            r5 = r6[r4]     // Catch:{ all -> 0x04a2 }
            if (r8 >= r5) goto L_0x0278
            r8 = r6[r4]     // Catch:{ all -> 0x04a2 }
            goto L_0x0285
        L_0x0278:
            int r5 = r1.height     // Catch:{ all -> 0x04a2 }
            int r5 = r5 + r8
            r15 = r6[r3]     // Catch:{ all -> 0x04a2 }
            if (r5 <= r15) goto L_0x0285
            r5 = r6[r3]     // Catch:{ all -> 0x04a2 }
            int r6 = r1.height     // Catch:{ all -> 0x04a2 }
            int r8 = r5 - r6
        L_0x0285:
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04a2 }
            r5[r4] = r7     // Catch:{ all -> 0x04a2 }
            r5[r3] = r8     // Catch:{ all -> 0x04a2 }
        L_0x028b:
            if (r5 != 0) goto L_0x0294
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzdv(r0)     // Catch:{ all -> 0x04a2 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x0294:
            com.google.android.gms.internal.ads.zzvj.zzpr()     // Catch:{ all -> 0x04a2 }
            android.app.Activity r6 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            int r7 = r1.width     // Catch:{ all -> 0x04a2 }
            int r6 = com.google.android.gms.internal.ads.zzazm.zzc(r6, r7)     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzvj.zzpr()     // Catch:{ all -> 0x04a2 }
            android.app.Activity r7 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            int r8 = r1.height     // Catch:{ all -> 0x04a2 }
            int r7 = com.google.android.gms.internal.ads.zzazm.zzc(r7, r8)     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbek r8 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04a2 }
            android.view.ViewParent r8 = r8.getParent()     // Catch:{ all -> 0x04a2 }
            if (r8 == 0) goto L_0x0494
            boolean r15 = r8 instanceof android.view.ViewGroup     // Catch:{ all -> 0x04a2 }
            if (r15 == 0) goto L_0x0494
            r15 = r8
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbek r9 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04a2 }
            r15.removeView(r9)     // Catch:{ all -> 0x04a2 }
            android.widget.PopupWindow r9 = r1.zzdiu     // Catch:{ all -> 0x04a2 }
            if (r9 != 0) goto L_0x02f7
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ all -> 0x04a2 }
            r1.zzdiw = r8     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbek r8 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04a2 }
            android.graphics.Bitmap r8 = com.google.android.gms.internal.ads.zzaxa.zzm(r8)     // Catch:{ all -> 0x04a2 }
            android.widget.ImageView r9 = new android.widget.ImageView     // Catch:{ all -> 0x04a2 }
            android.app.Activity r15 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            r9.<init>(r15)     // Catch:{ all -> 0x04a2 }
            r1.zzdis = r9     // Catch:{ all -> 0x04a2 }
            r9.setImageBitmap(r8)     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbek r8 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbfz r8 = r8.zzabh()     // Catch:{ all -> 0x04a2 }
            r1.zzdir = r8     // Catch:{ all -> 0x04a2 }
            android.view.ViewGroup r8 = r1.zzdiw     // Catch:{ all -> 0x04a2 }
            android.widget.ImageView r9 = r1.zzdis     // Catch:{ all -> 0x04a2 }
            r8.addView(r9)     // Catch:{ all -> 0x04a2 }
            goto L_0x02fc
        L_0x02f7:
            android.widget.PopupWindow r8 = r1.zzdiu     // Catch:{ all -> 0x04a2 }
            r8.dismiss()     // Catch:{ all -> 0x04a2 }
        L_0x02fc:
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ all -> 0x04a2 }
            android.app.Activity r9 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            r8.<init>(r9)     // Catch:{ all -> 0x04a2 }
            r1.zzdiv = r8     // Catch:{ all -> 0x04a2 }
            r8.setBackgroundColor(r4)     // Catch:{ all -> 0x04a2 }
            android.widget.RelativeLayout r8 = r1.zzdiv     // Catch:{ all -> 0x04a2 }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x04a2 }
            r9.<init>(r6, r7)     // Catch:{ all -> 0x04a2 }
            r8.setLayoutParams(r9)     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            android.widget.RelativeLayout r8 = r1.zzdiv     // Catch:{ all -> 0x04a2 }
            android.widget.PopupWindow r8 = com.google.android.gms.internal.ads.zzaxa.zza((android.view.View) r8, (int) r6, (int) r7, (boolean) r4)     // Catch:{ all -> 0x04a2 }
            r1.zzdiu = r8     // Catch:{ all -> 0x04a2 }
            r8.setOutsideTouchable(r3)     // Catch:{ all -> 0x04a2 }
            android.widget.PopupWindow r8 = r1.zzdiu     // Catch:{ all -> 0x04a2 }
            r8.setTouchable(r3)     // Catch:{ all -> 0x04a2 }
            android.widget.PopupWindow r8 = r1.zzdiu     // Catch:{ all -> 0x04a2 }
            boolean r9 = r1.zzdim     // Catch:{ all -> 0x04a2 }
            if (r9 != 0) goto L_0x032d
            r9 = 1
            goto L_0x032e
        L_0x032d:
            r9 = 0
        L_0x032e:
            r8.setClippingEnabled(r9)     // Catch:{ all -> 0x04a2 }
            android.widget.RelativeLayout r8 = r1.zzdiv     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbek r9 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04a2 }
            r8.addView(r9, r12, r12)     // Catch:{ all -> 0x04a2 }
            android.widget.LinearLayout r8 = new android.widget.LinearLayout     // Catch:{ all -> 0x04a2 }
            android.app.Activity r9 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            r8.<init>(r9)     // Catch:{ all -> 0x04a2 }
            r1.zzdit = r8     // Catch:{ all -> 0x04a2 }
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzvj.zzpr()     // Catch:{ all -> 0x04a2 }
            android.app.Activity r9 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            int r9 = com.google.android.gms.internal.ads.zzazm.zzc(r9, r14)     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzvj.zzpr()     // Catch:{ all -> 0x04a2 }
            android.app.Activity r15 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            int r14 = com.google.android.gms.internal.ads.zzazm.zzc(r15, r14)     // Catch:{ all -> 0x04a2 }
            r8.<init>(r9, r14)     // Catch:{ all -> 0x04a2 }
            java.lang.String r9 = r1.zzdil     // Catch:{ all -> 0x04a2 }
            int r14 = r9.hashCode()     // Catch:{ all -> 0x04a2 }
            switch(r14) {
                case -1364013995: goto L_0x0398;
                case -1012429441: goto L_0x038e;
                case -655373719: goto L_0x0384;
                case 1163912186: goto L_0x037a;
                case 1288627767: goto L_0x0370;
                case 1755462605: goto L_0x0366;
                default: goto L_0x0365;
            }     // Catch:{ all -> 0x04a2 }
        L_0x0365:
            goto L_0x03a1
        L_0x0366:
            java.lang.String r14 = "top-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a2 }
            if (r9 == 0) goto L_0x03a1
            r12 = 1
            goto L_0x03a1
        L_0x0370:
            java.lang.String r14 = "bottom-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a2 }
            if (r9 == 0) goto L_0x03a1
            r12 = 4
            goto L_0x03a1
        L_0x037a:
            java.lang.String r14 = "bottom-right"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a2 }
            if (r9 == 0) goto L_0x03a1
            r12 = 5
            goto L_0x03a1
        L_0x0384:
            java.lang.String r14 = "bottom-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a2 }
            if (r9 == 0) goto L_0x03a1
            r12 = 3
            goto L_0x03a1
        L_0x038e:
            java.lang.String r14 = "top-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a2 }
            if (r9 == 0) goto L_0x03a1
            r12 = 0
            goto L_0x03a1
        L_0x0398:
            java.lang.String r14 = "center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a2 }
            if (r9 == 0) goto L_0x03a1
            r12 = 2
        L_0x03a1:
            r9 = 9
            r14 = 10
            if (r12 == 0) goto L_0x03d8
            r15 = 14
            if (r12 == r3) goto L_0x03d4
            if (r12 == r13) goto L_0x03ce
            r13 = 12
            if (r12 == r11) goto L_0x03ca
            if (r12 == r10) goto L_0x03c3
            r9 = 11
            r10 = 5
            if (r12 == r10) goto L_0x03bf
            r8.addRule(r14)     // Catch:{ all -> 0x04a2 }
        L_0x03bb:
            r8.addRule(r9)     // Catch:{ all -> 0x04a2 }
            goto L_0x03dc
        L_0x03bf:
            r8.addRule(r13)     // Catch:{ all -> 0x04a2 }
            goto L_0x03bb
        L_0x03c3:
            r8.addRule(r13)     // Catch:{ all -> 0x04a2 }
        L_0x03c6:
            r8.addRule(r15)     // Catch:{ all -> 0x04a2 }
            goto L_0x03dc
        L_0x03ca:
            r8.addRule(r13)     // Catch:{ all -> 0x04a2 }
            goto L_0x03bb
        L_0x03ce:
            r9 = 13
            r8.addRule(r9)     // Catch:{ all -> 0x04a2 }
            goto L_0x03dc
        L_0x03d4:
            r8.addRule(r14)     // Catch:{ all -> 0x04a2 }
            goto L_0x03c6
        L_0x03d8:
            r8.addRule(r14)     // Catch:{ all -> 0x04a2 }
            goto L_0x03bb
        L_0x03dc:
            android.widget.LinearLayout r9 = r1.zzdit     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzaoq r10 = new com.google.android.gms.internal.ads.zzaoq     // Catch:{ all -> 0x04a2 }
            r10.<init>(r1)     // Catch:{ all -> 0x04a2 }
            r9.setOnClickListener(r10)     // Catch:{ all -> 0x04a2 }
            android.widget.LinearLayout r9 = r1.zzdit     // Catch:{ all -> 0x04a2 }
            java.lang.String r10 = "Close button"
            r9.setContentDescription(r10)     // Catch:{ all -> 0x04a2 }
            android.widget.RelativeLayout r9 = r1.zzdiv     // Catch:{ all -> 0x04a2 }
            android.widget.LinearLayout r10 = r1.zzdit     // Catch:{ all -> 0x04a2 }
            r9.addView(r10, r8)     // Catch:{ all -> 0x04a2 }
            android.widget.PopupWindow r8 = r1.zzdiu     // Catch:{ RuntimeException -> 0x044c }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x044c }
            com.google.android.gms.internal.ads.zzvj.zzpr()     // Catch:{ RuntimeException -> 0x044c }
            android.app.Activity r9 = r1.zzdia     // Catch:{ RuntimeException -> 0x044c }
            r10 = r5[r4]     // Catch:{ RuntimeException -> 0x044c }
            int r9 = com.google.android.gms.internal.ads.zzazm.zzc(r9, r10)     // Catch:{ RuntimeException -> 0x044c }
            com.google.android.gms.internal.ads.zzvj.zzpr()     // Catch:{ RuntimeException -> 0x044c }
            android.app.Activity r10 = r1.zzdia     // Catch:{ RuntimeException -> 0x044c }
            r11 = r5[r3]     // Catch:{ RuntimeException -> 0x044c }
            int r10 = com.google.android.gms.internal.ads.zzazm.zzc(r10, r11)     // Catch:{ RuntimeException -> 0x044c }
            r8.showAtLocation(r0, r4, r9, r10)     // Catch:{ RuntimeException -> 0x044c }
            r0 = r5[r4]     // Catch:{ all -> 0x04a2 }
            r8 = r5[r3]     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzapa r9 = r1.zzdau     // Catch:{ all -> 0x04a2 }
            if (r9 == 0) goto L_0x0424
            com.google.android.gms.internal.ads.zzapa r9 = r1.zzdau     // Catch:{ all -> 0x04a2 }
            int r10 = r1.width     // Catch:{ all -> 0x04a2 }
            int r11 = r1.height     // Catch:{ all -> 0x04a2 }
            r9.zza(r0, r8, r10, r11)     // Catch:{ all -> 0x04a2 }
        L_0x0424:
            com.google.android.gms.internal.ads.zzbek r0 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbfz r6 = com.google.android.gms.internal.ads.zzbfz.zzq(r6, r7)     // Catch:{ all -> 0x04a2 }
            r0.zza((com.google.android.gms.internal.ads.zzbfz) r6)     // Catch:{ all -> 0x04a2 }
            r0 = r5[r4]     // Catch:{ all -> 0x04a2 }
            r3 = r5[r3]     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzaxa r5 = com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x04a2 }
            android.app.Activity r6 = r1.zzdia     // Catch:{ all -> 0x04a2 }
            int[] r5 = r5.zzf(r6)     // Catch:{ all -> 0x04a2 }
            r4 = r5[r4]     // Catch:{ all -> 0x04a2 }
            int r3 = r3 - r4
            int r4 = r1.width     // Catch:{ all -> 0x04a2 }
            int r5 = r1.height     // Catch:{ all -> 0x04a2 }
            r1.zzb(r0, r3, r4, r5)     // Catch:{ all -> 0x04a2 }
            java.lang.String r0 = "resized"
            r1.zzdx(r0)     // Catch:{ all -> 0x04a2 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x044c:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x04a2 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x04a2 }
            int r4 = r0.length()     // Catch:{ all -> 0x04a2 }
            if (r4 == 0) goto L_0x0462
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x04a2 }
            goto L_0x0467
        L_0x0462:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x04a2 }
            r0.<init>(r3)     // Catch:{ all -> 0x04a2 }
        L_0x0467:
            r1.zzdv(r0)     // Catch:{ all -> 0x04a2 }
            android.widget.RelativeLayout r0 = r1.zzdiv     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbek r3 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04a2 }
            r0.removeView(r3)     // Catch:{ all -> 0x04a2 }
            android.view.ViewGroup r0 = r1.zzdiw     // Catch:{ all -> 0x04a2 }
            if (r0 == 0) goto L_0x0492
            android.view.ViewGroup r0 = r1.zzdiw     // Catch:{ all -> 0x04a2 }
            android.widget.ImageView r3 = r1.zzdis     // Catch:{ all -> 0x04a2 }
            r0.removeView(r3)     // Catch:{ all -> 0x04a2 }
            android.view.ViewGroup r0 = r1.zzdiw     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbek r3 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04a2 }
            r0.addView(r3)     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbek r0 = r1.zzdce     // Catch:{ all -> 0x04a2 }
            com.google.android.gms.internal.ads.zzbfz r3 = r1.zzdir     // Catch:{ all -> 0x04a2 }
            r0.zza((com.google.android.gms.internal.ads.zzbfz) r3)     // Catch:{ all -> 0x04a2 }
        L_0x0492:
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x0494:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzdv(r0)     // Catch:{ all -> 0x04a2 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x049b:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzdv(r0)     // Catch:{ all -> 0x04a2 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            return
        L_0x04a2:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x04a2 }
            goto L_0x04a6
        L_0x04a5:
            throw r0
        L_0x04a6:
            goto L_0x04a5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaor.zzg(java.util.Map):void");
    }

    public final void zzi(int i, int i2) {
        this.zzdin = i;
        this.zzdio = i2;
    }

    public final boolean zzub() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdiu != null;
        }
        return z;
    }
}
