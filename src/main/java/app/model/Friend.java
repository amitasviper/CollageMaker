package app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friend")
public class Friend implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    protected Friend() {
    }

    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Friend[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }
}