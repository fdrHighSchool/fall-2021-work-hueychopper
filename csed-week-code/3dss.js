let px, py;
function setup() {
  createCanvas(800, 500, WEBGL);
}

function draw() {
  background(0);
  px = width/2;
  py = height-100;
  camera(map(mouseX,0,width,-800,500), map(mouseY,0,height,-600,100), (height/2) / tan(PI/6),0,0,0,0,1,0);
  sun();
  planetGenerator(20, 450, (frameCount * 0.1), 40, 1.0001);
  planetGenerator(60, 10, (frameCount * 0.03), 45, 8.2);
  planetGenerator(180, 10, (frameCount * 0.02), 50, 16.4);
  planetGenerator(260, 10, (frameCount * 0.012), 49, 32.8);
  planetGenerator(400, 10, (frameCount * 0.003), 90, 64);
  planetGenerator(750, 10, (frameCount * 0.0013), 80, 128);
}
function sun() {
  translate(0,0);
  rotateY(frameCount * 0.0000001);
  sphere(80);
}
function planetGenerator(rotation, dy, velocity, size, dx) {
  push();
  var c = Math.cos(rotation) * (-dy);
  var s = Math.sin(rotation) * (-dy);
  rotateY(velocity);
  px = px + c*(dx);
  py = py + s;
  dx = 0;
  translate(px, py);
  sphere(size);
  pop();
}