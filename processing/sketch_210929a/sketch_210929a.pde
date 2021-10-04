float posX, posY, radiusX, radiusY;
float theta;
void setup() {
  size(800, 600);
  posX = posY = 0;
  radiusX = 50;
  radiusY = 100;
  theta = -10;
  //noLoop(); //using it to stop stars baouncing around
}
void draw() {
  background(0); //set bg-color to black
  //for(int i = 0; i < 120; i++) {
  //  fill(255);
  //  ellipse(random(800), random(600), 10, 10);
  //}

  fill(255, 170, 0);
  ellipse(width/2, height/2, 200, 200);
  //mercury
  mercury();
}
void mercury() {
   translate(width/2+100, height/2);
   theta += 0.01;
   posX = radiusX * cos(theta);
   posY = radiusY * sin(theta);
   fill(255);
   ellipse(posX, posY, 30, 30);
}
