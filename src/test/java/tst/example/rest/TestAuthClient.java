package tst.example.rest;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by MM on 17.01.2016.
 */
public class TestAuthClient {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();

        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("testuser", "password");
        clientConfig.register( feature) ;

        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget webTarget = client.target("http://localhost:8080/myapp").path("myresource");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();

        System.out.println(response.getStatus());
        System.out.println(response.getStatusInfo());
    }
}
