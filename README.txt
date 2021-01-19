================================================================================
                         AXP GATEWAY 5.0.0 - RC1
================================================================================

AXP is an API management and monetization
platform which supports all aspects of an API business, including creating, publishing,
consuming, discovery and monetization of APIs.

Key Features
=============

External Gateway Features
-------------------------
1. Dep upgrade to APIM 3.2.0
    * Internal Gateway and External Gateway Workflows supported
    * WSO2 APM Version 3.2.0 features - https://apim.docs.wso2.com/en/latest/getting-started/about-this-release/

System Requirements
==================================

1. Minimum memory - 2GB
2. Processor      - Pentium 800MHz or equivalent at minimum
3. Java 1.8
4. The Management Console requires you to enable Javascript of the Web browser,
   with MS IE 7. In addition to JavaScript, ActiveX should also be enabled
   with IE. This can be achieved by setting your security level to
   medium or lower.
5. To build AXP EXTERNAL GATEWAY from the Source distribution, it is necessary that you have
   JDK 1.8 version and Maven 3.3.9

Installation & Running
==================================

Databases
=========


    Create databases with following names
        devtproduserstoredb
        devtprodregdb
        devtprodapimgtdb
        devtproddepdb
        devtprodratedb
        devtprodapistatsdb
        devtprodactivitidb

    source 
        wso2telcohub-5.0.0-SNAPSHOT/dbscripts/mysql.sql for devtproduserstoredb
        wso2telcohub-5.0.0-SNAPSHOT/dbscripts/mysql.sql for devtprodregdb
        wso2telcohub-5.0.0-SNAPSHOT/dbscripts/apimgt/mysql.sql for devtprodapimgtdb
        wso2telcohub-5.0.0-SNAPSHOT/dbscripts/dep-hub/mysql/dep_db.sql for devtproddepdb
        wso2telcohub-5.0.0-SNAPSHOT/dbscripts/dep-hub/mysql/rate_db.sql for devtprodratedb
        wso2telcohub-5.0.0-SNAPSHOT/dbscripts/dep-hub/mysql/stats_db.sql for devtprodapistatsdb
        Tables will be created on runtime for devtprodactivitidb

Run add the following table under AM DB - devtprodapimgtdb

CREATE TABLE IF NOT EXISTS AM_API_SCOPES (
   API_ID  INTEGER NOT NULL,
   SCOPE_ID  INTEGER NOT NULL,
   FOREIGN KEY (API_ID) REFERENCES AM_API (API_ID) ON DELETE CASCADE  ON UPDATE CASCADE,
   FOREIGN KEY (SCOPE_ID) REFERENCES IDN_OAUTH2_SCOPE (SCOPE_ID) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = INNODB;




Deploying pack
============
TM - Profile Setup
==============
Goto /bin
chmod 777 profilesetup.sh wso2server.sh
backup internal#data#v1.war in run profilesetup.sh
copy internal#data#v1.war to Attached the deployment.toml files for each pack. repositiry/conf/deployment_TM.toml - Replace trafficmanager instance deployment.toml in /repository/conf/deployment.toml
Download and copy mysql-connector-java-5.1.40-bin.jar to /lib
mysql-connector-java-5.1.40-bin.jar - http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.40/mysql-connector-java-5.1.40.jar
start server /bin/
sh wso2server.sh -Dprofile=traffic-manager


Gateway Setup
============

Goto /bin

chmod 777 profilesetup.sh wso2server.sh
backup internal#data#v1.war in run profilesetup.sh
copy internal#data#v1.war to Attached the deployment.toml files for each pack. repositiry/conf/deployment_GW.toml - Replace gateway instance deployment.toml in /repository/conf/deployment.toml
Download and copy mysql-connector-java-5.1.40-bin.jar to /lib
mysql-connector-java-5.1.40-bin.jar - http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.40/mysql-connector-java-5.1.40.jar

start server /bin/
sh wso2server.sh -Dprofile=gateway-worker


Portal Setup
==========

repositiry/conf/deployment_PTL.toml - Replace portal instance deployment.toml in /repository/conf/deployment.toml
Download and copy mysql-connector-java-5.1.40-bin.jar to /lib
mysql-connector-java-5.1.40-bin.jar - http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.40/mysql-connector-java-5.1.40.jar

start server /bin/

Add following parameter based on deployment type

External Gateway
================
-DDEPLOYMENT_TYPE=external_gateway \

Internal Gateway
=================
-DDEPLOYMENT_TYPE=internal_gateway_type2 \

sh wso2server.sh ( will do a profile start later )


sh wso2server.sh

Go to Admin portal with admin user credentials.Under resident key manager add admin username and password for key manager.

KM Setup
========

download km pack from - https://sftp-release-binaries.s3.amazonaws.com/sftp/apim320/wso2is-km-5.10.0%2B1605108146035.full.zip
https://apim.docs.wso2.com/en/latest/install-and-setup/setup/distributed-deployment/configuring-wso2-identity-server-as-a-key-manager/
Refer the guide and execute Step 4 - Configure WSO2 IS with WSO2 API-M
Repleace deployment.toml file as below instruction.
repositiry/conf/deployment_KM.toml - Replace keymanager instance deployment.toml in /repository/conf/deployment.toml
Download and copy mysql-connector-java-5.1.40-bin.jar to /lib
mysql-connector-java-5.1.40-bin.jar - http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.40/mysql-connector-java-5.1.40.jar

start server /bin/
sh wso2server.sh ( will do a profile start later )

Documentation
==============

On-line product documentation is available at:
       --

Support
==================================

We are committed to ensuring that your enterprise middleware deployment is completely
supported from evaluation to production. Our unique approach ensures that all support
leverages our open development methodology and is provided by the very same engineers
who build the technology.

For additional support information please refer to https://support.wso2telco.com

Issue Tracker
==================================

Help us make our software better. Please submit any bug reports or feature
requests through the AXP JIRA system:

    https://jira.wso2telco.com/jira/projects/EXTGW/issues

--------------------------------------------------------------------------------
(c) Copyright 2021 AXP.
