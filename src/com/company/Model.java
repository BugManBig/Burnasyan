package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Patient> patients;
    private int nextId;

    public int getNextId() {
        return nextId;
    }

    public Patient getPatient(int id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                return patients.get(i);
            }
        }
        return null;
    }

    public void readPatients() {
        File file = new File("D:\\Soft\\IdeaTest\\Burnasyan\\Patients");
        File[] files = file.listFiles();
        patients = new ArrayList<>();
        nextId = 0;
        for (int i = 0; i < files.length; i++) {
            patients.add(getPatientFromFile(files[i]));
            String name = files[i].getName();
            int currentId = Integer.parseInt(name.substring(0, name.indexOf(".")));
            if (currentId > nextId) {
                nextId = currentId;
            }
        }
        nextId++;
    }

    public List<Patient> getFilteredPatients(String name, String surname, String patronymic, String birthday) {
        name = name.toLowerCase();
        surname = surname.toLowerCase();
        patronymic = patronymic.toLowerCase();
        List<Patient> filteredList = new ArrayList<>();
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

    private Patient getPatientFromFile(File file) {
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
        String fileName = file.getName();
        int id = Integer.parseInt(fileName.substring(0, fileName.lastIndexOf(".")));
        return new Patient(id, lines.get(0), lines.get(1), lines.get(2), lines.get(3));
    }
}
