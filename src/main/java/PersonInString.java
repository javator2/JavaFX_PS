import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonInString {
    private String name;
    private String lastName;
    private String adress;
    private String town;
    private String zipCode;
    private String telephoneNumber;

    public PersonInString() {
    }
}
