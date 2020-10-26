// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.view.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.feilang.mvpproject.util.TextViewUtils;
import android.widget.TextView;
import android.view.ViewGroup;
import android.util.AttributeSet;
import android.content.Context;
import me.yokeyword.fragmentation.SupportFragment;
import android.support.design.widget.TabLayout;

public class CommonTabLayout extends TabLayout
{
    private SupportFragment[] mFragments;
    private String[] mTabTitles;
    
    public CommonTabLayout(final Context context) {
        this(context, null);
    }
    
    public CommonTabLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public CommonTabLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    public void changeTabsTextSize() {
        final ViewGroup viewGroup = (ViewGroup)this.getChildAt(0);
        for (int i = 0; i < this.getTabCount(); ++i) {
            final ViewGroup viewGroup2 = (ViewGroup)viewGroup.getChildAt(this.getTabAt(i).getPosition());
            for (int childCount = viewGroup2.getChildCount(), j = 0; j < childCount; ++j) {
                final View child = viewGroup2.getChildAt(j);
                if (child instanceof TextView) {
                    TextViewUtils.resizeTextView((TextView)child, 5.0f);
                }
            }
        }
    }
    
    public PagerFragmentAdapter getFragmentAdapter(final FragmentManager fragmentManager) {
        return new PagerFragmentAdapter(fragmentManager);
    }
    
    public void initData(String[] mTabTitles, final SupportFragment[] mFragments) {
        this.mTabTitles = mTabTitles;
        this.mFragments = mFragments;
        mTabTitles = this.mTabTitles;
        for (int length = mTabTitles.length, i = 0; i < length; ++i) {
            this.newTab().setText(mTabTitles[i]);
        }
    }
    
    public class PagerFragmentAdapter extends FragmentPagerAdapter
    {
        public PagerFragmentAdapter(final FragmentManager fragmentManager) {
            super(fragmentManager);
        }
        
        @Override
        public int getCount() {
            return CommonTabLayout.this.mTabTitles.length;
        }
        
        @Override
        public Fragment getItem(final int n) {
            return (Fragment)CommonTabLayout.this.mFragments[n];
        }
        
        @Override
        public CharSequence getPageTitle(final int n) {
            return CommonTabLayout.this.mTabTitles[n];
        }
    }
}
