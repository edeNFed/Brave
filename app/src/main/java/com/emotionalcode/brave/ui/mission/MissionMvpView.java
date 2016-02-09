package com.emotionalcode.brave.ui.mission;

import com.emotionalcode.brave.ui.base.MvpView;

/**
 * Created by edenfed on 08/02/2016.
 */
public interface MissionMvpView extends MvpView {
    void doMission();
    void timeoutMission();
    void cancelMission();
}
