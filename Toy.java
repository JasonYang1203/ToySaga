/**
 * This class models Toy objects in the p05 Toy Saga II program
 */
public class Toy extends GraphicObject implements MouseListener, Movable {
  private boolean isDragging; // indicates whether this Toy object is being dragged or not

  /**
   * Constructs a new Toy object positioned at the center of the display window. The image assigned
   * to this Toy object is defined by the provided filename. A newly created Toy object is not being
   * dragged and have been rotated zero times.
   *
   * @param filename filename of the image of this Toy object.
   */
  public Toy(String filename) {
    super(filename);// use the super class's constructor
    isDragging = false; // initialize to false
  }

  /**
   * Constructs a new Toy object positioned at the specific x and y position within the display
   * window. The image assigned to this Toy object is defined by the provided filename. A newly
   * created Toy object is not being dragged and have been rotated zero times.
   *
   * @param filename filename filename of the image of this Toy object.
   * @param x        x-position (horizontal position) of this Toy object
   * @param y        y-position (vertical position) of this Toy object
   */
  public Toy(String filename, int x, int y) {
    super(filename, x, y);// use the super class's constructor
    isDragging = false; // initialize to false


  }

  /**
   * Draws this Toy to the display window at its current (x,y) position taking into account of its
   * moves. This method first moves this toy by calling its move() method. Then, it draws it to the
   * screen as a GraphicObject by calling the draw() method defined in the super class.
   */
  @Override
  public void draw() {
    move(); // first by calling the move() method
    super.draw(); // use the super class's draw() method

  }

  /**
   * Checks whether this Toy object is dragging
   *
   * @return true if this toy object is dragging
   */
  public boolean isDragging() {
    return isDragging; // return the isdragging

  }

  /**
   * Starts dragging this object by setting its instance field isDragging to true.
   */
  public void startDragging() {
    this.isDragging = true; // set isdragging to true

  }


  /**
   * Stops dragging this object by setting its instance field isDragging to false.
   */
  public void stopDragging() {
    this.isDragging = false; // set isgragging to false

  }

  /**
   * Moves this toy object with the specific dx, and dy moves. This toy should not get out of the
   * boundaries of the display window of the toy saga.
   *
   * @param dx horizontal move
   * @param dy vertical move
   */
  protected void move(int dx, int dy) {
    int newx = this.x + dx;// new x with the dx
    int newy = this.y + dy;// new y with the dy
    if ((0 <= newx && newx <= toySaga.width) && (0 <= newy && newy <= toySaga.height)) {// if
      // newx or newy is out of the bouth
      this.x = newx;
      this.y = newy;// update
    }

  }


  /**
   * If this toy is dragging, this method moves it following the mouse moves. The current x-position
   * of the mouse is given by toySaga.mouseX The current y-position of the mouse is given by
   * toySaga.mouseY The old x-position of the mouse (in the frame previous to the current frame) is
   * given by toySaga.pmouseX The old y-position of the mouse (in the frame previous to the current
   * frame) is given by toySaga.pmouseY
   */
  public void move() {
    if (isDragging) {// if is dragging
      int dx = toySaga.mouseX - toySaga.pmouseX;// difference of the previous mouse position and
      // now position
      int dy = toySaga.mouseY - toySaga.pmouseY;
      move(dx, dy);// call the move method

    }

  }


  /**
   * Checks whether this Toy object is over a given point: (x, y) position in the screen.
   *
   * @param x x-position within the display window
   * @param y y-position within the display window
   * @return true if this toy is over the specific (x,y) coordinates.
   */
  public boolean isOver(int x, int y) {
    int height = this.image.height;// the image height
    int width = this.image.width;// image width
    int toyx = this.x;// the toy object x position
    int toyy = this.y;// the toy object y position

    return (toyx - width / 2 <= x && x <= toyx + width / 2) && (toyy - height / 2 <= y && y <= toyy + height / 2);// return whether is over

  }


  /**
   * If no toy is dragging within the toy saga, this method begins dragging this Toy if the mouse is
   * over it and no toy is dragging in the toy saga scene
   */
  public void onClick() {
    if (!isDragging && isOver(toySaga.mouseX, toySaga.mouseY)) { // is not dragging and is mouse
      // is over the toy
      this.startDragging();// we drag

    }

  }


  /**
   * Stops dragging this Toy
   */
  public void onRelease() {
    this.stopDragging(); // stop drag

  }


  /**
   * Returns true the mouse is over the this Toy
   */
  public boolean isMouseOver() {
    return isOver(toySaga.mouseX, toySaga.mouseY); // check whether ismouseover


  }


}