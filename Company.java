package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;
import static org.hibernate.hql.internal.antlr.HqlTokenTypes.SELECT;

@NamedNativeQuery(
        name = "Company.lookForCompanyName",
       query = "SELECT * FROM COMPANY_NAME" +
                "WHERE NAME LIKE PARAMETER",
        resultClass = Company.class
)

@NamedQuery(
        name = "Company.findMatchingName",
        query = "FROM Company WHERE lastname LIKE CONCAT('%',:NAME,'%')"
)
@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();
    public static String PARAMETER = "%gre%";

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}