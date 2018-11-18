float pad = 100.0;
int numLines = 20;
Line[] lines = new Line[numLines];
float pHeight;

void setup() {
  size(800, 800);
  for (int i = 0; i < numLines; i++) {
    float h = (height - pad*2) / numLines;
    pHeight = h;
    int n = 40;
    PVector s = new PVector(0, i * h);
    PVector e = new PVector(width-2*pad, i * h);
    lines[i] = new Line(n, s, e);
  }
}

void draw() {
  noLoop();
  noFill();
  background(255);

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
  void render() {
    beginShape();
    curveVertex(start.x, start.y);
    for (int i = 0; i < number; i++) {
      curveVertex(i * (width-2*pad)/number, start.y+random(-number/10, number/10));
    }
    curveVertex(end.x, end.y);
    endShape();
  }
}
