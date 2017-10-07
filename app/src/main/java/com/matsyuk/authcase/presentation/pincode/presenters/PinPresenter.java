package com.matsyuk.authcase.presentation.pincode.presenters;

import com.matsyuk.authcase.domain.main.PinInteractor;

/**
 * @author e.matsyuk
 */
public class PinPresenter {

    private PinInteractor pinInteractor;

    public PinPresenter(PinInteractor pinInteractor) {
        this.pinInteractor = pinInteractor;
    }

    public void setNewPinCode(String pinCode) {
        pinInteractor.updatePinCode(pinCode);
    }

}
