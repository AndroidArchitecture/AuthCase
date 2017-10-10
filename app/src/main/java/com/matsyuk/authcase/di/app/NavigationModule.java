package com.matsyuk.authcase.di.app;

import android.content.Context;

import com.matsyuk.authcase.GlobalNavigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * @author e.matsyuk
 */
@Module
public class NavigationModule {

    private Context context;
    private Cicerone<Router> cicerone;

    public NavigationModule(Context context) {
        this.context = context;
        cicerone = Cicerone.create();
    }

    @Singleton
    @Provides
    Router provideRouter() {
        return cicerone.getRouter();
    }

    @Singleton
    @Provides
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    @Singleton
    @Provides
    Navigator provideGlobalNavigator() {
        return new GlobalNavigator(context);
    }

}
