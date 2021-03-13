package ua.org.chupik.contributorslist

import android.app.Application
import ua.org.chupik.contributorslist.di.AppComponent
import ua.org.chupik.contributorslist.di.AppModule
import ua.org.chupik.contributorslist.di.DaggerAppComponent

class App : Application() {

    var appComponent : AppComponent = createAppComponent()

    private fun createAppComponent(): AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
}