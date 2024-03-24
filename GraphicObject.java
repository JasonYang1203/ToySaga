import processing.core.PImage;

/**
 * This class models GraphicObject objects. This is an implementation of the Drawable interface
 */
public class GraphicObject extends Object implements Drawable {
  protected processing.core.PImage image; // Processing image of this GraphicObject
  protected static ToySaga toySaga; // Reference to the ToySaga graphic application where this
  // object will be displayed.
  protected int x; // x-position of this GraphicObject object in the display window
  protected int y; // y-position of this GraphicObject object in the display window

  /**
   * Constructs a new GraphicObject object positioned at the center of the display window.
   *
   * @param filename filename of the image of this graphic object
   */
  public GraphicObject(String filename) {
    this(filename, toySaga.width / 2, toySaga.height / 2);// at the center

  }

  /**
   * Constructs a new GraphicObject object positioned at the specific x and y position within the
   * display window. The image assigned to this GraphicObject object is defined by the provided
   * filename.
   *
   * @param filename filename of the image of this graphic object
   * @param x        x-position (horizontal position) of this GraphicObject object
   * @param y        y-position (vertical position) of this GraphicObject object
   */
  public GraphicObject(String filename, int x, int y) {
    this.x = x;// set x
    this.y = y;// set y
    setImage(filename);// set image

  }

  /**
   * Mutates the image of this GraphicObject by reloading it
   *
   * @param filename filename of the image to load
   */
  public void setImage(String filename) {
    if (toySaga != null) {// if not null
      image = toySaga.loadImage(filename);// loadimage
    }

  }


  /**
   * Draws the image of this GraphicObject to the display window at its current (x,y) position
   */
  @Override
  public void draw() {
    if (toySaga != null) {// if not null
      toySaga.image(image, x, y);// set the image
    }

  }

  /**
   * Gets the x-position of this GraphicObject object
   *
   * @return the x-position of this GraphicObject object
   */
  public int getX() {
    return x;// return x


  }

  /**
   * Gets the y-position of this GraphicObject object
   *
   * @return the y-position of this GraphicObject object
   */
  public int getY() {
    return y; // return y

  }

  /**
   * Sets the ToySaga PApplet object where this graphic object will be drawn
   *
   * @param toySaga PApplet object that represents the display window of the ToySaga app
   */
  public static void setProcessing(ToySaga toySaga) {
    GraphicObject.toySaga = toySaga; // set the toysaga object to the new given toysaga

  }


}