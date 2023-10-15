# ADDRESS API SPEC

## Create Address

Endpoint :  POST /api/contacts/{idContact}/addresses

Request Header: 

- X-API-TOKE : Token (Mandatory)

Request Body : 

```json
{
  "street": "Jalan Name",
  "city" : "Kota",
  "province" : "Provinsi",
  "country" : "Negara Indonesia",
  "postalCode" : " 12232"
}
```

Response Body (success) : 

```json
{
  "data" : {
      "id" : "random string",
      "street": "Jalan Name",
      "city" : "Kota",
      "province" : "Provinsi",
      "country" : "Negara Indonesia",
      "postalCode" : " 12232"
  }
}
```

Response Body (failed)

```json
{
  "errors" : "Contact is not found"
}
```

## Update Address

Endpoint : PUT /api/contact/{idContact}/addreses/{idAdress}

Request Header:

- X-API-TOKE : Token (Mandatory)

Request Body :

```json
{
  "street": "Jalan Name",
  "city" : "Kota",
  "province" : "Provinsi",
  "country" : "Negara Indonesia",
  "postalCode" : " 12232"
}
```

Response Body (success) :


```json
{
  "data" : {
    "id" : "random string",
    "street": "Jalan Name",
    "city" : "Kota",
    "province" : "Provinsi",
    "country" : "Negara Indonesia",
    "postalCode" : " 12232"
  }
}
```

Response Body (failed)

```json
{
  "errors" : "Address is not found"
}
```

## Get Address

Endpoint : GET /api/contacts/{idContact}/addresses/{idAddresses}

Request Header:

- X-API-TOKE : Token (Mandatory)

Response Body (success) :

```json
{
  "data" : {
    "id" : "random string",
    "street": "jalan",
    "city" : "kota",
    "province" : "provinsi",
    "country" : "indoneisa",
    "postal Code": "12342"
  }
}
```

Response Body (failed) : 

```json
{
  "errors": "address is not found"
}
```

## Delete Address

Endpoint : DELETE /api/contacts/{idContact}/addresses/{idAddresses}

Request Header:

- X-API-TOKE : Token (Mandatory)

Response Body (success) :

```json
{
  "data" : "OK"
}
```

Response Body (failed) :

```json
{
  "errors": "address is not found"
}
```

## List Address

Endpoint : GET /api/contacts/{idContact}/addresses

Request Header:

- X-API-TOKE : Token (Mandatory)

Request Body :

Response Body (success) :

````json
{
  "data": [
    {
      "id" : "random string",
      "street": "jalan",
      "city" : "kota",
      "province" : "provinsi",
      "country" : "indoneisa",
      "postal Code": "12342"
    }
  ]
}
````

Response Body (failed) : 

Response Body (failed) :

```json
{
  "errors": "address is not found"
}
```