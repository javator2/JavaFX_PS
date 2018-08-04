import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Data
public class PersonConverterToStingList {

    private String name;
    private String lastName;
    private String adress;
    private String town;
    private String zipCode;
    private String telephoneNumber;

    public static Collection<? extends PersonConverterToStingList> convert(ObservableList<Person> personList) {
        List<PersonConverterToStingList> personListToSave = new ArrayList<>();

        for (Person aPersonList : personList) {
            personListToSave.add
                    (new PersonConverterToStingList
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


}
