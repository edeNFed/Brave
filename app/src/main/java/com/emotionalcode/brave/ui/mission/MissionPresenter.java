package com.emotionalcode.brave.ui.mission;

import com.emotionalcode.brave.data.DataManager;
import com.emotionalcode.brave.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by edenfed on 08/02/2016.
 */
public class MissionPresenter extends BasePresenter<MissionMvpView> {
    private final DataManager mDataManager;

    @Inject
    public MissionPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }
}
