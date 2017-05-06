# explorecali
A demo project for spring boot

## Tasks
- [x] Generate a working Spring Boot project w/ [Spring Initializer][1]
- [x] Build, deplay and launch the application
- [x] Added the domain models
- [x] Added 2 models (repos, services) that manage Tour and TourPackage data 
 
## Features
#### v0.0.1 (first commit)
Generate a Spring Boot Project (maven) with the help of [Spring Initializer][1]
![img01][img01] 
> I added the following dependencies for this specific project
>  - web
>  - rest repository
>  - jpa
>  - h2

You can also generate the same by using `curl` command line. For instance,
```shell
curl -o explorecali.zip http://start.spring.io/
       starter.zip?
       name=explorecali&groupId=com.markiiimark.ec&artifactId=explore
       cali&version=0.0.1-
       SNAPSHOT&description=Demo+project+for+Spring+Boot&packageN
       ame=com.example.ec&type=maven-
       project&packaging=jar&javaVersion=1.8&language=java&bootVe
       rsion=1.5.2.RELEASE&dependencies=h2&dependencies=data-
       jpa&dependencies=web&dependencies=data-rest 
```	 

Then build, deply, and luanch the application. 

First, unzip the project
```shell
unzip explorecali.zip
```
Then, go to the directory that your project is unzipped
```shell
cd explorecali
```
Check you currently installed the latest jdk and apache maven
```shell
java -version
mvn -version
```
If so, then type this `mvn` command that will download required dependencies into your local repo
```shell
mvn install
```
If the `.jar` file is successfully compiled, run it 
```shell
java -jar target/explorecali-0.0.1-SNAPSHOT.jar
```
__NOTE__: add this flag to modify the port you want to test on
```shell
java -jar -Dserver.port=[NUMBER_OF_PORT] target/explorecali-0.0.1-SNAPSHOT.jar
```
![img02][img02]

#### v0.0.2
Create a set of appropriate domain models
- `Difficutly.java`
- `Region java`
- `TourPacakge.java`
- `Tour.java`

This is the UML diagram that represents our models' relationship to one another
![img03][img03]

#### v0.0.3
Create repo and service models that manage Tour and TourPackage, using their repos

#### v0.0.4
Modify `ExplorecaliApplication.java` and added methods to initialize Tours and TourPacakges for testing spring data query.

A Simple test of our RESTful API.
- ###### `GET https://localhost:8080`
![img04][img04]    
- ###### `GET https://localhost:8080/tourPackages`
![img05][img05]
- ###### `GET https://localhost:8080/tourPackages/BC`
![img06][img06]
- ###### `POST https://localhost:8080/tourPackages`  
![img07][img07] 
- ###### `GET https://localhost:8080/tourPacakges` after status 201 
![img08][img08] 
- ###### `GET https://localhost:8080/tourPacakges/ZC`
![img09][img09]

[1]: https://start.spring.io 
[img01]: /screenshots/[screenshot]01.png 
[img02]: /screenshots/[screenshot]02.png
[img03]: /screenshots/[screenshot]03.png
[img04]: /screenshots/[screenshot]04.png
[img05]: /screenshots/[screenshot]05.png
[img06]: /screenshots/[screenshot]06.png
[img07]: /screenshots/[screenshot]07.png
[img08]: /screenshots/[screenshot]08.png
[img09]: /screenshots/[screenshot]09.png
