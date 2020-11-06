package com.company;

import javax.swing.*;

public class CommentView {
    private JFrame frame;

    private CommentController commentController;
    private JTextArea commentArea;

    public void setCommentController(CommentController commentController) {
        this.commentController = commentController;
    }

    public void create() {
        frame = Params.createFrame();

        JLabel label = new JLabel("Комментарий");
        label.setBounds(200, 20, 100, 30);
        label.setFont(Params.FONT);
        frame.add(label);

        commentArea = new JTextArea();
        commentArea.setBounds(20, 60, 500, 200);
        commentArea.setFont(Params.FONT);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        frame.add(commentArea);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> commentController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.setVisible(true);
    }

    public String getComment() {
        return commentArea.getText().replaceAll("\n", "\\$");
    }

    public void close() {
        frame.dispose();
    }
}
