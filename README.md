Coffee Machine API
This project is an API for managing a coffee machine, built with Spring Boot. It includes features like preparing drinks, managing ingredients, adding new recipes, and tracking popular drinks. Swagger is used for API documentation.


Features
Prepare Drinks: Choose between espresso, americano, or cappuccino.
Manage Ingredients: Check stock levels and update them.
Add Recipes: Save new recipes for drinks.
Track Popularity: Find out the most ordered drink.
Operating Hours: Only works 8:00 to 17:00, and not on holidays or weekends.
Technologies Used
Java 17
Spring Boot (with Spring MVC and Spring Data JPA)
MySQL (for managing data)
Swagger UI (for testing API endpoints)
Maven (for building and managing dependencies)
Getting Started
Prerequisites
Java 17
Maven
MySQL database (for storing data)
(I used MySQL, because it easier to me to interact with database in my work laptop)


Important Endpoints
POST /api/drinks/{drinkId}/prepare: Prepares a drink by ID.
GET /api/drinks/most-popular: Gets the most popular drink.
POST /api/drinks/{drinkId}/recipes: Adds a recipe for a drink.
Note: The coffee machine is set to work only between 8:00 and 17:00 on weekdays and does not operate on public holidays (retrieved for Kazakhstan).

For questions, please contact muratovannur06@mail.ru
