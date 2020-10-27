package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzdnr;
    private String zzemc;
    private List<NativeAd.Image> zzemd;
    private NativeAd.Image zzeme;
    private String zzemf;
    private double zzemg;
    private String zzemh;
    private String zzemi;

    public final String getBody() {
        return this.zzdnr;
    }

    public final String getCallToAction() {
        return this.zzemf;
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

    public final String getPrice() {
        return this.zzemi;
    }

    public final double getStarRating() {
        return this.zzemg;
    }

    public final String getStore() {
        return this.zzemh;
    }

    public final void setBody(String str) {
        this.zzdnr = str;
    }

    public final void setCallToAction(String str) {
        this.zzemf = str;
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

    public final void setPrice(String str) {
        this.zzemi = str;
    }

    public final void setStarRating(double d) {
        this.zzemg = d;
    }

    public final void setStore(String str) {
        this.zzemh = str;
    }
}
