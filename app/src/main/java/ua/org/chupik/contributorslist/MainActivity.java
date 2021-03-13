package ua.org.chupik.contributorslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Inject GitHubService gitHubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getApplicationContext()).getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        loadList();
    }

    private void loadList(){
        gitHubService
                .getContributors()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showResults);
    }

    private void showResults(List<User> users) {
        UsersAdapter adapter = new UsersAdapter(users);
        recyclerView.setAdapter(adapter);
    }
}
