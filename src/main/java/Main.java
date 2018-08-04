import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    private VBox layout;

    private ObservableList <Person> personList = FXCollections.observableArrayList();

    public Main(){
        personList.add(new Person("Jan","Kowalski"));
        personList.add(new Person("Jan","Nowak"));
        personList.add(new Person("Anna","Kowalska"));
        personList.add(new Person("Bożena","Nowak"));
    }

    ObservableList<Person> getPersonList() {
        return personList;
    }
    public static void main(String[] args) {

    launch();
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Moja aplikacja w JavaFX");
        loadView();
    }

    public void loadView(){
        try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/rootview.fxml"));
        layout = (VBox) loader.load();

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

        PersonControler controler = loader.getController();
        controler.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    void loadNewPerson(){
        loader("/newPerson.fxml","Add person");
    }

    void loadPersonEdit() {
        loader("/personEdit.fxml","Edit person");
    }

    void loadDeletePerson() {
        loader("/personDelete.fxml","Delete person");
    }

    private void loader(String path, String title){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(path));
            VBox window = (VBox)loader.load();

            Stage editStage = new Stage();
            editStage.setTitle(title);
            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
