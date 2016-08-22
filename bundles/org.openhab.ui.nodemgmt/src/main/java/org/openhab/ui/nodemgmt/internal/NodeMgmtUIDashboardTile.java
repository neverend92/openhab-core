package org.openhab.ui.nodemgmt.internal;

import org.openhab.ui.dashboard.DashboardTile;

public class NodeMgmtUIDashboardTile implements DashboardTile {

    @Override
    public String getName() {
        return "Node Management UI";
    }

    @Override
    public String getUrl() {
        return "../nodemgmt/app";
    }

    @Override
    public String getOverlay() {
        return "html5";
    }

    @Override
    public String getImageUrl() {
        // TODO create new image for it.
        return "img/usermgmtui.png";
    }

}
