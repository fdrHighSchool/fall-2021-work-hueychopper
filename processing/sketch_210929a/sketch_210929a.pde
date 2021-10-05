ArrayList<Stars> stars;
PlanetOrbits sun;
//ArrayList<PlanetOrbits> planets;
color fillsun = color(255, 170, 0);
void setup() {
  size(800, 600);
  
  stars = new ArrayList<Stars>();
  for(int i = 0; i < 150; i++) {
    //translate(0, 0);
    stars.add(new Stars(random(width), random(height)));
  }
  
  sun = new PlanetOrbits(200, 0, 0, fillsun, width/2, height/2);
  sun.createPlanets(8);
  
}
void draw() {
  background(0); //set bg-color to black
  translate(width/2,height/2); //messes up stars
  for(Stars i : stars) {
    i.display();
  }
  sun.display();
  sun.orbitalCalculation();
}
