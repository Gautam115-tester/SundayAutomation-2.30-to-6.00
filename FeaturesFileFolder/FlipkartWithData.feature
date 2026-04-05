Feature: Search And Add to cart 

@DataDriven @multipleValues @search
Scenario Outline:

Given launch an chrome browser
And Navigate to flipkart site
When Search <search> in search text box
And Click on a first product
And Click on add to card
And Click on cart logo
And Check <productExp> product name has been added
Then close an chrome browser

Examples:
                      |    search                          |  productExp                            |
                      |  "iphone 17 pro 512GB"   |  "Apple iPhone 17 Pro"            |
                      | "Hp 14 AI PC"                  | "HP 14 AI PC"                         |
                      | "Carrier"                           | "CARRIER 2026"                   |