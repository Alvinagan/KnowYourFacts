package sg.edu.rp.c346.knowyourfacts;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> al) {

        super(fm);

        fragments = al;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
