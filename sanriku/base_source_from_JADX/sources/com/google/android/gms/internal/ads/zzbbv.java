package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import p009e.p010a.p011a.p012a.C0681a;

@TargetApi(14)
public final class zzbbv extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzbbw {
    private static final float[] zzecs = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int height;
    private int width;
    private final float[] zzecp = new float[9];
    private final zzbbu zzect;
    private final float[] zzecu = new float[9];
    private final float[] zzecv = new float[9];
    private final float[] zzecw = new float[9];
    private final float[] zzecx = new float[9];
    private final float[] zzecy = new float[9];
    private final float[] zzecz = new float[9];
    private float zzeda = Float.NaN;
    private float zzedb;
    private float zzedc;
    private SurfaceTexture zzedd;
    private SurfaceTexture zzede;
    private int zzedf;
    private int zzedg;
    private int zzedh;
    private FloatBuffer zzedi;
    private final CountDownLatch zzedj;
    private final Object zzedk;
    private EGL10 zzedl;
    private EGLDisplay zzedm;
    private EGLContext zzedn;
    private EGLSurface zzedo;
    private volatile boolean zzedp;
    private volatile boolean zzedq;

    public zzbbv(Context context) {
        super("SphericalVideoProcessor");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(zzecs.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzedi = asFloatBuffer;
        asFloatBuffer.put(zzecs).position(0);
        zzbbu zzbbu = new zzbbu(context);
        this.zzect = zzbbu;
        zzbbu.zza((zzbbw) this);
        this.zzedj = new CountDownLatch(1);
        this.zzedk = new Object();
    }

    private static void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        float f = fArr2[1] * fArr3[3];
        fArr[0] = (fArr2[2] * fArr3[6]) + f + (fArr2[0] * fArr3[0]);
        fArr[1] = (fArr2[2] * fArr3[7]) + (fArr2[1] * fArr3[4]) + (fArr2[0] * fArr3[1]);
        fArr[2] = (fArr2[2] * fArr3[8]) + (fArr2[1] * fArr3[5]) + (fArr2[0] * fArr3[2]);
        fArr[3] = (fArr2[5] * fArr3[6]) + (fArr2[4] * fArr3[3]) + (fArr2[3] * fArr3[0]);
        fArr[4] = (fArr2[5] * fArr3[7]) + (fArr2[4] * fArr3[4]) + (fArr2[3] * fArr3[1]);
        fArr[5] = (fArr2[5] * fArr3[8]) + (fArr2[4] * fArr3[5]) + (fArr2[3] * fArr3[2]);
        fArr[6] = (fArr2[8] * fArr3[6]) + (fArr2[7] * fArr3[3]) + (fArr2[6] * fArr3[0]);
        fArr[7] = (fArr2[8] * fArr3[7]) + (fArr2[7] * fArr3[4]) + (fArr2[6] * fArr3[1]);
        float f2 = fArr2[6] * fArr3[2];
        fArr[8] = (fArr2[8] * fArr3[8]) + (fArr2[7] * fArr3[5]) + f2;
    }

    private static void zzb(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static int zzd(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzfg("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        zzfg("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        zzfg("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        zzfg("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        Log.e("SphericalVideoRenderer", sb.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        zzfg("deleteShader");
        return 0;
    }

    private static void zzfg(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(C0681a.m336b(str, 21));
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    @VisibleForTesting
    private final boolean zzzd() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzedo;
        boolean z = false;
        if (!(eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE))) {
            z = this.zzedl.eglDestroySurface(this.zzedm, this.zzedo) | this.zzedl.eglMakeCurrent(this.zzedm, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT) | false;
            this.zzedo = null;
        }
        EGLContext eGLContext = this.zzedn;
        if (eGLContext != null) {
            z |= this.zzedl.eglDestroyContext(this.zzedm, eGLContext);
            this.zzedn = null;
        }
        EGLDisplay eGLDisplay = this.zzedm;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.zzedl.eglTerminate(eGLDisplay);
        this.zzedm = null;
        return eglTerminate;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzedh++;
        synchronized (this.zzedk) {
            this.zzedk.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01cf A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            android.graphics.SurfaceTexture r0 = r14.zzede
            if (r0 != 0) goto L_0x000f
            java.lang.String r0 = "SphericalVideoProcessor started with no output texture."
            com.google.android.gms.internal.ads.zzazw.zzfa(r0)
            java.util.concurrent.CountDownLatch r0 = r14.zzedj
            r0.countDown()
            return
        L_0x000f:
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            javax.microedition.khronos.egl.EGL10 r0 = (javax.microedition.khronos.egl.EGL10) r0
            r14.zzedl = r0
            java.lang.Object r1 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY
            javax.microedition.khronos.egl.EGLDisplay r0 = r0.eglGetDisplay(r1)
            r14.zzedm = r0
            javax.microedition.khronos.egl.EGLDisplay r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r0 != r1) goto L_0x002b
        L_0x0028:
            r0 = 0
            goto L_0x0092
        L_0x002b:
            int[] r1 = new int[r3]
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzedl
            boolean r0 = r7.eglInitialize(r0, r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x0028
        L_0x0036:
            int[] r0 = new int[r5]
            javax.microedition.khronos.egl.EGLConfig[] r1 = new javax.microedition.khronos.egl.EGLConfig[r5]
            r7 = 11
            int[] r9 = new int[r7]
            r9 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzedl
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzedm
            r11 = 1
            r10 = r1
            r12 = r0
            boolean r7 = r7.eglChooseConfig(r8, r9, r10, r11, r12)
            if (r7 == 0) goto L_0x0055
            r0 = r0[r6]
            if (r0 <= 0) goto L_0x0055
            r0 = r1[r6]
            goto L_0x0056
        L_0x0055:
            r0 = r4
        L_0x0056:
            if (r0 != 0) goto L_0x0059
            goto L_0x0028
        L_0x0059:
            int[] r1 = new int[r2]
            r1 = {12440, 2, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzedl
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzedm
            javax.microedition.khronos.egl.EGLContext r9 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            javax.microedition.khronos.egl.EGLContext r1 = r7.eglCreateContext(r8, r0, r9, r1)
            r14.zzedn = r1
            if (r1 == 0) goto L_0x0028
            javax.microedition.khronos.egl.EGLContext r7 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            if (r1 != r7) goto L_0x0071
            goto L_0x0028
        L_0x0071:
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzedl
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzedm
            android.graphics.SurfaceTexture r8 = r14.zzede
            javax.microedition.khronos.egl.EGLSurface r0 = r1.eglCreateWindowSurface(r7, r0, r8, r4)
            r14.zzedo = r0
            if (r0 == 0) goto L_0x0028
            javax.microedition.khronos.egl.EGLSurface r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r0 != r1) goto L_0x0084
            goto L_0x0028
        L_0x0084:
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzedl
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzedm
            javax.microedition.khronos.egl.EGLContext r8 = r14.zzedn
            boolean r0 = r1.eglMakeCurrent(r7, r0, r0, r8)
            if (r0 != 0) goto L_0x0091
            goto L_0x0028
        L_0x0091:
            r0 = 1
        L_0x0092:
            r1 = 35633(0x8b31, float:4.9932E-41)
            com.google.android.gms.internal.ads.zzzk<java.lang.String> r7 = com.google.android.gms.internal.ads.zzzz.zzcmr
            com.google.android.gms.internal.ads.zzzv r8 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r8 = r8.zzd(r7)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r7.zzqz()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzzv r8 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r7 = r8.zzd(r7)
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00b8
        L_0x00b6:
            java.lang.String r7 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}"
        L_0x00b8:
            int r1 = zzd(r1, r7)
            if (r1 != 0) goto L_0x00c1
        L_0x00be:
            r8 = 0
            goto L_0x0143
        L_0x00c1:
            r7 = 35632(0x8b30, float:4.9931E-41)
            com.google.android.gms.internal.ads.zzzk<java.lang.String> r8 = com.google.android.gms.internal.ads.zzzz.zzcms
            com.google.android.gms.internal.ads.zzzv r9 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r9 = r9.zzd(r8)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r8.zzqz()
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzzv r9 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r8 = r9.zzd(r8)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00e7
        L_0x00e5:
            java.lang.String r8 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}"
        L_0x00e7:
            int r7 = zzd(r7, r8)
            if (r7 != 0) goto L_0x00ee
            goto L_0x00be
        L_0x00ee:
            int r8 = android.opengl.GLES20.glCreateProgram()
            java.lang.String r9 = "createProgram"
            zzfg(r9)
            if (r8 == 0) goto L_0x0143
            android.opengl.GLES20.glAttachShader(r8, r1)
            java.lang.String r1 = "attachShader"
            zzfg(r1)
            android.opengl.GLES20.glAttachShader(r8, r7)
            java.lang.String r1 = "attachShader"
            zzfg(r1)
            android.opengl.GLES20.glLinkProgram(r8)
            java.lang.String r1 = "linkProgram"
            zzfg(r1)
            int[] r1 = new int[r5]
            r7 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r8, r7, r1, r6)
            java.lang.String r7 = "getProgramiv"
            zzfg(r7)
            r1 = r1[r6]
            if (r1 == r5) goto L_0x013b
            java.lang.String r1 = "SphericalVideoRenderer"
            java.lang.String r7 = "Could not link program: "
            android.util.Log.e(r1, r7)
            java.lang.String r1 = android.opengl.GLES20.glGetProgramInfoLog(r8)
            java.lang.String r7 = "SphericalVideoRenderer"
            android.util.Log.e(r7, r1)
            android.opengl.GLES20.glDeleteProgram(r8)
            java.lang.String r1 = "deleteProgram"
            zzfg(r1)
            goto L_0x00be
        L_0x013b:
            android.opengl.GLES20.glValidateProgram(r8)
            java.lang.String r1 = "validateProgram"
            zzfg(r1)
        L_0x0143:
            r14.zzedf = r8
            android.opengl.GLES20.glUseProgram(r8)
            java.lang.String r1 = "useProgram"
            zzfg(r1)
            int r1 = r14.zzedf
            java.lang.String r7 = "aPosition"
            int r1 = android.opengl.GLES20.glGetAttribLocation(r1, r7)
            r9 = 3
            r10 = 5126(0x1406, float:7.183E-42)
            r11 = 0
            r12 = 12
            java.nio.FloatBuffer r13 = r14.zzedi
            r8 = r1
            android.opengl.GLES20.glVertexAttribPointer(r8, r9, r10, r11, r12, r13)
            java.lang.String r7 = "vertexAttribPointer"
            zzfg(r7)
            android.opengl.GLES20.glEnableVertexAttribArray(r1)
            java.lang.String r1 = "enableVertexAttribArray"
            zzfg(r1)
            int[] r1 = new int[r5]
            android.opengl.GLES20.glGenTextures(r5, r1, r6)
            java.lang.String r7 = "genTextures"
            zzfg(r7)
            r1 = r1[r6]
            r7 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r7, r1)
            java.lang.String r8 = "bindTextures"
            zzfg(r8)
            r8 = 10240(0x2800, float:1.4349E-41)
            r9 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzfg(r8)
            r8 = 10241(0x2801, float:1.435E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzfg(r8)
            r8 = 10242(0x2802, float:1.4352E-41)
            r9 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzfg(r8)
            r8 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r7 = "texParameteri"
            zzfg(r7)
            int r7 = r14.zzedf
            java.lang.String r8 = "uVMat"
            int r7 = android.opengl.GLES20.glGetUniformLocation(r7, r8)
            r14.zzedg = r7
            r8 = 9
            float[] r8 = new float[r8]
            r8 = {1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216} // fill-array
            android.opengl.GLES20.glUniformMatrix3fv(r7, r5, r6, r8, r6)
            int r7 = r14.zzedf
            if (r7 == 0) goto L_0x01cc
            r7 = 1
            goto L_0x01cd
        L_0x01cc:
            r7 = 0
        L_0x01cd:
            if (r0 == 0) goto L_0x038c
            if (r7 != 0) goto L_0x01d3
            goto L_0x038c
        L_0x01d3:
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture
            r0.<init>(r1)
            r14.zzedd = r0
            r0.setOnFrameAvailableListener(r14)
            java.util.concurrent.CountDownLatch r0 = r14.zzedj
            r0.countDown()
            com.google.android.gms.internal.ads.zzbbu r0 = r14.zzect
            r0.start()
            r14.zzedp = r5     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
        L_0x01e9:
            boolean r0 = r14.zzedq     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            if (r0 != 0) goto L_0x0337
        L_0x01ed:
            int r0 = r14.zzedh     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            if (r0 <= 0) goto L_0x01fc
            android.graphics.SurfaceTexture r0 = r14.zzedd     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r0.updateTexImage()     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            int r0 = r14.zzedh     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            int r0 = r0 - r5
            r14.zzedh = r0     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            goto L_0x01ed
        L_0x01fc:
            com.google.android.gms.internal.ads.zzbbu r0 = r14.zzect     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r1 = r14.zzecp     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            boolean r0 = r0.zza((float[]) r1)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r1 = 5
            r7 = 4
            r8 = 1070141403(0x3fc90fdb, float:1.5707964)
            if (r0 == 0) goto L_0x0282
            float r0 = r14.zzeda     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            boolean r0 = java.lang.Float.isNaN(r0)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            if (r0 == 0) goto L_0x0277
            float[] r0 = r14.zzecp     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r9 = new float[r2]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r10 = 0
            r9[r6] = r10     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r11 = 1065353216(0x3f800000, float:1.0)
            r9[r5] = r11     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r9[r3] = r10     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r10 = new float[r2]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r11 = r0[r6]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r11 = r11 * r12
            r12 = r0[r5]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r12 = r12 * r13
            float r12 = r12 + r11
            r11 = r0[r3]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r13 = r9[r3]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r11 = r11 * r13
            float r11 = r11 + r12
            r10[r6] = r11     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r11 = r0[r2]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r11 = r11 * r12
            r12 = r0[r7]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r12 = r12 * r13
            float r12 = r12 + r11
            r11 = r0[r1]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r13 = r9[r3]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r11 = r11 * r13
            float r11 = r11 + r12
            r10[r5] = r11     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r11 = 6
            r11 = r0[r11]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r11 = r11 * r12
            r12 = 7
            r12 = r0[r12]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r12 = r12 * r13
            float r12 = r12 + r11
            r11 = 8
            r0 = r0[r11]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r9 = r9[r3]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r0 = r0 * r9
            float r0 = r0 + r12
            r10[r3] = r0     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r0 = r10[r5]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            double r11 = (double) r0     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r0 = r10[r6]     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            double r9 = (double) r0     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            double r9 = java.lang.Math.atan2(r11, r9)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r0 = (float) r9     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r0 = r0 - r8
            float r0 = -r0
            r14.zzeda = r0     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
        L_0x0277:
            float[] r0 = r14.zzecy     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r9 = r14.zzeda     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r10 = r14.zzedb     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r9 = r9 + r10
            zzb((float[]) r0, (float) r9)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            goto L_0x0291
        L_0x0282:
            float[] r0 = r14.zzecp     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r9 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            zza(r0, r9)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r0 = r14.zzecy     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r9 = r14.zzedb     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            zzb((float[]) r0, (float) r9)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
        L_0x0291:
            float[] r0 = r14.zzecu     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            zza(r0, r8)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r0 = r14.zzecv     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r8 = r14.zzecy     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r9 = r14.zzecu     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            zza((float[]) r0, (float[]) r8, (float[]) r9)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r0 = r14.zzecw     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r8 = r14.zzecp     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r9 = r14.zzecv     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            zza((float[]) r0, (float[]) r8, (float[]) r9)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r0 = r14.zzecx     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r8 = r14.zzedc     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            zza(r0, r8)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r0 = r14.zzecz     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r8 = r14.zzecx     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r9 = r14.zzecw     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            zza((float[]) r0, (float[]) r8, (float[]) r9)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            int r0 = r14.zzedg     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float[] r8 = r14.zzecz     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            android.opengl.GLES20.glUniformMatrix3fv(r0, r5, r6, r8, r6)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            android.opengl.GLES20.glDrawArrays(r1, r6, r7)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            java.lang.String r0 = "drawArrays"
            zzfg(r0)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            android.opengl.GLES20.glFinish()     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzedl     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            javax.microedition.khronos.egl.EGLDisplay r1 = r14.zzedm     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            javax.microedition.khronos.egl.EGLSurface r7 = r14.zzedo     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r0.eglSwapBuffers(r1, r7)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            boolean r0 = r14.zzedp     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            if (r0 == 0) goto L_0x031d
            int r0 = r14.width     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            int r1 = r14.height     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            android.opengl.GLES20.glViewport(r6, r6, r0, r1)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            java.lang.String r0 = "viewport"
            zzfg(r0)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            int r0 = r14.zzedf     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            java.lang.String r1 = "uFOVx"
            int r0 = android.opengl.GLES20.glGetUniformLocation(r0, r1)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            int r1 = r14.zzedf     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            java.lang.String r7 = "uFOVy"
            int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r7)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            int r7 = r14.width     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            int r8 = r14.height     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            r9 = 1063216883(0x3f5f66f3, float:0.87266463)
            if (r7 <= r8) goto L_0x030c
            android.opengl.GLES20.glUniform1f(r0, r9)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            int r0 = r14.height     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r0 = (float) r0     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r0 = r0 * r9
            int r7 = r14.width     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r0 = r0 / r7
            android.opengl.GLES20.glUniform1f(r1, r0)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            goto L_0x031b
        L_0x030c:
            int r7 = r14.width     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r7 = r7 * r9
            int r8 = r14.height     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            float r7 = r7 / r8
            android.opengl.GLES20.glUniform1f(r0, r7)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
            android.opengl.GLES20.glUniform1f(r1, r9)     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
        L_0x031b:
            r14.zzedp = r6     // Catch:{ IllegalStateException -> 0x0366, all -> 0x0347 }
        L_0x031d:
            java.lang.Object r0 = r14.zzedk     // Catch:{ InterruptedException -> 0x01e9 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x01e9 }
            boolean r1 = r14.zzedq     // Catch:{ all -> 0x0334 }
            if (r1 != 0) goto L_0x0331
            boolean r1 = r14.zzedp     // Catch:{ all -> 0x0334 }
            if (r1 != 0) goto L_0x0331
            int r1 = r14.zzedh     // Catch:{ all -> 0x0334 }
            if (r1 != 0) goto L_0x0331
            java.lang.Object r1 = r14.zzedk     // Catch:{ all -> 0x0334 }
            r1.wait()     // Catch:{ all -> 0x0334 }
        L_0x0331:
            monitor-exit(r0)     // Catch:{ all -> 0x0334 }
            goto L_0x01e9
        L_0x0334:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0334 }
            throw r1     // Catch:{ InterruptedException -> 0x01e9 }
        L_0x0337:
            com.google.android.gms.internal.ads.zzbbu r0 = r14.zzect
            r0.stop()
            android.graphics.SurfaceTexture r0 = r14.zzedd
            r0.setOnFrameAvailableListener(r4)
            r14.zzedd = r4
            r14.zzzd()
            return
        L_0x0347:
            r0 = move-exception
            java.lang.String r1 = "SphericalVideoProcessor died."
            com.google.android.gms.internal.ads.zzazw.zzc(r1, r0)     // Catch:{ all -> 0x037b }
            com.google.android.gms.internal.ads.zzawd r1 = com.google.android.gms.ads.internal.zzq.zzla()     // Catch:{ all -> 0x037b }
            java.lang.String r2 = "SphericalVideoProcessor.run.2"
            r1.zza(r0, r2)     // Catch:{ all -> 0x037b }
            com.google.android.gms.internal.ads.zzbbu r0 = r14.zzect
            r0.stop()
            android.graphics.SurfaceTexture r0 = r14.zzedd
            r0.setOnFrameAvailableListener(r4)
            r14.zzedd = r4
            r14.zzzd()
            return
        L_0x0366:
            java.lang.String r0 = "SphericalVideoProcessor halted unexpectedly."
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)     // Catch:{ all -> 0x037b }
            com.google.android.gms.internal.ads.zzbbu r0 = r14.zzect
            r0.stop()
            android.graphics.SurfaceTexture r0 = r14.zzedd
            r0.setOnFrameAvailableListener(r4)
            r14.zzedd = r4
            r14.zzzd()
            return
        L_0x037b:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbbu r1 = r14.zzect
            r1.stop()
            android.graphics.SurfaceTexture r1 = r14.zzedd
            r1.setOnFrameAvailableListener(r4)
            r14.zzedd = r4
            r14.zzzd()
            throw r0
        L_0x038c:
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzedl
            int r0 = r0.eglGetError()
            java.lang.String r0 = android.opengl.GLUtils.getEGLErrorString(r0)
            java.lang.String r1 = "EGL initialization failed: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x03a7
            java.lang.String r0 = r1.concat(r0)
            goto L_0x03ac
        L_0x03a7:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x03ac:
            com.google.android.gms.internal.ads.zzazw.zzfa(r0)
            com.google.android.gms.internal.ads.zzawd r1 = com.google.android.gms.ads.internal.zzq.zzla()
            java.lang.Throwable r2 = new java.lang.Throwable
            r2.<init>(r0)
            java.lang.String r0 = "SphericalVideoProcessor.run.1"
            r1.zza(r2, r0)
            r14.zzzd()
            java.util.concurrent.CountDownLatch r0 = r14.zzedj
            r0.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbv.run():void");
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.zzede = surfaceTexture;
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        float f5;
        int i = this.width;
        int i2 = this.height;
        float f6 = f * 1.7453293f;
        if (i > i2) {
            f4 = f6 / ((float) i);
            f3 = f2 * 1.7453293f;
            f5 = (float) i;
        } else {
            f4 = f6 / ((float) i2);
            f3 = f2 * 1.7453293f;
            f5 = (float) i2;
        }
        this.zzedb -= f4;
        float f7 = this.zzedc - (f3 / f5);
        this.zzedc = f7;
        if (f7 < -1.5707964f) {
            this.zzedc = -1.5707964f;
        }
        if (this.zzedc > 1.5707964f) {
            this.zzedc = 1.5707964f;
        }
    }

    public final void zzm(int i, int i2) {
        synchronized (this.zzedk) {
            this.width = i;
            this.height = i2;
            this.zzedp = true;
            this.zzedk.notifyAll();
        }
    }

    public final void zzul() {
        synchronized (this.zzedk) {
            this.zzedk.notifyAll();
        }
    }

    public final void zzzb() {
        synchronized (this.zzedk) {
            this.zzedq = true;
            this.zzede = null;
            this.zzedk.notifyAll();
        }
    }

    public final SurfaceTexture zzzc() {
        if (this.zzede == null) {
            return null;
        }
        try {
            this.zzedj.await();
        } catch (InterruptedException unused) {
        }
        return this.zzedd;
    }
}
