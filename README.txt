================================================================================
                         APIGATE AXP EXTERNAL GATEWAY 3.0.0
================================================================================

APIGATE AXP is an API management and monetization
platform which supports all aspects of an API business, including creating, publishing,
consuming, discovery and monetization of APIs.

Key Features
=============

External Gateway Features
-------------------------
1. Improved UI for Manage Application
    * Added further granularity for Blacklist/Whitelist
2. Improved traceability, ability to trace API calls with a unique ID
3. Dep upgrade to APIM 2.5.0
    * API Gateway/Microgateway
    * Allowing low-latency secure access to microservices
    * Protection against malicious XML and JSON Payloads at the API Gateway
    * Ability to upload certs to access back-end services using self-signed certs
4. Access Control
    * Ability to use any header to carry the Bearer token to the Gateway instead of the ‘Authorization’ header
    * Ability to restrict view/edit rights of APIs to selected user groups on the API Publisher
5. API Design and Documentation
    * Allow adding additional properties for APIs and searching by them​
    * Enhanced support for exposing SOAP services as REST APIs by auto-generating the REST interface by parsing the WSDL of the SOAP Service

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
       https://docs.apigate.com/display/MI/EXT-GW-3.0.0

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
requests through the APIGATE AXP JIRA system:

    https://jira.wso2telco.com/jira/projects/EXTGW/issues

--------------------------------------------------------------------------------
(c) Copyright 2019 Apigate.
