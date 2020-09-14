package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class DoctorSelectorController {
    private Model model = ModelSingleton.getModel();
    private List<Person> doctors;
    private DoctorSelectorView doctorSelectorView;
    private AddController addController;

    public void setAddController(AddController addController) {
        this.addController = addController;
    }

    public void setDoctorSelectorView(DoctorSelectorView doctorSelectorView) {
        this.doctorSelectorView = doctorSelectorView;
    }

    public void update() {
        model.readDoctors();
        doctors = model.getDoctors();
        String[] data = new String[doctors.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = doctors.get(i).getFio();
        }
        doctorSelectorView.setListData(data);
    }

    public void start() {
        doctorSelectorView.create();
        update();
    }

    public void handleCreateButtonClick() {
        List<String> strings = new ArrayList<>();
        strings.add(doctorSelectorView.getSurname());
        strings.add(doctorSelectorView.getName());
        strings.add(doctorSelectorView.getPatronymic());
        try {
            Files.write(new File(Params.get("PATH") + "/Doctors/" + model.getNextDoctorId() + ".txt").toPath(), strings, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.readDoctors();
        addController.setDoctor(model.getNextDoctorId() - 1);
        doctorSelectorView.close();
    }

    public void handleSelectButtonClick() {
        addController.setDoctor(doctors.get(doctorSelectorView.getSelectedIndex()).getId());
        doctorSelectorView.close();
    }
}
