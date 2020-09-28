package com.company;

import java.util.List;

public class SingleSearchController {
    private SingleSearchView singleSearchView;
    private List<Person> foundedList;
    private Model model = ModelSingleton.getModel();

    public void setSingleSearchView(SingleSearchView singleSearchView) {
        this.singleSearchView = singleSearchView;
    }

    public void start() {
        singleSearchView.create();
        model.readPatients();
        handleButtonRelease();
    }

    public void handleButtonRelease() {
        foundedList = model.getFilteredPatients(
                singleSearchView.getName(),
                singleSearchView.getSurname(),
                singleSearchView.getPatronymic());
        String[][] data = new String[foundedList.size()][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = foundedList.get(i).getFio();
            data[i][1] = foundedList.get(i).getBirthdayString();
        }
        singleSearchView.setTable(data);
    }

    public void handleSelectButtonClick() {
        int patientId = foundedList.get(singleSearchView.getSelectedIndex()).getId();
        System.out.println(model.getResearchList(patientId));
    }
}
