# USER API SPEC

## Register User

Endpoint: POST / api/users

Request body :
```json
{
  "username" : "haris",
  "password" : "priantury",
  "name" : "Haris Priantury"
}
```

Response body (succes) : 
```json
{
  "data" : "ok"
}
```

Response body (Failed) :
```json
{
  "error" : "your input is out of requirment"
}
```

## Login User

Endpoint: POST / api/auth/login

Request body :
```json
{
  "username" : "",
  "password" : ""
}
```

Response body (succes) :
```json
{
  "data" : {
    "token" : "Token",
    "expiredAt" : 2434242334
  }
}
```

Response body (Failed) :
```json
{
  "error" : "username and password wrong"
}
```   

## Get User

Endpoint: GET / api/users/current

Request Header : 
- X-API-TOKEN : TOKEN (Mandatory)

Response body (succes) :
```json
{
  "data" : {
    "username" : "priantury",
    "name" : "Haris Priantury"
  }
}
```

Response body (Failed, 401) :
```json
{
  "error" : "unauthorized"
}
```   

## Update User

Endpoint: PATCH / api/users/current

Request Header :
- X-API-TOKEN : TOKEN (Mandatory)

Request Body : 
```json
{
  "name" : "Haris Pri", // put if only want to update name
  "password" : "new password"  //put if only want to update password
}
```

Response body (succes) :
```json
{
  "data" : {
    "username" : "priantury",
    "name" : "Haris Priantury"
  }
}
```

Response body (Failed, 401) :
```json
{
  "error" : "unauthorized"
}
```   

## Logout User

Endpoint : DELETE /api/auth/logout

Request Header : 

- X-API-TOKEN : TOKEN (Mandatory)

Response Body (succes) : 

```json
{
  "data" : "OK"
}
```

  
