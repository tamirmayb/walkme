# Walkme Home Assignment - Backend

## ‘Campaigns Caps Layer’ - enforces the campaign’s caps validations and filters campaigns before they are returned to the user.

Author: Tamir Mayblat, tamirmayb@gmail.com

## Content

###Prerequisites :

* Java 11

###Notes :
* The app is using a mongodb cluster to save the data
* You can send a GET request to http://localhost:8080/walkme/api/campaigns in order to watch all the campaigns (the counters will not be effected).
* This app is designed to be used as backend support for the angular app: https://github.com/tamirmayb/walkme_client.git

###How to use :

* Start the server on your IDEA or deploy the jar target/walkme-1.0-SNAPSHOT.jar onto your server and start it.
* App should run on http://localhost:8080
* For your convenience you can also use swagger to run all the server's api's: 
http://localhost:8080/walkme/api/swagger-ui.html#/campaign-controller
* You can create a campaign or update the counters for existing campaigns.
* Run a GET request to the following endpoint in order to see the campaigns for a user:
http://localhost:8080/walkme/api/campaigns/{userId}

** Example :  http://localhost:8080/walkme/api/campaigns/2

### Thanks