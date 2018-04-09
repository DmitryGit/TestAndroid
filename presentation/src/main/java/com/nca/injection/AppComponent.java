package com.nca.injection;

import com.nca.presentation.screen.hw11.UserViewModelHW11;
import com.nca.presentation.screen.hw11.UserViewModelHW11e;
import com.nca.presentation.screen.user.UserViewModel;
import com.nca.presentation.screen.user.UserViewModelCW14;
import com.nca.presentation.screen.user.usermvp.SignUserPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    public void inject(UserViewModel userViewModel);
    public void inject(UserViewModelHW11 userViewModel);
    public void inject(UserViewModelHW11e userViewModel);
    public void inject(UserViewModelCW14 userViewModel);
    public void inject(SignUserPresenter signUserPresenter);
//    public void inject(GetUserByIdUseCase getUserByIdUseCase);
//    public void inject(UserRepositoryImpl userRepository);


}
