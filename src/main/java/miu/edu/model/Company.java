package miu.edu.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@DiscriminatorValue("Company")
public class Company extends PropertyOwner{
    @NotEmpty
    private String companyName;
    @Override
    public String getPropertyOwnerName() {
        return getCompanyName();
    }
    @Override
    public String toString() {
        return "Company [Legal Entity=" + super.toString() +  ", companyName=" + companyName + "]";
    } 
}
