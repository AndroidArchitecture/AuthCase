package com.matsyuk.authcase.di;

import com.matsyuk.authcase.di.app.AppComponent;
import com.matsyuk.authcase.di.app.DaggerAppComponent;

/**
 * @author e.matsyuk
 */
public class ComponentManager {

    private static volatile ComponentManager instance;
    private AppComponent appComponent;

    public static ComponentManager getInstance() {
        if (instance == null) {
            synchronized (ComponentManager.class) {
                if (instance == null) {
                    instance = new ComponentManager();
                }
            }
        }
        return instance;
    }

    private ComponentManager() {}

    public void initAppComponent() {
        appComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
