import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonConverter {

    static Collection<? extends PersonInString> convertToSting(ObservableList<Person> personList) {
        List<PersonInString> personListToSave = new ArrayList<>();

        for (Person aPersonList : personList) {
            personListToSave.add
                    (new PersonInString
                            (aPersonList.getName(),
                                    aPersonList.getLastName(),
                                    aPersonList.getAdress(),
                                    aPersonList.getTown(),
                                    aPersonList.getZipCode(),
                                    aPersonList.getTelephoneNumber()
                            ));
        }

        return personListToSave;
    }
    static ObservableList <Person> convertToStringProperty(List<PersonInString> personListToRead) {
         ObservableList <Person> personList = FXCollections.observableArrayList();

        for (PersonInString aPersonListToRead : personListToRead) {

            personList.add
                    (new Person
                            (aPersonListToRead.getName(),
                                    aPersonListToRead.getLastName(),
                                    aPersonListToRead.getAdress(),
                                    aPersonListToRead.getTown(),
                                    aPersonListToRead.getZipCode(),
                                    aPersonListToRead.getTelephoneNumber()));
        }

        return personList;
    }
}
