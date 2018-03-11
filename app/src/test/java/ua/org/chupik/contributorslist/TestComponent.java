package ua.org.chupik.contributorslist;

import dagger.Component;
import ua.org.chupik.contributorslist.di.AppComponent;
import ua.org.chupik.contributorslist.di.AppModule;

@Component(modules = {AppModule.class})
public interface TestComponent extends AppComponent{

    void inject(ExampleUnitTest test);

}