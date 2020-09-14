package com.company;

public class ElastoController {
    private ElastoView elastoView;

    public void setElastoView(ElastoView elastoView) {
        this.elastoView = elastoView;
    }

    public void start() {
        elastoView.create();
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.elastoQ3 = elastoView.getElast3();
        task.elastoQ10 = elastoView.getElast10();
        task.elastoPq = elastoView.getElastPq();
        task.elastoSQ3 = elastoView.getElastSelez();
        task.inaccuracy1 = elastoView.getInaccuracy1();
        task.inaccuracy2 = elastoView.getInaccuracy2();
        task.inaccuracy3 = elastoView.getInaccuracy3();
        task.inaccuracy4 = elastoView.getInaccuracy4();

        CommentView commentView = new CommentView();
        CommentController commentController = new CommentController();
        commentView.setCommentController(commentController);
        commentController.setCommentView(commentView);
        commentController.start();

        elastoView.close();
    }
}
