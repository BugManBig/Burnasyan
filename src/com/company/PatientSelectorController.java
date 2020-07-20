package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PatientSelectorController {
    private PatientSelectorView patientSelectorView;
    private Model model = ModelSingleton.getModel();
    private AddController addController;
    private List<Person> foundedList;

    public void setAddController(AddController addController) {
        this.addController = addController;
    }

    public void setPatientSelectorView(PatientSelectorView patientSelectorView) {
        this.patientSelectorView = patientSelectorView;
    }

    public void start() {
        patientSelectorView.create();
        model.readPatients();
        handleButtonRelease();
    }

    public void handleCreateButtonClick() {
        List<String> strings = new ArrayList<>();
        strings.add(patientSelectorView.getSurname());
        strings.add(patientSelectorView.getName());
        strings.add(patientSelectorView.getPatronymic());
        strings.add(patientSelectorView.getBirthday());
        strings.add(patientSelectorView.getSex().toString());
        try {
            Files.write(new File("D:\\Soft\\IdeaTest\\Burnasyan\\Patients\\" + model.getNextPatientId() + ".txt").toPath(), strings, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.readPatients();
        addController.setPatient(model.getNextPatientId() - 1);
        patientSelectorView.close();
    }

    public void handleButtonRelease() {
        foundedList = model.getFilteredPatients(
                patientSelectorView.getName(),
                patientSelectorView.getSurname(),
                patientSelectorView.getPatronymic(),
                patientSelectorView.getBirthday());
        String[][] data = new String[foundedList.size()][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = foundedList.get(i).getFio();
            data[i][1] = foundedList.get(i).getBirthdayString();
        }
        patientSelectorView.setTable(data);
        patientSelectorView.setSex(model.getPatientSex(patientSelectorView.getName()));
    }

    public void handleSelectButtonClick() {
        addController.setPatient(foundedList.get(patientSelectorView.getSelectedIndex()).getId());
        patientSelectorView.close();
    }
}
