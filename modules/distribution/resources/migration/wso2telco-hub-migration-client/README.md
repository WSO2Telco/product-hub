# WSO2.Telco HUB Migration Client

This is used to migrate wso2telcohub product to 2.0.0

This includes two main tasks,

	- Remove Custom Handlers declared in synapse configuration files which are no more needed.
	- Apply the existing tiers used for Application approval instead of default APIM tiers.	

How to use,

	- Copy the com.wso2telco.hub.custom.tier.migration-1.0.X.jar file to the <wso2telcohub_HOME>/repository/components/dropins directory.
	- Start the server with -DmigrateTier=true to migrate custom application tiers
	- Run the RemoveCustomHandler.sh script in SynapseMigration folder and give the path to wso2telcohub_HOME while execution.
   
