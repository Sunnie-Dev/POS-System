package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posSystem.ProductCatalog;
import posSystem.Register;
import posSystem.Store;

@DisplayName("Register Specification")
public class StoreTest{
    private ProductCatalog _catalog;
    private Register _register;
    private Store _store;

    @BeforeEach
    void setUp(){
        _catalog = new ProductCatalog();
        _register = new Register(_catalog);
        _store = new Store();
    }

    @Test
    @DisplayName(" Store Should get a Register")
    void storeShouldGetARegister(){
        _store.getRegister();
    }

    @Test
    void registerCanNotBeNull(){

    }
}
