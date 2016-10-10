package night.sync;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.widget.TextView;

public class Start extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Loaded fragment stays in memory if it is too memory intensive switch to
    //android.support.v4.app.FragmentStatePagerAdapter
    private SectionsPagerAdapter mSectionsPagerAdapter;
    
    //Hosts section contents
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

	//Create the adapter for the fragments
	mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

	//Setting up the ViewPager
	mViewPager = (ViewPager) findViewById(R.id.container);
	mViewPager.setAdapter(mSectionsPagerAdapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Place holder fragment
    public static class PlaceHolderFragment extends Fragment {
	//Number of fragments
	private static final String ARG_SECTION_NUMBER = "section_number";

	public PlaceHolderFragment() {
	}

	//New instance of this fragment in the given section number
	public static PlaceHolderFragment newInstance(int sectionNumber) {
	    PlaceHolderFragment fragment = new PlaceHolderFragment();
	    Bundle args = new Bundle();
	    args.putInt(ARG_SECTION_NUMBER, sectionNumber);
	    fragment.setArguments(args);
	    return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
				 Bundle savedInstanceState) {
	    View rootView = inflater.inflate(R.layout.fragment_main, container, false);
	    TextView textView = (TextView) rootView.findViewById(R.id.section_label);

	    switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
	    case 1:
		textView.setText(R.string.section1);
		break;
	    case 2:
		textView.setText(R.string.section2);
		break;
	    }
	    return rootView;
	}
    }

    //Returns the correct fragment
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

	public SectionsPagerAdapter(FragmentManager fm) {
	    super(fm);
	}

	@Override
	public Fragment getItem(int position) {
	    //getItem is called to instantiate the fragment for given page returns a PlaceHolderFragment
	    return PlaceHolderFragment.newInstance(position+1);
	}

	@Override
	public int getCount() {
	    return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
	    switch (position) {
	    case 0:
		return "SECTION 1";
	    case 2:
		return "SECTION 2";
	    }

	    return null;
	}
    }
}
