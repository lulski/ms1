# Lulski Java practice repo

### SpringBoot microservice with mongodb

### How to notes:
- build the docker image using gradle
> ./gradlew bootBuildImage --imageName=lulski/ms1

- run the docker image
> docker-compose up


- "run mongodb windows 10"*

>_"C:\Program Files\MongoDB\Server\4.2\bin\mongod.exe" --dbpath="c:\projects\data\db"_


>#create index in mongodb collection to prevent duplicate entity
>db.nav_menu_item.createIndex({"text":1},{unique:true})




### TODO:
* find out how to override repository.save(), but still be able to use spring default implementaion of save()
  https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories

  
* restructure the code  https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3
