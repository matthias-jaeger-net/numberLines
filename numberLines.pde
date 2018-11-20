float pad = 50.0;
int numLines = 200;

void setup() {
  size(800, 800);
}

void draw() {

    Line[] lines = new Line[numLines];

    noFill();
    background(255);
    translate(pad, pad);
    float ri = random(0.03, 0.2);
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
