package ua.org.chupik.contributorslist.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.org.chupik.contributorslist.GitHubApi;
import ua.org.chupik.contributorslist.GitHubService;

@Module
public class AppModule {

    @Provides @Singleton
    GitHubService provideGitHubService(GitHubApi api){
        return new GitHubService(api);
    }

    @Provides
    GitHubApi provideGitHubApi(Retrofit retrofit){
        return retrofit.create(GitHubApi.class);
    }

    @Provides
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}