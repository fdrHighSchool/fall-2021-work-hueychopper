class PlanetOrbits {
  float radius, theta, distance, velocity, pos_x, pos_y;
  PlanetOrbits[] planets;
  color planetColor;
  
  PlanetOrbits(float _r, float _d, float _velocity, color _fill, float X_translate, float Y_translate) {
    pos_x = X_translate;
    pos_y = Y_translate;
    radius = _r;
    theta = random(TWO_PI);
    distance = _d;
    planetColor = _fill;
    velocity = _velocity;
  }
  void createPlanets(int amnt) {
    planets = new PlanetOrbits[amnt];
    for(int i = 0; i < planets.length; i++) {
      switch(i) {
        case 0: 
          planets[0] = new PlanetOrbits(40, 150, 0.1, #747b81, distance, 0);
          break;
        case 1:
          planets[1] = new PlanetOrbits(50, 200, 0.08, #eed053, distance, 0);
          break;
        case 2:
          planets[2] = new PlanetOrbits(60, 250, 0.06, #806043, distance, 0);
          break;
         case 3:
           planets[3] = new PlanetOrbits(55, 390, 0.018, #9C2E35, distance, 0);
           break;
         case 4:
           planets[4] = new PlanetOrbits(110, 450, 0.009, #bcafb2, distance, 0);
           ellipse(0, 0, 500, 100);
           break;
         case 5: 
           planets[5] = new PlanetOrbits(100, 500, 0.0029, #fae5bf, distance, 0);
         case 6:
           planets[6] = new PlanetOrbits(90, 580, 0.0084, #4FD0E7, distance, 0);
         case 7:
           planets[7] = new PlanetOrbits(85, 650, 0.00164, #4b70dd, distance, 0);
      }
    }
  }
  void display() {
    pushMatrix();
    stroke(0);
    strokeWeight(10);
    rotate(theta);
    translate(distance, 0);
    //println(pos_x, pos_y);
    fill(planetColor);
    ellipse(0, 0,radius,radius);
    //printArray(planets);
    if(planets != null) {
      for(int i = 0; i < planets.length; i++) {
        planets[i].display();
      }
    }
    popMatrix();
  }
  
  void orbitalCalculation() {
    theta = theta + velocity;
    if(planets != null) {
      for(int i = 0; i < planets.length; i++) {
        planets[i].orbitalCalculation();
      }
    }
  }
}
