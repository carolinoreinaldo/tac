# tac

Banco de dados Fake para ser usado como back-end de CRUD.

Person Json :
{
  "name" : "...",
  "age": 26
}

End-Ponts :

CREATE
METHOD : (POST)
url -> /tac/persons
{
  "name" : "...",
  "age": 26
}

EDIT 
METHOD : (PUT)
url -> /tac/persons/{id}
{
  "name" : "...",
  "age": 26
}

DELETE
METHOD : (DELETE)
url -> /tac/persons/{id}


FIND : 
METHOD : (GET)
url -> /tac/persons/{id}

GET ALL :
METHOD : (GET)
url -> /tac/persons
