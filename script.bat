cd Framework/src
javac -parameters -d . *.java
jar -cvf ../../etu1808.jar etu1808
copy ../../etu1808.jar ../../TestFramework/WEB-INF/lib/

set CLASSPATH=.;C:\Program Files\Apache Software Foundation\Tomcat 8.5_Tomcat8Oni\webapps\etu1808.jar

cd ../../TestFramework/WEB-INF/classes
javac -parameters -d . *.java
cd ../../
jar -cvf ../TestFramework.war .

cd ../
pause
