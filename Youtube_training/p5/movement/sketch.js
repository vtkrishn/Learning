var x = 35;
var y = 200;
var xMax = false;
var yMax = false;
function setup() {
    createCanvas(600,400);
}

function draw() {
    background(0);
    fill(255,255,255);
    
    if(xMax == false){
        ellipse(x++,y,64,64); 
        if(x > 570){
            xMax = true;
            y = y + 10;
        }
    }
    
    if(xMax == true){
        ellipse(x--,y,64,64); 
        if(x < 35){
            xMax = false;
            y = y + 10;
        }
    }
}
