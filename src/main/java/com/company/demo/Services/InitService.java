package com.company.demo.Services;

import com.company.demo.Entity.*;
import com.company.demo.Repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class InitService {

    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;
    private ProjectRepository projectRepository;
    private StatusRepository statusRepository;
    private PriorityRepository priorityRepository;
    private TaskRepository taskRepository;
    private AdressRepository adressRepository;

    public InitService(EmployeeRepository employeeRepository, PositionRepository positionRepository, ProjectRepository projectRepository, StatusRepository statusRepository, PriorityRepository priorityRepository, TaskRepository taskRepository, AdressRepository adressRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.projectRepository = projectRepository;
        this.statusRepository = statusRepository;
        this.priorityRepository = priorityRepository;
        this.taskRepository = taskRepository;
        this.adressRepository = adressRepository;
    }

    public void init() {
        Employee e1 = employeeRepository.save(new Employee("Kate", "Mon", positionRepository.findById(3).orElse(null), LocalDate.of(1991, 02, 21), 4500, LocalDate.of(2021, 01, 01), true, adressRepository.findById(1).orElse(null), LocalDate.of(2025, 01, 01)));
        Employee e2 = employeeRepository.save(new Employee("Max", "Donken", positionRepository.findById(2).orElse(null), LocalDate.of(1987, 1, 15), 12000, LocalDate.of(2015, 04, 07), true, adressRepository.findById(2).orElse(null), LocalDate.of(2022, 01, 01)));
        Employee e3 = employeeRepository.save(new Employee("John", "Jhonson", positionRepository.findById(1).orElse(null), LocalDate.of(1963, 05, 06), 7000, LocalDate.of(2020, 11, 2), true, adressRepository.findById(3).orElse(null), LocalDate.of(2021, 12, 24)));
        Employee e4 = employeeRepository.save(new Employee("Cris", "Podlaski", positionRepository.findById(1).orElse(null), LocalDate.of(1982, 9, 10), 4250, LocalDate.of(2018, 10, 14), false, adressRepository.findById(4).orElse(null), LocalDate.of(2021, 11, 17)));
        Employee e5 = employeeRepository.save(new Employee("Madona", "Mem", positionRepository.findById(1).orElse(null), LocalDate.of(1999, 10, 12), 5100, LocalDate.of(2017, 6, 1), true, adressRepository.findById(5).orElse(null), LocalDate.of(2021, 11, 17)));
        Employee e6 = employeeRepository.save(new Employee("Jenifer", "Górska", positionRepository.findById(2).orElse(null), LocalDate.of(1997, 8, 28), 8000, LocalDate.of(2016, 5, 30), true, adressRepository.findById(6).orElse(null), LocalDate.of(2021, 11, 17)));
        Employee e7 = employeeRepository.save(new Employee("Dona", "Specter", positionRepository.findById(3).orElse(null), LocalDate.of(1984, 1, 15), 10000, LocalDate.of(2012, 5, 1), true, adressRepository.findById(7).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e8 = employeeRepository.save(new Employee("Nr8", "Specter", positionRepository.findById(1).orElse(null), LocalDate.of(1984, 1, 16), 10000, LocalDate.of(2020, 5, 1), true, adressRepository.findById(8).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e9 = employeeRepository.save(new Employee("Nr9", "Aqw", positionRepository.findById(1).orElse(null), LocalDate.of(1984, 1, 17), 10000, LocalDate.of(1999, 5, 1), true, adressRepository.findById(9).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e10 = employeeRepository.save(new Employee("Nr10", "Wer", positionRepository.findById(1).orElse(null), LocalDate.of(1999, 12, 18), 5500, LocalDate.of(2005, 5, 1), true, adressRepository.findById(10).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e11 = employeeRepository.save(new Employee("Nr11", "Srt", positionRepository.findById(1).orElse(null), LocalDate.of(1987, 11, 19), 5500, LocalDate.of(2006, 5, 1), true, adressRepository.findById(11).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e12 = employeeRepository.save(new Employee("Nr12", "Sty", positionRepository.findById(1).orElse(null), LocalDate.of(1986, 9, 20), 5500, LocalDate.of(2002, 5, 1), true, adressRepository.findById(12).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e13 = employeeRepository.save(new Employee("Nr13", "Ert", positionRepository.findById(1).orElse(null), LocalDate.of(1987, 8, 11), 5500, LocalDate.of(2007, 5, 1), true, adressRepository.findById(13).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e14 = employeeRepository.save(new Employee("Nr14", "Rty", positionRepository.findById(1).orElse(null), LocalDate.of(1989, 7, 12), 5500, LocalDate.of(2008, 5, 1), true, adressRepository.findById(14).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e15 = employeeRepository.save(new Employee("Nr15", "Tyu", positionRepository.findById(1).orElse(null), LocalDate.of(1999, 6, 13), 5500, LocalDate.of(2009, 5, 1), true, adressRepository.findById(15).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e16 = employeeRepository.save(new Employee("Nr16", "Tyi", positionRepository.findById(1).orElse(null), LocalDate.of(1993, 5, 14), 5500, LocalDate.of(2010, 5, 1), true, adressRepository.findById(16).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e17 = employeeRepository.save(new Employee("Nr17", "Uio", positionRepository.findById(1).orElse(null), LocalDate.of(1991, 4, 15), 5500, LocalDate.of(2012, 5, 1), true, adressRepository.findById(17).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e18 = employeeRepository.save(new Employee("Nr18", "Qwer", positionRepository.findById(1).orElse(null), LocalDate.of(1992, 3, 16), 5500, LocalDate.of(2011, 5, 1), true, adressRepository.findById(18).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e19 = employeeRepository.save(new Employee("Nr19", "Dass", positionRepository.findById(1).orElse(null), LocalDate.of(1981, 2, 17), 5500, LocalDate.of(2012, 5, 1), true, adressRepository.findById(19).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e20 = employeeRepository.save(new Employee("Nr20", "Popp", positionRepository.findById(1).orElse(null), LocalDate.of(1982, 10, 18), 5500, LocalDate.of(2013, 5, 1), true, adressRepository.findById(20).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e21 = employeeRepository.save(new Employee("Nr21", "Poiu", positionRepository.findById(1).orElse(null), LocalDate.of(1983, 11, 19), 5500, LocalDate.of(2014, 5, 1), true, adressRepository.findById(21).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e22 = employeeRepository.save(new Employee("Nr22", "Ytr", positionRepository.findById(1).orElse(null), LocalDate.of(1984, 11, 5), 5500, LocalDate.of(2015, 5, 1), true, adressRepository.findById(22).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e23 = employeeRepository.save(new Employee("Nr23", "Vds", positionRepository.findById(1).orElse(null), LocalDate.of(1985, 12, 2), 5500, LocalDate.of(2016, 5, 1), true, adressRepository.findById(23).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e24 = employeeRepository.save(new Employee("Nr24", "Fds", positionRepository.findById(1).orElse(null), LocalDate.of(1986, 9, 3), 5500, LocalDate.of(2017, 5, 1), true, adressRepository.findById(24).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e25 = employeeRepository.save(new Employee("Nr25", "Asd", positionRepository.findById(1).orElse(null), LocalDate.of(1987, 9, 4), 5500, LocalDate.of(2018, 5, 1), true, adressRepository.findById(25).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e26 = employeeRepository.save(new Employee("Nr26", "Spy", positionRepository.findById(1).orElse(null), LocalDate.of(1988, 9, 5), 5500, LocalDate.of(2019, 5, 1), true, adressRepository.findById(26).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e27 = employeeRepository.save(new Employee("Nr27", "Sld", positionRepository.findById(1).orElse(null), LocalDate.of(1989, 8, 6), 5500, LocalDate.of(2020, 5, 1), true, adressRepository.findById(27).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e28 = employeeRepository.save(new Employee("Nr28", "Sas", positionRepository.findById(1).orElse(null), LocalDate.of(1990, 8, 7), 6000, LocalDate.of(2021, 5, 1), true, adressRepository.findById(28).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e29 = employeeRepository.save(new Employee("Nr29", "Cds", positionRepository.findById(1).orElse(null), LocalDate.of(2000, 8, 8), 6000, LocalDate.of(2001, 5, 1), true, adressRepository.findById(29).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e30 = employeeRepository.save(new Employee("Nr30", "Azs", positionRepository.findById(2).orElse(null), LocalDate.of(2001, 7, 9), 6000, LocalDate.of(2012, 5, 1), true, adressRepository.findById(30).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e31 = employeeRepository.save(new Employee("Nr31", "Alo", positionRepository.findById(2).orElse(null), LocalDate.of(2000, 8, 10), 6000, LocalDate.of(2013, 5, 1), true, adressRepository.findById(31).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e32 = employeeRepository.save(new Employee("Nr32", "Pou", positionRepository.findById(1).orElse(null), LocalDate.of(2001, 7, 1), 6000, LocalDate.of(2012, 5, 1), true, adressRepository.findById(32).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e33 = employeeRepository.save(new Employee("Nr33", "Asd", positionRepository.findById(1).orElse(null), LocalDate.of(2002, 7, 2), 6000, LocalDate.of(2013, 5, 1), true, adressRepository.findById(33).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e34 = employeeRepository.save(new Employee("Nr34", "Bfd", positionRepository.findById(1).orElse(null), LocalDate.of(2003, 7, 3), 6000, LocalDate.of(2015, 5, 1), true, adressRepository.findById(34).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e35 = employeeRepository.save(new Employee("Nr35", "Pog", positionRepository.findById(1).orElse(null), LocalDate.of(2004, 6, 4), 6000, LocalDate.of(2016, 5, 1), true, adressRepository.findById(35).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e36 = employeeRepository.save(new Employee("Nr36", "Lkd", positionRepository.findById(1).orElse(null), LocalDate.of(2005, 6, 5), 6000, LocalDate.of(2017, 5, 1), true, adressRepository.findById(36).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e37 = employeeRepository.save(new Employee("Nr37", "Kfd", positionRepository.findById(1).orElse(null), LocalDate.of(1999, 6, 6), 6000, LocalDate.of(2018, 5, 1), true, adressRepository.findById(37).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e38 = employeeRepository.save(new Employee("Nr38", "Dsw", positionRepository.findById(1).orElse(null), LocalDate.of(1991, 6, 7), 6000, LocalDate.of(2020, 5, 1), true, adressRepository.findById(38).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e39 = employeeRepository.save(new Employee("Nr39", "Gtr", positionRepository.findById(1).orElse(null), LocalDate.of(1975, 5, 8), 6000, LocalDate.of(2019, 5, 1), true, adressRepository.findById(39).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e40 = employeeRepository.save(new Employee("Nr40", "Ghy", positionRepository.findById(1).orElse(null), LocalDate.of(1965, 5, 15), 8500, LocalDate.of(2001, 5, 1), true, adressRepository.findById(40).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e41 = employeeRepository.save(new Employee("Nr41", "Juy", positionRepository.findById(2).orElse(null), LocalDate.of(1966, 5, 16), 12000, LocalDate.of(2000, 5, 1), true, adressRepository.findById(41).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e42 = employeeRepository.save(new Employee("Nr42", "Kiy", positionRepository.findById(2).orElse(null), LocalDate.of(1970, 5, 17), 11000, LocalDate.of(2006, 5, 1), true, adressRepository.findById(42).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e43 = employeeRepository.save(new Employee("Nr43", "Mfd", positionRepository.findById(2).orElse(null), LocalDate.of(1979, 4, 18), 10000, LocalDate.of(2007, 5, 1), true, adressRepository.findById(43).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e44 = employeeRepository.save(new Employee("Nr44", "Nko", positionRepository.findById(2).orElse(null), LocalDate.of(1978, 4, 19), 8000, LocalDate.of(2015, 5, 1), true, adressRepository.findById(44).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e45 = employeeRepository.save(new Employee("Nr45", "Paftd", positionRepository.findById(2).orElse(null), LocalDate.of(1984, 4, 25), 9000, LocalDate.of(2001, 5, 1), true, adressRepository.findById(45).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e46 = employeeRepository.save(new Employee("Nr46", "Plorh", positionRepository.findById(3).orElse(null), LocalDate.of(1979, 4, 26), 18000, LocalDate.of(2015, 5, 1), true, adressRepository.findById(46).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e47 = employeeRepository.save(new Employee("Nr47", "Kama", positionRepository.findById(3).orElse(null), LocalDate.of(1971, 4, 27), 17000, LocalDate.of(2014, 5, 1), true, adressRepository.findById(47).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e48 = employeeRepository.save(new Employee("Nr48", "Mourle", positionRepository.findById(3).orElse(null), LocalDate.of(1985, 3, 28), 16000, LocalDate.of(2013, 5, 1), true, adressRepository.findById(48).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e49 = employeeRepository.save(new Employee("Nr49", "Nice", positionRepository.findById(3).orElse(null), LocalDate.of(1989, 2, 21), 15000, LocalDate.of(2001, 5, 1), true, adressRepository.findById(49).orElse(null), LocalDate.of(2024, 02, 03)));
        Employee e50 = employeeRepository.save(new Employee("Nr50", "Good", positionRepository.findById(4).orElse(null), LocalDate.of(1987, 2, 7), 50000, LocalDate.of(1998, 5, 1), true, adressRepository.findById(50).orElse(null), LocalDate.of(2024, 02, 03)));

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,e23,e24,e25,e26,e27,e28,e29,e30,e31,e32,e33,e34,e35,e36,e37,e38,e39,e40,
                e41,e42,e43,e44,e45,e46,e47,e48,e49,e50);

        Project project1 = new Project("Erif", statusRepository.findById(2).get(), LocalDate.of(2021, 12, 24), priorityRepository.findById(1).get());
        Project project2 = new Project("Kruk", statusRepository.findById(3).get(), LocalDate.of(2021, 11, 1), priorityRepository.findById(3).get());
        Project project3 = new Project("Coś", statusRepository.findById(1).get(), LocalDate.of(2021, 11, 15), priorityRepository.findById(2).get());
        Project project4 = new Project("Nowy", statusRepository.findById(3).get(), LocalDate.of(2022, 5, 1), priorityRepository.findById(2).get());
        Project project5 = new Project("Nowy5", statusRepository.findById(2).get(), LocalDate.of(2022, 1, 30), priorityRepository.findById(4).get());
        Project project6 = new Project("Nowy6", statusRepository.findById(1).get(), LocalDate.of(2023, 11, 30), priorityRepository.findById(2).get());
        Project project7 = new Project("Nowy7", statusRepository.findById(1).get(), LocalDate.of(2025, 10, 30), priorityRepository.findById(3).get());
        Project project8 = new Project("Nowy8", statusRepository.findById(1).get(), LocalDate.of(2022, 9, 30), priorityRepository.findById(2).get());
        Project project9 = new Project("Nowy9", statusRepository.findById(1).get(), LocalDate.of(2024, 8, 30), priorityRepository.findById(2).get());
        Project project10 = new Project("Nowy10", statusRepository.findById(1).get(), LocalDate.of(2025, 7, 30), priorityRepository.findById(3).get());
        Project project11 = new Project("Nowy11", statusRepository.findById(1).get(), LocalDate.of(2026, 6, 30), priorityRepository.findById(3).get());
        Project project12 = new Project("Nowy12", statusRepository.findById(3).get(), LocalDate.of(2027, 5, 30), priorityRepository.findById(3).get());
        Project project13 = new Project("Nowy13", statusRepository.findById(3).get(), LocalDate.of(2028, 4, 30), priorityRepository.findById(1).get());
        Project project14= new Project("Nowy14", statusRepository.findById(3).get(), LocalDate.of(2022, 3, 30), priorityRepository.findById(4).get());
        Project project15 = new Project("Nowy15", statusRepository.findById(3).get(), LocalDate.of(2022, 2, 17), priorityRepository.findById(4).get());

        List<Project> projects = Arrays.asList(project1, project2, project3, project4, project5, project6, project7, project8, project9, project10, project11, project12, project13, project14, project15);


        Task task1 = new Task("Nowy Task", "Założenie pierwszego taska", 4, statusRepository.findById(3).get());
        Task task2 = new Task("Kolejny", "Założenie drugiego taska", 2, statusRepository.findById(1).get());
        Task task3 = new Task("Następny", "Założenie trzeciego taska", 6, statusRepository.findById(3).get());
        Task task4 = new Task("Jeszcze jeden", "Założenie czwartego taska", 8, statusRepository.findById(1).get());
        Task task5 = new Task("Nowy5", "Założenie piątego taska", 12, statusRepository.findById(2).get());
        Task task6 = new Task("Nowy6", "Założenie szóstego taska", 7,statusRepository.findById(1).get());
        Task task7 = new Task("Nowy7", "Założenie siódmego taska", 8, statusRepository.findById(1).get());
        Task task8 = new Task("Nowy8", "Założenie ósmego taska", 7, statusRepository.findById(1).get());
        Task task9 = new Task("Nowy9", "Założenie dziewiątgo taska", 5, statusRepository.findById(1).get());
        Task task10 = new Task("Nowy10", "Założenie dziesiątego taska", 4, statusRepository.findById(3).get());
        Task task11 = new Task("Nowy11", "Założenie kolejnego taska", 12, statusRepository.findById(1).get());
        Task task12 = new Task("Nowy12", "Założenie kolejnego 12 taska", 15, statusRepository.findById(1).get());
        Task task13 = new Task("Nowy13", "Założenie kolejnego 13 taska", 9, statusRepository.findById(1).get());
        Task task14 = new Task("Nowy14", "Założenie kolejnego 14 taska", 7, statusRepository.findById(1).get());
        Task task15 = new Task("Nowy15", "Założenie kolejnego 15 taska", 6, statusRepository.findById(1).get());
        Task task16 = new Task("Nowy16", "Założenie kolejnego 16 taska", 8, statusRepository.findById(2).get());
        Task task17 = new Task("Nowy17", "Założenie kolejnego 17 taska", 9, statusRepository.findById(2).get());
        Task task18 = new Task("Nowy18", "Założenie kolejnego 18 taska", 12, statusRepository.findById(3).get());
        Task task19 = new Task("Nowy19", "Założenie kolejnego 19 taska", 17, statusRepository.findById(3).get());
        Task task20 = new Task("Nowy20", "Założenie kolejnego 20 taska", 18, statusRepository.findById(3).get());
        Task task21 = new Task("Nowy21", "Założenie kolejnego 21 taska", 15, statusRepository.findById(3).get());
        Task task22 = new Task("Nowy22", "Założenie kolejnego 22 taska", 4, statusRepository.findById(1).get());
        Task task23 = new Task("Nowy23", "Założenie kolejnego 23 taska", 3, statusRepository.findById(1).get());
        Task task24 = new Task("Nowy24", "Założenie kolejnego 24 taska", 2, statusRepository.findById(1).get());
        Task task25 = new Task("Nowy25", "Założenie kolejnego 25 taska", 8, statusRepository.findById(1).get());



        project1.addTask(task1);
        project2.addTask(task2);
        project1.addTask(task3);
        project3.addTask(task4);
        project2.addTask(task6);
        project5.addTask(task7);
        project1.addTask(task5);

        projectRepository.saveAll(projects);


        Address address = adressRepository.findById(1).orElse(null);
        address.setEmployee(e1);
        Address address2 = adressRepository.findById(2).orElse(null);
        address2.setEmployee(e2);
        Address address3 = adressRepository.findById(3).orElse(null);
        address3.setEmployee(e3);
        Address address4 = adressRepository.findById(4).orElse(null);
        address4.setEmployee(e4);
        Address address5 = adressRepository.findById(5).orElse(null);
        address5.setEmployee(e5);
        Address address6 = adressRepository.findById(6).orElse(null);
        address6.setEmployee(e6);
        Address address7 = adressRepository.findById(7).orElse(null);
        address7.setEmployee(e7);
        Address address8 = adressRepository.findById(8).orElse(null);
        address8.setEmployee(e8);
        Address address9 = adressRepository.findById(9).orElse(null);
        address9.setEmployee(e9);
        Address address10 = adressRepository.findById(10).orElse(null);
        address10.setEmployee(e10);
        Address address11 = adressRepository.findById(11).orElse(null);
        address11.setEmployee(e11);
        Address address12 = adressRepository.findById(12).orElse(null);
        address12.setEmployee(e12);
        Address address13 = adressRepository.findById(13).orElse(null);
        address13.setEmployee(e13);
        Address address14 = adressRepository.findById(14).orElse(null);
        address14.setEmployee(e14);
        Address address15 = adressRepository.findById(15).orElse(null);
        address15.setEmployee(e15);
        Address address16 = adressRepository.findById(16).orElse(null);
        address16.setEmployee(e16);
        Address address17 = adressRepository.findById(17).orElse(null);
        address17.setEmployee(e17);
        Address address18 = adressRepository.findById(18).orElse(null);
        address18.setEmployee(e18);
        Address address19 = adressRepository.findById(19).orElse(null);
        address19.setEmployee(e19);
        Address address20 = adressRepository.findById(20).orElse(null);
        address20.setEmployee(e20);
        Address address21 = adressRepository.findById(21).orElse(null);
        address21.setEmployee(e21);
        Address address22 = adressRepository.findById(22).orElse(null);
        address22.setEmployee(e22);
        Address address23 = adressRepository.findById(23).orElse(null);
        address23.setEmployee(e23);
        Address address24 = adressRepository.findById(24).orElse(null);
        address24.setEmployee(e24);
        Address address25 = adressRepository.findById(25).orElse(null);
        address25.setEmployee(e25);
        Address address26 = adressRepository.findById(26).orElse(null);
        address26.setEmployee(e26);
        Address address27 = adressRepository.findById(27).orElse(null);
        address27.setEmployee(e27);
        Address address28 = adressRepository.findById(28).orElse(null);
        address28.setEmployee(e28);
        Address address30 = adressRepository.findById(30).orElse(null);
        address30.setEmployee(e30);
        Address address29 = adressRepository.findById(29).orElse(null);
        address29.setEmployee(e29);
        Address address31 = adressRepository.findById(31).orElse(null);
        address31.setEmployee(e31);
        Address address32 = adressRepository.findById(32).orElse(null);
        address32.setEmployee(e32);
        Address address33 = adressRepository.findById(33).orElse(null);
        address33.setEmployee(e33);
        Address address34 = adressRepository.findById(34).orElse(null);
        address34.setEmployee(e34);
        Address address35 = adressRepository.findById(35).orElse(null);
        address35.setEmployee(e35);
        Address address36 = adressRepository.findById(36).orElse(null);
        address36.setEmployee(e36);
        Address address37 = adressRepository.findById(37).orElse(null);
        address37.setEmployee(e37);
        Address address38 = adressRepository.findById(38).orElse(null);
        address38.setEmployee(e38);
        Address address39 = adressRepository.findById(39).orElse(null);
        address39.setEmployee(e39);
        Address address40 = adressRepository.findById(40).orElse(null);
        address40.setEmployee(e40);
        Address address41 = adressRepository.findById(41).orElse(null);
        address41.setEmployee(e41);
        Address address42 = adressRepository.findById(42).orElse(null);
        address42.setEmployee(e42);
        Address address43 = adressRepository.findById(43).orElse(null);
        address43.setEmployee(e43);
        Address address44 = adressRepository.findById(44).orElse(null);
        address44.setEmployee(e44);
        Address address45 = adressRepository.findById(45).orElse(null);
        address45.setEmployee(e45);
        Address address46 = adressRepository.findById(46).orElse(null);
        address46.setEmployee(e46);
        Address address47 = adressRepository.findById(47).orElse(null);
        address47.setEmployee(e47);
        Address address48 = adressRepository.findById(48).orElse(null);
        address48.setEmployee(e48);
        Address address49 = adressRepository.findById(49).orElse(null);
        address49.setEmployee(e49);
        Address address50 = adressRepository.findById(50).orElse(null);
        address50.setEmployee(e50);

        List<Address> adresses = Arrays.asList(address, address2, address3, address4, address5, address6, address7, address8, address9, address10, address11, address12, address13,address14, address15,address16, address17,
                address18, address19,address19,address20, address21, address22, address23, address24,address25, address26,address27,address28,address29,address30,address31, address32, address33,address34, address35,
                address26,address37,address38,address39,address40, address41,address42,address43,address44, address45,address46,address47,address48,address49,address50);
        adressRepository.saveAll(adresses);


        task1.setProject(project1);
        task2.setProject(project2);
        task3.setProject(project1);
        task4.setProject(project3);
        task5.setProject(project1);
        task6.setProject(project2);
        task7.setProject(project5);
        task8.setProject(project6);
        task9.setProject(project7);
        task10.setProject(project8);
        task11.setProject(project9);
        task12.setProject(project10);
        task13.setProject(project11);
        task14.setProject(project12);
        task15.setProject(project13);
        task16.setProject(project14);
        task17.setProject(project15);
        task18.setProject(project1);
        task19.setProject(project2);
        task20.setProject(project3);
        task21.setProject(project4);
        task22.setProject(project5);
        task23.setProject(project6);
        task24.setProject(project7);
        task25.setProject(project8);


        e1.addTask(task1);
        e1.addTask(task2);
        e3.addTask(task3);
        e4.addTask(task4);
        e4.addTask(task5);
        e5.addTask(task6);
        e7.addTask(task7);
        e8.addTask(task8);
        e9.addTask(task9);
        e10.addTask(task10);
        e11.addTask(task11);
        e12.addTask(task12);
        e13.addTask(task13);
        e14.addTask(task14);
        e15.addTask(task15);
        e16.addTask(task16);
        e17.addTask(task17);
        e18.addTask(task18);
        e19.addTask(task19);
        e20.addTask(task20);
        e21.addTask(task21);
        e22.addTask(task22);
        e23.addTask(task23);
        e24.addTask(task24);
        e25.addTask(task25);

        task1.setEmployee(e1);
        task2.setEmployee(e2);
        task3.setEmployee(e3);
        task4.setEmployee(e4);
        task5.setEmployee(e5);
        task6.setEmployee(e6);
        task7.setEmployee(e7);
        task8.setEmployee(e8);
        task9.setEmployee(e9);
        task10.setEmployee(e10);
        task11.setEmployee(e11);
        task12.setEmployee(e12);
        task13.setEmployee(e13);
        task14.setEmployee(e14);
        task15.setEmployee(e15);
        task16.setEmployee(e16);
        task17.setEmployee(e17);
        task18.setEmployee(e18);
        task19.setEmployee(e19);
        task20.setEmployee(e20);
        task21.setEmployee(e21);
        task22.setEmployee(e22);
        task23.setEmployee(e23);
        task24.setEmployee(e24);
        task25.setEmployee(e25);

        e1.addProject(project1);
        e2.addProject(project3);
        e3.addProject(project1);
        e4.addProject(project3);
        e4.addProject(project1);
        e5.addProject(project2);
        e5.addProject(project5);
        e6.addProject(project4);
        e7.addProject(project5);
        e8.addProject(project6);
        e9.addProject(project7);
        e10.addProject(project8);
        e11.addProject(project9);
        e12.addProject(project10);
        e13.addProject(project11);
        e14.addProject(project12);
        e15.addProject(project13);
        e16.addProject(project14);
        e17.addProject(project15);
        e18.addProject(project1);
        e19.addProject(project2);
        e20.addProject(project3);
        e21.addProject(project4);
        e22.addProject(project5);
        e23.addProject(project6);
        e24.addProject(project7);
        e25.addProject(project8);
        e26.addProject(project15);
        e27.addProject(project14);
        e28.addProject(project13);
        e29.addProject(project13);
        e30.addProject(project12);
        e31.addProject(project12);
        e32.addProject(project11);
        e33.addProject(project10);
        e34.addProject(project9);
        e35.addProject(project8);
        e36.addProject(project8);
        e37.addProject(project8);
        e38.addProject(project11);
        e39.addProject(project12);
        e40.addProject(project15);
        e41.addProject(project7);
        e42.addProject(project7);
        e43.addProject(project6);
        e44.addProject(project5);
        e45.addProject(project5);
        e46.addProject(project4);
        e47.addProject(project2);
        e48.addProject(project13);
        e49.addProject(project14);



        List<Task> tasks = Arrays.asList(task1, task2, task3, task4, task5, task6, task7, task8, task9, task10, task11, task12, task13, task14, task15, task15, task16, task17, task18, task19, task20, task21, task22,
                task23, task24, task25);
        taskRepository.saveAll(tasks);
        employeeRepository.saveAll(employees);
    }
}
