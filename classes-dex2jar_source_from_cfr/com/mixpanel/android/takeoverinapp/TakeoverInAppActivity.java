/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.method.TransformationMethod
 *  android.view.Display
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.ScaleAnimation
 *  android.view.animation.TranslateAnimation
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.takeoverinapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.TransformationMethod;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixpanel.android.a;
import com.mixpanel.android.b.aa;
import com.mixpanel.android.b.h;
import com.mixpanel.android.b.j;
import com.mixpanel.android.b.n;
import com.mixpanel.android.b.y;
import com.mixpanel.android.c.f;
import com.mixpanel.android.takeoverinapp.FadingImageView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint(value={"ClickableViewAccessibility"})
@TargetApi(value=16)
public class TakeoverInAppActivity
extends Activity {
    private n a;
    private aa b;
    private int c = -1;

    private void a() {
        this.setContentView(a.d.com_mixpanel_android_activity_notification_full);
        Object object = (ImageView)this.findViewById(a.c.com_mixpanel_android_notification_gradient);
        FadingImageView fadingImageView = (FadingImageView)this.findViewById(a.c.com_mixpanel_android_notification_image);
        TextView textView = (TextView)this.findViewById(a.c.com_mixpanel_android_notification_title);
        TextView textView2 = (TextView)this.findViewById(a.c.com_mixpanel_android_notification_subtext);
        ArrayList<Button> arrayList = new ArrayList<Button>();
        Button button = (Button)this.findViewById(a.c.com_mixpanel_android_notification_button);
        arrayList.add(button);
        arrayList.add((Button)this.findViewById(a.c.com_mixpanel_android_notification_second_button));
        LinearLayout linearLayout = (LinearLayout)this.findViewById(a.c.com_mixpanel_android_button_exit_wrapper);
        ImageView imageView = (ImageView)this.findViewById(a.c.com_mixpanel_android_image_close);
        y y2 = (y)((aa.a.a)this.b.c()).a();
        Display display = this.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int n2 = this.getResources().getConfiguration().orientation;
        int n3 = 0;
        if (n2 == 1) {
            display = (RelativeLayout.LayoutParams)linearLayout.getLayoutParams();
            display.setMargins(0, 0, 0, (int)((float)point.y * 0.06f));
            linearLayout.setLayoutParams((ViewGroup.LayoutParams)display);
        }
        fadingImageView.a(y2.s());
        object.setBackgroundColor(y2.e());
        if (y2.n()) {
            textView.setVisibility(0);
            textView.setText((CharSequence)y2.o());
            textView.setTextColor(y2.p());
        } else {
            textView.setVisibility(8);
        }
        if (y2.f()) {
            textView2.setVisibility(0);
            textView2.setText((CharSequence)y2.g());
            textView2.setTextColor(y2.h());
        } else {
            textView2.setVisibility(8);
        }
        fadingImageView.setImageBitmap(y2.l());
        while (n3 < arrayList.size()) {
            object = y2.a(n3);
            this.a((Button)arrayList.get(n3), (h)object, y2, n3);
            ++n3;
        }
        if (y2.r() == 1) {
            object = (LinearLayout.LayoutParams)button.getLayoutParams();
            object.weight = 0.0f;
            object.width = -2;
            button.setLayoutParams((ViewGroup.LayoutParams)object);
        }
        imageView.setColorFilter(y2.q());
        linearLayout.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                TakeoverInAppActivity.this.finish();
                aa.a(TakeoverInAppActivity.this.c);
            }
        });
        this.a(fadingImageView, textView, textView2, arrayList, linearLayout);
    }

    private void a(Button button, final h h2, final j j2, final int n2) {
        if (h2 != null) {
            button.setVisibility(0);
            button.setText((CharSequence)h2.a());
            button.setTextColor(h2.b());
            button.setTransformationMethod(null);
            final GradientDrawable gradientDrawable = new GradientDrawable();
            int n3 = h2.c();
            final int n4 = 864454278;
            if (n3 != 0) {
                n4 = com.mixpanel.android.c.j.a(h2.c(), 864454278);
            }
            button.setOnTouchListener(new View.OnTouchListener(){

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        int n2 = n4;
                        gradientDrawable.setColor(n2);
                    } else {
                        gradientDrawable.setColor(h2.c());
                    }
                    return false;
                }
            });
            gradientDrawable.setColor(h2.c());
            gradientDrawable.setStroke((int)com.mixpanel.android.c.j.a(2.0f, (Context)this), h2.d());
            gradientDrawable.setCornerRadius((float)((int)com.mixpanel.android.c.j.a(5.0f, (Context)this)));
            if (Build.VERSION.SDK_INT < 16) {
                button.setBackgroundDrawable((Drawable)gradientDrawable);
            } else {
                button.setBackground((Drawable)gradientDrawable);
            }
            button.setOnClickListener(new View.OnClickListener(){

                /*
                 * Unable to fully structure code
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public void onClick(View var1_1) {
                    block16 : {
                        block14 : {
                            var4_5 = h2.e();
                            var3_6 = null;
                            var2_7 = null;
                            var1_1 = var3_6;
                            if (var4_5 != null) {
                                var1_1 = var3_6;
                                if (var4_5.length() > 0) {
                                    block13 : {
                                        try {
                                            var1_1 = Uri.parse((String)var4_5);
                                        }
                                        catch (IllegalArgumentException var1_3) {
                                            f.c("MixpanelAPI.TakeoverInAppActivity", "Can't parse notification URI, will not take any action", var1_3);
                                            return;
                                        }
                                        try {
                                            var1_1 = new Intent("android.intent.action.VIEW", (Uri)var1_1);
                                            TakeoverInAppActivity.this.startActivity((Intent)var1_1);
                                            break block13;
                                        }
                                        catch (ActivityNotFoundException var1_2) {}
                                        f.c("MixpanelAPI.TakeoverInAppActivity", "User doesn't have an activity for notification URI");
                                    }
                                    var1_1 = new JSONObject();
                                    try {
                                        var1_1.put("url", (Object)var4_5);
                                        break block14;
                                    }
                                    catch (JSONException var2_8) {}
                                    catch (JSONException var1_4) {
                                        var1_1 = var2_7;
                                    }
                                    f.e("MixpanelAPI.TakeoverInAppActivity", "Can't put url into json properties");
                                }
                            }
                        }
                        var3_6 = "primary";
                        if (((y)j2).r() == 2) {
                            var3_6 = n2 == 0 ? "secondary" : "primary";
                        }
                        var2_7 = var1_1;
                        if (var1_1 != null) ** GOTO lbl39
                        try {
                            var2_7 = new JSONObject();
lbl39: // 2 sources:
                            var1_1 = var2_7;
                            var2_7.put("button", (Object)var3_6);
                            var1_1 = var2_7;
                            break block16;
                        }
                        catch (JSONException var2_9) {}
                        f.e("MixpanelAPI.TakeoverInAppActivity", "Can't put button type into json properties");
                    }
                    TakeoverInAppActivity.b(TakeoverInAppActivity.this).c().a("$campaign_open", j2, (JSONObject)var1_1);
                    TakeoverInAppActivity.this.finish();
                    aa.a(TakeoverInAppActivity.a(TakeoverInAppActivity.this));
                }
            });
            return;
        }
        button.setVisibility(8);
    }

    private void a(ImageView imageView, TextView object, TextView textView, ArrayList<Button> arrayList, LinearLayout linearLayout) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 1.0f);
        scaleAnimation.setDuration(200L);
        imageView.startAnimation((Animation)scaleAnimation);
        imageView = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.5f, 1, 0.0f);
        imageView.setInterpolator((Interpolator)new DecelerateInterpolator());
        imageView.setDuration(200L);
        object.startAnimation((Animation)imageView);
        textView.startAnimation((Animation)imageView);
        object = arrayList.iterator();
        while (object.hasNext()) {
            ((Button)object.next()).startAnimation((Animation)imageView);
        }
        linearLayout.startAnimation(AnimationUtils.loadAnimation((Context)this, (int)a.a.com_mixpanel_android_fade_in));
    }

    static /* synthetic */ n b(TakeoverInAppActivity takeoverInAppActivity) {
        return takeoverInAppActivity.a;
    }

    public void onBackPressed() {
        aa.a(this.c);
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = this.getIntent().getIntExtra("com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY", Integer.MAX_VALUE);
        this.b = aa.b(this.c);
        if (this.b == null) {
            f.e("MixpanelAPI.TakeoverInAppActivity", "TakeoverInAppActivity intent received, but nothing was found to show.");
            this.finish();
            return;
        }
        this.a = n.a((Context)this, this.b.d());
        this.a();
    }

}

