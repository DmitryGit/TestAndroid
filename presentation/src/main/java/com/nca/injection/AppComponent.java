package com.nca.injection;

import com.nca.presentation.screen.user.UserViewModel;
import com.nca.presentation.screen.user.UserViewModelForHome9;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    public void inject(UserViewModel userViewModel);
    public void inject(UserViewModelForHome9 userViewModelForHome9);


}
