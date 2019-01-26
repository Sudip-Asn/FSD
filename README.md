# FSD

# FSD-SBA-PROJECT:Project Manager
# Name: Sudip Chatterjee
# Please refer to the "documents" folder which contain the following sub-folders
1.	Application_Screenshots : This contains application screenshots of all screens.
2.	MySQL Script : This contains table design and the DDL commands
3.	Emma_Coverage_Reports : This contains the junit test cases, emma code coverage report and screenshots.
4.	Jmeter Reports : This contains the screenshots of the jmeter execution on the rest end-point designed
5.	Jenkins : This contains the screenshots of the jenkins pipeline creation,execution and the build report
# Following are the projects structure:Project Manager
1.	"projectmanager-server" - The spring boot project using Rest API, JPA etc running in the back-end
2.	"projectmanager-web" - The angular project using HTML5,CS3,Bootstrap4 running in the front end
# Instructions for cloud lab VM:
•	The entire project code base is present in the path C:\Users\Admin\Desktop\FSD_Repository within the cloud lab VM.
•	The full stack projectmanager jar file(post-build) is present in the path C:\Users\Admin\Desktop\FSD_Repository\projectmanager-parent\projectmanager-server\target.
•	In order to run the application, open a command prompt(cmd.exe),navigate to the jar path mentioned above and run the command:java -jar jarname (projectmanager-API-0.0.1-SNAPSHOT.jar)
•	Open a web browser(google chrome) and use the URL:https://localhost:8090 to access the application
# Final Build Commands:
•	Maven: clean install -e [The UI code is build using "frontend-maven-plugin" and is packed inside the JAR artifacts itself. Refer projectmanager-web pom.xml](Command is mvn clean install)
•	Docker: package docker:build[spotify "docker-maven-plugin" is used to create image in the remote docker. configuration : pom.xml of projectmanager-server](Command is mvn package docker:build)
# Local Deployment Commands:
•	Spring boot in projectmanager-server folder: spring-boot:run
•	Angular ui in web folder of projectmanager-web: npm install -> npm start
# Jenkins:
1.	GitHub Branches to build: */master
2.	Jenkins script Path: projectmanager-server/Jenkinsfile
