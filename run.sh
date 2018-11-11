#!/bin/sh

# >> Stories
# Week 41: Initial Story set

#     As Gail or Erin, I can order my lunch from a restaurant so that the food is delivered to my place;
#     As Gail, I can browse the food catalogue by categories so that I can immediately identify my favorite junk food;
#     As Erin, I want to know before ordering the estimated time of delivery of the meal so that I can schedule my work around it, and be ready when it arrives.
#     As Erin, I can pay directly by credit card on the platform, so that I only have to retrieve my food when delivered;
#     As Jordan, I want to access to the order list, so that I can prepare the meal efficiently.
#     As Jamie, I want to know the orders that will have to be delivered around me, so that I can choose one and go to the restaurant to begin the course.
#     As Jamie, I want to notify that the order has been delivered, so that my account can be credited and the restaurant can be informed.

# Week 43: First evolution

# New personna: Terry, restaurant owner.

#     As Jordan, I want the customers to be able to review the meals so that I can improve them according to their feedback;
#     As a customer (Gail, Erin), I want to track the geolocation of the coursier in real time, so that I can anticipate when I will eat.
#     As Terry, I want to get some statistics (speed, cost) about global delivery time and delivery per coursier.

# Week 44: Second evolution

#     As Terry, I can emit a promotional code so that I can attract more customer to my restaurant.
#     As Jamie, I want to inform quickly that I can't terminate the course (accident, sick), so that the order can be replaced.

# Week 45: Last evolution

#     As Terry, I can emit a promotional code based on my menu contents (e.g., 10% discout for an entry-main course-dessert order), so that I can sell more expensive orders.
#     As Gail or Erin, I can follow the position of Jamie in real time, so that the food ETA can be updated automatically.

# Personas
student=Gail;
dev=Erin;
chief=Jordan;
coursier=Jamie;
personasSleep=2;

# Introduction
printf ">> Starting Uberoo micro-services eco-system scenarios"; sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";

echo "Scenarios will include the following personas:";
sleep $personasSleep;
echo "1. $student a student who lives in Sophia and often order (junk) food from food trucks.";
sleep $personasSleep;

echo "2. $dev a software developer working in a major company.";
sleep $personasSleep;

echo "3. $chief a restaurant chief."
sleep $personasSleep;

echo "4. $coursier, an Uberoo coursier.";
sleep $personasSleep;

echo "";
firstStorySleep=2;

printf "Creating foods"; sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";

printf "1. Creating DarkDemonNems from Lucichan restaurant";sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
darkDemonNemsLuchichan=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" "localhost:8089/MS/CREATE/FOOD" -d '{"name": "DarkDemonNemsByLucichan","description": "Its so tasty that you will lose your soul","restaurantId": "Lucichan","price": "15.0","category":"ASIAN"}');
echo $darkDemonNemsLuchichan;
echo "";
sleep $firstStorySleep;

printf "2. Creating VegetarianPizza from Mario restaurant";sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
vegetarianPizzaMarioPizza=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" "localhost:8089/MS/CREATE/FOOD" -d '{"name": "VegetarianPizzaByMario","description": "Best pizza ever","restaurantId": "Mario","price": "13.0","category":"ITALIAN"}');
echo $vegetarianPizzaMarioPizza;
echo "";
sleep $firstStorySleep;

printf "3. Creating Kebab from KebabierUltime restaurant";sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
kebabKebabierUltime=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" "localhost:8089/MS/CREATE/FOOD" -d '{"name": "KebabByKebabierUltime","description": "Come taste our ultimate meat","restaurantId": "KebabierUltime","price": "10.0","category":"JUNK"}');
echo $kebabKebabierUltime;
echo "";
sleep $firstStorySleep;

printf "4. Creating Noodles from Lucichan restaurant";sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
noodlesLucichan=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" "localhost:8089/MS/CREATE/FOOD" -d '{"name": "NoodlesLucican","description": "OMG it tastes so good, is it really only noodles ?","restaurantId": "Lucichan","price": "14.0","category":"ASIAN"}');
echo $noodlesLucichan;
echo "";
sleep $firstStorySleep;

printf "5. Creating PestoPasta from Mario restaurant";sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
pestoPastaMario=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" "localhost:8089/MS/CREATE/FOOD" -d '{"name": "PestoPizzaMario","description": "Our pasta beat all rivalry","restaurantId": "Mario","price": "16.0","category":"ITALIAN"}');
echo $pestoPastaMario;
echo "";
sleep $firstStorySleep;

# Restaurants

# printf "Creating restaurants"; sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";

# printf "1. Creating Lucichan restaurant";sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
# luciResto=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" '{"name":"Lucichan","address":"Lucichan","hashedPassWord":"egdogj305od","fax":"0602000404","phoneNumber":"0602000404"}');
# echo $luciResto;
# echo "";
# sleep $firstStorySleep;

# printf "2. Creating Mario restaurant";sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
# marioRestau=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" "localhost:8089/MS/CREATE/RESTAURANT" -d '{"name":"Mario","address":"mama","hashedPassWord":"egdogj305od","fax":"0602000404","phoneNumber":"0602000404"}');
# echo $marioRestau;
# echo "";
# sleep $firstStorySleep;

# printf "3. Creating KebabierUltime restaurant";sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
# kebabResto=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" "localhost:8089/MS/CREATE/RESTAURANT" -d '{{"name":"Mario","address":"keke","hashedPassWord":"egdogj305od","fax":"0602000404","phoneNumber":"0602000404"}');
# echo $kebabResto;
# echo "";
# sleep $firstStorySleep;


# Personas accounts

printf ">> Creating personas accounts"; sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";

printf "Creating $student" sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
studentAccount=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" localhost:8082/MS/CREATE/CLIENT -d '{"mail":"gail@me.fr","phoneNumber":"0656768798","name":"Gail","address":"11 rue GreenKing","creditCard":"6545213409873456"}');
echo $studentAccount;
sleep $firstStorySleep;

printf "Creating $dev" sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
devAccount=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" localhost:8082/MS/CREATE/CLIENT -d '{"mail":"erin@me.fr","phoneNumber":"0611223344","name":"Erin","address":"22 Boulevard Polytech","creditCard":"5345768912345432"}');
echo $devAccount;
sleep $firstStorySleep;

printf "Creating $chief" sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
# $chiefAccount=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" localhost:8082/MS/CREATE/CLIENT -d '{"mail":"jordan@me.fr","phoneNumber":"0754657678","name":"Jordan","address":"Mont de Biot","creditCard":"0987123476549876"}');
echo "CURL TO EDIT";
# echo $chiefAccount;
sleep $firstStorySleep;

printf "Creating $coursier" sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
coursierAccount=$(curl -X POST -H "Accept: application/json" -H "Content-type: application/json" localhost:8087/MS/CREATE/COURSIER -d '{"mail":"jamie@me.com","name":"Jamie","phone":"0655113311","location":"Polytech,Sophia"}');
echo "CURL TO EDIT";
echo $coursierAccount;
sleep $firstStorySleep;

printf ">> Starting first story";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
printf "1. As $student or $dev I can order my lunch from a restaurant so that the food is delivered to my place.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
sleep $firstStorySleep;

printf "2. As $student, I can browse the food catalogue by categories so that I can immediately identify my favorite junk food.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
foodWanted=$(curl -s -X GET -H "Accept: application/json" -H "Content-type: application/json" localhost:8089/MS/CONSULT/FOODS/JUNK);
echo $foodWanted;
sleep $firstStorySleep;

printf "3. As $dev, I want to know before ordering the estimated time of delivery of the meal so that I can schedule my work around it, and be ready when it arrives.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
devOrder=$(curl -s -X POST -H "Accept: application/json" -H "Content-type: application/json" localhost:8082/MS/CREATE/ORDER -d '{"clientMail":"erin@me.com","content":["KebabByKebabierUltime"]}');
echo $devOrder;
sleep $firstStorySleep;

printf "4. As Erin, I can pay directly by credit card on the platform, so that I only have to retrieve my food when delivered.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
paiementResult = $(curl -s -X POST "Accept: application/json" -H "Content-type: application/json" localhost:8082/MS/PAY/erin@me.fr/erin@me.fr_0);
echo $paiementResult;
sleep $firstStorySleep;

printf "5. As Jordan, I want to access to the order list, so that I can prepare the meal efficiently.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
# restaurantOrders=$(curl -s -X GET localhost:8089/MS/FOOD/Mario)
# echo $restaurantOrders;
echo "CURL TODO"; sleep $firstStorySleep;

printf "6. As Jamie, I want to know the orders that will have to be delivered around me, so that I can choose one and go to the restaurant to begin the course.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "CURL TODO"; sleep $firstStorySleep;

printf "7. As Jamie, I want to notify that the order has been delivered, so that my account can be credited and the restaurant can be informed.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "CURL TODO"; sleep $firstStorySleep;
