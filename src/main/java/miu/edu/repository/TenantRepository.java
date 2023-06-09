package miu.edu.repository;

import miu.edu.model.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    @Query("select t from Tenant t where t.name =:searchString or t.PropertyOwner.PropertyOwnerName = :searchString")
    Page<Tenant> searchTenant(String searchString, PageRequest pageRequest);
}
