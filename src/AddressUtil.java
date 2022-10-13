import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressUtil {
    public static Address toAddresses (ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String city = resultSet.getString("city");
        String street = resultSet.getString("street");
        int houseNumber = resultSet.getInt("house_number");
        int housing = resultSet.getInt("housing");
        int apartmentNumber = resultSet.getInt("apartment_number");

        return new Address(id, city, street, houseNumber, housing, apartmentNumber);
    }
}
