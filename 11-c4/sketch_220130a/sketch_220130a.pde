import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

Rects[][] bd;
String[][] ids = new String[6][7];
int rows = 6;
int cols = 7;

void setup() {
  size(600,500);
  bd = new Rects[6][7];
  for(int i = 0; i < bd.length; i++) {
    for(int j = 0; j < bd[i].length; j++) {
      bd[i][j] = new Rects(i*50,j*50,50,50);
      ids[i][j] = "[ ]";
    }
  }
  println(Arrays.deepToString(bd));
  println(Arrays.deepToString(ids));
  //noLoop(); //no loop will cause inputting to break
}
String checkCol = "";
int currentRound = 1;
void keyPressed() {
  println(keyCode);
  if(keyCode != 10) {
    Pattern pattern = Pattern.compile("[1-9]", Pattern.CASE_INSENSITIVE);
    Matcher match = pattern.matcher(Character.toString(key));
    boolean isMatch = match.find();
    if(isMatch) {
      checkCol = Character.toString(key);
    }
  } else {
    currentRound++;
    checkCol = "";
  }
}
void draw() {
  background(0);

  fill(255);
  stroke(255);
  pushMatrix();
  translate(50,40);
  if(currentRound % 2 != 0) {
    text("player1 input col: ", 0, 0);
    if(!checkCol.equals("")) {
      text(checkCol, 110, 0);
    }
  } else if(currentRound % 2 == 0) {
    text("player2 input col: ", 50, 40);
    if(!checkCol.equals("")) {
      text(checkCol, 160, 40);
    }
  }
  popMatrix();
  pushMatrix();
  boolean win = false;
  translate(width/2+100,height/2+100);
  rotate(PI);
  for(int i = 0; i < rows; i++) {
    for(int j = 0; j < cols; j++) {
      bd[i][j].display();
    }
  }
  popMatrix();
}
