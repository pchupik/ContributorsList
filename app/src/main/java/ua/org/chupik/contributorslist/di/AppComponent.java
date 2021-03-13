package ua.org.chupik.contributorslist.di;

import javax.inject.Singleton;

import dagger.Component;
import ua.org.chupik.contributorslist.MainActivity;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity activity);

}