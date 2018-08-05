import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PersonControler {
    private Main main;

    @FXML
    private TableView<Person> personTable;
    @FXML
    private Label nameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label adressLabel;
    @FXML
    private Label townLabel;
    @FXML
    private Label zipCodeLabel;
    @FXML
    private Label telephoneNumberLabel;

    @FXML
    private TableColumn<Person, String> nameCol;
    @FXML
    private TableColumn<Person, String> lastNameCol;

    @FXML
    private Button newButton;
    @FXML
    public void handleNewButton() {
        this.main.loadNewPerson();
    }
    @FXML
    public void handlePersonEdit(ActionEvent actionEvent) {
        Person selectPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectPerson != null) {
            System.out.println(selectPerson.getName() + " " + selectPerson.getLastName());
            this.main.loadPersonEdit(selectPerson);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Person Alert");
            alert.setContentText("No Person chosen");
            alert.showAndWait();
        }
    }
    @FXML
    public void handleDeletePerson(ActionEvent actionEvent) {
        int index = personTable.getSelectionModel().getSelectedIndex();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete" + index + "?",
                ButtonType.YES,
                ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            if (index >= 0) {
                personTable.getItems().remove(index);
            }
        }
    }
    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastNameCol.setCellValueFactory(cell -> cell.getValue().lastNameProperty());
        personTable.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldField, newField) -> showPersonDetails(newField));
    }
    private void showPersonDetails(Person person) {
        nameLabel.setText(person.getName());
        lastNameLabel.setText(person.getLastName());
        adressLabel.setText(person.getAdress());
        townLabel.setText(person.getTown());
        zipCodeLabel.setText(person.getZipCode());
        telephoneNumberLabel.setText(person.getTelephoneNumber());
    }

    void setMain(Main main) {
        this.main = main;
        personTable.setItems(this.main.getPersonList());
    }
    Main getMain() {
        return main;
    }

}
