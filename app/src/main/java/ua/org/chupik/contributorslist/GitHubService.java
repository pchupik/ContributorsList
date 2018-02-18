package ua.org.chupik.contributorslist;

import java.util.List;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubService {

    private static GitHubService instance;
    private GitHubApi api;
    private AsyncSubject<List<User>> asyncSubject;

    public static GitHubService getInstance() {
        if (instance == null)
            instance = new GitHubService();
        return instance;
    }

    private GitHubService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(GitHubApi.class);
    }

    public AsyncSubject<List<User>> getContributors() {
        if (asyncSubject == null) {
            asyncSubject = AsyncSubject.create();

            api.listContributors("JakeWharton","butterknife")
                    .subscribeOn(Schedulers.io())
                    .subscribe(asyncSubject);
        }
        return asyncSubject;
    }

    public GitHubApi getApi() {
        return api;
    }
}
