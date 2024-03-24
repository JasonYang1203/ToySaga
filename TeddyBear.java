import processing.core.PApplet;

/**
 * This class models a TeddyBear, which inherits from Toy. The properties of the bear include the
 * rotation, rotationDirection, callout, and ToySaga object
 */
public class TeddyBear extends Toy implements Drawable, MouseListener, Movable {

  private Callout callout; //The callout object associated with a bear
  private float rotation;//Current rotation amount of the bear (in radians)
  private boolean rotationDirection;//The direction the bear is rotating evaluated to true if the
  // rotation direction is clockwise,
  //and false if it is counterclockwise


  /**
   * Constructs a new TeddyBear object positioned at the specific x and y position within the
   * display window. The image assigned to this TeddyBear object is defined by ToySaga.BEAR
   * filename. The instance fields rotation, rotationDirection, and callout should be initialized by
   * this constructor as follows. rotations should be set to zero rotationDirection should be set to
   * true, meaning that the teddy bear is initialized to rotate in the clockwise direction. the
   * callout of this TeddyBear should be set to a new Callout at the same input x, y position
   *
   * @param x x-position (horizontal position) of this TeddyBear
   * @param y y-position (vertical position) of this TeddyBear
   */
  public TeddyBear(int x, int y) {
    super(ToySaga.BEAR, x, y);// super class constructor
    this.rotation = 0.0f;//initialize to 0
    this.rotationDirection = true;// set the rotation true
    this.callout = new Callout(x, y);// new Callout Object

  }

  /**
   * Returns the rotation amount of the TeddyBear
   *
   * @return float The rotation amount of the TeddyBear
   */
  public float getRotation() {
    return rotation;// return rotation

  }

  /**
   * Sets the rotation amount
   *
   * @param rotation The float-valued rotation amount (in radians)
   */
  public void setRotation(float rotation) {
    this.rotation = rotation; // set the rotation

  }

  /**
   * Sets the rotation direction. The value true for rotation direction means clockwise direction.
   *
   * @param direction The rotation direction (boolean valued).
   */
  public void setRotationDirection(boolean direction) {
    this.rotationDirection = direction; //set the direction

  }

  /**
   * Returns the rotation direction
   *
   * @return boolean The rotation direction
   */
  public boolean getRotationDirection() {
    return rotationDirection;//return the rotationdirection

  }

  /**
   * Draws this teddy bear by calling the helper method drawTeddyBearNightMode() if the toySaga mode
   * is night mode. Draws this teddy bear to the display window as an ordinary toy by calling the
   * draw() method defined in its super class if the toySaga mode is day mode.
   */
  @Override
  public void draw() {
    String mode = toySaga.getMode();// the mode for toysaga
    if (mode.equals(ToySaga.NIGHT_MODE)) {// if is nightmode
      drawTeddyBearNightMode();//call the helper
    } else {// if daymode
      super.draw();// call the super method

    }


  }


  /*** Provided method to draw this talking TeddyBear at night with respect to its moves
   */
  private void drawTeddyBearNightMode() {
    move();
    toySaga.pushMatrix(); // Save the current transformation matrix
    toySaga.translate(x, y); // Translate to the teddy bear’s position
    toySaga.rotate(rotation * PApplet.PI / 2); // Apply rotation
    if (toySaga.getMode() == "NIGHT") {
      toySaga.image(callout.image, 20f, -90f);
    }
    toySaga.image(image, 0.0f, 0.0f); // Draw the image at the rotated position
    toySaga.popMatrix(); // Restore the previous transformation matrix
  }


  /**
   * If the toySaga mode is day mode, this method moves this teddy bear as an ordinary toy by
   * calling the move() method defined in its super class. If the toySaga mode is night mode, this
   * method moves this TeddyBear as follows: (1) Switch the rotation direction if necessary as
   * follows. - if the rotation is outside of the range of -30 to 30 degrees, flip the rotation
   * direction. (2) Rotate this teddy bear with with an increment of 3 degrees in the proper
   * rotation direction Use PApplet.radians(3) to get the rotation increment in radians. How to
   * switch the rotation direction: - If the current rotation is at or beyond (greater than) 30
   * degrees (PApplet.radians(30)), set the rotation direction to false, meaning that this TeddyBear
   * is going to start rotating counterclockwise. - If the current rotation is at or beyond (less
   * than) -30 degrees (PApplet.radians(-30)), set the rotation direction to true (meaning that this
   * TeddyBear is going to start rotating clockwise). How to appropriately update the teddy bear
   * rotation value with 3 degrees in the proper rotation direction: - Increment the rotation by
   * PApplet.radians(3) if the clockwise rotation direction is true. - Decrement the rotation by
   * PApplet.radians(3) if the clockwise rotation direction is false.
   */
  @Override
  public void move() {
    String m = toySaga.getMode();// the mode for toysaga
    if (m.equals(ToySaga.DAY_MODE)) {// if is daymode
      super.move();
    } else {//nightmode
      if (rotation > PApplet.radians(30)) {// if outside the range 30
        this.rotationDirection = false;//set direction to false
      } else if (rotation < PApplet.radians(-30)) {//less than-30
        this.rotationDirection = true;
        ;//set direction to true

      }

      if (rotationDirection) {//flipping direction true
        this.rotation += PApplet.radians(3);// Increment the rotation by PApplet.radians(3)
      } else {//flipping direction false
        this.rotation -= PApplet.radians(3);// decrement the rotation by PApplet.radians(3)
      }


    }


  }


}