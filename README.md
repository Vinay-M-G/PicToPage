# PicToPage

A Java based Standalone Application to help Testers / developers to capture screenshots and convert to a desired document.

Spring Framework is utilized to improve performance by implementing the concepts of Dependency Injection and Inversion of Control.  

## Benefits

  - As End User No Need to do Take ScreenShot and Paste it to Document Every Time.
  
  - Supports Dual Formats (PDF and Word) (In Progress)
  
  - StandAlone Application which can be customised to end user needs.
  

## System Requirements

  - Java JDK 11 or higher
  - Apache Maven 3.x.x or higher
  
## How to Use for code changes 

  ```
   1. clone the project 
   2. Open CMD in the directory where the project is cloned
   3. Execute the following commands 
       mvn clean install assembly:single
       cd target
       java -jar PicToPage-1.0-jar-with-dependencies.jar
  ```

## Downloads and usage

To download the latest version of the Application, use the below link

    https://pic-to-page.s3.ap-south-1.amazonaws.com/executableJar/target/PicToPage-1.0-jar-with-dependencies.jar

After downloading successfully, open cmd in the downloaded location and run the below command

    java -jar PicToPage-1.0-jar-with-dependencies.jar