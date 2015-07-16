package com.trainerworkout.trainee;

import java.sql.SQLException;
import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.trainerworkout.trainee.adapter.NavDrawerListAdapter;
import com.trainerworkout.trainee.database.DatabaseHelper;
import com.trainerworkout.trainee.fragment.ChatFragment;
import com.trainerworkout.trainee.fragment.FeedbackFragment;
import com.trainerworkout.trainee.fragment.MyWorkoutsFragment;
import com.trainerworkout.trainee.fragment.ProfileFragment;
import com.trainerworkout.trainee.helper.BackHandledFragment;
import com.trainerworkout.trainee.helper.CurrentUser;
import com.trainerworkout.trainee.helper.BackHandledFragment.BackHandlerInterface;
import com.trainerworkout.trainee.model.drawer.NavDrawerFirstItem;
import com.trainerworkout.trainee.model.drawer.NavDrawerItem;
import com.trainerworkout.trainee.model.rest.UserModel;
import com.trainerworkout.trainee.notification.ToastNotification;

public class MainActivity extends FragmentActivity {

	private BackHandledFragment selectedFragment;

	// Menu Variables
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	// nav drawer title
	private CharSequence mDrawerTitle;
	// used to store app title
	private CharSequence mTitle;
	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;
	private ArrayList<Object> navDrawerItems;
	private NavDrawerListAdapter adapter;

	// Class Variables
	private static final String TAG = MainActivity.class.getSimpleName();

	// User information
	Integer user_id;

	/**
	 * Create the side menu and link fragments
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Retrieve user ID
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
			user_id = extras.getInt("user_id");
			saveCurrentUserID(user_id);
		}
		// Fetch current user
		UserModel user = CurrentUser.fetch(getApplicationContext());

		mTitle = mDrawerTitle = getTitle();

		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		navDrawerItems = new ArrayList<Object>();

		// First drawer 
		navDrawerItems.add(new NavDrawerFirstItem(user.getFirstName(),user.getImage()));
		// Profile
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons
				.getResourceId(0, -1)));
		// My Workouts
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons
				.getResourceId(1, -1)));
		// Chat
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons
				.getResourceId(2, -1)));
		// Feedback
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons
				.getResourceId(3, -1)));
		// Logout
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons
				.getResourceId(4, -1)));

		// Recycle the typed array
		navMenuIcons.recycle();

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, // nav menu toggle icon
				R.string.app_name, // nav drawer open - description for
				// accessibility
				R.string.app_name // nav drawer close - description for
				// accessibility
				) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
	}

	/**
	 * MENU CONFIGURATION: Methods to handle menu operations <br/>
	 * - onCreateOptionsMenu<br/>
	 * - onOptionsItemSelected<br/>
	 * - onPrepareOptionsMenu<br/>
	 * - onConfigurationChanged<br/>
	 * - onPostCreate<br/>
	 * - setTitle<br/>
	 * - displayView<br/>
	 * <br/>
	 * 
	 * Inner class: SlideMenuClickListener
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/***
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
	ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	public void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new ProfileFragment();
			break;
		case 1:
			fragment = new ProfileFragment();
			break;
		case 2:
			fragment = new MyWorkoutsFragment();
			break;
		case 3:
			fragment = new ChatFragment();
			break;
		case 4:
			fragment = new FeedbackFragment();
			break;
		case 5:
			new ToastNotification.Builder(this.getApplicationContext())
			.withNotification("Will Logout")
			.show();
			break;
		default:
			break;
		}

		
		
		if (fragment != null) {
			FragmentTransaction mFragmentTransaction = getFragmentManager()
	                .beginTransaction();
			mFragmentTransaction.addToBackStack(null)
			.replace(R.id.frame_container, fragment).commit();
			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			if(position == 0)
				setTitle(navMenuTitles[position]);
			else
				setTitle(navMenuTitles[position-1]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void onBackPressed() {
		if (getFragmentManager().getBackStackEntryCount() == 0) {
			this.finish();
		} else {
			getFragmentManager().popBackStack();
		}
	}

	/**
	 * Save the current user ID to retrieve his info
	 * @param userID
	 */
	private void saveCurrentUserID(int userID){
		SharedPreferences sp = getSharedPreferences("USER_PREFERENCES", Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putInt("CURRENT_USER_ID", userID);
		editor.commit();
	}
	
}
