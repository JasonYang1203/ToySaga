/**
 * This class models a Car, which inherits from Toy. Properties of the car include the moveDirection
 * (a boolean) which makes the car travel right if true and left otherwise
 */
public class Car extends Toy implements Drawable, MouseListener, Movable {
  private static int absoluteSpeed = 8; // Speed of move of cars, initially set to 8.
  private boolean isMovingRightward;// indicates whether this car is traveling rightward or leftward
  private int speed;// Speed of the horizontal movement of this car


  /**
   * Constructs a new Car object positioned at the specific x and y position within the display
   * window. The image assigned to this Car object is defined by the ToySaga.CAR filename. When
   * initially created, a car is set to be moving rightward and its speed is set to absoluteSpeed.
   *
   * @param x x-position (horizontal position) of this car
   * @param y y-position (vertical position) of this car
   */
  public Car(int x, int y) {
    super(ToySaga.CAR, x, y);// call the super class constructor
    this.speed = absoluteSpeed;
    this.isMovingRightward = true;
  }



  /**
   * If the toySaga mode is night mode, this method first moves this car, than draw it by calling
   * drawCarNightMode() helper method. Otherwise, this method draws this car as an ordinary toy if
   * the mode is day mode.
   */

  @Override
  public void draw() {
    String m = toySaga.getMode(); // get the toysage's mode
    if (m.equals(ToySaga.NIGHT_MODE)) {// if is nigh-mode
      move();// call the toy's method move()
      drawCarNightMode(); // use the helper method
    } else {// if is day-mode
      super.draw();// draw as usual toy
    }
  }

  /***
   * Provided method to draw a car at night with respect to its move direction
   */
  private void drawCarNightMode() {
    toySaga.pushMatrix();
    toySaga.rotate(0.0f);
    toySaga.translate(x, y);
    if (!isMovingRightward) {
      toySaga.scale(-1.0f, 1.0f);
    }
    toySaga.image(image, 0.0f, 0.0f);
    toySaga.popMatrix();
  }

  /**
   * Flips the Car's move direction from true to false or false to true and sets the speed of this
   * car to -speed.
   */
  public void flipMoveDirection() {
    this.isMovingRightward = !this.isMovingRightward; // Flip direction
    this.speed = -this.speed; // Reverse speed

  }

  /**
   * If the toySaga mode is day mode, this car moves as an ordinary toy (meaning call the move()
   * method defined in the super class). If the toySaga mode is night mode, this method increment
   * the car's x position by its speed. This car moves horizontally, meaning no changes will be made
   * to its y-coordinate.
   *
   * While moving rightward, if this car reaches (isOver) the right or the left border of the
   * screen, if flips move direction. Note that the right border is determined by the x-coordinate
   * to be toySaga.width. The left border of the display window is determined by the x-coordinate to
   * be 0. The vertical intersection position with either border is the y-position of this toy.
   */
  @Override
  public void move() {
    if (toySaga.getMode().equals(ToySaga.NIGHT_MODE)) {// if in night mode
      int dx = speed;
      int newx = x + dx;// new x is x+speed

      // Check boundaries according to specified conditions
      if (newx <= 0) { // Left border check
        x = 0; // Position at left border
        flipMoveDirection(); // Flip direction and reverse speed
      } else if (newx >= toySaga.width) { // Right border check
        x = toySaga.width; // Position at right border
        flipMoveDirection(); // Flip direction and reverse speed
      } else {// if not at boundary
        x = newx; // Update position of x
      }
    } else {// if day mode
      super.move(); // Day mode behavior
    }
  }

  /**
   * Gets the absolute speed of car toys
   *
   * @return the absolute speed of car toys
   */
  public static int getSpeed() {
    return absoluteSpeed; // return the absolute-speed
  }

  /**
   * Sets the absolute speed of car toys
   *
   * @param speed new absolute speed to be assigned to the class car
   */
  public static void setSpeed(int speed) {
    absoluteSpeed = speed;// update the speed
  }
}