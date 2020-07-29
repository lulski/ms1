
"run mongodb windows 10"
"C:\Program Files\MongoDB\Server\4.2\bin\mongod.exe" --dbpath="c:\projects\data\db"


#create index in mongodb collection to prevent duplicate entity
db.nav_menu_item.createIndex({"text":1},{unique:true})