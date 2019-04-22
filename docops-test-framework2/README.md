## DocOps2-Automation

Below instructions will let you run a copy of the selenium automation project for docops2 automation on your local machine for testing purpose. 

### **Pre-Requisites**
In order to execute slenium test scripts - your machine should have Java Installed (1.8 preferaably) and Maven installed and configurred
configure Maven Environment Variable , set the Environment Variable pointing to the Maven directory (M2_HOME=maven directory) and include the vriable in Path variable also : Add %M2_HOME%\bin; to Path variable

**Installing**

Pull the current repository from Git 

**Running the tests**

Go to the command prompt and navigate to the directory containing the pom.xml file and Run "maven clean test"  command
This should trigger the Selenium Automates Test cases on the defined URL and the defined browser
