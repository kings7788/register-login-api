package tw.com.bryant.register.model;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.com.bryant.register.model.CIMember;

public interface CIMemberRepository extends JpaRepository<CIMember,Long> {

    public CIMember findByCiUsername(String username);
}
