# CONTACT API SPEC

## Create Contact

Endpoint :  POST / api/contacts

Request Header : 

- X-API-TOKEN : Toke (Mandatory)

Request Body  : 

```json
{
  "firstName" : "Haris",
  "lastName" : "Priantury",
  "email" : "Haris@yopmail.com",
  "phone" : "008488759284"
}
```

Response Body (success) :

```json
{
  "data" : {
    "id" : "random string",
    "firstName" : "Haris",
    "lastName" : "Priantury",
    "email" : "Haris@yopmail.com",
    "phone" : "008488759284"
  }
}
```

Response Body (failed) :

```json
{
  "errors" : "email format invalid, phone format invalid, dll"
}
```

## Update Contact

Endpoint : PUR /api/contacts/{idContact}

- X-API-TOKEN : Toke (Mandatory)

Request Body  :

```json
{
  "firstName" : "Haris",
  "lastName" : "Priantury",
  "email" : "Haris@yopmail.com",
  "phobe" : "008488759284"
}
```

Response Body (success) :

```json
{
  "data" : {
    "id" : "random string",
    "firstName" : "Haris",
    "lastName" : "Priantury",
    "email" : "Haris@yopmail.com",
    "phobe" : "008488759284"
  }
}
```

Response Body (failed) :

```json
{
  "errors" : "email format invalid, phone format invalid, dll"
}
```

## Get Contact

Endpoint : GET /api/contacts/{idContact}

- X-API-TOKEN : Toke (Mandatory)

Response Body (success) :

```json
{
  "data" : {
    "id" : "random string",
    "firstName" : "Haris",
    "lastName" : "Priantury",
    "email" : "Haris@yopmail.com",
    "phone" : "008488759284"
  }
}
```

Response Body (failed) :

```json
{
  "errors" : "contact is not found"
}
```


Response Body (failed) :

## Search Contact

Endpoint : GET /api/contacts

Query Param : 

[//]: # (optional)
- name : String, conact first name or last name, using like query
- phone : String, contact phone, using like query
- email : String, contact email, using like query
- page : Integer , start from 0 default 0
- size : Interger , default 10

- X-API-TOKEN : Toke (Mandatory)

Response Body (success) :

```json
{
  "data" : [
    {
      "id" : "random string",
      "firstName" : "Haris",
      "lastName" : "Priantury",
      "email" : "Haris@yopmail.com",
      "phobe" : "008488759284"
    }
  ],
  "paging": {
    "currentPage" : 0, 
    "totalPage" : 10,
    "size" : 10
  }
}
```

Response Body (failed) :



## remove Contact

Endpoint : DELETE /api/contacts/{idContact}

- X-API-TOKEN : Toke (Mandatory)

Response Body (success) :

```json
{
  "data" : "OK"
}
```

Response Body (failed) :

```json
{
  "gaga;" : "contact not found"
}
```