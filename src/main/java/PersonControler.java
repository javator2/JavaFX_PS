import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private Label townLable;
    @FXML
    private Label zipCodeLabel;
    @FXML
    private Label telephoneNumberLabel;

    @FXML
    private TableColumn <Person,String> nameCol;
    @FXML
    private TableColumn <Person,String> lastNameCol;

    @FXML
    private Button newButton;

    @FXML
   public void handleNewButton(){
        System.out.println("testTest");
        this.main.loadPersonEdit();
    }


    @FXML
    public void initialize(){
        nameCol.setCellValueFactory(cell-> cell.getValue().nameProperty());
        lastNameCol.setCellValueFactory(cell-> cell.getValue().lastNameProperty());
    }

    public void setMain(Main main) {
        this.main = main;
        personTable.setItems(this.main.getPersonList());
    }
}
