/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 24.06.2026
 * @author 
 */

public abstract class Figur {
  
  // start attributes
  protected int x;
  protected int y;
  protected Farbe farbe;
  protected boolean wurdeBewegt;
  // end attributes
  
  public Figur(int x, int y, Farbe farbe) {
    this.x = x;
    this.y = y;
    this.farbe = farbe;
    this.wurdeBewegt = false;
  }

  // start methods
  public void setY(int yNeu) {
    y = yNeu;
  }

  public int getY() {
    return y;
  }

  public void setX(int xNeu) {
    x = xNeu;
  }

  public int getX() {
    return x;
  }

  public void setWurdeBewegt(boolean wurdeBewegtNeu) {
    wurdeBewegt = wurdeBewegtNeu;
  }

  // end methods
} // end of Figur
