        ================================================================================
                                        WSO2Telco DEP Gateway
        ================================================================================
        
---

| Branch | Build Status |
| :------------ |:-------------
| master | [![Build Status](http://ci.wso2telco.com/job/product-dep/badge/icon)](http://ci.wso2telco.com/job/product-dep)|

---

WSO2Telco DEP(Digital Enablement Platform) is an API management and monetization 
platform which supports all aspects of an API business, including creating, publishing, 
consuming, discovery and monetization of APIs.

WSO2Telco DEP can function as an:

* External Gateway
	- Expose and govern all your APIs using a common platform.

* Internal Gateway
	- Expose and share APIs within an organizations business units. 
	- APIs can be restricted to specific user groups and API governance can be controlled by the API owners.

For more information on WSO2Telco DEP Gateway please visit https://wso2telco.com/gateways.

Key Features
=============

External Gateway Features
-------------------------
* 100% open source
* Full featured API management
* Smart orchestration and workflow
* Secure exposure of MNO services over REST APIs
* Built-in MNO-specific adapters (SMPP, Webservices and Diameter)
* Insulates the MNO core network elements from external developers
* Built-in Mobile Connect compliant Identity Gateway and Authenticator libraries
* Built in ACR module for anonymising MSISDNs locally
* Pre-built integration to the Hub and other GSMA API Exchanges

Internal Gateway Features
-------------------------
* Freely download and deploy Mobile Connect features
* Complete API management capabilities provided by the renowned WSO2 API Manager
* Discovery and governance layer for internal APIs and microservices framework
* Application and subscription approval workflow enabling governance, ownership, and accountability to be maintained for all approved applications supporting multiple teams that publish APIs
* Manage access and discoverability of APIs based on user roles
* Library of connectors to integrate to most standard-based components and common vendor interfaces

System Requirements
==================================

1. Minimum memory - 2GB
2. Processor      - Pentium 800MHz or equivalent at minimum
3. Java 1.8
4. The Management Console requires you to enable Javascript of the Web browser,
   with MS IE 7. In addition to JavaScript, ActiveX should also be enabled
   with IE. This can be achieved by setting your security level to
   medium or lower.
5. To build WSO2Telco DEP Gateway from the Source distribution, it is necessary that you have
   JDK 1.8 version and Maven 3.3.9

Installation & Running
==================================

1. Extract the downloaded zip file and go to the 'bin' directory
2. Run the wso2server.sh or wso2server.bat as appropriate
3. API Publisher web application is running at http://localhost:9763/publisher. You may login
   to the Publisher using the default administrator credentials (user: admin, pass: admin).
4. API Store web application is running at http://localhost:9763/store. You may login
   to the Store using the default administrator credentials (user: admin, pass: admin).

Documentation
==============

On-line product documentation is available at:
       http://docs.wso2telco.com:8090/pages/viewpage.action?pageId=1507678

Support
==================================

We are committed to ensuring that your enterprise middleware deployment is completely 
supported from evaluation to production. Our unique approach ensures that all support 
leverages our open development methodology and is provided by the very same engineers 
who build the technology.

For additional support information please refer to https://wso2telco.com/services

Known issues of WSO2Telco DEP Gateway
=====================================

All the open issues pertaining to WSO2Telco DEP Gateway are reported at the following location:

    https://jira.wso2telco.com/jira/issues/?filter=12805

Issue Tracker
==================================

Help us make our software better. Please submit any bug reports or feature
requests through the WSO2Telco JIRA system:

    https://jira.wso2telco.com/jira/secure/Dashboard.jspa?selectPageId=10500

--------------------------------------------------------------------------------
(c) Copyright 2016 WSO2Telco.
