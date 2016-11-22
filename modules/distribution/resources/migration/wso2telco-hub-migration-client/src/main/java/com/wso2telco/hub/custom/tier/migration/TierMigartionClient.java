/**
 * Copyright (c) 2016, WSO2.Telco Inc. (http://www.wso2telco.com) All Rights Reserved.
 *
 * WSO2.Telco Inc. licences this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wso2telco.hub.custom.tier.migration;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.core.ServerStartupObserver;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.service.RegistryService;
import org.wso2.carbon.registry.core.session.UserRegistry;
import org.wso2.carbon.utils.CarbonUtils;

import com.wso2telco.hub.custom.tier.migration.internal.ServiceReferenceHolder;

public class TierMigartionClient implements ServerStartupObserver {

    private static final String APIMGT_REGISTRY_LOCATION = "/" + "apimgt";
    private static final String API_APPLICATION_DATA_LOCATION = APIMGT_REGISTRY_LOCATION
	    + "/" + "applicationdata";
    private static final String DEFAULT_TIERS_FILE = "default-tiers" + "/"
	    + "default-tiers.xml";
    private static final String APP_TIERS_FILE = "app-tiers.xml";

    private static final String APP_TIERS_LOCATION = API_APPLICATION_DATA_LOCATION
	    + "/" + APP_TIERS_FILE;

    public static final String ARG_MIGRATE_TIER = "migrateTier";

    private static final Log log = LogFactory.getLog(TierMigartionClient.class);

    private void updateAppTierConfigsInRegistry() {

	boolean isTierMigration = Boolean.parseBoolean(System
		.getProperty(ARG_MIGRATE_TIER));
	if (!isTierMigration) {

	    if (log.isDebugEnabled()) {
		log.debug("Skipping the Tier configuration update in registry");
	    }
	    return;
	}

	RegistryService registryService = ServiceReferenceHolder.getInstance()
		.getRegistryService();

	UserRegistry govRegistry = null;
	// get governance registry
	try {
	    govRegistry = registryService.getGovernanceSystemRegistry();
	} catch (RegistryException e) {
	    handleError("Error in getting Governance Registry", e);
	}

	byte[] data;

	String resourcesDirectory = CarbonUtils.getCarbonHome()
		+ File.separator + "repository" + File.separator + "resources";
	// check if a default-tiers.xml is available in the
	// <APIM_HOME>/repository/resources/default-tiers
	File defaultTiersFile = new File(resourcesDirectory + File.separator
		+ DEFAULT_TIERS_FILE);
	if (defaultTiersFile.exists()) {
	    data = readDefaultTierConfigFile(resourcesDirectory);
	    if (data != null && data.length > 0) {
		// delete the existing application tier config file in the
		// registry
		deleteExistingAppTierConfig(govRegistry);
		// update
		updateAppTierConfigs(govRegistry, data);
		log.info("Successfully updated the Application tiers configuration at "
			+ APP_TIERS_LOCATION);
	    }
	} else {
	    if (log.isDebugEnabled()) {
		log.debug("No custom " + DEFAULT_TIERS_FILE
			+ " file found at carbon resources directory");
	    }
	}
    }

    /**
     * Read the default tier configuration file from
     * <CARBON_HOME>/repository/resources/default-tiers
     *
     * @param resourcesDirectory
     *            full path to <CARBON_HOME>/repository/resources/default-tiers
     * @return file content as bytes
     */
    private byte[] readDefaultTierConfigFile(String resourcesDirectory) {
	byte[] data = null;

	try {
	    data = readAllBytes(get(resourcesDirectory + File.separator
		    + DEFAULT_TIERS_FILE));
	} catch (IOException e) {
	    handleError("Error reading default-tiers.xml from "
		    + resourcesDirectory, e);
	}
	return data;
    }

    /**
     * Update the app tiers configurations with new settings
     *
     * @param govRegistry
     *            Governance Registry object
     * @param data
     *            new content to be updated
     */
    private void updateAppTierConfigs(UserRegistry govRegistry, byte[] data) {
	Resource resource = null;
	try {
	    resource = govRegistry.newResource();
	} catch (RegistryException e) {
	    handleError("Error creating new registry resource", e);
	}

	try {
	    resource.setContent(data);
	} catch (RegistryException e) {
	    handleError("Error creating new registry resource", e);
	}

	try {
	    govRegistry.put(APP_TIERS_LOCATION, resource);
	} catch (RegistryException e) {
	    handleError("Error creating new registry resource", e);
	}
    }

    /**
     * Deletes the existing app tiers configuration resource in the registry, if
     * it exists
     *
     * @param govRegistry
     *            Governance Registry object
     */
    private void deleteExistingAppTierConfig(UserRegistry govRegistry) {
	try {
	    // check if the app-tiers.xml alraedy exists in the
	    // registry, if so delete it
	    if (govRegistry.resourceExists(APP_TIERS_LOCATION)) {
		log.info("Application tiers configuration already available in the registry, "
			+ "trying to overwrite");
		govRegistry.delete(APP_TIERS_LOCATION);
	    }
	} catch (RegistryException e) {
	    handleError("Error checking existence of Application tiers at "
		    + APP_TIERS_LOCATION, e);
	}
    }

    private void handleError(String errorMsg, RegistryException e) {

	log.error(errorMsg, e);
	throw new RuntimeException(errorMsg, e);
    }

    private void handleError(String errorMsg, IOException e) {

	log.error(errorMsg, e);
	throw new RuntimeException(errorMsg, e);
    }

    // Any work that needs to be performed after completion of starting all the
    // transports
    public void completedServerStartup() {

	if (log.isDebugEnabled()) {
	    log.debug("Completed Server Startup");
	}
    }

    // Any work that needs to be performed before starting all the transports
    public void completingServerStartup() {

	if (log.isDebugEnabled()) {
	    log.debug("Completing Server Startup");
	}

	updateAppTierConfigsInRegistry();

    }
}
