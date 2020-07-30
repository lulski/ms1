# Lulski JAVA practice
## SpringBoot microservice with mongodb

### Notes
*"run mongodb windows 10"*
_"C:\Program Files\MongoDB\Server\4.2\bin\mongod.exe" --dbpath="c:\projects\data\db"_


>#create index in mongodb collection to prevent duplicate entity
>db.nav_menu_item.createIndex({"text":1},{unique:true})



TODO:
* find out how to override repository.save(), but still be able to use spring default implementaion of save()
  https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories

  

