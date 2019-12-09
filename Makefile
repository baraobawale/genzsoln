run_all_in_parallel:
	make clean_it test_chrome

clean_it:
	mvn clean 

test_parallel:
	make -j test_firefox test_ie test_chrome

test_firefox:
	mvn install -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit -Dbrowser=firefox -Dtest=JunitRunner 

test_ie:
	mvn install -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit -Dbrowser=IE -Dtest=JunitRunner 

test_safari:
	mvn install -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit -Dbrowser=safari -Dtest=JunitRunner 

test_chrome:
	mvn install -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit -Dbrowser=chrome -Dtest=JunitRunner 

test_local:
    mvn install -Djavax.net.ssl.trustStore=/export/home/jenkins/certs/trust.jks -Djavax.net.ssl.trustStorePassword=changeit -Dbrowser=chrome -Dlocal=true 