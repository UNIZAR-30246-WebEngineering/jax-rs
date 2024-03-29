package rest.hellows;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.Grizzly;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {
	private static final Logger LOGGER = Grizzly.logger(Server.class);
	
	public static void main(String[] args) {
		LOGGER.setLevel(Level.FINER);
		
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
				URI.create("http://localhost:8080/helloWorld") , 
				new ResourceConfig().register(HelloWebService.class));
		try (Scanner scan = new Scanner(System.in)){
			server.start();
			LOGGER.info("Press 's'+'enter' to shutdown now the server...");
			while(!scan.nextLine().equals("s"));
		} catch (IOException ioe) {
			LOGGER.log(Level.SEVERE, ioe.toString(), ioe);
		} finally {
			LOGGER.info("Shuting now");
			server.shutdownNow();
			LOGGER.info("Server stopped");
		}
	}
}
