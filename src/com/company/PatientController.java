package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PatientController {
    private PatientView patientView;

    public void setPatientView(PatientView patientView) {
        this.patientView = patientView;
    }

    public void start() {
        patientView.create();
    }

    public void handleCreateButtonClick() {
        List<String> strings = new ArrayList<>();
        strings.add(patientView.getName());
        strings.add(patientView.getSurname());
        strings.add(patientView.getPatronymic());
        try {
            Files.write(new File("D:\\Soft\\IdeaTest\\Burnasyan\\1.txt").toPath(), strings, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
