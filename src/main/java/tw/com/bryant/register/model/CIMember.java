package tw.com.bryant.register.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="ci_member")
@NoArgsConstructor
@AllArgsConstructor
public class CIMember {

    @Id
    @Column(name="id")
    @SequenceGenerator(name="seq-gen",sequenceName="ci_member_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
    private Long Id;

    @Column(name="ci_username")
    private String ciUsername;

    @Column(name="ci_email")
    private String ciEmail;

    @Column(name="ci_password")
    private String ciPassword;

    @Column(name="ci_name")
    private String ciName;

    public CIMember(
        String ciUsername,
        String ciPassword,
        String ciEmail
    )
    {
        this.ciUsername = ciUsername;
        this.ciPassword = ciPassword;
        this.ciEmail = ciEmail;
    }

}
