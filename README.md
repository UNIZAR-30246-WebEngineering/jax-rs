# Hello World in JAX-RS
This is a multiproject about [JAX-RS](https://jax-rs-spec.java.net/).

# Address book service!
[Addressbook](addressbook) contains a demonstration of a CRUD repository with a RESTful interface. The code contains a set of [JUnit](http://junit.org/) tests that show how a REST client can interact with this repository.

# Hello World! Server (standalone)
[hellors](hellors)This project contains a demonstration of a web service build with [JAX-RS](http://docs.oracle.com/javaee/6/tutorial/doc/giepu.html) 
that can run standalone. That is, it does not require to be deployed in a server.

Run the code with ```gradle server``` and then navigate to [http://localhost:8080/helloWorld/sayHello/World](http://localhost:8080/helloWorld/sayHello/World) to 
retrieve a text containing the word `World`. 

The code of the service is:
```java
@Path("sayHello/{name}")
public class HelloWebService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(@PathParam("name") String name) {
		return "Hello "+name;
	}
}
```

Therefore, if `World` is changed by `me`, the returned message will be `Hello me`

# Hello World! Client
[hellors-cli](hellors-cli) contains a demonstration of a consumer of a REST web service.

Run the code with ```gradle client```. The code invokes a service that and then navigate to [http://localhost:8080/helloWorld/sayHello/World](http://localhost:8080/helloWorld/sayHello/World) to 
retrieve a text containing the word `World`. 
