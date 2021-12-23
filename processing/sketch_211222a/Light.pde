 class Light {
  float x_pos;
  float y_pos;
  
  Light(float x, float y) {
    x_pos = x;
    y_pos = y;
  }
  void display(float xLim, float yLim) {
    noStroke();
    float[][] colorArr = new float[3][20];
    for(int i = 0; i < 3; i++) {
      int rand = (int)random(25,255);
      for(int j = 0; j < 20; j++) {
        colorArr[i][j] = random(rand);
        fill(colorArr[0][j], colorArr[1][j], colorArr[2][j]);
        ellipse(random(x_pos,xLim),random(y_pos,yLim), 30, 30);
      }
    }
  }
}
