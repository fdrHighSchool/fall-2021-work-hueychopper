import java.util.regex.Matcher;
import java.util.regex.Pattern;

void setup() {
  size(500,500);
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
  
  //boolean win = false;
  fill(255);
  stroke(255);
  if(currentRound % 2 != 0) {
    text("player1 input col: ", 50, 40);
    if(!checkCol.equals("")) {
      text(checkCol, 160, 40);
    }
  } else if(currentRound % 2 == 0) {
    text("player2 input col: ", 50, 40);
    if(!checkCol.equals("")) {
      text(checkCol, 160, 40);
    }
  }
}
