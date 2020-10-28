package com.company;

public class BiohimController {
    private BiohimView biohimView;

    public void setBiohimView(BiohimView biohimView) {
        this.biohimView = biohimView;
    }

    public void start() {
        biohimView.create();
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.biohimObshij = biohimView.getObshij();
        task.biohimPryamoj = biohimView.getPryamoj();
        task.biohimAlt = biohimView.getAlt();
        task.biohimAst = biohimView.getAst();
        task.biohimGgt = biohimView.getGgt();
        task.biohimSchf = biohimView.getSchf();
        task.biohimSrb = biohimView.getSrb();

        CommentView commentView = new CommentView();
        CommentController commentController = new CommentController();
        commentView.setCommentController(commentController);
        commentController.setCommentView(commentView);
        commentController.start();

        biohimView.close();
    }
}
