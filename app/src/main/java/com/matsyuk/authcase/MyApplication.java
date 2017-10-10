package com.matsyuk.authcase;

import android.app.Application;

import com.matsyuk.authcase.di.ComponentManager;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

/**
 * @author e.matsyuk
 */
public class MyApplication extends Application {

    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Navigator globalNavigator;

    @Override
    public void onCreate() {
        super.onCreate();
        ComponentManager.getInstance().initAppComponent(getApplicationContext());
        ComponentManager.getInstance().getAppComponent().inject(this);
        navigatorHolder.setNavigator(globalNavigator);
    }

}
