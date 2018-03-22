package com.nca.injection;

import com.nca.data.net.RestApi;
import com.nca.data.net.RestService;
import com.nca.data.repository.UserRepositoryImpl;
import com.nca.domain.interactors.GetUserByIdUseCase;
import com.nca.presentation.screen.user.UserViewModel;
import com.nca.presentation.screen.user.UserViewModelForHome9;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    public void inject(UserViewModel userViewModel);
//    public void inject(UserViewModelForHome9 userViewModelForHome9);
//    public void inject(GetUserByIdUseCase getUserByIdUseCase);
//    public void inject(UserRepositoryImpl userRepository);


}
