package com.example.calculator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import matrix.Matrix;


public class MainController {
    @FXML
    private GridPane mainGrid;
    @FXML
    private Button leftMinus;
    @FXML
    private Button leftPlus;
    @FXML
    private Button rightMinus;
    @FXML
    private Button rightPlus;
    @FXML
    private TextArea ResultText;
    @FXML
    private Button plusButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button multiplyButton;

    private GridPane leftMatrix;
    private GridPane rightMatrix;


    private int leftHeight = 1;
    private int rightHeight = 1;

    public int getRows(GridPane gridPane, int size) {
        int ret = 0;
        for(int i = 0; i < size; i++)
        {
            if(!(((TextField) getNodeByRowColumnIndex(0, i, gridPane)).getText().equals("0"))
                    && !(((TextField) getNodeByRowColumnIndex(0, i, gridPane)).getText().equals("")))
                ret++;
        }
        return ret;
    }

    public int getCols(GridPane gridPane, int size) {
        int ret = 0;
        for(int i = 0; i < size; i++)
        {
            if(!(((TextField) getNodeByRowColumnIndex(i, 0, gridPane)).getText().equals("0"))
                    && !(((TextField) getNodeByRowColumnIndex(i, 0, gridPane)).getText().equals("")))
                ret++;
        }
        return ret;
    }
    
    void getMatrixGrid(GridPane gridPane, int rows, int cols, int[][] arr)
    {
        try {
            for(int i = 0; i < rows; i++)
                for(int j = 0; j < cols; j++)
                {
                    arr[i][j] = Integer.parseInt(((TextField) getNodeByRowColumnIndex(i, j, gridPane)).getText());
                }
        } catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Matrix format error. All text must be integer.");
        }
    }

    public void plus(ActionEvent e) {
        int leftRows = getRows(leftMatrix, leftHeight);
        int leftCols = getCols(leftMatrix, leftHeight);
        
        int rightRows = getRows(rightMatrix, rightHeight);
        int rightCols = getCols(rightMatrix, rightHeight);
        
        int[][] EXTleft = new int[leftRows][leftCols];
        int[][] EXTright = new int[rightRows][rightCols];
        
         getMatrixGrid(leftMatrix, leftRows, leftCols, EXTleft);
        System.out.println(Matrix.toText(EXTleft));

        
    }

    public void minus(ActionEvent e) {

    }

    public void multiply(ActionEvent e) {

    }

    public void addRightMatrix(ActionEvent e) {
        mainGrid.getChildren().remove(rightMatrix);
        if(getRightHeight() < 8) setRightHeight(getRightHeight() + 1);
        addMatrixPane(true, getRightHeight());
    }

    public void addLeftMatrix(ActionEvent e){
        mainGrid.getChildren().remove(leftMatrix);
        if(getLeftHeight() < 8) setLeftHeight(getLeftHeight() + 1);
        addMatrixPane(false, getLeftHeight());
    }

    public void minusRightMatrix(ActionEvent e) {
        mainGrid.getChildren().remove(rightMatrix);
        if(getRightHeight() > 1) setRightHeight(getRightHeight() - 1);
        addMatrixPane(true, getRightHeight());
    }

    public void minusLeftMatrix(ActionEvent e){
        mainGrid.getChildren().remove(leftMatrix);
        if(getLeftHeight() > 1)setLeftHeight(getLeftHeight() - 1);
        addMatrixPane(false, getLeftHeight());
    }

    public void addMatrixPane(boolean pos, int size)
    {
        if (pos)
        {
            rightMatrix = matrixPane(size);
            mainGrid.add(rightMatrix, 2, 0);
        }
        else
        {
            leftMatrix = matrixPane(size);
            mainGrid.add(leftMatrix, 0, 0);
        }
    }

    public GridPane matrixPane (int size)
    {
        GridPane matrixPane = new GridPane();
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
            {
                TextField textField = new TextField("0");
                textField.setAlignment(Pos.CENTER);
                textField.setPrefSize(500, 500);
                textField.setFont(new Font("Verdana", 20));

                matrixPane.add(textField, i, j);
            }
        return matrixPane;
    }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
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
}
