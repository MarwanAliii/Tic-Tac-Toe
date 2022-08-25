import java.util.Scanner;
public class main {
public static void gameBoard(String[] placements){
System.out.println(placements[0] + &quot;|&quot; + placements[1] + &quot;|&quot; + placements[2]);
System.out.println(&quot;_|_|_&quot;);
System.out.println(placements[3] + &quot;|&quot; + placements[4] + &quot;|&quot; + placements[5]);
System.out.println(&quot;_|_|_&quot;);
System.out.println(placements[6] + &quot;|&quot; + placements[7] + &quot;|&quot; + placements[8]);
}
public static int posCheck(int moveIndex, String[] placements){
boolean check = true;
String pos = &quot;&quot;;
while(check){
pos = String.valueOf(moveIndex);
if (pos.equals(&quot;1&quot;) || pos.equals(&quot;2&quot;)|| pos.equals(&quot;3&quot;) || pos.equals(&quot;4&quot;) ||

pos.equals(&quot;5&quot;) ||

pos.equals(&quot;6&quot;) || pos.equals(&quot;7&quot;) || pos.equals(&quot;8&quot;) ||

pos.equals(&quot;9&quot;)){

check = false;
}
else{
System.out.println(&quot;Please enter a value between 1 - 9!:&quot;);
moveIndex = askPos() + 1;
}
}
Integer pos2 = Integer.parseInt(pos);
return Integer.valueOf(pos2);
}
public static int askPos(){
//reads user&#39;s move
Scanner input = new Scanner(System.in);
System.out.println(&quot;Enter a number that corresponds to your desired placement!:

&quot;);

String Input = input.nextLine();
int userInput = Integer.parseInt(Input) - 1;
return userInput;
}
public static int ifEmpty(int moveIndex, String[] placements){
boolean check = true;
String pos = &quot;&quot;;
while(check){

pos = placements[moveIndex];
if (pos.equals(&quot;O&quot;) || pos.equals(&quot;X&quot;)){
System.out.println(&quot;Please enter your placement in an empty

box!&quot;);

moveIndex = askPos();
}
else{
check = false;
}
}
Integer pos2 = Integer.parseInt(pos);
return Integer.valueOf(pos2);
}
public static boolean ifEmpty2(int moveIndex, String[] placements){

String pos = placements[moveIndex];
if (pos.equals(&quot;O&quot;) || pos.equals(&quot;X&quot;)){
return false;
}
else{
return true;
}

}
public static void userMove(String[] placements){
//checks if inputed placements is from 1-9 and not above or below
int move = askPos();
move = posCheck(move + 1, placements) - 1;
//checks if inputed placements is in an empty box
move = ifEmpty(move, placements);
placements[move - 1] = &quot;X&quot;;
winner(placements);
compMove(move, placements);
gameBoard(placements);
}
public static void winner(String[] placements){
//determines winner
if (winnerX(placements)){
System.out.println(&quot;You Win!&quot;);
gameBoard(placements);
System.exit(1);
}
else if (winnerO(placements)){
System.out.println(&quot;You Lose!&quot;);
gameBoard(placements);

System.exit(1);
}
else if(!(winnerX(placements) || winnerO(placements))){
String num = &quot;&quot;;
int count = 0;
for(int i = 0; i &lt; placements.length; i++){
num = Integer.toString(i+1);
if(placements[i].equals(num)){
count++;
}
}
if(count==0){
System.out.println(&quot;Tie!&quot;);
gameBoard(placements);
System.exit(1);
}
}
}
public static boolean winnerX(String [] placements){
int xRow1Count = 0;
int xRow2Count = 0;
int xRow3Count = 0;
int xCol1Count = 0;
int xCol2Count = 0;
int xCol3Count = 0;
int xDiag1Count = 0;
int xDiag2Count = 0;
//This traverses the arrays first 3 elements in a row and check if they are all the

same characters

for(int i = 0; i &lt; 3; i++){
if(placements[i].equals(&quot;X&quot;)){
xRow1Count++;
}
}
//This traverses the arrays second 3 elements in a row and check if they are all the

same characters

for(int i = 3; i &lt; 6; i++){
if(placements[i].equals(&quot;X&quot;)){
xRow2Count++;
}
}

//This traverses the arrays third 3 elements in a row and check if they are all the

same characters

for(int i = 6; i &lt; 9; i++){
if(placements[i].equals(&quot;X&quot;)){
xRow3Count++;
}
}
//This traverses the arrays first 3 elements in a column and check if they are all the

same characters

for(int i = 0; i &lt; 7; i = i + 3){
if(placements[i].equals(&quot;X&quot;)){
xCol1Count++;
}
}
//This traverses the arrays second 3 elements in a column and check if they are all

the same characters

for(int i = 1; i &lt; 8; i = i + 3){
if(placements[i].equals(&quot;X&quot;)){
xCol2Count++;
}
}
//This traverses the arrays third 3 elements in a column and check if they are all

the same characters

for(int i = 2; i &lt; 9; i = i + 3){
if(placements[i].equals(&quot;X&quot;)){
xCol3Count++;
}
}
//This traverses the array and checks if 3 elements in a diagonal are all the same

characters

for(int i = 0; i &lt; 9; i = i + 4){
if(placements[i].equals(&quot;X&quot;)){
xDiag1Count++;
}
}
//This traverses the array and checks if 3 elements in a diagonal are all the same

characters

for(int i = 2; i &lt; 7; i = i + 2){
if(placements[i].equals(&quot;X&quot;)){
xDiag2Count++;
}

}
//checks if any variable reached value of three and if anyone won!
if((xRow1Count == 3) || (xRow2Count == 3) || (xRow3Count == 3) ||

(xCol1Count == 3) | (xCol2Count == 3) || (xCol3Count == 3)||

(xDiag1Count == 3) || (xDiag2Count == 3)){
return true;
}
return false;
}
public static boolean winnerO(String[] placements){
int oRow1Count = 0;
int oRow2Count = 0;
int oRow3Count = 0;
int oCol1Count = 0;
int oCol2Count = 0;
int oCol3Count = 0;
int oDiag1Count = 0;
int oDiag2Count = 0;
//This traverses the arrays first 3 elements in a row and check if they are all the

same characters

for(int i = 0; i &lt; 3; i++){
if(placements[i].equals(&quot;O&quot;)){
oRow1Count++;
}
}
//This traverses the arrays second 3 elements in a row and check if they are all the

same characters

for(int i = 3; i &lt; 6; i++){
if(placements[i].equals(&quot;O&quot;)){
oRow2Count++;
}
}
//This traverses the arrays third 3 elements in a row and check if they are all the

same characters

for(int i = 6; i &lt; 9; i++){
if(placements[i].equals(&quot;O&quot;)){
oRow3Count++;
}

}
//This traverses the arrays first 3 elements in a column and check if they are all the

same characters

for(int i = 0; i &lt; 7; i = i + 3){
if(placements[i].equals(&quot;O&quot;)){
oCol1Count++;
}
}
//This traverses the arrays second 3 elements in a column and check if they are all

the same characters

for(int i = 1; i &lt; 8; i = i + 3){
if(placements[i].equals(&quot;O&quot;)){
oCol2Count++;
}
}
//This traverses the arrays third 3 elements in a column and check if they are all

the same characters

for(int i = 2; i &lt; 9; i = i + 3){
if(placements[i].equals(&quot;O&quot;)){
oCol3Count++;
}
}
//This traverses the array and checks if 3 elements in a diagonal are all the same

characters

for(int i = 0; i &lt; 9; i = i + 4){
if(placements[i].equals(&quot;O&quot;)){
oDiag1Count++;
}
}
//This traverses the array and checks if 3 elements in a diagonal are all the same

characters

for(int i = 2; i &lt; 7; i = i + 2){
if(placements[i].equals(&quot;O&quot;)){
oDiag2Count++;
}
}
if ((oRow1Count == 3) || (oRow2Count == 3) || (oRow3Count == 3) ||

(oCol1Count == 3) | (oCol2Count == 3) || (oCol3Count == 3)||

(oDiag1Count == 3) || (oDiag2Count == 3)){
//O wins

return true;
}
return false;
}
public static void compMove(int userLastMove, String[] placements){
//int to check if its first round
int rndMove = 0;
//tries to make winning move by completing a row
for(int i = 0; i &lt; 7; i = i + 3){
if (placements[i].equals(&quot;O&quot;) &amp;&amp; placements[i + 2].equals(&quot;O&quot;) &amp;&amp;

!(placements[(i + (i + 2) / 2)].equals(&quot;X&quot;))){

if(ifEmpty2((i + (i + 2) / 2), placements)){
placements[(i + (i + 2) / 2)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}
//tries to make winning move by completing a row
for(int i = 1; i &lt; 8; i = i + 3){
if (placements[i].equals(&quot;O&quot;) &amp;&amp; placements[i + 1].equals(&quot;O&quot;)&amp;&amp;

!(placements[i-1].equals(&quot;X&quot;))){

if(ifEmpty2((i - 1), placements)){
placements[i -1] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}
//tries to make winning move by completing a row
for(int i = 0; i &lt; 7; i = i + 3){
if (placements[i].equals(&quot;O&quot;) &amp;&amp; placements[i + 1].equals(&quot;O&quot;)&amp;&amp;

!(placements[(i +2)].equals(&quot;X&quot;))){

if(ifEmpty2((i + 2), placements)){
placements[(i + 2)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}

}
//tries to make winning move by completing a Column
for(int i = 0; i &lt; 3; i++){
if (placements[i].equals(&quot;O&quot;) &amp;&amp; placements[i + 6].equals(&quot;O&quot;) &amp;&amp;

!(placements[(i + (i + 6))/2].equals(&quot;X&quot;))){

if(ifEmpty2((i + (i + 6) / 2), placements)){
placements[(i + (i + 6) / 2)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}
//tries to make winning move by completing a Column
for(int i = 0; i &lt; 3; i++){
if (placements[i].equals(&quot;O&quot;) &amp;&amp; placements[i + 3].equals(&quot;O&quot;) &amp;&amp;

!(placements[i + 6].equals(&quot;X&quot;)) ){

if(ifEmpty2((i + 6), placements)){
placements[(i + 6)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}
//tries to make winning move by completing a Column
for(int i = 3; i &lt; 6; i++){
if (placements[i].equals(&quot;O&quot;) &amp;&amp; placements[i + 3].equals(&quot;O&quot;) &amp;&amp;

!(placements[i - 3].equals(&quot;X&quot;)) ){

if(ifEmpty2((i - 3), placements)){
placements[(i - 3)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}
//tries to make winning move by completing a diagonal
if(placements[0].equals(&quot;O&quot;) &amp;&amp; placements[4].equals(&quot;O&quot;) &amp;&amp;

!(placements[8].equals(&quot;X&quot;))){

if(ifEmpty2(8, placements)){
placements[8] = &quot;O&quot;;

winner(placements);
rndMove++;
return;
}
}
//tries to make winning move by completing a diagonal
if(placements[0].equals(&quot;O&quot;) &amp;&amp; placements[8].equals(&quot;O&quot;) &amp;&amp;

!(placements[4].equals(&quot;X&quot;))){

if(ifEmpty2((4), placements)){
placements[(4)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
//tries to make winning move by completing a diagonal
if(placements[4].equals(&quot;O&quot;) &amp;&amp; placements[8].equals(&quot;O&quot;)&amp;&amp;

!(placements[0].equals(&quot;X&quot;))){

if(ifEmpty2(0, placements)){
placements[0] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
//tries to make winning move by completing a diagonal
if(placements[2].equals(&quot;O&quot;) &amp;&amp; placements[4].equals(&quot;O&quot;)&amp;&amp;

!(placements[6].equals(&quot;X&quot;))){

if(ifEmpty2(6, placements)){
placements[6] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
//tries to make winning move by completing a diagonal
if(placements[2].equals(&quot;O&quot;) &amp;&amp; placements[6].equals(&quot;O&quot;)&amp;&amp;

!(placements[4].equals(&quot;X&quot;))){

if(ifEmpty2(4, placements)){
placements[4] = &quot;O&quot;;
winner(placements);
rndMove++;

return;
}
}
//tries to make winning move by completing a diagonal
if(placements[6].equals(&quot;O&quot;) &amp;&amp; placements[4].equals(&quot;O&quot;)&amp;&amp;

!(placements[2].equals(&quot;X&quot;))){

if(ifEmpty2(2, placements)){
placements[2] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
//BLOCKS PLAYER MOVES
//BLOCKS PLAYER MOVES
//BLOCKS PLAYER MOVES
//blocks user from making winning move by completing a row
for(int i = 0; i &lt; 7; i = i + 3){
if (placements[i].equals(&quot;X&quot;) &amp;&amp; placements[i + 2].equals(&quot;X&quot;)){
if(ifEmpty2((i + (i + 2) / 2), placements)){
placements[(i + (i + 2) / 2)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}
//blocks user from making winning move by completing a row
for(int i = 1; i &lt; 8; i = i + 3){
if (placements[i].equals(&quot;X&quot;) &amp;&amp; placements[i + 1].equals(&quot;X&quot;)){
if(ifEmpty2((i - 1), placements)){
placements[(i - 1)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}

//blocks user from making winning move by completing a row
for(int i = 0; i &lt; 7; i = i + 3){

if (placements[i].equals(&quot;X&quot;) &amp;&amp; placements[i + 1].equals(&quot;X&quot;) ){
if(ifEmpty2((i + 2), placements)){
placements[(i + 2)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}
//blocks user from making winning move by completing a column
for(int i = 0; i &lt; 3; i++){
if (placements[i].equals(&quot;X&quot;) &amp;&amp; placements[i + 6].equals(&quot;X&quot;)){
if(ifEmpty2((i + (i + 6) / 2), placements)){
placements[(i + (i + 6) / 2)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}
//blocks user from making winning move by completing a column
for(int i = 0; i &lt; 3; i++){
if (placements[i].equals(&quot;X&quot;) &amp;&amp; placements[i + 3].equals(&quot;X&quot;)){
if(ifEmpty2((i + 6), placements)){
placements[(i + 6)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}
//blocks user from making winning move by completing a column
for(int i = 3; i &lt; 6; i++){
if (placements[i].equals(&quot;X&quot;) &amp;&amp; placements[i + 3].equals(&quot;X&quot;)){
if(ifEmpty2((i - 3), placements)){
placements[(i - 3)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
}

//blocks user from making winning move by completing a diagonal
if(placements[0].equals(&quot;X&quot;) &amp;&amp; placements[4].equals(&quot;X&quot;) ){
if(ifEmpty2((8), placements)){
placements[(8)] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
//blocks user from making winning move by completing a diagonal
if(placements[0].equals(&quot;X&quot;) &amp;&amp; placements[8].equals(&quot;X&quot;)){
if(ifEmpty2(4, placements)){
placements[4] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
//blocks user from making winning move by completing a diagonal
if(placements[4].equals(&quot;X&quot;) &amp;&amp; placements[8].equals(&quot;X&quot;)){
if(ifEmpty2(0, placements)){
placements[0] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
//blocks user from making winning move by completing a diagonal
if(placements[2].equals(&quot;X&quot;) &amp;&amp; placements[4].equals(&quot;X&quot;)){
if(ifEmpty2(6, placements)){
placements[6] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
//blocks user from making winning move by completing a diagonal
if(placements[2].equals(&quot;X&quot;) &amp;&amp; placements[6].equals(&quot;X&quot;)){
if(ifEmpty2(4, placements)){
placements[4] = &quot;O&quot;;
winner(placements);
rndMove++;

return;
}
}
//blocks user from making winning move by completing a diagonal
if(placements[6].equals(&quot;X&quot;) &amp;&amp; placements[4].equals(&quot;X&quot;) ){
if(ifEmpty2(2, placements)){
placements[2] = &quot;O&quot;;
winner(placements);
rndMove++;
return;
}
}
// random generated placement for first move
int random = (int) (Math.random() * 8) + 1;
while(true){
if(rndMove == 0 &amp;&amp; ifEmpty2(random, placements)){
placements[random] = &quot;O&quot;;
break;
}
}
}
public static void main(String[] args) {
//array for placements of X&#39;s and O&#39;s
String [] placements = {&quot;1&quot;, &quot;2&quot;, &quot;3&quot;, &quot;4&quot;, &quot;5&quot;, &quot;6&quot;, &quot;7&quot;, &quot;8&quot;, &quot;9&quot;};
gameBoard(placements);
//while loop to check if all slots in array are filled with X&#39; and O&#39;s
while(true){
userMove(placements);
}
}
}
