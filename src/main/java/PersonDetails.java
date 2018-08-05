import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonDetails {

    private Person person;
    private Stage stage;

    @FXML
    private  TextField name;
    @FXML
    private  TextField lastName;
    @FXML
    private TextField adress;
    @FXML
    private TextField town;
    @FXML
    private TextField zipCode;
    @FXML
    private TextField phoneNumber;


    void select(Person selectPerson) {
        name.setText(selectPerson.getName());
        lastName.setText(selectPerson.getLastName());
        adress.setText(selectPerson.getAdress());
        town.setText(selectPerson.getTown());
        zipCode.setText(selectPerson.getZipCode());
        phoneNumber.setText(selectPerson.getTelephoneNumber());
    }
    void setStage(Stage editStage) {
        this.stage=editStage;

    }
    void setPerson (Person person){
         this.person = person;
         name.setText(person.getName());
         lastName.setText(person.getLastName());
}

    public void handleAbort(ActionEvent actionEvent) {
        this.stage.close();
    }
    public void handleOK(){
        person.setName(name.getText());
        person.setLastName(lastName.getText());
        this.stage.close();

    }
}
