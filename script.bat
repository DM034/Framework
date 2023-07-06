cd framework/src
javac -parameters -d . *.java
jar -cvf ../../etu1808.jar etu1808
copy ../../etu1808.jar ../../test-framework/WEB-INF/lib/

set CLASSPATH=.;C:\Program Files\Apache Software Foundation\Tomcat 8.5_Tomcat8Oni\webapps\etu1808.jar

cd ../../test-framework/WEB-INF/classes
javac -parameters -d . *.java
cd ../../
jar -cvf ../test-framework.war .

cd ../
pause
