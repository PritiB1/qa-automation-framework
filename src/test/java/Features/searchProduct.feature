
Feature: Seacrh and place the order for prodcut.

Scenario: Seacrh experience for product search on home page and offer page
    
Given user is on GreenKart Home page
When user search with inital letters "Tom" on homepage and extracted Product
Then user searched same letters "Tom" on offers page 
Then verify the product name on both pages