#!/bin/sh

# Gail, a student who lives in Sophia and often order (junk) food from food trucks;
# Erin, a software developer working in a major company;
# Jordan, restaurant chef;
# Jamie, a coursier;

# Personas
student=Gail;
dev=Erin;
chief=Jordan;
coursier=Jamie;
personasSleep=2;

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

printf ">> Starting first story";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "1. As $student or $dev I can order my lunch from a restaurant so that the food is delivered to my place.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "CURL TODO"; sleep $firstStorySleep;

printf "2. As $student, I can browse the food catalogue by categories so that I can immediately identify my favorite junk food.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "CURL TODO"; sleep $firstStorySleep;

printf "3. As $dev, I want to know before ordering the estimated time of delivery of the meal so that I can schedule my work around it, and be ready when it arrives.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "CURL TODO"; sleep $firstStorySleep;

printf "4. As Erin, I can pay directly by credit card on the platform, so that I only have to retrieve my food when delivered.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "CURL TODO"; sleep $firstStorySleep;

printf "5. As Jordan, I want to access to the order list, so that I can prepare the meal efficiently.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "CURL TODO"; sleep $firstStorySleep;

printf "6. As Jamie, I want to know the orders that will have to be delivered around me, so that I can choose one and go to the restaurant to begin the course.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "CURL TODO"; sleep $firstStorySleep;

printf "7. As Jamie, I want to notify that the order has been delivered, so that my account can be credited and the restaurant can be informed.";
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";
echo "CURL TODO"; sleep $firstStorySleep;
