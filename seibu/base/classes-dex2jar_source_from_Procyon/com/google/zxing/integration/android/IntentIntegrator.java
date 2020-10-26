// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.integration.android;

import com.journeyapps.barcodescanner.CaptureActivity;
import android.content.Context;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import android.annotation.TargetApi;
import java.util.Iterator;
import android.os.Bundle;
import java.io.Serializable;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import android.app.Fragment;
import android.app.Activity;
import java.util.Collection;

public class IntentIntegrator
{
    public static final Collection<String> ALL_CODE_TYPES;
    public static final String CODE_128 = "CODE_128";
    public static final String CODE_39 = "CODE_39";
    public static final String CODE_93 = "CODE_93";
    public static final String DATA_MATRIX = "DATA_MATRIX";
    public static final String EAN_13 = "EAN_13";
    public static final String EAN_8 = "EAN_8";
    public static final String ITF = "ITF";
    public static final Collection<String> ONE_D_CODE_TYPES;
    public static final String PDF_417 = "PDF_417";
    public static final Collection<String> PRODUCT_CODE_TYPES;
    public static final String QR_CODE = "QR_CODE";
    public static final int REQUEST_CODE = 49374;
    public static final String RSS_14 = "RSS_14";
    public static final String RSS_EXPANDED = "RSS_EXPANDED";
    private static final String TAG;
    public static final String UPC_A = "UPC_A";
    public static final String UPC_E = "UPC_E";
    private final Activity activity;
    private Class<?> captureActivity;
    private Collection<String> desiredBarcodeFormats;
    private Fragment fragment;
    private final Map<String, Object> moreExtras;
    private int requestCode;
    private android.support.v4.app.Fragment supportFragment;
    
    static {
        TAG = IntentIntegrator.class.getSimpleName();
        PRODUCT_CODE_TYPES = list("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14");
        ONE_D_CODE_TYPES = list("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14", "CODE_39", "CODE_93", "CODE_128", "ITF", "RSS_14", "RSS_EXPANDED");
        ALL_CODE_TYPES = null;
    }
    
    public IntentIntegrator(final Activity activity) {
        this.moreExtras = new HashMap<String, Object>(3);
        this.requestCode = 49374;
        this.activity = activity;
    }
    
    private void attachMoreExtras(final Intent intent) {
        for (final Map.Entry<String, Object> entry : this.moreExtras.entrySet()) {
            final String s = entry.getKey();
            final Bundle value = entry.getValue();
            if (value instanceof Integer) {
                intent.putExtra(s, (Serializable)value);
            }
            else if (value instanceof Long) {
                intent.putExtra(s, (Serializable)value);
            }
            else if (value instanceof Boolean) {
                intent.putExtra(s, (Serializable)value);
            }
            else if (value instanceof Double) {
                intent.putExtra(s, (Serializable)value);
            }
            else if (value instanceof Float) {
                intent.putExtra(s, (Serializable)value);
            }
            else if (value instanceof Bundle) {
                intent.putExtra(s, (Bundle)value);
            }
            else {
                intent.putExtra(s, value.toString());
            }
        }
    }
    
    @TargetApi(11)
    public static IntentIntegrator forFragment(final Fragment fragment) {
        final IntentIntegrator intentIntegrator = new IntentIntegrator(fragment.getActivity());
        intentIntegrator.fragment = fragment;
        return intentIntegrator;
    }
    
    public static IntentIntegrator forSupportFragment(final android.support.v4.app.Fragment supportFragment) {
        final IntentIntegrator intentIntegrator = new IntentIntegrator(supportFragment.getActivity());
        intentIntegrator.supportFragment = supportFragment;
        return intentIntegrator;
    }
    
    private static List<String> list(final String... a) {
        return Collections.unmodifiableList((List<? extends String>)Arrays.asList((T[])a));
    }
    
    public static IntentResult parseActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 49374) {
            return parseActivityResult(n2, intent);
        }
        return null;
    }
    
    public static IntentResult parseActivityResult(int intExtra, final Intent intent) {
        if (intExtra == -1) {
            final String stringExtra = intent.getStringExtra("SCAN_RESULT");
            final String stringExtra2 = intent.getStringExtra("SCAN_RESULT_FORMAT");
            final byte[] byteArrayExtra = intent.getByteArrayExtra("SCAN_RESULT_BYTES");
            intExtra = intent.getIntExtra("SCAN_RESULT_ORIENTATION", Integer.MIN_VALUE);
            Integer value;
            if (intExtra == Integer.MIN_VALUE) {
                value = null;
            }
            else {
                value = intExtra;
            }
            return new IntentResult(stringExtra, stringExtra2, byteArrayExtra, value, intent.getStringExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL"), intent.getStringExtra("SCAN_RESULT_IMAGE_PATH"));
        }
        return new IntentResult();
    }
    
    public final IntentIntegrator addExtra(final String s, final Object o) {
        this.moreExtras.put(s, o);
        return this;
    }
    
    public Intent createScanIntent() {
        final Intent intent = new Intent((Context)this.activity, (Class)this.getCaptureActivity());
        intent.setAction("com.google.zxing.client.android.SCAN");
        if (this.desiredBarcodeFormats != null) {
            final StringBuilder sb = new StringBuilder();
            for (final String str : this.desiredBarcodeFormats) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(str);
            }
            intent.putExtra("SCAN_FORMATS", sb.toString());
        }
        intent.addFlags(67108864);
        intent.addFlags(524288);
        this.attachMoreExtras(intent);
        return intent;
    }
    
    public Class<?> getCaptureActivity() {
        if (this.captureActivity == null) {
            this.captureActivity = this.getDefaultCaptureActivity();
        }
        return this.captureActivity;
    }
    
    protected Class<?> getDefaultCaptureActivity() {
        return CaptureActivity.class;
    }
    
    public Map<String, ?> getMoreExtras() {
        return this.moreExtras;
    }
    
    public final void initiateScan() {
        this.startActivityForResult(this.createScanIntent(), this.requestCode);
    }
    
    public final void initiateScan(final Collection<String> desiredBarcodeFormats) {
        this.setDesiredBarcodeFormats(desiredBarcodeFormats);
        this.initiateScan();
    }
    
    public IntentIntegrator setBarcodeImageEnabled(final boolean b) {
        this.addExtra("BARCODE_IMAGE_ENABLED", b);
        return this;
    }
    
    public IntentIntegrator setBeepEnabled(final boolean b) {
        this.addExtra("BEEP_ENABLED", b);
        return this;
    }
    
    public IntentIntegrator setCameraId(final int i) {
        if (i >= 0) {
            this.addExtra("SCAN_CAMERA_ID", i);
        }
        return this;
    }
    
    public IntentIntegrator setCaptureActivity(final Class<?> captureActivity) {
        this.captureActivity = captureActivity;
        return this;
    }
    
    public IntentIntegrator setDesiredBarcodeFormats(final Collection<String> desiredBarcodeFormats) {
        this.desiredBarcodeFormats = desiredBarcodeFormats;
        return this;
    }
    
    public IntentIntegrator setDesiredBarcodeFormats(final String... a) {
        this.desiredBarcodeFormats = Arrays.asList(a);
        return this;
    }
    
    public IntentIntegrator setOrientationLocked(final boolean b) {
        this.addExtra("SCAN_ORIENTATION_LOCKED", b);
        return this;
    }
    
    public final IntentIntegrator setPrompt(final String s) {
        if (s != null) {
            this.addExtra("PROMPT_MESSAGE", s);
        }
        return this;
    }
    
    public IntentIntegrator setRequestCode(final int requestCode) {
        if (requestCode <= 0 || requestCode > 65535) {
            throw new IllegalArgumentException("requestCode out of range");
        }
        this.requestCode = requestCode;
        return this;
    }
    
    public IntentIntegrator setTimeout(final long l) {
        this.addExtra("TIMEOUT", l);
        return this;
    }
    
    protected void startActivity(final Intent intent) {
        if (this.fragment != null) {
            this.fragment.startActivity(intent);
            return;
        }
        if (this.supportFragment != null) {
            this.supportFragment.startActivity(intent);
            return;
        }
        this.activity.startActivity(intent);
    }
    
    protected void startActivityForResult(final Intent intent, final int n) {
        if (this.fragment != null) {
            this.fragment.startActivityForResult(intent, n);
            return;
        }
        if (this.supportFragment != null) {
            this.supportFragment.startActivityForResult(intent, n);
            return;
        }
        this.activity.startActivityForResult(intent, n);
    }
}
