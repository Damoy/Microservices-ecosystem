# Team
- BENZA Amandine 
- SWIDERSKA Johanna
- TOUTAIN Xavier
- FORNALI Damien
----
Master II - IFI - Software Architecture
Micro micro-services system
Nice Sophia-Antipolis University
2018-2019
----
- Subject: https://github.com/mosser/microservices/blob/master/assignments/3_Project.md
---
- Last updated: 11/10/2018
---

# Status
- Business domains

1. Users Management
- Clients
- Orders

2. Commons
- Shared domain between components

3. Orders
- Client
- Coursier ?
- Restaurant

4. Restaurants
- Order
- Coursiers

5. Coursiers
- Restaurants
- Orders

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
- SQL > JPA ? | SQLite ?
- Kafka
- Gatling