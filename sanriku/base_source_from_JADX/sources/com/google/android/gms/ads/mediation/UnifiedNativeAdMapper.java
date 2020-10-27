package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

public class UnifiedNativeAdMapper {
    private Bundle extras = new Bundle();
    private VideoController zzcgy;
    private String zzdnr;
    private String zzemc;
    private List<NativeAd.Image> zzemd;
    private NativeAd.Image zzeme;
    private String zzemf;
    private String zzemh;
    private String zzemi;
    private View zzemj;
    private boolean zzemk;
    private String zzemm;
    private Double zzemn;
    private View zzemo;
    private Object zzemp;
    private boolean zzemq;
    private boolean zzemr;
    private float zzems;

    public View getAdChoicesContent() {
        return this.zzemo;
    }

    public final String getAdvertiser() {
        return this.zzemm;
    }

    public final String getBody() {
        return this.zzdnr;
    }

    public final String getCallToAction() {
        return this.zzemf;
    }

    public float getCurrentTime() {
        return 0.0f;
    }

    public float getDuration() {
        return 0.0f;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getHeadline() {
        return this.zzemc;
    }

    public final NativeAd.Image getIcon() {
        return this.zzeme;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzemd;
    }

    public float getMediaContentAspectRatio() {
        return this.zzems;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzemr;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzemq;
    }

    public final String getPrice() {
        return this.zzemi;
    }

    public final Double getStarRating() {
        return this.zzemn;
    }

    public final String getStore() {
        return this.zzemh;
    }

    public final VideoController getVideoController() {
        return this.zzcgy;
    }

    public void handleClick(View view) {
    }

    public boolean hasVideoContent() {
        return this.zzemk;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.zzemo = view;
    }

    public final void setAdvertiser(String str) {
        this.zzemm = str;
    }

    public final void setBody(String str) {
        this.zzdnr = str;
    }

    public final void setCallToAction(String str) {
        this.zzemf = str;
    }

    public final void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public void setHasVideoContent(boolean z) {
        this.zzemk = z;
    }

    public final void setHeadline(String str) {
        this.zzemc = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.zzeme = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzemd = list;
    }

    public void setMediaContentAspectRatio(float f) {
        this.zzems = f;
    }

    public void setMediaView(View view) {
        this.zzemj = view;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.zzemr = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.zzemq = z;
    }

    public final void setPrice(String str) {
        this.zzemi = str;
    }

    public final void setStarRating(Double d) {
        this.zzemn = d;
    }

    public final void setStore(String str) {
        this.zzemh = str;
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void zza(VideoController videoController) {
        this.zzcgy = videoController;
    }

    public final View zzacu() {
        return this.zzemj;
    }

    public final Object zzjv() {
        return this.zzemp;
    }

    public final void zzn(Object obj) {
        this.zzemp = obj;
    }
}
