import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Kevin");
        Movie m1 = new Movie("Hangover 2", 1);
        Movie m2 = new Movie("Hangover 3", 2);
        Rental r1 = new Rental(m1, 15);
        Rental r2 = new Rental(m2, 20);

        customer.addRental(r1);
        customer.addRental(r2);
    }

    @Test
    void statement() {
        String expected = "Rental Record for Kevin\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tHangover 2\t\t15\t45.0\n" +
                "\tHangover 3\t\t20\t27.0\n" +
                "Amount owed is 72.0\n" +
                "You earned 3 frequent renter points";
        String result = customer.statement();

        Assertions.assertEquals(expected, result);

    }

}
