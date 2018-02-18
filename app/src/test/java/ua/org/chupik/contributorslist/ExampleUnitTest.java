package ua.org.chupik.contributorslist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    @Test
    public void creatingGitHubService_isCorrect() throws Exception {

        GitHubService gitHubService = GitHubService.getInstance();
        assertNotNull("api should not be null", gitHubService.getApi());
        assertTrue("api should be GitHubApi", gitHubService.getApi() instanceof GitHubApi);
        assertNotNull(gitHubService.getContributors());
    }
}