import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main extends Application {

    private Stage stage;
    private VBox layout;
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public Main() throws IOException {
        personList.addAll(readFromJson("personList"));
        saveToJson(personList, "personList");
    }

    public static void main(String[] args) {
        launch();
    }

    Stage getStage() {
        return stage;
    }

    ObservableList<Person> getPersonList() {
        return personList;
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Moja aplikacja w JavaFX");
        loadView();
    }

    private void loadView() {
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

    void loadNewPerson() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/newPerson.fxml"));
            VBox window = (VBox) loader.load();

            Stage editStage = new Stage();
            editStage.setTitle("Add person");
            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadPersonEdit(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/personEdit.fxml"));
            VBox window = (VBox) loader.load();

            PersonDetails personDetails = loader.getController();
            personDetails.select(person);
            personDetails.setPerson(person);

            Stage editStage = new Stage();
            editStage.setTitle("Edit person");
            personDetails.setStage(editStage);

            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Collection<? extends Person> readFromJson(String nameOfTheFile) throws IOException {
        ObservableList<Person> personListToRead = FXCollections.observableArrayList();
        ObjectMapper mapper = new ObjectMapper();

        List<PersonInString> personListInString =
                new ArrayList<>(mapper.readValue(new File(nameOfTheFile + ".json"),
                        new TypeReference<List<PersonInString>>() {
                        }));

        personListToRead.addAll(PersonConverter.convertToStringProperty(personListInString));
        return personListToRead;
    }

    private void saveToJson(ObservableList<Person> listsOfPersons, String nameOfFile) throws IOException {
        List<PersonInString> personListToSave
                = new ArrayList<>(PersonConverter.convertToSting(listsOfPersons));
        ObjectMapper mapper = new ObjectMapper();
        File filename = new File(nameOfFile + ".json");
        filename.createNewFile();
        mapper.writeValue(filename, personListToSave);
    }
}
