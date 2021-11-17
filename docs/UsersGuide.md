# User's Guide

The CarDB API has many endpoints that allow you to retrieve various data points about any vehicles in the database

## Endpoints

Each endpoint has full CRUD functionality (GET, POST, PATCH, DELETE)

all fields can be searched by ID by adding an ID parameter to the GET request

### /brand

Allows retreival or insertion of car brands

Fields: 

id - unique identifier (int)<br>
name - Name of the brand (varchar)

A brand requires an associated country



### /color

Fields: 

id - unique identifier (int) <br>
Name - Color name (varchar) <br>
Code - color code  (int) <br>

### /country

Stores what countries of origin a car may come from

Fields:

id - unique identifier (int) <br>
name - country name (varchar) <br>

### /drive-train

Stores Drivetrain data

Fields:

id - unique identifier (int) <br>
type - drivetrain type (varchar)


### /engine

Stores engine data

Fields: 

id - unique identifier (int) <br>
Type - Hybrid, Electric or Internal Combustion, stored as int (int) <br>
Displacement - engine displacement in CCs (if applicable) (int) <br>
Cylinder count - number of cylinders (if applicable) (int) <br>
Voltage - Electric or hybrid system voltage (int) <br>
Energy consumption - electric or hybrid energy consumption (int) <br>

### /model

stores car model data

Fields:

id - unique identifier (int)<br>
name - model name (varchar) <br>
seats - number of seats in the car (int)<br>
description - description of the model (varchar)<br>
Brand - brand the model is under (int) (foreign key)<br>
color - color of the model if applicable (int) (foreign key) <br>


Requires a Brand

### /transmission

Stores transmission data

Fields:

id - unique identifier (int) <br>
name - transmission designation (varchar) <br>
gears - number of gears in the transmission (int) <br>
automatic - true if automatic (boolean) <br>


### /trim

Stores trim data

Fields:

id - unique identifier (int) <br>
fuel consumption - fuel consumption in l/100km (int) <br>
model - model upon which the trim is based on (int) (foreign key) <br>
engine - engine for the trim (int) (foreign key) <br>
drive train - drive train for the trim (int) (foreign key) <br>
transmission - transmission for the trim (int) (foreign key) <br>
forced induction - whether the engine is utilising forced induction (boolean) <br>
description - short blurb explaining trim (varchar) <br>

Trims require engines, transmissions, and drivetrains
