package ua.org.chupik.contributorslist;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
//JakeWharton
    //butterknife
    @GET("repos/{owner}/{repo}/contributors")
    Observable<List<User>> listContributors(@Path("owner") String owner, @Path("repo") String repo);
}
