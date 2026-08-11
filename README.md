# DOSW_Lab2_Botero_Garcia_Leguizamon_Pineda
This repository is about the second laboratory of DOSW. Daniel Pinzon, Thomas Garcia
| Name | Institutional Email | GitHub User |
| --- | --- | --- |
| JOSE DANIEL GARCIA PINEDA | jose.gpineda@mail.escuelaing.edu.co | KenjiMaster |
| THOMAS SEBASTIAN GARCIA GOMEZ | thomas.garcia-g@mail.escuelaing.edu.co | thomassebastiangarciagomez-ctrl |
| MIGUEL BOTERO | | |
| JUAN GUILLERMO LEGUIZAMON RODRIGUEZ | | |

## Challenge Evidence

## Challenge 1 - Don Pepe's Store

### Diagram class

![Challenge_evidence](diagrams/diagrama_reto1.png)

Explanation:

In the first challenge of this lab, it's essential to understand why it complies with the SOLID principles. The way these principles are fulfilled is as follows:

S (Single Responsibility): each class has only one reason to change. Product only models product data, Bill only calculates totals/discounts and builds the invoice string, NewCustomer/FrequentCustomer only know their own discount percentage, and CustomerFactory only knows how to create customers. If a frequent customer's discount rule changes, you only touch FrequentCustomer.

O (Open/Closed): thanks to the Customer interface, Bill is closed for modification but open for extension — you can add a new VipCustomer without touching a single line of Bill.getDiscountAmount(). (Note: you would have to modify CustomerFactory to support the new type, since it uses if/else instead of a Map<CustomerType, Supplier<Customer>>; this is a minor violation, common in a Simple Factory).

L (Liskov Substitution): anywhere Bill expects a Customer, you can pass either a NewCustomer or a FrequentCustomer interchangeably without breaking Bill's behavior or producing inconsistent results — both fulfill the discountCustomer() contract by returning a valid double.

I (Interface Segregation): Customer is a small, cohesive interface (two methods), so no implementation is forced to implement methods it doesn't need.

D (Dependency Inversion): Bill depends on the Customer abstraction, not directly on NewCustomer or FrequentCustomer — since the constructor receives the interface type, not the concrete type. This dependency on the abstraction is what enables the Strategy pattern.

In this way, this challenge satisfactorily fulfills the SOLID principles, showing strong, future-extensible code.


## Challenge 2 - The Five-Star Chef

### Diagram class

![Challenge_evidence](diagrams/diagrama_reto2.png)

Explanation:

For the second challenge, the design pattern chosen was Builder. This is because HamburgerBuilder constructs a Hamburger object step by step through chained calls (bread().meat().cheese()...build()), without exposing a Hamburger constructor with a long list of parameters or forcing the object to be built in a single step. This is classic Builder: it separates the construction of a complex object from its final representation. 

This solution is key given the type of problem we're facing — a user is going to buy a hamburger, but they won't always want the same ingredients; these can vary. So it's very important to be able to create these combinations effectively, in such a way that the ingredients aren't tied to the hamburger but are instead free elements that may or may not be included in it without any consequence.

