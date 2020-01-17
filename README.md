# Point of Sale

Introduce a system that will have a single event handler as an entry point,
receiving a new barcode, and display the price for the given barcode.   

## Stage 1 - Sell One Product
Think of the different scenarios for a given barcode
 - product available for given barcode
 - product not available for given barcode
 - barcode being empty

## Stage 2 - Sell Multiple Products
Introduce one more event that will calculate the total of the previously
scanned products. Think of different scenarios:
 - have scanned products before (having sale in progress)
 - not having any products scanned (no sale in progress)


## Slides from the workshop
https://pasteapp.com/p/qKRB5CrGH1c?view=rOJe7fVA7o4