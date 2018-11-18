import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class numberLines extends PApplet {

float pad = 100.0f;
int numLines = 20;
Line[] lines = new Line[numLines];
float pHeight;

public void setup() {
  
  for (int i = 0; i < numLines; i++) {
    float h = (height - pad*2) / numLines;
    pHeight = h;
    int n = 40;
    PVector s = new PVector(0, i * h);
    PVector e = new PVector(width-2*pad, i * h);
    lines[i] = new Line(n, s, e);
  }
}

public void draw() {
  noLoop();
  noFill();
  //rect(pad, pad, width-2*pad, height-2*pad);

  translate(pad, pad + pHeight /2);


  for (Line nl : lines) {
    nl.render();
  }
  save("out/numberLines.jpg");
  exit();
}

class Line {
  PVector start;
  PVector end;
  int number;
  Line(int randNum, PVector lineStart, PVector lineEnd) {
    start = lineStart;
    end = lineEnd;
    number = randNum;
  }
  public void render() {
    beginShape();
    curveVertex(start.x, start.y);
    for (int i = 0; i < number; i++) {
      curveVertex(i * (width-2*pad)/number, start.y+random(-number/10, number/10));
    }
    curveVertex(end.x, end.y);
    endShape();
  }
}
  public void settings() {  size(800, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "numberLines" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
