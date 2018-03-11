package ua.org.chupik.contributorslist;

import java.util.List;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;

public class GitHubService {

    private GitHubApi api;
    private AsyncSubject<List<User>> asyncSubject;

    public GitHubService(GitHubApi gitHubApi) {
        api = gitHubApi;
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
