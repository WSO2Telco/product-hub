package com.wso2telco.hub.custom.tier.migration.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.core.ServerStartupObserver;
import org.wso2.carbon.registry.core.service.RegistryService;

import com.wso2telco.hub.custom.tier.migration.TierMigartionClient;

/**
 * @scr.component name="tier.migation.component" immediate="true"
 * @scr.reference name="registry.service"
 * interface="org.wso2.carbon.registry.core.service.RegistryService"
 * cardinality="1..1" policy="dynamic" bind="setRegistryService"
 * unbind="unsetRegistryService"
 */

public class TierMigrationCompnent {
    private static final Log log = LogFactory
	    .getLog(TierMigrationCompnent.class);

    protected void activate(ComponentContext ctx) throws Exception {

	if (log.isDebugEnabled()) {
	    log.debug("TierMigrationCompnent activating");
	}
	ctx.getBundleContext().registerService(
		ServerStartupObserver.class.getName(),
		new TierMigartionClient(), null);
    }

    protected void deactivate(ComponentContext ctx) throws Exception {

	if (log.isDebugEnabled()) {
	    log.debug("TierMigrationCompnent de-activating");
	}
    }

    protected void setRegistryService(RegistryService registryService) {
	if (registryService != null && log.isDebugEnabled()) {
	    log.debug("Registry service initialized");
	}
	ServiceReferenceHolder.getInstance()
		.setRegistryService(registryService);
    }

    protected void unsetRegistryService(RegistryService registryService) {
	ServiceReferenceHolder.getInstance().setRegistryService(null);
    }
}
