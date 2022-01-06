import java.util.*;
ArrayList<Light> tl;
void setup() {
  size(600, 800);
  background(0);
  noLoop();
  tl = new ArrayList<Light>();
  for(int i = 0; i < 2; i++) {
    tl.add(new Light(0,0));
  }
}

void draw() {
  background(0);
  for(Light c : tl) {
    c.display(width, height);
  }
  noStroke();
  fill(68,117,0);
  triangle(420,230,300,50,180, 230);
  triangle(300, 180, 460, 390, 140, 390);
  triangle(300, 300, 520, 600, 80, 600);
  
  fill(102, 51, 0);
  rect(270, 600, 60, 200);
  
  fill(68,117,0);
  stroke(234, 221, 202);
  strokeWeight(60);
  arc(300, 450, 540, 440, QUARTER_PI, PI-QUARTER_PI);
  strokeWeight(50);
  arc(300, 290, 400, 320, QUARTER_PI, PI-QUARTER_PI);
  strokeWeight(40);
  arc(300, 160, 280, 200, QUARTER_PI, PI-QUARTER_PI);

  noFill();
  stroke(255, 255, 0);
  strokeWeight(60);
  arc(300, 450, 460, 320, QUARTER_PI, PI-QUARTER_PI);
  strokeWeight(50);
  arc(300, 290, 330, 220, QUARTER_PI, PI-QUARTER_PI);
  strokeWeight(40);
  arc(300, 155, 220, 130, QUARTER_PI, PI-QUARTER_PI);

  stroke(102, 255, 102);
  strokeWeight(60);
  arc(300, 430, 360, 250, QUARTER_PI, PI-QUARTER_PI);
  strokeWeight(50);
  arc(300, 280, 250, 140, QUARTER_PI, PI-QUARTER_PI);
  strokeWeight(40);
  arc(300, 140, 160, 80, QUARTER_PI, PI-QUARTER_PI);

  fill(255, 255, 0);
  beginShape();
  vertex(300, 74);
  vertex(299.5, 77);
  vertex(302, 75);
  vertex(298, 75);
  vertex(301.5, 77);
  endShape(CLOSE);
}
