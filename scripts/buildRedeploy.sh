#!/bin/sh

echo "************ UNDEPLOYING *******************"
/opt/devel/as/glassfish3/bin/asadmin undeploy jeedemo
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
/opt/devel/as/glassfish3/bin/asadmin deploy target/jeedemo.war
