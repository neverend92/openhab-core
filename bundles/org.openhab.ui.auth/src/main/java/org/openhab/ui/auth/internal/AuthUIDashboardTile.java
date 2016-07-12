package org.openhab.ui.auth.internal;

import org.openhab.ui.dashboard.DashboardTile;

public class AuthUIDashboardTile implements DashboardTile {

    @Override
    public String getName() {
        return "User Profile";
    }

    @Override
    public String getUrl() {
        return "../auth/login";
    }

    @Override
    public String getOverlay() {
        return "html5";
    }

    @Override
    public String getImageUrl() {
        return "img/authui.png";
    }

}
