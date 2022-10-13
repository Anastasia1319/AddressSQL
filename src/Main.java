public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(1, "Cardiff", "Aberbran Rd.", 8, 1, 4);
        Address address2 = new Address(2, "Liverpool", "Vale Rd.", 20, 2, 8);
        Address address3 = new Address(3, "Oxford", "Oatlands Rd.", 48, 1, 3);
        Address address4 = new Address(4, "Norwich", "Eaton Rd.", 58, 3, 5);
        Address address5 = new Address(5, "Nottingham", "Balfour Rd.", 13, 2, 1);

        AddressConnector.add (address1);
        AddressConnector.add (address2);
        AddressConnector.add (address3);
        AddressConnector.add (address4);
        AddressConnector.add (address5);

        System.out.println(AddressConnector.readAll());

        AddressConnector.update (address3);
        AddressConnector.update(address5);
        System.out.println(AddressConnector.readAll());

        AddressConnector.delete (1);
        AddressConnector.delete (2);
        System.out.println(AddressConnector.readAll());
    }
}