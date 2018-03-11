package ua.org.chupik.contributorslist;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import ua.org.chupik.contributorslist.di.AppModule;

import static org.junit.Assert.*;

public class ExampleUnitTest {

    @Before
    public void setUp(){
        TestComponent component = DaggerTestComponent.builder()
                .appModule(new AppModule())
                .build();

        component.inject(this);
    }

    @Inject GitHubService gitHubService;

    @Test
    public void creatingGitHubService_isCorrect() throws Exception {

        assertNotNull("api should not be null", gitHubService.getApi());
        assertTrue("api should be GitHubApi", gitHubService.getApi() instanceof GitHubApi);
        assertNotNull(gitHubService.getContributors());
    }
}