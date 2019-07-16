package sg.edu.rp.c346.knowyourfacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;

    Button btnLater;

    int reqeustCode = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewpager1);
        btnLater = findViewById(R.id.btnLater);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());

        adapter = new MyFragmentPagerAdapter(fm, al);
        vPager.setAdapter(adapter);

        btnLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                c.add(Calendar.MINUTE,5);

                Intent i = new Intent(MainActivity.this, Receiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, reqeustCode, i, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
                Toast.makeText(MainActivity.this, "Notification has been set to 5 minutes...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_next){
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max - 1) {
                int next = vPager.getCurrentItem() + 1;
                vPager.setCurrentItem(next, true);
            }
            return true;

            } else if (id == R.id.action_previous){
                if (vPager.getCurrentItem() > 0){
                    int previous = vPager.getCurrentItem() - 1;
                    vPager.setCurrentItem(previous, true);
                }
                return true;

            } else if (id == R.id.action_random){
                setRandomPage();

            }


        return super.onOptionsItemSelected(item);

    }


    private void setRandomPage() {

        Random random = new Random();

        int page = random.nextInt(3);

        if (page != vPager.getCurrentItem()) {

            vPager.setCurrentItem(page, true);

        } else {

            setRandomPage();

        }
    }

}
