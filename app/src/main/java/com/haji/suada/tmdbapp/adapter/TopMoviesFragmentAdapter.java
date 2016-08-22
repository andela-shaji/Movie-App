package com.haji.suada.tmdbapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.haji.suada.tmdbapp.fragments.TopMoviesFragment;

/**
 * Created by suadahaji.
 */
public class TopMoviesFragmentAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "TOP MOVIES", "UPCOMING", "NOW PLAYING", "POPULAR" };
    private Context context;

    public TopMoviesFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        return TopMoviesFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
