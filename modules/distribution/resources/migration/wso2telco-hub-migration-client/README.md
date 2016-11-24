# WSO2.Telco HUB Migration Client

This is used to migrate wso2telcohub product to 2.0.0

This includes two main tasks,
	- Remove Custom Handlers declared in synapse configuration files which are no more needed.
	- Apply the existing tiers used for Application approval instead of default APIM tiers.	

How to use,
    - 
    - Start the server with -DmigrateTier=true to migrate custom application tiers
   
