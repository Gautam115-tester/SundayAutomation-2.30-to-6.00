Feature: search

@multipleData @search @smoke
Scenario: Verify the functionality of search module in flipkart homepage

Given launch an chrome browser
And Navigate to flipkart site
When Enter "mobile" in search module in homepage
And validate mobile page has been open by pagetitle and the title is "Mobile- Buy Products Online at Best Price in India - All Categories | Flipkart.com".
Then close an chrome browser

Given launch an chrome browser
And Navigate to flipkart site
When Enter "laptop" in search module in homepage
And validate mobile page has been open by pagetitle and the title is "Laptop- Buy Products Online at Best Price in India - All Categories | Flipkart.com".
Then close an chrome browser

@SingleData @search @regression
Scenario: Verify the functionality of product

Given launch an chrome browser
And Navigate to flipkart site
And Search an "mobile" in search module at homepage.
When Click on a first product
Then close an chrome browser


