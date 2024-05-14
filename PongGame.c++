#include <iostream>
#include <raylib.h>

    const int screenWidth = 1920;
    const int screenHeight = 1080;
 
          int p1_score = 0;
          int p2_score = 0;

using namespace std;

class Ball{
public:
float x,y;
int radius;
int x_speed;
int y_speed;
  
 void draw(){
    DrawCircle(x,y,radius,RED);
 }

  void update(){
   x+= x_speed;
   y+= y_speed;

   if(x>=screenWidth){
    p2_score++;
    ballagain();
   }
   
    if(x<=0){
    p1_score++;
    ballagain();
   }
   if(y>=screenHeight || y<=0){
    y_speed*= -1;
   }
 
  }
    void ballagain(){
      x = screenWidth/2;
      y= screenHeight/2;
     int choice[]={1,-1};
    x_speed*=choice[GetRandomValue(0,1)];
    y_speed*=choice[GetRandomValue(0,1)];
   }
};
class player1{
    public:
    float x,y;
    float width,height;
    int speed;
void draw(){
    DrawRectangle(x,y,width,height,RED);
}
void update(){
 if(IsKeyDown(KEY_DOWN)){
    y+= speed;
 }
 if(IsKeyDown(KEY_UP)){
    y-= speed;
 }
  if(y<=0){
     y = 0;
  }
  if(y+(height)>=GetScreenHeight()){
     y = GetScreenHeight()-(height);
  }

}
};
class player2 : public player1
{
public:
void update(int ball_y){
    if(y+height/2<=ball_y){
        y+=speed;
    }
    if(y+height/2>ball_y){
        y-=speed;
    }
  if(y<=0){
     y = 0;
  }
  if(y+(height)>=GetScreenHeight()){
     y = GetScreenHeight()-(height);
  }
}
};
Ball ball;
player1 p1;
player2 p2;
int main(){
    cout<<"Hello World"<<endl;

   InitWindow(screenWidth,screenHeight,"My pong game");
   ball.x = screenWidth/2;
   ball.y = screenHeight/2;
   ball.radius = 20;
   ball.x_speed = 15;
   ball.y_speed = 15;

   p1.x = screenWidth-10-20;
   p1.y = (screenHeight/2)-(150/2);
   p1.width = 20;
   p1.height = 150;
   p1.speed = 18;

   p2.x = 10;
   p2.y = (screenHeight/2)-(150/2);
   p2.width = 20;
   p2.height = 150;
   p2.speed = 14;


   SetTargetFPS(60);

   while(!WindowShouldClose()){


   BeginDrawing();

   ClearBackground(GRAY);


  ball.update();
  p1.update();
  p2.update(ball.y);

if(CheckCollisionCircleRec(Vector2{ball.x,ball.y},ball.radius,Rectangle{p1.x,p1.y,p1.width,p1.height})){
 ball.x_speed*= -1;
}
if(CheckCollisionCircleRec(Vector2{ball.x,ball.y},ball.radius,Rectangle{p2.x,p2.y,p2.width,p2.height})){
 ball.x_speed*= -1;
}
  DrawLine(screenWidth/2,0,screenWidth/2,screenHeight,WHITE);
  DrawText("Bakhat's Game",screenWidth/4,screenHeight/2,160,WHITE);
  DrawText(TextFormat("%i",p2_score),screenWidth/4,20,80,WHITE);
  DrawText(TextFormat("%i",p1_score),3*screenWidth/4,20,80,WHITE);
  ball.draw();
  p1.draw();
  p2.draw();

  



   EndDrawing();
}
    CloseWindow();

    return 0;
}