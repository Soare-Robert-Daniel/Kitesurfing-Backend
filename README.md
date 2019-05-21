# Kitsurfing - Backend
## API Calls
![Api Structure](https://i.imgur.com/9DN56CR.png)
## API General Structure
![Api General Structure](https://i.imgur.com/5QlmpIR.png)
## Database design
![DB design](https://i.imgur.com/6hXjJgO.png)
## Inputs Examples
For /signup
```javascript
{
    "username" : "demo",
    "password" : "demo123"
}
```
For /login
```javascript
{
    "username" : "demo",
    "password" : "demo123"
}
```
For /signout and /spots/* and /favorites/*
```javascript
{
    "token" : "6f8ec628-8772-4fd8-8dcf-91b9b134f758"
}
```
For /users/me/forgot-password
```javascript
{
    "username" : "demo"
}
```
For /users/me/reset-password
```javascript
{
    "password" : "newDemo123",
    "resetToken" : {
        "token" : "37cd3b23-75a0-499e-be9e-80f51353a4c3"
    }
}
```
## Successful Outputs Examples
For /signup
```javascript
{
    "response" : null,
    "status" : "succes",
    "message" : "User has been registered!"
}
```
For /login
```javascript
{
    "response" : 
    {
        "token" : "6f8ec628-8772-4fd8-8dcf-91b9b134f758"
    },
    "status" : "succes",
    "message" : ""
}
```
For /signout
```javascript
{
    "response" : null,
    "status" : "succes",
    "message" : "The token has been changed!"
}
```
For /users/me/forgot-password
```javascript
{
    "response" : 
    {
        "token" : "37cd3b23-75a0-499e-be9e-80f51353a4c3"
    },
    "status" : "succes",
    "message" : ""
}
```
For /users/me/reset-password
```javascript
{
    "response" : null,
    "status" : "succes",
    "message" : "Password has been changed!"
}
```
For /spots?country=Spain&windProbability=97
```javascript
{
  "response": [
    {
      "id": 58,
      "name": "Dakhla",
      "country": "Spain"
    },
    {
      "id": 59,
      "name": "Heliophora Lagoon",
      "country": "Spain"
    }
  ],
  "status": "success",
  "message": ""
}
```
For /spots/5
```javascript
{
  "response": {
    "longitude": 59.67,
    "latitude": 22.03,
    "windProbability": 87,
    "whenToGo": "AUGUST"
  },
  "status": "success",
  "message": ""
}
```
For /spots/countries
```javascript
{
  "response": [
    "Cook Islands",
    "South Africa",
    "Venezuela",
    "Oman",
    "Ecuador",
    "Morocco",
    "Australia",
    "Mexico",
    "Tanzania",
    "Viet Nam",
    "Peru",
    "Senegal",
    "Brazil",
    "Guadeloupe",
    "Libya",
    "Saudi Arabia",
    "Indonesia",
    "United Kingdom",
    "New Zealand",
    "United Arab Emirates",
    "Israel",
    "Sri Lanka",
    "Spain",
    "Egypt",
    "India"
  ],
  "status": "success",
  "message": ""
}
```
For /favorites/spots/add/5
```javascript
{
    "response" : null,
    "status" : "succes",
    "message" : "The spot has been added!"
}
```
For /favorites/spots/delete/5
```javascript
{
    "response" : null,
    "status" : "succes",
    "message" : "The spot has been deleted!"
}
```
## Invalid inputs
The server will return the error in this format:
```javascript
{
    "response" : null,
    "status" : "failed",
    "message" : "Information about the error"
}
```
#### E.g For /spots
With input
```javascript
{
    "token" : "12345-abc"
}
```
It will return
```javascript
{
  "response": null,
  "status": "failed",
  "message": "Invalid token format!"
}
```
