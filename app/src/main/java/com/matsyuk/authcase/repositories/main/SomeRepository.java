package com.matsyuk.authcase.repositories.main;

import com.matsyuk.authcase.domain.main.SomeModel;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public interface SomeRepository {
    Single<SomeModel> getData();
}
