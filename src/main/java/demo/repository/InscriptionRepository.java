package demo.repository;

import demo.domain.Inscription;
import demo.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    //D
    @Query("SELECT i FROM Inscription i WHERE i.state = 'PENDING' OR i.state = 'REJECTED'")
    List<Inscription> findAllByStateIsPendingOrRejected();

    //E -> D con consulta derivada
    List<Inscription> findByStateIn(List<State> states);

    //G
    List<Inscription> findByState(State state);

    //H
    @Query(value = "SELECT * FROM inscription WHERE state = :state", nativeQuery = true)
    List<Inscription> findByStateQueryNativa(@Param("state") String state);
}
