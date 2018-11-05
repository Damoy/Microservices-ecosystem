# Team
- BENZA Amandine 
- SWIDERSKA Johanna
- TOUTAIN Xavier
- FORNALI Damien
----
- Master II - IFI - Software Architecture
- Micro micro-services system
- Nice Sophia-Antipolis University
- 2018-2019
----
- Subject: https://github.com/mosser/microservices/blob/master/assignments/3_Project.md
---
- Last updated: 11/10/2018
---

# Status
- Business domains

1. Users Management
* Clients
* Orders

2. Commons
* Shared domain between components

3. Orders
* Client
* Coursier ?
* Restaurant

4. Restaurants
* Order
* Coursiers

5. Coursiers
* Restaurants
* Orders

6. Billing ?


# Use-cases resume
- TODO

# Micro-services
1. User management
- Stateless system
	- identification service
	- creation service
	- modifications service (which data to store ?)
	- credit card paiement option
	- associated orders consultation

2. Orders
> By user / view
- creation service
- modifications service
- delete service

- consultation service
	- e.g a restaurant wants to see its list of orders
	- e.g a coursier wants to see the orders he has to deliver

- basket service
	- cookies (client side)
	- server-side updates (more network traffic)

- paiement processing service
- ETA (Estimated Time of Arrival) micro-service ?
- order availability
	- restaurant notifies to the system that
		a certain order has been prepared and is
		ready for delivery

3. Restaurants
- Food entities [FE]: menus, "unique" dishes
- FE consultation service (anonymous ?)
	- first, full listing, then filter options
- FE modification service
- FE addition service
- FE deletion service

4. Coursiers

5. Commons
- ETA (Estimated Time of Arrival) micro-service ?

--
Each "-" is a new microservice (maven module: pom)


> Microservices TODO

- MSE
	- commons
		- ETA (estimated time of arrival)
		- Distance estimation
		- money modification
	- restaurants
		- consultation
			- food
			- menus
			- orders
			- restaurants
		- modification
			- food
			- menus
			- orders (set order ready to be delivered)
			- restaurants
	- clients
		- order addition (e.g. clients_addition_order)
		- modification
			- client
		- consultation
			- client
	- coursiers
		- modification
			- coursier (account)
			- orders (set order delivery to ongoing + delivered)
		- consultation
			- current orders (accepted offers)
			- orders candidate

Joanna:<br>
	- coursiers<br>
	<br>
Amandine:<br>
	- commons<br>
	- restaurants - deletion<br>
	<br>
Xavier:<br>
	- restaurants<br>
	- addition / modification / consultation<br><br>
Damien:<br>
	- clients<br>
	
-Kafka verbs<br>
TODO messages:<br>
- create an object > "create-object"<br>
- delete an object > "delete-object"<br>
- edit all object attributes > "edit-object"<br>
- edit an object > "edit-object-attribute"<br>
- consult an object > "consult-object"<br>

DONE messages:<br>
- object has been created > "object-created"<br>
- object has been deleted > "object-deleted"<br>
- all object attributes has been edited > "object-edited"<br>
- object attribute has been edited > "object-attribute-edited"<br>
- an object has been consulted > "object-consulted"<br> 


As Gail or Erin, I can order my lunch from a restaurant so that the food is delivered to my place;

As Gail, I can browse the food catalogue by categories so that I can immediately identify my favorite junk food;

As Erin, I want to know before ordering the estimated time of delivery of the meal so that I can schedule my work around it, and be ready when it arrives.

As Erin, I can pay directly by credit card on the platform, so that I only have to retrieve my food when delivered;

List of listened events:
- clients-accounts
"consult-client"
"edit-client-name"
"edit-client-address"
"edit-client-creditCard"
"edit-client-phone"

List of sent events:
- clients-accounts
"client-consulted"
"client-created"
"client-deleted"
"client-edited" // edit all client attributes
"client-name-edited" // edit one client attribute
"client-address-edited"
"client-creditCard-edited"
"client-phone-edited"

# Simplifications
1. No data crypting on the network
2. ..

# Questions
1. Rollback for transactions ?
2. Security for paiement ?
3. ..

# Tech
- Java
- Springboot
- NoSQL, Mongod
- Kafka
- Gatling

- Refactoring, 05/11/18
Reducing number of microservices because of performances issues.