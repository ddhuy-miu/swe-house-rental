package miu.edu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import miu.edu.model.Person;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("select p from Person p where p.firstName =:searchString or " +
            "p.lastName = :searchString or p.phoneNumber = :searchString or p.systemUser.username = :searchString or p.PropertyOwnerName =:searchString")
    Page<Person> searchPerson(String searchString, PageRequest pageRequest);
}
