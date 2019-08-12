package com.d2h2.recettes.di.module;


import com.d2h2.recettes.ui.main.MainActivity;
import com.d2h2.recettes.ui.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}