Rest Api with PostgresQL DB

Before run app you should create connection to DB(all settings check in applications.properties)

In your Rest-client you must do auth(admin(all references) or user(only /user))

You can:

1)admin/add - create new user 2)admin/delete/{id} - delete user with id:{id} 3)admin/getAll - get all users 4)admin/update/{id} - update user`s info with id:{id} 5)user/get/{id} - get user by id:{id}
