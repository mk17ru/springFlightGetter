### Hello, in this site you can get and add flights.

Heroku starts server ~ 30 seconds: https://flightgetter.herokuapp.com/

Start page you can find guide: https://flightgetter.herokuapp.com/

    There are two interfaces:\

### 1) User interface:
        get: /view/flights/{id}
        create: /view/flights/create
\
    In create insert csv string, for example: 100,SVO,BKK,20210701,2010,20210702,1115,SU-275\

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
\
### Csv string with JSON example:
    {
        "13,SVO,BKK,20210701,2010,20210702,1115,SU-275"
    }
\
### Note: to create new flight id should be new, not autoGen, because we have init data.


2) If you want to run app on your pc: \
     git clone \
     run DemoApplication class
