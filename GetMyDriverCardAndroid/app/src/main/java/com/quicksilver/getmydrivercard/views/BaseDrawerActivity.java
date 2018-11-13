package com.quicksilver.getmydrivercard.views;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.quicksilver.getmydrivercard.R;
import com.quicksilver.getmydrivercard.views.requests.RequestsActivity;
import com.quicksilver.getmydrivercard.views.step1.Step1Activity;
import com.quicksilver.getmydrivercard.views.users.login.LoginActivity;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;
    private int mIdentifier;
    private String mUsername;
    private AccountHeader accountHeader;

    public BaseDrawerActivity() {

    }

    public void setupDrawer() {
        PrimaryDrawerItem requestItem = new PrimaryDrawerItem()
                .withIdentifier(RequestsActivity.IDENTIFIER)
                .withIcon(GoogleMaterial.Icon.gmd_home)
                .withSelectable(true)
                .withName("Request");
        PrimaryDrawerItem ste1Item = new PrimaryDrawerItem()
                .withIdentifier(Step1Activity.IDENTIFIER)
                .withIcon(GoogleMaterial.Icon.gmd_ac_unit)
                .withSelectable(true)
                .withName("Step1");
        PrimaryDrawerItem userItem = new PrimaryDrawerItem()
                .withIdentifier(LoginActivity.IDENTIFIER)
                .withIcon(GoogleMaterial.Icon.gmd_verified_user)
                .withSelectable(true)
                .withName("User");

        AccountHeader headerResult = getAccountHeader();

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withSliderBackgroundColor(Color.GRAY)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        userItem,
                        new DividerDrawerItem(),
                        ste1Item,
                        requestItem
                ).withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    mIdentifier = (int) drawerItem.getIdentifier();

                    if (getIdentifier() == mIdentifier) {
                        return false;
                    }

                    Intent intent = getNextIntent(mIdentifier);

                    if (intent == null) {
                        return false;
                    }

                    startActivity(intent);
                    return true;
                }).withSelectedItem(getIdentifier())
                .build();
    }

    private Intent getNextIntent(int identifier) {
        Intent intent = null;

        switch (identifier) {
            case RequestsActivity.IDENTIFIER:
                intent = new Intent(this, RequestsActivity.class);
                break;
            case Step1Activity.IDENTIFIER:
                intent = new Intent(this, Step1Activity.class);
                break;
            case LoginActivity.IDENTIFIER:
                intent = new Intent(this, LoginActivity.class);
                break;
            default:
                break;
        }

        return intent;
    }

    protected abstract int getIdentifier();

    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }

    protected void setUsername(String username) {
        mUsername = username;
    }

    private AccountHeader getAccountHeader() {
        return new AccountHeaderBuilder()
                .withActivity(this)
                .addProfiles(
                        new ProfileDrawerItem().withName(mUsername).withIcon(R.drawable.user)
                )
                .withOnAccountHeaderListener((view, profile, current) -> false)
                .build();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
//    }
}

