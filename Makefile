run_all_in_parallel:
	make clean_it test_chrome

clean_it:
	mvn clean 

test_parallel:
	make -j test_firefox test_ie test_chrome

test_firefox:
	mvn install -Dbrowser=firefox -Dtest=JunitRunner -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit

test_ie:
	mvn install -Dbrowser=IE -Dtest=JunitRunner -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit

test_safari:
	mvn install -Dbrowser=safari -Dtest=JunitRunner -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit

test_chrome:
	mvn install -Dbrowser=chrome -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit

test_local:
    mvn install -Dbrowser=chrome -Dlocal=true -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit