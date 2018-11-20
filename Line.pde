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
  void render() {
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
