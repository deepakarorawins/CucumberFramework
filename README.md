# CucumberFramework








# Run Cucumber Test from Command Line / Terminal
For successful implementation of any testing framework, it is mandatory that test cases can be run in multiple ways so that people with different competency levels can use it how they need to. Because running any test framework from the Terminal has its own advantages, such as overriding the run configurations mentioned in the code. So, now we will focus on various ways to run the Cucumber tests.

# Run Cucumber Test from Command Line / Terminal
There are different ways to run Cucumber Test from command line. Tests can be run by using JUnit and Maven as well. But maven is the most suggested way and has extra benefits to it. This is why we started this Project as Maven project. And remember, Maven has a lot of advantages over other build tools, such as dependency management, lots of plugins and the convenience of running integration tests. Maven will allow our test cases to be run in different flavors, such as from the **Terminal**, integrating with **Jenkins**, and **parallel execution**.

# Maven Project
If in case you directly landed to this tutorial from search and not following this complete **Selenium Cucumber Framework series**, I suggest you to go through the first chapter of **End 2 End Selenium Test**. This chapter covers all the prerequisite for running test from Maven. Also to make sure that you have the below mentioned dependencies added in your Maven Project:
[pom.xml](https://github.com/deepakarorawins/CucumberFramework/blob/master/pom.xml)

# Run Test from Command Line
1. Open the **command prompt** and **cd** until the project root directory.
2. First, let’s run all the Cucumber Scenarios from the command prompt. Since it’s a Maven project and we have added Cucumber in **test scope** dependency and all features are also added in **src/test** packages, run the following command in the command prompt: <b><font color="blue">mvn test</font></b>

You would notice below that it actually triggered the **TestRunner** file.

Build Success Output

<font color="blue"><b>Note</b>: mvn test runs Cucumber Features using Cucumber’s JUnit Runner. The @RunWith (Cucumber.class) annotation on the TestRunner class tells JUnit to kick off Cucumber. Cucumber run time parses the command-line options to know what Feature to run, where the Glue Code lives, what plugins to use, and so on.
On the other hand, if you run test from eclipse when you use the JUnit Runner, these options are generated from the @CucumberOptions annotation on your test.</font>

# Overriding Cucumber Options
At times, you would need to override the configurations specified
in @CucumberOptions. If we want to override the configurations mentioned in the Runner, then we need to use following command: <font color="blue"><b>mvn test –DCucumber.options=”Your Options”</b></font>
If you need help on these Cucumber options, then enter the following command in the command prompt and look at the output: <font color="blue"><b>mvn test - Dcucumber.options=”–help”</b></font>

<font color="blue"><b>Note</b>:This gives you the list of parameters that can be passed through command line using CucumberOptions.</font>

# Running a Scenario from Command Line
If we want to run single Scenario from the cmd, this is how we
specify : <font color="blue">mvn test -Dcucumber.options=”feature file path” + “line number of the scenario”</font>

<font color="blue"><b>Note</b>: In the preceding code, “5” is the Feature file line number where a Scenario starts.</font>

# Running Scenarios using Tags from Command Line
If you want to run the test cases associated to Tags, this is how we specify: <font color="blue">mvn test -Dcucumber.options=”–tags @tag Name”</font>

# Overriding Report Plugin and Path
If you want to generate a different report or if you wish to change the report path. This how you do it: <font color="blue">mvn test -Dcucumber.options=”–plugin junit:target/cucumber-reports/report.xml”.</font>
Please look at our **Cucumber Report** to see what all reports you can generate using @CucumberOptions.

# Running a Feature file only from Command Line
If you want cucumber to run just a single feature file or multiple feature file, you can pass parameter for the same from command line. This how you do it:
<font color="blue">mvn test - Dcucumber.options=”src/test/resources/functionalTests/End2End_Tests.f eature”</font>

# Passing multiple Parameter at once
Its also possible to pass multiple options at once. This is how it can be done <font color="blue">mvn test -Dcucumber.options=”SomeThing” - Dcucumber.options=”SomeThing” -Dcucumber.options=”SomeThing”</font> <b>mvn test - Dcucumber.options=”src/test/resources/functionalTests/End2En d_Tests.feature” <font color="blue">-Dcucumber.options=”–tags @Smoke”</font></b>

