package dev.rinaldo;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.inject.Inject;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
public class FrutasResourceTest {

    @Inject
    FrutasService frutasService;
    
    @Test
    public void testListFrutas() {
        given().when().get()
          .then()
             .statusCode(200)
             .body(is("[{\"id\":1,\"nome\":\"Maçã\",\"qtd\":5},{\"id\":2,\"nome\":\"Pera\",\"qtd\":3},{\"id\":3,\"nome\":\"Laranja\",\"qtd\":1}]"));
    }
    
    @Test
    public void testListFrutas2() {
        List<Fruta> list = frutasService.list();
        assertFalse(list.isEmpty());
    }
    
}