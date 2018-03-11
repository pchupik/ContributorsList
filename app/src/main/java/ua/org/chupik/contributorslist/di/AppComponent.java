package ua.org.chupik.contributorslist.di;

import dagger.Component;
import ua.org.chupik.contributorslist.MainActivity;

@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity activity);

}