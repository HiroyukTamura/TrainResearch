package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.C0143R;
import androidx.core.content.res.ResourcesCompat;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p009e.p028d.p064d.p065a.p066a.C1567a;

class BrowserActionsFallbackMenuAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<BrowserActionItem> mMenuItems;

    static class ViewHolderItem {
        ImageView mIcon;
        TextView mText;

        ViewHolderItem() {
        }
    }

    BrowserActionsFallbackMenuAdapter(List<BrowserActionItem> list, Context context) {
        this.mMenuItems = list;
        this.mContext = context;
    }

    public int getCount() {
        return this.mMenuItems.size();
    }

    public Object getItem(int i) {
        return this.mMenuItems.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolderItem viewHolderItem;
        BrowserActionItem browserActionItem = this.mMenuItems.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(C0143R.layout.browser_actions_context_menu_row, (ViewGroup) null);
            viewHolderItem = new ViewHolderItem();
            viewHolderItem.mIcon = (ImageView) view.findViewById(C0143R.C0145id.browser_actions_menu_item_icon);
            viewHolderItem.mText = (TextView) view.findViewById(C0143R.C0145id.browser_actions_menu_item_text);
            view.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) view.getTag();
        }
        final String title = browserActionItem.getTitle();
        viewHolderItem.mText.setText(title);
        if (browserActionItem.getIconId() != 0) {
            viewHolderItem.mIcon.setImageDrawable(ResourcesCompat.getDrawable(this.mContext.getResources(), browserActionItem.getIconId(), (Resources.Theme) null));
        } else if (browserActionItem.getIconUri() != null) {
            final C1567a<Bitmap> loadBitmap = BrowserServiceFileProvider.loadBitmap(this.mContext.getContentResolver(), browserActionItem.getIconUri());
            loadBitmap.addListener(new Runnable() {
                public void run() {
                    Bitmap bitmap;
                    if (TextUtils.equals(title, viewHolderItem.mText.getText())) {
                        try {
                            bitmap = (Bitmap) loadBitmap.get();
                        } catch (InterruptedException | ExecutionException unused) {
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            viewHolderItem.mIcon.setVisibility(0);
                            viewHolderItem.mIcon.setImageBitmap(bitmap);
                            return;
                        }
                        viewHolderItem.mIcon.setVisibility(4);
                        viewHolderItem.mIcon.setImageBitmap((Bitmap) null);
                    }
                }
            }, new Executor() {
                public void execute(Runnable runnable) {
                    runnable.run();
                }
            });
        } else {
            viewHolderItem.mIcon.setImageBitmap((Bitmap) null);
            viewHolderItem.mIcon.setVisibility(4);
        }
        return view;
    }
}
