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
        setResearchButtonState();
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
        setResearchButtonState();
    }

    public void handleListClick() {
        setButtonState();
    }

    public void handleResearchClick() {
        setResearchButtonState();
    }

    private void setButtonState() {
        singleSearchView.setPatientButtonEnabled(singleSearchView.getSelectedPatientIndex() != -1);
    }

    private void setResearchButtonState() {
        singleSearchView.setResearchButtonEnabled(singleSearchView.getSelectedResearchIndex() != -1);
    }

    public void handleSelectResearchButtonClick() {
        int researchId = researchList.get(singleSearchView.getSelectedResearchIndex()).id;
        List<String> list = Model.getFileContents(Params.get("PATH") + "/research/" + researchId + ".txt");
        String[][] data = new String[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split("=");
            data[i][0] = Params.types[i];
            if (split.length == 2) {
                if (i == 0) {
                    model.readDoctors();
                    data[i][1] = model.getDoctor(Integer.parseInt(split[1])).getFio();
                } else if (i == 1) {
                    model.readPatients();
                    data[i][1] = model.getPatient(Integer.parseInt(split[1])).getFio();
                } else {
                    data[i][1] = split[1];
                }
            }
        }
        new TotalView().create(data);
    }

    public void handleBackButtonClick() {
        singleSearchView.close();
    }
}
