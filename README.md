# Person API

Practice project developed during [GFT START #2 Bootcamp](https://digitalinnovation.one/bootcamps/gft-start-2-java),
offered by Digital Innovation One.
---
## Introduction

This project handles a simple CRUD for basic info about people, like first name, last name, phones, CPF (Brazilian
acronym for "Cadastro de Pessoas Físicas" or "Physical Person Registration") and birthdate. The goal is to study the
main concepts of REST Architecture, and, by that, creating a RESTful API. Also, the course teaches how to simply deploy
in the cloud platform [Heroku](https://www.heroku.com/).
---
## REST and RESTful

REST is an acronym for **RE**presentational **S**tate **T**ransfer, an architectural pattern used to help to implement
web services. A RESTful service, or a RESTful API, is a web service that implements this architecture. For an API to
be considered RESTful, it must attend to the following criteria:

- Must implement Client/Server architecture;
- Must have a Uniform Interface (i.e., in short, must use the standard methods of HTTP protocol, such as GET, POST, PUT
  and DELETE, among others. Each method must be properly used. There are other details, like proper response codes.);
- Must be **Stateless**: each request made by a client must be independent of the others. That means that the server
should not store client's contexts and each request must have all the information needed for the server to process an
  adequate response;
- Cacheability: cache improves scalability and performance of a client-server interaction. A request can be defined as 
  cacheable or non-cacheable;
- Layered system: dividing a system into different layers makes the system more flexible to changes.

A RESTful service is simply a service that implements REST Architecture!
--
## Tools and Methods used

1. **Spring Boot**: [Spring project](https://spring.io/projects/spring-boot) that makes significantly easier to start
   Spring projects by simply adding starters 
   inside pom.xml.
2. **Intellij Community Edition**:  [Jetbrains](https://www.jetbrains.com/pt-br/idea/) IDE focused on languages that run
   in JVM (mainly Java, of course).
3. **Postman**: [Development app](https://www.postman.com/) that tests API endpoints.
4. **Spring Initializr**: a [website](https://start.spring.io/) that automatically generates a base Spring Boot project,
   based on the configs passed to it.
5. **Git/Github**: [Git](https://git-scm.com/) is a free and open source distributed version control.
   [Github](https://github.com/) is a repository hosting service which brings several tools to manage a project based on
   Git.
6. **Gitflow Workflow**: as the name says, a
   [git workflow](https://www.atlassian.com/br/git/tutorials/comparing-workflows/gitflow-workflow)
   that consist on creating a complementary
   branch called develop, then implementing each feature in new branches, merging those "feature branches" into develop.
   When develop branch is stable, then it merges into the main branch.
7. **Heroku**: a cloud platform as a service (PaaS) that supports deployments of web apps' projects.

## Useful links

Base URL to app deployed in Heroku: https://personapi-fvgs.herokuapp.com/api/v1/people


