package ua.org.chupik.contributorslist;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {

    @GET("repos/{owner}/{repo}/contributors?per_page=100")
    Observable<List<User>> listContributors(@Path("owner") String owner, @Path("repo") String repo);
}
