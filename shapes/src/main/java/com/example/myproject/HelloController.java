package com.example.myproject;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;


import java.util.Random;

public class HelloController {

    @FXML
    private Button btn;

    @FXML
    private Canvas canv;

    private enum Shape {
        RECTANGLE, OVAL, LINE
    }
    private GraphicsContext gc;
    final int N = 10;
    private static final Shape[] shapes = Shape.values();

    @FXML
    public void initialize(){
        gc= canv.getGraphicsContext2D();
    }

    @FXML
    void btnPressed(ActionEvent event) {
        Random r = new Random();
        double WidthSize = canv.getWidth()/4;
        double HeightSize = canv.getHeight()/4;

        gc.clearRect(0,0,canv.getWidth(),canv.getHeight());

        for (int i=0; i<N; i++){
            Shape shapeType = shapes[r.nextInt(shapes.length)];
            Color randcolor = new Color(r.nextFloat(),r.nextFloat(),r.nextFloat(),r.nextFloat());
            gc.setFill(randcolor);

            switch (shapeType) {
                case LINE -> {
                    gc.setStroke(randcolor);
                    gc.strokeLine(r.nextInt(300), r.nextInt(300), r.nextInt((int) WidthSize), r.nextInt((int) HeightSize));
                }
                case RECTANGLE ->
                        gc.fillRect(r.nextInt(300), r.nextInt(300), r.nextInt((int) WidthSize), r.nextInt((int) HeightSize));
                case OVAL ->
                        gc.fillOval(r.nextInt(300), r.nextInt(300), r.nextInt((int) WidthSize), r.nextInt((int) HeightSize));
            }





        }

    }

}
