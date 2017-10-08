function setup() {
    createCanvas(1024,1024);
}

function draw() {
    
    //functions for different objects
//    background(0,255,0);
//    rect(100,200,75,125);
//    line(30,20,85,75);
//    ellipse(192,134,56,78);


    //fill based on the mosue movement
//    if(mouseIsPressed){
//        fill(0);
//    }
//    else{
//        fill(255);
//    }
    
    //have ellipse draw when mouse movement
    ellipse(mouseX,mouseY, 100,100);
}