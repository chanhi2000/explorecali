# explorecali
A demo project for spring boot

## Tasks
- [x] Generate a working Spring Boot project w/ [Spring Initializer][1]
- [ ] Build, deplay and launch the application

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

[1]: https://start.spring.io 
[img01]: /screenshots/[screenshot]01.png 
[img02]: /screenshots/[screenshot]02.png
