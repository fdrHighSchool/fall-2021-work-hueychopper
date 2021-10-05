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
}
void planetOrbits(float radiusX, float radiusY) {
   theta += 0.01;
   posX = radiusX * cos(theta);
   posY = radiusY * sin(theta);
}

void mercury() {
   translate(width/2, height/2);
   planetOrbits(150,150);
   fill(255);
   ellipse(posX, posY, 30, 30);
}
