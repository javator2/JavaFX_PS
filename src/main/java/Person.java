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

    public void setName(String name) {
        this.name.set(name);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public void setTown(String town) {
        this.town.set(town);
    }

    public void setZipCode(String zipCode) {
        this.zipCode.set(zipCode);
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber.set(telephoneNumber);
    }



    public Person(String name,String lastName,String adress,String town,String zipCode, String telephoneNumber){
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
        this.adress= new SimpleStringProperty(adress);
        this.town= new SimpleStringProperty(town);
        this.zipCode= new SimpleStringProperty(zipCode);
        this.telephoneNumber= new SimpleStringProperty(telephoneNumber);
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
