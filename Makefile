run_all_in_parallel:
	make clean_it test_chrome

clean_it:
	mvn clean 

test_parallel:
	make -j test_firefox test_ie test_chrome

test_firefox:
	mvn install -Dbrowser=firefox

test_ie:
	mvn install -Dbrowser=IE

test_safari:
	mvn install -Dbrowser=safari

test_chrome:
	mvn install -Dbrowser=chrome

test_local:
    mvn install -Dbrowser=chrome -Dlocal=true