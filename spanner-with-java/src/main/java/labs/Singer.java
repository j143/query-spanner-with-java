package labs;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Singer {

    @GeneratedValue
    private UUID singerId;

    private String firstName;
    private String lastName;

    private Date birthDate;

    public Singer() {
        // Do nothing
    }

    public Singer(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public UUID getSingerId() {
        return singerId;
    }

    public void setSingerId(UUID singerId) {
        this.singerId = singerId;
    }

    
}