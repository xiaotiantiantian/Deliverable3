# Deliverable3

There are 3 Stories and 9 Sceniros, every test is passed. 

#Story 1: Login Test

##Sceniro 1:
Given correct username and password, 
When input it and press login button
Then user can login correctly

##Sceniro 2: 
Given correct username and wrong password, 
When input it and press login button user can login correctly 
Then the page would prompt "ERROR: Invalid login credentials."
    
##Sceniro 3: 
Given correct password and wrong username, 
When input it and press login button user can login correctly 
Then the page would prompt "ERROR: Invalid login credentials."


#Story2: Search Test

##Sceniro 1: 
Given a test of searching propose,  the input is "iPhone", which is a key word
When input it and press enter
Then the page would return all the answers

##Sceniro 2: 
Given a test of hacking propose, 
the input is " ' and 1=1" The "%20%27%20and%201=1" is the HTML Url
encoding of " ' and 1=1" 
When input it and press enter
Then the page would prompt "Not Acceptable".

##Sceniro 3: 
Given a test of searching propose, 
the input is "qa", which is a key word
When input it and press enter
Then the page would return all the answers, which means, return no results

#Story 3: Shopping Cart Test

##Sceniro 1: 
Given logged in status 
When add item to the cart 
Then the user can go to check out page correctly

##Sceniro 2: 
Given logged out status 
When add something to the cart 
Then the user can go to check out page correctly

##Sceniro 3: 
Given logged in status with item in shopping cart in Checkout page 
When change the item number and press update 
Then user can find the nubmer of item updated correctly

