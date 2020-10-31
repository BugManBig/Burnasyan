package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

public class Model {
    private List<Person> patients;
    private List<Person> doctors;
    private List<String> diagnosis;
    private int nextPatientId;
    private int nextDoctorId;
    private int nextResearchId;
    private Task task;

    public void calculateNextResearchId() {
        String[] files = new File(Params.get("PATH") + "/Research").list();
        for (String file : files) {
            int id = Integer.parseInt(file.substring(0, file.indexOf('.')));
            if (id > nextResearchId) {
                nextResearchId = id;
            }
        }
        nextResearchId++;
    }

    public void createTask() {
        task = new Task();
    }

    public Task getTask() {
        return task;
    }

    public List<Person> getDoctors() {
        return doctors;
    }

    public List<String> getDiagnosis() {
        return diagnosis;
    }

    public int getNextPatientId() {
        return nextPatientId;
    }

    public int getNextDoctorId() {
        return nextDoctorId;
    }

    public Sex getPatientSex(String name) {
        for (Person person : patients) {
            if (person.getName().equals(name)) {
                return person.getSex();
            }
        }
        return Sex.NONE;
    }

    public Person getPatient(int id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                return patients.get(i);
            }
        }
        return null;
    }

    public Person getDoctor(int id) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == id) {
                return doctors.get(i);
            }
        }
        return null;
    }

    public void readPatients() {
        File file = new File(Params.get("PATH") + "/Patients");
        File[] files = file.listFiles();
        patients = new ArrayList<>();
        nextPatientId = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isHidden()) {
                continue;
            }
            patients.add(getPersonFromFile(files[i]));
            String name = files[i].getName();
            int currentId = Integer.parseInt(name.substring(0, name.indexOf(".")));
            if (currentId > nextPatientId) {
                nextPatientId = currentId;
            }
        }
        nextPatientId++;
    }

    public void readDoctors() {
        File file = new File(Params.get("PATH") + "/Doctors");
        File[] files = file.listFiles();
        doctors = new ArrayList<>();
        nextDoctorId = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isHidden()) {
                continue;
            }
            doctors.add(getPersonFromFile(files[i]));
            String name = files[i].getName();
            int currentId = Integer.parseInt(name.substring(0, name.indexOf(".")));
            if (currentId > nextDoctorId) {
                nextDoctorId = currentId;
            }
        }
        nextDoctorId++;
    }

    public void readDiagnosis() {
        File file = new File(Params.get("PATH") + "/Diagnosis.txt");
        try {
            diagnosis = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addDiagnosis(String diagnosis) {
        List<String> diagnoses = new ArrayList<>();
        diagnoses.add(diagnosis);
        try {
            Files.write(new File(Params.get("PATH") + "/Diagnosis.txt").toPath(),
                    diagnoses, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getFilteredPatients(String name, String surname, String patronymic) {
        name = name.toLowerCase();
        surname = surname.toLowerCase();
        patronymic = patronymic.toLowerCase();
        List<Person> filteredList = new ArrayList<>();
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getSurname().toLowerCase().startsWith(surname)
                    && patients.get(i).getName().toLowerCase().startsWith(name)
                    && patients.get(i).getPatronymic().toLowerCase().startsWith(patronymic)) {
                filteredList.add(patients.get(i));
            }
        }
        return filteredList;
    }

    public static List<String> getFileContents(String path) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private Person getPersonFromFile(File file) {
        List<String> lines = getFileContents(file.getPath());
        String fileName = file.getName();
        int id = Integer.parseInt(fileName.substring(0, fileName.lastIndexOf(".")));
        if (lines.size() < 5) {
            return new Person(id, lines.get(0), lines.get(1), lines.get(2));
        }
        return new Person(id, lines.get(0), lines.get(1), lines.get(2), lines.get(3), Sex.valueOf(lines.get(4)));
    }

    public void saveResearch() {
        calculateNextResearchId();
        try {
            Files.write(new File(Params.get("PATH") + "/Research/" + nextResearchId + ".txt").toPath(),
                    task.getData(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTransplantationDate(int patientId) {
        List<PairIdDate> researchList = getResearchList(patientId);
        if (researchList.size() == 0) {
            return null;
        }
        int researchId = researchList.get(0).id;
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(Params.get("PATH") + "/Research/" + researchId + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("transplantationDate");
    }

    public List<PairIdDate> getResearchList(int patientId) {
        List<PairIdDate> list = new ArrayList<>();
        File[] research = new File(Params.get("PATH") + "/Research").listFiles();
        for (int i = 0; i < research.length; i++) {
            Properties properties = new Properties();
            try {
                properties.load(new FileReader(research[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (properties.getProperty("patientId").equals(String.valueOf(patientId))) {
                list.add(new PairIdDate(
                        Integer.parseInt(research[i].getName().substring(0, research[i].getName().lastIndexOf('.'))),
                        properties.getProperty("date")));
            }
        }
        list.sort(new Comparator<PairIdDate>() {
            @Override
            public int compare(PairIdDate o1, PairIdDate o2) {
                LocalDate date1 = LocalDate.parse(o1.date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                LocalDate date2 = LocalDate.parse(o2.date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                return date1.compareTo(date2) * -1;
            }
        });
        return list;
    }
}
