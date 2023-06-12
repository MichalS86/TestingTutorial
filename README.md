# Stub/Mock/Fake Tutorial

## How it works

Application holds paints details in postgres DB. Every paint contains  
- name  
- price (for 1 litre)  
- efficency (how many m2 can paint with one litre)

## How to deploy

Run script /database/create-local-postgres.sh to create docker container with postgres db.  
User: postgres  
Password: postgres
Maven application runs on localhost:8080 by default. 

## Endpoints

| Method | Path          | Description             |
| -------|---------------|------------------------ |
| POST   | /api/count    | counts painting cost    |
| POST   | /api/painting | add painting to db      |
| DELETE | /api/painting | delete painting from db |
| GET    | /api/painting | get painting from db    |

## Requests

Example /api/count request
 ```
{
    "room": {
        "width": 10,
        "height": 10,
        "length":10
    },
    "paintingId": 1
}
```


## Postman

/postman/Tutorial.postman_collection.json contains collection with example requests.  
