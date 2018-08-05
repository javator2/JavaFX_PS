import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private StringProperty name;
    private StringProperty lastName;
    private StringProperty adress;
    private StringProperty town;
    private StringProperty zipCode;
    private StringProperty telephoneNumber;

    public Person() {
    }

    public Person(String name,String lastName,String adress,String town,String zipCode, String telephoneNumber){
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
        this.adress= new SimpleStringProperty(adress);
        this.town= new SimpleStringProperty(town);
        this.zipCode= new SimpleStringProperty(zipCode);
        this.telephoneNumber= new SimpleStringProperty(telephoneNumber);
        }

    String getName() {
        return name.get();
    }
    StringProperty nameProperty() {
        return name;
    }

    String getLastName() {
        return lastName.get();
    }
    StringProperty lastNameProperty() {
        return lastName;
    }

    String getAdress() {
        return adress.get();
    }
    StringProperty adressProperty() {
        return adress;
    }

    String getTown() {
        return town.get();
    }
    StringProperty townProperty() {
        return town;
    }

    String getZipCode() {
        return zipCode.get();
    }
    StringProperty zipCodeProperty() {
        return zipCode;
    }

    String getTelephoneNumber() {
        return telephoneNumber.get();
    }
    StringProperty telephoneNumberProperty() {
        return telephoneNumber;
    }

    void setName(String name) {
        this.name.set(name);
    }
    void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
    void setAdress(String adress) {
        this.adress.set(adress);
    }
    void setTown(String town) {
        this.town.set(town);
    }
    void setZipCode(String zipCode) {
        this.zipCode.set(zipCode);
    }
    void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber.set(telephoneNumber);
    }

}
