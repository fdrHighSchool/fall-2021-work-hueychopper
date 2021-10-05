class Stars {
  float x, y, radius;
  
  Stars(float x_pos, float y_pos) {
    x = x_pos;
    y = y_pos;
    radius = 10;
  }
  void display() {
    noStroke();
    fill(255);
    ellipse(x, y, radius, radius);
  }
}
