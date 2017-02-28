package com.folioreader.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codetoart.r2_streamer.model.publication.Link;
import com.folioreader.Constants;
import com.folioreader.activity.FolioActivity;
import com.folioreader.fragments.FolioPageFragment;
import com.folioreader.smil.TextElement;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.SpineReference;

/**
 * Created by mahavir on 4/2/16.
 */
public class FolioPageFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Link> mSpineReferences;
    private String mEpubFileName;
    private FolioPageFragment mFolioPageFragment;


    public FolioPageFragmentAdapter(FragmentManager fm, List<Link> spineReferences, String epubFileName) {
        super(fm);
        this.mSpineReferences = spineReferences;
        this.mEpubFileName = epubFileName;
        FolioActivity.BUS.register(this);
    }

    @Override
    public Fragment getItem(int position) {
        mFolioPageFragment = FolioPageFragment.newInstance(position, mEpubFileName, mSpineReferences.get(position).getHref());
        mFolioPageFragment.setFragmentPos(position);
        return mFolioPageFragment;
    }

    @Override
    public int getCount() {
        return mSpineReferences.size();
    }

}
