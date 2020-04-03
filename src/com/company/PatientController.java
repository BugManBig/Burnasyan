package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PatientController {
    private PatientView patientView;
    private Model model = ModelSingleton.getModel();
    private AddController addController;
    private List<Person> foundedList;

    public void setAddController(AddController addController) {
        this.addController = addController;
    }

    public void setPatientView(PatientView patientView) {
        this.patientView = patientView;
    }

    public void start() {
        patientView.create();
        model.readPatients();
        handleButtonRelease();
    }

    public void handleCreateButtonClick() {
        List<String> strings = new ArrayList<>();
        strings.add(patientView.getSurname());
        strings.add(patientView.getName());
        strings.add(patientView.getPatronymic());
        strings.add(patientView.getBirthday());
        try {
            Files.write(new File("D:\\Soft\\IdeaTest\\Burnasyan\\Patients\\" + model.getNextPatientId() + ".txt").toPath(), strings, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.readPatients();
        addController.setPatient(model.getNextPatientId() - 1);
        patientView.close();
    }

    public void handleButtonRelease() {
        foundedList = model.getFilteredPatients(
                patientView.getName(),
                patientView.getSurname(),
                patientView.getPatronymic(),
                patientView.getBirthday());
        String[][] data = new String[foundedList.size()][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = foundedList.get(i).getFio();
            data[i][1] = foundedList.get(i).getBirthdayString();
        }
        patientView.setTable(data);
    }

    public void handleSelectButtonClick() {
        addController.setPatient(foundedList.get(patientView.getSelectedIndex()).getId());
        patientView.close();
    }
}
