import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PersonNew {
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

    @FXML
    private Button newButton;
    private ObservableList<Person> personList;
    @FXML
    public void handleNewButton(){
        PersonControler personControler = new PersonControler();
        personList = personControler.getMain().getPersonList();


    }


}
