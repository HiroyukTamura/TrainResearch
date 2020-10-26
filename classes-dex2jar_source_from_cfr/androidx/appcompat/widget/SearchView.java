/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.app.SearchableInfo
 *  android.content.ActivityNotFoundException
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.text.Editable
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.text.style.ImageSpan
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.KeyEvent$DispatcherState
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.TouchDelegate
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.AutoCompleteTextView
 *  android.widget.ImageView
 *  android.widget.ListAdapter
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 */
package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.ab;
import androidx.appcompat.widget.ai;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.aq;
import androidx.appcompat.widget.au;
import androidx.core.h.t;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
extends ab
implements androidx.appcompat.view.c {
    static final a i = new a();
    private c A;
    private b B;
    private d C;
    private View.OnClickListener D;
    private boolean E;
    private boolean F;
    private boolean G;
    private CharSequence H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private CharSequence M;
    private CharSequence N;
    private boolean O;
    private int P;
    private Bundle Q;
    private final Runnable R = new Runnable(){

        @Override
        public void run() {
            SearchView.this.d();
        }
    };
    private Runnable S = new Runnable(){

        @Override
        public void run() {
            if (SearchView.this.g != null && SearchView.this.g instanceof ai) {
                SearchView.this.g.a((Cursor)null);
            }
        }
    };
    private final WeakHashMap<String, Drawable.ConstantState> T = new WeakHashMap();
    private final View.OnClickListener U = new View.OnClickListener(){

        public void onClick(View view) {
            if (view == SearchView.this.b) {
                SearchView.this.g();
                return;
            }
            if (view == SearchView.this.d) {
                SearchView.this.f();
                return;
            }
            if (view == SearchView.this.c) {
                SearchView.this.e();
                return;
            }
            if (view == SearchView.this.e) {
                SearchView.this.h();
                return;
            }
            if (view == SearchView.this.a) {
                SearchView.this.l();
            }
        }
    };
    private final TextView.OnEditorActionListener V = new TextView.OnEditorActionListener(){

        public boolean onEditorAction(TextView textView, int n2, KeyEvent keyEvent) {
            SearchView.this.e();
            return true;
        }
    };
    private final AdapterView.OnItemClickListener W = new AdapterView.OnItemClickListener(){

        public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
            SearchView.this.a(n2, 0, null);
        }
    };
    final SearchAutoComplete a;
    private final AdapterView.OnItemSelectedListener aa = new AdapterView.OnItemSelectedListener(){

        public void onItemSelected(AdapterView<?> adapterView, View view, int n2, long l2) {
            SearchView.this.a(n2);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };
    private TextWatcher ab = new TextWatcher(){

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
        }

        public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            SearchView.this.b(charSequence);
        }
    };
    final ImageView b;
    final ImageView c;
    final ImageView d;
    final ImageView e;
    View.OnFocusChangeListener f;
    androidx.d.a.a g;
    SearchableInfo h;
    View.OnKeyListener j = new View.OnKeyListener(){

        public boolean onKey(View view, int n2, KeyEvent keyEvent) {
            if (SearchView.this.h == null) {
                return false;
            }
            if (SearchView.this.a.isPopupShowing() && SearchView.this.a.getListSelection() != -1) {
                return SearchView.this.a(view, n2, keyEvent);
            }
            if (!SearchView.this.a.a() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && n2 == 66) {
                view.cancelLongPress();
                SearchView.this.a(0, null, SearchView.this.a.getText().toString());
                return true;
            }
            return false;
        }
    };
    private final View k;
    private final View l;
    private final View m;
    private final View n;
    private f o;
    private Rect p = new Rect();
    private Rect q = new Rect();
    private int[] r = new int[2];
    private int[] s = new int[2];
    private final ImageView t;
    private final Drawable u;
    private final int v;
    private final int w;
    private final Intent x;
    private final Intent y;
    private final CharSequence z;

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet object, int n2) {
        super(context, (AttributeSet)object, n2);
        object = ao.a(context, (AttributeSet)object, a.j.SearchView, n2, 0);
        LayoutInflater.from((Context)context).inflate(((ao)object).g(a.j.SearchView_layout, a.g.abc_search_view), (ViewGroup)this, true);
        this.a = (SearchAutoComplete)this.findViewById(a.f.search_src_text);
        this.a.setSearchView(this);
        this.k = this.findViewById(a.f.search_edit_frame);
        this.l = this.findViewById(a.f.search_plate);
        this.m = this.findViewById(a.f.submit_area);
        this.b = (ImageView)this.findViewById(a.f.search_button);
        this.c = (ImageView)this.findViewById(a.f.search_go_btn);
        this.d = (ImageView)this.findViewById(a.f.search_close_btn);
        this.e = (ImageView)this.findViewById(a.f.search_voice_btn);
        this.t = (ImageView)this.findViewById(a.f.search_mag_icon);
        t.a(this.l, ((ao)object).a(a.j.SearchView_queryBackground));
        t.a(this.m, ((ao)object).a(a.j.SearchView_submitBackground));
        this.b.setImageDrawable(((ao)object).a(a.j.SearchView_searchIcon));
        this.c.setImageDrawable(((ao)object).a(a.j.SearchView_goIcon));
        this.d.setImageDrawable(((ao)object).a(a.j.SearchView_closeIcon));
        this.e.setImageDrawable(((ao)object).a(a.j.SearchView_voiceIcon));
        this.t.setImageDrawable(((ao)object).a(a.j.SearchView_searchIcon));
        this.u = ((ao)object).a(a.j.SearchView_searchHintIcon);
        aq.a((View)this.b, this.getResources().getString(a.h.abc_searchview_description_search));
        this.v = ((ao)object).g(a.j.SearchView_suggestionRowLayout, a.g.abc_search_dropdown_item_icons_2line);
        this.w = ((ao)object).g(a.j.SearchView_commitIcon, 0);
        this.b.setOnClickListener(this.U);
        this.d.setOnClickListener(this.U);
        this.c.setOnClickListener(this.U);
        this.e.setOnClickListener(this.U);
        this.a.setOnClickListener(this.U);
        this.a.addTextChangedListener(this.ab);
        this.a.setOnEditorActionListener(this.V);
        this.a.setOnItemClickListener(this.W);
        this.a.setOnItemSelectedListener(this.aa);
        this.a.setOnKeyListener(this.j);
        this.a.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View view, boolean bl2) {
                if (SearchView.this.f != null) {
                    SearchView.this.f.onFocusChange((View)SearchView.this, bl2);
                }
            }
        });
        this.setIconifiedByDefault(((ao)object).a(a.j.SearchView_iconifiedByDefault, true));
        n2 = ((ao)object).e(a.j.SearchView_android_maxWidth, -1);
        if (n2 != -1) {
            this.setMaxWidth(n2);
        }
        this.z = ((ao)object).c(a.j.SearchView_defaultQueryHint);
        this.H = ((ao)object).c(a.j.SearchView_queryHint);
        n2 = ((ao)object).a(a.j.SearchView_android_imeOptions, -1);
        if (n2 != -1) {
            this.setImeOptions(n2);
        }
        if ((n2 = ((ao)object).a(a.j.SearchView_android_inputType, -1)) != -1) {
            this.setInputType(n2);
        }
        this.setFocusable(((ao)object).a(a.j.SearchView_android_focusable, true));
        ((ao)object).a();
        this.x = new Intent("android.speech.action.WEB_SEARCH");
        this.x.addFlags(268435456);
        this.x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.y.addFlags(268435456);
        this.n = this.findViewById(this.a.getDropDownAnchor());
        if (this.n != null) {
            this.n.addOnLayoutChangeListener(new View.OnLayoutChangeListener(){

                public void onLayoutChange(View view, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
                    SearchView.this.k();
                }
            });
        }
        this.a(this.E);
        this.r();
    }

    private Intent a(Intent object, SearchableInfo searchableInfo) {
        Intent intent = new Intent(object);
        object = searchableInfo.getSearchActivity();
        object = object == null ? null : object.flattenToShortString();
        intent.putExtra("calling_package", (String)object);
        return intent;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Intent a(Cursor object, int n2, String string2) {
        String string3;
        String string4;
        try {
            string4 = string3 = ai.a((Cursor)object, "suggest_intent_action");
            if (string3 == null) {
                string4 = this.h.getSuggestIntentAction();
            }
        }
        catch (RuntimeException runtimeException) {
            block9 : {
                try {
                    n2 = object.getPosition();
                    break block9;
                }
                catch (RuntimeException runtimeException2) {}
                n2 = -1;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Search suggestions cursor at row ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(" returned exception.");
            Log.w((String)"SearchView", (String)((StringBuilder)object).toString(), (Throwable)runtimeException);
            return null;
        }
        string3 = string4;
        if (string4 == null) {
            string3 = "android.intent.action.SEARCH";
        }
        CharSequence charSequence = ai.a((Cursor)object, "suggest_intent_data");
        string4 = charSequence;
        if (charSequence == null) {
            string4 = this.h.getSuggestIntentData();
        }
        charSequence = string4;
        if (string4 != null) {
            String string5 = ai.a((Cursor)object, "suggest_intent_data_id");
            charSequence = string4;
            if (string5 != null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append("/");
                ((StringBuilder)charSequence).append(Uri.encode((String)string5));
                charSequence = ((StringBuilder)charSequence).toString();
            }
        }
        string4 = charSequence == null ? null : Uri.parse((String)charSequence);
        charSequence = ai.a((Cursor)object, "suggest_intent_query");
        return this.a(string3, (Uri)string4, ai.a((Cursor)object, "suggest_intent_extra_data"), (String)charSequence, n2, string2);
    }

    private Intent a(String string2, Uri uri, String string3, String string4, int n2, String string5) {
        string2 = new Intent(string2);
        string2.addFlags(268435456);
        if (uri != null) {
            string2.setData(uri);
        }
        string2.putExtra("user_query", this.N);
        if (string4 != null) {
            string2.putExtra("query", string4);
        }
        if (string3 != null) {
            string2.putExtra("intent_extra_data_key", string3);
        }
        if (this.Q != null) {
            string2.putExtra("app_data", this.Q);
        }
        if (n2 != 0) {
            string2.putExtra("action_key", n2);
            string2.putExtra("action_msg", string5);
        }
        string2.setComponent(this.h.getSearchActivity());
        return string2;
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            this.getContext().startActivity(intent);
            return;
        }
        catch (RuntimeException runtimeException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed launch activity: ");
            stringBuilder.append((Object)intent);
            Log.e((String)"SearchView", (String)stringBuilder.toString(), (Throwable)runtimeException);
            return;
        }
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.r);
        this.getLocationInWindow(this.s);
        int n2 = this.r[1] - this.s[1];
        int n3 = this.r[0] - this.s[0];
        rect.set(n3, n2, view.getWidth() + n3, view.getHeight() + n2);
    }

    private void a(boolean bl2) {
        this.F = bl2;
        int n2 = 8;
        boolean bl3 = false;
        int n3 = bl2 ? 0 : 8;
        boolean bl4 = TextUtils.isEmpty((CharSequence)this.a.getText()) ^ true;
        this.b.setVisibility(n3);
        this.b(bl4);
        View view = this.k;
        n3 = bl2 ? 8 : 0;
        view.setVisibility(n3);
        n3 = n2;
        if (this.t.getDrawable() != null) {
            n3 = this.E ? n2 : 0;
        }
        this.t.setVisibility(n3);
        this.p();
        bl2 = bl3;
        if (!bl4) {
            bl2 = true;
        }
        this.c(bl2);
        this.o();
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private Intent b(Intent object, SearchableInfo searchableInfo) {
        ComponentName componentName = searchableInfo.getSearchActivity();
        Object object2 = new Intent("android.intent.action.SEARCH");
        object2.setComponent(componentName);
        PendingIntent pendingIntent = PendingIntent.getActivity((Context)this.getContext(), (int)0, (Intent)object2, (int)1073741824);
        Bundle bundle = new Bundle();
        if (this.Q != null) {
            bundle.putParcelable("app_data", (Parcelable)this.Q);
        }
        Intent intent = new Intent(object);
        object = "free_form";
        int n2 = 1;
        Object object3 = this.getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            object = object3.getString(searchableInfo.getVoiceLanguageModeId());
        }
        int n3 = searchableInfo.getVoicePromptTextId();
        Object var7_11 = null;
        object2 = n3 != 0 ? object3.getString(searchableInfo.getVoicePromptTextId()) : null;
        object3 = searchableInfo.getVoiceLanguageId() != 0 ? object3.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            n2 = searchableInfo.getVoiceMaxResults();
        }
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", (String)object);
        intent.putExtra("android.speech.extra.PROMPT", (String)object2);
        intent.putExtra("android.speech.extra.LANGUAGE", (String)object3);
        intent.putExtra("android.speech.extra.MAX_RESULTS", n2);
        object = componentName == null ? var7_11 : componentName.flattenToShortString();
        intent.putExtra("calling_package", (String)object);
        intent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", (Parcelable)pendingIntent);
        intent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent;
    }

    private void b(boolean bl2) {
        int n2 = this.G && this.n() && this.hasFocus() && (bl2 || !this.L) ? 0 : 8;
        this.c.setVisibility(n2);
    }

    private boolean b(int n2, int n3, String string2) {
        Cursor cursor = this.g.a();
        if (cursor != null && cursor.moveToPosition(n2)) {
            this.a(this.a(cursor, n3, string2));
            return true;
        }
        return false;
    }

    private CharSequence c(CharSequence charSequence) {
        if (this.E) {
            if (this.u == null) {
                return charSequence;
            }
            int n2 = (int)((double)this.a.getTextSize() * 1.25);
            this.u.setBounds(0, 0, n2, n2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)"   ");
            spannableStringBuilder.setSpan((Object)new ImageSpan(this.u), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    private void c(boolean bl2) {
        int n2;
        if (this.L && !this.c() && bl2) {
            n2 = 0;
            this.c.setVisibility(8);
        } else {
            n2 = 8;
        }
        this.e.setVisibility(n2);
    }

    private void e(int n2) {
        Editable editable = this.a.getText();
        Object object = this.g.a();
        if (object == null) {
            return;
        }
        if (object.moveToPosition(n2) && (object = this.g.b((Cursor)object)) != null) {
            this.setQuery((CharSequence)object);
            return;
        }
        this.setQuery((CharSequence)editable);
    }

    private int getPreferredHeight() {
        return this.getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return this.getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_width);
    }

    private boolean m() {
        boolean bl2;
        SearchableInfo searchableInfo = this.h;
        boolean bl3 = bl2 = false;
        if (searchableInfo != null) {
            bl3 = bl2;
            if (this.h.getVoiceSearchEnabled()) {
                searchableInfo = null;
                if (this.h.getVoiceSearchLaunchWebSearch()) {
                    searchableInfo = this.x;
                } else if (this.h.getVoiceSearchLaunchRecognizer()) {
                    searchableInfo = this.y;
                }
                bl3 = bl2;
                if (searchableInfo != null) {
                    bl3 = bl2;
                    if (this.getContext().getPackageManager().resolveActivity((Intent)searchableInfo, 65536) != null) {
                        bl3 = true;
                    }
                }
            }
        }
        return bl3;
    }

    private boolean n() {
        return (this.G || this.L) && !this.c();
    }

    private void o() {
        int n2 = this.n() && (this.c.getVisibility() == 0 || this.e.getVisibility() == 0) ? 0 : 8;
        this.m.setVisibility(n2);
    }

    private void p() {
        boolean bl2 = TextUtils.isEmpty((CharSequence)this.a.getText());
        int n2 = 1;
        boolean bl3 = bl2 ^ true;
        int n3 = 0;
        int n4 = n2;
        if (!bl3) {
            n4 = this.E && !this.O ? n2 : 0;
        }
        int[] arrn = this.d;
        n4 = n4 != 0 ? n3 : 8;
        arrn.setVisibility(n4);
        Drawable drawable2 = this.d.getDrawable();
        if (drawable2 != null) {
            arrn = bl3 ? ENABLED_STATE_SET : EMPTY_STATE_SET;
            drawable2.setState(arrn);
        }
    }

    private void q() {
        this.post(this.R);
    }

    private void r() {
        CharSequence charSequence = this.getQueryHint();
        SearchAutoComplete searchAutoComplete = this.a;
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "";
        }
        searchAutoComplete.setHint(this.c(charSequence2));
    }

    private void s() {
        this.a.setThreshold(this.h.getSuggestThreshold());
        this.a.setImeOptions(this.h.getImeOptions());
        int n2 = this.h.getInputType();
        int n3 = 1;
        int n4 = n2;
        if ((n2 & 15) == 1) {
            n4 = n2 &= -65537;
            if (this.h.getSuggestAuthority() != null) {
                n4 = n2 | 65536 | 524288;
            }
        }
        this.a.setInputType(n4);
        if (this.g != null) {
            this.g.a((Cursor)null);
        }
        if (this.h.getSuggestAuthority() != null) {
            this.g = new ai(this.getContext(), this, this.h, this.T);
            this.a.setAdapter((ListAdapter)this.g);
            ai ai2 = (ai)this.g;
            n4 = n3;
            if (this.I) {
                n4 = 2;
            }
            ai2.a(n4);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.a.setText(charSequence);
        SearchAutoComplete searchAutoComplete = this.a;
        int n2 = TextUtils.isEmpty((CharSequence)charSequence) ? 0 : charSequence.length();
        searchAutoComplete.setSelection(n2);
    }

    private void t() {
        this.a.dismissDropDown();
    }

    @Override
    public void a() {
        if (this.O) {
            return;
        }
        this.O = true;
        this.P = this.a.getImeOptions();
        this.a.setImeOptions(this.P | 33554432);
        this.a.setText((CharSequence)"");
        this.setIconified(false);
    }

    void a(int n2, String string2, String string3) {
        string2 = this.a("android.intent.action.SEARCH", null, null, string3, n2, string2);
        this.getContext().startActivity((Intent)string2);
    }

    void a(CharSequence charSequence) {
        this.setQuery(charSequence);
    }

    public void a(CharSequence charSequence, boolean bl2) {
        this.a.setText(charSequence);
        if (charSequence != null) {
            this.a.setSelection(this.a.length());
            this.N = charSequence;
        }
        if (bl2 && !TextUtils.isEmpty((CharSequence)charSequence)) {
            this.e();
        }
    }

    boolean a(int n2) {
        if (this.C != null && this.C.a(n2)) {
            return false;
        }
        this.e(n2);
        return true;
    }

    boolean a(int n2, int n3, String string2) {
        if (this.C != null && this.C.b(n2)) {
            return false;
        }
        this.b(n2, 0, null);
        this.a.setImeVisibility(false);
        this.t();
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean a(View view, int n2, KeyEvent keyEvent) {
        if (this.h == null) {
            return false;
        }
        if (this.g == null) {
            return false;
        }
        if (keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) return false;
        if (n2 == 66 || n2 == 84 || n2 == 61) return this.a(this.a.getListSelection(), 0, null);
        if (n2 != 21 && n2 != 22) {
            if (n2 != 19 || this.a.getListSelection() != 0) return false;
            return false;
        }
        n2 = n2 == 21 ? 0 : this.a.length();
        this.a.setSelection(n2);
        this.a.setListSelection(0);
        this.a.clearListSelection();
        i.a(this.a, true);
        return true;
    }

    @Override
    public void b() {
        this.a("", false);
        this.clearFocus();
        this.a(true);
        this.a.setImeOptions(this.P);
        this.O = false;
    }

    void b(CharSequence charSequence) {
        Editable editable = this.a.getText();
        this.N = editable;
        boolean bl2 = TextUtils.isEmpty((CharSequence)editable);
        boolean bl3 = true;
        this.b(bl2 ^= true);
        if (bl2) {
            bl3 = false;
        }
        this.c(bl3);
        this.p();
        this.o();
        if (this.A != null && !TextUtils.equals((CharSequence)charSequence, (CharSequence)this.M)) {
            this.A.b(charSequence.toString());
        }
        this.M = charSequence.toString();
    }

    public boolean c() {
        return this.F;
    }

    public void clearFocus() {
        this.J = true;
        super.clearFocus();
        this.a.clearFocus();
        this.a.setImeVisibility(false);
        this.J = false;
    }

    void d() {
        int[] arrn = this.a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable drawable2 = this.l.getBackground();
        if (drawable2 != null) {
            drawable2.setState(arrn);
        }
        if ((drawable2 = this.m.getBackground()) != null) {
            drawable2.setState(arrn);
        }
        this.invalidate();
    }

    void e() {
        Editable editable = this.a.getText();
        if (!(editable == null || TextUtils.getTrimmedLength((CharSequence)editable) <= 0 || this.A != null && this.A.a(editable.toString()))) {
            if (this.h != null) {
                this.a(0, null, editable.toString());
            }
            this.a.setImeVisibility(false);
            this.t();
        }
    }

    void f() {
        if (TextUtils.isEmpty((CharSequence)this.a.getText())) {
            if (this.E && (this.B == null || !this.B.a())) {
                this.clearFocus();
                this.a(true);
                return;
            }
        } else {
            this.a.setText((CharSequence)"");
            this.a.requestFocus();
            this.a.setImeVisibility(true);
        }
    }

    void g() {
        this.a(false);
        this.a.requestFocus();
        this.a.setImeVisibility(true);
        if (this.D != null) {
            this.D.onClick((View)this);
        }
    }

    public int getImeOptions() {
        return this.a.getImeOptions();
    }

    public int getInputType() {
        return this.a.getInputType();
    }

    public int getMaxWidth() {
        return this.K;
    }

    public CharSequence getQuery() {
        return this.a.getText();
    }

    public CharSequence getQueryHint() {
        if (this.H != null) {
            return this.H;
        }
        if (this.h != null && this.h.getHintId() != 0) {
            return this.getContext().getText(this.h.getHintId());
        }
        return this.z;
    }

    int getSuggestionCommitIconResId() {
        return this.w;
    }

    int getSuggestionRowLayout() {
        return this.v;
    }

    public androidx.d.a.a getSuggestionsAdapter() {
        return this.g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void h() {
        if (this.h == null) {
            return;
        }
        SearchableInfo searchableInfo = this.h;
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                searchableInfo = this.a(this.x, searchableInfo);
            } else {
                if (!searchableInfo.getVoiceSearchLaunchRecognizer()) return;
                searchableInfo = this.b(this.y, searchableInfo);
            }
            this.getContext().startActivity((Intent)searchableInfo);
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {}
        Log.w((String)"SearchView", (String)"Could not find voice search activity");
    }

    void i() {
        this.a(this.c());
        this.q();
        if (this.a.hasFocus()) {
            this.l();
        }
    }

    void k() {
        if (this.n.getWidth() > 1) {
            Resources resources = this.getContext().getResources();
            int n2 = this.l.getPaddingLeft();
            Rect rect = new Rect();
            boolean bl2 = au.a((View)this);
            int n3 = this.E ? resources.getDimensionPixelSize(a.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(a.d.abc_dropdownitem_text_padding_left) : 0;
            this.a.getDropDownBackground().getPadding(rect);
            int n4 = bl2 ? -rect.left : n2 - (rect.left + n3);
            this.a.setDropDownHorizontalOffset(n4);
            n4 = this.n.getWidth();
            int n5 = rect.left;
            int n6 = rect.right;
            this.a.setDropDownWidth(n4 + n5 + n6 + n3 - n2);
        }
    }

    void l() {
        i.a(this.a);
        i.b(this.a);
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.R);
        this.post(this.S);
        super.onDetachedFromWindow();
    }

    @Override
    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        if (bl2) {
            this.a((View)this.a, this.p);
            this.q.set(this.p.left, 0, this.p.right, n5 - n3);
            if (this.o == null) {
                this.o = new f(this.q, this.p, (View)this.a);
                this.setTouchDelegate((TouchDelegate)this.o);
                return;
            }
            this.o.a(this.q, this.p);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    protected void onMeasure(int var1_1, int var2_2) {
        block9 : {
            block6 : {
                block7 : {
                    block8 : {
                        if (this.c()) {
                            super.onMeasure(var1_1, var2_2);
                            return;
                        }
                        var4_3 = View.MeasureSpec.getMode((int)var1_1);
                        var3_4 = View.MeasureSpec.getSize((int)var1_1);
                        if (var4_3 == Integer.MIN_VALUE) break block6;
                        if (var4_3 == 0) break block7;
                        if (var4_3 == 1073741824) break block8;
                        var1_1 = var3_4;
                        break block9;
                    }
                    var1_1 = var3_4;
                    if (this.K <= 0) break block9;
                    ** GOTO lbl-1000
                }
                var1_1 = this.K > 0 ? this.K : this.getPreferredWidth();
                break block9;
            }
            if (this.K > 0) lbl-1000: // 2 sources:
            {
                var1_1 = this.K;
            } else {
                var1_1 = this.getPreferredWidth();
            }
            var1_1 = Math.min(var1_1, var3_4);
        }
        var3_4 = View.MeasureSpec.getMode((int)var2_2);
        var2_2 = View.MeasureSpec.getSize((int)var2_2);
        if (var3_4 != Integer.MIN_VALUE) {
            if (var3_4 == 0) {
                var2_2 = this.getPreferredHeight();
            }
        } else {
            var2_2 = Math.min(this.getPreferredHeight(), var2_2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)var1_1, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)var2_2, (int)1073741824));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (e)parcelable;
        super.onRestoreInstanceState(parcelable.a());
        this.a(parcelable.a);
        this.requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        e e2 = new e(super.onSaveInstanceState());
        e2.a = this.c();
        return e2;
    }

    public void onWindowFocusChanged(boolean bl2) {
        super.onWindowFocusChanged(bl2);
        this.q();
    }

    public boolean requestFocus(int n2, Rect rect) {
        if (this.J) {
            return false;
        }
        if (!this.isFocusable()) {
            return false;
        }
        if (!this.c()) {
            boolean bl2 = this.a.requestFocus(n2, rect);
            if (bl2) {
                this.a(false);
            }
            return bl2;
        }
        return super.requestFocus(n2, rect);
    }

    public void setAppSearchData(Bundle bundle) {
        this.Q = bundle;
    }

    public void setIconified(boolean bl2) {
        if (bl2) {
            this.f();
            return;
        }
        this.g();
    }

    public void setIconifiedByDefault(boolean bl2) {
        if (this.E == bl2) {
            return;
        }
        this.E = bl2;
        this.a(bl2);
        this.r();
    }

    public void setImeOptions(int n2) {
        this.a.setImeOptions(n2);
    }

    public void setInputType(int n2) {
        this.a.setInputType(n2);
    }

    public void setMaxWidth(int n2) {
        this.K = n2;
        this.requestLayout();
    }

    public void setOnCloseListener(b b2) {
        this.B = b2;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c c2) {
        this.A = c2;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public void setOnSuggestionListener(d d2) {
        this.C = d2;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.H = charSequence;
        this.r();
    }

    public void setQueryRefinementEnabled(boolean bl2) {
        this.I = bl2;
        if (this.g instanceof ai) {
            ai ai2 = (ai)this.g;
            int n2 = bl2 ? 2 : 1;
            ai2.a(n2);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.h = searchableInfo;
        if (this.h != null) {
            this.s();
            this.r();
        }
        this.L = this.m();
        if (this.L) {
            this.a.setPrivateImeOptions("nm");
        }
        this.a(this.c());
    }

    public void setSubmitButtonEnabled(boolean bl2) {
        this.G = bl2;
        this.a(this.c());
    }

    public void setSuggestionsAdapter(androidx.d.a.a a2) {
        this.g = a2;
        this.a.setAdapter((ListAdapter)this.g);
    }

    public static class SearchAutoComplete
    extends androidx.appcompat.widget.e {
        final Runnable a = new Runnable(){

            @Override
            public void run() {
                SearchAutoComplete.this.b();
            }
        };
        private int b = this.getThreshold();
        private SearchView c;
        private boolean d;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int n2) {
            super(context, attributeSet, n2);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = this.getResources().getConfiguration();
            int n2 = configuration.screenWidthDp;
            int n3 = configuration.screenHeightDp;
            if (n2 >= 960 && n3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (n2 < 600 && (n2 < 640 || n3 < 480)) {
                return 160;
            }
            return 192;
        }

        boolean a() {
            return TextUtils.getTrimmedLength((CharSequence)this.getText()) == 0;
        }

        void b() {
            if (this.d) {
                ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput((View)this, 0);
                this.d = false;
            }
        }

        public boolean enoughToFilter() {
            return this.b <= 0 || super.enoughToFilter();
            {
            }
        }

        @Override
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            editorInfo = super.onCreateInputConnection(editorInfo);
            if (this.d) {
                this.removeCallbacks(this.a);
                this.post(this.a);
            }
            return editorInfo;
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
            this.setMinWidth((int)TypedValue.applyDimension((int)1, (float)this.getSearchViewTextMinWidthDp(), (DisplayMetrics)displayMetrics));
        }

        protected void onFocusChanged(boolean bl2, int n2, Rect rect) {
            super.onFocusChanged(bl2, n2, rect);
            this.c.i();
        }

        public boolean onKeyPreIme(int n2, KeyEvent keyEvent) {
            if (n2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState dispatcherState = this.getKeyDispatcherState();
                    if (dispatcherState != null) {
                        dispatcherState.startTracking(keyEvent, (Object)this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState dispatcherState = this.getKeyDispatcherState();
                    if (dispatcherState != null) {
                        dispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.c.clearFocus();
                        this.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(n2, keyEvent);
        }

        public void onWindowFocusChanged(boolean bl2) {
            super.onWindowFocusChanged(bl2);
            if (bl2 && this.c.hasFocus() && this.getVisibility() == 0) {
                this.d = true;
                if (SearchView.a(this.getContext())) {
                    SearchView.i.a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean bl2) {
            InputMethodManager inputMethodManager = (InputMethodManager)this.getContext().getSystemService("input_method");
            if (!bl2) {
                this.d = false;
                this.removeCallbacks(this.a);
                inputMethodManager.hideSoftInputFromWindow(this.getWindowToken(), 0);
                return;
            }
            if (inputMethodManager.isActive((View)this)) {
                this.d = false;
                this.removeCallbacks(this.a);
                inputMethodManager.showSoftInput((View)this, 0);
                return;
            }
            this.d = true;
        }

        void setSearchView(SearchView searchView) {
            this.c = searchView;
        }

        public void setThreshold(int n2) {
            super.setThreshold(n2);
            this.b = n2;
        }

    }

    private static class a {
        private Method a;
        private Method b;
        private Method c;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        a() {
            try {
                this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.a.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {}
            try {
                this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {}
            try {
                this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c.setAccessible(true);
                return;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                return;
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.a == null) return;
            try {
                this.a.invoke((Object)autoCompleteTextView, new Object[0]);
                return;
            }
            catch (Exception exception) {
                return;
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        void a(AutoCompleteTextView autoCompleteTextView, boolean bl2) {
            if (this.c == null) return;
            try {
                this.c.invoke((Object)autoCompleteTextView, bl2);
                return;
            }
            catch (Exception exception) {
                return;
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.b == null) return;
            try {
                this.b.invoke((Object)autoCompleteTextView, new Object[0]);
                return;
            }
            catch (Exception exception) {
                return;
            }
        }
    }

    public static interface b {
        public boolean a();
    }

    public static interface c {
        public boolean a(String var1);

        public boolean b(String var1);
    }

    public static interface d {
        public boolean a(int var1);

        public boolean b(int var1);
    }

    static class e
    extends androidx.e.a.a {
        public static final Parcelable.Creator<e> CREATOR = new Parcelable.ClassLoaderCreator<e>(){

            public e a(Parcel parcel) {
                return new e(parcel, null);
            }

            public e a(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            public e[] a(int n2) {
                return new e[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return this.a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        boolean a;

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = (Boolean)parcel.readValue(null);
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SearchView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" isIconified=");
            stringBuilder.append(this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        @Override
        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            parcel.writeValue((Object)this.a);
        }

    }

    private static class f
    extends TouchDelegate {
        private final View a;
        private final Rect b;
        private final Rect c;
        private final Rect d;
        private final int e;
        private boolean f;

        public f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get((Context)view.getContext()).getScaledTouchSlop();
            this.b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            this.a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            this.d.inset(-this.e, -this.e);
            this.c.set(rect2);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int n2;
            int n3;
            int n4;
            boolean bl2;
            boolean bl3;
            block10 : {
                n4 = (int)motionEvent.getX();
                n2 = (int)motionEvent.getY();
                n3 = motionEvent.getAction();
                int n5 = 1;
                bl3 = false;
                switch (n3) {
                    default: {
                        break;
                    }
                    case 3: {
                        bl2 = this.f;
                        this.f = false;
                        n3 = n5;
                        break block10;
                    }
                    case 1: 
                    case 2: {
                        boolean bl4;
                        bl2 = bl4 = this.f;
                        n3 = n5;
                        if (bl4) {
                            bl2 = bl4;
                            n3 = n5;
                            if (!this.d.contains(n4, n2)) {
                                n3 = 0;
                                bl2 = bl4;
                            }
                        }
                        break block10;
                    }
                    case 0: {
                        if (!this.b.contains(n4, n2)) break;
                        this.f = true;
                        bl2 = true;
                        n3 = n5;
                        break block10;
                    }
                }
                bl2 = false;
                n3 = n5;
            }
            if (bl2) {
                float f2;
                if (n3 != 0 && !this.c.contains(n4, n2)) {
                    f2 = this.a.getWidth() / 2;
                    n3 = this.a.getHeight() / 2;
                } else {
                    f2 = n4 - this.c.left;
                    n3 = n2 - this.c.top;
                }
                motionEvent.setLocation(f2, (float)n3);
                bl3 = this.a.dispatchTouchEvent(motionEvent);
            }
            return bl3;
        }
    }

}

