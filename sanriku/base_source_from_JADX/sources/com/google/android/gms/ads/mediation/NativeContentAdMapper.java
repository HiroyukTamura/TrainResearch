package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
public class NativeContentAdMapper extends NativeAdMapper {
    private String zzdnr;
    private String zzemc;
    private List<NativeAd.Image> zzemd;
    private String zzemf;
    private NativeAd.Image zzeml;
    private String zzemm;

    public final String getAdvertiser() {
        return this.zzemm;
    }

    public final String getBody() {
        return this.zzdnr;
    }

    public final String getCallToAction() {
        return this.zzemf;
    }

    public final String getHeadline() {
        return this.zzemc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzemd;
    }

    public final NativeAd.Image getLogo() {
        return this.zzeml;
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

    public final void setHeadline(String str) {
        this.zzemc = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzemd = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzeml = image;
    }
}
