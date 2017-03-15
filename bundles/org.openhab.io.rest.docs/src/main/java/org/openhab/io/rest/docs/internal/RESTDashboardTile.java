/**
 * Copyright (c) 2015-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.io.rest.docs.internal;

import org.eclipse.smarthome.core.auth.AuthenticatedHttpContext;
import org.openhab.ui.dashboard.DashboardTile;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The dashboard tile for the REST API,
 * also registers the Swagger UI as a web resource on the HTTP service
 *
 * @author Kai Kreuzer
 *
 */
public class RESTDashboardTile implements DashboardTile {

    private static final String ALIAS = "/doc";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private HttpService httpService;

    protected void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }

    protected void unsetHttpService(HttpService httpService) {
        this.httpService = null;
    }

    protected void activate(ComponentContext componentContext) {
        try {
            AuthenticatedHttpContext authHttpContext = new AuthenticatedHttpContext(
                    componentContext.getBundleContext().getBundle());
            httpService.registerResources(ALIAS, "swagger", authHttpContext);
            logger.debug("Started REST documentation service at: {}", ALIAS);
        } catch (NamespaceException e) {
            logger.error("Could not start up REST documentation service: {}", e.getMessage());
        }
    }

    protected void deactivate(ComponentContext componentContext) {
        httpService.unregister(ALIAS);
    }

    @Override
    public String getName() {
        return "REST API Docs";
    }

    @Override
    public String getUrl() {
        return "../doc/index.html";
    }

    @Override
    public String getOverlay() {
        return null;
    }

    @Override
    public String getImageUrl() {
        return "../doc/images/dashboardtile.png";
    }

}
