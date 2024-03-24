import java.io.File;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;


/**
 * This class implements the main graphic user interface (GUI) of the p05 Toy Saga II program
 */
public class ToySaga extends PApplet { // TODO declare ToySaga to inherit from the PApplet class

  // CONSTANTS
  // PATH to the folder of all images
  private static final String IMAGES_PATH = "images" + File.separator;

  // filename of the day background image of this toy saga
  protected static final String DAY_BACKGROUND = IMAGES_PATH + "backgroundDay.png";

  // filename of the night background image of this toy saga
  protected static final String NIGHT_BACKGROUND = IMAGES_PATH + "backgroundNight.png";

  // filename of the image of the bed
  protected static final String BED = IMAGES_PATH + "bed.png";

  // filename of the image of the nightstand
  protected static final String NIGHTSTAND = IMAGES_PATH + "nightstand.png";

  // filename of the image of the rug
  protected static final String RUG = IMAGES_PATH + "rug.png";

  // filename of the image of the car
  protected static final String CAR = IMAGES_PATH + "car.png";

  // filename of the image of the teddy bear
  protected static final String BEAR = IMAGES_PATH + "teddyBear.png";

  // filename of the image of the hoverball when it is on (night mode)
  protected static final String HOVERBALL_ON = IMAGES_PATH + "hoverBallOn.png";

  // filename of the image of the hoverball when it is off (day mode)
  protected static final String HOVERBALL_OFF = IMAGES_PATH + "hoverBallOff.png";

  // day mode
  protected static final String DAY_MODE = "DAY";

  // night mode
  protected static final String NIGHT_MODE = "NIGHT";

  // Maximum number of visible toys that can be stored in the drawableObjects list.
  private static final int MAX_TOYS_COUNT = 8;

  // other fields
  private static PImage backgroundImage; // PImage object that represents the background image


  // add an instance (NOT final) field of type ArrayList named drawableObjects.
  // The drawableObjects arraylist stores elements of type Drawable (interface Drawable) ONLY.
  private ArrayList<Drawable> drawableObjects;

  // add an instance (NOT final) field of type String named mode.
  // mode represents the current mode of this ToySaga application.
  private String mode;


  /**
   * Driver method that launches the application by calling this.runApplication()
   *
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    PApplet.main("ToySaga");// starts the application
    // TODO edit this method

  }

  /**
   * Gets the current mode of this Toy Saga app. The mode might be DAY or NIGHT.
   *
   * @return the current mode of this application
   */
  public String getMode() {

    return this.mode; // default return statement
  }

  /**
   * Returns true if this ToySaga mode is NIGHT_MODE
   *
   * @return true if this ToySaga mode is NIGHT_MODE
   */
  public boolean isNightMode() {
    if (this.mode.equals(NIGHT_MODE)) {// if night_mode
      return true;
    }
    // TODO implement this method
    return false; // default return statement
  }


  /**
   * Switches the mode of this toy saga application and loads the background image of the switched
   * mode. <BR>
   * <p>
   * Meaning, sets the mode to NIGHT_MODE if it was DAY_MODE and vice versa, and updates the
   * background image accordingly.
   */
  public void switchMode() {
    if (isNightMode()) {// if is night mode
      this.mode = NIGHT_MODE;// set to night mode
      backgroundImage = loadImage(NIGHT_BACKGROUND);// update background

    } else {// daymode
      this.mode = DAY_MODE;// set to day mode
      backgroundImage = loadImage(DAY_BACKGROUND);// update background

    }


  }


  // and keyPressed() callback methods predefined in the base class PApplet
  // uncomment the below code and complete the missing implementations

  /**
   * Sets the size of the display window of this graphic application
   */
  @Override
  public void settings() {
    this.size(800, 600);
  }

  /**
   * Sets the title and defines the initial environment properties of this graphic application. <br>
   * This method initializes all the data fields defined in this class.
   */
  @Override
  public void setup() {

    // sets the title and graphic environment properties of the display window
    this.getSurface().setTitle("P5 Toy Saga v2.0");
    this.textAlign(CENTER, CENTER);// horizontal alignment: center, vertical alignment: center
    this.imageMode(CENTER);// interprets the second and third parameters of image() as the
    // image’s center point.
    this.rectMode(CORNERS); // interprets the first two parameters of rect() as the location
    // of one corner, and the third and fourth parameters as the
    // location of the opposite corner.
    this.focused = true;// sets the processing program to be focused (true), meaning that
    // it is active and will accept input from mouse or keyboard

    // set starting mode
    mode = DAY_MODE;
    // load background image of day-background
    backgroundImage = loadImage(DAY_BACKGROUND);
    // instantiate the DrawableObject to empty
    drawableObjects = new ArrayList<Drawable>();


    // within the ToySaga.setup() method
    // TODO set the Processing for the SwitchButton class to be this ToySaga object
    SwitchButton.setProcessing(this);


    // TODO set the Processing for the GraphicObject class to be this ToySaga object
    GraphicObject.setProcessing(this);

    // TODO create a new SwitchButton at position (565, 20) and add it
    drawableObjects.add(new SwitchButton(565, 20));
    // to the drawableObjects list
    // TODO create a new GraphicObject BED at position (520, 270) and add it
    // to the drawableObjects list
    drawableObjects.add(new GraphicObject(BED, 520, 270));

    // TODO create a new GraphicObject RUG at position (220, 370) and add it
    // to the drawableObjects list
    drawableObjects.add(new GraphicObject(RUG, 220, 370));
    // TODO create a new GraphicObject NIGHTSTAND at position (325, 240) and add it
    // to the drawableObjects list
    drawableObjects.add(new GraphicObject(NIGHTSTAND, 325, 240));


  }

  /**
   * This callback method continuously draws and updates the application display window. It is
   * automatically called directly after setup() and continuously executes until the program is
   * stopped.
   * <p>
   * This method first draws the background image to the center of the screen. Then, it draws every
   * object stored in the drawableObjects list
   */
  @Override
  public void draw() {
    image(backgroundImage, width / 2, height / 2);// draw background image
    for (Drawable drawable : drawableObjects) {
      drawable.draw();// draw each drawable object at the arraylist
    }

  }

  /**
   * Callback method called once after every time the mouse button is pressed.
   * <p>
   * This method calls the onClick() method on every instance of MouseListener stored in the
   * drawableObjects list
   */
  @Override
  public void mousePressed() {
    for (Drawable drawable : drawableObjects) {
      if (drawable instanceof MouseListener) { // check whether the object is instance of
        // MouseListener
        ((MouseListener) drawable).onClick(); // call the onClick() method
      }
    }
  }

  /**
   * Callback method called every time the mouse button is released.
   * <p>
   * This method calls the onRelease() method on every instance of MouseListener stored in the
   * drawableObjects list
   */
  @Override
  public void mouseReleased() {
    for (Drawable drawable : drawableObjects) {
      if (drawable instanceof MouseListener) {// check whether the element in arraylist is instance
        // of mouselistener
        ((MouseListener) drawable).onRelease(); // call the onRelease() method

      }
    }

  }

  /**
   * Callback method called once every time a key is pressed. The key that was pressed is returned
   * by the this.key() this method.<BR> The ToySaga.keyPressed() method performs the below actions
   * based on the pressed key: <BR>
   * <p>
   * - Pressing 'c' or 'C' adds a new Car object at the mouse position if the MAX TOYS COUNT is not
   * reached. <BR> - Pressing 't' or 'T' adds a new TeddyBear object at the mouse position if the
   * MAX TOYS COUNT is not reached. <BR> - Pressing 'h' or 'H' adds a new Hoverball object at the
   * mouse position if the MAX TOYS COUNT is not reached. <BR> - Pressing 'd' or 'D' sets/switches
   * the mode to DAY_MODE and loads the DAY_BACKGROUND for the background image of this application.
   * <BR> - Pressing 'n' or 'N' sets/switches the mode to NIGHT_MODE and loads the NIGHT_BACKGROUND
   * for the background image of this application. <BR>
   */
  @Override
  public void keyPressed() {
    char keypreeed = Character.toLowerCase(key);// get the key that return and convert to lower case
    if (keypreeed == 'd') {// if the key is d
      mode = this.DAY_MODE; // switch the current mode to daymode
      this.backgroundImage = loadImage(this.DAY_BACKGROUND);// load image to day-background image
    } else if (keypreeed == 'n') {// if key is n
      mode = NIGHT_MODE; // switch the current mode to nightmode
      backgroundImage = loadImage(NIGHT_BACKGROUND);// load image to night-background image


    } else if (drawableObjects.size() < MAX_TOYS_COUNT) { // if the max count have not reach

      if (keypreeed == 'c') {// if key press 'c'
        Car newcar = new Car(this.mouseX, this.mouseY);// create a new Car object at the mouse
        // position
        drawableObjects.add(newcar);// add the Car object to arraylist
      } else if (keypreeed == 't') {// if key press 't'
        TeddyBear newbear = new TeddyBear(this.mouseX, this.mouseY);// create a new TeddyBear object
        // at the mouse position
        drawableObjects.add(newbear);// add the TeddyBear object to arraylist
      } else if (keypreeed == 'h') {// if key press 'h'
        Hoverball newhover = new Hoverball(this.mouseX, this.mouseY);// create a new Hoverball
        // object at the mouse position
        drawableObjects.add(newhover);// add the Hoverball object to arraylist
      }

    }


  }


  // in the write-up for details)

  /**
   * Returns true if NO Toy object is currently dragging. We assume that there is at most one object
   * being dragged at a given time.
   *
   * @return true if no toy is being dragged, or false otherwise.
   */
  public boolean noToyIsDragging() {

    for (Drawable drawable : drawableObjects) {// for loop
      if (drawable instanceof Toy) {// if is instance of toy
        if (((Toy) drawable).isDragging()) {// start method
          return false;

        }
      }

    }
    return true;// return

  }

  /**
   * Gets the number of Toy instances present in this application
   *
   * @return the number of Toy objects stored in the drawableObjects list
   */
  public int getToyCount() {
    int count = 0;// initial to 0
    for (Drawable drawable : drawableObjects) {// iterate object
      if (drawable instanceof Toy) {// if instance of toy
        count++;// toy count plus

      }
    }
    return count;// return


  }


}