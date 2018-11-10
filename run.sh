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

echo ">> Starting first story"; 
echo "1. As $student or $dev I can order my lunch from a restaurant so that the food is delivered to my place."
sleep 1; printf "."; sleep 1; printf "."; sleep 1; printf ".\n"; echo "";

echo "CURL TODO"; sleep $firstStorySleep;

echo "2. As $student, I can browse the food catalogue by categories so that I can immediately identify my favorite junk food."
sleep $firstStorySleep;