import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {
    private static final String ADD = "INSERT INTO addresses (id, city, street, house_number, housing, apartment_number)" +
            " VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM addresses";
    private static final String DELETE = "DELETE FROM addresses WHERE id =";
    private static final String UPDATE = "UPDATE addresses SET city = ?,  street = ?, house_number = ?, housing = ?, " +
            "apartment_number = ? WHERE ID =";

    public static void add(Address address) {
        Connection connection = DbConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setInt(1, address.getId());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setInt(4, address.getHouseNumber());
            statement.setInt(5, address.getHousing());
            statement.setInt(6, address.getApartmentNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Address> readAll() {
        List<Address> resultList = new ArrayList<>();

        Connection connection = DbConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Address address = AddressUtil.toAddresses(result);

                resultList.add(address);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public static void delete(int id) {
        Connection connection = DbConnectionUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(DELETE + id);
            System.out.println("Address id " + id + " has been deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Address address) {
        Connection connection = DbConnectionUtil.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE + address.getId())) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouseNumber());
            statement.setInt(4, address.getHousing());
            statement.setInt(5, address.getApartmentNumber());

            statement.executeUpdate();

            System.out.println("Line id = " + address.getId() +" has been updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
