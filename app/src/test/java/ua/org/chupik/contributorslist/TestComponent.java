package ua.org.chupik.contributorslist;

import javax.inject.Singleton;

import dagger.Component;
import ua.org.chupik.contributorslist.di.AppComponent;
import ua.org.chupik.contributorslist.di.AppModule;

@Singleton
@Component(modules = {AppModule.class})
public interface TestComponent extends AppComponent{

    void inject(ExampleUnitTest test);

}