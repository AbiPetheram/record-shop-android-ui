# :notes:Record Shop API:notes:
## Project Overview

Welcome to the Record Shop android application! This front end is for use with the back end API service found here: https://github.com/AbiPetheram/record-shop. The user interface has been designed in Android Studio and is written in Java. 

### Project Requirements

The record shop front end has been designed to use the back end API endpoints to perform CRUD actions on albums in the record shop.

### Key Features

* **View all albums in the record shop**: utilises a RecyclerView to display albums in a scrollable list.
* **Search by album name or release year**: albums can be searched by either album name or release year using search bars to dynamically display a list of all albums matching the criteria. The search functionality is constantly updating, so look out for new features!
* **Add new album**: a floating action button allowing a new album entry to be added to the database.
* **Update and delete existing albums**: all albums in the list are clickable and, when clicked, will promt either information to be edited and updated or deleted, with a confirmation pop up to ensure no accidental deletion. 

Available genres are:
ROCK, DANCE, PUNK, POP, METAL, BLUES, COUNTRY, RAP, CLASSICAL

## Getting Started

### Installing

Clone this repo using `git clone https://github.com/AbiPetheram/record-shop-android-ui`

Update the BASE_URL in com.example.record_shop_android_ui.service.RetrofitInstance to the URL of your hosted back end project:

`private static final String BASE_URL = "http://{your_URL_here}/";`

Update the res.xml.security_config.xml domain to include the URL of your hosted back end project:

`<domain includeSubdomains="true">{your_URL_here}</domain>`


### Running Program

Program can be run from within an Android Studio by clicking play.

## Future considerations

This is a continuously developing application which has started at a basic level and will continue to develop.

The next steps will be:

* Add album cover art to albums.
* Currently the back end stores Genre as an enum, which is represented as a string field in this front end. A spinner element will be added to map a set list of genre options to the enum values to ensure only valid genre values are selected.
* Improve search and filtering options to have multiple paramters.
