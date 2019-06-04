================================================================================
                         APIGATE AXP INTERNAL GATEWAY 4.0.0
================================================================================

APIGATE AXP is an API management and monetization
platform which supports all aspects of an API business, including creating, publishing,
consuming, discovery and monetization of APIs.

Key Features
=============

Internal Gateway Features
-------------------------
1. Improved UI for Manage Application
2. Improved traceability, ability to trace API calls with a unique ID
3. Enable response caching for APIs
4. Dep Upgarde to APIM 2.5.0
    * API Gateway/Microgateway
    * Allowing low-latency secure access to microservices
    * Protection against malicious XML and JSON Payloads at the API Gateway
    * Ability to upload certs to access back-end services using self-signed certs
5. Access Control
    * Ability to use any header to carry the Bearer token to the Gateway instead of the ‘Authorization’ header
6. General
    * Compatibility with WSO2 IAM version 5.6.0 as the Key Manager Profile
    * Bug Fixes
        * Emails are not generating for API subscription and subscription approvals
        * Request-response-logger is not available in IGW 4.0.0
        * Some links are not navigating to the correct pages in store
        * APIs are not showing in correct alignment in publisher portal
        * Displaying list view and tile view of APIs in store
        * Unable to scroll down when user click on a tag in the store
        * IGW logo changes

System Requirements
==================================

1. Minimum memory - 2GB
2. Processor      - Pentium 800MHz or equivalent at minimum
3. Java 1.8
4. The Management Console requires you to enable Javascript of the Web browser,
   with MS IE 7. In addition to JavaScript, ActiveX should also be enabled
   with IE. This can be achieved by setting your security level to
   medium or lower.
5. To build APIGATE AXP INTERNAL GATEWAY from the Source distribution, it is necessary that you have
   JDK 1.8 version and Maven 3.3.9

Installation & Running
==================================

1. Extract the downloaded zip file and go to the 'bin' directory
2. Run the wso2server.sh or wso2server.bat as appropriate
3. API Publisher web application is running at https://localhost:9443/publisher. You may login
   to the Publisher using the default administrator credentials (user: admin, pass: admin).
4. API Store web application is running at https://localhost:9443/store. You may login
   to the Store using the default administrator credentials (user: admin, pass: admin).

Documentation
==============

On-line product documentation is available at:
       https://docs.apigate.com/display/MI/INT-GW-4.0.0

Support
==================================

We are committed to ensuring that your enterprise middleware deployment is completely
supported from evaluation to production. Our unique approach ensures that all support
leverages our open development methodology and is provided by the very same engineers
who build the technology.

For additional support information please refer to https://support.wso2telco.com

Known issues of APIGATE AXP INTERNAL GATEWAY 4.0.0
=====================================

All the open issues pertaining to APIGATE AXP INTERNAL GATEWAY 4.0.0 :

    https://jira.wso2telco.com/jira/browse/INTGW-407
    https://jira.wso2telco.com/jira/browse/INTGW-408
    https://jira.wso2telco.com/jira/browse/INTGW-410
    https://jira.wso2telco.com/jira/browse/INTGW-411
    https://jira.wso2telco.com/jira/browse/INTGW-412
    https://jira.wso2telco.com/jira/browse/INTGW-416
    https://jira.wso2telco.com/jira/browse/INTGW-420
    https://jira.wso2telco.com/jira/browse/INTGW-427
    https://jira.wso2telco.com/jira/browse/INTGW-429
    https://jira.wso2telco.com/jira/browse/INTGW-434
    https://jira.wso2telco.com/jira/browse/INTGW-435
    https://jira.wso2telco.com/jira/browse/INTGW-436
    https://jira.wso2telco.com/jira/browse/INTGW-437
    https://jira.wso2telco.com/jira/browse/INTGW-438
    https://jira.wso2telco.com/jira/browse/INTGW-440
    https://jira.wso2telco.com/jira/browse/INTGW-426
    https://jira.wso2telco.com/jira/browse/INTGW-444
    https://jira.wso2telco.com/jira/browse/INTGW-445
    https://jira.wso2telco.com/jira/browse/INTGW-467
    https://jira.wso2telco.com/jira/browse/INTGW-469

Issue Tracker
==================================

Help us make our software better. Please submit any bug reports or feature
requests through the APIGATE AXP JIRA system:

    https://jira.wso2telco.com/jira/projects/INTGW/issues

--------------------------------------------------------------------------------
(c) Copyright 2019 Apigate.
