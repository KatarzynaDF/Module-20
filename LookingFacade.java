package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.dao.CompanyDao;
import com.kodilla.hibernate.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LookingFacade {


    @Autowired

    private EmployeeDao employeeDao;


    private static final Logger LOGGER = LoggerFactory.getLogger(LookingFacade.class);

    public List<Employee> searchEmployee(String search) throws LookingProcessException {
        LOGGER.info("Searching for employees matching " + search);
        List<Employee> list = employeeDao. findMatchingName(search);
        if (list.size() < 1) {
            LOGGER.error(LookingProcessException.EMPLOYEE_DOES_NOT_EXIST);
            throw new LookingProcessException(LookingProcessException.EMPLOYEE_DOES_NOT_EXIST);
        } else {
            LOGGER.info("List of employees matching");
            for (Employee employee : list) {
                LOGGER.info(employee.getFirstname() + " " + employee.getLastname());
            }
            return list;
        }
    }
}
