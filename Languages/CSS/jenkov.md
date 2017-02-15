CSS -> for HTML

type of references
  in the <style>
          background-color : red;
         <style>  
  in the attribute style="background-color: red;"
  using the links

  Selectors
    universal selector - *
    element selectotor - div p {}
    class selector - .
    id selector  - #
    attribute selector - [href] {}
        attribute begins with [href^="http://"]
          attribute equals with [href|="png"] --> png or png-
        attribute ends with [href$="png"] {}
        attribute equals with [href="png"] {}
        attribute contains with [href*="png"] {}
        attribute contains words [href~="programmer"] {}
    Group selector - div, p, h1 {}
    child selector - li>a {} ol>li>a {}
    descendant selector - ol a {} -> all a under ol     
    adjacent sibling selector - a+p {}
    general sibling selector - p~p {}

  Psuedo classes
    a:link,a:visited, a:hover a:active
    p:first-child p:last-child p:nth-child(2n)(every 2nd element)
    p:first-of-type p:last-of-type p:nth-of-type(2n)
    last-child only-child
    div:empty p:not(first-child)
    input[type="text"]:checked input:enabled input:disabled

  Pseudo elements
      ::selection  ::first-line ::before ::after
  CSS inheritance
      if the property is on the element then all the child gets the same property applied

  CSS precedence
        put !important - for max the priority

  CSS BOX model
          margin <-->border <--> padding <--> element
  CSS margin

    margin
    margin-top
    margin-right
    margin-bottom
    margin-left

CSS padding

    padding
    padding-top
    padding-right
    padding-bottom
    padding-left

CSS border
  border

  border-width
  border-style
  border-color

  border-top
  border-right
  border-bottom
  border-left

  border style
    solid
    dotted
    dashed
    double
    groove
    ridge
    inset
    outset
    none
    hidden

border-image-source

CSS colors
#one   {  background-color: red;  }
#two   {  background-color: #ff0000;  }
#three {  background-color: rgb(255, 0, 0);  }
#four  {  background-color: rgba(255, 0, 0, 1.0);  }
#five  {  background-color: hsl(0%, 100%, 0%); }

CSS Text Styling
  fort-family
  font-size
  color
  font-style
  font-weight
  text-transform - [lowercase, uppercase,capitalize]
  text-deconration
  letter-spacing
  line-height
  text-shadow
  text-indent

Web fonts
@font-face {
font-family: 'Roboto';
font-style: normal;
font-weight: 400;
src: local('Roboto Regular'),
     local('Roboto-Regular'),
     url(http://themes.googleusercontent.com/static/fonts/roboto/v11/2UX7WLTfW3W8TclTUvlFyQ.woff)
     format('woff');

CSS 2d transformation
CSS transitions

CSS postion
 absolute
 relative
  static
  fixed

CSS display
  inline
  block
  inline-block

CSS background-color
    background-positoon
    background-image
    background-repeat  

CSS float
   float-left
    float-right

CSS Box Shadow
  box-shadow : inset  offsetX  offsetY  blurRadius spreadRadius shadowColor     

CSS FOrm
 resize-none
      
