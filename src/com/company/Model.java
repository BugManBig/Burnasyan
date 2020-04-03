package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Person> patients;
    private List<Person> doctors;
    private int nextPatientId;
    private int nextDoctorId;

    public List<Person> getDoctors() {
        return doctors;
    }

    public int getNextPatientId() {
        return nextPatientId;
    }

    public int getNextDoctorId() {
        return nextDoctorId;
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
        File file = new File("D:\\Soft\\IdeaTest\\Burnasyan\\Patients");
        File[] files = file.listFiles();
        patients = new ArrayList<>();
        nextPatientId = 0;
        for (int i = 0; i < files.length; i++) {
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
        File file = new File("D:\\Soft\\IdeaTest\\Burnasyan\\Doctors");
        File[] files = file.listFiles();
        doctors = new ArrayList<>();
        nextDoctorId = 0;
        for (int i = 0; i < files.length; i++) {
            doctors.add(getPersonFromFile(files[i]));
            String name = files[i].getName();
            int currentId = Integer.parseInt(name.substring(0, name.indexOf(".")));
            if (currentId > nextDoctorId) {
                nextDoctorId = currentId;
            }
        }
        nextDoctorId++;
    }

    public List<Person> getFilteredPatients(String name, String surname, String patronymic, String birthday) {
        name = name.toLowerCase();
        surname = surname.toLowerCase();
        patronymic = patronymic.toLowerCase();
        List<Person> filteredList = new ArrayList<>();
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getSurname().toLowerCase().startsWith(surname)
                    && patients.get(i).getName().toLowerCase().startsWith(name)
                    && patients.get(i).getPatronymic().toLowerCase().startsWith(patronymic)
                    && patients.get(i).getBirthdayString().startsWith(birthday)) {
                filteredList.add(patients.get(i));
            }
        }
        return filteredList;
    }

    private Person getPersonFromFile(File file) {
        List<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines.size() < 4) {
            lines.add("01.01.1970");
        }
        String fileName = file.getName();
        int id = Integer.parseInt(fileName.substring(0, fileName.lastIndexOf(".")));
        return new Person(id, lines.get(0), lines.get(1), lines.get(2), lines.get(3));
    }
}
