class Rects {
  float x,y;
  float w,h;
  
  Rects(float cx, float cy, float cw, float ch) {
    x = cx;
    y = cy;
    w = cw;
    h = ch;
  }
  
  boolean checkID(String id) {
    if(id.equals("[ ]")) {
      return false;
    } else {
      return true;
    }
  }
  
  void display() {
    stroke(0);
    fill(200);
    //if(checkID("[x]") == true || checkID("[o]") == true) {
    //  mkCircle("red");
    //  rect(x,y,w,h);
    //} else {
    //  rect(x,y,w,h);
    //}
    rect(x,y,w,h);
  }
  void mkCircle(String ctype) {
    if(ctype.equals("red")) {
      fill(255,0,0);
      ellipse(x,y,50,50);
    } else {
      fill(200,200,0);
      ellipse(x,y,50,50);
    }
  }
}
