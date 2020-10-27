package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzkd {
    public int height;
    public int number;
    public int type;
    public int width;
    public zzja zzagl;
    public int zzagp;
    public byte[] zzagq;
    public int zzags;
    public int zzagt;
    /* access modifiers changed from: private */
    public String zzagz;
    public String zzaqo;
    public int zzaqp;
    public boolean zzaqq;
    public byte[] zzaqr;
    public zzjw zzaqs;
    public byte[] zzaqt;
    public int zzaqu;
    public int zzaqv;
    public int zzaqw;
    public boolean zzaqx;
    public int zzaqy;
    public int zzaqz;
    public int zzara;
    public int zzarb;
    public int zzarc;
    public float zzard;
    public float zzare;
    public float zzarf;
    public float zzarg;
    public float zzarh;
    public float zzari;
    public float zzarj;
    public float zzark;
    public float zzarl;
    public float zzarm;
    public int zzarn;
    public long zzaro;
    public long zzarp;
    public boolean zzarq;
    public boolean zzarr;
    public zzjt zzars;
    public int zzart;

    private zzkd() {
        this.width = -1;
        this.height = -1;
        this.zzaqu = -1;
        this.zzaqv = -1;
        this.zzaqw = 0;
        this.zzagq = null;
        this.zzagp = -1;
        this.zzaqx = false;
        this.zzaqy = -1;
        this.zzaqz = -1;
        this.zzara = -1;
        this.zzarb = 1000;
        this.zzarc = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        this.zzard = -1.0f;
        this.zzare = -1.0f;
        this.zzarf = -1.0f;
        this.zzarg = -1.0f;
        this.zzarh = -1.0f;
        this.zzari = -1.0f;
        this.zzarj = -1.0f;
        this.zzark = -1.0f;
        this.zzarl = -1.0f;
        this.zzarm = -1.0f;
        this.zzags = 1;
        this.zzarn = -1;
        this.zzagt = 8000;
        this.zzaro = 0;
        this.zzarp = 0;
        this.zzarr = true;
        this.zzagz = "eng";
    }

    /* synthetic */ zzkd(zzkb zzkb) {
        this();
    }

    private static List<byte[]> zza(zzos zzos) throws zzhi {
        try {
            zzos.zzbj(16);
            if (zzos.zzjc() != 826496599) {
                return null;
            }
            byte[] bArr = zzos.data;
            for (int position = zzos.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzhi("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhi("Error parsing FourCC VC1 codec private");
        }
    }

    private static boolean zzb(zzos zzos) throws zzhi {
        try {
            int zzja = zzos.zzja();
            if (zzja == 1) {
                return true;
            }
            if (zzja == 65534) {
                zzos.zzbi(24);
                return zzos.readLong() == zzkc.zzaoq.getMostSignificantBits() && zzos.readLong() == zzkc.zzaoq.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhi("Error parsing MS/ACM codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) throws zzhi {
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[(bArr.length - i9)];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzhi("Error parsing vorbis codec private");
                    }
                    throw new zzhi("Error parsing vorbis codec private");
                }
                throw new zzhi("Error parsing vorbis codec private");
            }
            throw new zzhi("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhi("Error parsing vorbis codec private");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01cd, code lost:
        r25 = r1;
        r1 = "audio/raw";
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0222, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x022a, code lost:
        r1 = r14;
        r3 = null;
        r25 = -1;
        r30 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x023b, code lost:
        r3 = r1;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0292, code lost:
        r41 = r3;
        r3 = r1;
        r1 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ab, code lost:
        r25 = -1;
        r30 = -1;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02f7, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02f9, code lost:
        r25 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02fb, code lost:
        r30 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02fd, code lost:
        r5 = r0.zzarr | false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0302, code lost:
        if (r0.zzarq == false) goto L_0x0306;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0304, code lost:
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0306, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0307, code lost:
        r5 = r5 | r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x030c, code lost:
        if (com.google.android.gms.internal.ads.zzoo.zzbd(r1) == false) goto L_0x0335;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x030e, code lost:
        r1 = com.google.android.gms.internal.ads.zzhf.zza(java.lang.Integer.toString(r44), r1, (java.lang.String) null, -1, r30, r0.zzags, r0.zzagt, r25, r3, r0.zzagl, r5 ? 1 : 0, r0.zzagz);
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0339, code lost:
        if (com.google.android.gms.internal.ads.zzoo.zzbe(r1) == false) goto L_0x0464;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x033d, code lost:
        if (r0.zzaqw != 0) goto L_0x034f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x033f, code lost:
        r2 = r0.zzaqu;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0341, code lost:
        if (r2 != -1) goto L_0x0345;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0343, code lost:
        r2 = r0.width;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0345, code lost:
        r0.zzaqu = r2;
        r2 = r0.zzaqv;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0349, code lost:
        if (r2 != -1) goto L_0x034d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x034b, code lost:
        r2 = r0.height;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x034d, code lost:
        r0.zzaqv = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x034f, code lost:
        r2 = r0.zzaqu;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0353, code lost:
        if (r2 == -1) goto L_0x0367;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0355, code lost:
        r5 = r0.zzaqv;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0357, code lost:
        if (r5 == -1) goto L_0x0367;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0359, code lost:
        r36 = ((float) (r0.height * r2)) / ((float) (r0.width * r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0367, code lost:
        r36 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x036b, code lost:
        if (r0.zzaqx == false) goto L_0x0438;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0371, code lost:
        if (r0.zzard == -1.0f) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0377, code lost:
        if (r0.zzare == -1.0f) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x037d, code lost:
        if (r0.zzarf == -1.0f) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0383, code lost:
        if (r0.zzarg == -1.0f) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0389, code lost:
        if (r0.zzarh == -1.0f) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x038f, code lost:
        if (r0.zzari == -1.0f) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0395, code lost:
        if (r0.zzarj == -1.0f) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x039b, code lost:
        if (r0.zzark == -1.0f) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03a1, code lost:
        if (r0.zzarl == -1.0f) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03a7, code lost:
        if (r0.zzarm != -1.0f) goto L_0x03ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03ab, code lost:
        r2 = new byte[25];
        r4 = java.nio.ByteBuffer.wrap(r2);
        r4.put((byte) 0);
        r4.putShort((short) ((int) ((r0.zzard * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r0.zzare * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r0.zzarf * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r0.zzarg * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r0.zzarh * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r0.zzari * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r0.zzarj * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r0.zzark * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) (r0.zzarl + 0.5f)));
        r4.putShort((short) ((int) (r0.zzarm + 0.5f)));
        r4.putShort((short) r0.zzarb);
        r4.putShort((short) r0.zzarc);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0428, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x042a, code lost:
        r39 = new com.google.android.gms.internal.ads.zzpa(r0.zzaqy, r0.zzara, r0.zzaqz, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0438, code lost:
        r39 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x043a, code lost:
        r1 = com.google.android.gms.internal.ads.zzhf.zza(java.lang.Integer.toString(r44), r1, (java.lang.String) null, -1, r30, r0.width, r0.height, -1.0f, r3, -1, r36, r0.zzagq, r0.zzagp, r39, r0.zzagl);
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0468, code lost:
        if ("application/x-subrip".equals(r1) == false) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x046a, code lost:
        r1 = com.google.android.gms.internal.ads.zzhf.zza(java.lang.Integer.toString(r44), r1, (java.lang.String) null, -1, r5 ? 1 : 0, r0.zzagz, r0.zzagl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0482, code lost:
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0488, code lost:
        if ("application/vobsub".equals(r1) != false) goto L_0x049f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x048e, code lost:
        if ("application/pgs".equals(r1) != false) goto L_0x049f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0494, code lost:
        if ("application/dvbsubs".equals(r1) == false) goto L_0x0497;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x049e, code lost:
        throw new com.google.android.gms.internal.ads.zzhi("Unexpected MIME type.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x049f, code lost:
        r1 = com.google.android.gms.internal.ads.zzhf.zza(java.lang.Integer.toString(r44), r1, (java.lang.String) null, -1, r3, r0.zzagz, r0.zzagl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x04b8, code lost:
        r2 = r43.zzc(r0.number, r6);
        r0.zzars = r2;
        r2.zze(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x04c5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01b3, code lost:
        r5.append("Unsupported PCM bit depth: ");
        r5.append(r1);
        r5.append(". Setting mimeType to ");
        r5.append("audio/x-unknown");
        r1 = r5.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01c7, code lost:
        android.util.Log.w("MatroskaExtractor", r1);
        r1 = "audio/x-unknown";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzjo r43, int r44) throws com.google.android.gms.internal.ads.zzhi {
        /*
            r42 = this;
            r0 = r42
            java.lang.String r1 = r0.zzaqo
            int r2 = r1.hashCode()
            r4 = 4
            r5 = 8
            r6 = 1
            r7 = 2
            r8 = 0
            r9 = 3
            r10 = -1
            switch(r2) {
                case -2095576542: goto L_0x014a;
                case -2095575984: goto L_0x0140;
                case -1985379776: goto L_0x0135;
                case -1784763192: goto L_0x012a;
                case -1730367663: goto L_0x011f;
                case -1482641358: goto L_0x0114;
                case -1482641357: goto L_0x0109;
                case -1373388978: goto L_0x00fe;
                case -933872740: goto L_0x00f3;
                case -538363189: goto L_0x00e8;
                case -538363109: goto L_0x00dd;
                case -425012669: goto L_0x00d1;
                case -356037306: goto L_0x00c5;
                case 62923557: goto L_0x00b9;
                case 62923603: goto L_0x00ad;
                case 62927045: goto L_0x00a1;
                case 82338133: goto L_0x0096;
                case 82338134: goto L_0x008b;
                case 99146302: goto L_0x007f;
                case 444813526: goto L_0x0073;
                case 542569478: goto L_0x0067;
                case 725957860: goto L_0x005b;
                case 855502857: goto L_0x0050;
                case 1422270023: goto L_0x0044;
                case 1809237540: goto L_0x0039;
                case 1950749482: goto L_0x002d;
                case 1950789798: goto L_0x0021;
                case 1951062397: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0154
        L_0x0015:
            java.lang.String r2 = "A_OPUS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 11
            goto L_0x0155
        L_0x0021:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 21
            goto L_0x0155
        L_0x002d:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 16
            goto L_0x0155
        L_0x0039:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 2
            goto L_0x0155
        L_0x0044:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 24
            goto L_0x0155
        L_0x0050:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 7
            goto L_0x0155
        L_0x005b:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 23
            goto L_0x0155
        L_0x0067:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 19
            goto L_0x0155
        L_0x0073:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 9
            goto L_0x0155
        L_0x007f:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 26
            goto L_0x0155
        L_0x008b:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 1
            goto L_0x0155
        L_0x0096:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 0
            goto L_0x0155
        L_0x00a1:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 18
            goto L_0x0155
        L_0x00ad:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 15
            goto L_0x0155
        L_0x00b9:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 12
            goto L_0x0155
        L_0x00c5:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 20
            goto L_0x0155
        L_0x00d1:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 25
            goto L_0x0155
        L_0x00dd:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 6
            goto L_0x0155
        L_0x00e8:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 4
            goto L_0x0155
        L_0x00f3:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 27
            goto L_0x0155
        L_0x00fe:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 8
            goto L_0x0155
        L_0x0109:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 14
            goto L_0x0155
        L_0x0114:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 13
            goto L_0x0155
        L_0x011f:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 10
            goto L_0x0155
        L_0x012a:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 17
            goto L_0x0155
        L_0x0135:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 22
            goto L_0x0155
        L_0x0140:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 3
            goto L_0x0155
        L_0x014a:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 5
            goto L_0x0155
        L_0x0154:
            r1 = -1
        L_0x0155:
            java.lang.String r2 = "application/dvbsubs"
            java.lang.String r11 = "application/pgs"
            java.lang.String r12 = "application/vobsub"
            java.lang.String r13 = "application/x-subrip"
            java.lang.String r14 = "audio/raw"
            java.lang.String r16 = "video/x-unknown"
            java.lang.String r15 = "audio/x-unknown"
            java.lang.String r3 = "MatroskaExtractor"
            r17 = 0
            switch(r1) {
                case 0: goto L_0x02f5;
                case 1: goto L_0x02f2;
                case 2: goto L_0x02ef;
                case 3: goto L_0x02e1;
                case 4: goto L_0x02e1;
                case 5: goto L_0x02e1;
                case 6: goto L_0x02cd;
                case 7: goto L_0x02b9;
                case 8: goto L_0x029c;
                case 9: goto L_0x0299;
                case 10: goto L_0x0284;
                case 11: goto L_0x023f;
                case 12: goto L_0x0233;
                case 13: goto L_0x0228;
                case 14: goto L_0x0225;
                case 15: goto L_0x0220;
                case 16: goto L_0x021d;
                case 17: goto L_0x021a;
                case 18: goto L_0x0217;
                case 19: goto L_0x0217;
                case 20: goto L_0x0214;
                case 21: goto L_0x020b;
                case 22: goto L_0x01d4;
                case 23: goto L_0x019e;
                case 24: goto L_0x019b;
                case 25: goto L_0x0191;
                case 26: goto L_0x018e;
                case 27: goto L_0x0172;
                default: goto L_0x016a;
            }
        L_0x016a:
            com.google.android.gms.internal.ads.zzhi r1 = new com.google.android.gms.internal.ads.zzhi
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2)
            throw r1
        L_0x0172:
            byte[] r1 = new byte[r4]
            byte[] r3 = r0.zzaqt
            byte r4 = r3[r8]
            r1[r8] = r4
            byte r4 = r3[r6]
            r1[r6] = r4
            byte r4 = r3[r7]
            r1[r7] = r4
            byte r3 = r3[r9]
            r1[r9] = r3
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r3 = r1
            r1 = r2
            goto L_0x02f9
        L_0x018e:
            r1 = r11
            goto L_0x02f7
        L_0x0191:
            byte[] r1 = r0.zzaqt
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r3 = r1
            r1 = r12
            goto L_0x02f9
        L_0x019b:
            r1 = r13
            goto L_0x02f7
        L_0x019e:
            int r1 = r0.zzarn
            int r1 = com.google.android.gms.internal.ads.zzov.zzbl(r1)
            if (r1 != 0) goto L_0x01cd
            int r1 = r0.zzarn
            int r4 = r15.length()
            int r4 = r4 + 60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
        L_0x01b3:
            java.lang.String r4 = "Unsupported PCM bit depth: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = ". Setting mimeType to "
            r5.append(r1)
            r5.append(r15)
            java.lang.String r1 = r5.toString()
        L_0x01c7:
            android.util.Log.w(r3, r1)
            r1 = r15
            goto L_0x02f7
        L_0x01cd:
            r25 = r1
            r1 = r14
            r3 = r17
            goto L_0x02fb
        L_0x01d4:
            com.google.android.gms.internal.ads.zzos r1 = new com.google.android.gms.internal.ads.zzos
            byte[] r4 = r0.zzaqt
            r1.<init>((byte[]) r4)
            boolean r1 = zzb(r1)
            if (r1 == 0) goto L_0x01f7
            int r1 = r0.zzarn
            int r1 = com.google.android.gms.internal.ads.zzov.zzbl(r1)
            if (r1 != 0) goto L_0x01cd
            int r1 = r0.zzarn
            int r4 = r15.length()
            int r4 = r4 + 60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            goto L_0x01b3
        L_0x01f7:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
            int r4 = r15.length()
            if (r4 == 0) goto L_0x0204
            java.lang.String r1 = r1.concat(r15)
            goto L_0x01c7
        L_0x0204:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r1)
            r1 = r4
            goto L_0x01c7
        L_0x020b:
            byte[] r1 = r0.zzaqt
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r14 = "audio/x-flac"
            goto L_0x023b
        L_0x0214:
            java.lang.String r14 = "audio/vnd.dts.hd"
            goto L_0x0222
        L_0x0217:
            java.lang.String r14 = "audio/vnd.dts"
            goto L_0x0222
        L_0x021a:
            java.lang.String r14 = "audio/true-hd"
            goto L_0x0222
        L_0x021d:
            java.lang.String r14 = "audio/eac3"
            goto L_0x0222
        L_0x0220:
            java.lang.String r14 = "audio/ac3"
        L_0x0222:
            r1 = r14
            goto L_0x02f7
        L_0x0225:
            java.lang.String r14 = "audio/mpeg"
            goto L_0x022a
        L_0x0228:
            java.lang.String r14 = "audio/mpeg-L2"
        L_0x022a:
            r1 = r14
            r3 = r17
            r25 = -1
            r30 = 4096(0x1000, float:5.74E-42)
            goto L_0x02fd
        L_0x0233:
            byte[] r1 = r0.zzaqt
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r14 = "audio/mp4a-latm"
        L_0x023b:
            r3 = r1
            r1 = r14
            goto L_0x02f9
        L_0x023f:
            r15 = 5760(0x1680, float:8.071E-42)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r9)
            byte[] r3 = r0.zzaqt
            r1.add(r3)
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r3 = r3.order(r4)
            long r6 = r0.zzaro
            java.nio.ByteBuffer r3 = r3.putLong(r6)
            byte[] r3 = r3.array()
            r1.add(r3)
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r5 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r3 = r3.order(r5)
            long r5 = r0.zzarp
            java.nio.ByteBuffer r3 = r3.putLong(r5)
            byte[] r3 = r3.array()
            r1.add(r3)
            java.lang.String r3 = "audio/opus"
            r25 = -1
            r30 = 5760(0x1680, float:8.071E-42)
            goto L_0x0292
        L_0x0284:
            r15 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = r0.zzaqt
            java.util.List r1 = zzd(r1)
            java.lang.String r3 = "audio/vorbis"
            r25 = -1
            r30 = 8192(0x2000, float:1.14794E-41)
        L_0x0292:
            r41 = r3
            r3 = r1
            r1 = r41
            goto L_0x02fd
        L_0x0299:
            r1 = r16
            goto L_0x02f7
        L_0x029c:
            com.google.android.gms.internal.ads.zzos r1 = new com.google.android.gms.internal.ads.zzos
            byte[] r5 = r0.zzaqt
            r1.<init>((byte[]) r5)
            java.util.List r1 = zza(r1)
            if (r1 == 0) goto L_0x02b0
            java.lang.String r3 = "video/wvc1"
        L_0x02ab:
            r25 = -1
            r30 = -1
            goto L_0x0292
        L_0x02b0:
            java.lang.String r5 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            android.util.Log.w(r3, r5)
            r3 = r1
            r1 = r16
            goto L_0x02f9
        L_0x02b9:
            com.google.android.gms.internal.ads.zzos r1 = new com.google.android.gms.internal.ads.zzos
            byte[] r3 = r0.zzaqt
            r1.<init>((byte[]) r3)
            com.google.android.gms.internal.ads.zzpd r1 = com.google.android.gms.internal.ads.zzpd.zzh(r1)
            java.util.List<byte[]> r3 = r1.zzagk
            int r1 = r1.zzart
            r0.zzart = r1
            java.lang.String r1 = "video/hevc"
            goto L_0x02f9
        L_0x02cd:
            com.google.android.gms.internal.ads.zzos r1 = new com.google.android.gms.internal.ads.zzos
            byte[] r3 = r0.zzaqt
            r1.<init>((byte[]) r3)
            com.google.android.gms.internal.ads.zzox r1 = com.google.android.gms.internal.ads.zzox.zzf(r1)
            java.util.List<byte[]> r3 = r1.zzagk
            int r1 = r1.zzart
            r0.zzart = r1
            java.lang.String r1 = "video/avc"
            goto L_0x02f9
        L_0x02e1:
            byte[] r1 = r0.zzaqt
            if (r1 != 0) goto L_0x02e8
            r1 = r17
            goto L_0x02ec
        L_0x02e8:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x02ec:
            java.lang.String r3 = "video/mp4v-es"
            goto L_0x02ab
        L_0x02ef:
            java.lang.String r1 = "video/mpeg2"
            goto L_0x02f7
        L_0x02f2:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            goto L_0x02f7
        L_0x02f5:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
        L_0x02f7:
            r3 = r17
        L_0x02f9:
            r25 = -1
        L_0x02fb:
            r30 = -1
        L_0x02fd:
            boolean r5 = r0.zzarr
            r5 = r5 | r8
            boolean r6 = r0.zzarq
            if (r6 == 0) goto L_0x0306
            r6 = 2
            goto L_0x0307
        L_0x0306:
            r6 = 0
        L_0x0307:
            r5 = r5 | r6
            boolean r6 = com.google.android.gms.internal.ads.zzoo.zzbd(r1)
            if (r6 == 0) goto L_0x0335
            java.lang.String r18 = java.lang.Integer.toString(r44)
            r20 = 0
            r21 = -1
            int r2 = r0.zzags
            int r6 = r0.zzagt
            com.google.android.gms.internal.ads.zzja r7 = r0.zzagl
            java.lang.String r8 = r0.zzagz
            r19 = r1
            r22 = r30
            r23 = r2
            r24 = r6
            r26 = r3
            r27 = r7
            r28 = r5
            r29 = r8
            com.google.android.gms.internal.ads.zzhf r1 = com.google.android.gms.internal.ads.zzhf.zza(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r6 = 1
            goto L_0x04b8
        L_0x0335:
            boolean r4 = com.google.android.gms.internal.ads.zzoo.zzbe(r1)
            if (r4 == 0) goto L_0x0464
            int r2 = r0.zzaqw
            if (r2 != 0) goto L_0x034f
            int r2 = r0.zzaqu
            if (r2 != r10) goto L_0x0345
            int r2 = r0.width
        L_0x0345:
            r0.zzaqu = r2
            int r2 = r0.zzaqv
            if (r2 != r10) goto L_0x034d
            int r2 = r0.height
        L_0x034d:
            r0.zzaqv = r2
        L_0x034f:
            int r2 = r0.zzaqu
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r10) goto L_0x0367
            int r5 = r0.zzaqv
            if (r5 == r10) goto L_0x0367
            int r6 = r0.height
            int r6 = r6 * r2
            float r2 = (float) r6
            int r6 = r0.width
            int r6 = r6 * r5
            float r5 = (float) r6
            float r2 = r2 / r5
            r36 = r2
            goto L_0x0369
        L_0x0367:
            r36 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0369:
            boolean r2 = r0.zzaqx
            if (r2 == 0) goto L_0x0438
            float r2 = r0.zzard
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0428
            float r2 = r0.zzare
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0428
            float r2 = r0.zzarf
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0428
            float r2 = r0.zzarg
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0428
            float r2 = r0.zzarh
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0428
            float r2 = r0.zzari
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0428
            float r2 = r0.zzarj
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0428
            float r2 = r0.zzark
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0428
            float r2 = r0.zzarl
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0428
            float r2 = r0.zzarm
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x03ab
            goto L_0x0428
        L_0x03ab:
            r2 = 25
            byte[] r2 = new byte[r2]
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r2)
            r4.put(r8)
            float r5 = r0.zzard
            r6 = 1195593728(0x47435000, float:50000.0)
            float r5 = r5 * r6
            r7 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzare
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarf
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarg
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarh
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzari
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarj
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzark
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarl
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarm
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            int r5 = r0.zzarb
            short r5 = (short) r5
            r4.putShort(r5)
            int r5 = r0.zzarc
            short r5 = (short) r5
            r4.putShort(r5)
            goto L_0x042a
        L_0x0428:
            r2 = r17
        L_0x042a:
            com.google.android.gms.internal.ads.zzpa r4 = new com.google.android.gms.internal.ads.zzpa
            int r5 = r0.zzaqy
            int r6 = r0.zzara
            int r7 = r0.zzaqz
            r4.<init>(r5, r6, r7, r2)
            r39 = r4
            goto L_0x043a
        L_0x0438:
            r39 = r17
        L_0x043a:
            java.lang.String r26 = java.lang.Integer.toString(r44)
            r28 = 0
            r29 = -1
            int r2 = r0.width
            int r4 = r0.height
            r33 = -1082130432(0xffffffffbf800000, float:-1.0)
            r35 = -1
            byte[] r5 = r0.zzagq
            int r6 = r0.zzagp
            com.google.android.gms.internal.ads.zzja r7 = r0.zzagl
            r27 = r1
            r31 = r2
            r32 = r4
            r34 = r3
            r37 = r5
            r38 = r6
            r40 = r7
            com.google.android.gms.internal.ads.zzhf r1 = com.google.android.gms.internal.ads.zzhf.zza(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            r6 = 2
            goto L_0x04b8
        L_0x0464:
            boolean r4 = r13.equals(r1)
            if (r4 == 0) goto L_0x0484
            java.lang.String r18 = java.lang.Integer.toString(r44)
            r20 = 0
            r21 = -1
            java.lang.String r2 = r0.zzagz
            com.google.android.gms.internal.ads.zzja r3 = r0.zzagl
            r19 = r1
            r22 = r5
            r23 = r2
            r24 = r3
            com.google.android.gms.internal.ads.zzhf r1 = com.google.android.gms.internal.ads.zzhf.zza((java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (int) r21, (int) r22, (java.lang.String) r23, (com.google.android.gms.internal.ads.zzja) r24)
        L_0x0482:
            r6 = 3
            goto L_0x04b8
        L_0x0484:
            boolean r4 = r12.equals(r1)
            if (r4 != 0) goto L_0x049f
            boolean r4 = r11.equals(r1)
            if (r4 != 0) goto L_0x049f
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x0497
            goto L_0x049f
        L_0x0497:
            com.google.android.gms.internal.ads.zzhi r1 = new com.google.android.gms.internal.ads.zzhi
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2)
            throw r1
        L_0x049f:
            java.lang.String r18 = java.lang.Integer.toString(r44)
            r20 = 0
            r21 = -1
            java.lang.String r2 = r0.zzagz
            com.google.android.gms.internal.ads.zzja r4 = r0.zzagl
            r19 = r1
            r22 = r3
            r23 = r2
            r24 = r4
            com.google.android.gms.internal.ads.zzhf r1 = com.google.android.gms.internal.ads.zzhf.zza((java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (int) r21, (java.util.List<byte[]>) r22, (java.lang.String) r23, (com.google.android.gms.internal.ads.zzja) r24)
            goto L_0x0482
        L_0x04b8:
            int r2 = r0.number
            r3 = r43
            com.google.android.gms.internal.ads.zzjt r2 = r3.zzc(r2, r6)
            r0.zzars = r2
            r2.zze(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkd.zza(com.google.android.gms.internal.ads.zzjo, int):void");
    }
}
