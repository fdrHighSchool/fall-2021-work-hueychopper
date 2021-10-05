float posX, posY;
float theta;
ArrayList<Stars> stars;

void setup() {
  size(800, 600);
  posX = posY = 0;
  theta = 0;
  stars = new ArrayList<Stars>();
  for(int i = 0; i < 150; i++) {
    stars.add(new Stars(random(width), random(height)));
  }
}
void draw() {
  background(0); //set bg-color to black
  
  for(Stars i : stars) {
    i.display();
  }

  fill(255, 170, 0);
  ellipse(width/2, height/2, 200, 200);
  mercury();
  venus();
  //earth();
  //mars();
}
void planetOrbits(float radiusX, float radiusY) {
   //translate(width/2, height/2);
   posX = radiusX * cos(theta);
   posY = radiusY * sin(theta);
   theta = theta + 1;
}

void mercury() {
   translate(width/2, height/2);
   planetOrbits(150,150);
   fill(255);
   ellipse(posX, posY, 30, 30);
}
void venus() {
  //translate(120, 120);
  planetOrbits(220, 220);
  fill(180, 40, 10);
  ellipse(posX, posY, 40, 40);
}
//void earth() {
//  planetOrbits(4, 300, 300);
//  fill(0, 10, 150);
//  ellipse(posX, posY, 50, 50);
//}
//void mars() {
//  planetOrbits(5, 380, 380);
//  fill(150, 5, 5);
//  ellipse(posX, posY, 45, 45);
//}
