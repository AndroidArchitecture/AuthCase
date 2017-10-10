package com.matsyuk.authcase;

import android.content.Context;
import android.content.Intent;

import com.matsyuk.authcase.presentation.pincode.views.PinCodeActivity;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

/**
 * The cut-down version of GlobalNavigator
 *
 * @author e.matsyuk
 */
public class GlobalNavigator implements Navigator {

    public final static String PIN_SCREEN = "pin_screen";

    private Context context;

    public GlobalNavigator(Context context) {
        this.context = context;
    }

    @Override
    public void applyCommand(Command command) {
        if (command instanceof Forward) {
            Forward forward = (Forward) command;
            if (forward.getScreenKey().equals(PIN_SCREEN)) {
                Intent intent = new Intent(context, PinCodeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }
    }

}
