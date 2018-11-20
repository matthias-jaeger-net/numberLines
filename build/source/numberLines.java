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

float pad = 50.0f;
int numLines = 200;

public void setup() {
  
}

public void draw() {

    Line[] lines = new Line[numLines];

    noFill();
    background(255);
    translate(pad, pad);
    float ri = random(0.03f, 0.2f);
    for (int i = 0; i < numLines; i++) {
      float h = (height - pad*2) / numLines;
      int n = 40 + i;
      PVector s = new PVector(0, i * h);
      PVector e = new PVector(width-2*pad, i * h);
      lines[i] = new Line(n, s, e, ri);
    }
    for (Line nl : lines) {
      nl.render();
    }

  if(frameCount < 10) {
    save("out/numberLines"+frameCount+".jpg");
  } else {
    exit();
  }
}
class Line {
  PVector start;
  PVector end;
  int number;
  float rinc = 0;
  Line(int randNum, PVector lineStart, PVector lineEnd, float rn) {
    start = lineStart;
    end = lineEnd;
    number = randNum;
    rinc = rn;
  }
  public void render() {
    beginShape();
    curveVertex(start.x, start.y);
    float n = 0;
    for (int i = 0; i < number; i++) {
      curveVertex(i * (width-2*pad)/number, start.y+noise(n)*pad);
      n += rinc;
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
