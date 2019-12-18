
# APIGATE Accelerator Platform 

        
---

| Branch | Build Status |
| :------------ |:-------------
| master | [![Build Status](http://ci.wso2telco.com:8080/job/product-hub/badge/icon)](http://ci.wso2telco.com:8080/view/IGW%20400%20Nightly%20Build/job/product-hub-NB/)|

---

APIGATE Accelerator Platform (Apigate AXP) is an API management and monetization 
platform which supports all aspects of an API business, including creating, publishing, 
consuming, discovery and monetization of APIs.

Key Features
=============

Internal Gateway Features
-------------------------
1)Productized MBSS compliance

        -Centralized login functionality
        -Ability to lock user accounts upon repeated failed attempts
        -Session management feature
        -Ability to define user activity periods
        -Password recovery via email link
        -Account suspension feature/email notification
        -Change/reset password feature & password validator
        -Facilitate for the user to create password while account is created by admin
        -Display last login time in store
        -Periodic password change feature
        -Idle account locking feature
        -Password History validation

2)Security Improvements - password validator in store 
3)Ability to secure APIs with Basic Authentication
4)Logging user activity
5)Generate REST API from SOAP Backend
6)Support for Open API Specification (Swagger) version 3.0

System Requirements
==================================

1. Minimum memory - 2GB
2. Processor      - Pentium 800MHz or equivalent at minimum
3. Java 1.8
4. The Management Console requires you to enable Javascript of the Web browser,
   with MS IE 7. In addition to JavaScript, ActiveX should also be enabled
   with IE. This can be achieved by setting your security level to
   medium or lower.
5. To build APIGATE AXP from the Source distribution, it is necessary that you have
   JDK 1.8 version and Maven 3.3.9

Installation & Running
==================================

1. Extract the downloaded zip file and go to the 'bin' directory
2. Run the axpserver.sh or axpserver.bat as appropriate
3. API Publisher web application is running at https://localhost:9443/publisher. You may login
   to the Publisher using the default administrator credentials (user: admin, pass: admin).
4. API Store web application is running at https://localhost:9443/store. You may login
   to the Store using the default administrator credentials (user: admin, pass: admin).

Documentation
==============

On-line product documentation is available at:
       https://docs.apigate.com/display/MI/INT-GW-4.0.1

Support
==================================

We are committed to ensuring that your enterprise middleware deployment is completely 
supported from evaluation to production. Our unique approach ensures that all support 
leverages our open development methodology and is provided by the very same engineers 
who build the technology.

For additional support information please refer to [Apigate Support](https://support.wso2telco.com)

Known issues  of APIGATE AXP INTERNAL GATEWAY
=====================================

1 	https://jira.wso2telco.com/jira/browse/INTGW-635
2 	https://jira.wso2telco.com/jira/browse/INTGW-636 
3 	https://jira.wso2telco.com/jira/browse/INTGW-694 
4 	https://jira.wso2telco.com/jira/browse/INTGW-695 
5 	https://jira.wso2telco.com/jira/browse/INTGW-534 
6 	https://jira.wso2telco.com/jira/browse/INTGW-537
7 	https://jira.wso2telco.com/jira/browse/INTGW-671
8 	https://jira.wso2telco.com/jira/browse/INTGW-865
9 	https://jira.wso2telco.com/jira/browse/INTGW-811 
10 	https://jira.wso2telco.com/jira/browse/INTGW-859	
11 	https://jira.wso2telco.com/jira/browse/INTGW-863
12 	https://jira.wso2telco.com/jira/browse/INTGW-862 
13 	https://jira.wso2telco.com/jira/browse/INTGW-866 
14 	https://jira.wso2telco.com/jira/browse/INTGW-444

All the open issues pertaining to APIGATE AXP INTERNAL GATEWAY 4.0.1 :

    https://jira.wso2telco.com/jira/browse/**
    
Issue Tracker
==================================

Help us make our software better. Please submit any bug reports or feature
requests through the WSO2Telco JIRA system:

    https://jira.wso2telco.com/jira/projects/INTGW/issues
    
### Big Thanks

Cross-browser Testing Platform and Open Source &#10084; Provided by 
![Alt text](https://github.com/WSO2Telco/product-hub/blob/master/images/LOGO_Sauce-Labs_Horiz_Red-Grey_RGB.png)
 https://saucelabs.com	
	
	
--------------------------------------------------------------------------------
(c) Copyright 2019 Apigate.
