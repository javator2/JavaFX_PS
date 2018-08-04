import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {


    private Stage stage;
    private VBox layout;

    private ObservableList <Person> personList = FXCollections.observableArrayList();

    public Main() throws IOException {
        List<PersonConverterToStingList> personListToSave = new ArrayList<>();

        personList.add(new Person("Jan","Kowalski","Władysława Łokietka 5","Torun","87-100","666 666 666"));
        personList.add(new Person("Jan","Nowak","Władysława Łokietka 5","Torun","87-100","666 666 666"));
        personList.add(new Person("Anna","Kowalska","Władysława Łokietka 5","Torun","87-100","666 666 666"));
        personList.add(new Person("Bozena","Nowak","Władysława Łokietka 5","Torun","87-100","666 666 666"));


        personListToSave.addAll(PersonConverterToStingList.convert(getPersonList()));
        ObjectMapper mapper = new ObjectMapper();
        File filename = new File("personList.json");
        filename.createNewFile();
        mapper.writeValue(filename,personListToSave);
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

    private void loadView(){
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

    void loadPersonEdit(Person person) {
        loader("/personEdit.fxml","Edit person",person);
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
    private void loader(String path, String title,Person person){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(path));
            VBox window = (VBox)loader.load();

            PersonDetails personDetails = loader.getController();
            personDetails.select(person);
            personDetails.setPerson(person);

            Stage editStage = new Stage();
            editStage.setTitle(title);
            personDetails.setStage(editStage);

            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getStage() {
        return stage;
    }

}
