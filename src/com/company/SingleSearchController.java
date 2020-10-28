package com.company;

import java.util.List;

public class SingleSearchController {
    private SingleSearchView singleSearchView;
    private List<Person> foundedList;
    private Model model = ModelSingleton.getModel();
    private List<PairIdDate> researchList;

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
        singleSearchView.setPatientsTable(data);
        setButtonState();
    }

    public void handleSelectPatientButtonClick() {
        int patientId = foundedList.get(singleSearchView.getSelectedPatientIndex()).getId();
        researchList = model.getResearchList(patientId);
        String[] data = new String[researchList.size()];
        for (int i = 0; i < researchList.size(); i++) {
            data[i] = researchList.get(i).date;
        }
        singleSearchView.setResearchList(data);
    }

    public void handleListClick() {
        setButtonState();
    }

    private void setButtonState() {
        singleSearchView.setPatientButtonEnabled(singleSearchView.getSelectedPatientIndex() != -1);
    }

    public void handleSelectResearchButtonClick() {
        int researchId = researchList.get(singleSearchView.getSelectedResearchIndex()).id;
        List<String> list = Model.getFileContents(Params.get("PATH") + "/research/" + researchId + ".txt");
        new TotalView().create(list);
    }

    public void handleBackButtonClick() {
        singleSearchView.close();
    }
}
