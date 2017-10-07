package com.matsyuk.authcase.di;

import com.matsyuk.authcase.di.main.DaggerMainComponent;
import com.matsyuk.authcase.di.main.MainComponent;

/**
 * @author e.matsyuk
 */
public class ComponentManager {

    private static volatile ComponentManager instance;
    private MainComponent mainComponent;

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

    public void initMainComponent() {
        mainComponent = DaggerMainComponent.builder().build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }

}
