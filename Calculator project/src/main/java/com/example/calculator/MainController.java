package com.example.calculator;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import matrix.Matrix;

public class MainController {
    @FXML
    private GridPane mainGrid;
    @FXML
    private TextArea ResultText;

    private GridPane leftMatrix;
    private GridPane rightMatrix;

    private int leftHeight = 1;
    private int rightHeight = 1;

    public int getRows(GridPane gridPane, int size) {
        int ret = 0;
        for (int i = 0; i < size; i++) {
            if (!(((TextField) getNodeByRowColumnIndex(i, 0, gridPane)).getText().equals("")))
                ret++;
        }
        return ret;
    }

    public int getCols(GridPane gridPane, int size) {
        int ret = 0;
        for (int i = 0; i < size; i++) {
            if (!(((TextField) getNodeByRowColumnIndex(0, i, gridPane)).getText().equals("")))
                ret++;
        }
        return ret;
    }

    void getMatrixGrid(GridPane gridPane, int rows, int cols, int[][] arr) {
        try {
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = Integer.parseInt(((TextField) getNodeByRowColumnIndex(i, j, gridPane)).getText());
                }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Matrix format error. All text must be integer.");
            alert.show();
        }
    }

    public void plus() {
        int leftRows = getRows(getLeftMatrix(), leftHeight);
        int leftCols = getCols(getLeftMatrix(), leftHeight);

        int rightRows = getRows(getRightMatrix(), rightHeight);
        int rightCols = getCols(getRightMatrix(), rightHeight);

        int[][] EXTleft = new int[leftRows][leftCols];
        int[][] EXTright = new int[rightRows][rightCols];

        getMatrixGrid(getLeftMatrix(), leftRows, leftCols, EXTleft);
        getMatrixGrid(getRightMatrix(), rightRows, rightCols, EXTright);

        try {
            if (leftCols == 0 || rightCols == 0) {

                throw new IllegalArgumentException("No input");
            }
            Matrix op = new Matrix(EXTleft, EXTright);
            getResultText().setText(Matrix.toText(op.getTotalMatrix()));

        } catch (IllegalArgumentException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Matrix format incorrect");
            alert.setContentText("Matrix's size not equal, can't add matrices");
            alert.show();
        }

    }

    public void minus() {
        int leftRows = getRows(getLeftMatrix(), leftHeight);
        int leftCols = getCols(getLeftMatrix(), leftHeight);

        int rightRows = getRows(getRightMatrix(), rightHeight);
        int rightCols = getCols(getRightMatrix(), rightHeight);

        int[][] EXTleft = new int[leftRows][leftCols];
        int[][] EXTright = new int[rightRows][rightCols];

        getMatrixGrid(getLeftMatrix(), leftRows, leftCols, EXTleft);
        getMatrixGrid(getRightMatrix(), rightRows, rightCols, EXTright);

        try {
            if (leftCols == 0 || rightCols == 0) {
                throw new IllegalArgumentException("No input");
            }
            Matrix op = new Matrix(EXTleft, EXTright);
            getResultText().setText(Matrix.toText(op.getDiffMatrix()));

        } catch (IllegalArgumentException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Matrix format incorrect");
            alert.setContentText("Matrix's size not equal, can't subtract matrices");
            alert.show();
        }
    }

    public void multiply() {
        int leftRows = getRows(getLeftMatrix(), leftHeight);
        int leftCols = getCols(getLeftMatrix(), leftHeight);

        int rightRows = getRows(getRightMatrix(), rightHeight);
        int rightCols = getCols(getRightMatrix(), rightHeight);

        int[][] EXTleft = new int[leftRows][leftCols];
        int[][] EXTright = new int[rightRows][rightCols];

        getMatrixGrid(getLeftMatrix(), leftRows, leftCols, EXTleft);
        getMatrixGrid(getRightMatrix(), rightRows, rightCols, EXTright);

        try {
            if (leftCols == 0 || rightCols == 0) {
                throw new IllegalArgumentException("No input");
            }
            Matrix op = new Matrix(EXTleft, EXTright);
            getResultText().setText(Matrix.toText(op.getProductMatrix()));

        } catch (IllegalArgumentException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Matrix format incorrect");
            alert.setContentText(
                    "Matrix's sizes are not valid, can't add matrices\nHint: First matrix's columns must equal to second matrix's rows");
            alert.show();
        }
    }

    public void addRightMatrix() {
        getMainGrid().getChildren().remove(getRightMatrix());
        if (getRightHeight() < 8)
            setRightHeight(getRightHeight() + 1);
        addMatrixPane(true, getRightHeight());
    }

    public void addLeftMatrix() {
        getMainGrid().getChildren().remove(getLeftMatrix());
        if (getLeftHeight() < 8)
            setLeftHeight(getLeftHeight() + 1);
        addMatrixPane(false, getLeftHeight());
    }

    public void minusRightMatrix() {
        getMainGrid().getChildren().remove(getRightMatrix());
        if (getRightHeight() > 1)
            setRightHeight(getRightHeight() - 1);
        addMatrixPane(true, getRightHeight());
    }

    public void minusLeftMatrix() {
        getMainGrid().getChildren().remove(getLeftMatrix());
        if (getLeftHeight() > 1)
            setLeftHeight(getLeftHeight() - 1);
        addMatrixPane(false, getLeftHeight());
    }

    public void addMatrixPane(boolean pos, int size) {
        if (pos) {
            setRightMatrix(matrixPane(size));
            getMainGrid().add(getRightMatrix(), 2, 0);
        } else {
            setLeftMatrix(matrixPane(size));
            getMainGrid().add(getLeftMatrix(), 0, 0);
        }
    }

    public GridPane matrixPane(int size) {
        GridPane matrixPane = new GridPane();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                TextField textField = new TextField("");
                textField.setAlignment(Pos.CENTER);
                textField.setPrefSize(500, 500);
                textField.setFont(new Font("Verdana", 20));

                matrixPane.add(textField, i, j);
            }
        return matrixPane;
    }

    public Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

    public int getLeftHeight() {
        return leftHeight;
    }

    public void setLeftHeight(int leftHeight) {
        this.leftHeight = leftHeight;
    }

    public int getRightHeight() {
        return rightHeight;
    }

    public void setRightHeight(int rightHeight) {
        this.rightHeight = rightHeight;
    }

    public GridPane getMainGrid() {
        return mainGrid;
    }

    public TextArea getResultText() {
        return ResultText;
    }

    public GridPane getLeftMatrix() {
        return leftMatrix;
    }

    public void setLeftMatrix(GridPane leftMatrix) {
        this.leftMatrix = leftMatrix;
    }

    public GridPane getRightMatrix() {
        return rightMatrix;
    }

    public void setRightMatrix(GridPane rightMatrix) {
        this.rightMatrix = rightMatrix;
    }
}
