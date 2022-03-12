###__________________________________
(M. Luiza Prestes - Estágio Java)

### How to utilize

GET Endpoint: `/v1/pokemons/?q=xxxxxx`

All the values from the endpoint are being sorted and comparated
Alphabetically and Length.

The return value contains the **Pokemon NAME, URL and HIGHLIGHT**.

As example for the request `/v1/pokemons/?q=pika`
```json
{
    "count": 1,
    "result": [
        {
            "name": "pikachu",
            "url": "https://pokeapi.co/api/v2/pokemon/25/",
            "highlight": "<pre>pika</pre>chu"
        }
    ]
}
```

### How to build

- Run `gradle shadowJar`
- Create the container `docker build -t pokemon-api .`
- Run the container (default port: 13001) `docker-compose up`

###__________________________________

### Would you like to work with us? Apply [here](https://app.pipefy.com/public_form/840222)!

# Looqbox Backend Challenge
![Looqbox](https://github.com/looqbox/looqbox-backend-challenge/blob/master/logo.png)

## Challenge
In this challenge you will need to build a **Microservice** using the stack below and a provided api.

We will not use anything from your project other than evaluate your skills and you are free to use this project in your portfolio.

## Stack
We use:
- Java/Kotlin
- `Spring Boot` for the framework
- `Gradle` for dependency management and local deployment

## Submitting
- Make a fork of this repository
- When you're done send us a pull request

# Guidelines
You need to make a HTTP REST API that 
- Consumes the [PokeAPI](https://pokeapi.co/) data.
- Provides an endpoint to query pokemons based on the substring of its name. For example:
  - Request: `GET /pokemons?q=pidge`
  - Expected response: ```{"result" : ["pidgey", "pidgeotto", "pidgeot"]}```
- You need to apply sorting by two algorithms (it is not permitted to use a sorting library, for this particular feature you must implement by yourself). And it’s very important to explain your implemented logic (For instance, you can use inline comments on the source code): 
  - the pokemon name's length and; 
  - the pokemon name's alphabetical order 
 
- Find a way to indicate the pokemon name highlight regarding the piece of its queried name. For example:
  - The queried name was `pi`
  - The highlight object must be ```{"name": "pikachu", "highlight": "<pre>pi</pre>kachu"}``` or ```{"name": "pikachu", "start": 0, "end": 2}```
- Draw a diagram explaining your architecture

## Bonus points!
- Design Patterns
- Unit Testing
- Dockerize the application
- Explain the Big-Ω (time complexity) of your sorting algorithms (explain how you calculated them)

## Useful links
- [Spring Framework](https://spring.io/)
- [Gradle](https://gradle.org/)
- [PokeApi docs](https://pokeapi.co/docs/v2.html)
