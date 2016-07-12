package org.openhab.ui.usermgmt.internal;

import org.openhab.ui.dashboard.DashboardTile;

public class UserMgmtUIDashboardTile implements DashboardTile {

    @Override
    public String getName() {
        return "User Management UI";
    }

    @Override
    public String getUrl() {
        return "../usermgmt/app";
    }

    @Override
    public String getOverlay() {
        return "html5";
    }

    @Override
    public String getImageUrl() {
        return "img/usermgmtui.png";
    }

}
