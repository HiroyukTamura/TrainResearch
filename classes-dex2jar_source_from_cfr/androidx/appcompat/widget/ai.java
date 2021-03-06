/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.SearchManager
 *  android.app.SearchableInfo
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.text.SpannableString
 *  android.text.TextUtils
 *  android.text.style.TextAppearanceSpan
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.SearchView;
import androidx.d.a.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class ai
extends c
implements View.OnClickListener {
    private final SearchManager j = (SearchManager)this.d.getSystemService("search");
    private final SearchView k;
    private final SearchableInfo l;
    private final Context m;
    private final WeakHashMap<String, Drawable.ConstantState> n;
    private final int o;
    private boolean p = false;
    private int q = 1;
    private ColorStateList r;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = -1;

    public ai(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.k = searchView;
        this.l = searchableInfo;
        this.o = searchView.getSuggestionCommitIconResId();
        this.m = context;
        this.n = weakHashMap;
    }

    private Drawable a(ComponentName object) {
        String string2 = object.flattenToShortString();
        boolean bl2 = this.n.containsKey(string2);
        Object var3_4 = null;
        if (bl2) {
            object = this.n.get(string2);
            if (object == null) {
                return null;
            }
            return object.newDrawable(this.m.getResources());
        }
        Drawable drawable2 = this.b((ComponentName)object);
        object = drawable2 == null ? var3_4 : drawable2.getConstantState();
        this.n.put(string2, (Drawable.ConstantState)object);
        return drawable2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private Drawable a(String string2) {
        Drawable drawable2;
        void var3_12;
        Drawable drawable3 = drawable2 = null;
        if (string2 == null) return var3_12;
        Drawable drawable4 = drawable2;
        if (string2.isEmpty()) return var3_12;
        if ("0".equals(string2)) {
            return null;
        }
        try {
            int n2 = Integer.parseInt(string2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android.resource://");
            stringBuilder.append(this.m.getPackageName());
            stringBuilder.append("/");
            stringBuilder.append(n2);
            String string3 = stringBuilder.toString();
            drawable2 = this.b(string3);
            if (drawable2 != null) {
                return drawable2;
            }
            drawable2 = androidx.core.a.a.a(this.m, n2);
            this.a(string3, drawable2);
            return drawable2;
        }
        catch (NumberFormatException numberFormatException) {}
        Drawable drawable5 = this.b(string2);
        if (drawable5 != null) {
            return drawable5;
        }
        Drawable drawable6 = this.b(Uri.parse((String)string2));
        this.a(string2, drawable6);
        return var3_12;
        catch (Resources.NotFoundException notFoundException) {}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Icon resource not found: ");
        stringBuilder.append(string2);
        Log.w((String)"SuggestionsAdapter", (String)stringBuilder.toString());
        return null;
    }

    private static String a(Cursor object, int n2) {
        if (n2 == -1) {
            return null;
        }
        try {
            object = object.getString(n2);
            return object;
        }
        catch (Exception exception) {
            Log.e((String)"SuggestionsAdapter", (String)"unexpected error retrieving valid column from cursor, did the remote process die?", (Throwable)exception);
            return null;
        }
    }

    public static String a(Cursor cursor, String string2) {
        return ai.a(cursor, cursor.getColumnIndex(string2));
    }

    private void a(ImageView imageView, Drawable drawable2, int n2) {
        imageView.setImageDrawable(drawable2);
        if (drawable2 == null) {
            imageView.setVisibility(n2);
            return;
        }
        imageView.setVisibility(0);
        drawable2.setVisible(false, false);
        drawable2.setVisible(true, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        int n2 = TextUtils.isEmpty((CharSequence)charSequence) ? 8 : 0;
        textView.setVisibility(n2);
    }

    private void a(String string2, Drawable drawable2) {
        if (drawable2 != null) {
            this.n.put(string2, drawable2.getConstantState());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Drawable b(ComponentName object) {
        void var1_3;
        ActivityInfo activityInfo;
        Object object2 = this.d.getPackageManager();
        try {
            activityInfo = object2.getActivityInfo(object, 128);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            String string2 = nameNotFoundException.toString();
        }
        int n2 = activityInfo.getIconResource();
        if (n2 == 0) {
            return null;
        }
        if ((object2 = object2.getDrawable(object.getPackageName(), n2, activityInfo.applicationInfo)) != null) {
            return object2;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Invalid icon resource ");
        ((StringBuilder)object2).append(n2);
        ((StringBuilder)object2).append(" for ");
        ((StringBuilder)object2).append(object.flattenToShortString());
        String string3 = ((StringBuilder)object2).toString();
        Log.w((String)"SuggestionsAdapter", (String)var1_3);
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private Drawable b(Uri var1_1) {
        try {
            var2_2 = "android.resource".equals(var1_1.getScheme());
            if (var2_2) {
                return this.a(var1_1);
            }
            var4_10 = this.m.getContentResolver().openInputStream(var1_1);
            if (var4_10 == null) ** GOTO lbl38
        }
        catch (FileNotFoundException var3_9) {
            var4_10 = new StringBuilder();
            var4_10.append("Icon not found: ");
            var4_10.append((Object)var1_1);
            var4_10.append(", ");
            var4_10.append(var3_9.getMessage());
            Log.w((String)"SuggestionsAdapter", (String)var4_10.toString());
            return null;
        }
        var3_6 = Drawable.createFromStream((InputStream)var4_10, null);
        {
            catch (Throwable var3_7) {
                try {
                    var4_10.close();
                    throw var3_7;
                }
                catch (IOException var4_12) {
                    var5_14 = new StringBuilder();
                    var5_14.append("Error closing icon stream for ");
                    var5_14.append((Object)var1_1);
                    Log.e((String)"SuggestionsAdapter", (String)var5_14.toString(), (Throwable)var4_12);
                }
                throw var3_7;
            }
        }
        try {
            var4_10.close();
            return var3_6;
        }
        catch (IOException var4_11) {
            var5_13 = new StringBuilder();
            var5_13.append("Error closing icon stream for ");
            var5_13.append((Object)var1_1);
            Log.e((String)"SuggestionsAdapter", (String)var5_13.toString(), (Throwable)var4_11);
            return var3_6;
        }
lbl38: // 1 sources:
        var3_8 = new StringBuilder();
        var3_8.append("Failed to open ");
        var3_8.append((Object)var1_1);
        throw new FileNotFoundException(var3_8.toString());
        catch (Resources.NotFoundException var3_4) {}
        var3_5 = new StringBuilder();
        var3_5.append("Resource does not exist: ");
        var3_5.append((Object)var1_1);
        throw new FileNotFoundException(var3_5.toString());
    }

    private Drawable b(String string2) {
        if ((string2 = this.n.get(string2)) == null) {
            return null;
        }
        return string2.newDrawable();
    }

    private CharSequence b(CharSequence charSequence) {
        TypedValue typedValue;
        if (this.r == null) {
            typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(a.a.textColorSearchUrl, typedValue, true);
            this.r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        typedValue = new SpannableString(charSequence);
        typedValue.setSpan((Object)new TextAppearanceSpan(null, 0, 0, this.r, null), 0, charSequence.length(), 33);
        return typedValue;
    }

    private void d(Cursor object) {
        if ((object = object != null ? object.getExtras() : null) == null || object.getBoolean("in_progress")) {
            // empty if block
        }
    }

    private Drawable e(Cursor cursor) {
        if (this.v == -1) {
            return null;
        }
        Drawable drawable2 = this.a(cursor.getString(this.v));
        if (drawable2 != null) {
            return drawable2;
        }
        return this.g(cursor);
    }

    private Drawable f(Cursor cursor) {
        if (this.w == -1) {
            return null;
        }
        return this.a(cursor.getString(this.w));
    }

    private Drawable g(Cursor cursor) {
        cursor = this.a(this.l.getSearchActivity());
        if (cursor != null) {
            return cursor;
        }
        return this.d.getPackageManager().getDefaultActivityIcon();
    }

    Cursor a(SearchableInfo arrstring, String string2, int n2) {
        Object var4_4 = null;
        if (arrstring == null) {
            return null;
        }
        String string3 = arrstring.getSuggestAuthority();
        if (string3 == null) {
            return null;
        }
        string3 = new Uri.Builder().scheme("content").authority(string3).query("").fragment("");
        String string4 = arrstring.getSuggestPath();
        if (string4 != null) {
            string3.appendEncodedPath(string4);
        }
        string3.appendPath("search_suggest_query");
        string4 = arrstring.getSuggestSelection();
        if (string4 != null) {
            arrstring = new String[]{string2};
        } else {
            string3.appendPath(string2);
            arrstring = var4_4;
        }
        if (n2 > 0) {
            string3.appendQueryParameter("limit", String.valueOf(n2));
        }
        string2 = string3.build();
        return this.d.getContentResolver().query((Uri)string2, null, string4, arrstring, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Cursor a(CharSequence charSequence) {
        charSequence = charSequence == null ? "" : charSequence.toString();
        if (this.k.getVisibility() != 0) return null;
        if (this.k.getWindowVisibility() != 0) {
            return null;
        }
        charSequence = this.a(this.l, (String)charSequence, 50);
        if (charSequence == null) return null;
        try {
            charSequence.getCount();
            return charSequence;
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)"SuggestionsAdapter", (String)"Search suggestions query threw an exception.", (Throwable)runtimeException);
        }
        return null;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    Drawable a(Uri uri) {
        Resources resources;
        CharSequence charSequence = uri.getAuthority();
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("No authority: ");
            ((StringBuilder)charSequence).append((Object)uri);
            throw new FileNotFoundException(((StringBuilder)charSequence).toString());
        }
        try {
            resources = this.d.getPackageManager().getResourcesForApplication((String)charSequence);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        List list = uri.getPathSegments();
        if (list == null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("No path: ");
            ((StringBuilder)charSequence).append((Object)uri);
            throw new FileNotFoundException(((StringBuilder)charSequence).toString());
        }
        int n2 = list.size();
        if (n2 == 1) {
            n2 = Integer.parseInt((String)list.get(0));
        } else {
            if (n2 != 2) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("More than two path segments: ");
                ((StringBuilder)charSequence).append((Object)uri);
                throw new FileNotFoundException(((StringBuilder)charSequence).toString());
            }
            n2 = resources.getIdentifier((String)list.get(1), (String)list.get(0), (String)charSequence);
        }
        if (n2 != 0) {
            return resources.getDrawable(n2);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("No resource found for: ");
        ((StringBuilder)charSequence).append((Object)uri);
        throw new FileNotFoundException(((StringBuilder)charSequence).toString());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No package found for authority: ");
        stringBuilder.append((Object)uri);
        throw new FileNotFoundException(stringBuilder.toString());
        catch (NumberFormatException numberFormatException) {}
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Single path segment is not a resource ID: ");
        stringBuilder2.append((Object)uri);
        throw new FileNotFoundException(stringBuilder2.toString());
    }

    @Override
    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        context = super.a(context, cursor, viewGroup);
        context.setTag((Object)new a((View)context));
        ((ImageView)context.findViewById(a.f.edit_query)).setImageResource(this.o);
        return context;
    }

    public void a(int n2) {
        this.q = n2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void a(Cursor cursor) {
        if (this.p) {
            Log.w((String)"SuggestionsAdapter", (String)"Tried to change cursor after adapter was closed.");
            if (cursor == null) return;
            cursor.close();
            return;
        }
        super.a(cursor);
        if (cursor == null) return;
        try {
            this.s = cursor.getColumnIndex("suggest_text_1");
            this.t = cursor.getColumnIndex("suggest_text_2");
            this.u = cursor.getColumnIndex("suggest_text_2_url");
            this.v = cursor.getColumnIndex("suggest_icon_1");
            this.w = cursor.getColumnIndex("suggest_icon_2");
            this.x = cursor.getColumnIndex("suggest_flags");
            return;
        }
        catch (Exception exception) {
            Log.e((String)"SuggestionsAdapter", (String)"error changing cursor and caching columns", (Throwable)exception);
        }
    }

    @Override
    public void a(View object, Context object2, Cursor cursor) {
        object2 = (a)object.getTag();
        int n2 = this.x != -1 ? cursor.getInt(this.x) : 0;
        if (object2.a != null) {
            object = ai.a(cursor, this.s);
            this.a(object2.a, (CharSequence)object);
        }
        if (object2.b != null) {
            object = ai.a(cursor, this.u);
            object = object != null ? this.b((CharSequence)object) : ai.a(cursor, this.t);
            if (TextUtils.isEmpty((CharSequence)object)) {
                if (object2.a != null) {
                    object2.a.setSingleLine(false);
                    object2.a.setMaxLines(2);
                }
            } else if (object2.a != null) {
                object2.a.setSingleLine(true);
                object2.a.setMaxLines(1);
            }
            this.a(object2.b, (CharSequence)object);
        }
        if (object2.c != null) {
            this.a(object2.c, this.e(cursor), 4);
        }
        if (object2.d != null) {
            this.a(object2.d, this.f(cursor), 8);
        }
        if (this.q != 2 && (this.q != 1 || (n2 & 1) == 0)) {
            object2.e.setVisibility(8);
            return;
        }
        object2.e.setVisibility(0);
        object2.e.setTag((Object)object2.a.getText());
        object2.e.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public CharSequence b(Cursor object) {
        if (object == null) {
            return null;
        }
        String string2 = ai.a(object, "suggest_intent_query");
        if (string2 != null) {
            return string2;
        }
        if (this.l.shouldRewriteQueryFromData() && (string2 = ai.a(object, "suggest_intent_data")) != null) {
            return string2;
        }
        if (this.l.shouldRewriteQueryFromText() && (object = ai.a(object, "suggest_text_1")) != null) {
            return object;
        }
        return null;
    }

    @Override
    public View getDropDownView(int n2, View view, ViewGroup viewGroup) {
        try {
            view = super.getDropDownView(n2, view, viewGroup);
            return view;
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)"SuggestionsAdapter", (String)"Search suggestions cursor threw exception.", (Throwable)runtimeException);
            viewGroup = this.b(this.d, this.c, viewGroup);
            if (viewGroup != null) {
                ((a)viewGroup.getTag()).a.setText((CharSequence)runtimeException.toString());
            }
            return viewGroup;
        }
    }

    @Override
    public View getView(int n2, View view, ViewGroup viewGroup) {
        try {
            view = super.getView(n2, view, viewGroup);
            return view;
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)"SuggestionsAdapter", (String)"Search suggestions cursor threw exception.", (Throwable)runtimeException);
            viewGroup = this.a(this.d, this.c, viewGroup);
            if (viewGroup != null) {
                ((a)viewGroup.getTag()).a.setText((CharSequence)runtimeException.toString());
            }
            return viewGroup;
        }
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.d(this.a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        this.d(this.a());
    }

    public void onClick(View object) {
        if ((object = object.getTag()) instanceof CharSequence) {
            this.k.a((CharSequence)object);
        }
    }

    private static final class a {
        public final TextView a;
        public final TextView b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;

        public a(View view) {
            this.a = (TextView)view.findViewById(16908308);
            this.b = (TextView)view.findViewById(16908309);
            this.c = (ImageView)view.findViewById(16908295);
            this.d = (ImageView)view.findViewById(16908296);
            this.e = (ImageView)view.findViewById(a.f.edit_query);
        }
    }

}

