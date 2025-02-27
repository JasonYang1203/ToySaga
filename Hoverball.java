import processing.core.PApplet;
import java.io.File;

/**
 * This class models a Hoverball, which inherits from Toy. Properties of the car include the x and y
 * position of the ball
 *
 */
public class Hoverball extends Toy implements Drawable, MouseListener, Movable {
  /**
   * Constructs a new Hoverball whose image filename is ToySaga.HOVERBALL_OFF located at the
   * specified (x, y) position within the display window
   *
   * @param x x-position of this Hoverball
   * @param y y-position of this Hoverball
   */
  public Hoverball(int x, int y) {
    super(ToySaga.HOVERBALL_OFF, x, y);// call the super to construct

  }

  /**
   * Sets the image of this Hoverball to ToySaga.HOVERBALL_ON if the toySaga mode is NIGHT_MODE and
   * to ToSaga.HOVERBALL_OFF, otherwise.
   *
   */
  private void switchOnOff() {

    if (toySaga.getMode().equals(toySaga.NIGHT_MODE)) {// if the mode is night mode
      setImage(ToySaga.HOVERBALL_ON);// set to on
    } else {// if mode is day mode
      setImage(ToySaga.HOVERBALL_OFF);// set to off

    }


  }

  /**
   * This method first sets the image of this Hoverball to ToySaga.HOVERBALL_ON if the toySaga mode
   * is NIGHT_MODE and to ToSaga. HOVERBALL_OFF, otherwise. Then, it draws this Hoverball by calling
   * the draw() method defined in its super class.
   */
  @Override
  public void draw() {
    switchOnOff();// call the switchOnoff

    super.draw();// call the super

  }

  /**
   * If the toySaga mode is night mode, this method bounces this Hoverball vertically by moving it
   * with dx equals to zero and dy equals to a factor of 6 * PApplet.sin(toySaga.frameCount * 0.1f)
   * use Math.round to cast the float to an int If the toySaga mode is day mode, this method moves
   * this Hoverball as an ordinary Toy by calling the move() method defined in its super class.
   *
   */
  @Override
  public void move() {
    if (toySaga.getMode().equals(this.toySaga.NIGHT_MODE)) {// if is night mode
      int dy = Math.round(6 * PApplet.sin(toySaga.frameCount * 0.1f));// get the dy
      int newy = y + dy;// get the potential newy
      if (0 <= newy && newy <= toySaga.height) {// if newy value not out of bound
        y = newy;// update
      }



    } else {// if is day-mode
      super.move();// call the super class

    }

  }



}