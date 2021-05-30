### This the app where you can get and add flights.

This app is deplyed by heroku. Heroku free starts server ~ 30 seconds, pls wait for the first time: https://flightgetter.herokuapp.com/

Start page you can find guide: https://flightgetter.herokuapp.com/

    There are two interfaces:

### 1) User interface:
        get: /view/flights/{id}
        create: /view/flights/create

    In block of creating with csv string, insert this, for example: 100,SVO,BKK,20210701,2010,20210702,1115,SU-275

### 2) Rest interface:
        get: /flights/{id} 
        create by json: /flights 
        create by csv string: /flights/string
### Json example:
        {
            "id": 20,
            "origin": "SVO",
            "destination": "BKK",
            "departureDate": 20210701,
            "departureTime": 2010,
            "arrivalDate" : 20210702,
            "arrivalTime" : 1115, 
            "number": "SU-276"
        }
       ![image](https://user-images.githubusercontent.com/57333967/120098588-31ae8f00-c150-11eb-8b14-1ea0e893bb45.png)


\
### Csv string with JSON example:
    {
        "13,SVO,BKK,20210701,2010,20210702,1115,SU-275"
    }

### Note: to create new flight id should be new, not autoGen, because we have init data.


### If you want to run app on your pc: 
     git clone https://github.com/mk17ru/springFlightGetter.git
     you need to install postgresql port : 5432
     In file application.properties you should set your password and username. Default username and password are postgres, postgres.
     and you need to create database with name flight_db
     run DemoApplication class
     http://localhost:8080/
