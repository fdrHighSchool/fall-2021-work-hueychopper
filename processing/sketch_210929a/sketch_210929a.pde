void setup() {
  size(600, 600);
  noLoop(); //using it to stop stars baouncing around
}
void draw() {
  background(0); //set bg-color to black
 
  for(int i = 0; i < 120; i++) {
    fill(255);
    ellipse(random(600), random(600), 10, 10);
  }

  fill(255, 170, 0);
  ellipse(width/2, height/2, 200, 200);
  
}
