package com.company;

import java.util.List;

public class TotalController {
    private TotalView totalView;
    private Model model = ModelSingleton.getModel();
    private String[][] data;
    private int researchId;

    public void setTotalView(TotalView totalView) {
        this.totalView = totalView;
    }

    public void start(int researchId) {
        this.researchId = researchId;
        List<String> list = Model.getFileContents(Params.get("PATH") + "/research/" + researchId + ".txt");
        data = new String[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split("=");
            data[i][0] = split[0];
            if (split.length == 2) {
                    data[i][1] = split[1];
            } else {
                data[i][1] = "";
            }
        }
        String[][] visualData = new String[data.length][2];
        for (int i = 0; i < data.length; i++) {
            visualData[i][0] = Params.types[i];
            visualData[i][1] = data[i][1];
            if (i == 0) {
                model.readDoctors();
                visualData[i][1] = model.getDoctor(Integer.parseInt(visualData[i][1])).getFio();
            } else if (i == 1) {
                model.readPatients();
                visualData[i][1] = model.getPatient(Integer.parseInt(visualData[i][1])).getFio();
            }
        }
        totalView.create(visualData);
    }

    public void handleSaveButtonClick() {
        for (int i = 2; i < data.length; i++) {
            data[i][1] = totalView.getTableValue(i);
        }
        model.updateResearch(data, researchId);
        totalView.close();
    }
}
