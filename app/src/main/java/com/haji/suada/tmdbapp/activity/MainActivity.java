package com.haji.suada.tmdbapp.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.haji.suada.tmdbapp.R;
import com.haji.suada.tmdbapp.adapter.ViewPageAdapter;
import com.haji.suada.tmdbapp.fragments.NowPlayingMoviesFragments;
import com.haji.suada.tmdbapp.fragments.PopularMoviesFragments;
import com.haji.suada.tmdbapp.fragments.TopMFragments;
import com.haji.suada.tmdbapp.fragments.UpcomingMoviesFragments;
import com.haji.suada.tmdbapp.helpers.Constants;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initCollapsingToolbar();

       /* ImageView thumbnail = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load("http://image.tmdb.org/t/p/w185/956xMjH4sPoqimqoLOP6AI19mjm.jpg").into(thumbnail);
*/


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.slidingTabs);
        tabLayout.setupWithViewPager(viewPager);



        if (Constants.API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TopMFragments(), "TOP RATED");
        adapter.addFragment(new UpcomingMoviesFragments(), "UPCOMING");
        adapter.addFragment(new NowPlayingMoviesFragments(), "NOW PLAYING");
        adapter.addFragment(new PopularMoviesFragments(), "POPULAR");
        viewPager.setAdapter(adapter);
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitleEnabled(false);
        ImageView header = (ImageView) findViewById(R.id.backdrop);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.backdrop);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener(){
            @SuppressWarnings("ResourceType")
            @Override
            public void onGenerated(Palette palette) {
                int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimaryDark);
                collapsingToolbar.setContentScrimColor(vibrantColor);
                collapsingToolbar.setStatusBarScrimColor(vibrantDarkColor);

            }
        });



        /*AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });*/
    }
}
