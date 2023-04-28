-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files

mysql -hcontainers-us-west-26.railway.app -uroot -pgVDZMqxqVi49mCLM9lbP --port 7327 --protocol=TCP railway 

exit

mysql -hcontainers-us-west-26.railway.app -uroot -pgVDZMqxqVi49mCLM9lbP --port 7327 --protocol=TCP railway < beers.sql
mysql -hcontainers-us-west-26.railway.app -uroot -pgVDZMqxqVi49mCLM9lbP --port 7327 --protocol=TCP railway < breweries.sql
mysql -hcontainers-us-west-26.railway.app -uroot -pgVDZMqxqVi49mCLM9lbP --port 7327 --protocol=TCP railway < categories.sql
mysql -hcontainers-us-west-26.railway.app -uroot -pgVDZMqxqVi49mCLM9lbP --port 7327 --protocol=TCP railway < geocodes.sql
mysql -hcontainers-us-west-26.railway.app -uroot -pgVDZMqxqVi49mCLM9lbP --port 7327 --protocol=TCP railway < styles.sql
