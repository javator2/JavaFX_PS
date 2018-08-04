import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private StringProperty name;
    private StringProperty lastName;
    private StringProperty adress;
    private StringProperty town;
    private StringProperty zipCode;
    private StringProperty telephoneNumber;

    public Person(String name,String lastName){
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
    }
    public String getName() {
        return name.get();
    }

    StringProperty nameProperty() {
        return name;
    }

    public String getLastName() {
        return lastName.get();
    }

    StringProperty lastNameProperty() {
        return lastName;
    }

    public String getAdress() {
        return adress.get();
    }

    public StringProperty adressProperty() {
        return adress;
    }

    public String getTown() {
        return town.get();
    }

    public StringProperty townProperty() {
        return town;
    }

    public String getZipCode() {
        return zipCode.get();
    }

    public StringProperty zipCodeProperty() {
        return zipCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber.get();
    }

    public StringProperty telephoneNumberProperty() {
        return telephoneNumber;
    }


}
