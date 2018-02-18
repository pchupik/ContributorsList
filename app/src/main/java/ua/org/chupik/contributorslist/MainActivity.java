package ua.org.chupik.contributorslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        loadList();
    }

    private void loadList(){
        GitHubService.getInstance()
                .getContributors()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showResults);
    }

    private void showResults(List<User> users) {
        UsersAdapter adapter = new UsersAdapter(users);
        recyclerView.setAdapter(adapter);
    }
}
